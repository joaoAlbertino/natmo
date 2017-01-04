
<%@ page import="natmo2.Teste" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'teste.label', default: 'Teste')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-teste" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-teste" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="latitude" title="${message(code: 'teste.latitude.label', default: 'Latitude')}" />
					
						<g:sortableColumn property="longitude" title="${message(code: 'teste.longitude.label', default: 'Longitude')}" />
					
						<g:sortableColumn property="p" title="${message(code: 'teste.p.label', default: 'P')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${testeInstanceList}" status="i" var="testeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${testeInstance.id}">${fieldValue(bean: testeInstance, field: "latitude")}</g:link></td>
					
						<td>${fieldValue(bean: testeInstance, field: "longitude")}</td>
					
						<td>${fieldValue(bean: testeInstance, field: "ponto")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${testeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
