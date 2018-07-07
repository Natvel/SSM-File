<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setCharacterEncoding("utf-8"); %>
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
  
   <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath }/scripts/jquery.js"></script>
    <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath }/scripts/eye-base.js"></script>
    <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath }/scripts/eye-all.js"></script>
  
</head>
  
  
  
  <body onload="b();">
   <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 修改电影信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="./fimlServlet?code=3&fid=${Fiml.fid}">
     
     <table style="font-size: 13px;">
     	<tr>
     	<td style="text-indent: 93px;">
    	 	电影类别&nbsp;：&nbsp;
    	 </td>
     		<td>
     		
     			<select name="sid">
     			<c:forEach items="${fsortlist}" var="fs">
     			<c:if test="${Fiml.fsort.sid==fs.sid}">
     			<option value="${fs.sid}" selected="selected">${fs.sname}</option>  
     			 </c:if>
     			 
     			 <c:if test="${Fiml.fsort.sid!=fs.sid}">
     			<option value="${fs.sid}">${fs.sname}</option>  
     			 </c:if>
     			</c:forEach>
     </select>
     		</td>
     	</tr>
     </table>
     <br/>
     <div class="form-group">
        <div class="label">
          <label>电影名称：</label>
        </div>
        <div class="field">
          <textarea class="input" name="fname" id="fname" style="height:45px">${Fiml.fname}</textarea>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>主演：</label>
        </div>
        <div class="field">
          <textarea class="input" name="fauto" id="fauto" style="height:45px">${Fiml.fauto}</textarea>
          <div class="tips"></div>
        </div>
      </div>
      
            <div class="form-group">
        <div class="label">
          <label>上映时间：</label>
        </div>
        <div class="field">
          <textarea class="input" name="ontime"  id="time" style="height:45px" onClick="eye.datePicker.show(ontime);">${Fiml.ontime}</textarea>
          <div class="tips"></div>
        </div>
      </div>
              
      <div class="form-group">
        <div class="label">
          <label>电影备注：</label>
        </div>
        <div class="field">
          <textarea name="fremark" class="input"  style="height:120px;" id="fremark" >${Fiml.fremark}</textarea>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit" onclick="return getB();"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body></html>