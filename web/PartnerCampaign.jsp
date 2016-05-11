<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DOMAIN.Poe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <h1>Campaign info</h1>
            </div>
            
            <div class="container">
                POE STATUS: <span style="color:orange;">Pending</span> <i style="color:gray;">(upload poe below)</i><br>
                Id : ${proposal.id} <br>
                Title : ${proposal.title}<br>
                Budget : ${proposal.budget}<br>
                <br>Proposal text: ${proposal.text}<br><br><br>
                
                <br><br>
                
                <hr>
                
                <br><br><strong>POE status</strong><br><br>
                
                <table>
                    <tr>
                        <th>link</th>
                        <th>status</th>
                        <th></th>
                    </tr>
                    

                    
                   
                <%

                    if (request.getAttribute("poe") != null) {

                        ArrayList<Poe> poe = (ArrayList<Poe>) request.getAttribute("poe");
                        for (int i = 0; i < poe.size(); i++) {

                %>
                <form method="GET" action="PartnerPoeListServlet">
                    <input type="hidden" name="fk_p_id" value="<%= request.getParameter("proposalid") %>"/>
                    <tr>
                        <td><%=poe.get(i).getPoe_link()%></td>
                        <td> <span style="color:orange">pending</span></td>
                        <td><a target="_blank" href="http://<%=poe.get(i).getPoe_link()%>">View link</a></td>
                    </tr>
                </form>
                <%
                        }
                    }
                %>
                
                </table>
                <form action="PartnerShowPoeServlet" method="POST">
                    <input type="hidden" name="prop_id" value="${proposal.id}" /> 
                    <button type="submit"> Load Poe</button>
                </form>
                
                <br><br><hr><br>
                
                <fieldset>
                    <legend><strong>POE upload</strong></legend>
                <form method="post" action="PartnerSubmitPoeServlet">
                    <input type="hidden" name="fk_prop_id" value="${proposal.id}" />
                    <br><br>Link : <input type="text" name="poe_link" placeholder="insert link" value=""/><br><br>
                    <button>Submit POE</button><br><br>
                </form>
                    
                </fieldset>
                
                <br><br>
                
            </div>
                
        </div>

    </body>
</html>
