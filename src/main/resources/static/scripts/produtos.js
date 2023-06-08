function mostrarConteudo(conteudoId) {
	var conteudos = document.getElementsByClassName('conteudo');
	for (var i = 0; i < conteudos.length; i++) {
	  conteudos[i].style.display = 'none';
	}
	document.getElementById(conteudoId).style.display = 'block';
	fecharNavbar();
	listProduto();
  }
  
  function fecharNavbar() {
	var navbarToggler = document.querySelector('.navbar-toggler');
	var targetModal = navbarToggler.getAttribute('data-bs-target');
	var modal = document.querySelector(targetModal);
	var bootstrapModal = bootstrap.Modal.getInstance(modal);
	bootstrapModal.hide();
  }
  
  document.addEventListener('DOMContentLoaded', function() {
	var sairButton = document.getElementById('sairButton');

	sairButton.addEventListener('click', function() {
	  window.location.href = 'index.html';
	});
	listCategoria();
	listMarca();
  });

function excluirProduto(e){
    var row = $(e).closest('tr');
    var id = row.find('td:eq(0)').text();   
    $.ajax({
      url: endpoint('/api/deleteProdutoById?id=' + id),
      type: 'DELETE',
      success: function() {
        alert('Produto foi removido com sucesso');
        row.remove();
      },
      error: function() {
        alert('Erro ao tentar excluir o produto');
      }
    });	
}

function getProdutoById(numero) {
	$.ajax({
		url: 'http://127.0.0.1:8081/api/getProdutoById?id=' + numero,
		type: 'GET',
		dataType: 'json',
		success: function(data) {
			console.log(data);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			console.error('Error fetching data:', errorThrown);
		}
	});
}


function listCategoria() {
	$.ajax({
		url: 'http://127.0.0.1:8081/api/listCategoria',
		type: 'GET',
		dataType: 'json',
		success: function(data) {
			const select = $('#categoria');
			select.empty();
			data.sort((a, b) => a.nome.localeCompare(b.nome));
			data.forEach(item => {
				const option = $('<option>', {
					value: item.id,
					text: item.nome
				});
				select.append(option);
			});
		},
		error: function(jqXHR, textStatus, errorThrown) {
			console.error('Error fetching data:', textStatus, errorThrown);
		}
	});
}

function listMarca() {
	$.ajax({
		url: 'http://127.0.0.1:8081/api/listMarca',
		type: 'GET',
		dataType: 'json',
		success: (data) => {
			const select = $("#marca");
			select.empty();
			data.sort((a, b) => a.nome.localeCompare(b.nome));
			data.forEach(item => {
				const option = $('<option>', {
					value: item.id,
					text: item.nome
				});
				select.append(option);
			});

		},
		error: (jqXHR, textStatus, errorThrown) => {
			console.error('Error fetching data:', textStatus, errorThrown);
		}
	})
}
function listProduto(){
	  $.ajax({
	    url: endpoint('/api/listProduto'),
	    method: 'GET',
	    success: function (data) {
			console.log(data);
			
	      $('#tabelaProdutos tbody').empty();
	      for (var i = 0; i < data.length; i++) {
	        var produto = data[i];
	        var novaLinha = $('<tr>');
	        novaLinha.append($('<td>').text(produto.id));
	        novaLinha.append($('<td>').text(produto.nome));
	        novaLinha.append($('<td>').text(produto.categoria.nome));
	        novaLinha.append($('<td>').text(produto.marca.nome));
	        novaLinha.append($('<td>').text(produto.preco));
	        novaLinha.append($('<td>').text(produto.quantidade_estoque));
			novaLinha.append($('<td>').html('<span class="excluir" onclick="excluirProduto(this)">EXCLUIR</>'));
	        $('#tabelaProdutos tbody').append(novaLinha);
	      }
	    },
	    error: function (jqXHR, textStatus, errorThrown) {
	      console.error('Error fetching data:', JSON.stringify(errorThrown));
	    }
	  });
	}

function endpoint(complemento){
	return 'http://127.0.0.1:8081' + complemento;
}

function salvarProduto(){
	console.log('clicoud');
	const json = {
		nome: $("#nome").val(),
		marca: {
			nome: $("#marca option:selected").text()
		},
		categoria: {
				nome: $("#categoria	 option:selected").text()
				},
		preco: $("#preco").val(),
		quantidadeEstoque: $("#qtdeEstoque").val(),
	}
	console.log(json);
	if ($("#categoria").val() == null) {alert("Cadastre Categoria!");return;};
	if ($("#marca").val() === null) {alert("Cadastre Marca!");return;};

	$.ajax({
		url: 'http://127.0.0.1:8081/api/saveProduto',
		type: 'POST',
		dataType: 'json',
		contentType: 'application/json',
		data: JSON.stringify(json),
		success: function(data) {
			console.log(data);
			alert('Produto cadastrado com sucesso');
		},
		error: function(jqXHR, textStatus, errorThrown) {
			console.error('Error fetching data:', errorThrown);
		}
	});
}

function salvarMarca(){
	const json = {
		nome: $('#novaMarca').val()
	}
	console.log(json);
	$.ajax({
		url: 'http://127.0.0.1:8081/api/saveMarca',
		type: 'POST',
		dataType: 'json',
		contentType: 'application/json',
		data: JSON.stringify(json),
		success: function(data) {
			console.log(data);
			$('#marcaModal').modal('hide')	;
		},
		error: function(jqXHR, textStatus, errorThrown) {
			console.error('Error fetching data:', errorThrown);
		}
	});
	window.location.href = 'produtos.html'
	
}

function salvarCategoria(){
	const json = {
		nome: $('#novaCategoria').val()
	}
	console.log(json);
	$.ajax({
		url: 'http://127.0.0.1:8081/api/saveCategoria',
		type: 'POST',
		dataType: 'json',
		contentType: 'application/json',
		data: JSON.stringify(json),
		success: function(data) {
			console.log(data);
			$('#categoriaModal').modal('hide')	;
		},
		error: function(jqXHR, textStatus, errorThrown) {
			console.error('Error fetching data:', errorThrown);
		}
	});
	window.location.href = 'produtos.html'
}