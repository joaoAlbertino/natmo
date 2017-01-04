<%@ page import="natmo2.Teste" %>



<div class="fieldcontain ${hasErrors(bean: testeInstance, field: 'latitude', 'error')} required">
	<label for="latitude">
		<g:message code="teste.latitude.label" default="Latitude" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="latitude" value="${fieldValue(bean: testeInstance, field: 'latitude')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: testeInstance, field: 'longitude', 'error')} required">
	<label for="longitude">
		<g:message code="teste.longitude.label" default="Longitude" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="longitude" value="${fieldValue(bean: testeInstance, field: 'longitude')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: testeInstance, field: 'p', 'error')} required">
	<label for="p">
		<g:message code="teste.p.label" default="P" />
		<span class="required-indicator">*</span>
	</label>
	
</div>

