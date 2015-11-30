jQuery(document).ready(function(){
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
		$totalHoras.val('');
	});
    
    $verificarHorarios.click(function(){
    	
    })
    
    $disciplina.change(function(){
    	if(this.value !=0 && $data.val() != ''){
    		var data_convertida = formata_data_banco($data.val())
    		var horarios = horarios_disponiveis_ala_disciplina(this.value, data_convertida);
    		var horarios_separados_vetor = horarios_separados(horarios)
    		
    		jQuery("#tabela_horario").append(quadro_horarios_disponiveis(horarios_separados_vetor));
    	}
    })
});

function quadro_horarios_disponiveis(horarios){
	var html = '';
	var montagem = "";
	var j = 0;
	   
	for(var i = 1 ; i <= 7; i++){
	   if( i == 1){
			j = 8;
	   }
	   var flag = false;
	   
	   for(var r = 0 ; r < horarios.length; r++){
		   if(j == horarios[r]){
			   flag = true;
			   break;
		   }
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

function horarios_disponiveis_ala_disciplina(disciplina, data){
	var replace_Data = data.replace("'","").replace("'","")
	var url = "VerificaHorarioDisponivelAula/" + "2015-11-02" + "/" + 1
	
	var horarios = [];
	
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
				  horarios.push(data[i])
			  }
		  },
		  error:function(){
			  alert('Erro')
		  }
	})
	
	return horarios;
}

function formata_data_banco(data){
	var dados = "" + data;
	dados = dados.split("/");
	var data_banco_dados = "";
	
	data_banco_dados = "'"+ dados[2] + "-" +  dados[1] + "-" + dados[0] + "'";
	
	return data_banco_dados;
}

function horarios_separados(hora){
	var horarios = [];
	
	var horarios_separados = "";
	
	for(var h = 0 ; h < hora.length;h++){
		var aux = "" + hora[h];
		if(aux != undefined){
			horarios_separados = aux.split('-')
			if(horarios_separados != undefined){
				valor_ini = horarios_separados[0];
				valor_fim = horarios_separados[1];
				var diferenca_hora = parseInt(valor_fim) - parseInt(valor_ini)
				horarios.push(valor_ini)
				for(var o = 0; o <=diferenca_hora; o++){
					horarios.push(o + 1)
				}
				horarios.push(valor_fim)
			}
		}
	}
	return horarios;
}
