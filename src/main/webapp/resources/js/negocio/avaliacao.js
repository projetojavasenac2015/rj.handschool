jQuery(document).ready(function($){
	var $disciplina = jQuery("#iddisciplinas");
	var $turma = jQuery("#turma"); 
	var $datas_todas_aula = jQuery("#datas_todas_aula")
	var $horarios = jQuery("#horarios")
	var $confirmar_avaliacao = jQuery("#confirmar_avaliacao")
	var $tipoAvaliacao = jQuery("#tipoAvaliacao")
	var $verificar_aulas = jQuery("#verificar_aulas")
	var $idaulas = jQuery("#idaulas")
	var $horarios = jQuery("#horarios")
	var $matriculaProfessor = jQuery("#matriculaProfessor")
	var $valor_min = jQuery("#valor_min")
	var $valor_max = jQuery("#valor_max")
	
	retorna_combo_turmas($turma,"TurmaProfessor/" + $matriculaProfessor.val());
	
	$turma.change(function(){
		retorna_combo_disciplinas_turma($disciplina,"DisciplinasTurma/" + this.value)
	})
	
	$disciplina.change(function(){
		if(this.value != 0){
			retorna_datas($turma.val(), this.value, $matriculaProfessor.val());
			jQuery(".calendar").remove();
			if(dados_data_aula != ""){
				calendario("#data_aulas");
			}
			retorna_combo_datas($datas_todas_aula)
		}
	})
	
	jQuery(document).on('change',"#datas_todas_aula", function(){
		var data_da_aula = this.value;
		
		if(data_da_aula != ""){
			var data_aux = data_da_aula.split("/");
			var data_real = data_aux[2] + "-" + data_aux[1] +"-" + data_aux[0];
			retorna_datas_aula($horarios,$turma.val(), $disciplina.val(), $matriculaProfessor.val(),data_real)
		}
	})
	
	$confirmar_avaliacao.click(function(){
		if($horarios.val() != "" && $horarios.val() != "0"){
			agenda_avaliacao($horarios.val(),$tipoAvaliacao.val(),$valor_min.val(), $valor_max.val());
			alerta('Aula Agendada!')
			window.location.reload();
		}
		else{
			alert('Nenhuma aula foi informada.')
		}
	})
	
	$horarios.change(function(){
		if(this.value != 0 && this.value != ""){
			$idaulas.val(this.value);
		}
	})
	
	if($verificar_aulas){
		$verificar_aulas.click(function(){
			if($idaulas.val() !="" && $idaulas.val() !=0 && $tipoAvaliacao.val() != "" && $tipoAvaliacao.val() != "0"){
				retornaAlunoAvaliacao($idaulas.val(),$tipoAvaliacao.val());
			}
			else{
				alert('Nenhuma aula encontrada');
			}
		})
	}
	
	if($matriculaProfessor.val() != ''){
		retornaQuadroAvaliacao($matriculaProfessor.val());
	}
});

function retorna_combo_turmas(obj, url){
	var html = "";
	var html2 = "";
	
	jQuery.ajax({
		  method: "GET",
		  url: url,
		  dataType: 'json', 
		  contentType: 'application/json',
		  mimeType: 'application/json',
		  async:false,
		  success:function(data){
			  var quantidade = data.length;
			  for(var i=0; i < quantidade; i++){
				  html +='<option value="'+ data[i].idturma +'">'+ data[i].descricao +'</option>';
				  html2 += '<span val="'+ data[i].idturma +'" class="last">'+ data[i].descricao +'</span>';
			  }
			  obj.append(html) ;
			  jQuery("#cusel-scroll-" + obj.attr("id")).append(html2);
		  }
	})
}

function agenda_avaliacao(idaula, tipo, valor_min, valor_max){
	var html = "";
	var html2 = "";
	
	jQuery.ajax({
		  method: "POST",
		  url: "ConfirmaAgendaAvaliacao/" + idaula + "/" + tipo + "/" + valor_min + "/" + valor_max,
		  dataType: 'json', 
		  contentType: 'application/json',
		  mimeType: 'application/json',
		  async:false,
		  success:function(data){
			 
		  }
	})
	alert('Avaliacao Agendada com sucesso!')
    window.location.reload();
}

var dados_data_aula = "";

function retorna_datas(idturma,iddisciplina, matricula){
	var dias
	jQuery.ajax({
		  method: "GET",
		  url: "AulasDisciplinas/"+ idturma +"/" + iddisciplina + "/" + matricula,
		  dataType: 'json', 
		  contentType: 'application/json',
		  mimeType: 'application/json',
		  async:false,
		  success:function(data){
			  var qtd = data.length;
			  if(qtd > 0){
				  var data_ini = data[0];
				  var datas = "";
				  
				  for(var i = 0; i < qtd; i++){
					  
				  }
			  }
			  dados_data_aula = data;
		  }
	})
}

function retorna_datas_aula(obj,idturma,iddisciplina, matricula, data){
	
	var html = "";
	var html2 = "";
	var spans = jQuery("#cusel-scroll-" + obj.attr("id"));
	
	obj.find("option").remove();
	spans.find("span:eq(0)").addClass("cuselActive first las");
	jQuery("#curselFrame-"+ obj.attr("id") +" > div .cuselText").text(spans.find("span:eq(0)").text());
	spans.find("span:not(:eq(0))").remove();
	
	jQuery.ajax({
		  method: "GET",
		  url: "AulasDisciplinas/"+ idturma +"/" + iddisciplina + "/" + matricula + "/" + data,
		  dataType: 'json', 
		  contentType: 'application/json',
		  mimeType: 'application/json',
		  async:false,
		  success:function(data){
			  var quantidade = data.length;
			  for(var i=0; i < quantidade; i++){
				  
				  var id_separado = data[i].split('?');
				  var id = id_separado[0]
				  
				  html +='<option value="'+ id +'">'+ data[i].replace(id + "?","") +'</option>';
				  html2 += '<span val="'+ id +'" class="last">'+ data[i].replace(id + "?","") +'</span>';
			  }
			  obj.append(html) ;
			  spans.append(html2);
		  }
	})
	
}

function retorna_combo_disciplinas_turma(obj, url){
	var html = "";
	var html2 = "";
	var spans = jQuery("#cusel-scroll-" + obj.attr("id"));
	
	obj.find("option").remove();
	spans.find("span:eq(0)").addClass("cuselActive first las");
	jQuery("#curselFrame-"+ obj.attr("id") +" > div .cuselText").text(spans.find("span:eq(0)").text());
	spans.find("span:not(:eq(0))").remove();
	
	jQuery.ajax({
		  method: "GET",
		  url: url,
		  dataType: 'json', 
		  contentType: 'application/json',
		  mimeType: 'application/json',
		  async:false,
		  success:function(data){
			  var quantidade = data.length;
			  for(var i=0; i < quantidade; i++){
				  html +='<option value="'+ data[i].iddisciplina +'">'+ data[i].nome +'</option>';
				  html2 += '<span val="'+ data[i].iddisciplina +'" class="last">'+ data[i].nome +'</span>';
			  }
			  obj.append(html) ;
			  spans.append(html2);
		  }
	})
}

function retorna_combo_datas(obj){
	var html = "";
	var html2 = "";
	
	obj.find("option:not(:eq(0))").remove();
	var spans = jQuery("#cusel-scroll-" + obj.attr("id"));
	jQuery("#curselFrame-"+ obj.attr("id") +" > div .cuselText").text(spans.find("span:eq(0)").text());
	spans.find("span:not(:eq(0))").remove();
	
	var qtd = dados_data_aula.length
	
	for(var i=0; i < qtd; i++){
		var data_real_separada = dados_data_aula[i].split('/');
		var data_real = data_real_separada[1] + "/" + data_real_separada[0] + "/" + data_real_separada[2];
		
	  html +='<option value="'+ data_real +'">'+ data_real +'</option>';
	  html2 += '<span val="'+ data_real +'" class="last">'+ data_real +'</span>';
	}
	obj.append(html) ;
	spans.append(html2);
}

var daysRange = 5;

function calendario(id) {
	$('<div class="calendar" />')
            .insertAfter($(id))
            .multiDatesPicker({
            	maxPicks: 1,
                addDates: eval(dados_data_aula),
                numberOfMonths: [1,1]
            }).prev().hide();
}


function retornaAlunoAvaliacao(idaulas, tipoavaliacao){
	var html = "", html2 = "";
	var obTabela = jQuery("#tabelaAlunoNaoAvaliado")
	var trobTabela = jQuery(".tr_nao_avaliado_tabela")
	trobTabela.remove();
	
	jQuery.ajax({
		  method: "GET",
		  url: "AlunosNaoAvaliados/" + idaulas + "/" + tipoavaliacao,
		  dataType: 'json', 
		  contentType: 'application/json',
		  mimeType: 'application/json',
		  success:function(data){
			  var quantidade = data.length;
			  var dados = eval(data);
			  
			  for(var i=0; i < quantidade; i++){
				  html +=  "<tr class='tr_nao_avaliado_tabela'>";
					  html +=  "<td style='vertical-align:middle'><span id='matricula_td_"+ i +"'>" + data[i].aluno.matricula + "</span></td>";
					  html +=  "<td style='vertical-align:middle'>" + data[i].aluno.nome + "</td>";
					  html +=  "<td>" + "<input type='text' size=2 style='heigth:29px' maxlength='3' name='nota' id='nota_"+ i +"'/>" + "</td>";
					  html +=  "<td style='vertical-align:middle'>" + "<a class='glyphicon glyphicon-edit' name='lancar_nota' onclick='lancar_notas("+ data[i].avaliacao.idavaliacao +","+ i +")'></a>" + "</td>";
				  html +=  "</tr>";
			  }
			  
			  if(quantidade ==0){
				  html +=  "<tr class='tr_nao_avaliado_tabela'>";
				  html +=  "<td colspan='4' style='text-align:center'>Nenhum dado econtrado.</td></tr>";
			  }
			  
			  obTabela.append(html)
		  }
	})
}

function lancar_notas(idavaliacao, id){
	if(idavaliacao !="0"){
		var nota = jQuery("#nota_" +id);
		var matricula = jQuery("#matricula_td_" + id)
		
		if(nota.val() !=0 && nota.val() != "" && matricula.text() != ""){
			efetua_lancamento_nota(nota.val(),idavaliacao,matricula.text());
		}
		else{
			alert('Informe o Valor da Nota!');
		}
	}
}

function efetua_lancamento_nota(nota,idavaliacao, matricula){
	jQuery.ajax({
		  method: "POST",
		  url: "EfetuaLancamentoNota/" + idavaliacao + "/" + matricula + "/" + nota,
		  dataType: 'json', 
		  contentType: 'application/json',
		  mimeType: 'application/json',
		  async:false,
		  success:function(data){
			  
		  }
	})
}

function retornaQuadroAvaliacao(matricula){
	var html = "", html2 = "";
	var obTabela = jQuery("#tabelaQuadroAvisos")
	var trobTabela = jQuery(".tr_nao_avaliado_tabela")
	trobTabela.remove();
	
	if(obTabela != undefined){
		jQuery.ajax({
			  method: "GET",
			  url: "QuadroAvaliacoes/" + matricula,
			  dataType: 'json', 
			  contentType: 'application/json',
			  mimeType: 'application/json',
			  success:function(data){
				  var quantidade = data.length;
				  var dados = eval(data);
				  
				  for(var i=0; i < quantidade; i++){
					  html +=  "<tr class='tr_nao_avaliado_tabela'>";
						  html +=  "<td>"+ formataDatas(data[i].data) +"</td>"
						  html +=  "<td style='text-align:center'>"+data[i].tipoAvaliacao.descricao+"</td>"
						  html +=  "<td style='text-align:center'>"+data[i].qtdAvaliacoes+"</td>"
						  html +=  "<td style='text-align:center'>"+data[i].valor +"</td>"
						  html +=  "<td style='text-align:center'>"+data[i].qtdReprovados +"</td>"
						  html +=  "<td style='text-align:center'>"+data[i].qtdAprovados +"</td>"
					  html +=  "</tr>";
				  }
				  obTabela.append(html)
			  }
		})
	}
}

function formataDatas(datas){
	if(datas != ''){
		var datas2 = datas.split('-');
		var datas3= datas2[2] + "/" + datas2[1] + "/" + datas2[0];
	}
	
	return datas3;
}
