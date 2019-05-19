<%--
  Created by IntelliJ IDEA.
  User: vmtr0
  Date: 18.05.2019
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Start page</title>
</head>
<body>

<table style="background-color: lightgray" border="black">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Tool type</th>
        <th>Avaiable</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${applicationScope.tools}" var="tool">
        <tr>


            <c:choose>

                <c:when test="${tool.available}">
                    <td bgcolor="green">${tool.id}</td>
                    <td bgcolor="green">${tool.name}</td>
                    <td bgcolor="green">${tool.type}</td>
                    <td style="background-color: lawngreen"></td>
                    <td style="background-color: green; vertical-align: middle; padding: 10px" >
                        <form>
                            <input type="hidden" name="action" value="take">
                            <input type="hidden" name="id" value="${tool.id}">
                            <input type="submit" value=" Take " style="width: 100%; height: 100%; top: 10px; vertical-align: middle">
                        </form>
                    </td>
                </c:when>
                <c:otherwise>
                    <td bgcolor="#ff6347">${tool.id}</td>
                    <td bgcolor="#ff6347">${tool.name}</td>
                    <td bgcolor="#ff6347">${tool.type}</td>
                    <td style="background-color: red"></td>
                    <td align="center" bgcolor="#ff6347" style="padding: 10px">
                        <form>
                            <input type="hidden" name="action" value="return">
                            <input type="hidden" name="id" value="${tool.id}">
                            <input type="submit" value="Return">
                        </form>
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
</table>
</body>
</html>
