<%@ page contentType="text/html;charset=UTF-8" %><%@ page import="java.util.Enumeration"%><%@ include file="/jsp/common/taglibs.jsp"%>404 没有找到页面
<%
Enumeration e = request.getHeaders("Referer"); 
String a ; 
if(e.hasMoreElements()){ 
a=(String)e.nextElement(); 
}else{ 
a="直接访问"; 
}
out.println(a);
%>