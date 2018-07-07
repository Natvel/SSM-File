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
  <script type="text/javascript" src="${pageContext.request.contextPath }/js.js"></script></head>
  
 <body onload="c();">
   <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 修改大厅信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="./hallServlet?code=3&tid=${halle.tid}">
    
      <div class="form-group">
        <div class="label">
          <label>大厅名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="tname" value="${halle.tname}" id="tname" />
          <div class="tips"></div>
        </div>
      </div>  
              
      <div class="form-group">
        <div class="label">
          <label>座位数量：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="tcount" value="${halle.tcount}" id="tcount" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit" onclick="return getC();"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body></html>