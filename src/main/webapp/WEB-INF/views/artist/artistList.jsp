<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>brEntertainment</title>

<!-- 부트스트랩 탬플릿 -->
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
<link href="resources/css/styles.css" rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>

<!-- jQuery 라이브러리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<style>
	/* 폰트 */
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap');
	* {font-family: 'Noto Sans KR', sans-serif;}
	
	/* input 스타일 */
	input:focus, input[type]:focus, .uneditable-input:focus {
	border-color: rgb(155, 89, 182); 
	box-shadow: 0 1px 1px rgba(229, 103, 23, 0.075) inset, 0 0 8px rgba(155, 89, 182, 0.6);
	outline: 0 none;
	}
	
	/* 드롭박스 스타일 */
	.dataTable-selector:focus, .dataTable-selector:active{
	    border-color: rgb(155, 89, 182); 
	    box-shadow: 0 1px 1px rgba(229, 103, 23, 0.075) inset, 0 0 8px rgba(155, 89, 182, 0.6);
	    outline: 0 none;
	}
	option:checked {background: rgb(155, 89, 182); color: white;}
	
	/* 페이징바 스타일 */
	.dataTable-pagination a {color:black;}
	.dataTable-pagination a:hover, 
	.dataTable-pagination a:focus {background: rgb(245, 238, 248); border-color: #dee2e6; color:black;}
	.dataTable-pagination a:active {box-shadow: 0 1px 1px rgba(229, 103, 23, 0.075) inset, 0 0 8px rgba(155, 89, 182, 0.6);}
	.page-item.active .page-link, .page-item.active .dataTable-pagination a, .dataTable-pagination .page-item.active a, .dataTable-pagination li.active .page-link, .dataTable-pagination li.active a {
	    z-index: 3; color: #fff; background-color: rgb(155, 89, 182); border-color: #dee2e6;}
	.dataTable-pagination .active a, .dataTable-pagination .active a:focus, .dataTable-pagination .active a:hover {
	    background-color: rgb(155, 89, 182);
	    box-shadow: none;} 
	    
	/* 컨텐츠영역 */    
	.outer{margin:auto; width:1000px;}
    .outer .wrap{height:350px; width:800px; margin-bottom: 30px; margin:auto;}
    .outer .wrap>*{
        height:100%;
        width:350px;
        text-align: center;
        box-sizing: border-box;
    }
    .wrap > .artist1{border:1px solid lightgray; float:left;}
    .wrap > .artist2{border:1px solid lightgray; float:right;}
    .outer .image{
        width:100%;
        height:100%;
        -webkit-filter: grayscale(100%);
        filter: gray;
    }
    .outer a:hover img{-webkit-filter: grayscale(0%); filter: none;}
    /* 페이징바 */
    #pagingArea{ margin-left:250px;}
    #pagingArea .page-link{
        background-color: rgb(235, 202, 250);
        color:white;
        height:45px;
        width:45px;
        text-align: center;
        line-height: 30px;
        font-size: 18px;
    }
</style>

</head>
<body class="sb-nav-fixed">
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
            <div class="outer">
                <br><br>
                <h1><b>ARTISTS</b></h1>
                <br><br><br>

                <!-- 아티스트 리스트 -->
                <div class="wrap">
                    <div class="artist1">
                        <a href=""><img class="image" src="../artistUpfiles/BLACKPINK.png" alt=""></a>
                    </div>
                    <div class="artist2">
                        <a href=""><img class="image" src="../artistUpfiles/BTS.jpeg" alt=""></a>
                    </div>
                </div>
                <div class="wrap">
                    <div class="artist1">
                        <a href=""><img class="image" src="../artistUpfiles/EXO.jpeg" alt=""></a>
                    </div>
                    <div class="artist2">
                        <a href=""><img class="image" src="../artistUpfiles/IU.jpeg" alt=""></a>
                    </div>
                </div>
                <div class="wrap">
                    <div class="artist1">
                        <a href=""><img class="image" src="../artistUpfiles/REDVELVET.png" alt=""></a>
                    </div>
                    <div  class="artist2">
                        <a href=""><img class="image" src="../artistUpfiles/SEVENTEEN.jpeg" alt=""></a>
                    </div>
                </div>
                <br><br><br>

                <!-- 페이징바 -->
                <div id="pagingArea">
                    <ul class="pagination">
                        <li class="page-item disabled"><a class="page-link" href="#"><</a></li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item"><a class="page-link" href="#">4</a></li>
                        <li class="page-item"><a class="page-link" href="#">5</a></li>
                        <li class="page-item"><a class="page-link" href="#">></a></li>
                    </ul>
                </div>

                <br><br><br><br><br>
            </div>
        </div>
    </div>
	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="resources/js/scripts.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script src="resources/js/datatables-simple-demo.js"></script>
</body>
</html>
