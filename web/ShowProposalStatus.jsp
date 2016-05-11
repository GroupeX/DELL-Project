<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DOMAIN.Proposal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="dell.css" type="text/css" rel="stylesheet"/>
        <title>Propasal Status</title>
    </head>
    <body>

        <%@include file="dell_menu.jsp" %>  
        
        <div class="wrapper">

            <div class="title_cont">
                <h1>Show proposals</h1>
            </div>

            <div class="container">
                <table class="dell_prop">
                    <tr>
                        <th>Id</th>
                        <th>Partner</th>
                        <th>Title</th>
                        <th>Status</th>
                        <th>Budget</th>
                        <th>Action</th>
                    </tr>
                    <tr>


                        <%

                            if (request.getAttribute("proposals") != null) {

                                ArrayList<Proposal> proposals = (ArrayList<Proposal>) request.getAttribute("proposals");
                                for (int i = 0; i < proposals.size(); i++) {

                        %>

                    <form method="GET" action="DellEvaluateServlet">
                        <input type="hidden" name="proposalid" value="<%=proposals.get(i).getId()%>"/>
                        <tr>
                            <td><%=proposals.get(i).getId()%></td>
                            <td>s</td>
                            <td><%=proposals.get(i).getTitle()%></td>

                            <%if (proposals.get(i).getStatus() == null) {%>
                            <td><span style="color: orange;">Pending</span></td>
                            <%} else {%>

                            <% if (proposals.get(i).getStatus().equals("1")) { %>
                            <td><span style="color: green;">Accepted</span></td>
                            <%}%>

                            <% if (proposals.get(i).getStatus().equals("2")) { %>
                            <td><span style="color: red;">Declined</span></td>
                            <%}%>
                                   
                            <%
                                }%>


                            <td><%=proposals.get(i).getBudget()%></td>



                            <td><button type="submit">Evaluate</button></td>
                    </tr>
                    </form>

                    <%
                            }
                        }
                    %>

                    </tr>
                </table>
                    
                <form action="DellPartnerListServlet" method="POST">
                    <button type="submit"> Load </button>
                </form>
                    
            </div>

        </div>

    </body>
</html>

