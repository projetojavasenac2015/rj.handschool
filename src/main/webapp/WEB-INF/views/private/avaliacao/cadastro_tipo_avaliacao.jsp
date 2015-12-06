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
				<div class="add-comment-title"><h3>${rotulo} Tipo de Avaliação</h3></div>
				<div class="comment-form">
					<form:form action="${pageContext.request.contextPath}/GravaTipoAvaliacao" method="post" id="commentForm"  commandName="tipoAvaliacao" class="ajax_form">
						<div class="form-inner">
							<div class="row">
								<div class="col-sm-4">
									<div class="field_text">
										<label for="nome" class="label_title">Tipo de Avaliação:</label>
	                               		<form:input path="descricao" type="text" name="descricao" id="descricao" value="" class="inputtext input_middle required"/>
	                               		<form:errors path="descricao"></form:errors>
	                               	</div>
	                           </div>
	                          	<div class="col-sm-2">
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
									<div class="col-md-12">
						   			 	<span class="btn btn-small">
						                   <input type="submit" id="confirmar" value="Confirmar" />
						           		</span>
					           		</div>
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