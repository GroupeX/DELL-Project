<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="dell.css" type="text/css" rel="stylesheet"/>
        <title>Dell MDF login</title>
    </head>
    <body>
        <div class="menu_wrapper">
            <img src="images/dell_logo.jpg" />
        </div>
        
        <div class="wrapper">
            
            <div class="title_cont">
                <h1>Dell MDF Planner login</h1>
            </div>
            
            <form method="post" action="login/login.jsp"><br>
                <input type="text" name="username" placeholder="Username" /><br><br>
                <input type="password" name="password" placeholder="Password" /><br><br>
                <input type="submit" name="login_submit" value="Login" />
            </form>
            
        </div>
        
    </body>
</html>
