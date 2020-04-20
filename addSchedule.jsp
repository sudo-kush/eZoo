	<!-- Header -->
	<jsp:include page="header.jsp" />
	
	<!-- JSTL includes -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
<!-- 	Just some stuff you need -->
	<header>
	  <div class="container">
	  
	<c:choose>
	<c:when test="${not empty message }">
	  <p class="alert ${messageClass}">${message }</p>
	<%
	  session.setAttribute("message", null);
	  session.setAttribute("messageClass", null);
	%>
	</c:when>
	</c:choose>
	
		<h1>eZoo <small>Create Schedule</small></h1>
		<hr class="paw-primary">
		
		<form action="addSchedule" method="post" class="form-horizontal">
		
		  <div class="form-group">
		    <label for="id" class="col-sm-4 control-label">Schedule ID</label>
		    <div class="col-sm-4">
		      <input type="number" class="form-control" id="id" name="id" placeholder="ID" required="required"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="name" class="col-sm-4 control-label">Feeding Time</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" id="name" name="name" placeholder="12:00" required="required"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="healthStatus" class="col-sm-4 control-label">Recurrence</label>
		    <div class="col-sm-4">
					<select required="required" name="healthStatus" class="form-control">
						<option value="Healthy">
							Daily
						</option>
						<option value="Sick">
							Every Other Day
						</option>
						<option value="Injured">
							Weekly
						</option>
						<option value="Dead">
							Monthly
						</option>
					</select>
				</div>
			</div>	
					  <div class="form-group">
		    <label for="id" class="col-sm-4 control-label">Food</label>
		    <div class="col-sm-4">
		      <input type="number" class="form-control" id="id" name="id" placeholder="Food" required="required"/>
		    </div>
		  </div>
		  		  <div class="form-group">
		    <label for="id" class="col-sm-4 control-label">Notes</label>
		    <div class="col-sm-4">
		      <input type="number" class="form-control" id="id" name="id" placeholder="Notes" required="required"/>
		    </div>
		  </div>

		  <div class="form-group">
		    <div class="col-sm-offset-4 col-sm-1">
		      <button type="submit" class="btn btn-primary">Add</button>
		    </div>
		  </div>
		</form>
	  </div>
	</header>


	<!-- Footer -->
	<jsp:include page="footer.jsp" />