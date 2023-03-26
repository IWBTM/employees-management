<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

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
							<td id="id-${entity.id}"><a href="/detail/${entity.id}">${entity.id}</a></td>
							<td id="position-${entity.id}"><a href="/detail/${entity.id}">${entity.position}</a></td>
							<td id="name-${entity.id}"><a href="/detail/${entity.id}">${entity.name}</a></td>
							<td id="phoneNumber-${entity.id}"><a href="/detail/${entity.id}">${entity.phoneNumber}</a></td>
							<td id="email-${entity.id}"><a href="/detail/${entity.id}">${entity.email}</a></td>
							<td id="td-btn">
							</td>
						</tr>
				</tbody>
			</table>

</body>
</html>