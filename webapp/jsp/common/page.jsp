<%@ page contentType="text/html;charset=UTF-8" %>
<c:if test="${pageInfo.totalPage>1}">
<fmt:formatNumber value="${(pageInfo.page/8) - 0.55}" pattern="#0" var="tmpIndex"></fmt:formatNumber>
<c:set value="${(tmpIndex * 8) + 1}" var="pageBegin" scope="page"/>
<c:if test="${pageBegin <= 0}">
<c:set value="1" var="pageBegin" scope="page"/>
</c:if>
<c:set value="${pageInfo.totalPage}" var="pageEnd" scope="page"/>
<c:if test="${pageInfo.totalPage > (tmpIndex + 1) * 8}">
	<c:set value="${(tmpIndex + 1) * 8}" var="pageEnd" scope="page"/>
</c:if>
<div class="floatr">
<c:if test="${pageInfo.page!=1 && pageInfo.page!=0}">
<a href="#" onclick="JavaScript:goPage('${pageInfo.previousPage}');">${pageScope.page}&lt;&lt;上一页</a>
</c:if>
<c:forEach begin="${pageScope.pageBegin}" end="${pageScope.pageEnd}" step="1" varStatus="s"><c:choose><c:when test="${s.current == pageInfo.page}">&nbsp;<b>第${s.current}页</b></c:when><c:otherwise>&nbsp;<a href="#" onclick="JavaScript:goPage('${s.current}');">第${s.current}页</a></c:otherwise></c:choose></c:forEach>
<c:if test="${pageInfo.page!=pageInfo.totalPage }">
<a href="#" onclick="JavaScript:goPage('${pageInfo.nextPage}');">下一页&gt;&gt;</a>
</c:if>
 共${pageInfo.resultCount}条，${pageInfo.totalPage}页。</div>
 </c:if>