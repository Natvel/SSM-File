package com.hp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.Entity.BroadEntity;
import com.hp.Entity.FimlEntity;
import com.hp.Entity.HallEntity;
import com.hp.Entity.SaleEntity;
import com.hp.serivce.impl.FimlSerivceImpl;
import com.hp.serivce.impl.HallSerivceImpl;
import com.hp.serivce.impl.SaleSerivceImpl;
import com.hp.serivce2.FimlSerivce;
import com.hp.serivce2.HallSerivce;
import com.hp.serivce2.SaleSerivce;

/**
 * Servlet implementation class SalaServlet
 */
@WebServlet("/SalaServlet")
public class SalaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String code=request.getParameter("code");
		SaleSerivce sale=new SaleSerivceImpl();
		HallSerivce hall=new HallSerivceImpl();
		if(code.equals("1"))
		{
			ArrayList<SaleEntity> slist=sale.GetSalelInfo();
			request.setAttribute("slist",slist);
			request.getRequestDispatcher("./sale/all.jsp").forward(request, response);
			
			
		}else if(code.equals("2"))
		{
			ArrayList<FimlEntity> flist=sale.GetMoveInfo();
			request.setAttribute("flist",flist);
			request.getRequestDispatcher("./sale/film.jsp").forward(request, response);
		}else if(code.equals("3"))
		{
			int id=Integer.parseInt(request.getParameter("id"));		
			SaleEntity s0=new SaleEntity();
			s0.setMid(id);
			ArrayList<SaleEntity> slist=sale.GetMoveInfo2(s0);
			request.setAttribute("slist",slist);
			request.getRequestDispatcher("./sale/bro.jsp").forward(request, response);
		}else if(code.equals("4"))
		{
			int fid=Integer.parseInt(request.getParameter("fid"));
			int xid=Integer.parseInt(request.getParameter("xid"));
			HallEntity h=new HallEntity();
			h.setTid(xid);
			ArrayList<HallEntity> slist=sale.GetZuoWei(h);
			request.setAttribute("slist",slist);
			request.setAttribute("xid",xid);			
			request.getRequestDispatcher("./sale/hall.jsp").forward(request, response);
		}else if(code.equals("5"))
		{
			int tid=Integer.parseInt(request.getParameter("tid"));
			
			//获取座位数量
			HallEntity ha=new HallEntity();
			ha.setTid(tid);
				
			int seat=hall.getSeat(ha);
			request.setAttribute("seat",seat);
			
			//获取已购买座位
			int xid=Integer.parseInt(request.getParameter("xid"));
			BroadEntity br=new BroadEntity();
			br.setXid(xid);
			SaleEntity sa=new SaleEntity();
			sa.setBr(br);
			ArrayList<SaleEntity> list=sale.ReverseSelectionZuoWei(sa);
			request.setAttribute("list",list);		
			request.setAttribute("xid",xid);
			request.getRequestDispatcher("./sale/seat.jsp").forward(request, response);
		
			/*int tid=Integer.parseInt(request.getParameter("tid"));
			
			int xid=Integer.parseInt(request.getParameter("xid"));
			SaleEntity sa=new SaleEntity();
			BroadEntity br=new BroadEntity();
			HallEntity ha=new HallEntity();
			
			ha.setTid(tid);
			br.setXid(xid);
			br.setHall(ha);
			sa.setBr(br);
			ArrayList<SaleEntity> list=sale.ReverseSelectionZuoWei(sa);
			int seat=hall.getSeat(ha);
			int a=sale.modifyhall(br);
			if(a>0)
			{
				request.setAttribute("xid",xid);
				request.setAttribute("seat",seat);
				request.setAttribute("list",list);
				request.getRequestDispatcher("./sale/seat.jsp").forward(request, response);
			}else
			{
				System.out.println("修改错误");
			}*/
		
		}else if(code.equals("6"))
		{
			String seat=request.getParameter("seat");
			int xid=Integer.parseInt(request.getParameter("xid"));
			SaleEntity sa=new SaleEntity();
			BroadEntity br=new BroadEntity();
			sa.setMzw(seat);
			br.setXid(xid);
			sa.setBr(br);
			int a=sale.SaleAddInfo(sa);
			if(a>0)
			{
				response.sendRedirect("./salaServlet?code=1");
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
