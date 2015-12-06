jQuery(document).ready(function(){
	var $dataAula = jQuery("#dataAula");
	var $disciplina = jQuery("#iddisciplina");
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
	
	jQuery(document).on("click","input[name='alocacao']",function(){
		if(this.checked){
			var aula = this.value;
			var index = jQuery(this).parent("td").parent("tr").index();
			var professor_selecionado = jQuery("[name='prof_disciplina']:eq("+index+")").val();
			if(aula != 0 && aula != "" && professor_selecionado != 0){
				alocaProfessorAula(professor_selecionado, aula)
				jQuery(".tr_aulas:eq("+index+")").remove();
				alert('Registro salvo com sucesso');
			}
			else{
				alert('Aula ou Professor nao informados')
				this.checked = false;
			}
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
		
	var html_sem_aulas = "<tr class='tr_aulas'><td colspan='4' style='text-align:center'>Nenhuma aula para esse dia</td></tr>"
	
	jQuery.ajax({
		  method: "GET",
		  url: "AulasNaoAlocadas/" + disciplina + "/" + replace_Data,
		  dataType: 'json', 
		  contentType: 'application/json',
		  mimeType: 'application/json',
		  success:function(data){
			  var quantidade = data.length;
			  
			  html = quantidade == 0 ? html_sem_aulas : html;
			  
			  for(var i=0; i < quantidade; i++){
				  html +=  "<tr class='tr_aulas'>";
					  html +=  "<td>" + data_real + "</td>";
					  html +=  "<td>" + data[i].horaInicio +"/"+ data[i].horaFim + "</td>";
					  html +=  "<td>" + data[i].listaambiente.nome + "</td>"
					  html +=  "<td>"+ html_combo_professor +"</td>";
					  html +=  "<td style='text-align:center'>"+ "<input name='alocacao' type='checkbox' value='"+ data[i].idaulas +"'>"+"</td>";
				  html +=  "</tr>";
			  }
			  obTabela.append(html);
		  }
	})
}

function alocaProfessorAula(matricula, aula){
	
	var confirmar = confirm("Deseja alocar esse professor?")
	if(confirmar){
		jQuery.ajax({
			  method: "POST",
			  url: "AlocacaoProfessorAula/" + matricula + "/" + aula,
			  dataType: 'json', 
			  contentType: 'application/json',
			  mimeType: 'application/json',
			  async:false,
			  success:function(data){
				 alert('Professor alocado');
				 return true;
			  }
		})
	}
	return false;
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