<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<spring:url value="/resources/js/negocio/perfil.js" var="PerfilPessoa" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="${PerfilPessoa}"></script> 
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
				<div class="add-comment-title"><h3>Adicionar Perfil</h3></div>
				<div class="comment-form">
					<form:form action="GravarPerfil" method="post" id="commentForm" class="ajax_form" modelAttribute="perfilPessoa">
						<div class="form-inner">
							<div class="row">
								<div class="col-md-5">
									<label for="" class="label_title">Professor(es):</label>
									<div class="field_select">
	                           			<tiles:insertTemplate template="/WEB-INF/views/private/utilitarios/combo_professor.jsp"></tiles:insertTemplate>
		                            </div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-5">
									<label for="" class="label_title">Perfil(s):</label>
									<div class="field_select">
	                           			<tiles:insertTemplate template="/WEB-INF/views/private/utilitarios/combo_perfil.jsp"></tiles:insertTemplate>
		                            </div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-2 col-md-offset-3">
									<span class="btn btn-small">
					                   <input type="button" id="add_perfil" value="Aplicar Perfil" />
					           		</span>
						       	</div>
							</div>
	                   	</div>
	                   	<div class="clear"></div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>