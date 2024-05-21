<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jobs 휴먼 클라우드 이력관리플렛폼</title>
<a href="community/">이준형</a>
<a href="member/index">김경민</a>
<a href="/cs_list_99">배서원</a>
<a href="members/index">추창민</a>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
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
						<li class="nav-item"><a href="#" class="nav-link active"
							aria-current="page"> 메뉴1 </a></li>
						<li><a href="#" class="nav-link link-body-emphasis"> 메뉴2
						</a></li>
					</ul>
				</div>
			</div>
			<div class="col-9">
				<div class="border p-3">
				<!-- 작업시작 -->
					<h2>사이트 이력서</h2>
					<hr>
					<!-- 검색창 -->
					<div id="searchBox" >
						<form action="search" method="post">
							<input type="text"  name="search">
							<button>검색</button>
						</form>
					</div>		
					<!-- 검색창 -->		
				 <div class="border p-5 rounded">
        	<c:forEach var="siteList" items="${siteList }">
	        <div class="border p-3 mb-3">
	        	<div class="row align-items-center">
	        		<div class="col-md-4">
	        			<div class="fs-7 text-secondary">이력서 제목 :${siteList.title } </div>
        			
	        		</div>
	        		<div class="col-md-5 text-secondary">
	        		<div class="col-md-3 d-flex flex-row-reverse">
	        			<c:choose>        
					        <c:otherwise>
					        	<a class="btn btn-jobs me-2" href="">수정</a>
					        	<a class="btn btn-secondary" href="">삭제</a>
					        </c:otherwise>
					    </c:choose> 
	        		</div>
	        		<div></div>
	        	</div>
	        </div>
        	</c:forEach>
        </div>
								
				<h2>자유양식 이력서</h2>
				<hr>
				
					<div id="searchBox" >
						<form action="search" method="post">
							<input type="text"  name="search">
							<button>검색</button>
						</form>
					</div>	
				
				
				
				
				
				
				
				
				
				<!-- 작업끝 -->
				</div>
			</div>

		</div>
	</div>
	<!-- 작업공간 영역 끝 -->
	<jsp:include page="../footer.jsp"></jsp:include>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>