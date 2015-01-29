//import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	ArrayList< Cliente > clientes = new ArrayList< Cliente >();
	private String textoBusca;

	

	public String getTextoBusca() {
		return textoBusca;
	}


	public void setTextoBusca(String textoBusca) {
		this.textoBusca = textoBusca;
	}


	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 451);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JDesktopPane desktopPrincipal = new JDesktopPane();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(desktopPrincipal, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(desktopPrincipal, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
		);
		
		contentPane.setLayout(gl_contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnLocadora = new JMenu("Locadora");
		menuBar.add(mnLocadora);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Aluguel");
		mnLocadora.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Reservar");
		mnLocadora.add(mntmNewMenuItem_4);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);
		
		JMenuItem mntmFilmes = new JMenuItem("Filmes");
		mnCadastros.add(mntmFilmes);
		
		JMenuItem mntmCds = new JMenuItem("CDs");
		mnCadastros.add(mntmCds);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCadastroCliente telaCadCliente = new TelaCadastroCliente();
				
				desktopPrincipal.add(telaCadCliente);
				
				telaCadCliente.setVisible(true);
				
				clientes.add(telaCadCliente.getNovoCliente());
				
				
			}
		});
		
		
		mnCadastros.add(mntmClientes);
		
		JMenu mnNewMenu = new JMenu("Buscas");
		menuBar.add(mnNewMenu);
		
		JMenuItem btBuscaFilmes = new JMenuItem("Filme");
		mnNewMenu.add(btBuscaFilmes);
		
		JMenuItem btBuscaCds = new JMenuItem("CDs");
		mnNewMenu.add(btBuscaCds);
		
		JMenuItem btBuscaClientes = new JMenuItem("Clientes");
		btBuscaClientes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				TelaBuscaCliente telaBuscaCliente = new TelaBuscaCliente();
				
				desktopPrincipal.add(telaBuscaCliente);
				
				telaBuscaCliente.setVisible(true);
				
				setTextoBusca(telaBuscaCliente.getTextoDigitado());
				
			}
		});
		
		mnNewMenu.add(btBuscaClientes);
		
		
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		
		try {
			
			TelaPrincipal frame = new TelaPrincipal();
			frame.setVisible(true);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
			
		
	}
	
	
	
	Cliente buscarNome(String nome){
		
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

