<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="dell.css" type="text/css" rel="stylesheet"/>
<title>View proposal</title>
</head>
<body>
    
    <%@include file="dell_menu.jsp" %>  
    
    <div class="wrapper">
        
        <div class="title_cont">
            <h1>Evaluate Proposal</h1>
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
            <form method="GET" action="DellEvaluateServlet">
                

                <input type="hidden" name="ChangeStatusForId" value="${proposal.id}"/>
                <button type="submit" name="StatusChanged" value="1" > Accept </button>
                <button type="submit" name="StatusChanged" value="2" > Decline </button>
            </form>
                <br><hr><br>
            <form method="post" action="DellDeleteProposalServlet">
                <input type="hidden" value="${proposal.id}" name="del_prop_id" />
                <button type="submit" name="del_button" value="3"  onClick="return confirm('Are you sure you want to delete this proposal?')"> delete </button>
            </form>
            
        </div>
        
    </div>

</body>
</html>
