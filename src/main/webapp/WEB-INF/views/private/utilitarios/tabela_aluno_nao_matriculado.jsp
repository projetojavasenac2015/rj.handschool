<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table" id="tableAlunoMatriculado">
    <thead>
      <tr>
        <th class="text-justify">Matricula</th>
        <th class="text-justify">Aluno</th>
        <th class="text-nowrap">Data Nascimento</th>
        <th class="text-nowrap">Ação</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${listaAlunoNaoMatriculado}" var="alunos">
    		<tr>
    			<td>${alunos.matricula}</td>
    			<td>${alunos.nome}</td>
    			<td>${alunos.dataNascimento}</td>
    			<td><input type="checkbox" name="alunos_matriculando" onclick="retornaDadosAlunos('${alunos.matricula}','${alunos.nome}', this)"></td>
    		</tr>
    	</c:forEach>
   	</tbody>
  </table>