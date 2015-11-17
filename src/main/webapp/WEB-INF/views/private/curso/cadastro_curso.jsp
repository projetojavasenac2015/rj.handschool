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
		
	})
</script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<div class="add-comment add-comment-velvet styled" id="addcomments">
				<div class="add-comment-title"><h3>${rotulo} Curso</h3></div>
				<div class="comment-form">
					<form:form action="${pageContext.request.contextPath}/GravaCurso" method="post" id="commentForm"  commandName="curso" class="ajax_form">
						<div class="form-inner">
							<div class="row">
								<div class="col-sm-6">
									<div class="field_text">
										<label for="nome" class="label_title">Curso:</label>
	                               		<form:input path="nome" type="text" name="nome" id="nome" value="" class="inputtext input_middle required"/>
	                               		<form:errors path="nome"></form:errors>
	                               	</div>
	                            	<div class="field_text">
	                               		<label for="descricao" class="label_title">Descrição:</label>
	                   					<form:textarea path="descricao" rows="20" cols="60" name="descricao" class="textarea input_middle" id="descricao"></form:textarea>
	                   					<form:errors path="descricao"></form:errors>
	                           		</div>
	                       		</div>
	                          	<div class="col-sm-2">
									<div class="field_select">
	                           			<form:select path="ativo" name="ativo" id="ativo" class="select_styled select_styled_orange">
	                                        <form:option  value="" label="Situação"/>
	                                        <form:option value="1" label="Ativo"/>
	                                    	<form:option value="0" label="Inativo"/>
	                                    </form:select>
	                                    <form:errors path="ativo"></form:errors>
		                           </div>
		                       </div>
	                       		<tiles:insertTemplate template="/WEB-INF/views/private/curso/ultimos_cursos_cadastrados.jsp"></tiles:insertTemplate>
	                       </div>
	                   	</div>
	                   	<div class="clear"></div>
						<div class="row">
							<div class="col-md-12">
								<div class="rowSubmit">
									<div class="col-sm-6">
										<a href="NovoCurso" class=""><span class="btn btn-small">Voltar</span></a>
									</div>
									<div class="col-sm-6">
						   			 	<span class="btn btn-small">
						                   <input type="submit" id="confirmar" value="Confirmar" />
						           		</span>
					           		</div>
				             	</div>
							</div>
						</div>
						<form:input path="idcurso" type="hidden" name="idcurso"/>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>