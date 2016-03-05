function adicionarVacinas (cartao, id) {

	var panelDefault = $('<div class="panel panel-default"></div>');
	var panelHeading = $('<div class="panel-heading clearfix"></div>');
	var panelTitle = $('<h4 class="panel-title"></h4>');
	var nomeCartao = $('<a data-toggle="collapse" data-parent="#accordion" href="#collapse'+id+'" class="nome-cartao"></a>');
	var buttons = $('<div class="pull-right"><a class="remove" href="#" title="Remover Cartão de Vacina"><i class="glyphicon glyphicon-remove"></i></a></div>');
	var nome = cartao.nome;
	var panelCollapse = $('<div id="collapse'+id+'" class="panel-collapse collapse"></div>');
	var panelBody = $('<div class="panel-body"></div>');
	var content = $('<p><strong>Última dose:</strong> <span class="ultima-dose">'+cartao.ultimaDose+'</span></p><p><strong>Próxima dose:</strong> <span class="proxima-dose">'+cartao.proximaDose+'</span><p><p class="descricao">'+cartao.descricao+'</p>');

	$('.panel-group').append(panelDefault);
	panelDefault.append(panelHeading);
	panelHeading.append(panelTitle);
	panelTitle.append(nomeCartao);
	nomeCartao.append(nome);
	panelTitle.append(buttons);
	panelDefault.append(panelCollapse);
	panelCollapse.append(panelBody);
	panelBody.append(content);


}

$( document ).ready(function() {

    $.getJSON( "moc_adicionar_vacina.json", function( resp ) {
	  var items = [];
	  var id = 0;
	  resp.data.forEach(function(cartao){
	  	adicionarVacinas(cartao, id);
	  	id++;
	  });
	  $('.page-title').text('Vacinas de '+ resp.usuario);
	});
});