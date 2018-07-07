<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 增加员工信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="../empServlet?code=4">
      
      <div class="form-group">
        <div class="label">
          <label>员工姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="ename" id="ename"/>
          <div class="tips"></div>
        </div>
      </div>  
          
      <div class="form-group">
        <div class="label">
          <label>员工性别：</label>
        </div>
        
        <div class="field"  style="padding-top: 9px;">
          <input type="radio" name="esex" value="1" checked="checked"/>男
          <input type="radio" name="esex" value="0"/>女
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>岗位：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="egw" id="egw"/>
          <div class="tips"></div>
        </div>
      </div> 
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit" onclick="return getD();"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body></html>