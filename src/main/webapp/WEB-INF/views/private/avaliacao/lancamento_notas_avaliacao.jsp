<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<spring:url value="/resources/js/negocio/turmas.js" var="Turmas" />
<spring:url value="/resources/js/negocio/avaliacao.js" var="Avaliacao" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<script src="${Turmas}"></script> 
<script src="${Avaliacao}"></script> 
<script>
	jQuery(document).ready(function(){
		
		
	})
</script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<div class="add-comment add-comment-velvet styled" id="addcomments">
				<div class="add-comment-title"><h3>Lançamento de Notas(Avaliação)</h3></div>
				<div class="comment-form">
					<form:form action="#" commandName="avaliacaoaluno" method="post" id="commentForm" class="ajax_form">
						<div class="form-inner">
							<div class="row">
								<div class="col-md-4">
									<div class="row">
										<div class="col-md-9">
											<select name="turma" id="turma" class="select_styled select_styled_orange">
		                                        <option value="0">Selecione a  Turma</option>
		                                    </select>
										</div>
									</div>
									<br/>
									<div class="row">
										<div class="col-md-9">
											<select name="iddisciplinas" id="iddisciplinas" class="select_styled select_styled_orange">
		                                        <option value="">Disciplina(s)</option>
		                                    </select>
				                        </div>
									</div>
									<br/>
									<div class="row">
										<div class="col-md-9">
		                               		<select name="datas_todas_aula" id="datas_todas_aula" class="select_styled select_styled_orange">
		                                        <option value="0">Data(s)</option>
		                                    </select>
		                               	</div>
									</div>
									<br/>
									<div class="row">
										<div class="col-md-9">
											<select name="horarios" id="horarios" class="select_styled select_styled_orange">
		                                        <option value="">Horário(s)</option>
		                                    </select>
		                                    <input type="hidden" id="idaulas"/>
		                               	</div>
									</div>
									<br/>
									<div class="row">
										<div class="col-md-9">
		                               		<tiles:insertTemplate template="/WEB-INF/views/private/utilitarios/combo_tipo_avaliacao.jsp"></tiles:insertTemplate>
		                               	</div>
									</div>
									<br/>
									<div class="row">
										<div class="col-md-12">
		                               		 <a href="#" class="btn" id="verificar_aulas"><span>Verificar</span></a>
		                               	</div>
									</div>
	                           	</div>
	                           	<div class="col-md-6">
									<div class="row">
										<div class="widget-container widget_calendar boxed-velvet col-md-10" style="min-width: 550px; min-height:300px;max-height:300px;overflow: auto">
											<tiles:insertTemplate template="/WEB-INF/views/private/utilitarios/tabela_aluno_nao_avaliado.jsp"></tiles:insertTemplate>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- <div class="clear"></div>
						<div class="row">
							<div class="col-sm-12">
								<div class="rowSubmit">
					   			 	<span class="btn btn-small">
					                   <input type="button" id="confirmar_avaliacao" value="Confirmar" />
					           		</span>
					             </div>
							</div>
						</div>
						 -->
						<input type="hidden" value="${matriculaProfessor}" id="matriculaProfessor"/>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>