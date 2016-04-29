package app.web;

import org.junit.Test;

import java.util.List;

public class JdbcConnectorTest {

    private JdbcConnector connector = new JdbcConnector();

    @Test
    public void findById() throws Exception {
        Account account = connector.findById(3);
        System.out.println(account);
    }

    @Test
    public void findAll() throws Exception {
        List<Account> accounts = connector.findAll();
        System.out.println(accounts);
    }
}