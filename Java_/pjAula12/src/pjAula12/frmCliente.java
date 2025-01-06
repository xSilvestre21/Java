package pjAula12;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class frmCliente extends JFrame implements ActionListener {
	
	// 1 Passo - Declaração dos Objetos
	JLabel lbNome, lbCNPJ, lbTelefone, lbStatus;
	JTextField txtNome;
	JFormattedTextField txtCNPJ, txtTelefone;
	JComboBox <String>cbxStatus;
	MaskFormatter mascaraCNPJ, mascaraTelefone;
	String status[] = {"Ativo", "Inativo"};
	JButton btCadastrar, btLimpar, btSair, btConsultar;
	JPanel pnCampos, pnBotoes;
	BorderLayout layout;
	GridLayout gridCampos, gridBotoes;
	File arquivo = new File("Clientes.txt");
	
	public frmCliente() {
		setTitle("Cadastro de Clientes");
		setLayout(layout = new BorderLayout());
		setSize(400, 300);
		setLocation(50, 50); // Posição em que exibe
		
		// 2 Passo Instanciação dos objetos
		pnCampos = new JPanel();
		pnBotoes = new JPanel();
		gridCampos = new GridLayout(4, 2);
		gridBotoes = new GridLayout(1, 4);
		lbNome = new JLabel("Razão Social ");
		lbCNPJ = new JLabel("CNPJ ");
		lbTelefone = new JLabel("Telefone ");
		lbStatus = new JLabel("Status ");
		
		txtNome = new JTextField(20);
		try {
			mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
			mascaraTelefone = new MaskFormatter("(##)#####-####");
		}catch(ParseException e) {
			System.err.println("Falha na máscara");
		}
		
		txtCNPJ = new JFormattedTextField(mascaraCNPJ);
		txtTelefone = new JFormattedTextField(mascaraTelefone);
		
		cbxStatus = new JComboBox<String>(status);
		
		btCadastrar = new JButton("Cadastrar");
		btCadastrar.setMnemonic('C');
		btCadastrar.setToolTipText("Cadastra um cliente");
		btCadastrar.addActionListener(this);
		
		btLimpar = new JButton("Limpar");
		btLimpar.setMnemonic('L');
		btLimpar.setToolTipText("Limpa os campos");
		btLimpar.addActionListener(this);
		
		btSair = new JButton("Sair");
		btSair.setMnemonic('S');
		btSair.setToolTipText("Sai do cadastro");
		btSair.addActionListener(this);
		
		btConsultar = new JButton("Consultar");
		btConsultar.setMnemonic('t');
		btConsultar.setToolTipText("Consulta o cadastro");
		btConsultar.addActionListener(this);
		
		pnCampos.setLayout(gridCampos);
		pnBotoes.setLayout(gridBotoes);
		
		// 3 Passo adicionar os campos a Frame
		pnCampos.add(lbNome);
		pnCampos.add(txtNome);
		pnCampos.add(lbCNPJ);
		pnCampos.add(txtCNPJ);
		pnCampos.add(lbTelefone);
		pnCampos.add(txtTelefone);
		pnCampos.add(lbStatus);
		pnCampos.add(cbxStatus);
		add(pnCampos, BorderLayout.NORTH);
		
		pnBotoes.add(btCadastrar);
		pnBotoes.add(btLimpar);
		pnBotoes.add(btConsultar);
		pnBotoes.add(btSair);
		add(pnBotoes, BorderLayout.SOUTH);
		
		setResizable(false);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btCadastrar) {
			try {
				// Se o aruivo não existir, cria.
				if(!arquivo.exists()) {
					OutputStream fO = new FileOutputStream("Clientes.txt");
				}
				
				PrintWriter out = new PrintWriter(new FileWriter(arquivo, true));
				out.print(txtNome.getText());
				out.print(" | ");
				out.print(txtCNPJ.getText());
				out.print(" | ");
				out.print(txtTelefone.getText());
				out.print(" | ");
				out.print(status[cbxStatus.getSelectedIndex()]);
				out.close();	
				
				JOptionPane.showMessageDialog(null,
						"Inclusão realizada com sucesso!",
						"Inclusão no Arquivo Texto",
						JOptionPane.INFORMATION_MESSAGE);
				setLimpar();
			}catch(IOException erro) {
			JOptionPane.showMessageDialog(null,
					"Erro na manipulação do Arquivo Texto." 
					+ erro,
					"Erro no Arquivo Texto",
					JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() == btLimpar) {
			setLimpar();
		}
		//https://gtihub.com/berretuino/poo
		if(e.getSource() == btConsultar) {
			frmConsulta consulta = new frmConsulta(arquivo);
			consulta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		if(e.getSource() == btSair) {
			System.exit(0);
		}
			
		
		
	}
	
	public void setLimpar() {
		txtNome.setText("");
		txtCNPJ.setText("");
		txtTelefone.setText("");
		cbxStatus.setSelectedIndex(0);
		txtNome.requestFocus();
	}
	public static void main(String[] args) {
		frmCliente frm = new frmCliente();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
