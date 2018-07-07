package com.hp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.Entity.HallEntity;
import com.hp.serivce.impl.HallSerivceImpl;
import com.hp.serivce2.HallSerivce;

/**
 * Servlet implementation class HallServlet
 */
@WebServlet("/HallServlet")
public class HallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String code=request.getParameter("code");
		HallSerivce hall=new HallSerivceImpl();
		if(code.equals("1"))
		{
			ArrayList<HallEntity> hList=hall.GetFimlInfo();
			request.setAttribute("hList",hList);
			request.getRequestDispatcher("./hall/all.jsp").forward(request, response);
		}
		//修改的反选
		if(code.equals("2"))
		{
			int tid=Integer.parseInt(request.getParameter("tid")); 
			HallEntity halle0=new HallEntity();
			halle0.setTid(tid);
			HallEntity halle=hall.HallReverseSelection(halle0);
			request.setAttribute("halle",halle);
			request.getRequestDispatcher("./hall/update.jsp").forward(request, response);
		}if(code.equals("3"))
		{
			int tid=Integer.parseInt(request.getParameter("tid"));
			String tname=request.getParameter("tname");
			int tcount=Integer.parseInt(request.getParameter("tcount"));
			HallEntity halle0=new HallEntity();
			halle0.setTname(tname);
			halle0.setTcount(tcount);
			halle0.setTid(tid);
			int a=hall.FimlModify(halle0);
			if(a>0)
			{
				response.sendRedirect("./hallServlet?code=1");
			}else
			{
				System.out.println("修改失败");
			}
		}if(code.equals("4"))
		{
			String tname=request.getParameter("tname");
			int tcount=Integer.parseInt(request.getParameter("tcount"));
			HallEntity halle0=new HallEntity();
			halle0.setTname(tname);
			halle0.setTcount(tcount);
			int a=hall.HallAddInfo(halle0);
			if(a>0)
			{
				response.sendRedirect("./hallServlet?code=1");
				
			}else
			{
				System.out.println("新增失败");
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
