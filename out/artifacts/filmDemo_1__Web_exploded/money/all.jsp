<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        
        <th>电影名称</th>
        <th>放映大厅</th>
        <th>放映时间</th>
        <th>结束时间</th>
        <th>已购票总数</th>
        <th>票价(￥)</th>
        <th>总收益(￥)</th>     
      </tr>
      
    <c:forEach items="${slist}" var="slist">
      	<tr>
      		<td>
      			${slist.br.fiml.fname}
      		</td>
      		<td>
      			${slist.br.hall.tname}
      		</td>
      		<td>
      			${slist.br.begintime}
      		</td>
      		<td>
      			${slist.br.endtime}
      		</td>
      		<td>
      			${slist.number}
      		</td>
      		<td>
      			${slist.br.xmoney}
      		</td>
      		<td>
      			${slist.number*slist.br.xmoney}
      		</td>
		
			</tr>
			
			</c:forEach>
      <tr>
      	<td colspan="7" align="center"><h4>合计总收益：${a}</h4></td>
      </tr> 
       
       
       </table>
  </div>


</body></html>
