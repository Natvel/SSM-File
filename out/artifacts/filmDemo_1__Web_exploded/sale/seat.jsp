<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>登录</title>  
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin.css">
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/js/pintuer.js"></script> 
  <script type="text/javascript" src="${pageContext.request.contextPath }/js.js"></script>
 
  </head>
  
  <body>
   <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 选择座位</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="./salaServlet?code=6" >
      
      <table style="font-size: 12px;">
    	 <tr>
    	 <td style="text-indent: 100px;">
    	 	选择座位&nbsp;：&nbsp;
    	 </td>
     	<td>
       <% int a=0; request.setAttribute("a",a); %> 
       <% String b="1"; request.setAttribute("b",b); %>	     	
     	<c:forEach var="i" begin="1" end="${seat}">
     		
     	<c:forEach items="${list}" var="list"  begin="0" end="${a}">
     		 
     	  <c:if test="${i==list.MZW}">	 
		<input type="checkbox" id="seat1" name="seat" value="${i}" checked="checked" readonly="readonly"/>${i}号座&nbsp;&nbsp;&nbsp;&nbsp;
		<% b="2";  request.setAttribute("b",b);%>
	      </c:if>	
	      
	        <c:if test="${i!=list.MZW}">	 
		<input type="checkbox" id="seat1" name="seat" value="${i}"/>${i}号座&nbsp;&nbsp;&nbsp;&nbsp;
		<%b="2"; request.setAttribute("b",b); %>
	      </c:if>	
	      
	      
		</c:forEach>
		
		 <c:if test="${b=='1'}">
	    <input type="checkbox" id="seat1" name="seat" value="${i}"/>${i}号座&nbsp;&nbsp;&nbsp;&nbsp;
	    </c:if>
		
		 <% a++; request.setAttribute("a",a); %> 
		
		
		<c:if test="${i%5==0}">
		<br/>
		<br/>
		<br/>
		</c:if>
		
		</c:forEach>
		
		<input type="hidden" name="xid" value="${xid}">		
		<br/>
      		 
     	</td>
     </tr>
    </table>
    <br/>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit" onclick="return getG();"> 完成</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body></html>