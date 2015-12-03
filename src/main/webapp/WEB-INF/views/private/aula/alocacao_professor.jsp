<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<spring:url value="/resources/js/negocio/alocacao.js" var="alocacaoNegocio" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<script src="${alocacaoNegocio}"></script> 
</head>
<body>
	<c:set var="dataDia" value="<%=new java.util.Date()%>" />
	<fmt:formatDate pattern="dd/MM/yyyy" var="dataAtual"  value="${dataDia}"/>
	<div class="row">
		<div class="col-md-12">
			<div class="add-comment add-comment-velvet styled" id="addcomments">
				<div class="add-comment-title"><h3>Lançamento de Aulas</h3></div>
				<div class="comment-form">
					<form:form action="GravaAlocacao" method="post" commandName="alocacao" id="commentForm" class="ajax_form">
						<div class="form-inner">
							<div class="row">
								<div class="col-md-5">
									<div class="field_text">
										<label for="" class="label_title">Disciplina:</label>
										<div class="field_select">
		                           			<tiles:insertTemplate template="/WEB-INF/views/private/utilitarios/combo_disciplina_simples.jsp"></tiles:insertTemplate>
			                            </div>
							        </div>
	                           	</div>
	                           	<div class="col-md-2 col-md-offset-1">
									<label for="dataAula" class="label_title">Data Aula:</label>
						            <input type="text" name="dataAula" id="dataAula" value='${dataAtual}' class="inputtext input_middle required data"/>
						       	</div>
						       	<div class="col-md-2 col-md-offset-1">
									<span class="btn btn-small">
					                   <input type="button" id="verificar_aulas" value="Aulas Lançadas" />
					           		</span>
						       	</div>
	                        </div>
	                        <div class="row">
								<div class="col-md-12">
				                    <tiles:insertTemplate template="/WEB-INF/views/private/utilitarios/tabela_aulas_nao_alucadas.jsp"></tiles:insertTemplate>
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