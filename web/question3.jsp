<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>*{font-family: sans-serif} a{text-decoration: none; color: #000;}</style>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>Module</th>
                    <th>Nombre D'Absence</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${r1}" var="rs">
                    <tr>      
                        <td>${rs[0]}</td>
                        <td>${rs[1]}</td>  
                    </tr>
                </c:forEach>
            </tbody>
        </table>



        <table border="1">
        </tbody>
        <thead>
            <tr>
                <th>Stagiaire</th>
                <th>Nombre D'Absence</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${r2}" var="rss">
                <tr>      
                    <td>${rss[0]}</td>
                    <td>${rss[1]}</td>  
                </tr>
            </c:forEach>

        </tbody>
    </table>






    <form action="question3" style="margin: 10px 0;">
        <label>ID Stagiaire</label>
        <input type="type" name="id-stagiaire-r">
        <button type="submit">Submit</button>
    </form>

    <table border="1">
    </tbody>
    <thead>
        <tr>
            <th>Stagiaire</th>
            <th>Module</th>
            <th>Nombre D'Absence</th>
        </tr>
    </thead>
    <tbody>

        <c:forEach items="${r3}" var="rs">
            <tr>      
                <td>${rs[0]}</td>
                <td>${rs[1]}</td> 
                <td>${rs[2]}</td>  
            </tr>
        </c:forEach>

    </tbody>
</table>
<a href="index.html" style="color: blue;">Go Home</a>

</body>
</html>
