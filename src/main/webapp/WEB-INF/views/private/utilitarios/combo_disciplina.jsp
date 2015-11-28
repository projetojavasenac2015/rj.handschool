<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script>
	jQuery(document).ready(function(){
		jQuery('#iddisciplina').chosen({ width: "100%" },{max_selected_options:20});
	})
</script>

<form:select path="listadisciplinas" name="iddisciplina" id="iddisciplina" multiple="true"  data-placeholder="Selecione a(s) Disicplina(s)">
	<form:options items="${listadisciplina}" itemValue="iddisciplina" itemLabel="nome"/>
</form:select>
<form:errors path="listadisciplinas"></form:errors>