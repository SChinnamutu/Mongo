<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>





<body>




<div style="margin: 100px 30%;">

		
<h2> Student Registration</h2>
		<form action="save" method="post">
			<table>
				<tr>
					<td><label for="name">Id</label> </td><td><input type="text" name="id" id="id"/></td>
				</tr>
				
				<tr>
					<td><label for="name">Name</label></td>
					<td><input type="text" id="name" name="name"/></td>
				</tr>
				
				<tr>
					<td><label for="name">Age</label></td>
					<td><input type="text" id="age" name="age"/></td>
				</tr>
				
				<tr>
					<td><label for="name">Address</label></td>
					<td><input type="text" id="address" name="address"/></td>
				</tr>
				
				
				<tr style="color: blue;">
					<td><input type="submit" value="Save"/></td>
				</tr>
				
			</table>
		</form>


<h2>View Student Details</h2>

		<table border="1">
		
		<c:if test="${not empty studentList}">
			<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Age</th>
						<th>Address</th>
						<th>Action</th>
					</tr>
			</thead>
			
			<tbody>
				
					<c:forEach var="student" items="${studentList}">
						<tr>
							<td>${student.id}</td>
							<td>${student.name}</td>
							<td>${student.age}</td>
							<td>${student.address}</td>
							<td>
								<input type="button" value="Delete" onclick="window.location='deleteDetails?id=${student.id}'"/>
							<%-- 	<input type="button" value="Edit" onclick="setDetails(${student.id},${student.name},${student.age},${student.address})"/> --%>
							</td>	
						</tr>
					</c:forEach>		
			</tbody>
			</c:if>
		</table>	
			
</div>

</body>
</html>