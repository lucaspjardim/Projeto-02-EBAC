import dao.ClienteDAO;
import dao.NotaFiscalDAO;
import dao.ProdutoDAO;
import model.Cliente;
import model.NotaFiscal;
import model.Produto;
import model.builder.ClienteBuilder;
import model.builder.NotaFiscalBuilder;

import java.util.List;
import java.util.Scanner;

/**
 * Author: Lucas Jardim
 */
public class Main {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        NotaFiscalDAO notaFiscalDAO = new NotaFiscalDAO();

        // Adicionando clientes
        Cliente cliente1 = new ClienteBuilder()
                .setNome("Lucas")
                .setCpf("123.456.789-00")
                .setEndereco("Rua X")
                .build();

        Cliente cliente2 = new ClienteBuilder()
                .setNome("Maria")
                .setCpf("987.654.321-00")
                .setEndereco("Rua Y")
                .build();

        Cliente cliente3 = new ClienteBuilder()
                .setNome("João")
                .setCpf("456.789.123-00")
                .setEndereco("Rua Z")
                .build();

        Cliente cliente4 = new ClienteBuilder()
                .setNome("Ana")
                .setCpf("654.321.987-00")
                .setEndereco("Rua W")
                .build();

        Cliente cliente5 = new ClienteBuilder()
                .setNome("Pedro")
                .setCpf("789.123.456-00")
                .setEndereco("Rua V")
                .build();

        Cliente cliente6 = new ClienteBuilder()
                .setNome("Paula")
                .setCpf("321.987.654-00")
                .setEndereco("Rua U")
                .build();

        clienteDAO.adicionar(cliente1);
        clienteDAO.adicionar(cliente2);
        clienteDAO.adicionar(cliente3);
        clienteDAO.adicionar(cliente4);
        clienteDAO.adicionar(cliente5);
        clienteDAO.adicionar(cliente6);

        // Adicionando produtos
        Produto p1 = new Produto("Produto 1", 100.0, "Descrição do Produto 1");
        Produto p2 = new Produto("Produto 2", 50.0, "Descrição do Produto 2");
        Produto p3 = new Produto("Produto 3", 75.0, "Descrição do Produto 3");
        Produto p4 = new Produto("Produto 4", 200.0, "Descrição do Produto 4");
        Produto p5 = new Produto("Produto 5", 30.0, "Descrição do Produto 5");
        Produto p6 = new Produto("Produto 6", 120.0, "Descrição do Produto 6");

        produtoDAO.adicionar(p1);
        produtoDAO.adicionar(p2);
        produtoDAO.adicionar(p3);
        produtoDAO.adicionar(p4);
        produtoDAO.adicionar(p5);
        produtoDAO.adicionar(p6);

        // Adicionando notas fiscais
        NotaFiscal notaFiscal1 = new NotaFiscalBuilder()
                .setCliente(cliente1)
                .setProdutos(List.of(p1, p2))
                .build();
        notaFiscalDAO.adicionar(notaFiscal1);

        NotaFiscal notaFiscal2 = new NotaFiscalBuilder()
                .setCliente(cliente2)
                .setProdutos(List.of(p3, p4))
                .build();
        notaFiscalDAO.adicionar(notaFiscal2);

        NotaFiscal notaFiscal3 = new NotaFiscalBuilder()
                .setCliente(cliente3)
                .setProdutos(List.of(p5))
                .build();
        notaFiscalDAO.adicionar(notaFiscal3);

        NotaFiscal notaFiscal4 = new NotaFiscalBuilder()
                .setCliente(cliente4)
                .setProdutos(List.of(p6, p2))
                .build();
        notaFiscalDAO.adicionar(notaFiscal4);

        NotaFiscal notaFiscal5 = new NotaFiscalBuilder()
                .setCliente(cliente5)
                .setProdutos(List.of(p1, p4))
                .build();
        notaFiscalDAO.adicionar(notaFiscal5);

        NotaFiscal notaFiscal6 = new NotaFiscalBuilder()
                .setCliente(cliente6)
                .setProdutos(List.of(p3, p5))
                .build();
        notaFiscalDAO.adicionar(notaFiscal6);

        // Exibindo todas as notas fiscais
        for (NotaFiscal nota : notaFiscalDAO.listar()) {
            System.out.println("\nCliente: " + nota.getCliente().getNome());
            System.out.println("Total: " + nota.getTotal());
            nota.getProdutos().forEach(produto ->
                    System.out.println("Produto: " + produto.getNome() + ", Preço: " + produto.getPreco())
            );
        }

        // Solicitando o CPF do cliente para buscar notas fiscais específicas
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDigite o CPF do cliente para ver suas notas fiscais: ");
        String cpf = scanner.nextLine();

        List<NotaFiscal> notasCliente = notaFiscalDAO.buscarCpfCliente(cpf);

        if (notasCliente.isEmpty()) {
            System.out.println("Nenhuma nota fiscal encontrada para o cliente com CPF: " + cpf);
        } else {
            System.out.println("Notas fiscais encontradas para o cliente com CPF: " + cpf);
            for (NotaFiscal notaFiscal : notasCliente) {
                System.out.println("\nCliente: " + notaFiscal.getCliente().getNome());
                System.out.println("Total: " + notaFiscal.getTotal());
                notaFiscal.getProdutos().forEach(produto ->
                        System.out.println("Produto: " + produto.getNome() + ", Preço: " + produto.getPreco())
                );
            }
        }
    }
}
