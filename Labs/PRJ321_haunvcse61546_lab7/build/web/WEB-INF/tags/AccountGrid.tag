<%-- 
    Document   : AccountGrid
    Created on : Sep 28, 2015, 7:35:49 PM
    Author     : Hau
--%>

<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="dataSource" required="true" rtexprvalue="true" %>
<%@attribute name="sqlStatement" required="true"  %>
<%@tag dynamic-attributes="params" %>

<c:catch var="ex" >
    <sql:setDataSource dataSource="${dataSource}" var="con" />
    <c:if test="${not empty con}" >
        <sql:query var="rs" dataSource="${con}" >
            ${sqlStatement}
            <c:forEach var="par" items="${params}" >
                <sql:param value="${par.value}" />
            </c:forEach>
        </sql:query>
        <c:if test="${not empty rs}" >
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Username</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="record" items="${rs.rows}" varStatus="counter" >
                        <tr>
                            <td>
                                ${counter.count}
                            .</td>
                            <td>
                                ${record.username}
                            </td>
                            <td>
                                <a href="Controller?btAction=view&username=${record.username}&lastSearchValue=${param.txtSearchValue}">
                                    ViewDetail</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </c:if>
    
</c:catch>
<c:if test="${not empty ex}" >
    Occurs Errors:
    ${ex}
</c:if>

<%-- any content can be specified here e.g.: --%>