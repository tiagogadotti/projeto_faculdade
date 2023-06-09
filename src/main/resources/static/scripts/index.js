$(document).ready(() => {

    // ...

    $("#divCriarConta").hide();

    $("#cliqueAquiParaCadastrar").click(() => {
        $(".login-form").hide();
        $("#divCriarConta").show();
        $("#entrarConta").hide();
    });

    $("#voltarLogin").click(() => {
        $(".login-form").show();
        $("#divCriarConta").hide();
        $("#entrarConta").show();
    });

    // ...

});

 
  
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
			url: 'http://127.0.0.1:8081/api/login',
			type: 'POST',
			dataType: 'json',
			contentType: 'application/json',
			data: JSON.stringify(json),
			success: (responseData) =>{ 
					console.log(responseData);
					window.location.href = 'produtos.html';
					}
			,
			error: function(jqXHR, textStatus, errorThrown) {
				const retorno = JSON.parse(jqXHR.responseText)
				alert(retorno.erro);
				console.error('Error fetching data:', responseData);
			}
		});
	})
	
	$("#divCriarConta").hide();
	
	$("#cliqueAquiParaCadastrar").click( () => {
		$("#divCriarConta").show();
	})
	
	$("#criarConta").click( (event) =>{
		event.preventDefault();	
		const json = {
			nome: $("#cadastroNome").val(),
			email: $("#cadastroEmail").val(),
			senha: $("#cadastroSenha").val(),
			data_nascimento: $("#cadastroDataNascimento").val()
		}
		console.log(json);
		
		$.ajax({
			url: 'http://127.0.0.1:8081/api/saveUsuario',
			type: 'POST',
			dataType: 'json',
			contentType: 'application/json',
			data: JSON.stringify(json),
			success: function(response) {
				console.log(JSON.stringify(response));
				window.alert(response.mensagem);
			},
			error: function(jqXHR, textStatus, errorThrown) {
				console.error('Error fetching data:', JSON.stringify(errorThrown));
				retorno = JSON.parse(jqXHR.responseText);
				window.alert(retorno.mensagem);
			}
		});
	})
	
})



