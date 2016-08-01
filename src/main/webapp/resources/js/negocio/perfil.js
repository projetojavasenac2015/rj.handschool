jQuery(document).ready(function(){
	var idprofessor = jQuery("#idpessoa");
	var idperfil = jQuery("#idperfil");
	
	jQuery("#add_perfil").click(function(){
		
		if(idprofessor.val() != 0 && idperfil.val() != 0){
			incluirPerfil(idprofessor.val(),idperfil.val())
		}
		else{
			alert('Informe o Professor e o Perfil')
		}
	})
	
	
});

function incluirPerfil(id_prof, id_perf){
	var html = "";
	
	jQuery.ajax({
		  method: "POST",
		  url: "GravarPerfil/"+ id_prof +"/"+ id_perf,
		  success:function(data){
			 alert('Perfil adicionado com sucesso')
		  },
		  error:function(e){
			  alert(e.message)
		  }
	})
}
