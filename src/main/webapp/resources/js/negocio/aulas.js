jQuery(document).ready(function(){
	jQuery("#tabela_horario").append(quadro_horarios_disponiveis());
	   
	var $horario_ini = jQuery("#horaInicio");
	var $horario_fim = jQuery("#horaFim");
	var $totalHoras = jQuery("#total_horas");
	var $verificarHorarios = jQuery("#verificar_horarios");
	var $data = jQuery("#dataAula");
	var $disciplina = jQuery("#iddisciplina");
	
	
    jQuery(document).on("click",".btn-follow",function(){
		var hora = jQuery(this).text();
				
		if($horario_ini.val() == ""){
			
			$horario_ini.val(hora);
		}
		else{
			$horario_fim.val(hora)
		}
		
		var valor_fim = $horario_fim.val();
		var valor_ini = $horario_ini.val();
		if( valor_fim != ""){
			if(parseInt(valor_ini) > parseInt(valor_fim)){
				alert('Horario inferior ao INICIO da aula');
				$horario_fim.val("");
			}
			if(parseInt(valor_ini) ==parseInt(valor_fim)){
				alert('Horario precisa ser diferente');
				$horario_fim.val("");
			}
		}
		
		var total = (valor_ini != "" && valor_fim !="") ? parseInt(valor_fim) - parseInt(valor_ini): "";
		
		$totalHoras.val(total);
	})
	
	jQuery(document).on("click","#limpar_dados_horario",function(){
		$horario_ini.val('');
		$horario_fim.val('');
	});
    
    $verificarHorarios.click(function(){
    	
    })
    
});

function quadro_horarios_disponiveis(){
	var html = '';
	var montagem = "";
	var j = 0;
	   
	for(var i = 1 ; i <= 7; i++){
	   if( i == 1){
			j = 8;
	   }
	   
	   html += '<tr class="tr_horario">';
	   for(var l = 0; l <=1 ; l++){
			aux = "";
			if( l == 0){
				aux = j;
			}
			else{
			    aux = j + 1;
			}
			html += '<td><a href="javascript:void(0)" class="btn btn-follow" style="margin-left:10px;margin-bottom:10px"><span>'+ (aux < 10 ? "0" + aux : aux) +':00</span></a></td>';
	   }
	   j = j + 2;

	   html += '</tr>';
   }
	
	html +="<tr><td colspan='2' style='text_align:center'><span class='btn btn-small' id='limpar_dados_horario'>Limpar</span><td></tr>";
	
	return html;
}

function verificar_horarios(){
	if($data.val() != "" && $disciplina.val() != "0"){
		
	}
	else{
		alert('Data Ou Disciplina nao informados');
	}
}
