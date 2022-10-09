package prova;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Prova {

	private JFrame frame;
	private JTextField txtNomeDoUsuario;
	private JTextField txtEnderecoInstalacao;
	private JTextField txtDataInstalacao;
	private JTextField txtNumeroDeTelefone;
	
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prova window = new Prova();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Prova() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtNomeDoUsuario = new JTextField();
		txtNomeDoUsuario.setBounds(10, 11, 279, 20);
		txtNomeDoUsuario.setText("Nome do usuário");
		frame.getContentPane().add(txtNomeDoUsuario);
		txtNomeDoUsuario.setColumns(10);
		
		txtEnderecoInstalacao = new JTextField();
		txtEnderecoInstalacao.setText("Endereço instalação");
		txtEnderecoInstalacao.setBounds(10, 42, 279, 20);
		frame.getContentPane().add(txtEnderecoInstalacao);
		txtEnderecoInstalacao.setColumns(10);
		
		txtDataInstalacao = new JTextField();
		txtDataInstalacao.setText("Data instalação");
		txtDataInstalacao.setBounds(10, 73, 279, 20);
		frame.getContentPane().add(txtDataInstalacao);
		txtDataInstalacao.setColumns(10);
		
		txtNumeroDeTelefone = new JTextField();
		txtNumeroDeTelefone.setText("Número de telefone");
		txtNumeroDeTelefone.setBounds(10, 104, 279, 20);
		frame.getContentPane().add(txtNumeroDeTelefone);
		txtNumeroDeTelefone.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Possui internet");
		chckbxNewCheckBox.setBounds(10, 173, 137, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JButton btnNewButton_1 = new JButton("Consultar");
		btnNewButton_1.setBounds(235, 216, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		

		
		JButton btnNewButton = new JButton("Criar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtNumeroDeTelefone.getText().length() != 10) {
					JOptionPane.showMessageDialog(null, "O número de telefone deve conter 10 caracteres.");
				} else {
					usuarios.add(new Usuario(txtNomeDoUsuario.getText(),
							txtEnderecoInstalacao.getText(),
							new Date(txtDataInstalacao.getText()),
							txtNumeroDeTelefone.getText(),
							chckbxNewCheckBox.isSelected(), 
							1,
							(String) comboBox.getSelectedItem())); // CORRIGIR: não tá pegando o valor do combobox
					
					System.out.print(usuarios.get(0).getTipoTelefone());
				}	
			}
		});
		btnNewButton.setBounds(102, 216, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Residencial", "Comercial", "Especializada"}));
		comboBox.setBounds(10, 135, 181, 22);
		frame.getContentPane().add(comboBox);		
	}
	
	private static void calculaPreco(Usuario usuario) {
		// Esse valor precisa ser um atributo da classe Usuario, mas apenas se o tipo de telefone for "Especializada".
		// Faz um if na hora da criação do usuario e se for especializada, pede o valor. Se não for, só põe o atributo como null.
		int quantidadeOcorrencias = 10;
		
		if (usuario.getTipoTelefone() == "Residencial") {
			usuario.setValorBasico(15);
		}
		if (usuario.getTipoTelefone() == "Comercial") {
			// Mesma data
			if (usuario.getDataInstalacao().compareTo(new Date("2019/01/01")) == 0) {
				usuario.setValorBasico(25);
			}
			if (usuario.getDataInstalacao().compareTo(new Date("2019/01/01")) > 0) {
				usuario.setValorBasico(37.50);
			}
		}
		if (usuario.getTipoTelefone() == "Especializada") {
			if (quantidadeOcorrencias >= 1 && quantidadeOcorrencias <= 1000) {
				usuario.setValorBasico(50);
			}
			if (quantidadeOcorrencias >= 1001 && quantidadeOcorrencias <= 5000) {
				usuario.setValorBasico(67.80);
			}
			if (quantidadeOcorrencias >= 5001 && quantidadeOcorrencias <= 10000) {
				usuario.setValorBasico(98.50);
			}
			if (quantidadeOcorrencias >= 10001 && quantidadeOcorrencias <= 50000) {
				usuario.setValorBasico(123.90);
			}
			if (quantidadeOcorrencias > 50000) {
				usuario.setValorBasico(187.82);
			}
		}
	}
	
}
