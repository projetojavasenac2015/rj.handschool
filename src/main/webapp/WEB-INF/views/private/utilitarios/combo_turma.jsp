<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:select path="turma" name="idturma" id="idturma" class="select_styled">
    <form:option value="0" label="Turma(s)"></form:option>
    <form:options items="${listaturma}" itemValue="idturma" itemLabel="descricao"/>
</form:select>
<form:errors path="turma"></form:errors>