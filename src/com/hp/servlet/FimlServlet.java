package com.hp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.Entity.FimlEntity;
import com.hp.Entity.FsortEntity;
import com.hp.serivce.impl.EmpSerivceImpl;
import com.hp.serivce.impl.FimlSerivceImpl;
import com.hp.serivce.impl.FsortSerivceImpl;
import com.hp.serivce2.EmpSerivce;
import com.hp.serivce2.FimlSerivce;
import com.hp.serivce2.FsortSerivce;

/**
 * Servlet implementation class FimlServlet
 */
@WebServlet("/FimlServlet")
public class FimlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FimlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		FimlSerivce fiml=new FimlSerivceImpl();
		FsortSerivce fsort=new FsortSerivceImpl();
		EmpSerivce emp=new EmpSerivceImpl();
		String code=request.getParameter("code");
		//查询
		if(code.equals("1"))
		{
			ArrayList<FimlEntity> fimllist=fiml.GetFimlInfo();
			request.setAttribute("fimllist",fimllist);
			request.getRequestDispatcher("./film/all.jsp").forward(request, response);
			
		}
		//反选
		else if(code.equals("2"))
		{
			 int fid=Integer.parseInt(request.getParameter("fid")); 
			 FimlEntity Fiml0=new FimlEntity();
			 Fiml0.setFid(fid);
			FimlEntity Fiml=fiml.FimlReverseSelection(Fiml0);
			
			ArrayList<FsortEntity> fsortlist=fsort.GetFsotrInfo();
			request.setAttribute("fsortlist",fsortlist);
			request.setAttribute("Fiml",Fiml);
			request.getRequestDispatcher("./film/update.jsp").forward(request, response);
			
		}else if(code.equals("3"))
		{
			int sid=Integer.parseInt(request.getParameter("sid"));
			String fname=request.getParameter("fname");
			String fauto=request.getParameter("fauto");
			String ontime=request.getParameter("ontime");
			String fremark=request.getParameter("fremark");
			int fid=Integer.parseInt(request.getParameter("fid"));
			FsortEntity fs=new FsortEntity();
			 FimlEntity Fiml=new FimlEntity();
			 fs.setSid(sid);
			 Fiml.setFname(fname);
			 Fiml.setFauto(fauto);
			 Fiml.setOntime(ontime);
			 Fiml.setFsort(fs);
			 Fiml.setFremark(fremark);
			 Fiml.setFid(fid);
			 int a=fiml.FimlModify(Fiml);
			 if(a>0)
			 {
				 response.sendRedirect("./fimlServlet?code=1");
			 }else
			 {
				 System.out.println("修改失败");
			 }
			
		}else if(code.equals("4"))
		{		
			ArrayList<FsortEntity> fsortList=fsort.GetFsotrInfo();
			request.setAttribute("fimlList",fsortList);
			request.getRequestDispatcher("./film/add.jsp").forward(request, response);		
		}else if(code.equals("5"))
		{
			int sid=Integer.parseInt(request.getParameter("sid"));
			String fname=request.getParameter("fname");
			String fauto=request.getParameter("fauto");
			String ontime=request.getParameter("ontime");
			String fremark=request.getParameter("fremark");
			FsortEntity fs=new FsortEntity();
			 FimlEntity Fiml=new FimlEntity();
			 fs.setSid(sid);
			 Fiml.setFname(fname);
			 Fiml.setFauto(fauto);
			 Fiml.setOntime(ontime);
			 Fiml.setFremark(fremark);
			 Fiml.setFsort(fs);
			int a=fiml.FimlAddInfo(Fiml);
			if(a>0)
			{
				response.sendRedirect("./fimlServlet?code=1");
			}else
			{
				System.out.println("新增失败");
			}	
		}else if(code.equals("6"))
		{
			int fid=Integer.parseInt(request.getParameter("fid"));
			 FimlEntity Fiml=new FimlEntity();
			 Fiml.setFid(fid);		 			
			int a=fiml.LowerFrame(Fiml);
			if(a>0)
			{
				response.sendRedirect("./fimlServlet?code=1");
			}else
			{
				System.out.println("下架失败");
			}
			
			
		}else if(code.equals("7"))
		{
			ArrayList<FimlEntity> fimllist=fiml.GetLowerFrame();
			request.setAttribute("fimllist",fimllist);
			request.getRequestDispatcher("./film/shang.jsp").forward(request, response);
			
		}else if(code.equals("8"))
		{
			int fid=Integer.parseInt(request.getParameter("fid"));
			FimlEntity Fiml=new FimlEntity();
			 Fiml.setFid(fid);
			 int a=fiml.OnTheShelf(Fiml);
				if(a>0)
				{
					response.sendRedirect("./fimlServlet?code=7");
				}else
				{
					System.out.println("上架失败");
				}
		}else
		{
			System.out.println("系统错误");
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
