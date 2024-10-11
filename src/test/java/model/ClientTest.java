package dao;

import model.Cliente;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Author: Lucas Jardim
 */
public class ClientTest {

    @Test
    public void testCriacaoCliente() {
        Cliente cliente = new Cliente("Lucas", "123.456.789-00", "Rua X");

        assertEquals("Nome do cliente deve ser Lucas", "Lucas", cliente.getNome());
        assertEquals("CPF do cliente deve ser 123.456.789-00", "123.456.789-00", cliente.getCpf());
        assertEquals("Endereço do cliente deve ser Rua X", "Rua X", cliente.getEndereco());

        System.out.println("Teste de criação de cliente passou com sucesso!");
    }
}
