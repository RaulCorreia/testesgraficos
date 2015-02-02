import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComboBox;


public class TelaBuscaFilmes extends JInternalFrame {
	private JTextField campoTextoTitulo;
	private JTextField campoTextoGenero;
	private String textoDigitado;
	ArrayList< Filmes > listaFilmes = new ArrayList< Filmes >();
	
	

	
	public String getTextoDigitado() {
		return textoDigitado;
	}




	public void setTextoDigitado(String textoDigitado) {
		this.textoDigitado = textoDigitado;
	}




	public TelaBuscaFilmes() throws NumberFormatException, IOException {
		
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
		
		
		
		//Carregando banco de dados
		File arq = new File("BancoDeFilmes.txt");
		FileReader reader = new FileReader(arq);
		BufferedReader ler = new BufferedReader(reader);
		String linha = "";
				
				
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
		ler.close();
		reader.close();
		
		
		//Fim De Carregamento dos dados
		
		
		
		
		
		
		
		//Espaços de Texto
		campoTextoTitulo = new JTextField();
		campoTextoTitulo.setColumns(10);
		
		campoTextoGenero = new JTextField();
		campoTextoGenero.setColumns(10);
		
		JComboBox comboBoxOpcoes = new JComboBox();
		
		
		
		//Labels
		JLabel lblTitulo = new JLabel("Buscar Por Titulo:");
		
		JLabel lblGenero = new JLabel("Buscar Por Genero:");
		
		JLabel lblBuscarFilmes = new JLabel("Busca De Filmes");
		lblBuscarFilmes.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblcampoObrigatorio = new JLabel("*Campo Obrigatorio");
		lblcampoObrigatorio.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblcampoObrigatorio.setVisible(false);
		
		JLabel lblcampoObrigatorio2 = new JLabel("*Campo Obrigatorio");
		lblcampoObrigatorio2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblcampoObrigatorio2.setVisible(false);
		
		
		//Botoes
		JButton btnBuscaPorTitulo = new JButton("Busca Por Titulo");
		
		btnBuscaPorTitulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				
				comboBoxOpcoes.removeAllItems();
				setTextoDigitado(campoTextoTitulo.getText());
				int i;
				boolean teste = false;
				boolean testeExiste = true;
				
				testeExiste = getTextoDigitado().isEmpty();
				
				
				
				
				for(i = 0; i < listaFilmes.size(); i++){
					
					teste = getTextoDigitado().equalsIgnoreCase(listaFilmes.get(i).getTitulo());
					if( teste == true){
						
						
						String verificadoAlugado;
						String verificadoReservado;
						
						if(listaFilmes.get(i).isLocado() == true){
							verificadoAlugado = "INDISPONIVEL";
						} else{
							verificadoAlugado = "DISPONIVEL";
						}
						
						if(listaFilmes.get(i).isReservado() == true){
							verificadoReservado = "RESERVADO";
						} else{
							verificadoReservado = "DISPONIVEL";
						}
						
						
						if(verificadoReservado.equalsIgnoreCase("DISPONIVEL")){
							comboBoxOpcoes.addItem(listaFilmes.get(i).getTitulo() +" - R$ " + String.valueOf(listaFilmes.get(i).getPreco()) + " - Ano: " + listaFilmes.get(i).getAno() +" - " + verificadoAlugado);
							
						}
						if(verificadoReservado.equalsIgnoreCase("RESERVADO") && verificadoAlugado.equalsIgnoreCase("DISPONIVEL")){
							comboBoxOpcoes.addItem(listaFilmes.get(i).getTitulo() +" - R$ " + String.valueOf(listaFilmes.get(i).getPreco()) + " - Ano: " + listaFilmes.get(i).getAno() +" - " + verificadoReservado);
							
							
						}
						if(verificadoReservado.equalsIgnoreCase("RESERVADO") && verificadoAlugado.equalsIgnoreCase("INDISPONIVEL")){
							comboBoxOpcoes.addItem(listaFilmes.get(i).getTitulo() +" - R$ " + String.valueOf(listaFilmes.get(i).getPreco()) + " - Ano: " + listaFilmes.get(i).getAno() +" - " + verificadoAlugado);
							
							
						}
						
					}
					
				}
				
				if (testeExiste == true){
					lblcampoObrigatorio.setVisible(true);
					JOptionPane.showMessageDialog(null,"Digite o nome do Filmes");
				}
				
				
				
				
				
				
				
			}
		});
		
		
		JButton btnBuscaPorGenero = new JButton("Busca Por Genero");
		
		btnBuscaPorGenero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBoxOpcoes.removeAllItems();
				setTextoDigitado(campoTextoGenero.getText());
				int i;
				boolean teste = false;
				boolean testeExiste = true;
				
				testeExiste = getTextoDigitado().isEmpty();
				
				
				
				for(i = 0; i < listaFilmes.size(); i++){
					
					teste = getTextoDigitado().equalsIgnoreCase(listaFilmes.get(i).getGenero());
					if( teste == true){
						
						
						String verificadoAlugado;
						String verificadoReservado;
						
						if(listaFilmes.get(i).isLocado() == true){
							verificadoAlugado = "INDISPONIVEL";
						} else{
							verificadoAlugado = "DISPONIVEL";
						}
						
						if(listaFilmes.get(i).isReservado() == true){
							verificadoReservado = "RESERVADO";
						} else{
							verificadoReservado = "DISPONIVEL";
						}
						
						
						if(verificadoReservado.equalsIgnoreCase("DISPONIVEL")){
							comboBoxOpcoes.addItem(listaFilmes.get(i).getTitulo() +" - R$ " + String.valueOf(listaFilmes.get(i).getPreco()) + " - Ano: " + listaFilmes.get(i).getAno() +" - " + verificadoAlugado);
							
						}
						if(verificadoReservado.equalsIgnoreCase("RESERVADO") && verificadoAlugado.equalsIgnoreCase("DISPONIVEL")){
							comboBoxOpcoes.addItem(listaFilmes.get(i).getTitulo() +" - R$ " + String.valueOf(listaFilmes.get(i).getPreco()) + " - Ano: " + listaFilmes.get(i).getAno() +" - " + verificadoReservado);
							
							
						}
						if(verificadoReservado.equalsIgnoreCase("RESERVADO") && verificadoAlugado.equalsIgnoreCase("INDISPONIVEL")){
							comboBoxOpcoes.addItem(listaFilmes.get(i).getTitulo() +" - R$ " + String.valueOf(listaFilmes.get(i).getPreco()) + " - Ano: " + listaFilmes.get(i).getAno() +" - " + verificadoAlugado);
							
							
						}
						
					}
					
				}
				
				
				if (testeExiste == true){
					lblcampoObrigatorio2.setVisible(true);
					JOptionPane.showMessageDialog(null,"Digite o nome do Filmes");
				}
				
				
				
				
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
			layoutTelaBuscaFilmes.createParallelGroup(Alignment.TRAILING)
				.addGroup(layoutTelaBuscaFilmes.createSequentialGroup()
					.addGroup(layoutTelaBuscaFilmes.createParallelGroup(Alignment.LEADING)
						.addGroup(layoutTelaBuscaFilmes.createSequentialGroup()
							.addGap(39)
							.addGroup(layoutTelaBuscaFilmes.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTitulo)
								.addGroup(layoutTelaBuscaFilmes.createSequentialGroup()
									.addComponent(campoTextoTitulo, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblcampoObrigatorio))
								.addComponent(btnBuscaPorTitulo)
								.addComponent(lblGenero)
								.addGroup(layoutTelaBuscaFilmes.createSequentialGroup()
									.addComponent(campoTextoGenero, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblcampoObrigatorio2))
								.addComponent(btnBuscaPorGenero)
								.addComponent(comboBoxOpcoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(layoutTelaBuscaFilmes.createSequentialGroup()
							.addGap(192)
							.addComponent(lblBuscarFilmes)))
					.addContainerGap(160, Short.MAX_VALUE))
				.addGroup(layoutTelaBuscaFilmes.createSequentialGroup()
					.addContainerGap(407, Short.MAX_VALUE)
					.addComponent(btnFechar)
					.addGap(59))
		);
		layoutTelaBuscaFilmes.setVerticalGroup(
			layoutTelaBuscaFilmes.createParallelGroup(Alignment.LEADING)
				.addGroup(layoutTelaBuscaFilmes.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBuscarFilmes)
					.addGap(13)
					.addComponent(lblTitulo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layoutTelaBuscaFilmes.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextoTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblcampoObrigatorio))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBuscaPorTitulo)
					.addGap(18)
					.addComponent(lblGenero)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layoutTelaBuscaFilmes.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextoGenero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblcampoObrigatorio2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBuscaPorGenero)
					.addGap(18)
					.addComponent(comboBoxOpcoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
					.addComponent(btnFechar)
					.addGap(22))
		);
		getContentPane().setLayout(layoutTelaBuscaFilmes);
		
		

	}
}
