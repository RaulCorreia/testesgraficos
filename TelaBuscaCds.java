import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JComboBox;


public class TelaBuscaCds extends JInternalFrame {
	private JTextField campoTextoTitulo;
	private JTextField campoTextoGenero;
	private String textoDigitado;
	ArrayList< Cds > listaCds = new ArrayList< Cds >();
	
	

	
	public String getTextoDigitado() {
		return textoDigitado;
	}




	public void setTextoDigitado(String textoDigitado) {
		this.textoDigitado = textoDigitado;
	}




	public TelaBuscaCds() throws NumberFormatException, IOException {
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
	
	
	//Carregando Dados dos Cds
	String linha = "";
	File arq = new File("BancoDeCds.txt");
	FileReader reader = new FileReader(arq);
	BufferedReader ler = new BufferedReader(reader);
			
			
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
	ler.close();
	reader.close();
	
	
	
	
	
	
	//Espaços de Texto
	campoTextoTitulo = new JTextField();
	campoTextoTitulo.setColumns(10);
	
	campoTextoGenero = new JTextField();
	campoTextoGenero.setColumns(10);
	
	JComboBox comboBoxOpcoes = new JComboBox();
	
	
	//Labels
	JLabel lblBuscaPorTitulo = new JLabel("Busca Por Titulo:");
	
	JLabel lblBuscaPorGenero = new JLabel("Busca Por Genero:");
	
	JLabel lblBuscaDeCds = new JLabel("Busca De Cds");
	lblBuscaDeCds.setFont(new Font("Tahoma", Font.BOLD, 15));
	
	JLabel lblcampoObrigatorio = new JLabel("*Campo Obrigatorio");
	lblcampoObrigatorio.setFont(new Font("Tahoma", Font.PLAIN, 9));
	lblcampoObrigatorio.setVisible(false);
	
	JLabel lblcampoObrigatorio2 = new JLabel("*Campo Obrigatorio");
	lblcampoObrigatorio2.setFont(new Font("Tahoma", Font.PLAIN, 9));
	lblcampoObrigatorio2.setVisible(false);
	
	
	//Botoes
	JButton btnBuscaPorTitulo = new JButton("Busca Por Titulo");
	
	btnBuscaPorTitulo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			comboBoxOpcoes.removeAllItems();
			setTextoDigitado(campoTextoTitulo.getText());
			int i;
			boolean teste = false;
			boolean testeExiste = true;
			
			testeExiste = getTextoDigitado().isEmpty();
			
			
			for(i = 0; i < listaCds.size(); i++){
				
				teste = getTextoDigitado().equalsIgnoreCase(listaCds.get(i).getNomeBanda());
				
				if( teste == true){
					
					String verificadoAlugado;
					String verificadoReservado;
					
					if(listaCds.get(i).isLocado() == true){
						verificadoAlugado = "INDISPONIVEL";
					} else{
						verificadoAlugado = "DISPONIVEL";
					}
					
					if(listaCds.get(i).isReservado() == true){
						verificadoReservado = "RESERVADO";
					} else{
						verificadoReservado = "DISPONIVEL";
					}
					
					
					if(verificadoReservado.equalsIgnoreCase("DISPONIVEL")){
						comboBoxOpcoes.addItem(listaCds.get(i).getNomeBanda() + " - Album: " + listaCds.get(i).getAlbum() +" - R$ "+ String.valueOf(listaCds.get(i).getPreco()) +" - " + verificadoAlugado);
						
					}
					if(verificadoReservado.equalsIgnoreCase("RESERVADO") && verificadoAlugado.equalsIgnoreCase("DISPONIVEL")){
						comboBoxOpcoes.addItem(listaCds.get(i).getNomeBanda() + " - Album: " + listaCds.get(i).getAlbum() +" - R$ "+ String.valueOf(listaCds.get(i).getPreco()) +" - " + verificadoReservado);
						
						
					}
					if(verificadoReservado.equalsIgnoreCase("RESERVADO") && verificadoAlugado.equalsIgnoreCase("INDISPONIVEL")){
						comboBoxOpcoes.addItem(listaCds.get(i).getNomeBanda() + " - Album: " + listaCds.get(i).getAlbum() +" - R$ "+ String.valueOf(listaCds.get(i).getPreco()) +" - " + verificadoAlugado);
						
						
					}
					
					
					
				} 
				
			}
			
			if (testeExiste == true){
				lblcampoObrigatorio.setVisible(true);
				JOptionPane.showMessageDialog(null,"Digite o nome da Banda");
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
			
			
			for(i = 0; i < listaCds.size(); i++){
				
				teste = getTextoDigitado().equalsIgnoreCase(listaCds.get(i).getGenero());
				
				if( teste == true){
					
					String verificadoAlugado;
					String verificadoReservado;
					
					if(listaCds.get(i).isLocado() == true){
						verificadoAlugado = "INDISPONIVEL";
					} else{
						verificadoAlugado = "DISPONIVEL";
					}
					
					if(listaCds.get(i).isReservado() == true){
						verificadoReservado = "RESERVADO";
					} else{
						verificadoReservado = "DISPONIVEL";
					}
					
					
					if(verificadoReservado.equalsIgnoreCase("DISPONIVEL")){
						comboBoxOpcoes.addItem(listaCds.get(i).getNomeBanda() + " - Album: " + listaCds.get(i).getAlbum() +" - R$ "+ String.valueOf(listaCds.get(i).getPreco()) +" - " + verificadoAlugado);
						
					}
					if(verificadoReservado.equalsIgnoreCase("RESERVADO") && verificadoAlugado.equalsIgnoreCase("DISPONIVEL")){
						comboBoxOpcoes.addItem(listaCds.get(i).getNomeBanda() + " - Album: " + listaCds.get(i).getAlbum() +" - R$ "+ String.valueOf(listaCds.get(i).getPreco()) +" - " + verificadoReservado);
						
						
					}
					if(verificadoReservado.equalsIgnoreCase("RESERVADO") && verificadoAlugado.equalsIgnoreCase("INDISPONIVEL")){
						comboBoxOpcoes.addItem(listaCds.get(i).getNomeBanda() + " - Album: " + listaCds.get(i).getAlbum() +" - R$ "+ String.valueOf(listaCds.get(i).getPreco()) +" - " + verificadoAlugado);
						
						
					}
					
					
					
				} 
				
			}
			
			if (testeExiste == true){
				lblcampoObrigatorio2.setVisible(true);
				JOptionPane.showMessageDialog(null,"Digite o nome da Banda");
			}
			
			
			
			
			
			
		}
	});
	
	
	
	JButton btnFechar = new JButton("Fechar");
	
	btnFechar.addActionListener(new ActionListener() {
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
					.addComponent(comboBoxOpcoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnBuscaPorGenero)
					.addComponent(lblBuscaPorGenero)
					.addComponent(btnBuscaPorTitulo)
					.addComponent(lblBuscaPorTitulo)
					.addGroup(layoutTelaBuscaCds.createSequentialGroup()
						.addGroup(layoutTelaBuscaCds.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(campoTextoGenero, Alignment.LEADING)
							.addComponent(campoTextoTitulo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
						.addGap(18)
						.addGroup(layoutTelaBuscaCds.createParallelGroup(Alignment.LEADING)
							.addComponent(lblcampoObrigatorio2)
							.addComponent(lblcampoObrigatorio))))
				.addGap(177))
			.addGroup(Alignment.TRAILING, layoutTelaBuscaCds.createSequentialGroup()
				.addContainerGap(341, Short.MAX_VALUE)
				.addComponent(btnFechar)
				.addGap(125))
	);
	layoutTelaBuscaCds.setVerticalGroup(
		layoutTelaBuscaCds.createParallelGroup(Alignment.LEADING)
			.addGroup(layoutTelaBuscaCds.createSequentialGroup()
				.addContainerGap()
				.addComponent(lblBuscaDeCds)
				.addGap(15)
				.addComponent(lblBuscaPorTitulo)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(layoutTelaBuscaCds.createParallelGroup(Alignment.BASELINE)
					.addComponent(campoTextoTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblcampoObrigatorio))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(btnBuscaPorTitulo)
				.addGap(18)
				.addComponent(lblBuscaPorGenero)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(layoutTelaBuscaCds.createParallelGroup(Alignment.BASELINE)
					.addComponent(campoTextoGenero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblcampoObrigatorio2))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(btnBuscaPorGenero)
				.addGap(18)
				.addComponent(comboBoxOpcoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
				.addComponent(btnFechar)
				.addContainerGap())
	);
	getContentPane().setLayout(layoutTelaBuscaCds);
		
	
	
	

	}
}
