<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div>
  <h2>Test Form Submission</h2>

  	<div>
  	Id <c:out value="${testPojo.id}"/>	</div>
  	
	<s:url value="${submission_url}" var="form_url" /> 
	
	<sf:form method="${restmethod}" 
	           action="${form_url}" 
	           modelAttribute="testPojo"> 
		
		Message: <sf:input path="message" size="15" /><br/>
		Opinion: <sf:input path="innerPojo.opinion" size="15" /><br/>
		Text: <sf:input path="innerPojo.text" size="15" /><br/>		
		
		<table>
		<c:forEach items="${testPojo.innerPojos}" var="item" varStatus="i">
			<tr><td>
				<input type="text" name="innerPojos[${i.index}].text" value="${item.text}" />
			</td><td>
				<input type="text" name="innerPojos[${i.index}].opinion" value="${item.opinion}" />	
			</td></tr>
			
		</c:forEach>
		</table>
		
		<input name="commit" type="submit" 
		                    value="Sumbit your Message" />
	</sf:form>
	<sf:form method="DELETE" 
             action="${form_url}" 
             modelAttribute="testPojo"> 
             <input name="commit" type="submit" 
                        value="Delete The Message" />
             </sf:form>
</div>
