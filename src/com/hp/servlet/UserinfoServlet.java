package com.hp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.Entity.UserEntity;
import com.hp.serivce.impl.UserinfoSerivceImpl;
import com.hp.serivce2.UserinfoSerivce;

/**
 * Servlet implementation class UserinfoServlet
 */
@WebServlet("/UserinfoServlet")
public class UserinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserinfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserinfoSerivce user=new UserinfoSerivceImpl();
		
		String code=request.getParameter("code");
		if(code.equals("1")){
		String uname=request.getParameter("uname");
		String upsw=request.getParameter("upsw");
		UserEntity use=new UserEntity();
		use.setUname(uname);
		use.setUpsw(upsw);
		String a=user.Verification(use);
		if(a!=null)
		{
			request.setAttribute("a",a);
			request.getRequestDispatcher("./main/main.jsp").forward(request, response);
		}else
		{
			System.out.println("µÇÂ¼Ê§°Ü");
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
