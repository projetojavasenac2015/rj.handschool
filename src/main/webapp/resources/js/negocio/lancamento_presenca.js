jQuery(document).ready(function(){
	var $dataAula = jQuery("#dataHoraCadastro");
	var $disciplina = jQuery("#iddisciplinas");
	var $turma = jQuery("#turma"); 
	var $verificar_turma_presenca = jQuery("#verificar_turma");
	
	retorna_combo_turmas($turma,"TurmaProfessor/MAT03122015211611");
	
	$turma.change(function(){
		retorna_combo_disciplinas_turma($disciplina,"DisciplinasTurma/" + this.value)
	})
	
	$verificar_turma_presenca.click(function(){
		var data_aula = formata_data_banco($dataAula.val()).replace("'","").replace("'","")
		retornaAlunoTurma($turma.val(), $disciplina.val(),data_aula, 'MAT06122015192455');
	})
});

function retornaAlunoTurma(turma, disciplina, data_aula, matricula){
	var html = "";
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
					  html +=  "<td>" + data[i].aluno.nome + "&nbsp;<input type='checkbox' name='aluno_presenca'/>" + "</td>";
					  html +=  "<td>" + data[i].aluno.matricula + "</td>";
					  html +=  "<td>" + data[i].turma.descricao + "</td>";
					  html +=  "<td>" + data[i].disciplina.nome + "</td>";
					  html +=  "<td>" + data[i].aulas.dataAula + "</td>";
					  html +=  "<td>" + data[i].aulas.horaInicio + "/" + data[i].aulas.horaFim + "</td>";
					 
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