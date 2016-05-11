<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DOMAIN.Proposal"%>
<%@ page import ="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link href="dell.css" type="text/css" rel="stylesheet"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Create Propasal</title>
  </head>
  <body>

      <%@include file="partner_menu.jsp" %>  
    
    <div class="wrapper">
        <div class="title_cont">
            <h1>Proposal Status</h1>
        </div>
        <div class="container">
            
            <table >
                
                <tr>
                    <th>ID</th>
                    <th>TITLE</th>
                    <th>STATUS</th>
                    <th></th>
                </tr>
                
                <%

                    if (request.getAttribute("proposals") != null) {

                        ArrayList<Proposal> proposals = (ArrayList<Proposal>) request.getAttribute("proposals");
                        for (int i = 0; i < proposals.size(); i++) {

                %>
                    <form method="GET" action="PartnerProposalInfoServlet">
                        <input type="hidden" name="proposalid" value="<%=proposals.get(i).getId()%>"/>
                        <tr>
                            <td><%=proposals.get(i).getId()%></td>
                            <td><%=proposals.get(i).getTitle()%></td>

                            <%if (proposals.get(i).getStatus() == null) {%>
                            <td><span style="color: orange;">Pending</span></td>
                            <%} else {%>

                            <% if (proposals.get(i).getStatus().equals("1")) { %>
                            <td><span style="color: green;">Accepted</span></td>
                            <%}%>

                            <% if (proposals.get(i).getStatus().equals("2")) { %>
                            <td><span style="color: red;">Declined</span></td>
                            <%}
                                }%>



                            <!-- som standart er det pending og farve gul/orange, hvis man evaluerer bliver den anden farve, 
                            fx declined = rød eller accepted=grøn-->
                            <td><button type="submit">View Proposal</button></td>
                    </tr>
                    </form>

                    <%
                            }
                        }
                    %>

                    </tr>
                </table>
                    
                <form action="PartnerProposalListServlet" method="POST">
                    <input type="hidden" name="sess_partner_id" value="<%=session.getAttribute("partner_id")%>" /> 
                    <button type="submit"> Load proposals</button>
                </form>
                    
        </div>
    </div>
      
  </body>
</html>
