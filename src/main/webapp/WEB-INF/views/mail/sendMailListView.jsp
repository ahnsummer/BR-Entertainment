<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<!-- 부트스트랩 탬플릿 -->
	<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
	<link href="resources/css/styles.css" rel="stylesheet" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
	
	<!-- jQuery 라이브러리 -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- fullcalendar CDNs-->
    <link href='resources/scheduleResources/lib/main.css' rel='stylesheet' />
    <script src='resources/scheduleResources/lib/main.js'></script>
    <script src='resources/scheduleResources/lib/locales/ko.js'></script>
    
<title>Insert title here</title>

<style>
    .card-footer{
        text-align: end;
    }

</style>
</head>
<body>
       <!-- 상단바 -->
    <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
        <jsp:include page="../common/userHeader.jsp"/>
    </nav>
    
    <div id="layoutSidenav">
        
        <!-- 메뉴바 -->
        <div id="layoutSidenav_nav">
            <jsp:include page="../common/userMenu.jsp"/>
        </div>

        <!--컨텐츠-->
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">보낸 메일함</h1>
                    <br>
                    <div class="card mb-4">
                        <div class="card-header">
                            <i class="far fa-envelope"></i>
                            보낸 메일
                        </div>
                        <div class="card-body">
                            <table id="datatablesSimple" class="mailList">
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th>받은 사람(수신여부 같이)</th>
                                        <th>제목</th>
                                        <th>일시</th>
                                        <th>첨부파일</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach var="s" items="${slist}">
	                                    <tr>
	                                        <td><input type="checkbox" name="" id="mailCheck_${s.mailNo}" ></td>
	                                        <%--
	                                        <c:forEach var="r" items="${rlist}">
	                                          
                                        		<c:choose>
	                                        		<c:when test="${ s.mail_no = r.mail_no and r.receiverCount > 1 }">	
		                                        		<c:choose>
		                                        			<c:when test="${ r.receiverYCount = 'N'}">
		                                        				<td>총 ${r.receiverCount} 명 중 ${r.receiverYCount} 읽음</td>
		                                        			</c:when>
		                                        			<c:when test="${ s.mail_no = r.mail_no and r.receiverCount = 1 }">
		                                        				
		                                        				<td>${r.receiverYCount} 읽지않음</td>
		                                        				
		                                        			</c:when>
		                                        			<c:otherwise>
		                                        				
		                                        			</c:otherwise>
		                                        		</c:choose>
	                                        		</c:when>
                                        		</c:choose>
	                                        </c:forEach>
	                                        --%>
	                                        <td></td>
	                                        <c:choose>
		                                        <c:when test="${ !empty s.mailTitle }">
		                                        	<td>${ s.mailTitle }</td>
		                                        </c:when>
		                                        <c:otherwise>
			                                        <td>(제목 없음)</td>
		                                        </c:otherwise>
	                                        </c:choose>
	                                        
	                                        <td>${ s.mailSendDate }</td>
	                                        <c:choose>
												<c:when test="${ s.mfIsHave > 0 }">
													<td>Y</td>
												</c:when>
												<c:otherwise>
													<td>N</td>											
												</c:otherwise>
											</c:choose>
	                                    </tr>
                                	</c:forEach>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th><input type="checkbox"></th>
                                        <th><button onclick="important()"><i class="far fa-star"></i></button></th>
                                        <th></th>
                                        <th>Age</th>
                                        <th>Sta rt date</th>
                                        <th>Salary</th>
                                    </tr>
                                </tfoot>
                            </table>
                            <div class="card-footer">
                                <a class="btn btn-primary btn-block">답장</a>
                                <a class="btn btn-primary btn-block">전달</a>
                                <a class="btn btn-primary btn-block"><i class="far fa-star"></i></a>
                                <a class="btn btn-primary btn-block">메일쓰기</a>
                                <a class="btn btn-primary btn-block">삭제하기</a>
                            </div>
                        </div>
                    </div>
                </div>
            </main> 
        </div>
    </div>
</body>
<script>
    function showAndHide(){
        if($('#dis').css('display') == 'none'){
        $('#dis').show();
    }else{
        $('#dis').hide();
    }
    }
</script>
</html>