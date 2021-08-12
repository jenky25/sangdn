
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="t" class="dao.impl.DigitalDAOImpl" scope="request"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body> 
       <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <div class="main">
                    <%
                        if (request.getAttribute("one") == null) {
                    %>
                    <div class="tittle">
                        ${t.getTop(1).get(0).title}
                    </div>
                    <div class="image">
                        <img src="images/${t.getTop(1).get(0).image}"/>
                    </div>
                    <div class="text">
                        ${t.getTop(1).get(0).description} 
                    </div>
                    <div class="signature">
                        <div class="icon1"></div>
                        <div class="icon2"></div>
                        By ${t.getTop(1).get(0).author} | ${t.getTop(1).get(0).timePost}
                    </div>
                    <% } else {%>
                    <div class="tittle">
                        ${one.title}
                    </div>
                    <div class="image">
                        <img src="images/${one.image}"/>
                    </div>
                    <div class="text">
                        ${one.description} 
                    </div>
                    <div class="signature">
                        <div class="icon1"></div>
                        <div class="icon2"></div>
                        By ${one.author} | ${one.timePost}
                    </div>
                    <% }%>
                </div>
                <jsp:include page="Right.jsp"/> 
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
