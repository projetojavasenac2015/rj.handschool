jQuery(document).ready(function(){
	var $dataAula = jQuery("#dataHoraCadastro");
	var $disciplina = jQuery("#iddisciplinas");
	var $turma = jQuery("#turma"); 
	var $verificar_turma_presenca = jQuery("#verificar_turma");
	var $matriculaProfessor = jQuery("#matriculaProfessor")
	
	retorna_combo_turmas($turma,"TurmaProfessor/" + $matriculaProfessor.val());
	
	$turma.change(function(){
		retorna_combo_disciplinas_turma($disciplina,"DisciplinasTurma/" + this.value)
	})
	
	$verificar_turma_presenca.click(function(){
		var data_aula = formata_data_banco($dataAula.val()).replace("'","").replace("'","")
		retornaAlunoTurma($turma.val(), $disciplina.val(),data_aula, $matriculaProfessor.val());
	})
	
	retorna_combo_presenca();
	
	jQuery(document).on('change',"[name='presenca_aluno']",function(){
		var index = jQuery(this).parent("td").parent("tr").index();
		var dados = jQuery("[name='matricula_aula']:eq("+index+")").val().split("/");
		efetua_lancamento_presenca(dados[0],dados[1],jQuery(this).val());
		jQuery(".tr_presenca_tabela:eq("+index+")").remove();
	})
});

function retornaAlunoTurma(turma, disciplina, data_aula, matricula){
	var html = "", html2 = "";
	var obTabela = jQuery("#tabelaAlunoPresenca")
	var trobTabela = jQuery(".tr_presenca_tabela")
	trobTabela.remove();
	
	jQuery.ajax({
		  method: "GET",
		  url: "ListaPresenca/" + turma + "/" + disciplina  + "/" + data_aula + "/" + matricula,
		  dataType: 'json', 
		  contentType: 'application/json',
		  mimeType: 'application/json',
		  success:function(data){
			  var quantidade = data.length;
			  var dados = eval(data);
			  
			  for(var i=0; i < quantidade; i++){
				  html +=  "<tr class='tr_presenca_tabela'>";
					  html +=  "<td>" + data[i].aluno.nome + "</td>";
					  html +=  "<td>" + combo_presenca_aluno+ "</td>";
					  html +=  "<td>" + data[i].aluno.matricula + "</td>";
					  html +=  "<td>" + data[i].turma.descricao + "</td>";
					  html +=  "<td>" + data[i].disciplina.nome + "</td>";
					  //html +=  "<td>" + data[i].aulas.dataAula + "</td>";
					  html +=  "<td>" + data[i].aulas.horaInicio + "/" + data[i].aulas.horaFim + "</td>";
					  html += "<input type='hidden' name='matricula_aula' value="+ data[i].aluno.matricula + "/" + data[i].aulas.idaulas +" />"
				  html +=  "</tr>";
			  }
			  
			  if(quantidade == 0){
				  html +=  "<tr class='tr_presenca_tabela'><td colspan='7' style='text-align:center'>Nenhum dado encontrado</td></tr>";
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

var combo_presenca_aluno = "";

function retorna_combo_presenca(){
	var html2 = "";
	html2 += "<select name='presenca_aluno' class='select_styled'>";
	html2 += "<option value='0'>Selecione</option>";
	html2 += "<option value='P'>Presente</option>";
	html2 += "<option value='A'>Ausente</option>";
	html2 += "</select>";
	combo_presenca_aluno = html2;
}

function efetua_lancamento_presenca(matricula, aula,situacao){
	if(matricula != "" && aula != "" && situacao !=0){
		jQuery.ajax({
			  method: "POST",
			  url: "EfetuaPresenca/" + matricula + "/" + aula  + "/" + situacao,
			  dataType: 'json', 
			  contentType: 'application/json',
			  mimeType: 'application/json',
			  async:false,
			  success:function(data){
				  alert("Registro efetuado");
			  }
		})
	}
	else{
		alert("Algum dado não informado.")
	}
}
