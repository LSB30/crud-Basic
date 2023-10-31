package br.com.belato;

import br.com.belato.dao.ClienteMapDAO;
import br.com.belato.dao.IClienteDAO;
import br.com.belato.domain.Cliente;

import javax.swing.*;

public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();

        String opcao =
                JOptionPane.showInputDialog(null, "Digite 1 para cadastro | 2 para consultar | 3 para exclusão | 4 para alteração | 5 para sair.", "Cadastro", JOptionPane.INFORMATION_MESSAGE);


        while (!isOpcaoValida(opcao)) {
            if ("".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null, "Digite 1 para cadastro | 2 para consultar | 3 para exclusão | 4 para alteração | 5 para sair.", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }

        while (isOpcaoValida(opcao)) {
            if (isOpcaoSair(opcao)) {
                sair();
            } else if (isCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separado por virgula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            }
            opcao = JOptionPane.showInputDialog(null, "Digite 1 para cadastro | 2 para consultar | 3 para exclusão | 4 para alteração | 5 para sair.", "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        }


        if (isOpcaoCadastro(opcao)) {
            JOptionPane.showInputDialog(null, "Digite 1 para cadastro | 2 para consultar | 3 para exclusão | 4 para alteração | 5 para sair.", "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");

        if (dadosSeparados.length < 2) {
            JOptionPane.showMessageDialog(null, "Pelo menos Nome e CPF são necessários para o cadastro.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nome = (dadosSeparados.length > 0 && !dadosSeparados[0].isEmpty()) ? dadosSeparados[0] : null;
        String cpf = (dadosSeparados.length > 1 && !dadosSeparados[1].isEmpty()) ? dadosSeparados[1] : null;
        String telefone = (dadosSeparados.length > 2 && !dadosSeparados[2].isEmpty()) ? dadosSeparados[2] : "0";
        String endereco = (dadosSeparados.length > 3 && !dadosSeparados[3].isEmpty()) ? dadosSeparados[3] : null;
        String numero = (dadosSeparados.length > 4 && !dadosSeparados[4].isEmpty()) ? dadosSeparados[4] : "0";
        String cidade = (dadosSeparados.length > 5 && !dadosSeparados[5].isEmpty()) ? dadosSeparados[5] : null;
        String estado = (dadosSeparados.length > 6 && !dadosSeparados[6].isEmpty()) ? dadosSeparados[6] : null;



        for(String d: dadosSeparados) {
            System.out.println(d);
        }
        Cliente cliente = new Cliente(nome,cpf,telefone,endereco,numero,cidade,estado);
        System.out.println(dadosSeparados);
        System.out.println(cliente);


        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
        if(isCadastrado) {
            JOptionPane.showInputDialog(null, "Cliente cadastrado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showInputDialog(null, "Cliente já se encontra cadastrado.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static boolean isCadastro(String opcao) {
        if ("1".equals(opcao)) {
            return true;
        }

        return false;
    }

    private static boolean isOpcaoSair(String opcao) {
        if ("5".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)) {
            return true;
        }

        return false;
    }

    private static void sair() {
        JOptionPane.showInputDialog(null, "Saindo...", "Sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);

    }

    private static boolean isOpcaoCadastro(String opcao) {
        if ("1".equals(opcao)) {
            JOptionPane.showInputDialog(null, "Saindo...", "Sair", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }

        return false;
    }
}
