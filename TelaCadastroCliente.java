//import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;


public class TelaCadastroCliente extends JInternalFrame {
	private JTextField campoTextoNome;
	private Cliente novoCliente;
	private JTextField campoTextoEndereco;
	


	public Cliente getNovoCliente() {
		return novoCliente;
	}


	public void setNovoCliente(Cliente novoCliente) {
		this.novoCliente = novoCliente;
	}





	public TelaCadastroCliente() throws ParseException {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 9));
		
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
		
		campoTextoEndereco = new JTextField();
		campoTextoEndereco.setColumns(10);
		
		//Campo de Texto Formatado
		MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
		MaskFormatter mascaraTel = new MaskFormatter("(##)####-####");
		JFormattedTextField textoFormatadoCpf = new JFormattedTextField(mascaraCpf);
		JFormattedTextField textoFormatadoTel = new JFormattedTextField(mascaraTel);
	
					
		
		
		
		
		//Labels
		JLabel lblNome = new JLabel("Nome:");
		
		JLabel lblCpf = new JLabel("Cpf:");
		
		JLabel lblTelefone = new JLabel("Telefone:");
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		
		JLabel lblapenasNumeros = new JLabel("*Apenas Numeros");
		lblapenasNumeros.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel lblapenasNumeros_1 = new JLabel("*Apenas Numeros");
		lblapenasNumeros_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		
		
		//Botoes
		JButton botaoCadastrar = new JButton("Cadastrar");
		
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				//Tratamento para remover a mascara
				String cpf = textoFormatadoCpf.getText();
				String telefone = textoFormatadoTel.getText();
				cpf = cpf.replace(".","");
				cpf = cpf.replace("-","");
				telefone = telefone.replace("(","");
				telefone = telefone.replace(")","");
				telefone = telefone.replace("-","");
				
				setNovoCliente(new Cliente(campoTextoNome.getText(), cpf, telefone, campoTextoEndereco.getText()));
				
				
				campoTextoNome.setText(null);
				textoFormatadoCpf.setText(null);
				textoFormatadoTel.setText(null);
				campoTextoEndereco.setText(null);
				
				
				//Salvar o Cadastro Do Filme
				File arquivo;
				FileWriter writer;
				PrintWriter escrever;
				
				try {
					arquivo = new File ("BancoDeClientes.txt");
					writer = new FileWriter(arquivo, true);
					escrever = new PrintWriter(writer);
				
					escrever.println(getNovoCliente().gravarArquivo());
					
					escrever.close();
					writer.close();
					
				
				} catch (FileNotFoundException e) {
					
					JOptionPane.showMessageDialog(null,"Arquivo Nao Foi Encontrado ou Nao Foi Aberto");
					
				} catch (IOException e) {
					
					JOptionPane.showMessageDialog(null,"Nao Foi Possivel Salvar");
				} finally {
				
					JOptionPane.showMessageDialog(null,"Cliente Cadastrado Com Sucesso!");
				}
				
			}
		});
		
		
		JButton botaoFechar = new JButton("Fechar");
		
		botaoFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				TelaCadastroCliente.this.dispose();
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Alinhamento do Layout
		GroupLayout lLayoutTelaCadCliente = new GroupLayout(getContentPane());
		lLayoutTelaCadCliente.setHorizontalGroup(
			lLayoutTelaCadCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(lLayoutTelaCadCliente.createSequentialGroup()
					.addContainerGap()
					.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, lLayoutTelaCadCliente.createSequentialGroup()
							.addComponent(botaoCadastrar)
							.addGap(119)
							.addComponent(botaoFechar)
							.addGap(134))
						.addGroup(lLayoutTelaCadCliente.createSequentialGroup()
							.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTelefone)
								.addComponent(lblEndereco)
								.addComponent(lblCpf)
								.addComponent(lblNome))
							.addGap(40)
							.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.TRAILING)
								.addGroup(lLayoutTelaCadCliente.createSequentialGroup()
									.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(textoFormatadoCpf, Alignment.LEADING)
										.addComponent(textoFormatadoTel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.LEADING)
										.addComponent(lblapenasNumeros)
										.addComponent(lblapenasNumeros_1))
									.addGap(201))
								.addGroup(lLayoutTelaCadCliente.createSequentialGroup()
									.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.TRAILING)
										.addComponent(campoTextoEndereco, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
										.addComponent(campoTextoNome, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
									.addGap(65))))))
		);
		lLayoutTelaCadCliente.setVerticalGroup(
			lLayoutTelaCadCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(lLayoutTelaCadCliente.createSequentialGroup()
					.addGap(53)
					.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextoNome, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome))
					.addGap(35)
					.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(textoFormatadoCpf, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCpf)
						.addComponent(lblapenasNumeros))
					.addGap(34)
					.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(textoFormatadoTel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefone)
						.addComponent(lblapenasNumeros_1))
					.addGap(18)
					.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextoEndereco, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEndereco))
					.addGap(51)
					.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(botaoCadastrar)
						.addComponent(botaoFechar))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		getContentPane().setLayout(lLayoutTelaCadCliente);

	}
}