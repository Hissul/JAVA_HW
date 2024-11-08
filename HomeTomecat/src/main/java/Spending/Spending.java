package Spending;


import java.io.FileReader;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

import HomeTomecat.Wallet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Spending
 */
@WebServlet("/spending")
public class Spending extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
   
	
	// GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		List<Wallet> spendings = session.createQuery("FROM Wallet", Wallet.class).getResultList();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		response.setContentType("text/html");
		
        PrintWriter writer = response.getWriter();
        try {        	
	        	writer.println("<html>");
	        	writer.println("<head>");
	        	writer.println("<title>Spendings</title>");
	        	writer.println("</head>");
	        	writer.println("<body>");
	        	writer.println("<h1>Your Spendings</h1>");
	        	writer.println("<ul>");
	        	for(Wallet spending : spendings) {
        			writer.println("<li>" + formatter.format(spending.date) + " - " + spending.purpose + " - " + spending.amount  + "</li>");         			
        		}
	        writer.println("</ul>");
	        	writer.println("</body>");
	        	writer.println("</html>");  
        } finally {
            writer.close();  
        }
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	// POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				

		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		
		System.out.println(session);	
		
		Wallet wallet = new Wallet();
		wallet.purpose = request.getParameter("purpose");
		wallet.amount = Double.valueOf(request.getParameter("amount"));
		wallet.date = new Date();
		
		session.save(wallet);
		
		Transaction transaction = session.beginTransaction();
		transaction.commit();
		
        doGet(request, response);
	}

}
