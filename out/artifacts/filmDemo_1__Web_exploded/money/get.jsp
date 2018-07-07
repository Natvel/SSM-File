<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>登录</title>  
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin.css">
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/js/pintuer.js"></script> 
    <style type="text/css">
       *{
        font-size: 12px;
       }
    </style>

  </head>
  
  <body>

  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 操作信息管理</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
        <li>
          
          <%--<button type="submit" class="button border-red"><span class="icon-trash-o"></span> 批量删除</button>
        --%></li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        
        <th>已卖出的座位</th>       
        <th>票价</th>
        <th>小计</th>
        
           
      </tr>
      <c:forEach items="${slist}" var="slist"> 
      	<tr>
      		<td>
      		${slist.mzw}
      		</td>
      		
      		<td>
      		${slist.br.xmoney}
      		</td>
      		
      		<td>
      		${slist.br.xmoney}
      		</td>
      		
      		
      	</tr>   
       </c:forEach> 
      <tr>
      	<td colspan="7" align="center">
      		<h4>合计总收益:${Xmoney}</h4>
      	</td>
      </tr>
      
       <tr>
       		<td colspan="8" align="center">
				<a href="./profit?code=1"><button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 返回上一级</button></a>
			</td>
       </tr>
       
    </table>
  </div>


</body></html>
