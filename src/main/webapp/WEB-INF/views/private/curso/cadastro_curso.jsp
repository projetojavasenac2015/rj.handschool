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
		
	})
</script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<div class="add-comment add-comment-velvet styled" id="addcomments">
				<div class="add-comment-title"><h3>Novo Curso</h3></div>
				<div class="comment-form">
					<form action="GravaCurso" method="post" id="commentForm" class="ajax_form">
						<div class="form-inner">
							<div class="col-sm-6">
								<div class="field_text">
                              		<label for="nome" class="label_title">Curso:</label>
                               		<input type="text" name="nome" id="nome" value="${nome}" class="inputtext input_middle required" />
                           		</div>
                            	<div class="field_text">
                               		<label for="descricao" class="label_title">Descrição:</label>
<<<<<<< HEAD
                               		<textarea rows="20" cols="60" name="descricao" value="${descricao}" class="textarea input_middle" id="descricao"></textarea>
                           		</div>
=======
                               		<textarea rows="20" cols="20" name="descricao" value="${descricao}" class="inputtext input_middle" id="descricao"></textarea>
                           		</div>
                           		<div class="field_text">
                               		<label for="ementa" class="label_title">Ementa:</label>
                               		<div id="editar_ementa" class="edit_buttons"></div>
                               		<textarea rows="50" cols="20" name="ementa" value="${ementa}" class="textarea textarea_middle" id="ementa"></textarea>
                               	</div>
>>>>>>> master
                           </div>
							<div class="col-sm-2">
								<div class="field_select">
                           			<select name="ativo" id="ativo" class="select_styled select_styled_orange">
                                        <option value="">Situação</option>
                                        <option value="1">Ativo</option>
                                        <option value="0">Inativo</option>
                                    </select>
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