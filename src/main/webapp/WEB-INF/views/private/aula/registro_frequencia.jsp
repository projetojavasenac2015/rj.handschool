<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<spring:url value="/resources/js/negocio/turmas.js" var="Turmas" />
<spring:url value="/resources/js/negocio/lancamento_presenca.js" var="LancamentoPresenca" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<script src="${Turmas}"></script> 
<script src="${LancamentoPresenca}"></script> 
<script>
	jQuery(document).ready(function(){
		jQuery('#idAula').chosen({ width: "100%" },{max_selected_options:1});
	})
</script>
</head>
<body>
	<c:set var="data_atual" value="<%=new java.util.Date()%>" />
	<div class="row">
		<div class="col-sm-12">
			<div class="add-comment add-comment-velvet styled" id="addcomments">
				<div class="add-comment-title"><h3>Registro de Frenquência <!-- <sup class="note_lado" title="Turmas Pendentes">3</sup> --></h3></div>
				<div class="comment-form">
					<form action="#" method="post" id="commentForm" class="ajax_form">
						<div class="form-inner">
							<div class="row">
								<div class="col-md-2">
									<div class="field_text">
							           	<label for="dataHoraCadastro" class="label_title">Data:</label>
							            <input type="text" name="dataHoraCadastro" id="dataHoraCadastro" value='<fmt:formatDate pattern="dd/MM/yyyy"  value="${data_atual}"/>' class="inputtext input_middle required" readOnly="readonly" />
							        </div>
							    </div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<div class="field_text">
	                           			<select name="turma" id="turma" class="select_styled select_styled_orange">
	                                        <option value="0">Selecione a  Turma</option>
	                                    </select>
		                           </div>
	                           	</div>
	                           	<div class="col-md-5">
									<div class="field_text">
	                           			<select name="iddisciplinas" id="iddisciplinas" class="select_styled select_styled_orange">
	                                        <option value="">Disciplina(s)</option>
	                                    </select>
		                           </div>
	                           	</div>
                           		<div class="col-md-2 col-md-offset-1">
									<div class="field_text">
	                           			<span class="btn btn-small">
						                   <input type="button" id="verificar_turma" value="Listar" />
						           		</span>
		                           </div>
	                           	</div>
							</div>
							<div class="row">
	                   			<div class="col-md-12">
			                   		<tiles:insertTemplate template="/WEB-INF/views/private/utilitarios/tabela_aluno_presenca.jsp"></tiles:insertTemplate>
					  			</div>
	                   		</div>
	                   	</div>
						<!-- <div class="clear"></div>
						<div class="row">
							<div class="col-sm-12">
								<div class="rowSubmit">
					   			 	<span class="btn btn-small">
					                   <input type="submit" id="confirmar" value="Confirmar" />
					           		</span>
					             </div>
							</div>
						</div>
						 -->
						<input type="hidden" value="${matriculaProfessor}" id="matriculaProfessor"/>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>