<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Homepage</title>
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
                <h1 class="text-center text-white bg-info">ĐỀ THI THỬ BẰNG LÁI XE A1 200 CÂU HỎI MỚI NHẤT 2020</h1>

            </div>

        </header>

        <main>
            <div class="row">
                <div class="container">
                    <div class="panel main">
                        <c:choose>
                            <c:when test="${type=='A1'}">
                                <h3 class="text-center text-primary">BỘ ĐỀ THI THỬ BẰNG LÁI XE MÁY A1 CHÍNH THỨC TỪ 01/08/2020</h3>
                                <p>Cấu trúc bộ đề thi sát hạch giấy phép lái xe hạng A1 sẽ bao gồm 25 câu hỏi, mỗi câu hỏi chỉ có duy nhất 
                                    1 đáp trả lời đúng phản ánh đúng bản chất của thi trắc nghiệm. Khác hẳn với bộ đề thi luật cũ là 2 đáp án. Mỗi đề thi chúng tôi sẽ bố trí từ 2 - 4 
                                    câu hỏi điểm liệt để học viên có thể làm quen và ghi nhớ, tránh việc làm sai câu hỏi liệt.</p>
                                <ul>
                                    <li>Số lượng câu hỏi:&nbsp;<strong>25 câu</strong>.</li>
                                    <li>Yêu cầu làm đúng&nbsp;<strong>23/25 câu</strong>.</li>
                                    <li>Thời gian:&nbsp;<strong>19 phút</strong>.</li>
                                </ul>
                                <p><strong>Lưu ý đặc biệt:</strong>&nbsp;uyệt đối không được làm sai câu hỏi điểm liệt, vì trong kỳ thi thật nếu học viên làm sai "
                                    <strong>Câu Điểm Liệt</strong>" đồng nghĩa với việc "<strong>KHÔNG ĐẠT</strong>" 
                                    dù cho các câu khác trả lời đúng!</p>
                                </c:when>
                                <c:when test="${type=='A2'}">
                                <h3 class="text-center text-primary">BỘ ĐỀ THI BẰNG LÁI XE A2 ONLINE BẢN CHUẨN</h3>
                                <p>CCấu trúc bộ đề luyện thi sát hạch A2 luật mới áp dụng chính thức từ 01/08/2020 sẽ bao gồm 25 câu hỏi,
                                    mỗi câu hỏi có duy nhất 1 đáp trả lời đúng. Mỗi đề thi A2 bố trí từ 2 - 4 câu hỏi điểm liệt để học viên có thể làm quen và ghi nhớ, 
                                    tránh việc làm sai câu hỏi liệt. Trong kỳ thi thật cấu trúc đề thi sẽ được sắp xếp theo dạng ngẫu nhiên, yêu cầu học viên phải học - 
                                    hiểu để vượt qua các câu hỏi, tránh tình trạng học tủ hay học vẹt.</p>
                                <ul>
                                    <li>Số lượng câu hỏi:&nbsp;<strong>25 câu</strong>.</li>
                                    <li>Yêu cầu làm đúng&nbsp;<strong>23/25 câu</strong>.</li>
                                    <li>Thời gian:&nbsp;<strong>19 phút</strong>.</li>
                                </ul>
                                <p><strong>Lưu ý đặc biệt:</strong>&nbsp;uyệt đối không được làm sai câu hỏi điểm liệt, vì trong kỳ thi thật nếu học viên làm sai "
                                    <strong>Câu Điểm Liệt</strong>" đồng nghĩa với việc "<strong>KHÔNG ĐẠT</strong>" 
                                    dù cho các câu khác trả lời đúng!</p>
                                </c:when>
                                <c:when test="${type=='B1'}">
                                <h3 class="text-center text-primary">CẤU TRÚC ĐỀ THI BẰNG LÁI XE Ô TÔ TRỰC TUYẾN</h3>
                                <p>Đề thi lý thuyết bằng lái xe B1 - C online  mỗi đề gồm 30 câu, mỗi câu hỏi chỉ có 1 đáp án đúng.
                                    Trong mỗi đề thi lý thuyết lái xe B1 online sẽ gồm: 9 câu hỏi biển báo giao thông, 9 câu giải sa hình, 9 câu hỏi luật giao thông và các quy tắc khi tham gia giao thông an toàn, 
                                    1 câu hỏi về kinh doanh vận tải, 1 câu kỹ thuật lái xe Ôtô và sửa chữa cơ bản, cuối cùng là 1 câu đạo đức của người lái xe.</p>
                                <ul>
                                    <li>Số lượng câu hỏi:&nbsp;<strong>30 câu</strong>.</li>
                                    <li>Yêu cầu làm đúng&nbsp;<strong>27/30 câu</strong>.</li>
                                    <li>Thời gian:&nbsp;<strong>19 phút</strong>.</li>
                                </ul>
                                <p><strong>Lưu ý đặc biệt:</strong>&nbsp;uyệt đối không được làm sai câu hỏi điểm liệt, vì trong kỳ thi thật nếu học viên làm sai "
                                    <strong>Câu Điểm Liệt</strong>" đồng nghĩa với việc "<strong>KHÔNG ĐẠT</strong>" 
                                    dù cho các câu khác trả lời đúng!</p>
                                </c:when>
                                <c:when test="${type=='B2'}">
                                <h3 class="text-center text-primary">CẤU TRÚC ĐỀ THI BẰNG LÁI XE Ô TÔ TRỰC TUYẾN</h3>
                                <p>Cấu trúc bộ đề thi sát hạch giấy phép lái xe hạng B2 sẽ bao gồm 30 câu hỏi, mỗi câu hỏi chỉ có duy nhất 
                                    1 đáp trả lời đúng phản ánh đúng bản chất của thi trắc nghiệm. Khác hẳn với bộ đề thi luật cũ là 2 đáp án. Mỗi đề thi chúng tôi sẽ bố trí từ 2 - 4 
                                    câu hỏi điểm liệt để học viên có thể làm quen và ghi nhớ, tránh việc làm sai câu hỏi liệt.</p>
                                <ul>
                                    <li>Số lượng câu hỏi:&nbsp;<strong>30 câu</strong>.</li>
                                    <li>Yêu cầu làm đúng&nbsp;<strong>27/30 câu</strong>.</li>
                                    <li>Thời gian:&nbsp;<strong>19 phút</strong>.</li>
                                </ul>
                                <p><strong>Lưu ý đặc biệt:</strong>&nbsp;uyệt đối không được làm sai câu hỏi điểm liệt, vì trong kỳ thi thật nếu học viên làm sai "
                                    <strong>Câu Điểm Liệt</strong>" đồng nghĩa với việc "<strong>KHÔNG ĐẠT</strong>" 
                                    dù cho các câu khác trả lời đúng!</p>
                                </c:when>
                            </c:choose>

                        <div class="text-center" style="margin: 20px">
                            <button class="btn btn-success btn-success-1 test" style="margin-bottom: 0px" type="button">Thi thử­ ${requestScope.type} </button>
                            <c:if test="${requestScope.listID.size()>0}">
                                <div class="mt-3">
                                    <a class="btn btn-success test d-inline"
                                       href="MainServlet?action=ChooseQuiz&type=${requestScope.type}"> Đề ngẫu nhiên</a>
                                </div>
                            </c:if>
                        </div>
                        <h6>Chọn đề: </h6>
                        <div class="" style="padding: 20px">

                            <c:set var="list" value="${requestScope.listID}"></c:set>
                            <c:forEach items="${list}" var="id">

                                <div>
                                    <a class="btn btn-success test d-inline"
                                       href="MainServlet?action=ChooseQuiz&QuizID=${id}&type=${requestScope.type}"> Đề ${id}</a>
                                  
                                </div>


                            </c:forEach>


                        </div>
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