<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<spring:url value="/resources/js/negocio/turmas.js" var="turmasNegocio" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<script src="${turmasNegocio}"></script> 
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<div class="add-comment add-comment-velvet styled" id="addcomments">
				<div class="add-comment-title"><h3>Turma</h3></div>
				<div class="comment-form">
					<form:form commandName="turma" action="GravaTurma" method="post" id="commentForm" class="ajax_form">
						<div class="form-inner">
							<div class="row">
								<div class="col-md-5">
									<label for="curso" class="label_title">Curso:</label>
									<div class="field_select">
										<tiles:insertTemplate template="/WEB-INF/views/private/utilitarios/combo_curso.jsp"></tiles:insertTemplate>
		                           </div>
		                       </div>
	                        </div>
							<div class="row">
								<div class="col-md-8">
									<label for="curso" class="label_title">Turma:</label>
									<tiles:insertTemplate template="/WEB-INF/views/private/utilitarios/tabela_turmas_ativas.jsp"></tiles:insertTemplate>
	                        	</div>
	                        </div>
                           	<div class="row">
	                        	<div class="col-md-8">
	                        		<label for="disciplinas" class="label_title">Aluno(s):</label>
	                           		<div class="field_select">
	                           			
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
						<form:hidden path="idturma"/>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>