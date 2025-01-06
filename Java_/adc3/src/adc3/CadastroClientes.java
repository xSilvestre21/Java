package adc3;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;

public class CadastroClientes extends JFrame implements ActionListener {
	
	// 1 Passo - Declaração dos Objetos
    JTextField campoNome, campoCPF, campoCNPJ, campoTelefone, campoEmail, campoDataCadastro;
    JComboBox<String> comboTipoCadastro, comboEstado, comboStatus;
    JTextField campoFaturamento;
    ArrayList<Cliente> clientesCadastrados;
    MaskFormatter mascaraCNPJ, mascaraTelefone, mascaraCPF;
    JPanel pnCampos, pnBotoes;
	GridLayout gridCampos, gridBotoes;
	BorderLayout layout;
	JFormattedTextField txtCPF, txtTelefone, txtCNPJ;

    public CadastroClientes() {
        super("Cadastro de Clientes");
        clientesCadastrados = new ArrayList<>();
        setLayout(layout = new BorderLayout());
        setSize(500, 350);
		setLocation(50, 50);

        pnCampos = new JPanel();
		pnBotoes = new JPanel();
		gridCampos = new GridLayout(10, 2);
		gridBotoes = new GridLayout(1, 4);

        JLabel labelTipoCadastro = new JLabel("Tipo de Cadastro:");
        comboTipoCadastro = new JComboBox<>(new String[]{"Pessoa Física", "Pessoa Jurídica"});

        JLabel labelNome = new JLabel("Nome:");
        campoNome = new JTextField();

        JLabel labelCPF = new JLabel("CPF:");
        campoCPF = new JTextField();
        
        JLabel labelCNPJ = new JLabel("CNPJ:");
        campoCNPJ = new JTextField();

        JLabel labelEstado = new JLabel("Estado:");
        comboEstado = new JComboBox<>(new String[]{"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", 
        		"GO", "MA", "MT", "MS", "MG", "PA", "PB", 
        		"PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"});
       
        JLabel labelTelefone = new JLabel("Telefone:");
        campoTelefone = new JTextField();

        JLabel labelEmail = new JLabel("Email:");
        campoEmail = new JTextField();

        JLabel labelDataCadastro = new JLabel("Data do Cadastro:");
        campoDataCadastro = new JTextField();
        campoDataCadastro.setEditable(false);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        campoDataCadastro.setText(dateFormat.format(new Date()));

        JLabel labelStatus = new JLabel("Status:");
        comboStatus = new JComboBox<>(new String[]{"Ativo", "Inativo"});

        JLabel labelFaturamento = new JLabel("Faturamento:");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        campoFaturamento = new JTextField();
        campoFaturamento.setEditable(true);
        campoFaturamento.setText(currencyFormat.format(0));

        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnLimpar = new JButton("Limpar");
        JButton btnConsultar = new JButton("Consultar");
        JButton btnAlterar = new JButton("Alterar");
        JButton btnSair = new JButton("Sair");
        JButton btnExcluir = new JButton("Excluir");
        
        try {
        	mascaraCPF = new MaskFormatter("###.###.###-##");
			mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
			mascaraTelefone = new MaskFormatter("(##) #####-####");
			
		}catch(ParseException e) {
			System.err.println("Falha na máscara");
		}
		
		txtCPF = new JFormattedTextField(mascaraCPF);
		txtCNPJ = new JFormattedTextField(mascaraCNPJ);
		txtTelefone = new JFormattedTextField(mascaraTelefone);

        btnCadastrar.addActionListener(this);
        btnLimpar.addActionListener(this);
        btnConsultar.addActionListener(this);
        btnAlterar.addActionListener(this);
        btnSair.addActionListener(this);
        btnExcluir.addActionListener(this);
        
        pnCampos.setLayout(gridCampos);
		pnBotoes.setLayout(gridBotoes);

        pnCampos.add(labelTipoCadastro);
        pnCampos.add(comboTipoCadastro);
        pnCampos.add(labelNome);
        pnCampos.add(campoNome);
        pnCampos.add(labelCPF);
        pnCampos.add(txtCPF);
        pnCampos.add(labelCNPJ);
	   	pnCampos.add(txtCNPJ);
        pnCampos.add(labelEstado);
        pnCampos.add(comboEstado);
        pnCampos.add(labelTelefone);
        pnCampos.add(txtTelefone);
        pnCampos.add(labelEmail);
        pnCampos.add(campoEmail);
        pnCampos.add(labelDataCadastro);
        pnCampos.add(campoDataCadastro);
        pnCampos.add(labelStatus);
        pnCampos.add(comboStatus);
        pnCampos.add(labelFaturamento);
        pnCampos.add(campoFaturamento);
        add(pnCampos, BorderLayout.NORTH);
      
        pnBotoes.add(btnCadastrar);
        pnBotoes.add(btnLimpar);
        pnBotoes.add(btnConsultar);
        pnBotoes.add(btnAlterar);
        pnBotoes.add(btnSair);
        pnBotoes.add(btnExcluir);
		add(pnBotoes, BorderLayout.SOUTH);
		
	   

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CadastroClientes::new);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Cadastrar":
                cadastrarCliente();
                break;
            case "Limpar":
                limparCampos();
                break;
            case "Consultar":
                consultarCliente();
                break;
            case "Alterar":
                alterarCliente();
                break;
            case "Sair":
                sair();
                break;
            case "Excluir":
                excluirCliente();
                break;
        }
        
        
    }
    
    private void cadastrarCliente() {
    	String pessoa = (String)comboTipoCadastro.getSelectedItem();
        String nome = campoNome.getText();
        String cpf = txtCPF.getText();
        String cnpj = txtCNPJ.getText();
        String estado = (String) comboEstado.getSelectedItem();
        String telefone = txtTelefone.getText();
        String email = campoEmail.getText();
        String dataCadastro = campoDataCadastro.getText();
        String status = (String) comboStatus.getSelectedItem();
        String faturamento = campoFaturamento.getText();
        Cliente cliente = new Cliente(pessoa, nome, cpf, cnpj, estado, telefone, email, dataCadastro, status, faturamento);
        clientesCadastrados.add(cliente);
        limparCampos();
        JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
    }

    private void limparCampos() {
    	comboTipoCadastro.setSelectedIndex(0);
        campoNome.setText("");
        txtCPF.setText("");
        txtCNPJ.setText("");
        comboEstado.setSelectedIndex(0);
        txtTelefone.setText("");
        campoEmail.setText("");
        campoDataCadastro.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        comboStatus.setSelectedIndex(0);
        campoFaturamento.setText(NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(0));
    }

    private void consultarCliente() {
        String[] clientes = new String[clientesCadastrados.size()];
        for (int i = 0; i < clientesCadastrados.size(); i++) {
            clientes[i] = clientesCadastrados.get(i).getNome();
        }
        String clienteSelecionado = (String) JOptionPane.showInputDialog(
                this,
                "Selecione o cliente:",
                "Consultar Cliente",
                JOptionPane.QUESTION_MESSAGE,
                null,
                clientes,
                clientes[0]);

        if (clienteSelecionado != null) {
            for (Cliente cliente : clientesCadastrados) {
                if (cliente.getNome().equals(clienteSelecionado)) {
                    preencherCampos(cliente);
                    break;
                }
            }
        }
    }

    private void preencherCampos(Cliente cliente) {
    	//combo
    	comboTipoCadastro.setSelectedItem(cliente.getPessoa());
        campoNome.setText(cliente.getNome());
        txtCPF.setText(cliente.getCpf());
        txtCNPJ.setText(cliente.getCnpj());
        comboEstado.setSelectedItem(cliente.getEstado());
        txtTelefone.setText(cliente.getTelefone());
        campoEmail.setText(cliente.getEmail());
        campoDataCadastro.setText(cliente.getDataCadastro());
        comboStatus.setSelectedItem(cliente.getStatus());
        campoFaturamento.setText(cliente.getFaturamento());
    }

    private void alterarCliente() {
        String clienteSelecionado = campoNome.getText();

        for (Cliente cliente : clientesCadastrados) {
            if (cliente.getNome().equals(clienteSelecionado)) {
            	cliente.setPessoa((String) comboTipoCadastro.getSelectedItem());
                cliente.setCpf(txtCPF.getText());
                cliente.setCnpj(txtCNPJ.getText());
                cliente.setEstado((String) comboEstado.getSelectedItem());
                cliente.setTelefone(txtTelefone.getText());
                cliente.setEmail(campoEmail.getText());
                cliente.setStatus((String) comboStatus.getSelectedItem());
                cliente.setFaturamento(campoFaturamento.getText());
                
                limparCampos();
                JOptionPane.showMessageDialog(this, "Cliente alterado com sucesso!");
                return;
                
            }
        }
        JOptionPane.showMessageDialog(this, "Cliente não encontrado!");
    }

    private void sair() {
        System.exit(0);
    }

    private void excluirCliente() {
        String clienteSelecionado = campoNome.getText();

        for (Cliente cliente : clientesCadastrados) {
            if (cliente.getNome().equals(clienteSelecionado)) {
                clientesCadastrados.remove(cliente);
                break;
            }
        }
        limparCampos();
        JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso!");
    }
    

    private static class Cliente {
    	private String pessoa;
        private String nome;
        private String cpf;
        private String cnpj;
        private String estado;
        private String telefone;
        private String email;
        private String dataCadastro;
        private String status;
        private String faturamento;

        public Cliente(String pessoa, String nome, String cpf, String cnpj ,String estado, String telefone, String email, String dataCadastro, String status, String faturamento) {
            this.pessoa = pessoa;
        	this.nome = nome;
            this.cpf = cpf;
            this.cnpj = cnpj;
            this.estado = estado;
            this.telefone = telefone;
            this.email = email;
            this.dataCadastro = dataCadastro;
            this.status = status;
            this.faturamento = faturamento;
        }

        public String getPessoa() {
            return pessoa;
        }
        
        public void setPessoa(String pessoa) {
            this.pessoa = pessoa;
        }
        
        public String getNome() {
            return nome;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }
        
        public String getCnpj() {
            return cnpj;
        }

        public void setCnpj(String cnpj) {
            this.cnpj = cnpj;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getDataCadastro() {
            return dataCadastro;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getFaturamento() {
            return faturamento;
        }

        public void setFaturamento(String faturamento) {
            this.faturamento = faturamento;
        }
    }
    
}

