function ediarCartao (cartao) {

	$('#inputNome').val(cartao.nome);
	$('#inputTipo').val(cartao.tipo);



}

$( document ).ready(function() {

    $.getJSON( "moc_editar.json", function( resp ) {
	  var items = [];
	  var id = 0;
	  resp.data.forEach(function(cartao){
	  	ediarCartao(cartao, id);
	  	id++;
	  });
	  
	});
});