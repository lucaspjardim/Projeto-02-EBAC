package model.builder;

import model.Cliente;

/**
 * Author: Lucas Jardim
 */
public class ClienteBuilder {
    private String nome;
    private String cpf;
    private String endereco;

    public ClienteBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ClienteBuilder setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public ClienteBuilder setEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public Cliente build() {
        return new Cliente(nome, cpf, endereco);
    }
}
