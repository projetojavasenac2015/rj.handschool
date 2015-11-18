<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<script>
	jQuery(document).ready(function(){
		jQuery('#iddisciplina').chosen({ width: "100%" },{max_selected_options:20});
	})
</script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<div class="add-comment add-comment-velvet styled" id="addcomments">
				<div class="add-comment-title"><h3>${rotulo} Modulo</h3></div>
				<div class="comment-form">
					<form:form commandName="modulo" action="#" method="post" id="commentForm" class="ajax_form">
						<div class="form-inner">
							<div class="row">
								<div class="col-md-5">
									<div class="field_text">
	                              		<label for="descricao" class="label_title">Modulo:</label>
	                               		<form:input path="descricao" type="text" name="descricao" id="descricao" value="" class="inputtext input_middle required" />
	                               		<form:errors path="descricao"></form:errors>
	                           		</div>
	                        	</div>
	                        	<div class="col-md-2">
									<div class="field_select">
	                           			<tiles:insertTemplate template="/WEB-INF/views/private/utilitarios/combo_situacao.jsp"></tiles:insertTemplate>
		                           </div>
		                       </div>
                        	</div>
							<div class="row">
								<div class="col-md-5">
									<label for="curso" class="label_title">Curso:</label>
									<div class="field_select">
										<form:select path="curso" name="idcurso" id="idcurso" class="select_styled">
	                                        <form:option value="" label="Selecione o Curso"></form:option>
	                                        <form:options items="${listacurso}" itemValue="idcurso" itemLabel="nome"/>
	                                    </form:select>
	                                    <form:errors path="curso"></form:errors>
		                           </div>
		                       </div>
	                       	</div>
	                       	<div class="row">
	                        	<div class="col-md-8">
	                        		<label for="disciplinas" class="label_title">Disciplinas:</label>
	                           		<div class="field_select">
	                           			<form:select path="disciplina" name="iddisciplina" id="iddisciplina" multiple="true"  data-placeholder="Selecione">
                                  			<form:options items="${listadisciplina}" itemValue="iddisciplina" itemLabel="nome"/>
	                                    </form:select>
	                                    <form:errors path="disciplina"></form:errors>
		                           </div>
	                           	</div>
	                        </div>
						</div>
						<div class="clear"></div>
						<div class="row">
							<div class="col-sm-12">
								<div class="rowSubmit">
					   			 	<span class="btn btn-small">
					                   <input type="submit" id="confirmar" value="Confirmar" />
					           		</span>
					             </div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>