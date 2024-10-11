package dao;

import model.Cliente;
import model.NotaFiscal;
import model.Produto;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Author: Lucas Jardim
 */
public class NotaFiscalDAOTest {

    private NotaFiscalDAO notaFiscalDAO;

    @Before
    public void setUp() {
        notaFiscalDAO = new NotaFiscalDAO();
    }

    @Test
    public void testAdicionarEListarNotaFiscal() {
        Cliente cliente = new Cliente("Lucas", "123.456.789-00", "Rua X");
        Produto produto1 = new Produto("Produto 1", 100.0, "Descrição do Produto 1");
        Produto produto2 = new Produto("Produto 2", 50.0, "Descrição do Produto 2");

        NotaFiscal notaFiscal = new NotaFiscal(cliente, List.of(produto1, produto2));
        notaFiscalDAO.adicionar(notaFiscal);

        assertEquals("Deve haver 1 nota fiscal na lista", 1, notaFiscalDAO.listar().size());
        assertEquals("O cliente da nota fiscal deve ser Lucas", cliente, notaFiscalDAO.listar().get(0).getCliente());
        assertEquals("O total da nota fiscal deve ser 150.0", 150.0, notaFiscalDAO.listar().get(0).getTotal(), 0.01);

        System.out.println("Teste de adicionar e listar nota fiscal passou com sucesso!");
    }

    @Test
    public void testBuscarPorCpfCliente() {
        Cliente cliente = new Cliente("Lucas", "123.456.789-00", "Rua X");
        Produto produto = new Produto("Produto 1", 100.0, "Descrição do Produto 1");

        NotaFiscal notaFiscal = new NotaFiscal(cliente, List.of(produto));
        notaFiscalDAO.adicionar(notaFiscal);

        List<NotaFiscal> notas = notaFiscalDAO.buscarCpfCliente("123.456.789-00");

        assertEquals("Deve haver 1 nota fiscal para o cliente com CPF 123.456.789-00", 1, notas.size());
        assertEquals("O cliente da nota fiscal deve ser Lucas", cliente, notas.get(0).getCliente());

        // Mensagem de sucesso
        System.out.println("Teste de buscar nota fiscal por CPF do cliente passou com sucesso!");
    }
}
