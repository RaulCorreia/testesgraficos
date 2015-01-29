import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TelaCadastroCliente extends JInternalFrame {
	private JTextField campoTextoNome;
	private JTextField campoTextoCpf;
	private JTextField campoTextoTel;
	private String nome;
	private String cpf;
	private String telefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
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
	public TelaCadastroCliente() {
		setEnabled(false);
		setBounds(100, 30, 333, 335);
		
		campoTextoNome = new JTextField();
		campoTextoNome.setColumns(10);
		
		campoTextoCpf = new JTextField();
		campoTextoCpf.setColumns(10);
		
		campoTextoTel = new JTextField();
		campoTextoTel.setColumns(10);
		
		JButton btnNewButton = new JButton("Ok");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				nome = campoTextoNome.getText();
				cpf = campoTextoCpf.getText();
				telefone = campoTextoTel.getText();
				
				Cliente novoCliente = new Cliente(nome, cpf, telefone);
				
				
			}
		});
		
		
		JLabel lblNome = new JLabel("Nome:");
		
		JLabel lblCpf = new JLabel("Cpf:");
		
		JLabel lblTelefone = new JLabel("Telefone:");
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		
		JLabel lblNewLabel = new JLabel("Ex: 12345678912");
		
		JLabel lblEx = new JLabel("Ex: 0012345678");
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(113)
					.addComponent(lblNewLabel)
					.addContainerGap(119, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNome)
								.addGap(18))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblTelefone)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addComponent(lblCpf))
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(campoTextoTel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
							.addComponent(btnNewButton_1))
						.addComponent(campoTextoNome, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
						.addComponent(campoTextoCpf, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
					.addGap(65))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(114)
					.addComponent(lblEx)
					.addContainerGap(124, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextoNome, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome))
					.addGap(18)
					.addComponent(lblNewLabel)
					.addGap(3)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextoCpf, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCpf))
					.addGap(19)
					.addComponent(lblEx)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextoTel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefone))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}