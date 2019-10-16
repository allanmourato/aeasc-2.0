$(function() {
	
	var modal = $('#modalCadastroRapidoCategoria');
	var botalSalvar = modal.find('.js-modal-cadastro-categoria-salvar-btn');
	var form = modal.find('.js-modal-formulario-categoria');
	var comboCategoria = $('#comboCategoria');
	
	form.on('submit', function(e) { e.preventDefault() });
	
	var url = form.attr('action');
	var imputNomeCategoria= modal.find('#nomeCategoria');
	var containerMensagemError = $('.js-mensagem-cadastro-rapido-categoria')
	
	modal.on('shown.bs.modal', onModalShow);
	modal.on('hide.bs.modal', onModalClose);
	modal.on('click', onBotaoSalvarClick);
	
	function onModalShow() {
		imputNomeCategoria.focus();
	}
	
	function onModalClose() {
		imputNomeCategoria.val('');
		containerMensagemError.addClass('hidden');
		form.removeClass('has-error');
	}
	
	function onBotaoSalvarClick() {
		var nomeCategoria = imputNomeCategoria.val().trim();
		
		$.ajax({
			
			url: url,
			method: 'POST',
			contentType: 'application/json',
			data: JSON.stringify({ nome : nomeCategoria }),
			error: onErrorSalvandoCategoria,
			success: onCategoriaSalva
		});
	}
	
	function onErrorSalvandoCategoria(obj) {
		var mensagens = obj.responseText;
		containerMensagemError.removeClass('hidden');
		containerMensagemError.html('<span>' + mensagens + '</span>' );
		form.find('.form-group').addClass('has-error');
		console.log(obj);
	}
	
	function onCategoriaSalva(categoria) {
		var comboCategoria = $('#comboCategoria');
		comboCategoria.append('<option value=' + categoria.id + '>' + categoria.nome + '</option>');
		comboCategoria.val(categoria.id);
		modal.modal('hide');
	}
});