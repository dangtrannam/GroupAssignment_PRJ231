<%-- 
    Document   : profile
    Created on : Mar 18, 2021, 1:51:17 PM
    Author     : macbookpro2018
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/profile.css" >
    </head>
    <body>  
        <header>
            <div class="container">
                <!-- Start: Navigation with Search -->
                <nav role="navigation"
                     class="navbar navbar-dark navbar-expand-md bg-success border rounded navigation-clean-search relative">
                    <div class="container"><a class="navbar-brand homepage" href="MainServlet?action=viewQuiz&quiz=A1">Trang chủ</a>
                        <button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navcol-1">
                            <ul class="nav navbar-nav">
                                <li class="nav-item"><a class="nav-link" href="MainServlet?action=viewQuiz&quiz=A1">Thi thử­ A1</a></li>
                                <li class="nav-item"><a class="nav-link" href="MainServlet?action=viewQuiz&quiz=A2">Thi thử­­ A2</a></li>
                                <li class="nav-item"><a class="nav-link" href="MainServlet?action=viewQuiz&quiz=B1">Thi thử­­ B1</a></li>
                                <li class="nav-item"><a class="nav-link" href="MainServlet?action=viewQuiz&quiz=B2">Thi thử­­ B2</a></li>

                            </ul>

                            <div>
                                <c:choose >
                                    <c:when  test="${not empty sessionScope.user.userName}">
                                        <c:url value="MainServlet?action=ViewProfileController" var ="profileLink"></c:url>
                                        <a  href="${profileLink}" class="btn  btn-sm login " >Welcome <c:out value = "${sessionScope.user.userName}" /></a>
                                    </c:when>
                                    <c:otherwise>
                                        <c:url value="MainServlet?action=Login" var ="LoginLink"></c:url>
                                        <a  href="${LoginLink}" class="btn  btn-sm login " >Đăng nhập</a>
                                    </c:otherwise>
                                </c:choose>

                                <c:url value="MainServlet?action=Logout" var="LogoutLink"></c:url>
                                <a href="${LogoutLink}" class="btn btn-sm logout ">Đăng xuất</a>
                            </div>

                        </div>
                    </div>
                </nav>
                <h1 class="text-center text-white bg-info">ĐỀ THI THỬ BẰNG LÁI XE A1 200 CÂU HỎI MỚI NHẤT 2020</h1>
            </div>

        </header>

        <main>
            <div class="container">
                <div class="profile panel">
                    <form action="ChangePasswordController" method="POST">

                        <table border="1" cellpadding="10">
                            <c:set var="readonly" value="readonly" />
                            <tbody>
                                <tr>
                            <div class="form-group">
                                <td> <label for="UserName">Username: </label> </td>
                                <td> <input type="text" readonly name="UserName" class="form-control" value="${sessionScope.user.getUserName()}" > </td>
                            </div>


                            </tr>
                            <tr>
                                <c:if test="${state=='changePassword'}" var="isChangeState">
                                    <c:set var="readonly" value="" />
                                </c:if>
                            <div class="form-group">
                                <td> <label for="Password">Password </label> </td>
                                <td> <input type="text" ${readonly} name="Password" id="Password" class="form-control" value="${sessionScope.user.getPassword()}"> </td>
                            </div>
                            </tr>

                            <c:if test="${isChangeState}">
                                <tr>
                                <div class="form-group">
                                    <td> <label for="re-Password">Re-Password </label> </td>
                                    <td> <input type="text" ${readonly} name="re-Password" id="re-Password" class="form-control" value=""> </td>
                                </div>
                                </tr>
                            </c:if>


                            <tr>
                            <div class="form-group">
                                <td> <label for="role">Role </label> </td>
                                <td> <input type="text" id="role" readonly class="form-control" value="${sessionScope.user.getRole()}"> </td>
                            </div>

                            </tr>
                            </tbody>
                        </table>

                        <c:choose>
                            <c:when test="${isChangeState}">
                                <input type="hidden" value="confirm" name="confirm">
                                <button type="submit" class="btn btn-primary mt-3">Confirm change</button>
                            </c:when>
                            <c:otherwise>
                                <c:url var="changePassword" value="MainServlet?action=ChangePasswordController" />
                                <a href="${changePassword}" class="btn btn-primary text-white mt-3">Change password</a>
                            </c:otherwise>
                        </c:choose>


                    </form>

                    <c:url var="homepage" value="MainServlet?action=viewQuiz&quiz=A1" />
                    <a href="${homepage}"> Return to the homepage</a>
                </div>
            </div>
        </main>


        <footer>
            <div class="container">
                <div class="footer-basic panel">
                    <!-- Start: Links -->
                    <ul class="list-inline">
                        <li class="list-inline-item"><a href="#">Home</a></li>
                        <li class="list-inline-item"><a href="#">Services</a></li>
                        <li class="list-inline-item"><a href="#">About</a></li>
                        <li class="list-inline-item"><a href="#">Terms</a></li>
                        <li class="list-inline-item"><a href="#">Privacy Policy</a></li>
                    </ul><!-- End: Links -->
                    <!-- Start: Copyright -->
                    <p class="copyright">FPT University© 2021</p><!-- End: Copyright -->
                </div>
            </div>
        </footer>
    </body>
</html>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
