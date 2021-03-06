<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

	<!-- summer note -->
	
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
    
    <script src="resources/mailResources/lang/summernote-ko-KR.js"></script>
    
    <!-- email input  -->
    <link rel="stylesheet" href="resources/mailResources/email.multiple.css">
    
    <style>
        #layoutAuthentication_content{
            margin: auto;
        }

        .col-lg-5{
            width:1000px;
        }


        .dataTable-input{
            display: inline-block;
        }

        .input-explain{
            display: inline-block;
            width:70px;
        }

        #schTitle, #attendance, #schCategory, #schContent{
            width: 90%;
        }

        #startDate, #endDate, #startTime, #endTime{
            height:40px; width:130px;
        }

        #schContent{
            resize: none;
            width:68%
        }
		
		#email-check{
			display:none;
            color:red;
		}
		
        /* btn css */
        #toggle_fileList:link, #toggle_fileList:visited, #toggle_fileList:hover, #toggle_fileList:active{
            text-decoration: none;
            text-decoration: underline;
            color:black;
        }

        .btn-block{
            margin-bottom:5px;
        }

        .svg-inline--fa{
            vertical-align:middle;
        }

        /* file input css*/
        #file_wrap{
        }


        input[type="file"]{
            display: none;
        }

        #file_showAndHideBtn{
            size:7;
        }
        
        .fa-caret-square-up, .fa-caret-square-down{
            font-size:30px;
        }

        #target_file_wrap{
            float:left;
        }

        #drop_zone{
            border:1px solid #e5e5e5;
            float:right;
            width:80%;
            height:120px;
            display:none;
        }

        #content_explain{
            clear:both;
        }

        /* summernote css */
        .note-modal-footer{
            height:50px;
            padding-right:30px;
            border-top:1px solid #e5e5e5;
        }
    </style>
<title>Insert title here</title>
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
        <div id="layoutAuthentication_content">
            <main>
                <br><br>
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-5">
                            <div class="card shadow-lg border-0 rounded-lg mt-5">
                                <div class="card-header"><h3 class="text-center font-weight-light my-4"><i class="far fa-envelope"></i> 메일 쓰기</h3></div>
                                <form name="sendMail" id="sendMail" action="doReply.mail" method="post" enctype="multipart/form-data">
                                    <input type="hidden" id="is_receiver_check" value="T">
                                    <div class="card-body">
                                    
                                    	<input type="hidden" id="writer" name="mailWriter" value="${ loginUser.officeEmail }" >
                                    	<input type="hidden" id="memberNo" name="memNo" value="${ loginUser.memNo }">       
                                        
                                        <input type="text" id="mailReceiver" placeholder="Email">
                                        
                                        
                                        <c:choose>                                        
	                                        <c:when test="${ fn:indexOf(s.mailReceiver, ',') gt 0 }">
		                                    	<c:forTokens var="r" items="${ s.mailReceiver }" delims=",">
		                                    			<span class="email-ids">${r}<span class="cancel-email">x</span></span>
				                                    	<input type="hidden" name="mailReceiver" value="${ r }">
			                                    </c:forTokens>
		                                    </c:when>	
		                                    <c:otherwise>
		                                    	<span class="email-ids">${s.mailWriter}<span class="cancel-email">x</span></span>
		                                    	<input type="hidden" name="mailReceiver" value="${s.mailReceiver}">
		                                    </c:otherwise>
	                                    </c:choose>
                						
                						
                                        <a class="btn btn-primary btn-block" href="">주소록</a>
                                        <a class="btn btn-primary btn-block" href="">내게 쓰기</a>
                                        <label for=""></label><br>
                                        <div id="email-check"></div><br>
                                        <span class="input-explain">제목</span><input class="dataTable-input" id="title" name="mailTitle" type="text" min=0 placeholder="" value="[RE] ${s.mailTitle }"/>
                                        <label for=""></label>

                                        <br>

                                        <div id="file_wrap">
                                            <div id="target_file_wrap">
                                                <span>파일첨부</span>
                                                <input multiple type="file" id="upfile" name="upfile">
                                                <a id="toggle_fileList" href="#" onclick="toggle_layer();"><i class="far fa-caret-square-up"></i></a>
                                                <a href="#" onclick="$('#upfile').click()" class="btn btn-primary">내 PC</a>

                                            </div>
                                            <div id="drop_zone" ondrop="dropHandler(event);">
                                                <span></span>
                                                <c:forEach var="mf" items="${mflist}">
                                                <div>
                                                	<input multiple type="file" id="upfile" name="upfile">
                                                	<input type="checkbox" id="#[object File]"> ${mf.mailOrigin}
                                        	        <c:choose>
									                	<c:when test="${(1024*1024) <= mf.mailFSize}">
									                		(${String.format("%.2f", mf.mailFSize/1024/1024)} MB)
									                	</c:when>
									                	<c:when test="${(1024) <= mf.mailFSize}">
									                		(${String.format("%.2f", mf.mailFSize/1024)} KB)
									                	</c:when>
									                	<c:otherwise>
									                		(${String.format("%.2f", mf.mailFSize)} byte)
									                	</c:otherwise>
								                	</c:choose>
                                                	<span class="cancel-file"><i class="far fa-times-circle"></i></span>
                                                </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                        <br><div id="content_explain">내용</div>
                                        <br>
                                        <div>
                                            <textarea id="summernote" name="mailContent">${s.mailContent}</textarea>
                                        </div>
                                        <div class="card-footer text-center py-3">
                                            <div class="small">
                                                <button type="button" id="do_reply" class="btn btn-primary btn-block">답장하기</button>
                                                <button type="button" id="sendTemp" class="btn btn-primary btn-block">임시저장</button>
                                            </div>
                                        </div>    
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </div>

</body>
<script>

	
	$(document).ready(function() {
	    $('#summernote').summernote({
	    	lang: 'ko-KR',
	    	placeholder: '내용을 입력해주세요.',
	        tabsize: 2,
	        height: 340,
	        toolbar: [
	          ['style', ['style']],
	          ['font', ['bold', 'underline', 'clear']],
	          ['color', ['color']],
	          ['para', ['ul', 'ol', 'paragraph']],
	          ['table', ['table']],
	          ['insert', ['link', 'picture', 'video']],
	          ['view', ['fullscreen', 'codeview', 'help']]
	        ]
	      });

	});
	
    jQuery(document).ready(function($) {
        var target_id = "upfile";     
        $("#" + target_id).bind('change', function() {
            selectFile(this.files, target_id); 
        }); 
    }); 
    // 기본 파일 업로드 시켜놓는 함수
    
    // 파일 선택시 
    function selectFile(fileObject, target_id) { 
        var files = null; 
        var totalFileSize = 0; 
        // 직접 파일 등록시 
        files = jQuery('#' + target_id)[0].files; 
        console.log(files);
		
        if (files != null) { 
            for (var i = 0; i < files.length; i++) { 
                // 파일 이름 
                var fileName = files[i].name; 
                var fileNameArr = fileName.split("\."); 
                // 확장자 
                var ext = fileNameArr[fileNameArr.length - 1]; 
                var fileSize = files[i].size; 
                // 파일 사이즈(단위 :byte) console.log("fileSize="+fileSize); 
                if (fileSize <= 0) { 
                    console.log("0kb file return"); 
                    return; 
                } 
                var fileSizeKb = fileSize / 1024; 
                // 파일 사이즈(단위 :kb) 
                var fileSizeMb = fileSizeKb / 1024;
                // 파일 사이즈(단위 :Mb) 
                var fileSizeStr = ""; 
                if ((1024*1024) <= fileSize) { 
                // 파일 용량이 1메가 이상인 경우 console.log("fileSizeMb="+fileSizeMb.toFixed(2)); 
                    fileSizeStr = fileSizeMb.toFixed(2) + " Mb"; 
                } else if ((1024) <= fileSize) { 
                    console.log("fileSizeKb="+parseInt(fileSizeKb)); 
                    fileSizeStr = parseInt(fileSizeKb) + " kb"; 
                } else { 
                    console.log("fileSize="+parseInt(fileSize)); 
                    fileSizeStr = parseInt(fileSize) + " byte"; 
                }
                // 업로드 파일 목록 생성 
                $("#drop_zone").append('<div><input type="checkbox" id="#' + files[i] + '"> ' + fileName + ' (' + fileSizeStr + ')' + '<span class="cancel-file"><i class="far fa-times-circle"></i></span></div>');
                $("#drop_zone").show();
                $(".fa-caret-square-up").attr('class', 'fa-caret-square-down');
                
                $(document).on('click','.cancel-file',function(){
                    $(this).parent().next().remove();
                    $(this).parent().remove();
                });
            } 
        } else{ 
            alert("ERROR"); 
        } 
    }
    
    $("").toggle(); // show -> hide , hide -> show)

    function toggle_layer() {
	if($("#drop_zone").css("display") == "none"){
		$(".fa-caret-square-up").attr('class', 'fa-caret-square-down');
        $("#drop_zone").show();
	}else{
		$("#drop_zone").hide();
        $(".fa-caret-square-down").attr('class', 'fa-caret-square-up');
	}
}
 
    // 회원가입 넘길때 check요소 없을 시, 제약걸기
    // $('#insertCheck').click(function(e) {
    //     e.preventDefault();

    //     // 이메일 전송 Check
    //     if($('#receiver').val() == null) {
    //          alert('받는 사람이 지정되지 않았습니다.' + '받는 사람 주소를 입력해주세요');
    //          return false;
    //     }

    //     $('#sendMail').submit();
    // });

    
// 이메일 받는 사람 관련 js    
(function($){
	// 같은 이메일 입력 불가 조건
	let mrarr = [];
	mrarr.push($('input[name=mailReceiver]').val()); 
	console.log(mrarr);
	let replymrarr = mrarr;

    $.fn.email_multiple = function(options) {

        let defaults = {
            reset: true,
            fill: false,
            data: null
        };

        //let settings = $.extend(defaults, options);
        let email = "";

        return this.each(function()
        {
            $(this).after("<span class=\"to-input\">받는사람</span>\n<br>" +
                "<div class=\"all-mail\"></div>\n" +
                "<input type=\"text\" class=\"enter-mail-id\" placeholder=\"이메일 입력 후 엔터를 누르세요.\" />");
            let $orig = $(this);
            let $element = $('.enter-mail-id');
            $element.keydown(function (e) {
                $element.css('border', '');
                if (e.keyCode === 13 || e.keyCode === 32) {
                    let getValue = $element.val();
                    if (/^[a-z0-9._-]+@[a-z0-9._-]+\.[a-z]{2,6}$/.test(getValue)){
                    	//배열 생성
							if( mrarr.includes(getValue) ){
								alert('똑같은 메일주소는 보낼 수 없습니다.');	
								return false;
							}
						
						$('.all-mail').append('<span class="email-ids">' + getValue + '<span class="cancel-email">x</span></span>');
                        $('.all-mail').append('<input type="hidden" name="mailReceiver" value="' + getValue + '">');
                        
                        $('#is_receiver_check').attr('value', 'T');
                        $('#email-check').hide();
                        $element.val('');

                    	email += getValue
                    	replymrarr.push(getValue);

                            
                    } else {
                        $element.css('border', '1px solid red')
                        $('#email-check').html('<span>유효하지 않은 이메일입니다. 다시 입력해주세요.</span>');
                        $('#email-check').show();
                    }
                $orig.val(email.slice(0))
                }});

            $(document).on('click','.cancel-email',function(){
                $(this).parent().next().remove();
                $(this).parent().remove();
            });

            return $orig.hide()
        });
    };

})(jQuery);


    
    // email input js
	$(document).ready(function($){
	  let data = [
	    ]
	  $("#mailReceiver").email_multiple({
	      data: data
	  })
	});
    
    // 이메일 보낼 때 체크제약조건
	$('#do_reply').click(function(e) {
        e.preventDefault();
        if($('.email-ids').next('input').val() == null){
        	$('#email-check').show();
            $('#email-check').change($('#email-check').html('<span>받은 사람이 지정되지 않았습니다. 받는 사람 주소를 입력해주세요. </span>'));
        	return false;
        } if($('#is_receiver_check').val() !== 'T'){
            $('.enter-mail-id').css('border', '1px solid red');
            $('.enter-mail-id').focus();
            $('#email-check').show();
            $('#email-check').change($('#email-check').html('<span>받은 사람이 지정되지 않았습니다. 받는 사람 주소를 입력해주세요. </span>'));
            return false;
        }
        $('#sendMail').submit();        
	});
    
    // 이메일 임시저장 
    $('#sendTemp').click(function(e){
    	e.preventDefault();
    	if(checkValue() === false){
    		alert('임시저장할 수 없습니다. 내용을 넣어주세요.');
    		return false;
    	} else{
            $('#sendMail').attr('action','sendTemp.mail');
            $('#sendMail').submit();
    	}
    	
    	function checkValue(){
    		if($('input[type=text]').val()  == "" && $('#title').val() == "" && $('.note-editable').children('p').html() == '<br>'){
    			return false;
    		} 
    		return true;
        };
    })
</script>
</html>