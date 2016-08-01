<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:select path="listaprofessor" name="idpessoa" id="idpessoa" class="select_styled">
    <form:option value="0" label="Selecione o Professor"></form:option>
    <form:options items="${listaprofessor}" itemValue="idpessoa" itemLabel="nome"/>
</form:select>
<form:errors path="listaprofessor"></form:errors>