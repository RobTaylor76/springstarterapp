

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div>
  <h2>Test Pojos</h2>

    


    
    <table>
    <c:forEach items="${testPojos}" var="item" varStatus="i">
       <s:url value="/testpojo/${item.id}" var="pojo_url" />     
      <tr><td>
        ${item.name}
      </td><td>
        <a href="${pojo_url}">View</a>        
 
      </td></tr>
      
    </c:forEach>
    </table>
    
</div>
