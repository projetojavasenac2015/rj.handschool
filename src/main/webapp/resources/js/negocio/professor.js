jQuery(document).ready(function(){
	var $turma = jQuery("#turma"); 
	var $carousel_alunos = jQuery("#carousel_alunos");
	var matricula_prof = "MAT03122015211611";
	
	retorna_combo_turmas($turma,"TurmaProfessor/" + matricula_prof);
	
	$turma.change(function(){
		dados_aluno(matricula_prof,this.value);
		$carousel_alunos.html(dados_alunos_professor_turma);
	})
});

var dados_alunos_professor_turma = ""

function dados_aluno(professor, turma){
	var html = "";
	
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
				html+= '<li class="first"><a href="#"><p>QTD1</p><span>Atividades Realizadas</span></a></li>';
				html+= '<li><a href="#"><p>QTD2</p><span>Media</span></a></li>';
				html+= '<li class="last"><a href="#"><p>QTD3</p><span>Faltas</span></a></li>';
				html+= '</ul>';
				html+= '</div>';
				html+= '</div>';
				html+= '</div>';
			  }
			  
			  dados_alunos_professor_turma = html;
		  }
	})
}