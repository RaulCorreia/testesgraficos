import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TelaBuscaCds extends JInternalFrame {
	private JTextField campoTextoTitulo;
	private JTextField campoTextoGenero;
	private String textoDigitado;
	
	

	
	public String getTextoDigitado() {
		return textoDigitado;
	}




	public void setTextoDigitado(String textoDigitado) {
		this.textoDigitado = textoDigitado;
	}




	public TelaBuscaCds() {
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
	
	
	//Espaços de Texto
	campoTextoTitulo = new JTextField();
	campoTextoTitulo.setColumns(10);
	
	campoTextoGenero = new JTextField();
	campoTextoGenero.setColumns(10);
	
	
	//Labels
	JLabel lblBuscaPorTitulo = new JLabel("Busca Por Titulo:");
	
	JLabel lblBuscaPorGenero = new JLabel("Busca Por Genero:");
	
	JLabel lblBuscaDeCds = new JLabel("Busca De Cds");
	lblBuscaDeCds.setFont(new Font("Tahoma", Font.BOLD, 15));
	
	
	//Botoes
	JButton btnBuscaPorTitulo = new JButton("Busca Por Titulo");
	
	btnBuscaPorTitulo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			setTextoDigitado(campoTextoTitulo.getText());
			
		}
	});
	
	
	
	JButton btnBuscaPorGenero = new JButton("Busca Por Genero");
	
	btnBuscaPorGenero.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			setTextoDigitado(campoTextoGenero.getText());
			
		}
	});
	
	
	
	JButton btnCancelar = new JButton("Cancelar");
	
	btnCancelar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			TelaBuscaCds.this.dispose();
			
		}
	});
	
	
	
	
	
	
	
	//Alinhamento do Layout
	GroupLayout layoutTelaBuscaCds = new GroupLayout(getContentPane());
	layoutTelaBuscaCds.setHorizontalGroup(
		layoutTelaBuscaCds.createParallelGroup(Alignment.LEADING)
			.addGroup(layoutTelaBuscaCds.createSequentialGroup()
				.addGap(212)
				.addComponent(lblBuscaDeCds)
				.addContainerGap(220, Short.MAX_VALUE))
			.addGroup(layoutTelaBuscaCds.createSequentialGroup()
				.addGap(52)
				.addGroup(layoutTelaBuscaCds.createParallelGroup(Alignment.LEADING)
					.addGroup(layoutTelaBuscaCds.createSequentialGroup()
						.addComponent(btnBuscaPorGenero)
						.addContainerGap())
					.addGroup(layoutTelaBuscaCds.createParallelGroup(Alignment.LEADING)
						.addGroup(layoutTelaBuscaCds.createSequentialGroup()
							.addComponent(btnBuscaPorTitulo)
							.addContainerGap())
						.addGroup(layoutTelaBuscaCds.createSequentialGroup()
							.addGroup(layoutTelaBuscaCds.createParallelGroup(Alignment.LEADING)
								.addGroup(layoutTelaBuscaCds.createSequentialGroup()
									.addComponent(lblBuscaPorGenero)
									.addPreferredGap(ComponentPlacement.RELATED, 117, GroupLayout.PREFERRED_SIZE))
								.addGroup(layoutTelaBuscaCds.createParallelGroup(Alignment.LEADING)
									.addGroup(layoutTelaBuscaCds.createSequentialGroup()
										.addComponent(lblBuscaPorTitulo)
										.addPreferredGap(ComponentPlacement.RELATED, 126, GroupLayout.PREFERRED_SIZE))
									.addComponent(campoTextoGenero, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
									.addComponent(campoTextoTitulo, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)))
							.addGap(241)))))
			.addGroup(Alignment.TRAILING, layoutTelaBuscaCds.createSequentialGroup()
				.addContainerGap(388, Short.MAX_VALUE)
				.addComponent(btnCancelar)
				.addGap(54))
	);
	layoutTelaBuscaCds.setVerticalGroup(
		layoutTelaBuscaCds.createParallelGroup(Alignment.LEADING)
			.addGroup(layoutTelaBuscaCds.createSequentialGroup()
				.addContainerGap()
				.addComponent(lblBuscaDeCds)
				.addGap(41)
				.addComponent(lblBuscaPorTitulo)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(campoTextoTitulo, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(btnBuscaPorTitulo)
				.addGap(49)
				.addComponent(lblBuscaPorGenero)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(campoTextoGenero, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(btnBuscaPorGenero)
				.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
				.addComponent(btnCancelar)
				.addGap(24))
	);
	getContentPane().setLayout(layoutTelaBuscaCds);
		
	
	
	

	}

}
