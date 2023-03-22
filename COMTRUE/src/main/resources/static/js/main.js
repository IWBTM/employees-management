
let employees = {
	add: function() {
		let modal = document.querySelector('#modal--add--employees');
		modal.style.display = 'block';
	},

	modalCancel: function() {
		let modal = document.querySelector('#modal--add--employees');
		modal.style.display = 'none';
	},

	modalAdd: function() {
		let data = {
			id: $("#modal--id").val(),
			name: $("#modal--name").val(),
			phoneNumber: $("#modal--phoneNumber").val(),
			position: $("#modal--position").val(),
			email: $("#modal--email").val(),
		}
		if (data.id.length < 3) {
			alert('직원 번호는 반드시 3자리 이상으로 입력해주세요. ex) 001, 002');
		} else {
			$.ajax({
				type: 'post',
				url: '/api/employees/add',
				data: JSON.stringify(data),
				contentType: "application/json; charset=UTF-8",
				dataType: "json"
			}).done(function(data) {
				if (data.httpStatus) {
					alert(data.body);
					location.reload();
				} else {
					alert(data.body);
				}
			}).fail(function(error) {
				alert("예기치 못 한 오류가 발생하였습니다. 관리자에게 문의해주세요.");
			});
		}
	},

	update: function(id) {
		alert(id + '바로 수정하실 수 있습니다.');
	},

	delete: function(id) {
		alert(id + '정말 삭제하시겠습니까?');
	}
}