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
import com.hp.serivce.impl.BroadSerivceImpl;
import com.hp.serivce.impl.EmpSerivceImpl;
import com.hp.serivce.impl.FimlSerivceImpl;
import com.hp.serivce.impl.HallSerivceImpl;
import com.hp.serivce2.BroadSerivce;
import com.hp.serivce2.EmpSerivce;
import com.hp.serivce2.FimlSerivce;
import com.hp.serivce2.HallSerivce;

/**
 * Servlet implementation class BroadServlet
 */
@WebServlet("/BroadServlet")
public class BroadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BroadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String code=request.getParameter("code");
		FimlSerivce fiml=new FimlSerivceImpl();
		HallSerivce hall=new HallSerivceImpl();
		EmpSerivce emp=new EmpSerivceImpl();
		BroadSerivce bro=new BroadSerivceImpl();
		if(code.equals("1"))
		{
			ArrayList<BroadEntity> bList=bro.GetBroadInfo();
			request.setAttribute("bList",bList);
			request.getRequestDispatcher("./broad/all.jsp").forward(request, response);
		}else if(code.equals("2"))
		{
			int xid=Integer.parseInt(request.getParameter("xid"));
			int fflag=0;
			
			BroadEntity b=new BroadEntity();
		    b.setFflag(fflag);
			b.setXid(xid);
			int a=bro.BroadDelete(b);
			if(a>0)
			{
				response.sendRedirect("./broadServlet?code=1");
			}else
			{
				System.out.println("É¾³ýÊ§°Ü");
			}
		
		}else if(code.equals("3"))
		{
			
			int fid=Integer.parseInt(request.getParameter("fid"));
			int xid=Integer.parseInt(request.getParameter("xid"));
			int eid=Integer.parseInt(request.getParameter("eid"));
			int tid=Integer.parseInt(request.getParameter("tid"));
			
			EmpEntity e=new EmpEntity();
			e.setEid(eid);
			EmpEntity e0=emp.EmpReverseSelection(e);
			HallEntity h=new HallEntity();
			h.setTid(tid);
			FimlEntity f=new FimlEntity();
			HallEntity h0=hall.HallReverseSelection(h);
			f.setFid(fid);
			FimlEntity f0=fiml.FimlReverseSelection(f);
			BroadEntity b=new BroadEntity();
			b.setXid(xid);
			BroadEntity br=bro.brodReverseSelection(b);
			request.setAttribute("br",br);
			ArrayList<FimlEntity> fimllist=fiml.GetFimlInfo();
			ArrayList<HallEntity> hList=hall.GetFimlInfo();
			ArrayList<EmpEntity> elist=emp.GetEmpInfo();
			request.setAttribute("br",br);
			request.setAttribute("fimllist",fimllist);
			request.setAttribute("hList",hList);
			request.setAttribute("elist",elist);
			request.setAttribute("f0",f0);
			request.setAttribute("e0",e0);
			request.setAttribute("h0",h0);
			
			request.getRequestDispatcher("./broad/update.jsp").forward(request, response);
			
		}else if(code.equals("4"))
		{
			int xid=Integer.parseInt(request.getParameter("xid"));
			int tid=Integer.parseInt(request.getParameter("tid"));
			int fid=Integer.parseInt(request.getParameter("fid"));
			int eid=Integer.parseInt(request.getParameter("eid"));
			String begintime=request.getParameter("begintime");
			System.out.println(begintime);
			String endtime=request.getParameter("endtime");
			String xmoney=request.getParameter("xmoney");
		float xmoney2=Float.parseFloat(request.getParameter("xmoney"));
			
			BroadEntity br=new BroadEntity();
			FimlEntity fiml0=new FimlEntity();
			EmpEntity emp0=new EmpEntity();
			HallEntity hall0=new HallEntity();

	
			br.setXid(xid);
			br.setBegintime(begintime);
			br.setEndtime(endtime);
			br.setXmoney(xmoney2);
		
		fiml0.setFid(fid);
		emp0.setEid(eid);
		hall0.setTid(tid);
		
		
		br.setFiml(fiml0);
		br.setHall(hall0);
		br.setEmp(emp0);
		
		int a=bro.BroadModify(br);
		if(a>0)
		{
			response.sendRedirect("./broadServlet?code=1");
		}else
		{
			System.out.println("ÐÞ¸ÄÊ§°Ü");
		}
			
			
		}else if(code.equals("5"))
		{
			ArrayList<FimlEntity> fimllist=fiml.GetFimlInfo();
			ArrayList<HallEntity> hList=hall.GetFimlInfo();
			ArrayList<EmpEntity> elist=emp.GetEmpInfo();
			request.setAttribute("fimllist",fimllist);
			request.setAttribute("hList",hList);
			request.setAttribute("elist",elist);
			request.getRequestDispatcher("./broad/add.jsp").forward(request, response);
			
		}else if(code.equals("6"))
		{
			int tid=Integer.parseInt(request.getParameter("tid"));
			int fid=Integer.parseInt(request.getParameter("fid"));
			int eid=Integer.parseInt(request.getParameter("eid"));
			String begintime=request.getParameter("begintime");
			String endtime=request.getParameter("endtime");
			String xmoney=request.getParameter("xmoney");
		float xmoney2=Float.parseFloat(request.getParameter("xmoney"));
			
			BroadEntity br=new BroadEntity();
			FimlEntity fiml0=new FimlEntity();
			EmpEntity emp0=new EmpEntity();
			HallEntity hall0=new HallEntity();

	
			br.setBegintime(begintime);
			br.setEndtime(endtime);
			br.setXmoney(xmoney2);
		
		fiml0.setFid(fid);
		emp0.setEid(eid);
		hall0.setTid(tid);
		
		
		br.setFiml(fiml0);
		br.setHall(hall0);
		br.setEmp(emp0);
		
		int a=bro.BroadAddInfo(br);
		if(a>0)
		{
			response.sendRedirect("./broadServlet?code=1");
		}else if(code.equals("7"))
		{
			
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
