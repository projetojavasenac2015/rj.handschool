jQuery(document).ready(function(){
	jQuery("#idcurso").change(function(){
		 retornaTurmaCurso(this.value);
	})
});

function retornaTurmaCurso(id){
	var html = "";
	var obTabela = jQuery("#tableCursoAtivo")
	var trobTabela = jQuery(".tr_curso_tabela")
	trobTabela.remove();
	
	jQuery.ajax({
		  method: "GET",
		  url: "TurmasAtivas/" + id,
		  dataType: 'json', 
		  contentType: 'application/json',
		  mimeType: 'application/json',
		  success:function(data){
			  var quantidade = data.length;
			  var dados = eval(data);
			  
			  for(var i=0; i < quantidade; i++){
				  html +=  "<tr class='tr_curso_tabela'>";
					  html +=  "<td>" + data[i].descricao + "</td>";
					  html +=  "<td>" + data[i].ano + "</td>";
					  html +=  "<td>" + data[i].quantidadeAlunos + "</td>";
					  html +=  "<td>" + data[i].ativo + "</td>";
				  html +=  "<tr>";
			  }
			  obTabela.append(html)
		  }
	})
}

