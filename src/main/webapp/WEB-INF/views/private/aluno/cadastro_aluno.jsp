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
		<div class="col-md-12">
			<div class="add-comment add-comment-velvet styled" id="addcomments">
				<div class="add-comment-title"><h3>Aluno</h3></div>
				<div class="comment-form">
					<form action="#" method="post" id="commentForm" class="ajax_form">
						<div class="form-inner">
							<tiles:insertTemplate template="/WEB-INF/views/private/pessoa/cadastro_pessoa.jsp"></tiles:insertTemplate>
							<div class="row">
								<div class="col-md-5">
									<div class="field_text">
	                           			<select name="turma" id="turma" class="select_styled select_styled_orange">
	                                        <option value="">Turmas</option>
	                                    </select>
		                           </div>
	                           	</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<div class="field_text">
	                              		<label for="matricula" class="label_title">Matricula:</label>
	                               		<input type="text" name="matricula" id="matricula" value="" disabled="disabled" class="inputtext input_middle required" />
	                           		</div>
	                           	</div>
								<div class="col-md-2">
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
									<div class="field_text">
	                              		<label for="email" class="label_title">E-mail:</label>
                              		 	<input type="text" name="email" id="email" value="" class="inputtext input_middle required" />
                              		</div>
	                           	</div>
	                           	<div class="col-md-2 col-md-offset-2">
									<div class="field_text">
	                              		<label for="senha" class="label_title">Senha:</label>
	                               		<input type="text" name="senha" id="senha" value="" class="inputtext input_middle required" />
	                           		</div>
	                           	</div>
                           	</div>
                   		</div>
						<div class="clear"></div>
						<div class="row">
							<div class="col-md-12">
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