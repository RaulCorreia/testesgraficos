import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;

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

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;


public class TelaLocadoraDevolucao extends JInternalFrame {

	ArrayList< Cliente > clientes = new ArrayList< Cliente >();
	ArrayList< Cds > listaCds = new ArrayList< Cds >();
	ArrayList< Filmes > listaFilmes = new ArrayList< Filmes >();	
	ArrayList < Integer > Ids = new ArrayList < Integer >();
	private JTextField campoTextoNome;
	private JTextField campoTextCliente;
	private int idClienteSelecionado = -1;
	private int quantidade = 0;
	private int idFilmeSelecionado = -1;
	private int idCdSelecionado = -1;
	
	
	

	
	
	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


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


	public int getIdClienteSelecionado() {
		return idClienteSelecionado;
	}


	public void setIdClienteSelecionado(int idClienteSelecionado) {
		this.idClienteSelecionado = idClienteSelecionado;
	}









	public TelaLocadoraDevolucao() throws NumberFormatException, IOException {
		
		
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
				
				
				
		//Carregando Dados dos Clientes
		arq = new File("BancoDeClientes.txt");
		reader = new FileReader(arq);
		ler = new BufferedReader(reader);
				
		while ((linha = ler.readLine()) != null){
			Cliente cliente;
					
			String[] partes = linha.split("-");
					
			cliente = new Cliente(partes[0], partes[1], partes[2], partes[4]);
			cliente.setSaldo(Float.parseFloat(partes[3]));
					
			clientes.add(cliente);
					
					
		}
				
		ler.close();
		reader.close();
				
				
				
		//Carregando Dados dos Cds
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
		
		
		
		//Campo de Texto
		campoTextoNome = new JTextField();
		campoTextoNome.setColumns(10);
		
		campoTextCliente = new JTextField();
		campoTextCliente.setColumns(10);
		
		JTextArea textAreaCliente = new JTextArea();
		
		//Labels
		JLabel lblNomeFilmeBanda = new JLabel("Nome Filme/Banda");
		
		JLabel lblNomeCliente = new JLabel("Nome Cliente");
		
		JLabel lblCliente = new JLabel("Cliente");
		
		JLabel lblcampoObrigatorio = new JLabel("*Campo Obrigatorio");
		lblcampoObrigatorio.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblcampoObrigatorio.setVisible(false);
		
		
		JLabel lblcampoObrigatorio2 = new JLabel("*Campo Obrigatorio");
		lblcampoObrigatorio2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblcampoObrigatorio2.setVisible(false);
		
		
		//BOTOES DE SELECAO
		JRadioButton selecaoFilme = new JRadioButton("Filme");
		
		JRadioButton selecaoCd = new JRadioButton("Cds");
		
		ButtonGroup botaoDeSelecao = new ButtonGroup();
		botaoDeSelecao.add(selecaoFilme);
		botaoDeSelecao.add(selecaoCd);
		
		
		//COMBO BOX
		JComboBox comboBoxOpcoes = new JComboBox();
		
		
		
		//Botoes
		JButton btnBuscarFilmeBanda = new JButton("Buscar Filme/Cd");
		btnBuscarFilmeBanda.setEnabled(false);
		
		JButton btnBuscarCliente = new JButton("Buscar Cliente");
		
		JButton btnDevolucao = new JButton("Devolu\u00E7\u00E3o/Remover Reserva");
		
		
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLocadoraDevolucao.this.dispose();
				
			}
		});
		
		
		
		
		
		
		
		
		//BUSCAR CLIENTE
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				
				String nome = campoTextCliente.getText();
				int i;
				boolean teste = false;
				boolean testeDigitado1 = nome.isEmpty();
				
				
				for(i = 0; i < clientes.size(); i++){
					
					teste = nome.equalsIgnoreCase(clientes.get(i).getNome());
					if( teste == true){
						
						textAreaCliente.setText(clientes.get(i).getNome() + " - Cpf: " + clientes.get(i).getCpf() + " - A PAGAR: " + clientes.get(i).getSaldo() + " R$");
						lblCliente.setVisible(true);
						textAreaCliente.setVisible(true);
						setIdClienteSelecionado(i);
						break;
					}
					
				}
				
				
				if(testeDigitado1 == true){
					lblcampoObrigatorio2.setVisible(true);

				}
				
				
				
			}
		});
		

		//FIM DE BUSCA CLIENTE
		
		
		
		
		
		
		//SELECIONAR FILMES
		
		selecaoFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				comboBoxOpcoes.removeAllItems();
				btnBuscarFilmeBanda.setEnabled(true);
				
				btnBuscarFilmeBanda.addActionListener(new ActionListener() {
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
									verificadoAlugado = "ALUGADO";
								} else{
									verificadoAlugado = "DISPONIVEL";
								}
								
								if(listaFilmes.get(i).isReservado() == true){
									verificadoReservado = "RESERVADO";
								} else{
									verificadoReservado = "DISPONIVEL";
								}
								
								if(verificadoReservado.equalsIgnoreCase("RESERVADO")){
									comboBoxOpcoes.addItem(listaFilmes.get(i).getTitulo() +" - Ano: " + listaFilmes.get(i).getAno() +" - " + verificadoReservado);
									setQuantidade(getQuantidade()+1);
									Ids.add(i);
								}
								if(verificadoAlugado.equalsIgnoreCase("ALUGADO")){
									comboBoxOpcoes.addItem(listaFilmes.get(i).getTitulo() +" - Ano: " + listaFilmes.get(i).getAno() +" - " + verificadoAlugado);
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
							public void actionPerformed(ActionEvent evt) {
								
								for (int i = 0; i <= getQuantidade(); i++){
									
									if (comboBoxOpcoes.getSelectedIndex() == i){
										
										setIdFilmeSelecionado(Ids.get(i));
										
									}
										
								}
										
							}
							
						});
					
						
					
					
					}
				});
				
				
				//-------Botao DEVOLUÇÃO
				
				btnDevolucao.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				
						
						if(getIdFilmeSelecionado() != -1 && getIdClienteSelecionado() != -1){
							
							listaFilmes.get(getIdFilmeSelecionado()).setLocado(false);
							listaFilmes.get(getIdFilmeSelecionado()).setReservado(false);
							clientes.get(getIdClienteSelecionado()).setSaldo(clientes.get(getIdClienteSelecionado()).getSaldo() - listaFilmes.get(getIdFilmeSelecionado()).getPreco());
							JOptionPane.showMessageDialog(null, "Entrega Registrada");
							
							//Salvando Alterações Feitas ------
							File arquivo1, arquivo2;
							FileWriter writer1, writer2;
							PrintWriter escrever1, escrever2;
							
							try {
								arquivo1 = new File ("BancoDeFilmes.txt");
								writer1 = new FileWriter(arquivo1, false);
								escrever1 = new PrintWriter(writer1);
								
								arquivo2 = new File ("BancoDeClientes.txt");
								writer2 = new FileWriter(arquivo2, false);
								escrever2 = new PrintWriter(writer2);
								
								
								
								for(int i = 0; i < listaFilmes.size(); i++){
									
									escrever1.println(listaFilmes.get(i).gravarArquivo());
									
								}
								for(int i = 0; i < clientes.size(); i++){
									
									escrever2.println(clientes.get(i).gravarArquivo());
								}
							
								
								
								escrever1.close();
								writer1.close();
								escrever2.close();
								writer2.close();
								
							
							} catch (FileNotFoundException evt) {
								
								JOptionPane.showMessageDialog(null,"Arquivo Nao Foi Encontrado ou Nao Foi Aberto");
								
							} catch (IOException evt) {
								
								JOptionPane.showMessageDialog(null,"Nao Foi Possivel Salvar as Alterações");
							}
							
							campoTextCliente.setText(null);
							campoTextoNome.setText(null);
							comboBoxOpcoes.removeAllItems();
							lblCliente.setVisible(false);
							textAreaCliente.setVisible(false);
							lblcampoObrigatorio.setVisible(false);
							Ids.clear();
							setIdClienteSelecionado(-1);
							setIdFilmeSelecionado(-1);
							setQuantidade(0);
							
						}
						
						
					}
				});
				
				
					
			}
		});
		
		
		//------------------------ FIM de devolução filme
		
		
		
		
		
		
		
		
		//DEVOLVER Cds----------------------------
		
		selecaoCd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				comboBoxOpcoes.removeAllItems();
				btnBuscarFilmeBanda.setEnabled(true);
				
				btnBuscarFilmeBanda.addActionListener(new ActionListener() {
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
									verificadoAlugado = "ALUGADO";
								} else{
									verificadoAlugado = "DISPONIVEL";
								}
										
								if(listaCds.get(i).isReservado() == true){
									verificadoReservado = "RESERVADO";
								} else{
									verificadoReservado = "DISPONIVEL";
								}
										
										
								if(verificadoReservado.equalsIgnoreCase("RESERVADO")){
									comboBoxOpcoes.addItem(listaCds.get(i).getNomeBanda() + " - Album: " + listaCds.get(i).getAlbum() +" - " + verificadoReservado);
									setQuantidade(getQuantidade()+1);
									Ids.add(i);
								}
								if(verificadoAlugado.equalsIgnoreCase("ALUGADO")){
									comboBoxOpcoes.addItem(listaCds.get(i).getNomeBanda() + " - Album: " + listaCds.get(i).getAlbum() +" - " + verificadoAlugado);
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
				}); 
						
						
						
						
						
						
				//-------Botao DEVOLUÇÃO
						
				btnDevolucao.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
							
						if(getIdCdSelecionado() != -1 && getIdClienteSelecionado() != -1){
								
							listaCds.get(getIdCdSelecionado()).setLocado(false);
							listaCds.get(getIdCdSelecionado()).setReservado(false);
							clientes.get(getIdClienteSelecionado()).setSaldo(clientes.get(getIdClienteSelecionado()).getSaldo() - listaCds.get(getIdCdSelecionado()).getPreco());
							JOptionPane.showMessageDialog(null, "Entrega Registrada");
									
							//Salvando Alterações Feitas ------
							File arquivo1, arquivo2;
							FileWriter writer1, writer2;
							PrintWriter escrever1, escrever2;
									
							try {
								arquivo1 = new File ("BancoDeCds.txt");
								writer1 = new FileWriter(arquivo1, false);
								escrever1 = new PrintWriter(writer1);
										
								arquivo2 = new File ("BancoDeClientes.txt");
								writer2 = new FileWriter(arquivo2, false);
								escrever2 = new PrintWriter(writer2);
										
								for(int i = 0; i < listaCds.size(); i++){
											
									escrever1.println(listaCds.get(i).gravarArquivo());
											
								}
								for(int i = 0; i < clientes.size(); i++){
											
									escrever2.println(clientes.get(i).gravarArquivo());
								}
									
										
										
								escrever1.close();
								writer1.close();
										
									
							} catch (FileNotFoundException e) {
										
								JOptionPane.showMessageDialog(null,"Arquivo Nao Foi Encontrado ou Nao Foi Aberto");
										
							} catch (IOException e) {
										
								JOptionPane.showMessageDialog(null,"Nao Foi Possivel Salvar");
							}
									
							campoTextCliente.setText(null);
							campoTextoNome.setText(null);
							comboBoxOpcoes.removeAllItems();
							lblCliente.setVisible(false);
							textAreaCliente.setVisible(false);
							Ids.clear();
							setIdClienteSelecionado(-1);
							setIdCdSelecionado(-1);
							setQuantidade(0);
									
						}
								
								
					}
				});
							
						
						
						
						
					}
				});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Alinhamento do layout
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(56)
							.addComponent(comboBoxOpcoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNomeCliente)
										.addComponent(lblNomeFilmeBanda))
									.addGap(37)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnBuscarCliente)
										.addComponent(btnBuscarFilmeBanda)
										.addComponent(campoTextCliente, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
										.addComponent(campoTextoNome))
									.addGap(39)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblcampoObrigatorio2)
										.addComponent(lblcampoObrigatorio)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblCliente)
									.addGap(34)
									.addComponent(textAreaCliente, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(138)
							.addComponent(selecaoFilme)
							.addGap(83)
							.addComponent(selecaoCd)))
					.addContainerGap(73, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(159)
					.addComponent(btnDevolucao)
					.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
					.addComponent(btnFechar)
					.addGap(29))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(selecaoFilme)
						.addComponent(selecaoCd))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeFilmeBanda)
						.addComponent(campoTextoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblcampoObrigatorio))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(btnBuscarFilmeBanda)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeCliente)
						.addComponent(campoTextCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblcampoObrigatorio2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBuscarCliente)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCliente)
						.addComponent(textAreaCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(comboBoxOpcoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDevolucao)
						.addComponent(btnFechar))
					.addGap(26))
		);
		getContentPane().setLayout(groupLayout);

	}
}
