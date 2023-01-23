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


//@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BookingServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
				System.out.println(connection);
				 
				String query="insert into BookingType(user_id,user_name,mobile_no,from_address,to_address,parcel_id,tracking_id) values(?,?,?,?,?,?,?)";
				PreparedStatement ps = connection.prepareStatement(query);
				
				String UserId = request.getParameter(("userId"));
				PrintWriter writer = response.getWriter();
				writer.println("User Id:"+UserId);
				
				String UserName = request.getParameter("UserName");
				PrintWriter writer2 = response.getWriter();
		        writer.println("User Name:"+UserName);	
		        
				String MobileNo = request.getParameter("MobileNo");
				PrintWriter writer3 = response.getWriter();
				writer.println("Mobile No:"+MobileNo);
				
				String FromAddress = request.getParameter("FromAddress");
				PrintWriter writer4 = response.getWriter();
                writer.println("From Address:"+FromAddress);				
				
				String ToAddress = request.getParameter("ToAddress");
				PrintWriter writer5 = response.getWriter();
				writer.println("To Address:"+ToAddress);
				
				String ParcelId= request.getParameter("ParcelId");
				PrintWriter writer6 = response.getWriter();
				writer.println("Parcel Id:"+ParcelId);
				
				String TrackingId = request.getParameter("TrackingId");
				PrintWriter writer7 = response.getWriter();
                writer.println("Tracking Id:"+TrackingId);	
                
                request.getRequestDispatcher("HomePage.jsp").forward(request, response);
				
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
