<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:select path="tipoAvaliacao" name="tipoAvaliacao" id="tipoAvaliacao" class="select_styled select_styled_orange">
    <form:option value="0" label="Selecione o Tipo de Avaliação"></form:option>
    <form:options items="${listaTipoAvaliacao}" itemValue="idtipoAvaliacao" itemLabel="descricao"/>
</form:select>
<form:errors path="tipoAvaliacao"></form:errors>