<%@ page isELIgnored="false"%>
<%@page import="javax.servlet.*,javax.servlet.http.*,java.sql.*,java.io.*"%>
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
						<h2 class="section-title navbar-collapse collapse">Latest Video</h2>
						<div class="product-carousel">
							<c:forEach var="product" items="${videoList}" varStatus="i">
								<div class="single-product">
									<div class="product-f-image">
										<div class="video-container">
										<iframe width="560" height="315"
											src="https://www.youtube.com/embed/${product.youtubeId}"
											frameborder="0"
											allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
											allowfullscreen></iframe>
											<div class="product-hover">
												<a href="https://youtu.be/${product.youtubeId}" class="view-details-link" target="_blank"><i class=""></i> See details</a>
										  </div>
										</div>
									</div>

									<h2>
										${product.videoName}
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
	
	<div class="maincontent-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="latest-product">
						<h2 class="section-title">Top Video</h2>
						<div class="product-carousel">
						  <c:forEach var="product" items="${topvideoList}" varStatus="i">
								<div class="single-product">
									<div class="product-f-image">
									<div class="video-container">
										<iframe width="560" height="315"
											src="https://www.youtube.com/embed/${product.youtubeId}"
											frameborder="0"
											allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
											allowfullscreen></iframe>
											<div class="product-hover">
												<a href="https://youtu.be/${product.youtubeId}"
													class="view-details-link" target="_blank"><i
													class="fa fa-link"></i> See details</a>
											</div>
										</div>
									</div>
									<h2>${product.videoName}</h2>
								</div>
							</c:forEach>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</body>
</html>