<%@ page contentType="text/html;charset=UTF-8" %><%@ include file="/jsp/common/taglibs.jsp"%>
500 报错
<br/>
<H1>错误：</H1><%=exception%>
<%
exception.printStackTrace(response.getWriter());
%>