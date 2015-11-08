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
		jQuery('#idAula').chosen({ width: "100%" },{max_selected_options:1});
	})
</script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<div class="add-comment add-comment-velvet styled" id="addcomments">
				<div class="add-comment-title"><h3>Registro de Frenquência</h3></div>
				<div class="comment-form">
					<form action="#" method="post" id="commentForm" class="ajax_form">
						<div class="form-inner">
							<div class="row">
								<div class="col-md-4">
									<div class="field_text">
	                           			<select name="turma" id="turma" class="select_styled select_styled_orange">
	                                        <option value="">Turma</option>
	                                    </select>
		                           </div>
	                           	</div>
	                           	<div class="col-md-5">
									<div class="field_text">
	                           			<select name="disciplina" id="disciplina" class="select_styled select_styled_orange">
	                                        <option value="">Disciplina</option>
	                                    </select>
		                           </div>
	                           	</div>
                           		<div class="col-md-2 col-md-offset-1">
									<div class="field_text">
							           	<label for="dataHoraCadastro" class="label_title">Data:</label>
							            <input type="text" name="dataHoraCadastro" id="dataHoraCadastro" value="" class="inputtext input_middle required data" />
							        </div>
							    </div>
							</div>
							<div class="row">
								<div class="col-md-5">
									<div class="field_select">
										<select name="idAula" id="idAula" multiple data-placeholder="Aulas">
	                                        <option value="">Aula</option>
	                                    </select>
		                           </div>
	                           	</div>
							</div>
							<div class="row">
	                   			<div class="col-md-12">
			                   		<table class="table table-hover">
									    <thead>
									      <tr>
									        <th>Aluno</th>
									        <th>Presença Aula X</th>
									        <th>Observação</th>
									      </tr>
									    </thead>
									    <tbody>
									      <tr>
									        <td>John</td>
									        <td>Doe</td>
									        <td>john@example.com</td>
									        <td>
								            </td>
									      </tr>
									   	</tbody>
									  </table>
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