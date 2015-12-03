<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<spring:url value="/resources/js/negocio/aulas.js" var="aulasNegocio" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<script src="${aulasNegocio}"></script> 
</head>
<body>
	<c:set var="dataDia" value="<%=new java.util.Date()%>" />
	<fmt:formatDate pattern="dd/MM/yyyy" var="dataAtual"  value="${dataDia}"/>
	<div class="row">
		<div class="col-md-12">
			<div class="add-comment add-comment-velvet styled" id="addcomments">
				<div class="add-comment-title"><h3>Lançamento de Aulas</h3></div>
				<div class="comment-form">
					<form:form action="GravaAula" method="post" commandName="aula" id="commentForm" class="ajax_form">
						<div class="form-inner">
							<div class="row">
								<div class="col-md-2">
									<div class="field_text">
							           	<label for="dataAula" class="label_title">Data Aula:</label>
							            <form:input path="dataAula" type="text" name="dataAula" id="dataAula" value='${dataAtual}' class="inputtext input_middle required data"/>
							        	<form:errors path="dataAula"></form:errors>
							        </div>
	                           	</div>
	                           	<div class="col-md-5 col-md-offset-1">
									<label for="" class="label_title">Disciplina:</label>
									<div class="field_select">
	                           			<tiles:insertTemplate template="/WEB-INF/views/private/utilitarios/combo_disciplina_simples.jsp"></tiles:insertTemplate>
		                            </div>
	                           	</div>
	                        </div>
	                        <div class="row">
	                        	<div class="col-md-5">
									<label for="" class="label_title">Ambiente:</label>
									<div class="field_select">
	                           			<tiles:insertTemplate template="/WEB-INF/views/private/utilitarios/combo_ambiente.jsp"></tiles:insertTemplate>
		                            </div>
	                           	</div>
	                        </div>
							<div class="row">
								<div class="col-md-4">
				                    <div class="widget-container widget_profile boxed-velvet">
				                        <div class="inner">
				                            <div class="widget_profile_top clearfix">
				                            	<div class="follow">
													<table id="tabela_horario">
													</table>
												</div>
				                            </div>
				                        </div>
				                    </div>
				                </div>
	                   			<div class="col-md-2 col-md-offset-1">
									<div class="field_text">
							           	<label for="horarios" class="label_title">Horário:</label>
							            <form:input path="horaInicio" type="text" name="horaInicio" id="horaInicio" value='' class="inputtext input_middle required" readonly="true"/>
							        	<form:errors path="horaInicio"></form:errors>
							        </div>
							    </div>
							    <div class="col-md-2">
							    	<div class="field_text">
							           	<form:input path="horaFim" type="text" name="horaFim" id="horaFim" value='' class="inputtext input_middle required" readonly="true"/>
							        	<form:errors path="horaFim"></form:errors>
							        </div>
							    </div>
							    <div class="col-md-2">
							    	<div class="field_text">
						    			<input type="text" name="" id="total_horas" class="inputtext input_middle required" readonly>
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