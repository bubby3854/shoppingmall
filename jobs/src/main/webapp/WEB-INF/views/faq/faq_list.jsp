<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 고객센터</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link href="/css/common.css" rel="stylesheet">
</head>
<body class="d-flex flex-column h-100" data-logged-in="${sessionScope.loggedInMember != null}">
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
                <a href="../admin99/cs_list_99" class="nav-link link-body-emphasis">
                 고객센터 관리
                </a>
              </li> 
              <li>
                <a href="../admin99/notice_list_99" class="nav-link link-body-emphasis">
                 공지사항 관리
                </a>
              </li>
              <li>
                <a href="../admin99/faqList" class="nav-link active" aria-current="page">
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
<<<<<<< HEAD:jobs/src/main/webapp/WEB-INF/views/faq/faq_list.jsp
    <div class="col-9">
        <div class="border p-3">
        <p class="text-secondary d-flex">
	    	<a href="#" class="nav-link text-secondary">마이페이지</a> <span class="mx-3">&gt;</span>
	    	<a href="#" class="nav-link text-black fw-bolder">FAQ 관리</a>
	    </p>
        	<div class="overflow-auto">
		    <form class="d-flex float-end" action="/noticeSearchData_99">
		      <input class="form-control me-2"  value="${searchData }" type="search" placeholder="제목 검색" aria-label="제목 검색" style="width: 150px;">
		      <button class="btn btn-light" type="submit">검색</button>
		    </form>
		    <form class="d-flex float-start" action="../admin99/faqCategory_99" method="post">
			  	<select class="form-select" name="category" id="category">
			  	<option value="">전체보기</option>
			  	<option value="회원가입·정보">회원가입·정보</option>
			  	<option value="이력서 관리·활용">이력서 관리·활용</option>
			  	<option value="입사지원">입사지원</option>
			  	<option value="채용정보">채용정보</option>
			  	<option value="기타">기타</option>
			  	</select>
           		<input type="submit" class="btn btn-jobs" value="검색하기">
			</form>
		  	</div>
		  	<a class="btn btn-outline-primary mt-3" href="../admin99/faqWriteForm" role="button" onclick="">FAQ 글 작성하기</a>
		  	
        	<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">번호</th>
			      <th scope="col">카테고리</th>
			      <th scope="col">제목</th>
			    </tr>
			  </thead>
			  <tbody class="table-group-divider">
			  
			  <c:forEach var="list" items="${list }" varStatus="status">
			  	<tr>
			      <td scope="row">${status.count }</td>
			      <td>${list.category }</td>
			      <td><a href="/admin99/faqDetail_99?faq_no=${list.faq_no }">${list.title }</a></td>
			    </tr>
			  </c:forEach>
			  </tbody>
			</table>
=======
    <div class="col-9 mb-5">
    	<p class="text-secondary d-flex">
	    	<a href="#" class="nav-link text-secondary">관리자 모드</a> <span class="mx-3">&gt;</span>
	    	<a href="#" class="nav-link text-secondary">고객센터 관리</a> <span class="mx-3">&gt;</span>
	    	<a href="" class="nav-link text-black fw-bolder">문의·신고 상세보기</a>
	    </p>
        <div class="border p-5">
        	<div id="category">#${dto.category }</div>
        	<div class="fs-7 text-secondary my-2" id="writerId">작성자 | ${writer.mem_id }</div>
        	<div class="fs-5 fw-bold my-3" id="title">${dto.title }</div>
        	<div class="py-3 border-top border-bottom mb-3" id="content">${dto.content }</div>
       		<a class="btn btn-light" href="../delete_99?cs_no=${dto.cs_no }" role="button">삭제</a>
        	<hr>
        	<form action="../admin99/cs_request_99?cs_no=${dto.cs_no }" method="post" onsubmit="return requestRegForm()">
        	
        	<div class="mb-3">
                	<label for="" class="form-label">답변 제목</label>
                	<textarea class="form-control" name="title" id="title" placeholder="제목을 입력해주세요..."></textarea>
                	<label for="" class="form-label mt-3">답변 내용</label>
                	<textarea class="form-control" name="content" id="content" placeholder="명확한 답변을 해주세요..."></textarea>
           	</div>
           	<input type="submit" class="btn btn-jobs w-100 mb-3" value="등록하기">
           	<br>
        	<a class="btn btn-light" href="../admin99/cs_list_99" role="button">이전</a>
        	<a class="btn btn-light" href="#" role="button">TOP</a>
        	</form>
>>>>>>> 06ae4a842a48d116dc947609ffc6277753c97d1e:jobs/src/main/webapp/WEB-INF/views/admin/cs_detail.jsp
        </div>
    </div>
</div>
</div>
<!-- 작업공간 영역 끝 -->
<jsp:include page="../footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>