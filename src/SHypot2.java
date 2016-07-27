import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SHypot2 extends HttpServlet {

	public void doGet(HttpServletRequest request,
					  HttpServletResponse response)
					  throws ServletException, IOException {
		// Obtain the parameters that contain the lengths
		// of the two sides.
		String side1 = request.getParameter("firstside");
		String side2 = request.getParameter("secondside");
		
		// This string will hold the computed length of
		// the hypotenuse.
		String hypot;
		
		// If a parameter is missing, then set
		// strings to a null string.
		if(side1 == null | side2 == null) {
			side1 = "";
			side2 = "";
			hypot = "";
		} else {
		// Compute the hypotenuse.
			try {
				double a, b, h;
				a = Double.parseDouble(side1);
				b = Double.parseDouble(side2);
				h = Math.sqrt(a*a + b*b);
				hypot = "" + h;
			} catch(NumberFormatException exc) {
				hypot = "Invalid Data";
			}
		}
		// Set the content type and get a stream
		// for the response.
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		// Display HTML form.
		pw.print("<html> <body> " +
					"<form name=\"Form1\"" +
					"action=\"http://localhost:8080/" +
					"examples/servlets/SHypot2\">" +
					"Compute the Hypotenuse<br><br>" +
					"Enter length of side one: " +
					"<input type=textbox name = " +
					"\"firstside\" size=12 value=\"" +
					side1 + "\">" +
					"<br>Enter length of side two: " +
					"<input type=textbox name = " +
					"\"secondside\" size=12 value=\"" +
					side2 +"\"><br><br>" +
					"<input type=submit value=\"Compute\">" +
					"</form>" +
					"Length of hypotenuse: " +
					"<input READONLY type=textbox name = " +
					"\"hypot\" size=20 value=\"" +
					hypot +"\"> </body> </html>");
		pw.close();
	}
}