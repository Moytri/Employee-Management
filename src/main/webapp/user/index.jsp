<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		
	    <div class="col-sm-4" style="background-color:#f5f5f5; padding-top: 20px;">		  
		  <div class="row">
		    <div class="col-sm-12">
		    	<c:if test="${message == null || message.code != 801}">
		    		<jsp:include page="/employee/findEmployees.jsp"></jsp:include>
		    	</c:if>
		    	<c:if test="${message.code == 801}">
		    		<jsp:include page="/error/error-801.jsp"></jsp:include>
		    	</c:if>		    
		    	<%-- <jsp:include page="/employee/findEmployees.jsp"></jsp:include> --%>
			</div>
		  </div>		  		  	    	    	
	    </div>
	    
	  </div>
	</div>
</body>
</html>