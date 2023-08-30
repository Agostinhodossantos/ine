<%@ include file="/init.jsp" %>

<div class="container-xl">
	<div class="table-responsive">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-5">
						<h2> <b>Resultado</b></h2>
					</div>
					<div class="col-sm-7">


					</div>
				</div>
			</div>
			<table class="table table-striped table-hover">
				<thead>
				<tr>
					<th>#</th>
					<th>Nome</th>
					<th>Email</th>
					<th>Cargo</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${searchUsers}" var="users" varStatus="loop">
					<tr>
						<td>${loop.index + 1}</td>
						<td>
							<a href="<portlet:actionURL name='viewBook'>
								<portlet:param name='bookId' value='${users.userId}' />
								</portlet:actionURL>">${users.firstName} ${users.lastName}
							</a>
						</td>
						<td>${users.emailAddress}</td>
						<td>${users.jobTitle}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<div class="clearfix">
				<div class="hint-text">Showing <b>${searchUsers.size()}</b> out of <b>${searchUsers.size()}</b> entries</div>
				<ul class="pagination">
					<li class="page-item disabled"><a href="#">Previous</a></li>
					<li class="page-item active"><a href="#" class="page-link">1</a></li>
					<li class="page-item"><a href="#" class="page-link">Next</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>