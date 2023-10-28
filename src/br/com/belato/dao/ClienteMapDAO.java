package br.com.belato.dao;

import br.com.belato.domain.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ClienteMapDAO implements IClienteDAO{

    private Map<Long, Cliente> map;
    public ClienteMapDAO() {
        this.map = new HashMap<>();
    }
    @Override
    public Boolean cadastrar(Cliente cliente) {
        if(this.map.containsKey(cliente.getCpf())) {
            return false;
        }
        this.map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteCadastrado = this.map.get(cpf);
        if(clienteCadastrado != null) {
            this.map.remove(clienteCadastrado.getCpf());
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteCadastrado = this.map.get(cliente.getCpf());
        if(clienteCadastrado != null) {
            clienteCadastrado.setCidade(cliente.getCidade());
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setEnd(cliente.getEnd());
            clienteCadastrado.setEstado(cliente.getEstado());
            clienteCadastrado.setNumero(cliente.getNumero());
            clienteCadastrado.setTel(cliente.getTel());
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }

}
