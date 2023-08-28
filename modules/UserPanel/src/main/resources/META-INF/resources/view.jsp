<%@ include file="/init.jsp" %>

<div class="container-xl">
	<div class="table-responsive">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-5">
						<h2> <b>Usuarios</b></h2>
					</div>
					<div class="col-sm-7">
						<form action="<portlet:actionURL name='searchUsers' />" method="GET" cssClass="input-group">
						<div class="input-group">
							<input type="text" class="form-control" name="search" placeholder="Nome" aria-label="Pesquisar" aria-describedby="basic-addon2">
							<div class="input-group-append">
								<button class="btn btn-outline-secondary" type="button"  type="submit">Pesquisar</button>
							</div>
						</div>
						</form>
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
				<c:forEach items="${users}" var="users" varStatus="loop">
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
				<div class="hint-text">Showing <b>${users.size()}</b> out of <b>${users.size()}</b> entries</div>
				<ul class="pagination">
					<li class="page-item disabled"><a href="#">Previous</a></li>
					<li class="page-item active"><a href="#" class="page-link">1</a></li>
					<li class="page-item"><a href="#" class="page-link">Next</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>