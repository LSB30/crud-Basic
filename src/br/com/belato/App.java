package br.com.belato;

import br.com.belato.dao.ClienteMapDAO;
import br.com.belato.dao.IClienteDAO;

import javax.swing.*;

public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();
        String opcao =
                JOptionPane.showInputDialog(null, "Digite 1 para cadastro | 2 para consultar | 3 para exclusão | 4 para alteração | 5 para sair.", "Cadastro", JOptionPane.INFORMATION_MESSAGE);


        while(!isOpcaoValida(opcao)) {
            if("".equals(opcao)) {
                sair();
            }
        }
        if (isOpcaoCadastro(opcao)) {
            JOptionPane.showInputDialog(null, "Digite 1 para cadastro | 2 para consultar | 3 para exclusão | 4 para alteração | 5 para sair.", "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    private static boolean isOpcaoValida(String opcao) {
        if("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao)) {
            return true;
        }

        return false;
    }

    private static void sair() {
        JOptionPane.showInputDialog(null, "Saindo...", "Sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);

    }

    private static boolean isOpcaoCadastro(String opcao) {
    }
}
