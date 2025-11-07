package br.edu.fatecpg.swingjava.view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import br.edu.fatecpg.swingjava.model.Cliente;

public class CadastroForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JSpinner spnIdade;
	private JRadioButton rbMasculino, rbFeminino;
	private JButton btnEnviar;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroForm frame = new CadastroForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroForm() {
		setTitle("Formulário de Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// --- Campos do formulário ---
		JLabel label = new JLabel("Nome:");
		label.setBounds(10, 10, 179, 36);
		contentPane.add(label);
		txtNome = new JTextField();
		txtNome.setBounds(194, 10, 179, 36);
		contentPane.add(txtNome);

		JLabel label_1 = new JLabel("Idade:");
		label_1.setBounds(10, 51, 179, 36);
		contentPane.add(label_1);
		spnIdade = new JSpinner(new SpinnerNumberModel(18, 0, 120, 1));
		spnIdade.setBounds(194, 51, 179, 36);
		contentPane.add(spnIdade);

		JLabel label_2 = new JLabel("Sexo:");
		label_2.setBounds(10, 92, 179, 36);
		contentPane.add(label_2);
		JPanel panelSexo = new JPanel();
		panelSexo.setBounds(194, 92, 179, 36);
		rbMasculino = new JRadioButton("Masculino");
		rbFeminino = new JRadioButton("Feminino");
		ButtonGroup grupoSexo = new ButtonGroup();
		grupoSexo.add(rbMasculino);
		grupoSexo.add(rbFeminino);
		panelSexo.add(rbMasculino);
		panelSexo.add(rbFeminino);
		contentPane.add(panelSexo);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(10, 133, 179, 36);
		lblResultado = new JLabel(" ");
		lblResultado.setBounds(194, 133, 179, 43);
		contentPane.add(btnEnviar);
		contentPane.add(lblResultado);

		// --- Evento do botão ---
		btnEnviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				enviarDados();
			}
		});
	}

	private void enviarDados() {
		String nome = txtNome.getText().trim();
		int idade = (int) spnIdade.getValue();
		String sexo = rbMasculino.isSelected() ? "Masculino"
				: rbFeminino.isSelected() ? "Feminino" : "";

		if (nome.isEmpty() || sexo.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}

		Cliente cliente = new Cliente(nome, idade, sexo);
		lblResultado.setText("<html>" + cliente.getResumo().replaceAll("\n", "<br>") + "</html>");
	}
}
