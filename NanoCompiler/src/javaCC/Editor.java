package javaCC;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultCaret;

public class Editor extends JFrame {

	private JPanel contentPane;
	private JTextField caminhoArquivo;
	private Compilador compilador = new Compilador();
	private JTextPane textAreaTokens;
	private JTextPane textAreaCodigo;
	private JTextPane console;

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

	public void limparTudo() {
		textAreaCodigo.setText("");
		textAreaTokens.setText("");
		console.setText("");
	}
	
	public void limpar() {
		console.setText("");
		textAreaTokens.setText("");
	}
	
	/**
	 * Create the frame.
	 */
	public Editor() {
		setTitle("CMM Compiler");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
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
		scrollPane_1.setBounds(420, 45, 354, 336);
		contentPane.add(scrollPane_1);
		
		JPanel panel_1 = new JPanel();
		scrollPane_1.setViewportView(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Console", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		console = new JTextPane();
		console.setFont(new Font("Monospaced", Font.PLAIN, 11));
		console.setEditable(false);
		console.setBounds(10, 22, 334, 301);
		panel_1.add(console);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(420, 392, 354, 158);
		contentPane.add(scrollPane_2);
		
		JPanel panel = new JPanel();
		scrollPane_2.setViewportView(panel);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tokens", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		textAreaTokens = new JTextPane();
		textAreaTokens.setFont(new Font("Monospaced", Font.PLAIN, 11));
		textAreaTokens.setEditable(false);
		textAreaTokens.setBounds(10, 21, 334, 304);
		panel.add(textAreaTokens);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new TitledBorder(null, "C\u00F3digo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(10, 45, 400, 505);
		contentPane.add(scrollPane);
		
		textAreaCodigo = new JTextPane();
		textAreaCodigo.setFont(new Font("Monospaced", Font.PLAIN, 11));
		scrollPane.setViewportView(textAreaCodigo);
		
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
				
				compilador.compilar(textAreaCodigo.getText());
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
	}
}
