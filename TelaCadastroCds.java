import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class TelaCadastroCds extends JInternalFrame {
	private JTextField campoTextoBanda;
	private JTextField campoTextoAlbum;
	private JTextField campoTextoGenero;
	private JTextField campotextoPreco;
	private Cds novoCd;
	
	
	public Cds getNovoCd() {
		return novoCd;
	}


	public void setNovoCd(Cds novoCd) {
		this.novoCd = novoCd;
	}


	public TelaCadastroCds() {
		
		//Ação ao mover a janela, voltar aonde estava
		addComponentListener(new ComponentAdapter() {
			public void componentMoved(ComponentEvent evt) {
				setLocation(0, 0);
			}
		});
		
		//Reduz a barra
		putClientProperty("JInternalFrame.isPalette", Boolean.TRUE); 
		
		
		setBounds(0, 0, 547, 389);
		
		//Espaços de Texto
		campoTextoBanda = new JTextField();
		campoTextoBanda.setColumns(10);
		
		campoTextoAlbum = new JTextField();
		campoTextoAlbum.setColumns(10);
		
		campoTextoGenero = new JTextField();
		campoTextoGenero.setColumns(10);
		
		campotextoPreco = new JTextField();
		campotextoPreco.setColumns(10);
		
		
		//Labels
		JLabel lblNomeDaBanda = new JLabel("Banda:");
		
		JLabel lblNomeDoAlbum = new JLabel("Album:");
		
		JLabel lblNomeDoGenero = new JLabel("Genero:");
		
		JLabel lblPreco = new JLabel("Pre\u00E7o");
		
		
		//Botoes
		JButton btnCadastrar = new JButton("Cadastrar");
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				novoCd = new Cds(campoTextoGenero.getText(), false, false, Float.parseFloat(campotextoPreco.getText()), campoTextoBanda.getText(), campoTextoAlbum.getText());
				
				JOptionPane.showMessageDialog(null,"Cd Cadastrado Com Sucesso!");
				
				TelaCadastroCds.this.dispose();
				
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				TelaCadastroCds.this.dispose();
				
			}
		});
		
		
		
		
		
		//Alinhamento do Layout
		GroupLayout layoutTelaCadCds = new GroupLayout(getContentPane());
		layoutTelaCadCds.setHorizontalGroup(
			layoutTelaCadCds.createParallelGroup(Alignment.LEADING)
				.addGroup(layoutTelaCadCds.createSequentialGroup()
					.addGap(38)
					.addGroup(layoutTelaCadCds.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNomeDaBanda)
						.addComponent(lblNomeDoAlbum)
						.addComponent(lblNomeDoGenero)
						.addComponent(lblPreco))
					.addGap(35)
					.addGroup(layoutTelaCadCds.createParallelGroup(Alignment.LEADING)
						.addGroup(layoutTelaCadCds.createSequentialGroup()
							.addGroup(layoutTelaCadCds.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(campoTextoAlbum, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
								.addComponent(campoTextoBanda, Alignment.LEADING)
								.addComponent(campoTextoGenero, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
								.addComponent(campotextoPreco, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(194, Short.MAX_VALUE))
						.addGroup(layoutTelaCadCds.createSequentialGroup()
							.addComponent(btnCadastrar)
							.addPreferredGap(ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
							.addComponent(btnCancelar)
							.addGap(116))))
		);
		layoutTelaCadCds.setVerticalGroup(
			layoutTelaCadCds.createParallelGroup(Alignment.LEADING)
				.addGroup(layoutTelaCadCds.createSequentialGroup()
					.addGap(53)
					.addGroup(layoutTelaCadCds.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextoBanda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNomeDaBanda))
					.addGap(36)
					.addGroup(layoutTelaCadCds.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextoAlbum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNomeDoAlbum))
					.addGap(34)
					.addGroup(layoutTelaCadCds.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextoGenero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNomeDoGenero))
					.addGap(30)
					.addGroup(layoutTelaCadCds.createParallelGroup(Alignment.BASELINE)
						.addComponent(campotextoPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPreco))
					.addGap(46)
					.addGroup(layoutTelaCadCds.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnCancelar))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		getContentPane().setLayout(layoutTelaCadCds);

	}
}
