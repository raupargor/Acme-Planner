<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
	<acme:form-textbox code="manager.task.form.label.title" path="title"/>
	<acme:form-double code="manager.task.form.label.workload" path="workload"/>
	<acme:form-textbox code="manager.task.form.label.description" path="description"/>
	<acme:form-url code="manager.task.form.label.link" path="link"/>
	
	<jstl:if test="${!readonly}">
		<acme:form-submit code="manager.task.form.button.create" action="/manager/task/create"/>	
  	</jstl:if>
  	<acme:form-return code="manager.task.form.button.return"/>
</acme:form>