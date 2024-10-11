import dao.*;
import dao.ClientTest;
import dao.NotaFiscalTest;
import dao.ProdutoTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Author: Lucas Jardim
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ClientTest.class,
        ProdutoTest.class,
        NotaFiscalTest.class,
        ClienteDAOTest.class,
        ProdutoDAOTest.class,
        NotaFiscalDAOTest.class
})
public class AllTests {
}
