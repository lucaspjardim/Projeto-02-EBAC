package dao;

import model.NotaFiscal;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Lucas Jardim
 */
public class NotaFiscalDAO {
    private List<NotaFiscal> notasFiscais = new ArrayList<>();

    public void adicionar(NotaFiscal notaFiscal) {
        notasFiscais.add(notaFiscal);
    }

    public List<NotaFiscal> listar() {
        return notasFiscais;
    }

    public List<NotaFiscal> buscarCpfCliente(String cpf) {
        return notasFiscais.stream()
                .filter(nota ->nota.getCliente().getCpf().equals(cpf))
                .toList();
    }
}
