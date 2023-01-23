package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/AdminLogTestServe")
public class AdminLogTestServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminLogTestServe() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
				System.out.println(connection);
				
				String mailId=request.getParameter("mailId");
				PrintWriter writer=response.getWriter();
				//writer.println("mailIdId:"+mailId);
				
				String password = request.getParameter("password");
				PrintWriter writer2 = response.getWriter();
				//writer.println("Password:"+password);
				
				String query = "select mail_id,password from Admin where mail_id=?";
				PreparedStatement ps = connection.prepareStatement(query);
				
				ps.setString(1, mailId);
				ResultSet rs = ps.executeQuery();// Retrieve the data
               
				while (rs.next()) {
					
					if(mailId.equals("admin123@gmail.com")) {
						if(password.equals("admin@123")) {
							System.out.println("Login Successfully!!!...");
							 
							//request.getRequestDispatcher("HomePage.jsp").forward(request, response);
						
						}
						
						}
						else
							System.out.println("Invalid MailId or Password");
					
							
					}
	
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
