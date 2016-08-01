jQuery(document).ready(function(){
	var turma = jQuery("#turma2")
	var professor = jQuery("#idprofessor")
	var notificacao = jQuery("#text_notificacao")
	
	jQuery("#enviar_notificacao").click(function(){
		var obj = {
			turma : turma.val(),
			professor: professor.val(),
			notificacao: notificacao.val()
		}
		if(validarNotificacao(obj)){
			notificarTurma(obj)
			notificacao.val('');
		}
	})
	
	//retorna_notificacao();
});

function notificarTurma(obj){
	jQuery.ajax({
		  method: "POST",
		  url: "Notificar/" + obj.turma + "/" + obj.professor + "/" + obj.notificacao,
		  success:function(data){
			  alert(data)
		  },error: function(e){
			  alert(e)
		  }
	})
}

function validarNotificacao(obj){
	if(obj.turma  == 0){
		alert('Informe a Turma');
		return false;
	}
	
	if(obj.notificacao == ''){
		alert('Incluir o texto da notificação')
		return false;
	}
	
	if(obj.professor == null){
		alert('Informe o professor')
		return false;
	}
	
	if(obj.notificacao.length > 255){
		alert('Informe um texto com até 255 caracteres')
		return false;
	}
	return true;
}

function retorna_lista_modelo(obj_geral){
	var obj_lista_modelo = $("#lista_notificacao");
	var obj_lista_modelo_li = $("#lista_modelo")
	
	var lista_clonada = obj_lista_modelo_li.clone()
	
	$(lista_clonada).find("#nome_modelo_lista").each(function(){
		this.value = obj.nome_pessoa;
	})
	
	$(lista_clonada).find("#data_modelo_lista").each(function(){
		this.value = obj.data_notificacao;
	})
	
	$(lista_clonada).find("#turma_modelo_lista").each(function(){
		this.value = obj.turma_notificacao;
	})
	
	$(lista_clonada).find("#msg_modelo_lista").each(function(){
		this.value = obj.notificacao;
	})
	
	obj_lista_modelo.append(lista_clonada);
}

function retorna_notificacao(){
	jQuery.ajax({
		  method: "GET",
		  url: "GetNotificacao",
		  dataType: 'json', 
		  contentType: 'application/json',
		  mimeType: 'application/json',
		  success:function(data){
			  var dados = eval(data)
			  
			  for(var i = 0; i < dados.length; i++){
				  var obj = {
					  nome_pessoa : dados[i].professor.nome,
					  data_notificacao : dados[i].dataNotificacao,
					  turma_notificacao : dados[i].turma.descricao,
					  notificacao: dados[i].notificacao
				  }
				  
				  retorna_lista_modelo(obj);
			  }
		  },error: function(e){
			  alert(e)
		  }
	})
}