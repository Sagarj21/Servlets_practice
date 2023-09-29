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
		
		//send hyperlink to browser having url to complete redirection
		String url=null;
		if(engine.equalsIgnoreCase("google"))
			url="https://www.google.com/search?q="+ss+"";
		else if(engine.equalsIgnoreCase("bing"))
			url="https://www.bing.com/search?q="+ss+"";
		else
			url="https://www.in.search.yahoo.com/search?p="+ss+"";
		
		
		//perform sendredirection
		System.out.println("before resp.sendredirect");
		res.sendRedirect(url);
		System.out.println("after resp.sendredirect");
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
