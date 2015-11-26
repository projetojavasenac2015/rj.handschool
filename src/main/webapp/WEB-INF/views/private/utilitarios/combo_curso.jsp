<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:select path="curso" name="idcurso" id="idcurso" class="select_styled">
    <form:option value="0" label="Selecione o Curso"></form:option>
    <form:options items="${listacurso}" itemValue="idcurso" itemLabel="nome"/>
</form:select>
<form:errors path="curso"></form:errors>