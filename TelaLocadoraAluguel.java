import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.awt.Font;




public class TelaLocadoraAluguel extends JInternalFrame {
	private JTextField campoTextoNome;
	private JTextField campoTextCliente;
	private boolean selecao;
	ArrayList< Cliente > clientes = new ArrayList< Cliente >();
	ArrayList< Cds > listaCds = new ArrayList< Cds >();
	ArrayList< Filmes > listaFilmes = new ArrayList< Filmes >();
	File arq;
	FileReader reader;
	BufferedReader ler;
	private int idFilmeSelecionado = -1;
	private int idCdSelecionado = -1;
	private int idClienteSelecionado = -1;
	private int quantidade = 0;
	private ArrayList < Integer > Ids = new ArrayList < Integer >();

	
	
	



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



	public int getIdFilmeSelecionado() {
		return idFilmeSelecionado;
	}



	public void setIdFilmeSelecionado(int idFilmeSelecionado) {
		this.idFilmeSelecionado = idFilmeSelecionado;
	}



	public int getIdClienteSelecionado() {
		return idClienteSelecionado;
	}



	public void setIdClienteSelecionado(int idClienteSelecionado) {
		this.idClienteSelecionado = idClienteSelecionado;
	}




	public boolean isSelecao() {
		return selecao;
	}



	public void setSelecao(boolean selecao) {
		this.selecao = selecao;
	}



	public TelaLocadoraAluguel() throws NumberFormatException, IOException {
		//Ação ao mover a janela, voltar aonde estava
		addComponentListener(new ComponentAdapter() {
			public void componentMoved(ComponentEvent evt) {
				setLocation(0, 0);
			}
		});
				
		//Reduz a barra
		putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
				
		setBounds(0, 0, 547, 389);
		
		
		
		//Carregando banco de dados
		arq = new File("BancoDeFilmes.txt");
		reader = new FileReader(arq);
		ler = new BufferedReader(reader);
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
		
		
		
		//ComboBox com as Escolhas
		JComboBox comboBoxOpcoes = new JComboBox();
		
		
		//Espaços de Texto
		campoTextoNome = new JTextField();
		campoTextoNome.setColumns(10);
		
		campoTextCliente = new JTextField();
		campoTextCliente.setColumns(10);
		
		JTextPane textoNomeClienteSelecionado = new JTextPane();
		textoNomeClienteSelecionado.setVisible(false);
		
		
		//Labels
		JLabel lblNome = new JLabel("Nome do Filme/Banda:");
		JLabel lblNomeCliente = new JLabel("Nome Cliente:");
		JLabel lblClienteSelecionado = new JLabel("Cliente Selecionado:");
		lblClienteSelecionado.setVisible(false);
		
		JLabel lblcampoObrigatorio = new JLabel("*Campo Obrigatorio");
		lblcampoObrigatorio.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblcampoObrigatorio.setVisible(false);
		
		JLabel lblcampoObrigatorio2 = new JLabel("*Campo Obrigatorio");
		lblcampoObrigatorio2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblcampoObrigatorio2.setVisible(false);
		
		
		//Escolha do que alugar
		JRadioButton selecaoFilme = new JRadioButton("Filme", false);
		
		JRadioButton selecaoCd = new JRadioButton("Cd", false);
		
		
		ButtonGroup botaoDeSelecao = new ButtonGroup();
		botaoDeSelecao.add(selecaoFilme);
		botaoDeSelecao.add(selecaoCd);
		
		
		//Botoes
		
		JButton btnAlugar = new JButton("Alugar");
		
	
		JButton btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = campoTextCliente.getText();
				int i;
				boolean teste = false;
				boolean testeDigitado1 = nome.isEmpty();
				
				
				for(i = 0; i < clientes.size(); i++){
					
					teste = nome.equalsIgnoreCase(clientes.get(i).getNome());
					if( teste == true){
						
						textoNomeClienteSelecionado.setText(clientes.get(i).getNome() + " - Cpf: " + clientes.get(i).getCpf() + " - Devendo: " + clientes.get(i).getSaldo() + " R$");
						lblClienteSelecionado.setVisible(true);
						textoNomeClienteSelecionado.setVisible(true);
						setIdClienteSelecionado(i);
						break;
					}
					
				}
				
				
				if(testeDigitado1 == true){
					lblcampoObrigatorio2.setVisible(true);

				}
				
				
				
				
			}
		});
		
		
		JButton btnBuscarFilmebanda = new JButton("Buscar Filme/Banda");
		btnBuscarFilmebanda.setEnabled(false);
		
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLocadoraAluguel.this.dispose();
			}
		});
		
		
		
		
		//Seleção do Tipo de produto
		
	//Alugar Filmes------------------------------
		
		selecaoFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				comboBoxOpcoes.removeAllItems();
				btnBuscarFilmebanda.setEnabled(true);
				
				btnBuscarFilmebanda.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						
						comboBoxOpcoes.removeAllItems();
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
				
				
				//-------Botao Alugar
				
				btnAlugar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						
						if(getIdFilmeSelecionado() != -1 && getIdClienteSelecionado() != -1){
							
							listaFilmes.get(getIdFilmeSelecionado()).setLocado(true);
							listaFilmes.get(getIdFilmeSelecionado()).setReservado(false);
							clientes.get(getIdClienteSelecionado()).setSaldo( clientes.get(getIdClienteSelecionado()).getSaldo() + listaFilmes.get(getIdFilmeSelecionado()).getPreco());
							JOptionPane.showMessageDialog(null, "Aluguel Resgistrado com sucesso.\nDevolução: 3 Dias Uteis\nValor a ser pago: R$ " + listaFilmes.get(getIdFilmeSelecionado()).getPreco());
							
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
								
							
							} catch (FileNotFoundException e) {
								
								JOptionPane.showMessageDialog(null,"Arquivo Nao Foi Encontrado ou Nao Foi Aberto");
								
							} catch (IOException e) {
								
								JOptionPane.showMessageDialog(null,"Nao Foi Possivel Salvar as Alterações");
							}
							
							campoTextCliente.setText(null);
							campoTextoNome.setText(null);
							comboBoxOpcoes.removeAllItems();
							lblClienteSelecionado.setVisible(false);
							textoNomeClienteSelecionado.setVisible(false);
							lblcampoObrigatorio.setVisible(false);
							lblcampoObrigatorio2.setVisible(false);
							Ids.clear();
							setIdClienteSelecionado(-1);
							setIdFilmeSelecionado(-1);
							setQuantidade(0);
							
						}
						
						
					}
				});
				
				
					
			}
		});
		//------------------------ FIM de alugar Filmes
		
		
		
		
		
	//Alugar Cds----------------------------
		
		selecaoCd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBoxOpcoes.removeAllItems();
				btnBuscarFilmebanda.setEnabled(true);
				
				btnBuscarFilmebanda.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						
						comboBoxOpcoes.removeAllItems();
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
				
				btnAlugar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						
						if(getIdCdSelecionado() != -1 && getIdClienteSelecionado() != -1){
							
							listaCds.get(getIdCdSelecionado()).setLocado(true);
							listaCds.get(getIdCdSelecionado()).setReservado(false);
							clientes.get(getIdClienteSelecionado()).setSaldo(clientes.get(getIdClienteSelecionado()).getSaldo() + listaCds.get(getIdCdSelecionado()).getPreco());
							JOptionPane.showMessageDialog(null, "Aluguel Resgistrado com sucesso.\nDevolução: 3 Dias Uteis\nValor a ser pago: R$ " + listaCds.get(getIdCdSelecionado()).getPreco());
							
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
								escrever2.close();
								writer2.close();
								
							
							} catch (FileNotFoundException e) {
								
								JOptionPane.showMessageDialog(null,"Arquivo Nao Foi Encontrado ou Nao Foi Aberto");
								
							} catch (IOException e) {
								
								JOptionPane.showMessageDialog(null,"Nao Foi Possivel Salvar");
							}
							
							campoTextCliente.setText(null);
							campoTextoNome.setText(null);
							comboBoxOpcoes.removeAllItems();
							lblClienteSelecionado.setVisible(false);
							textoNomeClienteSelecionado.setVisible(false);
							lblcampoObrigatorio.setVisible(false);
							lblcampoObrigatorio2.setVisible(false);
							Ids.clear();
							setIdClienteSelecionado(-1);
							setIdCdSelecionado(-1);
							setQuantidade(0);
							
						}
						
						
					}
				});
					
				
				
				
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Alinhamento do Layout
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(156)
					.addComponent(selecaoFilme)
					.addGap(43)
					.addComponent(selecaoCd)
					.addContainerGap(244, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(262, Short.MAX_VALUE)
					.addComponent(btnAlugar)
					.addGap(123)
					.addComponent(btnFechar)
					.addGap(18))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(85)
					.addComponent(comboBoxOpcoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(418, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblClienteSelecionado)
						.addComponent(lblNomeCliente)
						.addComponent(lblNome))
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnBuscarFilmebanda)
								.addContainerGap())
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnBuscarCliente)
									.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(campoTextCliente, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
										.addComponent(campoTextoNome, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblcampoObrigatorio2)
										.addComponent(lblcampoObrigatorio))
									.addGap(39))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textoNomeClienteSelecionado, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
							.addGap(65))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(selecaoFilme)
						.addComponent(selecaoCd))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome)
						.addComponent(lblcampoObrigatorio))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBuscarFilmebanda)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNomeCliente)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(campoTextCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblcampoObrigatorio2)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnBuscarCliente)
							.addGap(13)
							.addComponent(textoNomeClienteSelecionado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblClienteSelecionado))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboBoxOpcoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFechar)
						.addComponent(btnAlugar))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		
		
		

	}
}
