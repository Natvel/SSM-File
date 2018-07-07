package com.hp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.Entity.EmpEntity;
import com.hp.serivce.impl.EmpSerivceImpl;
import com.hp.serivce2.EmpSerivce;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String code=request.getParameter("code");
		EmpSerivce emp=new EmpSerivceImpl();
		if(code.equals("1"))
		{
			ArrayList<EmpEntity> elist=emp.GetEmpInfo();
			request.setAttribute("elist",elist);
			request.getRequestDispatcher("./emp/all.jsp").forward(request, response);
			
		}else if(code.equals("2"))
		{
			
			int eid=Integer.parseInt(request.getParameter("eid"));
			EmpEntity emp0=new EmpEntity();
			emp0.setEid(eid);
			EmpEntity eEntity=emp.EmpReverseSelection(emp0);
			request.setAttribute("e",eEntity);
			request.getRequestDispatcher("./emp/update.jsp").forward(request, response);
			
		}else if(code.equals("3"))
		{
			int eid=Integer.parseInt(request.getParameter("eid"));
			String ename=request.getParameter("ename");
			int esex=Integer.parseInt(request.getParameter("esex"));
			String egw=request.getParameter("egw");
			EmpEntity emp0=new EmpEntity();
			emp0.setEid(eid);
			emp0.setEname(ename);
			emp0.setEsex(esex);
			emp0.setEgw(egw);
			
			int a=emp.EmpModify(emp0);
            if(a>0)
            {
            	response.sendRedirect("./empServlet?code=1");
            }else
            {
            	System.out.println("ÐÞ¸ÄÊ§°Ü");
            }
			
		}else if(code.equals("4"))
		{
			String ename=request.getParameter("ename");
			int esex=Integer.parseInt(request.getParameter("esex"));
			String egw=request.getParameter("egw");
			EmpEntity emp0=new EmpEntity();
			emp0.setEname(ename);
			emp0.setEsex(esex);
			emp0.setEgw(egw);
			int a=emp.EmpAddInfo(emp0);
              if(a>0)
              {
            	  response.sendRedirect("./empServlet?code=1");
              }else
              {
            	  System.out.println("ÐÂÔöÊ§°Ü");
              }			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
