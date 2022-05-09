<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Question 1</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>*{font-family: sans-serif} a{text-decoration: none; color: #000;}</style>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Totaux</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${resultat2}" var="rs">
                    <c:choose>
                        <c:when test="${rs[1] < 20}">
                            <tr style="background-color: red;">      
                                <td>${rs[0]}</td>
                                <td>${rs[1]}</td>  
                            </tr>
                        </c:when>    
                        <c:otherwise>
                            <tr>      
                                <td>${rs[0]}</td>
                                <td>${rs[1]}</td>  
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </tbody>
        </table>
        
        <a href="index.html" style="color: blue;">Go Home</a>
    </body>
</html>
