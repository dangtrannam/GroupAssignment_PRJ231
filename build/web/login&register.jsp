<%-- Document : index.jsp Created on : Feb 27, 2021, 3:24:24 PM Author : macbookpro2018 --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <% String action=(String) request.getAttribute("action"); String alert=(String)
                request.getAttribute("alert"); if (alert==null) { alert="" ; } if (action==null) action="Login" ; %>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>
                    <%=action%> page
                </title>
                <!--<link rel="stylesheet" href="./css/login&register.css">-->
                <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
                    id="bootstrap-css">
                <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
                <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        </head>

        <body>
            <div class="container  login-container">
                <div class="row">
                    <div class="col-md-6 login-form-1">
                        <h3>
                            <%=action%> page
                        </h3>
                        <form action="MainServlet" method="post" name="flogin">

                            <span class="message">${alert}</span>

                            <input type="hidden" name="action" value="handle<%=action%>">

                            <div class="form-group">
                                <label for="uname"><b>Username</b></label>
                                <input type="text" placeholder="Username" name="uname" required>
                            </div>

                            <div class="form-group">
                                <label for="psw"><b>Password</b></label>
                                <input type="password" placeholder="Password" name="psw" required>
                            </div>

                            <% if (action.equals("Register")) { %>
                                <input type="password" placeholder="Re-password" name="re-psw" required>
                                <button type="submit">Register</button>
                                <p>Already have an account? Click the link below</p>
                                <a class="register" href="MainServlet?action=Login"> Login</a>
                                <% } else { %>
                                    <button type="submit">Login</button>
                                    <p>Don't have an account? Click the link below</p>
                                    <a class="register" href="MainServlet?action=Register"> Register</a>
                                    <% }%>
                        </form>

                    </div>
                </div>






            </div>

        </body>

        </html>

        <script>
            function myAlert() {
                let alert = <%=alert%>;
                if (alert)
                    window.alert(alert);
            }
            myAlert();
        </script>