import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class TelaBuscaCliente extends JInternalFrame {
	private JTextField campoTextoNome;
	private JTextField campoTextoCpf;
	private String textoDigitado;


	public String getTextoDigitado() {
		return textoDigitado;
	}


	public void setTextoDigitado(String textoDigitado) {
		this.textoDigitado = textoDigitado;
	}


	public TelaBuscaCliente() {
		
		//Ação ao mover a janela, voltar aonde estava
		addComponentListener(new ComponentAdapter() {
			
			public void componentMoved(ComponentEvent e) {
				setLocation(0, 0);
			}
		});
		
		//Reduz a barra
		putClientProperty("JInternalFrame.isPalette", Boolean.TRUE); 
		
		//Tamanho da tela
		setBounds(0, 0, 547, 389);
		
		
		//Labels
		JLabel lblBuscaDeClientes = new JLabel("Busca de Clientes");
		lblBuscaDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscaDeClientes.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblBuscaPorNome = new JLabel("Busca Por Nome:");
		JLabel lblBuscaPorCpf = new JLabel("Busca Por Cpf:");
		
		
		//Espaçõs de Texto
		campoTextoNome = new JTextField();
		campoTextoNome.setColumns(10);
		
		campoTextoCpf = new JTextField();
		campoTextoCpf.setColumns(10);
		
		
		
		//Botoes
		JButton btnBuscaPorCpf = new JButton("Busca Por Cpf");
		
		btnBuscaPorCpf.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				
				textoDigitado = campoTextoCpf.getText();
			}
		});
		
		
		
		
		JButton btnBuscaPorNome = new JButton("Busca Por Nome");
		
		btnBuscaPorNome.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				
				textoDigitado = campoTextoNome.getText();
				
			}
		});
		
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				
				TelaBuscaCliente.this.dispose();
			}
		});
		
		
		
		//Alinhamento do Layout
		GroupLayout LayoutTelaBuscaCliente = new GroupLayout(getContentPane());
		LayoutTelaBuscaCliente.setHorizontalGroup(
			LayoutTelaBuscaCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(LayoutTelaBuscaCliente.createSequentialGroup()
					.addGap(31)
					.addGroup(LayoutTelaBuscaCliente.createParallelGroup(Alignment.LEADING, false)
						.addComponent(campoTextoNome, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
						.addComponent(lblBuscaPorNome)
						.addComponent(btnBuscaPorNome)
						.addComponent(lblBuscaPorCpf)
						.addComponent(campoTextoCpf)
						.addComponent(btnBuscaPorCpf))
					.addPreferredGap(ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
					.addComponent(btnFechar)
					.addGap(21))
				.addGroup(LayoutTelaBuscaCliente.createSequentialGroup()
					.addGap(192)
					.addComponent(lblBuscaDeClientes, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(196, Short.MAX_VALUE))
		);
		LayoutTelaBuscaCliente.setVerticalGroup(
			LayoutTelaBuscaCliente.createParallelGroup(Alignment.TRAILING)
				.addGroup(LayoutTelaBuscaCliente.createSequentialGroup()
					.addComponent(lblBuscaDeClientes, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(lblBuscaPorNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(campoTextoNome, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBuscaPorNome)
					.addGap(61)
					.addComponent(lblBuscaPorCpf)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(campoTextoCpf, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBuscaPorCpf)
					.addContainerGap(75, Short.MAX_VALUE))
				.addGroup(LayoutTelaBuscaCliente.createSequentialGroup()
					.addContainerGap(314, Short.MAX_VALUE)
					.addComponent(btnFechar)
					.addGap(23))
		);
		getContentPane().setLayout(LayoutTelaBuscaCliente);

	}
}
