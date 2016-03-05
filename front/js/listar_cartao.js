function criarCartao (cartao, id) {

	var panelDefault = $('<div class="panel panel-default"></div>');
	var panelHeading = $('<div class="panel-heading clearfix"></div>');
	var panelTitle = $('<h4 class="panel-title"></h4>');
	var nomeCartao = $('<a data-toggle="collapse" data-parent="#accordion" href="#collapse'+id+'" class="nome-cartao"></a>');
	var buttons = $('<div class="pull-right"><a class="edit" href="#" title="Editar Cartão de Vacina"><i class="glyphicon glyphicon-pencil"></i></a><a class="remove" href="#" title="Remover Cartão de Vacina"><i class="glyphicon glyphicon-remove"></i></a></div>');
	var nome = cartao.nome;
	var panelCollapse = $('<div id="collapse'+id+'" class="panel-collapse collapse in"></div>');
	var panelBody = $('<div class="panel-body"></div>');
	var list = $('<ul class="vacinas-list"></ul>');

	$('.panel-group').append(panelDefault);
	panelDefault.append(panelHeading);
	panelHeading.append(panelTitle);
	panelTitle.append(nomeCartao);
	nomeCartao.append(nome);
	panelTitle.append(buttons);
	panelDefault.append(panelCollapse);
	panelCollapse.append(panelBody);
	panelBody.append(list);

	 cartao.vacinas.forEach(function(vacina){
	 	list.append('<li>'+vacina.nome+'<a href="#" title="Ver detalhes"><i class="glyphicon glyphicon-eye-open ver"></i></a></li>');
	 });


}

$( document ).ready(function() {

    $.getJSON( "moc.json", function( resp ) {
	  var items = [];
	  console.log(resp.data[0].nome);
	  var id = 0;
	  resp.data.forEach(function(cartao){
	  	criarCartao(cartao, id);
	  	id++;
	  });
	  
	});
});