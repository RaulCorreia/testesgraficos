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
import java.io.*;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;



public class TelaCadastroFilmes extends JInternalFrame {
	private JTextField campoTextoTitulo;
	private JTextField campoTextoGenero;
	private JButton btnCadastrar;
	private JButton btnFechar;
	private Filmes novoFilme;
	
	
	
	public Filmes getNovoFilme() {
		return novoFilme;
	}



	public void setNovoFilme(Filmes novoFilme) {
		this.novoFilme = novoFilme;
	}



	public TelaCadastroFilmes() throws ParseException {
		
		
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
		campoTextoTitulo = new JTextField();
		campoTextoTitulo.setColumns(10);
		
		campoTextoGenero = new JTextField();
		campoTextoGenero.setColumns(10);
		
		MaskFormatter preco = new MaskFormatter("##,##");;
		MaskFormatter ano = new MaskFormatter("####");;
		
		JFormattedTextField textoFormatadoPreco = new JFormattedTextField(preco);;
		JFormattedTextField textoFormatadoAno = new JFormattedTextField(ano);;
		
		
		
		
		
		//Labels
		JLabel lblTitulo = new JLabel("Titulo:");
		
		JLabel lblAno = new JLabel("Ano:");
		
		JLabel lblGenero = new JLabel("Genero:");
		
		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		
		JLabel lblapenasNumeros = new JLabel("*Apenas Numeros");
		lblapenasNumeros.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel lblapenasNumeros_1 = new JLabel("*Apenas Numeros");
		lblapenasNumeros_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		
		
		//Botoes
		btnCadastrar = new JButton("Cadastrar");
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				String preco = textoFormatadoPreco.getText();
				String ano = textoFormatadoAno.getText();
				
				preco = preco.replace(",", ".");
				
				
				setNovoFilme(new Filmes(campoTextoTitulo.getText(), campoTextoGenero.getText(), false, false, Float.parseFloat(preco), Integer.parseInt(ano)));
				
				
				campoTextoTitulo.setText(null);
				textoFormatadoAno.setText(null);
				campoTextoGenero.setText(null);
				textoFormatadoPreco.setText(null);
				
				
				
				
				//Salvar o Cadastro Do Filme
				File arquivo;
				FileWriter writer;
				PrintWriter escrever;
				
				try {
					arquivo = new File ("BancoDeFilmes.txt");
					writer = new FileWriter(arquivo, true);
					escrever = new PrintWriter(writer);
				
					escrever.println(getNovoFilme().gravarArquivo());
					
					escrever.close();
					writer.close();
					
				
				} catch (FileNotFoundException e) {
					
					JOptionPane.showMessageDialog(null,"Arquivo Nao Foi Encontrado ou Nao Foi Aberto");
					
				} catch (IOException e) {
					
					JOptionPane.showMessageDialog(null,"Nao Foi Possivel Salvar");
				} finally{				
				 JOptionPane.showMessageDialog(null,"Filme Cadastrado Com Sucesso!");
				}
				
			}
		});
		
		
		btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
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
							.addGap(123)
							.addComponent(btnCadastrar)
							.addGap(90)
							.addComponent(btnFechar))
						.addGroup(layoutTelaCadFilmes.createSequentialGroup()
							.addGap(84)
							.addGroup(layoutTelaCadFilmes.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTitulo)
								.addComponent(lblAno)
								.addComponent(lblGenero)
								.addComponent(lblPreco))
							.addGap(22)
							.addGroup(layoutTelaCadFilmes.createParallelGroup(Alignment.LEADING)
								.addGroup(layoutTelaCadFilmes.createSequentialGroup()
									.addComponent(textoFormatadoPreco, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblapenasNumeros_1))
								.addGroup(layoutTelaCadFilmes.createParallelGroup(Alignment.LEADING)
									.addComponent(campoTextoTitulo, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
									.addComponent(campoTextoGenero, 214, 214, 214)
									.addGroup(layoutTelaCadFilmes.createSequentialGroup()
										.addComponent(textoFormatadoAno, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblapenasNumeros))))))
					.addContainerGap(172, Short.MAX_VALUE))
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
						.addComponent(lblAno)
						.addComponent(textoFormatadoAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblapenasNumeros))
					.addGap(18)
					.addGroup(layoutTelaCadFilmes.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextoGenero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGenero))
					.addGap(18)
					.addGroup(layoutTelaCadFilmes.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPreco)
						.addComponent(textoFormatadoPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblapenasNumeros_1))
					.addGap(52)
					.addGroup(layoutTelaCadFilmes.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnFechar))
					.addContainerGap(87, Short.MAX_VALUE))
		);
		getContentPane().setLayout(layoutTelaCadFilmes);

	}
}
