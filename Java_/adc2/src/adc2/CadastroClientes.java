package adc2;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CadastroClientes extends JFrame implements ActionListener {
    private JTextField campoNome, campoCPF, campoTelefone, campoEmail, campoDataCadastro;
    private JComboBox<String> comboTipoCadastro, comboEstado, comboStatus;
    private JTextField campoFaturamento;
    private ArrayList<Cliente> clientesCadastrados;

    public CadastroClientes() {
        super("Cadastro de Clientes");

        clientesCadastrados = new ArrayList<>();

        JPanel painel = new JPanel(new GridLayout(13, 2));

        JLabel labelTipoCadastro = new JLabel("Tipo de Cadastro:");
        comboTipoCadastro = new JComboBox<>(new String[]{"Pessoa Física", "Pessoa Jurídica"});

        JLabel labelNome = new JLabel("Nome:");
        campoNome = new JTextField();

        JLabel labelCPF = new JLabel("CPF:");
        campoCPF = new JTextField();

        JLabel labelEstado = new JLabel("Estado:");
        comboEstado = new JComboBox<>(new String[]{"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"});

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

        btnCadastrar.addActionListener(this);
        btnLimpar.addActionListener(this);
        btnConsultar.addActionListener(this);
        btnAlterar.addActionListener(this);
        btnSair.addActionListener(this);
        btnExcluir.addActionListener(this);

        painel.add(labelTipoCadastro);
        painel.add(comboTipoCadastro);
        painel.add(labelNome);
        painel.add(campoNome);
        painel.add(labelCPF);
        painel.add(campoCPF);
        painel.add(labelEstado);
        painel.add(comboEstado);
        painel.add(labelTelefone);
        painel.add(campoTelefone);
        painel.add(labelEmail);
        painel.add(campoEmail);
        painel.add(labelDataCadastro);
        painel.add(campoDataCadastro);
        painel.add(labelStatus);
        painel.add(comboStatus);
        painel.add(labelFaturamento);
        painel.add(campoFaturamento);
        painel.add(btnCadastrar);
        painel.add(btnLimpar);
        painel.add(btnConsultar);
        painel.add(btnAlterar);
        painel.add(btnSair);
        painel.add(btnExcluir);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(painel);
        setSize(500, 500);
        setLocationRelativeTo(null);
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
        String nome = campoNome.getText();
        String cpf = campoCPF.getText();
        String estado = (String) comboEstado.getSelectedItem();
        String telefone = campoTelefone.getText();
        String email = campoEmail.getText();
        String dataCadastro = campoDataCadastro.getText();
        String status = (String) comboStatus.getSelectedItem();
        String faturamento = campoFaturamento.getText();

        Cliente cliente = new Cliente(nome, cpf, estado, telefone, email, dataCadastro, status, faturamento);
        clientesCadastrados.add(cliente);
        limparCampos();
        JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
    }

    private void limparCampos() {
        campoNome.setText("");
        campoCPF.setText("");
        comboEstado.setSelectedIndex(0);
        campoTelefone.setText("");
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
        campoNome.setText(cliente.getNome());
        campoCPF.setText(cliente.getCpf());
        comboEstado.setSelectedItem(cliente.getEstado());
        campoTelefone.setText(cliente.getTelefone());
        campoEmail.setText(cliente.getEmail());
        campoDataCadastro.setText(cliente.getDataCadastro());
        comboStatus.setSelectedItem(cliente.getStatus());
        campoFaturamento.setText(cliente.getFaturamento());
    }

    private void alterarCliente() {
        String clienteSelecionado = campoNome.getText();

        for (Cliente cliente : clientesCadastrados) {
            if (cliente.getNome().equals(clienteSelecionado)) {
                cliente.setCpf(campoCPF.getText());
                cliente.setEstado((String) comboEstado.getSelectedItem());
                cliente.setTelefone(campoTelefone.getText());
                cliente.setEmail(campoEmail.getText());
                cliente.setStatus((String) comboStatus.getSelectedItem());
                cliente.setFaturamento(campoFaturamento.getText());

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
        private String nome;
        private String cpf;
        private String estado;
        private String telefone;
        private String email;
        private String dataCadastro;
        private String status;
        private String faturamento;

        public Cliente(String nome, String cpf, String estado, String telefone, String email, String dataCadastro, String status, String faturamento) {
            this.nome = nome;
            this.cpf = cpf;
            this.estado = estado;
            this.telefone = telefone;
            this.email = email;
            this.dataCadastro = dataCadastro;
            this.status = status;
            this.faturamento = faturamento;
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

