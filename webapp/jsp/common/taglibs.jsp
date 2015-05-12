<%@ taglib prefix="s" uri="/struts-tags" %><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" 
%><%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" 
%><%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" 
%><%@ taglib uri="oscache" prefix="cache" 
%><%@ page import="com.dihaitech.wxshop.common.Property" 
%><c:set var="ctx" value="${pageContext.request.contextPath}"
/><c:set var="base" value="<%=Property.BASE%>"
/><c:set var="actionExt" value="<%=Property.ACTION_EXT%>"/>