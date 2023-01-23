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


//@WebServlet("/LoginTestServe")
public class LoginTestServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginTestServe() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
				System.out.println(connection);
				
				String userId=request.getParameter("userId");
				//PrintWriter writer=response.getWriter();
				//writer.println("userId:"+userId);
				
				String password = request.getParameter("password");
				PrintWriter writer2 = response.getWriter();
				//writer.println("Password:"+password);
				
				String query = "select user_id,password from Register where user_id=?";
				PreparedStatement ps = connection.prepareStatement(query);
				
				ps.setString(1,userId);
				ResultSet rs = ps.executeQuery();// Retrieve the data
               
				while (rs.next()) {
					
					String id = rs.getString(1);
					if (id.equals(userId)) {
						String password1 = rs.getString(2);
						if (password1.equals(password)) {
							
							
							System.out.println("Login Successfull!!!!!!..");
							
							 request.getRequestDispatcher("HomePage.jsp").forward(request, response);
		
							//request.getRequestDispatcher("HomePage.html").forward(request, response);
						}
					else 
							System.out.println("User Id Invalid!!!!");
						
					}
						else {
							System.out.println("Password Invalid");
						}
				
				
			 
				}
			}
				catch (SQLException e) {
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
