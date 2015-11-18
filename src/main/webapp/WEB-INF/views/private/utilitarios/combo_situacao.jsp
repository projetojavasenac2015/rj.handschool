<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:select path="ativo" name="ativo" id="ativo" class="select_styled select_styled_orange">
    <form:option  value="" label="Situação"/>
    <form:option value="1" label="Ativo"/>
	<form:option value="0" label="Inativo"/>
</form:select>
<form:errors path="ativo"></form:errors>