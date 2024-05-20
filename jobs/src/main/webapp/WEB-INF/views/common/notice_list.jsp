<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jobs 휴먼 클라우드 이력관리플렛폼</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link href="/css/common.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<!-- 작업공간 영역 -->
<div class="container">
<div class="row">
    <div class="col-3">
        <div class="border p-3">
            <ul class="nav nav-pills flex-column mb-auto">
            <!-- 여기에 메뉴를 나열해주세요 -->
     			<li class="nav-item">
	                <a href="../cs_list_99" class="nav-link link-body-emphasis">문의·신고</a>
	            </li>
	            <li>
                	<a href="../notice_list_99" class="nav-link active" aria-current="page">공지사항</a>
              	</li>
            </ul>
        </div>
    </div>
    
    <div class="col-9">
        <div class="border p-3">
        <h3 style="text-align:center;">공지사항</h3>
        	<c:choose>
        		<c:when test="${mem_no == '3'}">
        			<a class="btn btn-light" href="../admin99/notice_write_form_99" role="button" onclick="return isLoggedIn()">공지사항 작성하기</a>
        		</c:when>
        		<c:otherwise>
        		</c:otherwise>
        	</c:choose>
        	
        	<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">번호</th>
			      <th scope="col">카테고리</th>
			      <th scope="col">제목</th>
			      <th scope="col">작성일</th>
			    </tr>
			  </thead>
			  <tbody class="table-group-divider">
			  
			  <c:forEach var="list" items="${list }" varStatus="status">
			  	<tr>
			      <td scope="row">${status.count }</td>
			      <td>${list.category }</td>
				  <td><a href="../noticeDetail_99?notice_no=${list.notice_no }">${list.title }</a></td>
			      <td>${list.reg_date }</td>
			    </tr>
			  </c:forEach>
			  </tbody>
			</table>
        </div>
    </div>
</div>
</div>
<!-- 작업공간 영역 끝 -->
<jsp:include page="../footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>