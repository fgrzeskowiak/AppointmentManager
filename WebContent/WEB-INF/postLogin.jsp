<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Przekierowanie</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
  </head>
<body>
	<jsp:include page = "fragment/navbar.jspf" />
	
	<div class = "container">
	
		<div class = field>
		</div>
		<div class = "col col-md-4 col-md-offset-4">
			<div class="alert alert-success" role="alert"><Strong>Zalogowano pomyślnie</Strong></div>     	
     	</div>
        	
        <div class = "row">
			<div class = "col col-md-2 col-md-offset-5">
        	    <h3 class="centered"><a href="<c:out value="${pageContext.request.contextPath}" />"><c:out value="Strona główna" /></a></h3>     	
        	</div>
        </div>
	</div>
	
	<jsp:include page = "fragment/footer.jspf"/>
    
     
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.js"></script>
	
	

</body>
</html>