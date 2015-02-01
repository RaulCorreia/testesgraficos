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

import javax.swing.JLabel;



public class TelaLocadoraAluguel extends JInternalFrame {
	private JTextField campoTextoNome;
	private JTextField campoTextCliente;
	private boolean selecao;
	File arq;
	FileReader reader;
	BufferedReader ler;
	
	

	public boolean isSelecao() {
		return selecao;
	}



	public void setSelecao(boolean selecao) {
		this.selecao = selecao;
	}



	public TelaLocadoraAluguel() throws FileNotFoundException {
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
		campoTextoNome = new JTextField();
		campoTextoNome.setColumns(10);
		
		campoTextCliente = new JTextField();
		campoTextCliente.setColumns(10);
		
		
		//Labels
		JLabel lblNomeFilme = new JLabel("Nome do Filme:");
		
		
		
		//Escolha do que alugar
		JRadioButton selecaoFilme = new JRadioButton("Filme", false);
		
		JRadioButton selecaoCd = new JRadioButton("Cd", false);
		
		ButtonGroup botaoDeSelecao = new ButtonGroup();
		botaoDeSelecao.add(selecaoFilme);
		botaoDeSelecao.add(selecaoCd);
		
		if(selecaoFilme.isSelected()){
			
			reader = new FileReader("BancoDeFilmes.txt");
			ler = new BufferedReader(reader);
			char letra;
			String palavra = "";
			
			try {
				while ((letra = (char) ler.read()) != '|'){
					
					palavra = palavra + letra;
					
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,"Nao Foi Possivel Ler");
			}
			
			JOptionPane.showMessageDialog(null,palavra);
		}
		if(selecaoCd.isSelected()){
			
		}
		
		
		
		
		
		
		
		
		
		//Alinhamento do Layout
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(109)
							.addComponent(selecaoFilme)
							.addGap(95)
							.addComponent(selecaoCd))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(lblNomeFilme)
							.addGap(46)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(campoTextCliente, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
								.addComponent(campoTextoNome, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))))
					.addContainerGap(180, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(selecaoFilme)
						.addComponent(selecaoCd))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTextoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNomeFilme))
					.addGap(53)
					.addComponent(campoTextCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(187, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		
		

	}
}
