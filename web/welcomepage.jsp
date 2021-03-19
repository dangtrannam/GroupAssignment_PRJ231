<%-- 
    Document   : mainHomepage
    Created on : Mar 18, 2021, 10:49:21 PM
    Author     : macbookpro2018
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main  Homepage</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/home.css">
    </head>
    <body>
        <header>
            <div class="container">
                <!-- Start: Navigation with Search -->
                <nav role="navigation"
                     class="navbar navbar-dark navbar-expand-md bg-success border rounded navigation-clean-search relative">
                    <div class="container"><a class="navbar-brand homepage" href="MainServlet">Trang chủ</a>
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
                                        <c:url value="MainServlet?action=ViewProfileController" var ="profileLink"></c:url>
                                        <a  href="${profileLink}" class="btn  btn-sm login " >Welcome <c:out value = "${sessionScope.user.userName}" /></a>
                                        <c:url value="MainServlet?action=Logout" var="LogoutLink"></c:url>
                                        <a href="${LogoutLink}" class="btn btn-sm logout ">Đăng xuất</a>
                                    </c:when>
                                    <c:otherwise>
                                        <c:url value="MainServlet?action=Login" var ="LoginLink"></c:url>
                                        <a  href="${LoginLink}" class="btn  btn-sm login " >Đăng nhập</a>
                                        <c:url value="MainServlet?action=Register" var="ResLink"></c:url>
                                        <a href="${ResLink}" class="btn btn-sm logout ">Đăng ký</a>
                                    </c:otherwise>
                                </c:choose>
                            </div>

                        </div>
                    </div>
                </nav>


            </div>

        </header>

        <main class="mt-4">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 text-center mb-4">
                        <h1>Welcome to Driver license practice website!</h1>
                    <h4>This website helps you have more confident in your real exam.</h4>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <p><strong>Trung tâm thi lái xe FPT</strong>  là một trong những đơn vị đào tạo lái xe ô tô uy tín nhất tại Hồ Chí Minh.
                            Trung tâm được thành lập năm 2006, Sau 10 năm  thành công lớn nhất của Trung tâm được tạo bởi chính là việc dạy lái xe an toàn,
                            am hiểu luật GTĐB của hơn 100.000 học viên sau khi kết thúc khoá học lái xe ô tô. Tận tâm chăm sóc những học viên đã đăng ký thi bằng lái xe tại đây,
                            mang lại những lợi ích tốt nhất cho học viên là những gì Trung tâm luôn theo đuổi. 
                            Chúng tôi đã và đang khẳng định mình là điểm đến tin tưởng nhất cho học viên học lái xe B1,B2, C không chỉ tại Hồ Chí Minh mà còn ở các tỉnh lân cận.</p>
                    </div>
                    <div class="col-md-4">
                        <strong>Tại sao chọn chúng tôi?</strong>
                        <ul class="list-group">
                            <li class="list-group-item">Cơ sở vật chất khang trang và đạt chuẩn theo quy định ISO :9001:2015</li>
                            <li class="list-group-item">Giáo viên của chúng tôi là những người có phẩm chất đạo đức tốt, nhiều năm kinh nghiệm, nhiệt tình, chuyên nghiệp, trình độ cao.</li>
                            <li class="list-group-item">Trang thiết bị giảng dạy theo chuẩn</li>
                            <li class="list-group-item">Chủ động nắm bắt thông tin khóa học</li>
                            <li class="list-group-item">Học và thi trực tuyến mọi lúc, mọi nơi</li>
                            <li class="list-group-item">Điều chỉnh thời gian học linh hoạt. Chúng tôi đào tạo cả thứ 7 hoặc chủ nhật, ngoài giờ để phù hợp với công việc và học tập của bạn.</li>
                            <li class="list-group-item">Tư vấn việc làm sau khi tốt nghiệp</li>

                        </ul>
                    </div>
                    <div class="col-md-4">
                        <strong>Chúng tôi cam kết khi học lái xe tại Trung tâm</strong>
                        <ul class="list-group">
                            <li class="list-group-item">Học phí niêm yết công khai. Học viên nộp học phí trực tiếp tại phòng kế toán của trung tâm và nhận lại biên lai sau khi nộp. Học viên có thể nộp học phí làm 2 đợt.</li>
                            <li class="list-group-item">Không phát sinh chi phí khi học. Nhiều học viên lo lắng trong lúc học sẽ phát sinh các khoản phí không mong muốn như : đổ xăng, chi phí thầy, ăn uống, giáo viên vòi vĩnh….Và chúng tôi can kết khi bạn học lái xe tại Trung tâm sẽ không phát sinh bất kỳ khoản phí nào trong quá trình học.

                            </li>
                            <li class="list-group-item">Giáo viên nhiệt tình- chu đáo- trình độ cao- khả năng sư phạm tốt- sử dụng công nghệ vào giảng dạy.</li>
                            <li class="list-group-item">Ứng dụng công nghệ dạy học trực tuyến như : sử dụng các bài giảng online lý thuyết, chia sẻ hình ảnh trực quan các bài tập thực hành bằng các phần mềm dạy học. </li>
                            <li class="list-group-item">Học và thi trực tuyến mọi lúc, mọi nơi</li>
                            <li class="list-group-item">Xe tập lái sử dụng học thực hành theo đúng hạng xe thi.</li>
                            <li class="list-group-item">Sân tập và thi theo tiêu chuẩn ISO:9001:2015. </li>

                        </ul>
                    </div>

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
