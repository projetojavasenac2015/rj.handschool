<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<div class="row">
	<div class="col-md-10">
		<c:if test="${ not empty listaUltimosCursosCastrados}">
			<table class="table table-hover" id="tabela">
				<thead>
					<tr>
						<th class="text-nowrap">Curso</th>
						<th>Descrição</th>
						<th class="text-nowrap">Registro</th>
						<th>Editar</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach  items="${listaUltimosCursosCastrados}" var="cursos">
						<tr>
							<td>${cursos.nome}</td>
							<td>${cursos.descricao}</td>
							<td>${cursos.dataHoraCadastro}</td>
							<td><a class="glyphicon glyphicon-edit" href="${pageContext.request.contextPath}/DadosCurso/${cursos.idcurso}"></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</div>
