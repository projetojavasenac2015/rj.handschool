<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<spring:url value="/resources/js/negocio/turmas.js" var="Turmas" />
<spring:url value="/resources/js/negocio/professor.js" var="Professor" />
<spring:url value="/resources/js/negocio/avaliacao.js" var="Avaliacao" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="${Turmas}"></script> 
<script src="${Professor}"></script> 
<script src="${Avaliacao}"></script> 
<title></title>
<script>
jQuery(document).ready(function ($) {

	var daysRange = 5;

    function assignCalendar(id) {
        $('<div class="calendar" />')
                .insertAfter($(id))
                .multiDatesPicker({
                    dateFormat: 'yy-mm-dd',
                    minDate: new Date(),
                    maxDate: '+1y',
                    altField: id,
                    firstDay: 1,
                    showOtherMonths: true
                }).prev().hide();
    }

    assignCalendar('#date_departure');
});
</script>
</head>
<body>
	<div class="row">
        <div class="col-sm-4">
            <div class="widget-container widget_profile boxed-velvet" >
                <div class="inner">
                    <div class="widget_profile_top clearfix">
                        <div class="avatar"><img src="images/temp/avatar.png" alt="" /></div>
                        <h5>${nome_professor}</h5>
                        <BR/>
                        <span class="subtitle">PROFESSOR</span>
                        <div class="follow">
                            <a href="#" class="btn btn-follow"><span>Informações</span></a>
                        </div>
                    </div>
                    <ul class="counters clearfix">
                        <li class="first"><a href="#"><p>0</p><span>Quantidades de Turmas</span></a></li>
                        <li><a href="#"><p>0</p><span>Indice de Aprovação do Professor</span></a></li>
                        <li class="last"><a href="#"><p>0</p><span>Indice de Aprovação de Turma</span></a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-sm-8">
            <div class="tabs_framed styled">
                <div class="inner">
                    <ul class="tabs clearfix active_bookmark1">
                        <li class="active">
                            <a href="#events" data-toggle="tab">
                                <sup class="note">${qtdaulasProfessor}</sup>Aulas
                            </a>
                        </li>
                        <li>
                            <a href="#turmas" data-toggle="tab">Turmas</a>
                        </li>
                        <li><a href="#avaliacoes" data-toggle="tab">Quadro de Avaliações</a></li>
                        <li><a href="#notificacoes" data-toggle="tab">Painel de Notificações</a></li>
                    </ul>

                    <div class="tab-content clearfix">
                        <div class="tab-pane clearfix fade in active" id="events">
                            <div class="widget-container widget_calendar boxed-velvet col-sm-6 col-sm-offset-0">
                                <div class="inner">
                                    <input type="text" name="date_departure" class="inputField" id="date_departure">
                                </div>
                            </div>
                            <div class="panel panel-primary boxed-velvet col-sm-5 col-sm-offset-1" style="min-height:262.328px;max-height:262.328px;overflow: auto">
                                <div class="panel-heading">
                                    <h3 class="panel-title">
                                    <i class="fa fa-rss">Aulas do dia</i></h3>
                                </div>
                                <div class="panel-body feed">
                                    <div class="feed-item-body" style="overflow: auto">
                                        <c:forEach var="aulas" items="${aulasProfessor}">
										   Aula:
										   <fmt:formatDate value="${aulas.dataAula}" pattern="dd/MM/yyyy" var="data"/> 
										   <c:out value='${data}'/>
										   <br>
										   <br>
										   Horário(s):
										   <br>
										   <br> 
										   <c:out value="${aulas.horaInicio}"/>/<c:out value="${aulas.horaFim}"/>
										   <br>
										   <br>
										   Ambiente:
										   <br>
										   <br>
										   
										   <c:out value="${aulas.listaambiente.descricao}"/>
										   <div class="divider"></div>
										   <br>
										</c:forEach>
                                    </div>
                                    
                                </div>
                                <!-- <a href="#" class="btn btn-rigth btn-acute" style="z-index:0"><span>Adicionar Atividade</span></a> -->
                            </div>
                        </div>
                        <div class="tab-pane clearfix fade" id="turmas">
                            <div class="row" style="margin-left:12px;margin-right:12px">
                                <div class="col-ms-12">
                                    <div class="field_select">
                                        <select name="turma" id="turma" class="select_styled select_styled_orange">
	                                        <option value="0">Selecione a Turma</option>
	                                    </select>
                                    </div>
                                </div>
                                <div class="col-ms-4">
                                    <div class="widget-container widget_gallery boxed boxed-cream">
                                         <div class="inner">
                                            <div id="alunos_listados" class="carousel slide" data-interval="20000">
                                                <div class="carousel-inner" id="carousel_alunos">
                                                    
                                                </div>
                                                <a class="carousel-control left" href="#alunos_listados" data-slide="prev"></a>
                                                <a class="carousel-control right" href="#alunos_listados" data-slide="next"></a>
                                            </div>
                                         </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane clearfix fade" id="avaliacoes">
                          	<tiles:insertTemplate template="/WEB-INF/views/private/utilitarios/tabela_quadro_avaliacao.jsp"></tiles:insertTemplate>
                        </div>
                        <div class="tab-pane clearfix fade" id="notificacoes">
                         dasd
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <input type="hidden" value="${matriculaProfessor}" id="matriculaProfessor"/>
</body>
</html>