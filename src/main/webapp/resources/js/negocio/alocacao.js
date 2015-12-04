jQuery(document).ready(function(){
	var $dataAula = jQuery("#dataAula");
	var $disciplina = jQuery("#iddisciplina");
	
	jQuery("#verificar_aulas").click(function(){
		if($dataAula.val() != "" && $disciplina.val() != "0"){
		 	var data = formata_data_banco($dataAula.val());
			retornaAulas($disciplina.val(), data, $dataAula.val());
		}
		else{
			alert("Data da aula ou disciplina nao Informadas.")
		}
	})
});

function retornaAulas(disciplina, data, data_real){
	var replace_Data = data.replace("'","").replace("'","")
	var html = "";
	var obTabela = jQuery("#tabelaAulas")
	var trobTabela = jQuery(".tr_aulas")
	trobTabela.remove();
	
	html_combo_professor = ""
		
	retorna_combo_professor(disciplina);
		
	jQuery.ajax({
		  method: "GET",
		  url: "AulasNaoAlocadas/" + disciplina + "/" + replace_Data,
		  dataType: 'json', 
		  contentType: 'application/json',
		  mimeType: 'application/json',
		  success:function(data){
			  var quantidade = data.length;
			  
			  for(var i=0; i < quantidade; i++){
				  html +=  "<tr class='tr_aulas'>";
					  html +=  "<td>" + data_real + "</td>";
					  html +=  "<td>" + data[i].horaInicio +"/"+ data[i].horaFim + "</td>";
					  html +=  "<td>" + data[i].listaambiente.nome + "</td>"
					  html +=  "<td>"+ html_combo_professor +"</td>";
				  html +=  "<tr>";
			  }
			  obTabela.append(html);
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

var html_combo_professor;

function retorna_combo_professor(disciplina){
	var html = "";
	
	jQuery.ajax({
		  method: "GET",
		  url: "ProfessorDisciplina/" + disciplina,
		  dataType: 'json', 
		  contentType: 'application/json',
		  mimeType: 'application/json',
		  async:false,
		  success:function(data){
			  var quantidade = data.length;
			  html +='<select id="prof_disciplina" name="prof_disciplina">';
			  html +='<option value="0">Selecione o Professor</option>';
			  for(var i=0; i < quantidade; i++){
				  html +='<option value="'+ data[i].matriculaProfessor +'">'+ data[i].nome +'</option>';
			  }
			  html +='</select>';
			  html_combo_professor = html ;
		  }
	})
	
}