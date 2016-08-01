<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table" id="">
    <thead>
      <tr>
        <th class="text-justify">Professor</th>
        <th class="text-nowrap">Perfil</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${listaPerfilPessoa}" var="perfis">
    		<tr>
    			<td>${perfis.idPessoa.nome}</td>
    			<td>${perfis.idPerfil.descricao}</td>
    		</tr>
    	</c:forEach>
   	</tbody>
  </table>