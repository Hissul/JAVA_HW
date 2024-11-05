package Spending;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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

   
    public Spending() {
        // TODO Auto-generated constructor stub
    }

    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("G E T");
		
		ArrayList<String> rows = new ArrayList<String>();
 		
		FileReader reader = new FileReader("SPENDING.txt");
		Scanner scan = new Scanner(reader);
		
		while(scan.hasNextLine()) {			
			rows.add(scan.nextLine());			
		}
		
		reader.close();
		
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
	        	for(String row : rows) {
        			writer.println("<li>" + row + "</li>");         			
        		}
	        writer.println("</ul>");
	        	writer.println("</body>");
	        	writer.println("</html>");  
        } finally {
            writer.close();  
        }
        
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		
		String text = request.getParameter("textField");
		Integer amount = Integer.valueOf(request.getParameter("amountField"));	
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = new Date();  
        
        FileWriter writer = new FileWriter("SPENDING.txt", true); // рабочий стол??? WTF??
        writer.write(formatter.format(date) + "  :  " +  text + "  -  " + amount + "\n");
        writer.close();
		
        doGet(request, response);
	}

}
