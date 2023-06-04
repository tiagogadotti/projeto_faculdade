function mostrarConteudo(conteudoId) {
	var conteudos = document.getElementsByClassName('conteudo');
	for (var i = 0; i < conteudos.length; i++) {
	  conteudos[i].style.display = 'none';
	}
	document.getElementById(conteudoId).style.display = 'block';
	fecharNavbar();
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
  });
  
  

$(document).ready(() => {
	getAllCategoria();
	getAllMarca();
	getAllProdutos();


	$("#salvarProduto").click(() => {
		const json = {
			nome: $("#nome").val(),
			marca: $("#marca").val(),
			categoria: $("#categoria").val(),
			preco: $("#preco").val(),
			quantidadeEstoque: $("#qtdeEstoque").val(),
		}

		$.ajax({
			url: 'http://127.0.0.1:8081/api/insertProduto',
			type: 'POST',
			dataType: 'json',
			contentType: 'application/json',
			data: JSON.stringify(json),
			success: function(data) {
				console.log(data);
			},
			error: function(jqXHR, textStatus, errorThrown) {
				console.error('Error fetching data:', errorThrown);
			}
		});
		getAllProdutos();
	})
})

function displayProdutos(produtos) {
	let table = $('<table>').addClass('productTable');
	let headerRow = $('<tr>').append(
		$('<th>').text('ID'),
		$('<th>').text('Nome'),
		$('<th>').text('Marca'),
		$('<th>').text('Preço'),
		$('<th>').text('Categoria'),
		$('<th>').text('Quantidade Estoque'),
		$('<th>').text('Editar'),
		$('<th>').text('Excluir')
	);
	table.append(headerRow);


	produtos.forEach(produto => {
		let row = $('<tr>').append(
			$('<td>').text(produto.id),
			$('<td>').text(produto.nome),
			$('<td>').text(produto.marca),
			$('<td>').text(produto.preco),
			$('<td>').text(produto.categoria),
			$('<td>').text(produto.quantidadeEstoque)
		);
		table.append(row);
	});

	// Append the table to the container div
	$('#productTableContainer').empty().append(table);
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


function getAllProdutos() {
	$.ajax({
		url: 'http://127.0.0.1:8081/api/getAllListaProdutos',
		type: 'GET',
		dataType: 'json',
		success: function(data) {
			displayProdutos(data);
		},
		error: (jqXHR, textStatus, errorThrown) => {
			console.error('Error fetching data:', textStatus, errorThrown);
		}
	});
}

function getAllCategoria() {
	$.ajax({
		url: 'http://127.0.0.1:8081/api/getAllCategoria',
		type: 'GET',
		dataType: 'json',
		success: function(data) {
			const select = $('#categoria');
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


function getAllMarca() {
	$.ajax({
		url: 'http://127.0.0.1:8081/api/getAllMarca',
		type: 'GET',
		dataType: 'json',
		success: (data) => {
			const select = $("#marca");
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
