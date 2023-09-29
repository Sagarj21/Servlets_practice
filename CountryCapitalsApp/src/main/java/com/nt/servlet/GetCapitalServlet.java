package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCapitalServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		//get printwriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		
		//read form data
		int country=Integer.parseInt(req.getParameter("country"));
		
		//get capital city name
		String capitals[]=new String[]{"New Delhi","lslamabad","w DC","beijing"};
		String countries[]= new String[] {"india","Pakistan","usa","China"};
		
		pw.println("<h1 style='color:blue;text-align:center'> Capital name of country"+ countries[country]+" is::"+ capitals[country]+"</h1>");
		
		//add home hyperlink
	
		pw.println("<a href='page.html'>Home</a>");
		
		//close stream
		pw.close();
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException {
		// TODO Auto-generated method stub
		doGet(req,res);
	}
}
