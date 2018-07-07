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
  <script type="text/javascript" src="${pageContext.request.contextPath }/js.js"></script></head>
  
  <body onload="a();">
   <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>修改电影类别</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="./fsortServlet?code=3&sid=${FS.sid}">
      <div class="form-group">
        <div class="label">
          <label>电影类别:</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="sname" value="${FS.sname}" id="sname" />
          <div class="tips"></div>
        </div>
      </div>  
              
      <div class="form-group">
        <div class="label">
          <label>电影备注：</label>
        </div>
        <div class="field">
          <textarea name="sremark" class="input" style="height:120px;" id="sremark" >${FS.sremark}</textarea>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit" onclick="return getA();" >提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body></html>