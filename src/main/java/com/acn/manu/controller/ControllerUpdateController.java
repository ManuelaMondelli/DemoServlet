package com.acn.manu.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.acn.manu.dto.DtoEmployee;
import com.acn.manu.service.ServiceEmployee;

/**
 * Servlet implementation class ControllerUpdateController
 */
@WebServlet("/updateEmployee")
public class ControllerUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource dataSource;
	private DtoEmployee dtoUpEmp;
	private ServiceEmployee serviceEmployee;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerUpdateController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	//collegamento al file context per il caricamento del data source
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
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        String id=request.getParameter("id");
        int idE=Integer.parseInt(id);
        String name=request.getParameter("firstName");
        String surname=request.getParameter("lastName");
        String email=request.getParameter("email");         
        String phone=request.getParameter("phoneNumber");  
        String date=request.getParameter("hireDate");
        String jobId=request.getParameter("jobId");        
        String sal=request.getParameter("salary");
        double salary=Double.parseDouble(sal);
        String comm=request.getParameter("commissionPct");
        double commission=Double.parseDouble(comm);
        String mId=request.getParameter("managerId"); 
        int managerId=Integer.parseInt(mId);
        String dId=request.getParameter("departmentId");
        int departmentId=Integer.parseInt(dId);
        if((name!=null) && (surname!=null) && (email!=null) && (phone!=null) &&
        		(jobId!=null) && (sal!=null) && (mId!=null) && (dId!=null)) {
        	dtoUpEmp=new DtoEmployee();
        	dtoUpEmp.setFirstName(name);
        	dtoUpEmp.setLastName(surname);
        	dtoUpEmp.setEmail(email);
        	dtoUpEmp.setPhoneNumber(phone);
        	dtoUpEmp.setHireDate(date); 
        	dtoUpEmp.setJobId(jobId);
        	dtoUpEmp.setSalary(salary);
        	dtoUpEmp.setCommissionPct(commission);
        	dtoUpEmp.setManagerId(managerId);
        	dtoUpEmp.setDepartmentId(departmentId);
        	serviceEmployee = new ServiceEmployee();
        	int row=serviceEmployee.update(idE, dtoUpEmp, dataSource);
        	RequestDispatcher rd = request.getRequestDispatcher("updatedEmployee.jsp");
        	request.getSession().setAttribute("dtoUpEmp",dtoUpEmp);
        	rd.forward(request, response);
        }else {
        	System.out.println("Errore inserimento dati");
        }
}
}
