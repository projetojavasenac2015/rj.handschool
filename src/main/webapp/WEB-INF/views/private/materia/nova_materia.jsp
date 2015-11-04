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
<title>Disciplina</title>
<script>
	jQuery(document).ready(function(){
		jQuery('#conteudo').chosen({ width: "100%" });
	})
</script>
</head>
<body>
	<div class="body_wrap">
		<div class="container">
			<div class="row">
				<div class="col-sm-5">
					<div class="add-comment add-comment-velvet styled" id="addcomments">
		            	<div class="add-comment-title"><h3>Nova Disciplina</h3></div>
		               	<div class="comment-form">
		                    <form action="#" method="post" id="commentForm" class="ajax_form">
		                         <div class="form-inner">
		                            <div class="field_text">
		                                <label for="contact_name" class="label_title">Disciplina:</label>
		                                <input type="text" name="disciplina" id="disciplina" value="" class="inputtext input_middle required" />
		                            </div>
	                             	<div class="field_select">
		                                <label for="conteudo" class="label_title">Conteúdo:</label>
		                                <select name="conteudo" id="conteudo" multiple data-placeholder="Adicione o Conteúdo">
                                            <option value='example1@gmail.com'>conteúdo</option>
                                        </select>
                                    </div>
		                            <div class="clear"></div>
		                        </div>
		                        <div class="rowSubmit">
		                            <span class="btn btn-small"><input type="submit" id="send" value="Confirmar" /></span>
		                        </div>
		                    </form>
		                </div>
		            </div>	
				</div>
			</div>
		</div>
	</div>
</body>
</html>