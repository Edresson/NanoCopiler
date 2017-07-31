package front;

import static front.Compilador.SUCESSO;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;
import javax.swing.UIManager;

public class Editor extends JFrame {

	private static final long serialVersionUID = 2931774801826309005L;
	private JPanel contentPane;
	private JTextField caminhoArquivo;
	private Compilador compilador = new Compilador();
	private JTextPane textAreaTokens;
	private JTextPane textAreaCodigo;
	private JTextPane console;
	private JLabel labelLinha;
	private JLabel labelColuna;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editor frame = new Editor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void limparTudo() {
		textAreaCodigo.setText("");
		textAreaTokens.setText("");
		console.setText("");
	}
	
	private void limpar() {
		console.setText("");
		textAreaTokens.setText("");
	}
	
	static int getOffsetLinha(JTextComponent comp, int offset) {
	    Document doc = comp.getDocument();
	    if (offset < 0 || offset > doc.getLength()) 
	    	return 0;

	    Element map = doc.getDefaultRootElement();
        return map.getElementIndex(offset);
	}

	static int getOffsetInicioLinha(JTextComponent comp, int linha) {
	    Element map = comp.getDocument().getDefaultRootElement();
	    if (linha < 0 || linha >= map.getElementCount()) 
	    	return 0;

	    Element elementoLinha = map.getElement(linha);
        return elementoLinha.getStartOffset();
	}
	
	/**
	 * Create the frame.
	 */
	public Editor() {
		setResizable(false);
		setTitle("CMM Compiler");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 630);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		caminhoArquivo = new JTextField();
		caminhoArquivo.setBackground(Color.WHITE);
		caminhoArquivo.setEditable(false);
		caminhoArquivo.setBounds(162, 12, 343, 22);
		contentPane.add(caminhoArquivo);
		caminhoArquivo.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new TitledBorder(null, "Console", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane_1.setBounds(420, 45, 354, 269);
		contentPane.add(scrollPane_1);
		
		console = new JTextPane();
		scrollPane_1.setViewportView(console);
		console.setFont(new Font("Monospaced", Font.PLAIN, 11));
		console.setEditable(false);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setViewportBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u00C1rvore", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(420, 325, 354, 225);
		contentPane.add(scrollPane_2);
		
		textAreaTokens = new JTextPane();
		scrollPane_2.setViewportView(textAreaTokens);
		textAreaTokens.setFont(new Font("Monospaced", Font.PLAIN, 11));
		textAreaTokens.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new TitledBorder(null, "C\u00F3digo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(10, 45, 400, 505);
		contentPane.add(scrollPane);
		
		textAreaCodigo = new JTextPane();
		textAreaCodigo.setFont(new Font("Monospaced", Font.PLAIN, 11));
		scrollPane.setViewportView(textAreaCodigo);
		textAreaCodigo.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				int dot = e.getDot();
			    int numeroLinha = getOffsetLinha(textAreaCodigo, dot);
			    int numeroColuna = dot - getOffsetInicioLinha(textAreaCodigo, numeroLinha);
				
				labelLinha.setText(Integer.toString(numeroLinha + 1));
				labelColuna.setText(Integer.toString(numeroColuna + 1));
			}
		});
		
		JButton btnAbrirArquivo = new JButton("Abrir Arquivo");
		btnAbrirArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos", "txt");
				
				fc.setFileFilter(filtro);
				int returnVal = fc.showOpenDialog(contentPane);
				
				File file = null;
		        if (returnVal != JFileChooser.APPROVE_OPTION) {
		        	return;
		        } 
		        
		        file = fc.getSelectedFile();
		        caminhoArquivo.setText(file.getPath());
		        
		        try {
					textAreaCodigo.setText(new Scanner(file).useDelimiter("\\Z").next());
				} catch (FileNotFoundException e1) {
					console.setText("Erro processar arquivo de entrada.");
				}
			}
		});
		btnAbrirArquivo.setBounds(10, 11, 142, 23);
		contentPane.add(btnAbrirArquivo);
		
		JButton btnCompilar = new JButton("Compilar");
		btnCompilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
				
				if (SUCESSO.equals(compilador.compilar(textAreaCodigo.getText()))) {
					textAreaTokens.setText(compilador.printAst());
				} 
				
				console.setText(compilador.getConsole());
			}
		});
		btnCompilar.setBounds(685, 11, 89, 23);
		contentPane.add(btnCompilar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTudo();
			}
		});
		btnLimpar.setBounds(586, 11, 89, 23);
		contentPane.add(btnLimpar);
		
		JLabel lblLinhacoluna = new JLabel("Linha/Coluna:");
		lblLinhacoluna.setBounds(618, 561, 84, 29);
		contentPane.add(lblLinhacoluna);
		
		labelLinha = new JLabel("1");
		labelLinha.setHorizontalAlignment(SwingConstants.CENTER);
		labelLinha.setBounds(700, 561, 25, 29);
		contentPane.add(labelLinha);
		
		labelColuna = new JLabel("1");
		labelColuna.setHorizontalAlignment(SwingConstants.CENTER);
		labelColuna.setBounds(749, 561, 25, 29);
		contentPane.add(labelColuna);
		
		JLabel label = new JLabel("/");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(726, 561, 25, 29);
		contentPane.add(label);
	}
}
