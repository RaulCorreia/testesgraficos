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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;


public class TelaCadastroCliente extends JInternalFrame {
	private JTextField campoTextoNome;
	private Cliente novoCliente;
	


	public Cliente getNovoCliente() {
		return novoCliente;
	}


	public void setNovoCliente(Cliente novoCliente) {
		this.novoCliente = novoCliente;
	}





	public TelaCadastroCliente() throws ParseException {
		
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
		
		//Campo de Texto Formatado
		MaskFormatter mascaraCpf;
		MaskFormatter mascaraTel;
		JFormattedTextField textoFormatadoCpf;
		JFormattedTextField textoFormatadoTel;
		
		mascaraCpf = new MaskFormatter("###.###.###-##");
		textoFormatadoCpf = new JFormattedTextField(mascaraCpf);
		
		mascaraTel = new MaskFormatter("(##) ####-####");
		textoFormatadoTel = new JFormattedTextField(mascaraTel);			
		
		
		
		
		//Labels
		JLabel lblNome = new JLabel("Nome:");
		
		JLabel lblCpf = new JLabel("Cpf:");
		
		JLabel lblTelefone = new JLabel("Telefone:");
		
		
		//Botoes
		JButton botaoCadastrar = new JButton("Cadastrar");
		
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				setNovoCliente(new Cliente(campoTextoNome.getText(), textoFormatadoCpf.getText(), textoFormatadoTel.getText()));
				
				
				campoTextoNome.setText(null);
				textoFormatadoCpf.setText(null);
				textoFormatadoTel.setText(null);
				
				
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
			lLayoutTelaCadCliente.createParallelGroup(Alignment.TRAILING)
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
					.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.LEADING)
						.addGroup(lLayoutTelaCadCliente.createSequentialGroup()
							.addComponent(campoTextoNome, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
							.addGap(65))
						.addGroup(lLayoutTelaCadCliente.createSequentialGroup()
							.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textoFormatadoCpf, Alignment.LEADING)
								.addComponent(textoFormatadoTel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
							.addContainerGap())))
				.addGroup(lLayoutTelaCadCliente.createSequentialGroup()
					.addContainerGap(135, Short.MAX_VALUE)
					.addComponent(botaoCadastrar)
					.addGap(113)
					.addComponent(botaoFechar)
					.addGap(137))
		);
		lLayoutTelaCadCliente.setVerticalGroup(
			lLayoutTelaCadCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(lLayoutTelaCadCliente.createSequentialGroup()
					.addGap(53)
					.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextoNome, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome))
					.addGap(35)
					.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCpf)
						.addComponent(textoFormatadoCpf, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefone)
						.addComponent(textoFormatadoTel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(68)
					.addGroup(lLayoutTelaCadCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(botaoFechar)
						.addComponent(botaoCadastrar))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		getContentPane().setLayout(lLayoutTelaCadCliente);

	}
}