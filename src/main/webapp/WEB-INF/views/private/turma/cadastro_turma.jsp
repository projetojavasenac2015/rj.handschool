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
				<div class="add-comment-title"><h3>Turma</h3></div>
				<div class="comment-form">
					<form:form commandName="turma" action="GravaTurma" method="post" id="commentForm" class="ajax_form">
						<div class="form-inner">
							<div class="row">
								<div class="col-md-5">
									<div class="field_text">
	                              		<label for="descricaoTurma" class="label_title">Turma:</label>
	                               		<form:input path="descricao" type="text" name="descricao" id="descricao" value="" readonly="true" class="inputtext input_middle required" />
	                           			<form:errors path="descricao"></form:errors>
	                           		</div>
	                        	</div>
	                        	<div class="col-md-2 col-md-offset-1">
	                            	<div class="field_select">
	                            		<label for="ano" class="label_title">Ano:</label>
										<form:select path="ano" name="ano" id="ano" class="select_styled">
	                                        <c:forEach begin="${ano_ini}" end="${ano_fim}" var="val">
                                         		<c:choose>
                                         	  		<c:when test="${val eq ano_ini}">
                                         	     		<form:option value="${val}" selected="true" label="${val}"/>
                                         	  		</c:when>
	                                         		<c:otherwise>
									                	<form:option value="${val}" label="${val}"/>
										            </c:otherwise>
										        </c:choose> 
	                                        </c:forEach>
	                                    </form:select>
	                                    <form:errors path="ano"></form:errors>
		                           </div>
	                        	</div>
                        	</div>
                        	<div class="row">
	                        	<div class="col-md-2">
	                        		<label for="quantidadeAlunos" class="label_title">Qtd Alunos:</label>
	                           		<div class="field_select">
	                           			<form:input path="quantidadeAlunos" type="text" name="quantidadeAlunos" id="quantidadeAlunos" value="" class="inputtext input_middle required" />
	                                    <form:errors path="quantidadeAlunos"></form:errors>
		                           </div>
	                           	</div>
	                           	<div class="col-md-2 col-md-offset-4">
									<div class="field_select">
	                           			<tiles:insertTemplate template="/WEB-INF/views/private/utilitarios/combo_situacao.jsp"></tiles:insertTemplate>
		                           </div>
		                       </div>
                           	</div>
                           	<div class="row">
								<div class="col-md-5">
									<label for="curso" class="label_title">Curso:</label>
									<div class="field_select">
										<tiles:insertTemplate template="/WEB-INF/views/private/utilitarios/combo_curso.jsp"></tiles:insertTemplate>
		                           </div>
		                       </div>
	                        </div>
	                        <div class="row">
								<div class="panel panel-primary boxed-velvet col-md-5" style="max-height:362.328px;">
                                   	 <!--
                                   	 <div class="panel-heading">
                                         <h4 class="panel-title" style="text-align: center">
                                         	Modulos Desse Curso
                                         </h4>
                                     </div>
                                      <div class="panel-body feed" style="overflow: auto;max-height: 200px">
                                         <div class="feed-item-body ">
                                             Modulo:<span>nome_curso</span>
                                             <br/>
                                             <ul>
                                             	<li>2</li>
                                             	<li>3</li>
	                                            <li>4</li> 	
                                             </ul>
                                         </div>
                                         <div class="divider"></div>
                                    </div>
                                     -->
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