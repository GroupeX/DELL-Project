<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="dell.css" type="text/css" rel="stylesheet"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include  file="partner_menu.jsp" %>
        <div class="wrapper">
            <div class="title_cont">
                <h1>Proposal Info</h1>
            </div>
            
        <div class="container">
            
            Status :
            <c:set var="val" value="${proposal.status}" />
            <c:choose>
                <c:when test="${val  == '1'}">
                    <span style="color: green;">Accepted </span><br>
                </c:when>
                <c:when test="${val  == '2'}">
                    <span style="color: red;">Declined </span><br>
                </c:when>
                <c:otherwise>
                    <span style="color: orange;">pending evaluation </span><br>
                </c:otherwise>
            </c:choose>
            
            Id : <strong>${proposal.id}</strong> <br>
            Title : <strong>${proposal.title}</strong><br>
            Budget : <strong>${proposal.budget}</strong><br>
            <br>Proposal text: <br>
            <strong>${proposal.text}</strong><br><br><br>
            <hr><br>
            
            <a href="PartnerProposalStatus.jsp">Back</a>
            
        </div>
    </body>
</html>
