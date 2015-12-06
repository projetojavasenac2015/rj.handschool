jQuery(document).ready(function(){
	jQuery("#painelMatricula").hide();
	
	jQuery("#idcurso").change(function(){
		 retornaTurmaCurso(this.value);
	})
	
	jQuery(document).on('click','[name="atribuir_aluno"]', function(){
		jQuery("#turma_matricular").text(this.title);
		jQuery("#idturma").val(this.value);
		jQuery("#painelMatricula").show();
		retoraAlunosTurma(this.value);
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
					  html +=  "<td><input type='radio' name='atribuir_aluno' title='"+ data[i].descricao +"' value='"+ data[i].idturma +"'/></td>";
				  html +=  "<tr>";
			  }
			  obTabela.append(html)
		  }
	})
}


function retornaDadosAlunos(matricula, nome, obj){
	var html = "";
	var modelo = getModelo(matricula, nome);
	
	var idturma = jQuery("#idturma")
	
	if(idturma != undefined){
		idturma = idturma.val();
	}
	
	if(obj.checked){
		
		var index = jQuery(obj).parent().parent().index();
		
		jQuery("#painelMatriculaAtribuida").append(modelo);
		
		jQuery.ajax({
			  method: "POST",
			  url: "EfetuaMatricula/" + idturma + "/" + matricula,
		  	  dataType: 'json', 
			  contentType: 'application/json',
			  mimeType: 'application/json',
			  success:function(data){
				  alert('Matrícula Efetuada');
			  }
		});
		jQuery("#tableAlunoMatriculado tr:eq("+ (index + 1) +")").remove();
	}
	
	
}

function getModelo(matricula, nome){
	var modelo = "<div class='feed-item-body'>";
	modelo+=""+ matricula +"&nbsp;-&nbsp;" + nome
	modelo+="</div><div class='divider'></div>";
	return modelo;
}

function retoraAlunosTurma(idturma){
	var html = "";
	var objPainel = jQuery("#painelMatriculaAtribuida")
	var objPainel2 = jQuery(".feed-item-body")
	var objPainel3 = jQuery(".feed-item-body > divider")
	objPainel2.remove();
	objPainel3.remove();
	
	jQuery.ajax({
		  method: "GET",
		  url: "AlunosMatriculadosTurma/" + idturma,
		  dataType: 'json', 
		  contentType: 'application/json',
		  mimeType: 'application/json',
		  success:function(data){
			  var quantidade = data.length;
			  var dados = eval(data);
			  
			  for(var i=0; i < quantidade; i++){
				  html += getModelo(dados[i].matricula,dados[i].nome);
			  }
			  objPainel.append(html)
		  }
	})
}
	
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
