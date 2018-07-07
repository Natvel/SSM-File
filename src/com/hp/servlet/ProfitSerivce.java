package com.hp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.Entity.BroadEntity;
import com.hp.Entity.EmpEntity;
import com.hp.Entity.FimlEntity;
import com.hp.Entity.HallEntity;
import com.hp.Entity.SaleEntity;
import com.hp.serivce.impl.BroadSerivceImpl;
import com.hp.serivce.impl.EmpSerivceImpl;
import com.hp.serivce.impl.FimlSerivceImpl;
import com.hp.serivce.impl.HallSerivceImpl;
import com.hp.serivce.impl.ProitSerivceImpl;
import com.hp.serivce2.BroadSerivce;
import com.hp.serivce2.EmpSerivce;
import com.hp.serivce2.FimlSerivce;
import com.hp.serivce2.HallSerivce;
import com.hp.serivce2.ProitSerivce;

/**
 * Servlet implementation class BroadServlet
 */
@WebServlet("/ProfitServlet")
public class ProfitSerivce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfitSerivce() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String code=request.getParameter("code");
		ProitSerivce pro=new ProitSerivceImpl();
		if(code.equals("1"))
		{
			ArrayList<SaleEntity> slist=pro.GetSalelInfo();
			request.setAttribute("slist",slist);
			request.getRequestDispatcher("./money/all2.jsp").forward(request, response);
		}else if(code.equals("2"))
		{
			
			int fid=Integer.parseInt(request.getParameter("fid"));
			SaleEntity sa=new SaleEntity();
			sa.setMid(fid);
			ArrayList<SaleEntity> slist=pro.GetSalelInfo2(sa);
			float Xmoney=pro.JiSuanOne(sa);
			request.setAttribute("slist",slist);
			request.setAttribute("Xmoney",Xmoney);
			request.getRequestDispatcher("./money/get.jsp").forward(request,response);
			
		}else if(code.equals("3"))
		{
			ArrayList<SaleEntity> slist=pro.TotalIncome();
			double a=pro.a();
			request.setAttribute("a",a);
			request.setAttribute("slist",slist);
			request.getRequestDispatcher("./money/all.jsp").forward(request, response);
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
