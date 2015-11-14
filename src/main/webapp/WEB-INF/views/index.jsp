<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="author" content="HandSchool">
<meta name="keywords" content="">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>
	<tiles:getAsString name="title"></tiles:getAsString> HandSchool
</title>
<spring:url value="resources/js/libs/jquery-1.10.0.min.js" var="jquerymin" />
<spring:url value="resources/js/libs/jquery-ui.min.js" var="jquery-ui" />
<spring:url value="resources/js/libs/bootstrap.min.js" var="bootstrap" />
<spring:url value="resources/js/general.js" var="general" />
<spring:url value="resources/js/cusel-min.js" var="cusel" />
<spring:url value="resources/js/jquery.chosen.min.js" var="jselec" />
<spring:url value="resources/js/jquery.maskedinput.js" var="jsmacara" />
<spring:url value="resources/js/custom.js" var="customizado" />
<spring:url value="resources/js/jquery-ui.min.js" var="jUi" />
<spring:url value="resources/js/jquery-ui.multidatespicker.js" var="dataPicker" />
<spring:url value="resources/css/jquery-ui-1.8.20.custom.css" var="cssJquery" />
<spring:url value="resources/css/bootstrap.css" var="cssBoot" />
<spring:url value="resources/css/cusel.css" var="cssCusel" />
<spring:url value="resources/css/personalizado.css" var="persona" />
<spring:url value="resources/css/chosen.css" var="cssCombo" />
<spring:url value="resources/css/jquery-ui.min.css" var="jCui" />

<script src="${jquerymin}"></script>
<script src="${jquery-ui}"></script>
<script src="${bootstrap}"></script>
<script src="${general}"></script>
<script src="${cusel}"></script>
<script src="${jselec}"></script>
<script src="${jsmacara}"></script>
<script src="${customizado}"></script>
<script src="${jUi}"></script>
<script src="${dataPicker}"></script>
<link href="${cssJquery}" rel="stylesheet">
<link href="${cssBoot}" rel="stylesheet">
<link href="${cssCusel}" rel="stylesheet">
<link href="${persona}" rel="stylesheet">
<link href="${cssCombo}" rel="stylesheet">
<link href="${jCui}" rel="stylesheet">
</head>
<body>
	<div class="body_wrap" id="principal">
		<div class="container" >
			<div class="content" role="main">
                <div class="row">
                    <div class="col-sm-3">
                        <h2 class="foo"><a haref="/">HAND SCHOOL</a></h2>
                    </div>
                    <div class="col-sm-9">
                        <div class="widget-container widget_search boxed-velvet">
                            <div class="inner">
                                <form method="get" id="" action="#">
                                    <div class="clearfix">
                                        <span class="btn btn-small">
                                            <input type="submit" id="searchsubmit2" value="Pesquisar" />
                                        </span>
                                        <div class="input_wrap">
                                            <span class="input_icon"></span>
                                            <input class="inputField" name="search3" type="text" placeHolder="Digite a palavra chave" />
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
		 	<div class="divider"></div>
		 	<div class="">
		 		<div class="row">
                    <div class="col-sm-10">
                        <div class="dropdown-wrap boxed-velvet" style="margin-bottom:20px;">
                             <ul class="dropdown inner clearfix">
                                <li><a href="#"><span class="glyphicon glyphicon-home">&nbsp;Home</span></a></li>
                                <li><a href="#"><span class="glyphicon glyphicon-wrench">&nbsp;Gerenciador</span></a>
                                    <ul>
                                        <li><a href="#">Aluno</a>
                                        	<ul>
                                        		<li><a href="CadastroALuno">Novo</a></li>
                                        		<li><a href="CadastroALuno">Listar Alunos</a></li>
                                        	</ul>
                                        </li>
                                        <li><a href="#">Professor</a></li>
                                        <li><a href="#">Curso</a>
                                        	<ul>
		                                        <li><a href="NovoCurso">Novo</a></li>
		                                        <li><a href="CadastramentoTurma">Listar Cursos</a></li>
		                                    </ul>
                                        </li>
                                        <li><a href="#">Disciplinas</a>
                                        	<ul>
		                                        <li><a href="NovaDisciplina">Nova</a></li>
		                                        <li><a href="CadastramentoTurma">Listar Disciplinas</a></li>
		                                    </ul>
                                        </li>
                                        <li><a href="#">Turma</a>
                                        	<ul>
		                                        <li><a href="NovaTurma">Nova</a></li>
		                                        <li><a href="CadastramentoTurma">Listar as turmas</a></li>
		                                    </ul>
                                        </li>
                                        <li><a href="#">Modulo</a>
                                        	<ul>
		                                        <li><a href="NovoModulo">Novo Modulo</a></li>
		                                    </ul>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="#"><span class="glyphicon glyphicon-book">&nbsp;Aulas</span></a>
                               	 	<ul>
                                   		<li><a href="Atividades">Agenda de Atividades</a></li>
                                   	</ul>
                                </li>
                                <li><a href="#"><span class="glyphicon glyphicon-calendar">&nbsp;Frequencia</span></a>
                                   	<ul>
                                    	<li><a href="RegistroFrequencia">Consulta</a></li>
                                    	<li><a href="RegistroFrequencia">Lançamento</a></li>
                                    </ul>
                                </li>
                                <li><a href="#"><span class="glyphicon glyphicon-edit">&nbsp;Avaliações</span></a>
                                	<ul>
                                    	<li><a href="AgendarAvaliacao">Agendar Avaliação</a></li>
                                    	<li><a href="LancamentoNotas">Lançamento de Notas</a></li>
                                    	<li><a href="AlterarAvaliacoes">Alterar Avaliações</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-sm-2 tagcloud margin-10">
                        <a href="#" class="tag-link-1" title="2 topics" hidefocus="true" style=""><span>Solicitações</span></a>
                    </div>
                </div>
            </div>
            
            <tiles:insertAttribute name="body"></tiles:insertAttribute>
		</div>
	</div>
</body>
</html>