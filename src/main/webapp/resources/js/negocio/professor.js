jQuery(document).ready(function(){
	var $turma = jQuery("#turma"); 
	var $carousel_alunos = jQuery("#carousel_alunos");
	var $matriculaProfessor = jQuery("#matriculaProfessor")
	var $qtdTurmas = jQuery("#qtdTurmas")
	
	
	if($turma.find("option").length == 1){
		retorna_combo_turmas($turma,"TurmaProfessor/" + $matriculaProfessor.val());
	}
	
	$qtdTurmas.text($turma.find("option").length)
	
	$turma.change(function(){
		dados_aluno($matriculaProfessor.val(),this.value);
		$carousel_alunos.html(dados_alunos_professor_turma);
	})
});

var dados_alunos_professor_turma = ""

function dados_aluno(professor, turma){
	var html = "";
	var vetor =  new Array();
	
	jQuery.ajax({
		  method: "GET",
		  url: "alunoVinculadosProfessor/" + professor + "/" + turma,
		  dataType: 'json', 
		  contentType: 'application/json',
		  mimeType: 'application/json',
		  async:false,
		  success:function(data){
			  var quantidade = data.length;
			  var dados = eval(data);
			  var tem_item = "";
			  
			  for(var i=0; i < quantidade; i++){
			    
				tem_item = i ==0 ? "active" : "";
				
				vetor = retorna_media_aluno(turma,data[i].matricula);
				
				var qtd_avaliacao =  vetor[1] == undefined ? 0 :  vetor[1]
				var media =  vetor[0] == undefined ? 0 :  vetor[0]
				
				html+= '<div class="'+tem_item+' item">'
				html+= '<div class="widget-container widget_profile col-10" >';
				html+= '<div class="inner">';
				html+= '<div class="widget_profile_top clearfix" style="margin-bottom:50px">';
				html+= '<div class="avatar"></div>';
				html+= '<h5>'+ data[i].nome +'</h5>';
				html+= '<span class="subtitle">'+ data[i].matricula +'</span>';
				html+= '<div class="follow">';
				html+= '<a href="#" class="btn btn-follow"><span>'+ data[i].email +'</span></a>';
				html+= '</div>';
				html+= '</div>';
				html+= '<ul class="counters clearfix">';
				html+= '<li class="first"><a href="#"><p>'+ qtd_avaliacao  +'</p><span>Quantidade Avalicoes</span></a></li>';
				html+= '<li><a href="#"><p>'+ media +'</p><span>Media</span></a></li>';
				html+= '<li class="last"><a href="#"><p>Futuro</p><span>% de Faltas</span></a></li>';
				html+= '</ul>';
				html+= '</div>';
				html+= '</div>';
				html+= '</div>';
			  }
			  
			  dados_alunos_professor_turma = html;
		  }
	})
}

function retorna_media_aluno(turma,matricula){
	var valor = new Array();
	
	jQuery.ajax({
		  method: "GET",
		  url: "AlunosMediaAvaliacao/" + turma + "/" + matricula,
		  dataType: 'json', 
		  contentType: 'application/json',
		  mimeType: 'application/json',
		  async:false,
		  success:function(data){
			  if(data.length > 0){
				  valor[0] = data[0].valor; 
				  valor[1] = data[0].qtdAvaliacoes;
			  }
		  }
	})
	
	return valor;
}
