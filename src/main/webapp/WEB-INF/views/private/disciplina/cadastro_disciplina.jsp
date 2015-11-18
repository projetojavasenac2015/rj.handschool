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
<title>Disciplina</title>
<script>
	jQuery(document).ready(function(){
		
	})
</script>
</head>
<body>
	<div class="row">
		<div class="col-md-12">
			<div class="add-comment add-comment-velvet styled" id="addcomments">
				<div class="add-comment-title"><h3>${rotulo} Disciplina</h3></div>
				<div class="comment-form">
					<form:form action="${pageContext.request.contextPath}/GravaDisciplina" method="post" id="commentForm" class="ajax_form" commandName="disciplina">
						<div class="form-inner">
							<div class="row">
								<div class="col-md-1" style="">
									<form:label path="">${menssagem}</form:label>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="field_text">
	                              		<label for="nome" class="label_title">Disciplina:</label>
	                               		<form:input type="text" path="nome" name="nome" id="nome" value="" class="inputtext input_middle required" />
	                               		<form:errors path="nome"></form:errors>
	                           		</div>
	                            	<div class="field_text">
	                               		<label for="ementa" class="label_title">Ementa:</label>
	                               		<div id="editar_ementa" class="edit_buttons"></div>
	                               		<form:textarea path="ementa" rows="50" cols="20" name="ementa" class="textarea textarea_middle" id="ementa"></form:textarea>
	                               		<form:errors path="ementa"></form:errors>
	                               	</div>
	                           </div>
								<div class="col-md-2">
									<div class="field_select">
	                           			<tiles:insertTemplate template="/WEB-INF/views/private/utilitarios/combo_situacao.jsp"></tiles:insertTemplate>
		                           </div>
		                       </div>
	                       </div>
	                   	</div>
						<div class="clear"></div>
						<div class="row">
							<div class="col-md-12">
								<div class="rowSubmit">
					   			 	<span class="btn btn-small">
					                   <input type="submit" id="confirmar" value="Confirmar" />
					           		</span>
					             </div>
							</div>
						</div>
						<form:input path="iddisciplina" type="hidden" name="iddisciplina"/>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>