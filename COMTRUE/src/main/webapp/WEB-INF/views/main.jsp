<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 관리 프로그램</title>
<!-- 부트스트랩 라이브러리 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- ajax통신 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<link rel="stylesheet" href="/css/main.css">
</head>
<body>

	<!-- 직원 추가 모달 -->
	<div id="modal--add--employees">
		<div id="modal--add--employees--body">
			<h2>직원 추가</h2>
			<input type="text" id="modal--id" placeholder="직원번호" value="001">
			<input type="text" id="modal--name" placeholder="이름" value="경민">
			<input type="text" id="modal--phoneNumber" placeholder="전화번호"
				value="000-6709-7992"> <input type="text"
				id="modal--position" placeholder="직급" value="사원"> <input
				type="text" id="modal--email" placeholder="이메일"
				value="abc@naver.com">
			<div id="btn--modal">
				<div>
					<button id="btn--modal--cancel" onclick="employees.modalCancel()">취소</button>
				</div>
				<div>
					<button id="btn--modal--add" onclick="employees.modalAdd()">
						추가</button>
				</div>
			</div>
		</div>
	</div>

	<div id="header">
		<img alt="귀사 로고" src="images/logo.png">
	</div>

	<div id="employees-list">
		<div class="container">
			<div id="btn--row">
				<input type="button" id="btn--add" onclick="employees.add();"
					value="직원 추가">
				<form action="" method="get">
					<select name="whatSearch" id="lang">
						<option value="id">직원 번호</option>
						<option value="position">직급</option>
						<option value="name">이름</option>
						<option value="phoneNumber">전화번호</option>
						<option value="email">이메일</option>
					</select> <input type="text" id="input--search" placeholder="검색어를 입력하세요."
						name="q" value="${q}" id="board--search--input">
					<button class="btn" id="btn--search" type="submit">검색</button>
				</form>
			</div>
			<div></div>
			<table class="table" id="answer-list-table">
				<thead>
					<tr style="text-align: center;">
						<th>직원 번호</th>
						<th>직급</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>이메일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="employees" items="${employeesList}">
						<tr id="employees-list-${employees.id}" onmouseover="">
							<td><p>${employees.id}</p></td>
							<td><p>${employees.position}</p></td>
							<td><p>${employees.name}</p></td>
							<td><p>${employees.phoneNumber}</p></td>
							<td><p>${employees.email}</p></td>
							<td id="td-btn"><div id="UD">
									<button id="btn--update"
										onclick="employees.update(${employees.id});">수정</button>
									<button id="btn--delete" onclick="employees.delete(${employees.id});">삭제</button>
								</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<script type="text/javascript" src="/js/main.js"></script>
</body>
</html>