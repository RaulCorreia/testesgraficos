//import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class TelaCadastroCliente extends JInternalFrame {
	private JTextField campoTextoNome;
	private JTextField campoTextoCpf;
	private JTextField campoTextoTel;
	private String nome;
	private String cpf;
	private String telefone;
	Cliente novoCliente;
	
	
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public Cliente getNovoCliente() {
		return novoCliente;
	}


	public void setNovoCliente(Cliente novoCliente) {
		this.novoCliente = novoCliente;
	}





	public TelaCadastroCliente() {
		
		//Ação ao mover a janela, voltar aonde estava
		addComponentListener(new ComponentAdapter() {
			
			public void componentMoved(ComponentEvent arg0) {
				setLocation(0, 0);
			}
		});
		
		
		//Reduz a barra
		putClientProperty("JInternalFrame.isPalette", Boolean.TRUE); 
		
		setEnabled(false);
		setBounds(0, 0, 547, 389);
		
		//Espaços de Texto
		campoTextoNome = new JTextField();
		campoTextoNome.setColumns(10);
		
		campoTextoCpf = new JTextField();
		campoTextoCpf.setColumns(10);
		
		campoTextoTel = new JTextField();
		campoTextoTel.setColumns(10);
		
		
		//Labels
		JLabel lblNome = new JLabel("Nome:");
		
		JLabel lblCpf = new JLabel("Cpf:");
		
		JLabel lblTelefone = new JLabel("Telefone:");
		
		JLabel lblExempCpf = new JLabel("Ex: 12345678912");
		
		JLabel lblExempTelefone = new JLabel("Ex: 0012345678");
		
		
		//Botoes
		JButton botaoCadastrar = new JButton("Cadastrar");
		
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				setNome(campoTextoNome.getText());
				setCpf(campoTextoCpf.getText());
				setTelefone(campoTextoTel.getText());
				
				novoCliente = new Cliente(nome, cpf, telefone);
				
				JOptionPane.showMessageDialog(null,"Cliente Cadastrado Com Sucesso!");
				
				TelaCadastroCliente.this.dispose();
				
			}
		});
		
		
		JButton botaoCancelar = new JButton("Cancelar");
		
		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				TelaCadastroCliente.this.dispose();
				
			}
		});
		
		
		
		
		//Alinhamento do Layout
		GroupLayout lLayoutTelaCadCliente = new GroupLayout(getContentPane());
		lLayoutTelaCadCliente.setHorizontalGroup(
			lLayoutTelaCadCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(lLayoutTelaCadCliente.createSequentialGroup()
					.addGap(19)
					.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.LEADING)
						.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.TRAILING)
							.addGroup(lLayoutTelaCadCliente.createSequentialGroup()
								.addComponent(lblNome)
								.addGap(18))
							.addGroup(lLayoutTelaCadCliente.createSequentialGroup()
								.addComponent(lblTelefone)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addComponent(lblCpf))
					.addGap(4)
					.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.TRAILING)
						.addComponent(campoTextoNome, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, lLayoutTelaCadCliente.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(campoTextoCpf, Alignment.LEADING)
							.addComponent(campoTextoTel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)))
					.addGap(65))
				.addGroup(lLayoutTelaCadCliente.createSequentialGroup()
					.addGap(157)
					.addComponent(lblExempTelefone)
					.addContainerGap(295, Short.MAX_VALUE))
				.addGroup(lLayoutTelaCadCliente.createSequentialGroup()
					.addGap(154)
					.addComponent(lblExempCpf)
					.addContainerGap(292, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, lLayoutTelaCadCliente.createSequentialGroup()
					.addContainerGap(161, Short.MAX_VALUE)
					.addComponent(botaoCadastrar)
					.addGap(113)
					.addComponent(botaoCancelar)
					.addGap(137))
		);
		lLayoutTelaCadCliente.setVerticalGroup(
			lLayoutTelaCadCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(lLayoutTelaCadCliente.createSequentialGroup()
					.addGap(53)
					.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextoNome, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome))
					.addGap(18)
					.addComponent(lblExempCpf)
					.addGap(3)
					.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextoCpf, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCpf))
					.addGap(19)
					.addComponent(lblExempTelefone)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextoTel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefone))
					.addGap(68)
					.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(botaoCancelar)
						.addComponent(botaoCadastrar))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		getContentPane().setLayout(lLayoutTelaCadCliente);

	}
}