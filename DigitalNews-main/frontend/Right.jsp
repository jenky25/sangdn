
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="t" class="dao.impl.DigitalDAOImpl" scope="request"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Right</title>
        <link href="css/right.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="right">
                <div class="newst">
                    <div class="titleNews">
                        <span>Digital News</span>
                    </div>
                    <div class="contentNews">
                        ${t.getTop(1).get(0).shortDes}
                    </div>
                </div>
                <div class="newst">
                    <div class="titleNews">
                        Search
                    </div>
                    <form action="SearchControl" method="post">                      
                        <% if (request.getAttribute("search") == null) { %>
                        <input class="searchBox" type="text" name="txtSearch" size="15" required>
                        <% }else{ %>
                        <input class="searchBox" type="text" name="txtSearch" size="15" value="${search}" required>
                        <% } %>
                        <input class="searchButton" type="submit" name="btnGo" value="Go">
                    </form>                        
                </div>
                <div class="newst">
                    <div class="titleNews">
                        <span>Last Articles</span><br>
                    </div>
                    <c:forEach items="${t.getTop(7)}" begin="1" end="6" var="i">
                    <div class="lastArticles">
                        <a href="DetailControl?id=${i.id}">${i.title}</a>
                    </div>
                </c:forEach>
            </div>
        </div>    
    </body>
</html>
