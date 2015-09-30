<%-- 
    Document   : myGrid
    Created on : Sep 28, 2015, 9:51:49 AM
    Author     : Hau
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="dataSource" required="true" rtexprvalue="true" %>
<%@attribute  name="sqlStatement" required="true" %>
<%@tag  dynamic-attributes="params"  %>

<%-- any content can be specified here e.g.: --%>
<c:catch var="ex" >
    <sql:setDataSource dataSource="${dataSource}" var="con" />
    <c:if test="${not empty con}" >
        ${sqlStatement}
        
        <c:forEach var="par" items="${params}" >
            <sql:param value="${par.value}" />
        </c:forEach>
    </c:if>
    
</c:catch>
<c:if test="${not empty ex}" >
    ${ex}
</c:if>
