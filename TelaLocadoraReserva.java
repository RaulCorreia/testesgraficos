import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class TelaLocadoraReserva extends JInternalFrame {
	private JTextField campoTextoNome;
	ArrayList< Filmes > listaFilmes = new ArrayList< Filmes >();
	ArrayList< Cds > listaCds = new ArrayList< Cds >();
	private ArrayList < Integer > Ids = new ArrayList < Integer >();
	private int quantidade = 0;
	private int idFilmeSelecionado = -1;
	private int idCdSelecionado = -1;
	
	
	
	
	
	
	
	public int getIdFilmeSelecionado() {
		return idFilmeSelecionado;
	}


	public void setIdFilmeSelecionado(int idFilmeSelecionado) {
		this.idFilmeSelecionado = idFilmeSelecionado;
	}


	public int getIdCdSelecionado() {
		return idCdSelecionado;
	}


	public void setIdCdSelecionado(int idCdSelecionado) {
		this.idCdSelecionado = idCdSelecionado;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}







	public TelaLocadoraReserva() throws NumberFormatException, IOException {
		
		
		//Ação ao mover a janela, voltar aonde estava
		addComponentListener(new ComponentAdapter() {
			public void componentMoved(ComponentEvent arg0) {
				setLocation(0, 0);
			}
		});
		
		//Reduz a barra
		putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
		
		setBounds(0, 0, 547, 389);
		
		
		//Carregando banco de dados
		File arq = new File("BancoDeFilmes.txt");
		FileReader reader = new FileReader(arq);
		BufferedReader ler = new BufferedReader(reader);
		String linha = "";
				
				
	//Carregando Dados dos filmes ----------------
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
		
	//----------Fim de carregamento Filmes
		
		
		
	//Carregando Dados do Cd----------------------

		arq = new File("BancoDeCds.txt");
		reader = new FileReader(arq);
		ler = new BufferedReader(reader);
				
				
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
		
	//----------------------------Fim De Carregamento Cd	
		
		
		
		

		
		
		//Campo de texto
		campoTextoNome = new JTextField();
		campoTextoNome.setColumns(10);
		
		
		//Label
		JLabel lblNome = new JLabel("Nome:");
		
		JLabel lblcampoObrigatorio = new JLabel("*Campo Obrigatorio");
		lblcampoObrigatorio.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblcampoObrigatorio.setVisible(false);
		
		
		//ComboBox
		JComboBox comboBoxOpcoes = new JComboBox();
		
		
		
		//Botoes
		JButton btnProcurar = new JButton("Procurar");
		
		
		JRadioButton selecaoFilme = new JRadioButton("Filmes");
		
		JRadioButton selecaoCd = new JRadioButton("Cds");
		
		
		ButtonGroup botaoDeSelecao = new ButtonGroup();
		botaoDeSelecao.add(selecaoFilme);
		botaoDeSelecao.add(selecaoCd);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.setEnabled(false);
		
		JButton btnFechar = new JButton("Fechar");
		
		
		
		
		
//-------------Inicio De Seleçoes
		
		
		selecaoFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				comboBoxOpcoes.removeAllItems();
				btnReservar.setEnabled(true);
				
				btnProcurar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						
						String nome = campoTextoNome.getText();
						int i;
						boolean teste = false;
						boolean testeDigitado2 = nome.isEmpty();
						
						
						
						for(i = 0; i < listaFilmes.size(); i++){
							
							teste = nome.equalsIgnoreCase(listaFilmes.get(i).getTitulo());
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
									setQuantidade(getQuantidade()+1);
									Ids.add(i);
								}
								if(verificadoReservado.equalsIgnoreCase("RESERVADO") && verificadoAlugado.equalsIgnoreCase("DISPONIVEL")){
									comboBoxOpcoes.addItem(listaFilmes.get(i).getTitulo() +" - R$ " + String.valueOf(listaFilmes.get(i).getPreco()) + " - Ano: " + listaFilmes.get(i).getAno() +" - " + verificadoReservado);
									setQuantidade(getQuantidade()+1);
									Ids.add(i);
									
								}
								if(verificadoReservado.equalsIgnoreCase("RESERVADO") && verificadoAlugado.equalsIgnoreCase("INDISPONIVEL")){
									comboBoxOpcoes.addItem(listaFilmes.get(i).getTitulo() +" - R$ " + String.valueOf(listaFilmes.get(i).getPreco()) + " - Ano: " + listaFilmes.get(i).getAno() +" - " + verificadoAlugado);
									setQuantidade(getQuantidade()+1);
									Ids.add(i);
									
								}
								
								
								
								
								
							}
							
						}
						
						//Testa se foi digitado
						if(testeDigitado2 == true){
							lblcampoObrigatorio.setVisible(true);
						}
						
						
						
						//------------------ Opcao Selecionada no ComboBox
						
						comboBoxOpcoes.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								for (int i = 0; i <= getQuantidade(); i++){
									
									if (comboBoxOpcoes.getSelectedIndex() == i){
										
										setIdFilmeSelecionado(Ids.get(i));
										
									}
										
								}
										
							}
							
						});
					
						
					
					
					}
				});
				
				
				//-------Botao Reservar
				
				btnReservar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						
						if(getIdFilmeSelecionado() != -1){
							
							listaFilmes.get(getIdFilmeSelecionado()).setReservado(true);
							JOptionPane.showMessageDialog(null, "Reserva Resgistrado com sucesso.");
							
							//Salvando Alterações Feitas ------
							File arquivo1;
							FileWriter writer1;
							PrintWriter escrever1;
							
							try {
								arquivo1 = new File ("BancoDeFilmes.txt");
								writer1 = new FileWriter(arquivo1, false);
								escrever1 = new PrintWriter(writer1);
															
								
								
								for(int i = 0; i < listaFilmes.size(); i++){
									
									escrever1.println(listaFilmes.get(i).gravarArquivo());
									
								}
								
							
								
								
								escrever1.close();
								writer1.close();
								
								
							
							} catch (FileNotFoundException e) {
								
								JOptionPane.showMessageDialog(null,"Arquivo Nao Foi Encontrado ou Nao Foi Aberto");
								
							} catch (IOException e) {
								
								JOptionPane.showMessageDialog(null,"Nao Foi Possivel Salvar as Alterações");
							}
							
							
							campoTextoNome.setText(null);
							comboBoxOpcoes.removeAllItems();
							setIdFilmeSelecionado(-1);
							setQuantidade(0);
							Ids.clear();
							
						}
						
						
					}
				});
				
				
					

				
				
			}
		}); //--------------- Fim de Aluguel Filmes
		
		
		
		
//-----------------Inicio Aluguel Cds
		
		selecaoCd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxOpcoes.removeAllItems();
				btnProcurar.setEnabled(true);
				
				btnProcurar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String nome = campoTextoNome.getText();
						int i;
						boolean teste = false;
						boolean testeDigitado3 = nome.isEmpty();
						
						
						
						for(i = 0; i < listaCds.size(); i++){
							
							teste = nome.equalsIgnoreCase(listaCds.get(i).getNomeBanda());
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
									setQuantidade(getQuantidade()+1);
									Ids.add(i);
								}
								if(verificadoReservado.equalsIgnoreCase("RESERVADO") && verificadoAlugado.equalsIgnoreCase("DISPONIVEL")){
									comboBoxOpcoes.addItem(listaCds.get(i).getNomeBanda() + " - Album: " + listaCds.get(i).getAlbum() +" - R$ "+ String.valueOf(listaCds.get(i).getPreco()) +" - " + verificadoReservado);
									setQuantidade(getQuantidade()+1);
									Ids.add(i);
									
								}
								if(verificadoReservado.equalsIgnoreCase("RESERVADO") && verificadoAlugado.equalsIgnoreCase("INDISPONIVEL")){
									comboBoxOpcoes.addItem(listaCds.get(i).getNomeBanda() + " - Album: " + listaCds.get(i).getAlbum() +" - R$ "+ String.valueOf(listaCds.get(i).getPreco()) +" - " + verificadoAlugado);
									setQuantidade(getQuantidade()+1);
									Ids.add(i);
									
								}
								
								
								
							}
							
						}
						
						
						if(testeDigitado3 == true){
							lblcampoObrigatorio.setVisible(true);

						}
						
						
						
						//------------------ Opcao Selecionada no ComboBox
						
						comboBoxOpcoes.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								
								for (int i = 0; i <= getQuantidade(); i++){
									
									if (comboBoxOpcoes.getSelectedIndex() == i){
										
										setIdCdSelecionado(Ids.get(i));
										
									}
										
								}
										
							}
							
						});
						
						
						
						
					}
				}); //Fim da ação ao apertar buscar cd
				
				
				
				
				
				
				//-------Botao Alugar
				
				btnReservar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						
						if(getIdCdSelecionado() != -1){
							
							listaCds.get(getIdCdSelecionado()).setReservado(true);
							JOptionPane.showMessageDialog(null, "Reserva Resgistrado com sucesso.");
							
							//Salvando Alterações Feitas ------
							File arquivo;
							FileWriter writer;
							PrintWriter escrever;
							
							try {
								arquivo = new File ("BancoDeCds.txt");
								writer = new FileWriter(arquivo, false);
								escrever = new PrintWriter(writer);
								
								for(int i = 0; i < listaCds.size(); i++){
									
									escrever.println(listaCds.get(i).gravarArquivo());
									
								}
							
								
								
								escrever.close();
								writer.close();
								
							
							} catch (FileNotFoundException e) {
								
								JOptionPane.showMessageDialog(null,"Arquivo Nao Foi Encontrado ou Nao Foi Aberto");
								
							} catch (IOException e) {
								
								JOptionPane.showMessageDialog(null,"Nao Foi Possivel Salvar");
							}
							
							campoTextoNome.setText(null);
							comboBoxOpcoes.removeAllItems();
							setIdCdSelecionado(-1);
							setQuantidade(0);
							Ids.clear();
							
						}
						
						
					}
				});
				
				
				
				
				
				
			}
		});//------------------------------------Fim Aluguel Cds
		
		
		
		
		
		
		
		
		
		
		
		
		
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaLocadoraReserva.this.dispose();
				
			}
		});
		
		
		
		
		
		
		//Alinhamento do Layout
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(lblNome)
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBoxOpcoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnReservar)
								.addPreferredGap(ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
								.addComponent(btnFechar)
								.addGap(39))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(selecaoFilme)
										.addGap(60)
										.addComponent(selecaoCd))
									.addComponent(btnProcurar)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(campoTextoNome, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
										.addGap(58)
										.addComponent(lblcampoObrigatorio)))
								.addContainerGap(41, Short.MAX_VALUE)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(selecaoFilme)
						.addComponent(selecaoCd))
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome)
						.addComponent(lblcampoObrigatorio))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnProcurar)
					.addGap(43)
					.addComponent(comboBoxOpcoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReservar)
						.addComponent(btnFechar))
					.addGap(24))
		);
		getContentPane().setLayout(groupLayout);
		
		
		
		

	}
}
