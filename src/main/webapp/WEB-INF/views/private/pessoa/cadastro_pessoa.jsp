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
		<div class="col-md-3">
			<div class="field_text">
           		<label for="cpf" class="label_title">CPF:</label>
           		<input type="text" name="cpf" id="cpf" value="" class="inputtext input_middle required cpf" />
       		</div>
		</div>
		<div class="col-md-3 col-md-offset-2">
			<div class="field_text">
           		<label for="rg" class="label_title">RG:</label>
           		<input type="text" name="rg" id="rg" value="" class="inputtext input_middle required rg" />
       		</div>
		</div>
		<div class="col-md-2 col-md-offset-2">
			<div class="avatar"><img src="<c:url value="../src/main/webapp/resources/images/temp/user.jpg"/>" alt="" /></div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<div class="field_text">
           		<label for="nome" class="label_title">Nome:</label>
           		<input type="text" name="nome" id="nome" value="" class="inputtext input_middle required" />
       		</div>
		</div>
		<div class="col-md-2 col-md-offset-1">
			<div class="field_text">
	           	<label for="data_nascimento" class="label_title">Nascimento:</label>
	            <input type="text" name="data_nascimento" id="data_nascimento" value="" class="inputtext input_middle required data" />
	        </div>
	    </div>
	</div>
	<div class="row">
		<div class="col-md-5">
			<div class="field_text">
           		<label for="rg" class="label_title">Pai:</label>
            	<input type="text" name="pai" id="pai" value="" class="inputtext input_middle required" />
       		</div>
       	</div>	
       	<div class="col-md-5 col-md-offset-2">	
            <div class="field_text">
             	<label for="mae" class="label_title">Mãe:</label>
                <input type="text" name="mae" id="mae" value="" class="inputtext input_middle required" />
            </div>
        </div>    		
    </div>
</body>
</html>