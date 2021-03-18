<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Thi bằng lái xe A1</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <link rel="stylesheet" href="./css/test.css">
    </head>

    <body>
        <header>
            <div class="container">
                <!-- Start: Navigation with Search -->
                <nav role="navigation"
                     class="navbar navbar-dark navbar-expand-md bg-success border rounded navigation-clean-search relative">
                    <div class="container"><a class="navbar-brand homepage" href="MainServlet?action=viewQuiz&type=A1">Trang chủ</a>
                        <button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navcol-1">
                            <ul class="nav navbar-nav">
                                <li class="nav-item"><a class="nav-link" href="MainServlet?action=viewQuiz&type=A1">Thi thử­ A1</a></li>
                                <li class="nav-item"><a class="nav-link" href="MainServlet?action=viewQuiz&type=A2">Thi thử­­ A2</a></li>
                                <li class="nav-item"><a class="nav-link" href="MainServlet?action=viewQuiz&type=B1">Thi thử­­ B1</a></li>
                                <li class="nav-item"><a class="nav-link" href="MainServlet?action=viewQuiz&type=B2">Thi thử­­ B2</a></li>

                            </ul>

                            <div>
                                <c:choose >
                                    <c:when  test="${not empty sessionScope.user.userName}">
                                        <c:url value="MainServlet?action=ViewProfile" var ="profileLink"></c:url>
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
            <c:if test="${not empty requestScope.ChosenAns}">
                <c:set var="state" value="review" />
                <c:set var="chosenAnsList" value="${requestScope.ChosenAns}" />
                <c:set var="grade" value="${requestScope.grade}" />
            </c:if>
            <c:set var="questions" value="${Quiz.getList()}"></c:set>

                <div class="container">
                    <form action="MainServlet?action=Submit" name="f-doquiz" method="post" id="f-doquiz">
                        <div class="row">

                            <div class="col-md-4">
                                <div class="panel panel-default" id="blockA">
                                    <div class="panel-body">
                                        <div style="margin: bottom 10px;">
                                            <strong style="font-size: 12pt; color: blue;">Câu hỏi | Đề số: 01 - 200 Câu Hỏi Thi A1</strong>
                                        </div>
                                        <div id="questionList">
                                        <c:forEach var="btn" begin="1" end="${questions.size()}">

                                            <label class="${requestScope.results.get(btn-1)} btn btn-success btn-cauhoi clickcauhoi btn-${btn} " id="show${btn}" data-id="data${btn}">
                                                <input type="radio" id="${btn}" data-id="data${btn}" >
                                                ${btn} 
                                            </label>

                                        </c:forEach>
                                    </div>
                                </div>
                            </div>


                            <c:choose >
                                <c:when test="${state=='review'}">
                                    <div id="blockB" class="panel panel-default">
                                        <div class="result">
                                            <strong>Kết quả bài làm</strong>
                                            <p>Đề: ${questions.get(0).getQuizID()}</p>
                                            <p>Số câu đúng: ${grade}</p>
                                            <p>Số câu sai: ${questions.size()-grade}</p>
                                            <c:set var="msg" value="KHÔNG ĐẠT" />
                                            <c:if test="${grade >= 23}" >
                                                <c:set var="msg" value="ĐẠT" />
                                            </c:if>
                                            <p>Kết quả: <span class="text-danger">${msg}</span></p>
                                            <p>Chưa trả lời: <span class="text-secondary">Màu xám</span></p>
                                            <p>Đáp án sai: <span class="text-danger">Màu đỏ</span></p>
                                            <p>Đáp án đúng: <span class="text-success"> Màu xanh</span></p>

                                        </div>
                                    </div>


                                    <c:set var="QuizType" value="${fn:substring(questions.get(0).getQuizID(),0,2)}" />
                                    <div id="blockC" class="panel panel-default">
                                        <div>
                                            <a class="btn btn-primary" href="MainServlet?action=viewQuiz&quiz=${QuizType}" >Chọn đề khác</a>
                                        </div>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div id="blockB" class="panel panel-default">

                                        <strong style="font-size:12pt; color:blue"> Thời gian còn lại:  <span id="countdown" class="timer"></span></strong>
                                    </div>

                                    <div id="blockC" class="panel panel-default">
                                        <div>
                                            <input type="submit" name="nopbai" id="nopbai" value="Nộp bài">
                                        </div>
                                    </div>
                                </c:otherwise>
                            </c:choose>


                        </div>

                        <div class="col-md-8">
                            <div class="panel panel-default" id="blockD">
                                <div class="panel-body">
                                    <div>

                                        <input type="hidden" name="QuizID" value="${questions.get(0).getQuizID()}">
                                        <c:set var="i" value="0"/>


                                        <c:forEach items="${questions}" var="question">
                                            <c:set var="i" value="${i+1}"/>
                                            <div class="row d-none ndcauhoi" id="cauhoi${i}"/>
                                            <div class="row">
                                                <div class="col-md-12 text-primary">
                                                    <strong>Câu hỏi ${i}:</strong>
                                                </div>

                                                <div class="col-12" style="text-align: justify;">
                                                    <strong>${question.getContent()}</strong>
                                                </div>
                                                <img class="col-12 img-responsive" src="" alt="">


                                                <c:set var="answers" value="${question.getListAnswer()}"></c:set>
                                                    <div class="col-md-12">
                                                    <c:set var="j" value="0"/>
                                                    <c:forEach items="${answers}" var="answer">

                                                        <c:set var="checked" value="" />
                                                        <c:if test="${state=='review'}" var="testState">
                                                            <c:set var="isRight" value="text-danger" />

                                                            <c:if test="${chosenAnsList.get(i-1) == j}" var="choseRight">
                                                                <c:set var="checked" value="checked" />
                                                            </c:if>
                                                            <c:if test="${answer.getIsCorrect().trim()=='true'}" var="IsRight">
                                                                <c:set var="isRight" value="text-success" />
                                                            </c:if>
                                                        </c:if>


                                                        <div class="cautraloi">
                                                            <label class="checkbox-inline ${isRight}">
                                                                <input type="radio" class="answer " name="${i-1}" value="${j}" ${checked} > ${answer.getContent()}
                                                            </label>
                                                        </div>


                                                        <c:set var="j" value="${j+1}"/>

                                                    </c:forEach>
                                                </div>
                                            </div>

                                        </div>

                                    </c:forEach>

                                    <div>
                                        <div>
                                            <ul class="pager d-flex justify-content-around">
                                                <li id="prev" onclick="showQuestion(${i-1})" class="previous cautruoc btn btn-primary float-left ">Câu trước</li>
                                                <li id="next" onclick="showQuestion(${i+1})"class="next causau btn btn-primary float-right">Câu sau</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>
            </div>

        </div>
    </form>
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
            <p class="copyright">FPT University Â© 2021</p><!-- End: Copyright -->
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



<script src="./js/test.js"></script>