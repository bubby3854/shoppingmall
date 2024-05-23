<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jobs 휴먼 클라우드 이력관리플렛폼</title>
<a href="community/">이준형</a>
<a href="member/index">김경민</a>
<a href="common/index">배서원</a>
<a href="members/index">추창민</a>
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
              <li class="nav-item">
                <a href="../admin99/admin_dashboard_99" class="nav-link link-body-emphasis">
                  My home
                </a>
              </li>
              <li>
                <a href="/admin/members" class="nav-link link-body-emphasis">
                 개인회원 관리
                </a>
              </li>
              <li>
                <a href="/admin/companies" class="nav-link link-body-emphasis">
                 기업회원 관리
                </a>
              </li> 
              <li>
                <a href="../admin99/cs_list_99" class="nav-link active" aria-current="page">
                 고객센터 관리
                </a>
              </li> 
              <li>
                <a href="../admin99/notice_list_99" class="nav-link link-body-emphasis">
                 공지사항 관리
                </a>
              </li>
              <li>
                <a href="../admin99/faqList" class="nav-link link-body-emphasis">
                 FAQ 관리
                </a>
              </li>
              <li>
                <a href="#" class="nav-link link-body-emphasis">
                 신고 접수된 건
                </a>
              </li>   
             </ul>
        </div>
    </div>
    <div class="col-9">
        <div class="border p-3">
        	<div id="category">${dto.category }</div>
        	<br>
        	<div>작성자</div>
        	<div id="writerId">${writer.mem_id }</div>
        	<br>
        	<div>제목</div>
        	<div id="title">${dto.title }</div>
        	<div>내용</div>
        	<div id="content">${dto.content }</div>
       		<a class="btn btn-light" href="../delete_99?cs_no=${dto.cs_no }" role="button">삭제</a>
        	<hr>
        	<form action="../admin99/cs_request_99?cs_no=${dto.cs_no }" method="post" onsubmit="return requestRegForm()">
        	<br>
        	<div class="mb-3">
                	<label for="" class="form-label">답변 제목</label>
                	<textarea class="form-control" name="title" id="title" placeholder="제목을 입력해주세요..."></textarea>
                	<label for="" class="form-label">답변 내용</label>
                	<textarea class="form-control" name="content" id="content" placeholder="명확한 답변을 해주세요..."></textarea>
           	</div>
           	<input type="submit" class="btn btn-jobs w-100" value="등록하기">
           	<br>
        	<a class="btn btn-light" href="../admin99/cs_list_99" role="button">이전</a>
        	<a class="btn btn-light" href="#" role="button">TOP</a>
        	</form>
        </div>
    </div>
</div>
</div>
<!-- 작업공간 영역 끝 -->
<jsp:include page="../footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="../js/csScript.js"></script>
</body>
</html>