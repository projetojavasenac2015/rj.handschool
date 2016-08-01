<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:select path="listaperfil" name="idperfil" id="idperfil" class="select_styled select_styled_orange">
    <form:option value="0" label="Selecione o Perfil"></form:option>
    <form:options items="${listaperfil}" itemValue="id" itemLabel="descricao"/>
</form:select>
<form:errors path="listaperfil"></form:errors>