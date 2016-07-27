package servletandjsp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a.talismanov on 23.06.2016.
 */

public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Book> books = new ArrayList<>();

        books.add(new Book(1L, "OCA java"));
        books.add(new Book(2L, "java for testers"));
        books.add(new Book(3L, "OCP java"));

        req.setAttribute("bookList", books);

        getServletContext().getRequestDispatcher("/books.jsp").forward(req, resp);


    }
}
