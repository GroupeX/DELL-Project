<%@ page import ="java.sql.*" %>
<%
    String usern = request.getParameter("username");    
    String passw = request.getParameter("password");
    //Class.forName("com.mysql.jdbc.Driver");
    Class.forName("oracle.jdbc.OracleDriver");
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:dat",
            "SEM2_GR03", "SEM2_GR03");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from users where user_username='" + usern + "' and user_password='" + passw + "'");
    if (rs.next()) {
        
        //String status_id = rs.getString("fk_status_id");
        //session.setAttribute("user_status" , status_id);
        
        //if(session.getAttribute("user_status") == "1" ){
        //    out.print("Partner Logged In");
            //response.sendRedirect("../PartnerProposalStatus.jsp");
        //}
        //else if(session.getAttribute("status") == "2"){
        //    out.print("Dell Logged In");
            //response.sendRedirect("../PartnerProposalStatus.jsp");
        //}
        
        session.setAttribute("user_status", rs.getString("fk_status_id"));
        session.setAttribute("userid", usern);
        session.setAttribute("partner_id", rs.getString("fk_partner_id"));
        
        if(session.getAttribute("user_status").equals("1")){
            response.sendRedirect("../PartnerProposalStatus.jsp");
        }
        else if(session.getAttribute("user_status").equals("2")){
            response.sendRedirect("../DellDashboard.jsp");
        }
        
        //response.sendRedirect("success.jsp");
        
    } else {
        out.println("Invalid password <a href='../index.jsp'>try again</a>");
    }
%>
