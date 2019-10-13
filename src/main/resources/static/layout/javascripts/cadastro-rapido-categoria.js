$(function() {
	
	var modal = $('#modalCadastroRapidoCategoria');
	var botalSalvar = modal.find('.js-modal-cadastro-estilo-salvar-btn');
	var form = modal.find('.js-modal-formulario-estilo');
	
	form.on('submit', function(e) { e.preventDefault() });
	
	var url = form.attr('action');
	var imputNomeEstilo = modal.find('#nomeEstilo');
	var containerMensagemError = $('.js-mensagem-cadastro-rapido-estilo')
	
	modal.on('shown.bs.modal', onModalShow);
	modal.on('hide.bs.modal', onModalClose);
	modal.on('click', onBotaoSalvarClick);
	
	function onModalShow() {
		nomeCategoria.focus();
	}
	
	function onModalClose() {
		nomeCategoria.val('');
		containerMensagemError.addClass('hidden');
		form.removeClass('has-error');
	}
	
	function onBotaoSalvarClick() {
		var nomeCategoria = nomeCategoria.val().trim();
		
		$.ajax({
			
			url: url,
			method: 'POST',
			contentType: 'application/json',
			data: JSON.stringify({ nome : nomeCategoria }),
			error: onErrorSalvandoCategoria,
			success: onCategoriaSalva
		})
	}
	
	function onErrorSalvandoEstilo(obj) {
		var mensagens = obj.responseText;
		containerMensagemError.removeClass('hidden');
		containerMensagemError.html('<span>' + mensagens + '</span>' );
		form.find('.form-group').addClass('has-error');
		console.log(obj);
	}
	
	function onEstiloSalvo(estilo) {
		var comboEstilo = $('#estilo');
		comboEstilo.append('<option value=' + categoria.id + '>' + categoria.nome + '</option>');
		comboEstilo.val(estilo.codigo);
		modal.modal('hide');
	}