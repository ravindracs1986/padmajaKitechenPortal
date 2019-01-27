<%@ page isELIgnored="false"%>
<%@page
	import="javax.servlet.*,javax.servlet.http.*,java.sql.*,java.io.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>

</head>
<body>
<!-- End main content area start-->
	<div class="maincontent-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="latest-product">
						<h2 class="section-title">Non-Veg Racipe</h2>
						<div class="product-carousel">

							<c:forEach var="product" items="${videoList}" varStatus="i">
								<%-- ${product}<br> --%>
								<div class="single-product">
									<div class="product-f-image">
										<iframe width="560" height="315"
											src="https://www.youtube.com/embed/${product.youtubeId}"
											frameborder="0"
											allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
											allowfullscreen></iframe>

										<div class="product-hover">
											<!-- <a href="#" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> Add to cart</a>-->
											<a href="https://youtu.be/${product.youtubeId}"
												class="view-details-link" target="_blank"><i
												class="fa fa-link"></i> See details</a>
										</div>
									</div>

									<h2>
										<a href="single-product.jsp">${product.videoName}</a>
									</h2>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End main content area -->
</body>
</html>