package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeSearchServlet extends HttpServlet {

	private static final String GET_EMP_BY_ENO="SELECT EMPNO,ENAME,SAL,JOB,DEPTNO FROM EMP WHERE EMPNO=?";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get pw
		PrintWriter pw=res.getWriter();
		//set res content type
		res.setContentType("text/html");
		//get access to ServletContext obj
		ServletContext sc=getServletContext();
		System.out.println("testservlet  ServletContext obj"+sc.hashCode());
		//read servlet init param values
		String driver=sc.getInitParameter("driverClass");
		String url=sc.getInitParameter("url");
		String user=sc.getInitParameter("dbuser");
		String pwd=sc.getInitParameter("pwd");

		
		//read form data
		int no=Integer.parseInt(req.getParameter("eno"));

		try {
			Class.forName(driver);
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		
		//write jdbc code
		try(Connection con =DriverManager.getConnection(url,user,pwd);
				PreparedStatement ps=con.prepareStatement(GET_EMP_BY_ENO)){
			if(ps!=null)
				ps.setInt(1, no);
			try(ResultSet rs=ps.executeQuery()){

				if(rs!=null) {
					if(rs.next()) {
						pw.println("<h1 style='color:blue;text-align:center'>Employee details are </h1>");
						pw.println("<b>Employee number:"+rs.getInt(1)+"</b><br>");
						pw.println("<b>Employee Name:"+rs.getString(2)+"</b><br>");
						pw.println("<b>Employee Desg:"+rs.getString(4)+"</b><br>");
						pw.println("<b>Employee Salary:"+rs.getFloat(3)+"</b><br>");
						pw.println("<b>Employee Dept no:"+rs.getInt(5)+"</b><br>");
					}else {
						pw.println("<h1 style='color:red;text-align:center'>Employee not found</h1>");
					}//else
				}//if

				pw.println("<br><br><p style='text-align:center'><a href='search.html'>Home</a></p>");
				pw.close();
			}//try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
		}

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
