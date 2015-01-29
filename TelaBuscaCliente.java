import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TelaBuscaCliente extends JInternalFrame {
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private String textoDigitado;


	public String getTextoDigitado() {
		return textoDigitado;
	}


	public void setTextoDigitado(String textoDigitado) {
		this.textoDigitado = textoDigitado;
	}


	public TelaBuscaCliente() {
		setBounds(10, 10, 400, 359);
		
		JLabel lblBuscaDeClientes = new JLabel("Busca de Clientes");
		lblBuscaDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscaDeClientes.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblBuscaPorNome = new JLabel("Busca Por Nome:");
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		
		JButton btnBuscaPorNome = new JButton("Busca Por Nome");
		
		btnBuscaPorNome.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				
				textoDigitado = textFieldNome.getText();
				
			}
		});
		
		JLabel lblBuscaPorCpf = new JLabel("Busca Por Cpf:");
		
		textFieldCpf = new JTextField();
		textFieldCpf.setColumns(10);
		
		JButton btnBuscaPorCpf = new JButton("Busca Por Cpf");
		
		btnBuscaPorCpf.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				
				textoDigitado = textFieldCpf.getText();
			}
		});
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				
				TelaBuscaCliente.this.dispose();
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textFieldNome, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
						.addComponent(lblBuscaPorNome)
						.addComponent(btnBuscaPorNome)
						.addComponent(lblBuscaPorCpf)
						.addComponent(textFieldCpf)
						.addComponent(btnBuscaPorCpf))
					.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
					.addComponent(btnFechar)
					.addGap(21))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(116)
					.addComponent(lblBuscaDeClientes, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(125, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblBuscaDeClientes, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(lblBuscaPorNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBuscaPorNome)
					.addGap(61)
					.addComponent(lblBuscaPorCpf)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldCpf, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBuscaPorCpf)
					.addContainerGap(45, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(284, Short.MAX_VALUE)
					.addComponent(btnFechar)
					.addGap(23))
		);
		getContentPane().setLayout(groupLayout);

	}
}
