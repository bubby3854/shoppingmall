<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jobs 휴먼 클라우드 이력관리플렛폼</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link href="/css/common.css" rel="stylesheet">
</head>
<body class="d-flex flex-column h-100">
<jsp:include page="../header.jsp"></jsp:include>
<!-- 작업공간 영역 -->
<div class="container">
<div class="row">
    <div class="col-3">
        <div class="border p-3">
            <ul class="nav nav-pills flex-column mb-auto">
            <!-- 여기에 메뉴를 나열해주세요 -->
              
             </ul>
        </div>
    </div>
    
    <div class="col-9">
        <div class="border p-3">
        <!-- common controller -->
        	<form action="../writeFAQ" method="post" onsubmit="return noticeRegForm()">
		    	<h3 style="text-align:center;">FAQ 작성</h3>
	      		<div>카테고리 종류(필수)</div>
			  	<select class="form-select" name="category" id="category">
			  	<option value="">선택하세요</option>
			  	<option value="회원가입·정보">회원가입·정보</option>
			  	<option value="이력서 관리·활용">이력서 관리·활용</option>
			  	<option value="입사지원">입사지원</option>
			  	<option value="채용정보">채용정보</option>
			  	<option value="기타">기타</option>
			  	</select>
	 			<div class="mb-3">
                	<label for="" class="form-label">제목</label>
                	<textarea class="form-control" name="title" id="title" placeholder="제목"></textarea>
                	<label for="" class="form-label">내용</label>
                	<textarea class="form-control" name="content" id="content" placeholder="내용"></textarea>
           		</div>
           		<div class="mb-1">글 비공개 여부</div>
	 			<input type="radio" value="1" name="mem_type" id="member"> 일반회원
	 			<input class="ms-3" type="radio" value="0" name="mem_type" id="company"> 기업회원<br>
           		<input type="submit" class="btn btn-jobs w-100" value="등록하기">
			</form>
			<a class="btn btn-light" href="#" role="button">이전</a>
        </div>
    </div>
</div>
</div>
<!-- 작업공간 영역 끝 -->
<jsp:include page="../footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="../js/noticeScript.js"></script>
</body>
</html>
</body>
</html>