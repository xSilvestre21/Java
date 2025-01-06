package adc2;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Produtos extends JFrame {
	
	private JComboBox<String> cbUnidade, cbSituacao;
	private JButton btnIncluir, btnExcluir, btnPesquisar, btnLimpar, btnAlterar;
	private HashMap<String, String[]> produtos;
	private JTextField txtCodigo, txtDescricao, txtLargura, txtComprimento, txtLocalizacao;

	public Produtos() {
		setTitle("Cadastrar produtos");
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		produtos = new HashMap<>();

		JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		panel.add(new JLabel("Código do Produto:"));
		txtCodigo = new JTextField();
		panel.add(txtCodigo);

		panel.add(new JLabel("Descrição:"));
		txtDescricao = new JTextField();
		panel.add(txtDescricao);

		panel.add(new JLabel("Unidade de Medida:"));
		cbUnidade = new JComboBox<>(new String[] { "Unidade", "Kg", "g", "L", "mL" });
		panel.add(cbUnidade);

		panel.add(new JLabel("Largura:"));
		txtLargura = new JTextField();
		panel.add(txtLargura);

		panel.add(new JLabel("Comprimento:"));
		txtComprimento = new JTextField();
		panel.add(txtComprimento);

		panel.add(new JLabel("Situação:"));
		cbSituacao = new JComboBox<>(new String[] { "Ativo", "Inativo", "Pendente", "Excluido" });
		panel.add(cbSituacao);

		panel.add(new JLabel("Localização:"));
		txtLocalizacao = new JTextField();
		panel.add(txtLocalizacao);

		btnIncluir = new JButton("Incluir");
		btnExcluir = new JButton("Excluir");
		btnPesquisar = new JButton("Pesquisar");
		btnLimpar = new JButton("Limpar");
		btnAlterar = new JButton("Alterar");
		

		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarProduto();
			}
		});

		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirProduto();
			}
		});

		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarProduto();
				pesquisarProduto();
				
			}
		});

		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});

		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarProduto();
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 5, 5));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		buttonPanel.add(btnIncluir);
		buttonPanel.add(btnExcluir).setEnabled(false);
		buttonPanel.add(btnPesquisar);
		buttonPanel.add(btnLimpar);
		buttonPanel.add(btnAlterar).setEnabled(false);;

		add(panel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void cadastrarProduto() {
		String codigo = txtCodigo.getText();
		if (produtos.containsKey(codigo)) {
			JOptionPane.showMessageDialog(this, "Produto já cadastrado com este código!");
			return;
		}

		String descricao = txtDescricao.getText();
		String unidade = (String) cbUnidade.getSelectedItem();
		String largura = txtLargura.getText();
		String comprimento = txtComprimento.getText();
		String situacao = (String) cbSituacao.getSelectedItem();
		String localizacao = txtLocalizacao.getText();

		String[] produto = { descricao, unidade, largura, comprimento, situacao, localizacao };
		produtos.put(codigo, produto);

		JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
		limparCampos();
	}

	private void pesquisarProduto() {
		String codigo = txtCodigo.getText();
		String[] produto = produtos.get(codigo);
		
		if (produto != null) {
			txtDescricao.setText(produto[0]);
			cbUnidade.setSelectedItem(produto[1]);
			txtLargura.setText(produto[2]);
			txtComprimento.setText(produto[3]);
			cbSituacao.setSelectedItem(produto[4]);
			txtLocalizacao.setText(produto[5]);
			btnAlterar.setEnabled(true);
			btnExcluir.setEnabled(true);
			txtCodigo.setEnabled(false);
			txtDescricao.setEnabled(false);
			cbUnidade.setEnabled(false);
			txtLargura.setEnabled(false);
			txtComprimento.setEnabled(false);
			cbSituacao.setEnabled(false);
			txtLocalizacao.setEnabled(false);
			
		} else {
			JOptionPane.showMessageDialog(this, "Produto não encontrado!");
		
		}
	}

	private void excluirProduto() {
		String codigo = txtCodigo.getText();
		if (produtos.containsKey(codigo)) {
			cbSituacao.setSelectedIndex(3);
			JOptionPane.showMessageDialog(this, "Produto excluído com sucesso!");
			limparCampos();
			
		} else {
			JOptionPane.showMessageDialog(this, "Produto não encontrado para excluir!");
		}
		
	}

	private void alterarProduto() {
		String codigo = txtCodigo.getText();
		txtCodigo.setEnabled(true);
		txtDescricao.setEnabled(true);
		cbUnidade.setEnabled(true);
		txtLargura.setEnabled(true);
		txtComprimento.setEnabled(true);
		cbSituacao.setEnabled(true);
		txtLocalizacao.setEnabled(true);
		if (produtos.containsKey(codigo)) {
			
			String descricao = txtDescricao.getText();
			String unidade = (String) cbUnidade.getSelectedItem();
			String largura = txtLargura.getText();
			String comprimento = txtComprimento.getText();
			String situacao = (String) cbSituacao.getSelectedItem();
			String localizacao = txtLocalizacao.getText();
		

			String[] produto = { descricao, unidade, largura, comprimento, situacao, localizacao };
			produtos.put(codigo, produto);
			
			
			
		} else {
			JOptionPane.showMessageDialog(this, "Produto não encontrado para alterar!");
		}
	
	}
	

	private void limparCampos() {
		txtCodigo.setText("");
		txtDescricao.setText("");
		txtLargura.setText("");
		txtComprimento.setText("");
		txtLocalizacao.setText("");
		cbUnidade.setSelectedIndex(0);
		cbSituacao.setSelectedIndex(0);
		txtCodigo.requestFocus();
		txtCodigo.setEnabled(true);
		txtDescricao.setEnabled(true);
		cbUnidade.setEnabled(true);
		txtLargura.setEnabled(true);
		txtComprimento.setEnabled(true);
		cbSituacao.setEnabled(true);
		txtLocalizacao.setEnabled(true);

	}

	public static void main(String[] args) {
		new Produtos();
	}
	
}