
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
		let newId = this.idCheck(id);
		$.ajax({
			type: 'get',
			url: `/api/employees/findById/${newId}`
		}).done(function(data) {
			let UId = document.getElementById(`id-${data.body.id}`);
			let UPosition = document.getElementById(`position-${data.body.position}`);
			let UName = document.getElementById(`name-${data.body.name}`);
			let UPhoneNumber = document.getElementById(`phoneNumber-${data.body.phoneNumber}`);
			let UEmail = document.getElementById(`email-${data.body.email}`);

			let UBtn = document.getElementById(`btn--update-${data.body.id}`);
			let DBtn = document.getElementById(`btn--delete-${data.body.id}`);

			UId.innerHTML = `<input type="text" id="U--id" placeholder="${data.body.id}" value="${data.body.id}">`;
			UPosition.innerHTML = `<input type="text" id="U--position" placeholder="${data.body.position}" value="${data.body.position}">`;
			UName.innerHTML = `<input type="text" id="U--name" placeholder="${data.body.name}" value="${data.body.name}">`;
			UPhoneNumber.innerHTML = `<input type="text" id="U--phoneNumber" placeholder="${data.body.phoneNumber}" value="${data.body.phoneNumber}">`;
			UEmail.innerHTML = `<input type="text" id="U--email" placeholder="${data.body.email}" value="${data.body.email}">`;

			UBtn.innerHTML = `<button id="btn--cancel-${data.body.id}" class="btn--update" onclick="employees.cancelUpdate();">취소</button>`;
			DBtn.innerHTML = `<button id="btn--ok-${data.body.id}" class="btn--delete" onclick="employees.okUpdate(${data.body.id});">완료</button>`;
		}).fail(function(data) {
			alert('예기치 못 한 오류가 발생했습니다. 관리자에게 문의해주세요.');
		});
	},

	cancelUpdate: function() {
		alert('취소 됩니다.');
		location.reload();
	},

	okUpdate: function(originId) {
		let data = {
			id: $('#U--id').val(),
			position: $('#U--position').val(),
			name: $('#U--name').val(),
			phoneNumber: $('#U--phoneNumber').val(),
			email: $('#U--email').val()
		}
		if (data.id.length < 3) {
			alert('직원 번호는 반드시 3자리 이상으로 입력해주세요. ex) 001, 002');
		} else {
			$.ajax({
				type: 'post',
				url: `/api/employees/update/${originId}`,
				data: JSON.stringify(data),
				contentType: 'application/json; charset=UTF-8;',
				dataType: 'json'
			}).done(function(data) {
				alert(data.body);
				location.reload();
			}).fail(function(err) {
				alert('예기치 못 한 오류가 발생하였습니다.');
			});
		}
	},

	delete: function(id) {
		let newId = this.idCheck(id);
		if (confirm(`직원 번호 ${newId}번을 정말 삭제하시겠습니까?`)) {
			$.ajax({
				type: 'delete',
				url: `/api/employees/delete/${newId}`,
			}).done(function(data) {
				alert(data.body);
				document.getElementById(`employees-list-${newId}`).remove();
			}).fail(function(err) {
				alert('삭제에 실패 하였습니다.');
			});
		} else {
			alert('취소되었습니다.');
		}
	},

	idCheck: function(id) {
		let newId;
		if (id < 10) {
			newId = "00" + id;
		}
		return newId;
	}
}