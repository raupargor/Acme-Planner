<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.task.list.label.title" path="title"/>
	<acme:form-double code="authenticated.task.list.label.workload" path="workload"/>
	<acme:form-textbox code="authenticated.task.list.label.description" path="description"/>
	<acme:form-url code="authenticated.task.list.label.link" path="link"/>
	
	<acme:form-submit code="authenticated.task.list.label.create" action="/manager/task/create"/>	
  	<acme:form-return code="authenticated.task.list.label.return"/>
  	
</acme:form>