$(document).ready(() => {

	$("#salvarCategoria").click(() => {

		json = {
			nome: $("#nomeCategoria").val()
		}

		$.ajax({
			url: 'http://127.0.0.1:8081/api/saveCategoria',
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(json),
			success: function(response) {
				window.alert($("#nomeCategoria").val() + " CADASTRADO COM SUCESSO!	");
			},
			error: function(xhr, status, error) {
				console.log('Error: ' + error);
			}
		});

	})


})
