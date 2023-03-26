<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/detail.css">
</head>
<body>
<div>
	<div>
		<h1 style="font-weight: bold;" onclick="history.back();">뒤로 가기</h1>
	</div>

	<div>
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
						<tr id="employees-info">
							<td id="id-${entity.id}"><p>${entity.id}</p></td>
							<td id="position-${entity.id}"><p>${entity.position}</p></td>
							<td id="name-${entity.id}"><p>${entity.name}</p></td>
							<td id="phoneNumber-${entity.id}"><p>${entity.phoneNumber}</p></td>
							<td id="email-${entity.id}"><p>${entity.email}</p></td>
							<td id="td-btn">
							</td>
						</tr>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>