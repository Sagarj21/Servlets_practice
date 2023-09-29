import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		//read form data
		String ss=req.getParameter("ss");
		String engine=req.getParameter("engine");
		
		//send hyperlink to webapp
		if(engine.equalsIgnoreCase("google"))
			pw.println("<h1 style='color:red;text-align:center'><a href='https://www.google.com/search?q="+ss+"'>click here for google search</h1>");
		else if(engine.equalsIgnoreCase("bing"))
			pw.println("<h1 style='color:red;text-align:center'><a href='https://www.bing.com/search?q="+ss+"'>click here for bing search</h1>");
		else
			pw.println("<h1 style='color:red;text-align:center'><a href='https://www.in.search.yahoo.com/search?p="+ss+"'>click here for yahoo search</h1>");
		
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
