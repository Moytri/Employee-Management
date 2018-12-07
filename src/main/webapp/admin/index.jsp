<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Admin Page</title>
	
	<!-- Reference Bootstrap files -->	
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  
  	.fill { 
	    min-height: 100%;
	    height: 100%;
	}
	
  </style>	

</head>
<body>
	<div class="container-fluid fill" style="background-color:#f5f5f5;">
	  <div class="row">
	    <div class="col-sm-8">
		  <div class="row">
		    <div class="col-sm-12">
		    	<jsp:include page = "/employee/employees.jsp"></jsp:include>
			</div>
		  </div>	    
		  <div class="row">
		    <div class="col-sm-12">
		    	<jsp:include page="/employee/logout.jsp"></jsp:include>
			</div>
		  </div>	    	    	
		</div>
		
	    <div class="col-sm-4" style="background-color:white;">
		  <div class="row">
		    <div class="col-sm-12">		    	
		    	<c:if test="${message == null || message.code != 502}">
		    		<jsp:include page="/employee/addEmployees.jsp"></jsp:include>
		    	</c:if>
		    	<c:if test="${message.code == 502}">
		    		<jsp:include page="/error/error-502.jsp"></jsp:include>
		    	</c:if>
			</div>
		  </div>		  
		  <div class="row">
		    <div class="col-sm-12">
		    	<c:if test="${message == null || message.code != 801}">
		    		<jsp:include page="/employee/findEmployees.jsp"></jsp:include>
		    	</c:if>
		    	<c:if test="${message.code == 801}">
		    		<jsp:include page="/error/error-801.jsp"></jsp:include>
		    	</c:if>		    	
			</div>
		  </div>
		  <div class="row">
		    <div class="col-sm-12">
		    	<c:if test="${message == null || message.code != 902}">
		    		<jsp:include page="/employee/deleteEmployee.jsp"></jsp:include>
		    	</c:if>
		    	<c:if test="${message.code == 902}">
		    		<jsp:include page="/error/error-902.jsp"></jsp:include>
		    	</c:if>
			</div>
		  </div>		  		  	    	    	
	    </div>
	  </div>
	</div>
			   		 
</body>
</html>