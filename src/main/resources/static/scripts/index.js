$(document).ready(() => {
    
    $("#teste").click(() => {
        window.location.href = 'produtos.html';
    })
	
	$("#entrarConta").click( (event) =>{
		event.preventDefault();	
		const json = {
			email: $("#email").val(),
			senha: $("#password").val()
		}
		
		$.ajax({
			url: 'http://127.0.0.1:8081/login',
			type: 'POST',
			dataType: 'json',
			contentType: 'application/json',
			data: JSON.stringify(json),
			success: function(isAuthorized) {
				if (!isAuthorized){
					alert("Credenciais Inválidas!");
				}else{
					window.location.href = 'produtos.html';
				}
			},
			error: function(jqXHR, textStatus, errorThrown) {
				console.error('Error fetching data:', errorThrown);
			}
		});
		
	})
});