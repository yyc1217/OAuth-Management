<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-md-8">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">
					<c:choose>
						<c:when test="${not empty clientList}">應用服務列表</c:when>
						<c:otherwise>您尚未註冊任何應用服務</c:otherwise>
					</c:choose>
				</h3>
				<div class="box-tools">
					<div class="input-group">
						<div class="input-group-btn">
							<a href="<c:url value="/developer/client/create"/>"><button
									class="btn btn-sm btn-default pull-right">
									<i class="fa fa-plus">註冊新應用服務</i>
								</button></a>
						</div>
					</div>
				</div>
			</div>
			<%-- /.box-header --%>
			<div class="box-body">
				<c:if test="${not empty clientList}">
					<table class="table table-hover">
						<tr>
							<th>名稱</th>
						</tr>
						<c:forEach var="client" items="${clientList}">
							<tr>
								<td>
									<a href="<c:url value="/developer/client/detail/${client.id}"/>">
										${client.name}
									</a>
									<c:if test="${isInBlacklist}">
										<span class='badge bg-red'>黑名單</span>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
			<%-- /.box-body --%>
		</div>
		<%-- /.box --%>
	</div>
</div>