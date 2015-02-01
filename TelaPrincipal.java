//import java.awt.EventQueue;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;








import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;




public class TelaPrincipal extends JFrame {

	private JPanel telaPrincipal;
	ArrayList< Cliente > clientes = new ArrayList< Cliente >();
	ArrayList< Cds > listaCds = new ArrayList< Cds >();
	ArrayList< Filmes > listaFilmes = new ArrayList< Filmes >();
	private String textoBusca;
	
	

	public String getTextoBusca() {
		return textoBusca;
	}


	public void setTextoBusca(String textoBusca) {
		this.textoBusca = textoBusca;
	}
	
	public Cliente getClientes(int num) {
		return clientes.get(num);
	}


	public void setClientes(Cliente cliente) {
		this.clientes.add(cliente);
	}


	public Cds getListaCds(int num) {
		return listaCds.get(num);
	}


	public void setListaCds(Cds cd) {
		this.listaCds.add(cd);
	}


	public Filmes getListaFilmes(int num) {
		return listaFilmes.get(num);
	}


	public void setListaFilmes(Filmes filme) {
		this.listaFilmes.add(filme);
	}



	public TelaPrincipal() {
		
		//Nao Pode Redimensionar
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 451);
		
		//Criação do PainelPrincipal
		telaPrincipal = new JPanel();
		telaPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaPrincipal);
		
		//Criação do Desktop
		JDesktopPane desktopPrincipal = new JDesktopPane();
		
		
		//Barra de Menus
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		//Menu Locadora e submenus
		JMenu menuLocadora = new JMenu("Locadora");
		menuBar.add(menuLocadora);
		
		JMenuItem subMenuAluguel = new JMenuItem("Aluguel");
		
		subMenuAluguel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				TelaLocadoraAluguel telaAluguel;
				try {
					telaAluguel = new TelaLocadoraAluguel();
				
				
					desktopPrincipal.add(telaAluguel);
				
				
					telaAluguel.setVisible(true);
				
				} catch (NumberFormatException | IOException e) {
					JOptionPane.showMessageDialog(null, "Nenhum Arquivo do Banco De Dados Encontrado");
					e.printStackTrace();
				}
				
				
				
				
			}
		});
		menuLocadora.add(subMenuAluguel);
		
		JMenuItem subMenuReservar = new JMenuItem("Reservar");
		menuLocadora.add(subMenuReservar);
		
		
		//Menu Cadastros e submenus
		JMenu menuCadastros = new JMenu("Cadastros");
		menuBar.add(menuCadastros);
		
		
		JMenuItem subMenuCadFilmes = new JMenuItem("Filmes");
		subMenuCadFilmes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				TelaCadastroFilmes telaCadFilmes = new TelaCadastroFilmes();
				
				desktopPrincipal.add(telaCadFilmes);
				
				telaCadFilmes.setVisible(true);
				
				//setListaFilmes(telaCadFilmes.getNovoFilme());
				
			}
		});
		menuCadastros.add(subMenuCadFilmes);
		
		
		JMenuItem subMenuCadCds = new JMenuItem("CDs");
		subMenuCadCds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				TelaCadastroCds telaCadCds = new TelaCadastroCds();
				
				desktopPrincipal.add(telaCadCds);
				
				telaCadCds.setVisible(true);
				
				//setListaCds(telaCadCds.getNovoCd());
				
			}
		});
		menuCadastros.add(subMenuCadCds);
		
		
		JMenuItem subMenuCadClientes = new JMenuItem("Clientes");
		subMenuCadClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				
				TelaCadastroCliente telaCadCliente;
				try {
					telaCadCliente = new TelaCadastroCliente();
				
					desktopPrincipal.add(telaCadCliente);
				
					telaCadCliente.setVisible(true);
				
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//setClientes(telaCadCliente.getNovoCliente());
				
				
			}
		});
		menuCadastros.add(subMenuCadClientes);
		
		
		//Menu Busca e submenus
		JMenu menuBuscas = new JMenu("Buscas");
		menuBar.add(menuBuscas);
		
		JMenuItem subMenuBuscaFilmes = new JMenuItem("Filme");
		subMenuBuscaFilmes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaBuscaFilmes telaBuscaFilmes = new TelaBuscaFilmes();
				
				desktopPrincipal.add(telaBuscaFilmes);
				
				telaBuscaFilmes.setVisible(true);
				
				setTextoBusca(telaBuscaFilmes.getTextoDigitado());
				
			}
		});
		menuBuscas.add(subMenuBuscaFilmes);
		
		JMenuItem subMenuBuscaCds = new JMenuItem("CDs");
		subMenuBuscaCds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaBuscaCds telaBuscaCds = new TelaBuscaCds();
				
				desktopPrincipal.add(telaBuscaCds);
				
				telaBuscaCds.setVisible(true);
				
				setTextoBusca(telaBuscaCds.getTextoDigitado());
				
			}
		});
		menuBuscas.add(subMenuBuscaCds);
		
		JMenuItem subMenuBuscaClientes = new JMenuItem("Clientes");
		subMenuBuscaClientes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				TelaBuscaCliente telaBuscaCliente = new TelaBuscaCliente();
				
				desktopPrincipal.add(telaBuscaCliente);
				
				telaBuscaCliente.setVisible(true);
				
				setTextoBusca(telaBuscaCliente.getTextoDigitado());
				
			}
		});
		menuBuscas.add(subMenuBuscaClientes);
		
		
		
		//Alinhamento do Layout da Tela Principal
		GroupLayout layoutPrincipal = new GroupLayout(telaPrincipal);
		layoutPrincipal.setHorizontalGroup(
			layoutPrincipal.createParallelGroup(Alignment.LEADING)
				.addComponent(desktopPrincipal, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
		);
		layoutPrincipal.setVerticalGroup(
			layoutPrincipal.createParallelGroup(Alignment.LEADING)
				.addComponent(desktopPrincipal, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
		);
				
		telaPrincipal.setLayout(layoutPrincipal);
		
		
		
		
	}
	
	
	
	
	

	public static void main(String[] args) {
		
		
		try {
			
			TelaPrincipal frame = new TelaPrincipal();
			frame.setVisible(true);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
			
		
	}
	
	
	
	
	
	//Criação das Funções
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

