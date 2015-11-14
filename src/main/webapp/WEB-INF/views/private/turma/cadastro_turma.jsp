<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<script>
	jQuery(document).ready(function(){
		jQuery('#quantidadeAlunos').chosen({ width: "100%" },{max_selected_options:1});
	})
</script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<div class="add-comment add-comment-velvet styled" id="addcomments">
				<div class="add-comment-title"><h3>Turma</h3></div>
				<div class="comment-form">
					<form action="#" method="post" id="commentForm" class="ajax_form">
						<div class="form-inner">
							<div class="row">
								<div class="col-md-5">
									<div class="field_text">
	                              		<label for="descricaoTurma" class="label_title">Turma:</label>
	                               		<input type="text" name="descricaoTurma" id="descricaoTurma" value="" class="inputtext input_middle required" />
	                           		</div>
	                        	</div>
	                        	<div class="col-md-2 col-md-offset-1">
	                            	<div class="field_select">
										<select name="ano" id="ano" class="select_styled">
	                                        <option value="">Ano</option>
	                                        <c:forEach begin="${ano_ini}" end="${ano_fim}" var="val">
	                                        	<option value="${val}"><c:out value="${val}"/></option>
	                                        </c:forEach>
	                                    </select>
		                           </div>
	                        	</div>
                        	</div>
                        	<div class="row">
	                        	<div class="col-md-3">
	                        		<label for="curso" class="label_title">Qtd:</label>
	                           		<div class="field_select">
	                           			<select name="quantidadeAlunos" id="quantidadeAlunos" multiple data-placeholder="Alunos">
	                                        <c:forEach begin="1" end="40" var="val">
	                                        	<option value="${val}"><c:out value="${val}"/></option>
	                                        </c:forEach>
	                                    </select>
		                           </div>
	                           	</div>
	                           	<div class="col-md-2 col-md-offset-3">
									<div class="field_select">
	                           			<select name="ativo" id="ativo" class="select_styled select_styled_orange">
	                                        <option value="">Situação</option>
	                                        <option value="1">Ativo</option>
	                                        <option value="0">Inativo</option>
	                                    </select>
		                           </div>
		                       </div>
                           	</div>
                           	<div class="row">
								<div class="col-md-5">
									<label for="curso" class="label_title">Curso:</label>
									<div class="field_select">
										<select name="curso" id="curso" class="select_styled">
	                                        <option value="">Selecione o Curso</option>
	                                        <option value="">1</option>
	                                        <option value="">2</option>
	                                    </select>
		                           </div>
		                       </div>
	                        </div>
	                        <div class="row">
								<div class="panel panel-primary boxed-velvet col-md-5" style="max-height:362.328px;">
                                   	 <div class="panel-heading">
                                         <h4 class="panel-title" style="text-align: center">
                                         	Modulos Desse Curso
                                         </h4>
                                     </div>
                                     <div class="panel-body feed" style="overflow: auto;max-height: 200px">
                                         <div class="feed-item-body ">
                                             teste
                                             teste
                                             teste
                                             teste
                                             tested
                                             asdasdas
                                             teste
                                             teste
                                             teste
                                             teste
                                             tested
                                             asdasdas
                                             teste
                                             teste
                                             teste
                                             teste
                                             tested
                                             asdasdas
                                         </div>
                                         <div class="divider"></div>
                                         <div class="feed-item-body">
	                                             teste
	                                             teste
	                                             teste
	                                             teste
	                                             tested
	                                             asdasdas
	                                             teste
	                                             teste
	                                             teste
	                                             teste
	                                             tested
	                                             asdasdas
	                                             teste
	                                             teste
	                                             teste
	                                             teste
	                                             tested
	                                             asdasdas
	                                         </div>
                                         <div class="divider"></div>
                                         <div class="feed-item-body">
	                                             teste
	                                             teste
	                                             teste
	                                             teste
	                                             tested
	                                             asdasdas
	                                             teste
	                                             teste
	                                             teste
	                                             teste
	                                             tested
	                                             asdasdas
	                                             teste
	                                             teste
	                                             teste
	                                             teste
	                                             tested
	                                             asdasdas
	                                         </div>
	                                         <div class="divider"></div>
                                         <div class="feed-item-body">
	                                             teste
	                                             teste
	                                             teste
	                                             teste
	                                             tested
	                                             asdasdas
	                                             teste
	                                             teste
	                                             teste
	                                             teste
	                                             tested
	                                             asdasdas
	                                             teste
	                                             teste
	                                             teste
	                                             teste
	                                             tested
	                                             asdasdas
	                                         </div>
	                                         <div class="divider"></div>
                                         <div class="feed-item-body">
	                                             teste
	                                             teste
	                                             teste
	                                             teste
	                                             tested
	                                             asdasdas
	                                             teste
	                                             teste
	                                             teste
	                                             teste
	                                             tested
	                                             asdasdas
	                                             teste
	                                             teste
	                                             teste
	                                             teste
	                                             tested
	                                             asdasdas
	                                         </div>
	                                         <div class="divider"></div>
                                         <div class="feed-item-body">
	                                             teste
	                                             teste
	                                             teste
	                                             teste
	                                             tested
	                                             asdasdas
	                                             teste
	                                             teste
	                                             teste
	                                             teste
	                                             tested
	                                             asdasdas
	                                             teste
	                                             teste
	                                             teste
	                                             teste
	                                             tested
	                                             asdasdas
	                                         </div>
	                                         <div class="divider"></div>
                                         <div class="feed-item-body">
	                                             teste
	                                             teste
	                                             teste
	                                             teste
	                                             tested
	                                             asdasdas
	                                             teste
	                                             teste
	                                             teste
	                                             teste
	                                             tested
	                                             asdasdas
	                                             teste
	                                             teste
	                                             teste
	                                             teste
	                                             tested
	                                             asdasdas
	                                         </div>
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
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>