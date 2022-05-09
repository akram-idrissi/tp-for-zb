<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Question 1</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>*{
                font-family: sans-serif
            }
            a{
                text-decoration: none;
                color: #000;
            }</style>
    </head>
    <body>
        <h1>Rechercher une Absence</h1>
        <form action="question1">
            <table>
                <tbody>
                    <tr>
                        <td>
                            <label>Id de l'absence</label>
                            <input type="hidden" name="action" value="rechercher">
                            <input type="text" id="abs-search" name="id-absence-r" >
                            <button type="submit" id="search">Rechercher</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>

        <c:if test="${resultat != null}">
            <div>
                <p>ID Absence: ${resultat.getInt(1)}</p>
                <p>Date Absence: ${resultat.getString(2)}</p>
                <p>ID Stagiare: ${resultat.getInt(3)}</p>
                <p>ID Module: ${resultat.getInt(4)}</p>
                <p>Type D'Absence: ${resultat.getString(5)}</p>
            </div> 
        </c:if>    

        <h1>Ajouter une Absence</h1>
        <form action="question1">
            <table>
                <tbody>
                    <tr>
                        <td><label>Date</label></td>
                        <td><input type="text" name="date-absence-a">   </td>                            
                    </tr>

                    <tr>
                        <td><label>Id Stagiaire</label></td>
                        <td><input type="text" name="id-stagiaire-a"></td>                            
                    </tr>

                    <tr>
                        <td><label>Id Module</label></td>
                        <td><input type="text" name="id-module-a"></td>                            
                    </tr>

                    <tr>
                        <td><label>Type Absence</label></td>
                        <td><input type="text" name="type-absence-a"></td>                            
                    </tr>

                    <tr>
                        <td>
                            <input type="hidden" name="action" value="ajouter">
                            <button type="submit">Ajouter</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>

        <h1>Supprimer une Absence</h1>
        <form action="question1">
            <table>
                <tbody>
                    <tr>
                        <td>
                        <td><input type="hidden" name="action" value="supprimer"></td>
                <label>Id de l'absence</label>
                <input type="text" name="id-absence-s" >
                <button type="submit">Supprimer</button>
                </td>
                </tr>
                </tbody>
            </table>
        </form>
        <a href="index.html" style="color: blue;">Go Home</a>
        
    </body>
</html>
