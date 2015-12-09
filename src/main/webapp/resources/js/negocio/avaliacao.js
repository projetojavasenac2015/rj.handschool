jQuery(document).ready(function($){
	var $disciplina = jQuery("#iddisciplinas");
	var $turma = jQuery("#turma"); 
	
	retorna_combo_turmas($turma,"TurmaProfessor/MAT03122015211611");
	
	$turma.change(function(){
		retorna_combo_disciplinas_turma($disciplina,"DisciplinasTurma/" + this.value)
	})
	
	$disciplina.change(function(){
		if(this.value != 0){
			retorna_datas($turma.val(), this.value);
			jQuery(".calendar").remove();
			calendario("#data_aulas");
		}
	})
	
	jQuery(document).on('click','', function(){
		
	})
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
var dados_data_aula = "";

function retorna_datas(idturma,iddisciplina){
	
	jQuery.ajax({
		  method: "GET",
		  url: "AulasDisciplinas/"+ idturma +"/" + iddisciplina ,
		  dataType: 'json', 
		  contentType: 'application/json',
		  mimeType: 'application/json',
		  async:false,
		  success:function(data){
			  var qtd = data.length;
			  dados_data_aula = data;
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

