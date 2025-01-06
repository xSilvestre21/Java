package adc1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Veiculo extends JFrame implements ActionListener{

	JButton btCadastrar, btAlterar, btExcluir, btPesquisar, btLimpar, btSair;
	JTextField txtPlaca, txtModelo, txtAno, txtData, txtValor;	
	JLabel lbPlaca, lbModelo, lbAno, lbData, lbValor, lbFabricante;
	JPanel pnCampos, pnCampos2, pnCampos3, pnBotoes;
	JComboBox<String> cmbFabricante = new JComboBox<>();
	public Veiculo() {
		super("Controle de Frota - Cadastro de Veículos");
		setSize(600, 200);
		setLayout(new BorderLayout());
		
	
		txtPlaca = new JTextField(20);
		txtModelo = new JTextField(20);
		cmbFabricante = new JComboBox<String>();
		cmbFabricante.addItem("CHEVROLET");
		txtAno = new JTextField(20);
		txtData = new JTextField("13/03/2024", 20);
		txtValor = new JTextField(20);
		
		lbPlaca = new JLabel("Placa");
		lbModelo = new JLabel("Modelo");
		lbAno = new JLabel("Ano");
		lbData = new JLabel("Data Compra");
		lbValor = new JLabel("Valor (R$)");
		lbFabricante = new JLabel("Fabricante")
				;
		btCadastrar = new JButton("Cadastrar");
		btCadastrar.setMnemonic(KeyEvent.VK_C);
		btAlterar = new JButton("Alterar");
		btAlterar.setMnemonic(KeyEvent.VK_A);
		btExcluir = new JButton("Excluir");
		btExcluir.setMnemonic(KeyEvent.VK_E);
		btPesquisar = new JButton("Pesquisar");
		btPesquisar.setMnemonic(KeyEvent.VK_P);
		btLimpar = new JButton("Limpar");
		btLimpar.setMnemonic(KeyEvent.VK_L);
		btSair = new JButton("Sair");
		btSair.setMnemonic(KeyEvent.VK_S);
		
		pnCampos = new JPanel(new GridLayout(3, 4, 12, 2));
		pnBotoes = new JPanel(new FlowLayout());
		
		// 3 Passo adicionar objeto a tela
		pnCampos.add(lbPlaca);
		pnCampos.add(txtPlaca);
		pnCampos.add(lbFabricante);
		pnCampos.add(cmbFabricante);
		pnCampos.add(lbModelo);
		pnCampos.add(txtModelo);
		pnCampos.add(lbAno);
		pnCampos.add(txtAno);
		pnCampos.add(lbData);
		pnCampos.add(txtData);
		pnCampos.add(lbValor);
		pnCampos.add(txtValor);
		
		pnBotoes.add(btCadastrar);
		pnBotoes.add(btAlterar).setEnabled(false);
		pnBotoes.add(btExcluir).setEnabled(false);
		pnBotoes.add(btPesquisar);
		pnBotoes.add(btLimpar);
		pnBotoes.add(btSair);
		
		add(pnCampos, new BorderLayout().NORTH);
		add(pnBotoes, new BorderLayout().SOUTH);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		Veiculo form = new Veiculo();
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent evento){
		if(evento.getSource() == txtModelo){
		txtModelo.setText(txtModelo.getText().toUpperCase());
		}
		if(evento.getSource() == btCadastrar){
			//cadastrar();
		}
		if(evento.getSource() == btAlterar){
			//alterar();
		}
		if(evento.getSource() == btExcluir){
			//excluir();
		}
		if(evento.getSource() == btPesquisar){
			//pesquisar();
		}
		if(evento.getSource() == btLimpar){
			//limpar();
		}
		if(evento.getSource() == btSair){
			dispose();
		}
	}

}