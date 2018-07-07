package com.hp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.Entity.FsortEntity;
import com.hp.serivce.impl.FsortSerivceImpl;
import com.hp.serivce2.FsortSerivce;

/**
 * Servlet implementation class FsortServlet
 */
@WebServlet("/FsortServlet")
public class FsortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FsortServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String code=request.getParameter("code");
		FsortSerivce fsort=new FsortSerivceImpl();
		if(code.equals("1"))
		{
			ArrayList<FsortEntity> FsortList=fsort.GetFsotrInfo();
			request.setAttribute("FsortEntity",FsortList);
			request.getRequestDispatcher("./fsort/all.jsp").forward(request,response);
			//request.getRequestDispatcher("./all.jsp").forward(request,response);
		}else if(code.equals("2"))
		{
			 int sid=Integer.parseInt(request.getParameter("sid")); 
			 FsortEntity f=new FsortEntity();
			 f.setSid(sid);
			FsortEntity FS=fsort.FsortReverseSelection(f);
			request.setAttribute("FS",FS);
			request.getRequestDispatcher("/fsort/update.jsp").forward(request, response);
		}else if(code.equals("3"))
		{
			 int sid=Integer.parseInt(request.getParameter("sid")); 

			String sname=request.getParameter("sname");
		
			String sremark=request.getParameter("sremark");
		
			FsortEntity f=new FsortEntity();
			f.setSid(sid);
			f.setSname(sname);
			f.setSremark(sremark);
			int a=fsort.FsortModify(f);
			if(a>0)
			{
				response.sendRedirect("./fsortServlet?code=1");
			}else
			{
				System.out.println("ÐÞ¸ÄÊ§°Ü");
			}
		}else if(code.equals("4"))
		{
			String sname=request.getParameter("sname");
			String sremark=request.getParameter("sremark");
			FsortEntity f=new FsortEntity();
			f.setSname(sname);
			f.setSremark(sremark);
			int a=fsort.FsorAddInfo(f);
			if(a>0)
			{
				response.sendRedirect("./fsortServlet?code=1");
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
