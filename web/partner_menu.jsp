    <%@ page language="java" import="java.util.*" %>
    <div class="menu_wrapper">
    
        <img src="images/dell_logo.jpg" />
        
        <ul>
            <li><a href="PartnerProposalStatus.jsp">Proposal status</a></li>
            <li><a href="CreatePropasal.jsp">New proposal</a></li>
            <!--<li><a href="PartnerProposals.jsp">My proposals</a></li>-->
            <li><a href="PartnerViewCampaigns.jsp">My campaigns</a></li>
        </ul>
        
        <span style="float: right; margin-top: 30px; margin-right: 30px; color:#0085C3; background: white; padding:10px 20px;">
            PARTNER ADMIN
        </span>

        <span style="float: right; width: 1px; height: 55px; background: white; margin-top: 23px; margin-right: 20px;"></span>

        <span style="float: right; margin-top: 30px; margin-right: 20px; color:white; text-align: right;">
            Welcome, <%=session.getAttribute("userid")%><br>
            <a href='login/logout.jsp' style="color: #cccccc; text-decoration: none;"> Log out</a>
        </span>
        
      </div>
            
    <%
    for (Enumeration e = session.getAttributeNames(); e.hasMoreElements(); ) {     
        String attribName = (String) e.nextElement();
        Object attribValue = session.getAttribute(attribName);
    %>
    <BR><%= attribName %> - <%= attribValue %>

    <%
    }
    %>