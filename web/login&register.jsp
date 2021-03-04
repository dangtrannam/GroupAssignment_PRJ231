<%-- 
    Document   : index.jsp
    Created on : Feb 27, 2021, 3:24:24 PM
    Author     : macbookpro2018
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            String action = (String) request.getParameter("action");
            String alert = (String) request.getParameter("alert");
            if (alert == null) alert = "";
            if(action==null) action="Register";
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
        <link rel="stylesheet" href="./css/login&register.css">

    </head>
    <body>
        <div class="container">
            <h1> <%=action%> page</h1>

            <form action="MainServlet" method="post" name="flogin">
                <input type="hidden" name ="action" value="handle<%=action%>">

                <label for="uname"><b>Username</b></label>
                <input type="text" placeholder="Username" name="uname" required>

                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Password" name="psw" required>

                <% if (action.equals("Register")) { %>
                <input type="password" placeholder="Re-password" name="re-psw" required>
                <button type="submit" >Register</button>
                <p>Already have an account? Click the link below</p>
                <a class="register" href="login&register.jsp?action=Login"> Login</a>
                <% } else { %>
                <button type="submit" >Login</button>
                <p>Don't have an account? Click the link below</p>
                <a class="register" href="login&register.jsp?action=Register"> Register</a>
                <% }%>
                
            </form>
        </div>

    </body>
</html>

<script>
    let alert = <%=alert %>;
    if (alert)
        window.alert(alert);
</script>
