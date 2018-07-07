<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  
  <body onload="d();">
   <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 选择放映大厅</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="./salaServlet?code=5">
      
      <table style="font-size: 12px;">
    	 <tr>
    	 <td style="text-indent: 76px;">
    	 	选择放映大厅&nbsp;：&nbsp;
    	 </td>
     	<td>
    
     		 <select name="tid">
     		  	<c:forEach items="${slist}" var="slist">
      		<option value="${slist.tid}">${slist.tname}</option>
      			</c:forEach>  
      		</select>
      		
      		<input type="hidden" name="xid" value="${xid}">
     	</td>
     </tr>
    </table>
    <br/>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit" onclick="return getD();"> 下一步</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body></html>