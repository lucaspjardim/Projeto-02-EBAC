package dao;

import model.Cliente;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Author: Lucas Jardim
 */
public class ClienteDAOTest {
    private ClienteDAO clienteDAO;

    @Before
    public void setUp() {
        clienteDAO = new ClienteDAO();
    }

    @Test
    public void testAdicionar() {
        Cliente cliente = new Cliente("Lucas", "123.456.789-00", "Rua X");
        clienteDAO.adicionar(cliente);

        assertEquals("Deve haver 1 cliente na lista", 1, clienteDAO.listar().size());
        assertEquals("O nome do cliente deve ser Lucas", "Lucas", clienteDAO.listar().get(0).getNome());

        System.out.println("Teste de adicionar e listar cliente passou com sucesso!");
    }
}
