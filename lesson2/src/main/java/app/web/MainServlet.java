package app.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    private final JdbcConnector connector = new JdbcConnector();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account;
        try {
            int userId = Integer.parseInt(request.getParameter("user_id"));
            account = connector.findById(userId);
        } catch (Exception e) {
            account = new Account(-1, "Anonymous");
        }
        request.setAttribute("account", account);
        RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/secret.jsp");
        reqDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("DO POST");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("DO DELETE");
    }
}
