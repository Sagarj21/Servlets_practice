package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Locale;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinkServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		//get printwriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		
		//read additional req paramater value
		String pval=req.getParameter("p1");
		
		//get all available locales
		Locale locales[]=Locale.getAvailableLocales();
		
		//differentiate logics for hyperlinks
		
		if(pval.equalsIgnoreCase("link1")) {
			pw.println("<h1>All languages are:</h1>");
			for(Locale l:locales) {
				pw.println(l.getDisplayLanguage()+",");
			}
		}//if
		else if(pval.equalsIgnoreCase("link2")) {
			pw.println("<h1>All countries are:</h1>");
			for(Locale l:locales) {
				pw.println(l.getDisplayCountry()+",");
			}
		}
		else {
			pw.println("<h1>System date and time"+LocalDateTime.now()+"</h1>");
		}
		
		//add home hyperlink
		pw.println("<br> <a href='links.html'>Home</a>");
		
		//close stream
		pw.close();
				
	}//doGet(-,-)
	

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		doGet(req, res);
	}//dopost(-,-)
	
}//class