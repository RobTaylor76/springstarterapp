<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div>
  <h2>Test Form Submission</h2>
  <div>
  	Output was <c:out value="${testPojo.message}"/></div>
  	<div>
  	Name was <c:out value="${testPojo.name}"/>	</div>
  	
	<s:url value="/test" var="submission_url" /> 
	
	<sf:form method="POST" 
	           action="${submission_url}" 
	           modelAttribute="testPojo"> 
		
		Message: <sf:input path="message" size="15" /><br/>
		Opinion: <sf:input path="innerPojo.opinion" size="15" /><br/>	
		
		<input name="commit" type="submit" 
		                    value="Sumbit your Message" />
	</sf:form>
</div>
