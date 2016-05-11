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
            <h1>Create Proposal</h1>
        </div>
        <div class="container cp_cont">
            <form method="post" action="PartnerCreateProposalServlet">
                <input type="hidden" name="sess_partner_id" value="<%=session.getAttribute("partner_id")%>" /> 
                <input type="text" name="title" placeholder="Enter proposal title" value="" />
                <input type="text" name="budget" placeholder="budget" value="" />
                <textarea name="text">Default value
                       
                </textarea>
                <input type="submit" value="Create proposal" name="prop_submit" class="cp_button" />
            </form>
        </div>
    </div>
    

      
      <!--<a href="ShowProposalStatus.jsp">ShowProposal</a>-->
  </body>
</html>
