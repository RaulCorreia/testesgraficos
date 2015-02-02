import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;


public class TelaBuscaCliente extends JInternalFrame {
	private JTextField campoTextoNome;
	private String textoDigitado;
	ArrayList< Cliente > clientes = new ArrayList< Cliente >();
	

	public String getTextoDigitado() {
		return textoDigitado;
	}


	public void setTextoDigitado(String textoDigitado) {
		this.textoDigitado = textoDigitado;
	}


	public TelaBuscaCliente() throws ParseException, NumberFormatException, IOException {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 9));
		
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
		
		
		
		//Carregando Dados dos Clientes
		File arq = new File("BancoDeClientes.txt");
		FileReader reader = new FileReader(arq);
		BufferedReader ler = new BufferedReader(reader);
		String linha = "";
		
		while ((linha = ler.readLine()) != null){
			Cliente cliente;
			
			String[] partes = linha.split("-");
			
			cliente = new Cliente(partes[0], partes[1], partes[2], partes[4]);
			cliente.setSaldo(Float.parseFloat(partes[3]));
			
			clientes.add(cliente);
			
				
		}
				
		ler.close();
		reader.close();
		
		
		
		
		
		//Labels
		JLabel lblBuscaDeClientes = new JLabel("Busca de Clientes");
		lblBuscaDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscaDeClientes.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblBuscaPorNome = new JLabel("Busca Por Nome:");
		JLabel lblBuscaPorCpf = new JLabel("Busca Por Cpf:");
		
		JLabel lblcampoObrigatorio = new JLabel("*Campo Obrigatorio");
		lblcampoObrigatorio.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblcampoObrigatorio.setVisible(false);
		
		JLabel lblcampoObrigatorio2 = new JLabel("*Campo Obrigatorio");
		lblcampoObrigatorio2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblcampoObrigatorio2.setVisible(false);
		
		
		JComboBox comboBoxOpcoes = new JComboBox();
		
		//Espaçõs de Texto
		campoTextoNome = new JTextField();
		campoTextoNome.setColumns(10);
		
		MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
		JFormattedTextField textoFormatadoCpf = new JFormattedTextField(mascaraCpf);
		
		
		
		//Botoes
		JButton btnBuscaPorCpf = new JButton("Busca Por Cpf");
		
		btnBuscaPorCpf.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				
				comboBoxOpcoes.removeAllItems();
				
				//Tratamento do que foi digitado
				String cpf = textoFormatadoCpf.getText();
				cpf = cpf.replace(".","");
				cpf = cpf.replace("-","");
				setTextoDigitado(cpf);
				
				String testeExiste = textoFormatadoCpf.getText();
				
				
				int i;
				boolean teste = false;
				
				
				
				for(i = 0; i < clientes.size(); i++){
					
					teste = getTextoDigitado().equalsIgnoreCase(clientes.get(i).getCpf());
					if( teste == true){
						
						comboBoxOpcoes.addItem(clientes.get(i).getNome() +  " - Cpf: " + clientes.get(i).getCpf() + " - Devendo: " + String.valueOf(clientes.get(i).getSaldo()) + " R$");
						
					}
					
				}
				
				
				if (testeExiste.equals("   .   .   -  ") ){
					lblcampoObrigatorio2.setVisible(true);
					JOptionPane.showMessageDialog(null,"Digite o Cpf");
				}
				
				
				
				
			}
		});
		
		
		
		
		JButton btnBuscaPorNome = new JButton("Busca Por Nome");
		
		btnBuscaPorNome.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				
				comboBoxOpcoes.removeAllItems();				
				setTextoDigitado(campoTextoNome.getText());
				int i;
				boolean teste = false;
				
				boolean testeExiste = getTextoDigitado().isEmpty();
				
				
				
				for(i = 0; i < clientes.size(); i++){
					
					teste = getTextoDigitado().equalsIgnoreCase(clientes.get(i).getNome());
					
					if( teste == true){
						
						comboBoxOpcoes.addItem(clientes.get(i).getNome() +  " - Cpf: " + clientes.get(i).getCpf() + " - Devendo: " + String.valueOf(clientes.get(i).getSaldo()) + " R$");
						
					}
					
				}
				
				
				if (testeExiste == true){
					lblcampoObrigatorio.setVisible(true);
					JOptionPane.showMessageDialog(null,"Digite o nome");
				}
				
				
				
				
				
				
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
			LayoutTelaBuscaCliente.createParallelGroup(Alignment.TRAILING)
				.addGroup(LayoutTelaBuscaCliente.createSequentialGroup()
					.addGap(192)
					.addComponent(lblBuscaDeClientes, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(196, Short.MAX_VALUE))
				.addGroup(LayoutTelaBuscaCliente.createSequentialGroup()
					.addContainerGap(446, Short.MAX_VALUE)
					.addComponent(btnFechar)
					.addGap(104))
				.addGroup(LayoutTelaBuscaCliente.createSequentialGroup()
					.addGap(31)
					.addGroup(LayoutTelaBuscaCliente.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxOpcoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBuscaPorCpf)
						.addComponent(lblBuscaPorNome)
						.addGroup(LayoutTelaBuscaCliente.createSequentialGroup()
							.addComponent(campoTextoNome, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblcampoObrigatorio))
						.addComponent(btnBuscaPorNome)
						.addGroup(LayoutTelaBuscaCliente.createSequentialGroup()
							.addGroup(LayoutTelaBuscaCliente.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textoFormatadoCpf, Alignment.LEADING)
								.addComponent(btnBuscaPorCpf, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(38)
							.addComponent(lblcampoObrigatorio2)))
					.addGap(229))
		);
		LayoutTelaBuscaCliente.setVerticalGroup(
			LayoutTelaBuscaCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(LayoutTelaBuscaCliente.createSequentialGroup()
					.addComponent(lblBuscaDeClientes, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(lblBuscaPorNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(LayoutTelaBuscaCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblcampoObrigatorio))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBuscaPorNome)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblBuscaPorCpf)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(LayoutTelaBuscaCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(textoFormatadoCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblcampoObrigatorio2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBuscaPorCpf)
					.addGap(18)
					.addComponent(comboBoxOpcoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
					.addComponent(btnFechar)
					.addGap(19))
		);
		getContentPane().setLayout(LayoutTelaBuscaCliente);

	}
}
