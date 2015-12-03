<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:select path="listaambiente" name="idambiente" id="idambiente" class="select_styled">
    <form:option value="0" label="Selecione o Ambiente"></form:option>
    <form:options items="${listaambiente}" itemValue="idambiente" itemLabel="nome"/>
</form:select>
<form:errors path="listaambiente"></form:errors>