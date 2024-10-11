package dao;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Lucas Jardim
 */
public class ClienteDAO {
    private List<Cliente> clientes = new ArrayList<>();

    public void adicionar(Cliente cliente){
        clientes.add(cliente);
    }

    public List<Cliente> listar() {
        return clientes;
    }

    public Cliente buscarCpf(String cpf) {
        return clientes.stream()
                .filter(cliente -> cliente.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }
}
