<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 08.05.2020
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>bookmark-app</title>
</head>
    <body style="font-family:Arial;font-size:20px;">
        <div style="height:65px;align: center;background: #DB5227;font-family: Arial;color: white;">
        <br><b>
            <a href="" style="font-family:garamond;font-size:34px;margin:0px 0px 0px 10px;color:white;text-decoration: none;">bookmark-app</a></b>
            <div style="height:25px;background: #DB5227;font-family: Arial;color: white;">
                <b>
                    <a href="<%=request.getContextPath()%>/bookmark/mybooks" style="font-size:16px;color:white;margin-left:1150px;text-decoration:none;">My Books</a>
                    <a href="<%=request.getContextPath()%>/auth/logout" style="font-size:16px;color:white;margin-left:10px;text-decoration:none;">Logout</a>
                </b>
            </div>
        </div>
        <br><br>

        <table>
            <c:forEach var = "book" items="${books}">
                <tr>
                    <td>
                        <img src="${book.imageUrl}" width="175" height="200">
                    </td>

                    <td style="color:gray;">
                        By <span style="color: #B13100;">${book.authors[0]}</span>
                        <br><br>
                        Rating: <span style="color: #B13100;">${book.amazonRating}</span>
                        <br><br>
                        Publication Year: <span style="color: #B13100;">${book.publicationYear}</span>
                        <br><br>
                        <a href = "<%=request.getContextPath()%>/bookmark/save?bid=${book.id}" style="font-size:18px;color:#0058A6;font-weight:bold;text-decoration:none">Save</a>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                </tr>

            </c:forEach>

        </table>

    </body>
</html>
