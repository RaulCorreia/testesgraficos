import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;




public class TelaLocadoraAluguel extends JInternalFrame {
	private JTextField campoTextoNome;
	private JTextField campoTextCliente;
	private boolean selecao;
	ArrayList< Cliente > clientes = new ArrayList< Cliente >();
	ArrayList< Cds > listaCds = new ArrayList< Cds >();
	ArrayList< Filmes > listaFilmes = new ArrayList< Filmes >();
	File arq;
	FileReader reader;
	BufferedReader ler;
	



	public boolean isSelecao() {
		return selecao;
	}



	public void setSelecao(boolean selecao) {
		this.selecao = selecao;
	}



	public TelaLocadoraAluguel() throws NumberFormatException, IOException {
		//Ação ao mover a janela, voltar aonde estava
		addComponentListener(new ComponentAdapter() {
			public void componentMoved(ComponentEvent evt) {
				setLocation(0, 0);
			}
		});
				
		//Reduz a barra
		putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
				
		setBounds(0, 0, 547, 389);
		
		
		
		//Carregando banco de dados
		arq = new File("BancoDeFilmes.txt");
		reader = new FileReader(arq);
		ler = new BufferedReader(reader);
		String linha = "";
		
		
		if (arq.exists() && arq.isFile() && arq.canRead()){
		//Carregando Dados dos filmes
		while ((linha = ler.readLine()) != null){
			Filmes filme;
			
			String[] partes = linha.split("-");
			boolean alugado;
			boolean reservado;
			
			
			if (partes[2].equalsIgnoreCase("false")){
				alugado = false;
			} else{
				alugado = true;
			}
			
			if(partes[3].equalsIgnoreCase("false")){
				reservado = false;
			} else {
				reservado = true;
			}
			
			
			
			filme = new Filmes(partes[0], partes[1], alugado, reservado, Float.parseFloat(partes[4]), Integer.parseInt(partes[5]));
			
			listaFilmes.add(filme);
		}
		
		
		//Carregando Dados dos Clientes
		arq = new File("BancoDeClientes.txt");
		
		while ((linha = ler.readLine()) != null){
			Cliente cliente;
			
			String[] partes = linha.split("-");
			
			cliente = new Cliente(partes[0], partes[1], partes[2]);
			cliente.setSaldo(Float.parseFloat(partes[3]));
			clientes.add(cliente);
			
			
		}
		
		
		//Carregando Dados dos Cds
		arq = new File("BancoDeCds.txt");
		
		
		
		while ((linha = ler.readLine()) != null){
			
			Cds cd;
			
			String[] partes = linha.split("-");
			
			boolean alugado;
			boolean reservado;
			
			if (partes[3].equalsIgnoreCase("false")){
				alugado = false;
			} else{
				alugado = true;
			}
			
			if(partes[4].equalsIgnoreCase("false")){
				reservado = false;
			} else {
				reservado = true;
			}
			
			cd = new Cds(partes[0], partes[1], partes[2], alugado, reservado, Float.parseFloat(partes[5]));
			listaCds.add(cd);
			
		}
		} else{
			JOptionPane.showMessageDialog(null, "Nenhum Arquivo do Banco De Dados Encontrado");
		}
		
		
		
		
		//Espaços de Texto
		campoTextoNome = new JTextField();
		campoTextoNome.setColumns(10);
		
		campoTextCliente = new JTextField();
		campoTextCliente.setColumns(10);
		
		JTextPane textoNomeClienteSelecionado = new JTextPane();
		textoNomeClienteSelecionado.setVisible(false);
		
		
		//Labels
		JLabel lblNome = new JLabel("Nome do Filme/Banda:");
		JLabel lblNomeCliente = new JLabel("Nome Cliente:");
		JLabel lblClienteSelecionado = new JLabel("Cliente Selecionado:");
		lblClienteSelecionado.setVisible(false);
		
		
		//Escolha do que alugar
		JRadioButton selecaoFilme = new JRadioButton("Filme", false);
		
		JRadioButton selecaoCd = new JRadioButton("Cd", false);
		
		
		ButtonGroup botaoDeSelecao = new ButtonGroup();
		botaoDeSelecao.add(selecaoFilme);
		botaoDeSelecao.add(selecaoCd);
		
		
		//Botoes
		JButton btnBuscarCliente = new JButton("Buscar Cliente");
		
		
		//Seleção do Tipo de produto
		selecaoFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				JOptionPane.showMessageDialog(null, "Filme foi selecionado");
				lblClienteSelecionado.setVisible(true);
				textoNomeClienteSelecionado.setVisible(true);
				
			}
		});
		
		
		
		selecaoCd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Cds foi selecionado");
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Alinhamento do Layout
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(156)
					.addComponent(selecaoFilme)
					.addGap(95)
					.addComponent(selecaoCd)
					.addContainerGap(192, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNome)
						.addComponent(lblNomeCliente)
						.addComponent(lblClienteSelecionado))
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnBuscarCliente)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(textoNomeClienteSelecionado, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(campoTextCliente, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
									.addComponent(campoTextoNome, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
								.addGap(144)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(selecaoFilme)
						.addComponent(selecaoCd))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome))
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNomeCliente))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBuscarCliente)
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textoNomeClienteSelecionado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblClienteSelecionado))
					.addContainerGap(144, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		
		

	}
	
	
	
	public Cliente buscarNome(String nome){
		
		Cliente clienteBusca = new Cliente();
		Cliente clienteAchado = new Cliente();
		
		int i = 0;
		int j = clientes.size();
		
		clienteBusca = clientes.get(i);
		
		for(i = 1; i < j; i++ ){
		
			if(clienteBusca.getNome().equals(nome)){
			
				clienteAchado = clienteBusca;
			
			}
			
			clienteBusca = clientes.get(i);
			
		}
		
		
		return clienteAchado;
	}
}
