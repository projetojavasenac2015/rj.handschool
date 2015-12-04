<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="author" content="HandSchool">
<meta name="keywords" content="">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title><tiles:getAsString name="title"/></title>
<spring:url value="resources/js/libs/jquery-1.10.0.min.js" var="jquerymin" />
<spring:url value="resources/js/libs/jquery-ui.min.js" var="jquery-ui" />
<spring:url value="resources/js/libs/bootstrap.min.js" var="bootstrap" />
<spring:url value="resources/css/jquery-ui-1.8.20.custom.css" var="cssJquery" />
<spring:url value="resources/css/bootstrap.css" var="cssBoot" />
<spring:url value="resources/css/personalizado.css" var="persona" />

<script src="${jquerymin}"></script>
<script src="${jquery-ui}"></script>
<script src="${bootstrap}"></script>
<link href="${cssBoot}" rel="stylesheet">
<link href="${persona}" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row" style="margin-top:115px">
			<div class="col-md-5 col-md-offset-3">
   				<span class="btn btn-right btn-acute"><h1 class="foo">HAND SCHOOL</h1></span>
   				<br/>
   				<div class="add-comment add-comment-velvet styled" id="login" style="margin-top:25px">
					<div class="add-comment-title"><h3>Login</h3></div>
					<div class="comment-form">
   						<form:form action="j_spring_security_check" commandName="login" method="post" id="login_forme" class="ajax_form">
							<div class="form-inner">
							    <div class="field_text">
							        <label for="usuario" class="label_title">E-mail:</label>
							        <input type="text" name="email" id="email" value="" placeholder="e-mail@handschool.com" class="inputtext input_middle required" />
							    </div>
							    <div class="field_text">
							        <label for="subject" class="label_title">Senha:</label>
							        <input type="password" name="senha" id="senha" value="" placeholder="" class="inputtext input_middle required" />
							    </div>
   								<div class="clear"></div>
							</div>
							<div class="rowSubmit">
							    <span class="btn btn-small"><input type="submit" id="logar" value="Entrar" /></span>
							</div>
						</form:form>
       				</div>
   				</div>
   			</div>  
		</div>
	</div>
</body>
</html>