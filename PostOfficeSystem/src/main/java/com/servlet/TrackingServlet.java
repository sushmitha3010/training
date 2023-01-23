package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/TrackingServlet")
public class TrackingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TrackingServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			try {
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
				System.out.println(connection);
				
				String query="insert into User_Tracking(location_id,location_name,status) values(?,?,?)";
				PreparedStatement ps = connection.prepareStatement(query);
				
				String LocationId=request.getParameter("LocationId");
				String LocationName = request.getParameter("LocationName");
				String Status = request.getParameter("Status");
				
				ps.setString(1,request.getParameter("LocationId"));
				ps.setString(2,request.getParameter("LocationName"));
				ps.setString(3,request.getParameter("Status"));
				
				 request.getRequestDispatcher("HomePage.jsp").forward(request, response);
				
				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
					
		String LocationId = request.getParameter("LocationId");
		PrintWriter writer = response.getWriter();
		writer.println("Location Id:" + LocationId);

		String LocationName = request.getParameter("LocationName");
		PrintWriter writer1 = response.getWriter();
		writer.println("Location Name:" + LocationName);

		String Status = request.getParameter("Status");
		PrintWriter writer2 = response.getWriter();
		writer.println("Status:" + Status);
		
		}
		



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
