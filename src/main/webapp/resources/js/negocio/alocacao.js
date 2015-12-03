jQuery(document).ready(function(){
	var $dataAula = jQuery("#dataAula");
	var $disciplina = jQuery("#iddisciplina");
	
	jQuery("#verificar_aulas").click(function(){
		if($dataAula.val() != "" && $disciplina.val() != "0"){
		 	retornaAulas($disciplina.val(), formata_data_banco($dataAula.val()));
		}
	})
});

function retornaTurmaCurso(disciplina, data){
	var html = "";
	var obTabela = jQuery("#tabelaAulas")
	var trobTabela = jQuery(".tr_aulas")
	trobTabela.remove();
	
	jQuery.ajax({
		  method: "GET",
		  url: "AulasNaoAlocadas/" + disciplina + "/" + data,
		  dataType: 'json', 
		  contentType: 'application/json',
		  mimeType: 'application/json',
		  success:function(data){
			  var quantidade = data.length;
			  
			  for(var i=0; i < quantidade; i++){
				  html +=  "<tr class='tr_aulas'>";
					  html +=  "<td>" + data[i].data + "</td>";
					  html +=  "<td>" + data[i].horario + "</td>";
					  html +=  "<td>" + data[i].ambiente.nome + "</td>"
					  html +=  "<td>"+ retorna_combo_professor(disciplina) +"</td>";
				  html +=  "<tr>";
			  }
			  obTabela.append(html)
		  }
	})
}

function formata_data_banco(data){
	var dados = "" + data;
	dados = dados.split("/");
	var data_banco_dados = "";
	
	data_banco_dados = "'"+ dados[2] + "-" +  dados[1] + "-" + dados[0] + "'";
	
	return data_banco_dados;
}

function retorna_combo_professor(disciplina){
	var html = "";
	
	jQuery.ajax({
		  method: "GET",
		  url: "ProfessorDisciplina/" + disciplina,
		  dataType: 'json', 
		  contentType: 'application/json',
		  mimeType: 'application/json',
		  success:function(data){
			  var quantidade = data.length;
			  
			  html +="<select id='prof_disciplina' name='prof_disciplina'>";
			  html +="<option value='0'>Selecione o Professor</option>"
			  for(var i=0; i < quantidade; i++){
				  html +="<option value='"+ data[i].matriculaProfessor +"'>"+ data[i].nome +"</option>";
			  }
			  html +="</select>"
			  obTabela.append(html)
		  }
	})
	
}