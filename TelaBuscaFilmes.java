import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TelaBuscaFilmes extends JInternalFrame {
	private JTextField campoTextoTitulo;
	private JTextField campoTextoGenero;
	private String textoDigitado;
	
	

	
	public String getTextoDigitado() {
		return textoDigitado;
	}




	public void setTextoDigitado(String textoDigitado) {
		this.textoDigitado = textoDigitado;
	}




	public TelaBuscaFilmes() {
		
		//Ação ao mover a janela, voltar aonde estava
		addComponentListener(new ComponentAdapter() {
			public void componentMoved(ComponentEvent evt) {
				setLocation(0, 0);	
			}
		});
		
		//Reduz a barra
		putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
		
		
		//Alinhamento
		setBounds(0, 0, 547, 389);
		
		
		//Espaços de Texto
		campoTextoTitulo = new JTextField();
		campoTextoTitulo.setColumns(10);
		
		campoTextoGenero = new JTextField();
		campoTextoGenero.setColumns(10);
		
		
		
		//Labels
		JLabel lblTitulo = new JLabel("Buscar Por Titulo:");
		
		JLabel lblGenero = new JLabel("Buscar Por Genero:");
		
		JLabel lblBuscarFilmes = new JLabel("Busca De Filmes");
		lblBuscarFilmes.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		
		
		//Botoes
		JButton btnBuscaPorTitulo = new JButton("Busca Por Titulo");
		
		btnBuscaPorTitulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				setTextoDigitado(campoTextoTitulo.getText());
				
			}
		});
		
		
		JButton btnBuscaPorGenero = new JButton("Busca Por Genero");
		
		btnBuscaPorGenero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setTextoDigitado(campoTextoGenero.getText());
				
			}
		});
		
		
		JButton btnFechar = new JButton("Fechar");
		
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaBuscaFilmes.this.dispose();
				
			}
		});
		
		
		
		
		
		
		
		
		//Alinhamento do Layout
		GroupLayout layoutTelaBuscaFilmes = new GroupLayout(getContentPane());
		layoutTelaBuscaFilmes.setHorizontalGroup(
			layoutTelaBuscaFilmes.createParallelGroup(Alignment.LEADING)
				.addGroup(layoutTelaBuscaFilmes.createSequentialGroup()
					.addGroup(layoutTelaBuscaFilmes.createParallelGroup(Alignment.LEADING)
						.addGroup(layoutTelaBuscaFilmes.createSequentialGroup()
							.addGap(39)
							.addGroup(layoutTelaBuscaFilmes.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTitulo)
								.addComponent(campoTextoTitulo, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGenero)
								.addComponent(campoTextoGenero, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscaPorTitulo)
								.addComponent(btnBuscaPorGenero)))
						.addGroup(layoutTelaBuscaFilmes.createSequentialGroup()
							.addGap(192)
							.addComponent(lblBuscarFilmes)))
					.addContainerGap(218, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, layoutTelaBuscaFilmes.createSequentialGroup()
					.addContainerGap(383, Short.MAX_VALUE)
					.addComponent(btnFechar)
					.addGap(59))
		);
		layoutTelaBuscaFilmes.setVerticalGroup(
			layoutTelaBuscaFilmes.createParallelGroup(Alignment.LEADING)
				.addGroup(layoutTelaBuscaFilmes.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBuscarFilmes)
					.addGap(39)
					.addComponent(lblTitulo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(campoTextoTitulo, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBuscaPorTitulo)
					.addGap(53)
					.addComponent(lblGenero)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(campoTextoGenero, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBuscaPorGenero)
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addComponent(btnFechar)
					.addGap(22))
		);
		getContentPane().setLayout(layoutTelaBuscaFilmes);
		
		

	}
}
