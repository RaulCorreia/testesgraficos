import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class TelaCadastroFilmes extends JInternalFrame {
	private JTextField campoTextoTitulo;
	private JTextField campoTextoAno;
	private JTextField campoTextoGenero;
	private JTextField campoTextoPreco;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private Filmes novoFilme;
	
	
	
	public Filmes getNovoFilme() {
		return novoFilme;
	}



	public void setNovoFilme(Filmes novoFilme) {
		this.novoFilme = novoFilme;
	}



	public TelaCadastroFilmes() {
		
		//A��o ao mover a janela, voltar aonde estava
		addComponentListener(new ComponentAdapter() {
			public void componentMoved(ComponentEvent evt) {
				setLocation(0, 0);
			}
		});
		
		//Reduz a barra
		putClientProperty("JInternalFrame.isPalette", Boolean.TRUE); 
		
		setBounds(0, 0, 547, 389);
		
		//Espa�os de Texto
		campoTextoTitulo = new JTextField();
		campoTextoTitulo.setColumns(10);
		
		campoTextoAno = new JTextField();
		campoTextoAno.setColumns(10);
		
		campoTextoGenero = new JTextField();
		campoTextoGenero.setColumns(10);
		
		campoTextoPreco = new JTextField();
		campoTextoPreco.setColumns(10);
		
		
		//Labels
		JLabel lblTitulo = new JLabel("Titulo:");
		
		JLabel lblAno = new JLabel("Ano:");
		
		JLabel lblGenero = new JLabel("Genero:");
		
		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		
		
		//Botoes
		btnCadastrar = new JButton("Cadastrar");
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				setNovoFilme(new Filmes(campoTextoGenero.getText(), false, false, Float.parseFloat(campoTextoPreco.getText()), campoTextoTitulo.getText(), Integer.parseInt(campoTextoAno.getText())));
				
				JOptionPane.showMessageDialog(null,"Filme Cadastrado Com Sucesso!");
				
				TelaCadastroFilmes.this.dispose();
				
			}
		});
		
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				TelaCadastroFilmes.this.dispose();
				
			}
		});
		
		
		
		
		//Alinhamento do Layout
		GroupLayout layoutTelaCadFilmes = new GroupLayout(getContentPane());
		layoutTelaCadFilmes.setHorizontalGroup(
			layoutTelaCadFilmes.createParallelGroup(Alignment.LEADING)
				.addGroup(layoutTelaCadFilmes.createSequentialGroup()
					.addGroup(layoutTelaCadFilmes.createParallelGroup(Alignment.LEADING)
						.addGroup(layoutTelaCadFilmes.createSequentialGroup()
							.addGap(84)
							.addGroup(layoutTelaCadFilmes.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTitulo)
								.addComponent(lblAno)
								.addComponent(lblGenero)
								.addComponent(lblPreco))
							.addGap(22)
							.addGroup(layoutTelaCadFilmes.createParallelGroup(Alignment.LEADING)
								.addComponent(campoTextoPreco, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addGroup(layoutTelaCadFilmes.createParallelGroup(Alignment.LEADING, false)
									.addComponent(campoTextoTitulo, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
									.addComponent(campoTextoGenero)
									.addComponent(campoTextoAno, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))))
						.addGroup(layoutTelaCadFilmes.createSequentialGroup()
							.addGap(123)
							.addComponent(btnCadastrar)
							.addGap(90)
							.addComponent(btnCancelar)))
					.addContainerGap(148, Short.MAX_VALUE))
		);
		layoutTelaCadFilmes.setVerticalGroup(
			layoutTelaCadFilmes.createParallelGroup(Alignment.LEADING)
				.addGroup(layoutTelaCadFilmes.createSequentialGroup()
					.addGap(64)
					.addGroup(layoutTelaCadFilmes.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextoTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTitulo))
					.addGap(18)
					.addGroup(layoutTelaCadFilmes.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextoAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAno))
					.addGap(18)
					.addGroup(layoutTelaCadFilmes.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextoGenero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGenero))
					.addGap(18)
					.addGroup(layoutTelaCadFilmes.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPreco)
						.addComponent(campoTextoPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(60)
					.addGroup(layoutTelaCadFilmes.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnCancelar))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		getContentPane().setLayout(layoutTelaCadFilmes);

	}
}