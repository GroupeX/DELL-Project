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
    <title>JSP Page</title>
  </head>
  <body>

      <%@include file="partner_menu.jsp" %>  
    
    <div class="wrapper">
        <div class="title_cont">
            <h1>Campaigns</h1>
        </div>
        <div class="container">
            <table>
                <tr>
                    <th>ID</th>
                    <th>TITLE</th>
                    <th></th>
                </tr>
                
                <%
                    if (request.getAttribute("proposals") != null) {

                        ArrayList<Proposal> proposals = (ArrayList<Proposal>) request.getAttribute("proposals");
                        for (int i = 0; i < proposals.size(); i++) {
                %>
                    <form method="GET" action="PartnerCampaignInfoServlet">
                        <input type="hidden" name="proposalid" value="<%=proposals.get(i).getId()%>"/>
                        <tr>
                            <td><%=proposals.get(i).getId()%></td>
                            <td><%=proposals.get(i).getTitle()%></td>

                            <td><button type="submit">View</button></td>
                    </tr>
                    </form>

                    <%
                            }
                        }
                    %>


            </table>
                    
                <form action="PartnerShowCampaignsServlet" method="POST">
                    <input type="hidden" name="sess_partner_id" value="<%=session.getAttribute("partner_id")%>" /> 
                    <button type="submit"> Load campaigns</button>
                </form>
            
        </div>
    </div>
      
  </body>
</html>
