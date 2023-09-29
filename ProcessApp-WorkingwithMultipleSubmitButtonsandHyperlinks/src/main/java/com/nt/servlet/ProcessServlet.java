package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {

	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		//read special request param value
		String s1val=req.getParameter("s1");
		
		//read form data textbox values
		int val1=0,val2=0;
		if(!s1val.equalsIgnoreCase("link1") && !s1val.equalsIgnoreCase("link1")) {// read textbox values only when request is not coming from hyperlinks
			val1=Integer.parseInt(req.getParameter("t1"));
			val2=Integer.parseInt(req.getParameter("t2"));
		}
		
		
		//differentiate logics form submit buttons and hyperlinks
		if(s1val.equalsIgnoreCase("add")) {
			pw.println("<h1>Sum of "+val1+"and"+val2+"is"+(val1+val2)+"</h1>");
		}
		else if(s1val.equalsIgnoreCase("sub")) {
			pw.println("<h1>Sub of "+val1+"and"+val2+"is"+(val1-val2)+"</h1>");
		}
		else if(s1val.equalsIgnoreCase("mul")){
			pw.println("<h1>Mul of "+val1+"and"+val2+"is"+(val1*val2)+"</h1>");
		}
		else if(s1val.equalsIgnoreCase("div")){
			pw.println("<h1>div of "+val1+"and"+val2+"is"+((float)val1/val2)+"</h1>");
		}
		else if(s1val.equalsIgnoreCase("link1")) {
			pw.println("<h1>system properties are ");
			pw.println("<b>"+System.getProperties()+"</b>");
		}else {
			pw.println("<h1>sytem date and time::"+ LocalDateTime.now() +"</h1>");
		}
		
		//add home hyperlink
		pw.println("<br> <a href='form.html'>home</a>");
		
		
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
