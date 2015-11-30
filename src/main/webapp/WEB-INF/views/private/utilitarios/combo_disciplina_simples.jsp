<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:select path="listadisciplinas" name="iddisciplina" id="iddisciplina" class="select_styled" multiple="false">
    <form:option value="0" label="Selecione a Disciplina"></form:option>
    <form:options items="${listadisciplina}" itemValue="iddisciplina" itemLabel="nome"/>
</form:select>
<form:errors path="listadisciplinas"></form:errors>