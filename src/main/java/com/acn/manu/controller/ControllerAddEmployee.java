package com.acn.manu.controller;

import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class ControllerAddEmployee
 */
@WebServlet("/addemployee" )
public class ControllerAddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource dataSource;
	private ServiceEmployee serviceEmployee;
	private DtoEmployee dtoAddEmp;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAddEmployee() {
        super();
       }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("lol1");
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
			System.out.println("lol2");
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
        if((id!=null) && (name!=null) && (surname!=null) && (email!=null) && (phone!=null) && //(hireDate!=null) && 
        		(jobId!=null) && (sal!=null) && (mId!=null) && (dId!=null)) {
        	System.out.println("Malaka");
        	System.out.println("Malaka");
        	dtoAddEmp= new DtoEmployee();
        	dtoAddEmp.setEmployeeId(idE);
        	dtoAddEmp.setFirstName(name);
        	dtoAddEmp.setLastName(surname);
        	dtoAddEmp.setEmail(email);
        	dtoAddEmp.setPhoneNumber(phone);
        	dtoAddEmp.setHireDate(date); 
        	dtoAddEmp.setJobId(jobId);
        	dtoAddEmp.setSalary(salary);
        	dtoAddEmp.setCommissionPct(commission);
        	dtoAddEmp.setManagerId(managerId);
        	dtoAddEmp.setDepartmentId(departmentId);
        	serviceEmployee = new ServiceEmployee();
        	int row=serviceEmployee.create(dtoAddEmp, dataSource);
        	System.out.println("Employee added ");
            System.out.println("\rEmployee ID " +dtoAddEmp.getEmployeeId());
            System.out.println("\rFirst Name " +dtoAddEmp.getFirstName());
            System.out.println("\rLast Name " +dtoAddEmp.getLastName());
            System.out.println("\rE-mail " +dtoAddEmp.getEmail());
            System.out.println("\rPhone number " +dtoAddEmp.getPhoneNumber());
            //System.out.println("\rHire Date " +dto.getHireDate());
            System.out.println("\rJob ID " +dtoAddEmp.getJobId());
            System.out.println("\rSalary " +dtoAddEmp.getSalary());
            System.out.println("\rCommission " +dtoAddEmp.getCommissionPct());
            System.out.println("\rManager ID " +dtoAddEmp.getManagerId());
            System.out.println("\rDepartment ID " +dtoAddEmp.getDepartmentId());
            RequestDispatcher rd = request.getRequestDispatcher("addedemployee.jsp");
            request.getSession().setAttribute("dtoAddEmp",dtoAddEmp);
            rd.forward(request, response);
                 
        }else {
        	System.out.println("Dati inseriti non validi");
        	RequestDispatcher rd = request.getRequestDispatcher("FormNewEmployee.jsp");
            rd.include(request, response);
        }
       
}
}

