package servletandjsp.justservletexamples;


import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

public class SDemo1 extends GenericServlet {

    static int count=0;
    String msg = "";

    // Called once, at startup.
    public void init(ServletConfig sc) {
        msg = "Servlet initialized.";
    }

    // Called once, when the servlet is removed.
    public void destroy() {
        msg += " This won't be seen.";
    }

    // Called repeatedly to handle requests.
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        count++;
        // Set the content type.
        response.setContentType("text/html");

        // Get a response stream.
        PrintWriter pw = response.getWriter();

        // Show that the service() method has been called
        // and display the server name.
        msg += "<br>Inside service(). Server: "+request.getServerName()+"<br>count="+count;
        pw.println(msg);
        pw.close();
        System.out.println();
    }
}