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
  
  
  
  
  <style type="text/css">
  
  		#parent {
   
}
  </style>
  
  
  </style>
  
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.0.min.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/jquery-ui.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-ui-1.10.4.custom.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-ui-timepicker-zh-CN.js"></script>
<style type="text/css">
.ui-timepicker-div .ui-widget-header { margin-bottom: 8px; }
.ui-timepicker-div dl { text-align: left; }
.ui-timepicker-div dl dt { float: left; clear:left; padding: 0 0 0 5px; }
.ui-timepicker-div dl dd { margin: 0 10px 10px 45%; }
.ui-timepicker-div td { font-size: 90%; }
.ui-tpicker-grid-label { background: none; border: none; margin: 0; padding: 0; }

.ui-timepicker-rtl{ direction: rtl; }
.ui-timepicker-rtl dl { text-align: right; padding: 0 5px 0 0; }
.ui-timepicker-rtl dl dt{ float: right; clear: right; }
.ui-timepicker-rtl dl dd { margin: 0 45% 10px 10px; }
</style>
  
  </head>
  
  <body onload="e();">
   <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>修改放映信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="./broadServlet?code=4&xid=${br.xid}">
    
    <table style="font-size: 13px;" >
    	 <tr>
    	 <td style="text-indent: 93px;">
    	 	电影信息&nbsp;：&nbsp;
    	 </td>
     	<td >  
     		 <select name="fid">
     		 <c:forEach items="${fimllist}" var="fimllist">
     		 <c:if test="${f0.fid==fimllist.fid}">
      			<option value="${fimllist.fid}" selected="selected">${fimllist.fname}</option>
      			</c:if>
      			
      		 <c:if test="${br.xid!=fimllist.fid}">
      			<option value="${fimllist.fid}">${fimllist.fname}</option>
      			</c:if>	
      			
      			</c:forEach>
      		</select>  
     	</td>
     </tr>
    </table>
    <br/>
    
     <table style="font-size: 13px;">
    	 <tr>
    	 <td style="text-indent: 93px;">
    	 	大厅信息&nbsp;：&nbsp;
    	 </td>
     	<td> 
     		 <select name="tid">
     		 <c:forEach items="${hList}" var="hList">
     		 <c:if test="${h0.tid==hList.tid}">
      			<option value="${hList.tid}" selected="selected">${hList.tname}</option>
      			</c:if>
      			
      		  <c:if test="${br.xid!=hList.tid}">
      			<option value="${hList.tid}">${hList.tname}</option>
      			</c:if>
      			
      			</c:forEach>
      		</select>  
     	</td>
     </tr>
    </table>
    <br/>
    
    <table style="font-size: 13px;">
    	 <tr>
    	 <td style="text-indent: 93px;">
    	 	员工信息&nbsp;：&nbsp;
    	 </td>
     	<td> 
     		 <select name="eid">
     		 <c:forEach items="${elist}" var="elist">
      			<c:if test="${e0.eid==elist.eid}">
      			<option value="${elist.eid}" selected="selected">${elist.ename}</option>
      			</c:if>
      			
      			<c:if test="${br.xid!=elist.eid}">
      			<option value="${elist.eid}">${elist.ename}</option>
      			</c:if>
      			</c:forEach>
      		</select>  
     	</td>
     </tr>
    </table>
    <br/>
    
    
      <div class="form-group">
        <div class="label">
          <label>开始时间：</label>
        </div>
        <div class="field">
          	<input name="begintime" id="begintime2" class="input" style="height:45px" value="${br.begintime}">
          <div class="tips"></div>
        </div>
      </div>
      
      <script type="text/javascript">
	$( "input[name='begintime'],input[name='act_stop_time']" ).datetimepicker();
</script>
      
            <div class="form-group">
        <div class="label">
          <label>结束时间：</label>
        </div>
        <div class="field">
          <input name="endtime" id="endtime" class="input" style="height:45px" value="${br.endtime}">
          
          <div class="tips"></div>
        </div>
      </div>
      
      <script type="text/javascript">
	$( "input[name='endtime'],input[name='act_stop_time']" ).datetimepicker();
</script>
              
      <div class="form-group">
        <div class="label">
          <label>票价：</label>
        </div>
        <div class="field">
          <textarea name="xmoney" class="input" id="xmoney2" style="height:45px;" >${br.xmoney}</textarea>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit" onclick="return getE();"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body></html>