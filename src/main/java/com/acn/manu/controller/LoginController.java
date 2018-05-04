package com.acn.manu.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.servlet.ServletConfig;

import com.acn.manu.dto.DtoLogin;
import com.acn.manu.service.ServiceLogin;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private DtoLogin dto;
    private ServiceLogin service;
    private DataSource dataSource;
    private boolean result=false;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    /*
    public LoginController() {
    	try {
            System.out.println("-----------------------------------------------------");
            System.out.println("init method has been called and servlet is initialized");

            
            //Using JDNI lookup get the DataSource.
            
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/HRDB");

            System.out.println("Using JDNI lookup got the DataSource : " + dataSource);
            System.out.println("-----------------------------------------------------");
        } catch (NamingException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        */
   
    @Override
    public void init(ServletConfig config) {
        try {
        	 System.out.println("-----------------------------------------------------");
             System.out.println("init method has been called and servlet is initialized");

             /*
             * Using JDNI lookup get the DataSource.
              */
             Context initContext = new InitialContext();
             Context envContext = (Context) initContext.lookup("java:/comp/env");
             dataSource = (DataSource) envContext.lookup("jdbc/HRDB");

             System.out.println("Using JDNI lookup got the DataSource : " + dataSource);
             System.out.println("-----------------------------------------------------");
        }catch (Exception ex) {
            System.out.println("ERROR");
        }
    }	
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Afer add 1");
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Afer add 1");
		processRequest(request, response);
		
	}
	
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //caricamento nelle variabili di username e password inseriti da input
        String name = request.getParameter("username")/*.trim()*/;
        String pass = request.getParameter("password")/*.trim()*/;
        System.out.println("context: "+ request.getContextPath());
        //Setting DTO field
        dto = new DtoLogin();
        dto.setUsername(name);
        dto.setPassword(pass);
        //controllo nullo lato server
        if ((name != null) && (pass != null)) {
            service = new ServiceLogin();
            //chiamata al metodo del service
            result=service.login(dto, dataSource);
            System.out.println(result);
            //se i campi non sono nulli ci sara il reindirizzamento alla pagina welcome
            //in caso contrario si tornera alla index per reinserire username e password
            if(result == true) {
	            RequestDispatcher rd = request.getRequestDispatcher("/welcome.jsp");
	            rd.forward(request, response);
            }else {
	            System.out.println("Username o password non validi");
	            RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
	            rd.include(request, response);
        }
    }

}
}
