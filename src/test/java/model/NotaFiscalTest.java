package dao;

import model.Cliente;
import model.NotaFiscal;
import model.Produto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Author: Lucas Jardim
 */
public class NotaFiscalTest {

    @Test
    public void testCalculoTotalNotaFiscal() {
        Cliente cliente = new Cliente("Lucas", "123.456.789-00", "Rua X");
        Produto produto1 = new Produto("Produto 1", 100.00, "Descrição do Produto 1");
        Produto produto2 = new Produto("Produto 2", 50.0, "Descrição do Produto 2");

        NotaFiscal notaFiscal = new NotaFiscal(cliente, List.of(produto1, produto2));

        assertEquals("O total da nota fiscal deve ser 150.0", 150.0, notaFiscal.getTotal(), 0.01);

        System.out.println("Teste de cálculo do total da nota fiscal passou com sucesso!");
    }
}
