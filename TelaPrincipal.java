import java.awt.EventQueue;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
				
				
				
			}
		});
		
		
		mnCadastros.add(mntmClientes);
		
		JMenu mnNewMenu = new JMenu("Buscas");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Filme");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("CDs");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Clientes");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		
		
	}

	
}

