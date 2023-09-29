package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//get pwwriter
		PrintWriter pw=res.getWriter();
		
		//get access to servletconfig object
		ServletConfig cg=getServletConfig();
		System.out.println("testservlet  servletcongig obj"+cg.hashCode());
		pw.println("<b>db user init param values"+cg.getInitParameter("dbuser")+"<b>");
		//close the stream
	}
}
