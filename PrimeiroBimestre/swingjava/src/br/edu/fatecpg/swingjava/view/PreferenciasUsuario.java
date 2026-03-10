package br.edu.fatecpg.swingjava.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import br.edu.fatecpg.swingjava.model.Usuario;

public class PreferenciasUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> cbTema;
	private JCheckBox chkNotificacoes;
	private JSlider slVolume;
	private JButton btnSalvar;
	private JTextArea txtResultado;

	private Usuario usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreferenciasUsuario frame = new PreferenciasUsuario();
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
	public PreferenciasUsuario() {
		setTitle("Configurações de Preferências");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// --- Componentes da interface ---
		JLabel label = new JLabel("Tema:");
		label.setBounds(10, 10, 202, 45);
		contentPane.add(label);
		cbTema = new JComboBox<>(new String[] { "Claro", "Escuro" });
		cbTema.setBounds(222, 10, 202, 45);
		contentPane.add(cbTema);

		JLabel label_1 = new JLabel("Notificações:");
		label_1.setBounds(10, 65, 202, 45);
		contentPane.add(label_1);
		chkNotificacoes = new JCheckBox("Ativar notificações");
		chkNotificacoes.setBounds(222, 65, 202, 45);
		contentPane.add(chkNotificacoes);

		JLabel label_2 = new JLabel("Volume:");
		label_2.setBounds(10, 120, 202, 45);
		contentPane.add(label_2);
		slVolume = new JSlider(0, 100, 50);
		slVolume.setBounds(222, 120, 202, 45);
		slVolume.setMajorTickSpacing(25);
		slVolume.setPaintTicks(true);
		slVolume.setPaintLabels(true);
		contentPane.add(slVolume);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 175, 202, 45);
		contentPane.add(btnSalvar);

		txtResultado = new JTextArea();
		txtResultado.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(txtResultado);
		scrollPane.setBounds(222, 175, 202, 45);
		contentPane.add(scrollPane);

		// --- Eventos ---
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				salvarPreferencias();
			}
		});

		cbTema.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				atualizarTema();
			}
		});
	}

	private void atualizarTema() {
		String tema = (String) cbTema.getSelectedItem();
		if ("Escuro".equals(tema)) {
			getContentPane().setBackground(Color.DARK_GRAY);
			contentPane.setBackground(Color.DARK_GRAY);
			txtResultado.setBackground(Color.LIGHT_GRAY);
		} else {
			getContentPane().setBackground(Color.WHITE);
			contentPane.setBackground(Color.WHITE);
			txtResultado.setBackground(Color.WHITE);
		}
	}

	private void salvarPreferencias() {
		String tema = (String) cbTema.getSelectedItem();
		boolean notificacoes = chkNotificacoes.isSelected();
		int volume = slVolume.getValue();

		usuario = new Usuario(tema, notificacoes, volume);
		txtResultado.setText(usuario.getResumo());
	}
}
