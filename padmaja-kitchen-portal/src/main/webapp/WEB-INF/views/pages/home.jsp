<%@ page isELIgnored="false"%>
<%@page
	import="javax.servlet.*,javax.servlet.http.*,java.sql.*,java.io.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>


<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%-- <title>Document Singing</title>
	<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link> --%>
</head>

</head>
<body>

	<%-- <h3>Document Singing</h3>


	<div class="form-container">
		<h1>Welcome to Document Singing</h1>
		
		Click on below links to see FileUpload in action.<br/><br/>
		
		<a href="${pageContext.request.contextPath}/singleUpload">Single File Upload</a>  OR  <a href="${pageContext.request.contextPath}/multiUpload">Multi File Upload</a>
	</div> --%>
	<!-- End main content area start-->
	<div class="maincontent-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="latest-product">
						<h2 class="section-title">Latest Video</h2>
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
	
	<div class="maincontent-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="latest-product">
						<h2 class="section-title">Top Video</h2>
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
									<h2><a href="single-product.jsp">${product.videoName}</a></h2>
								</div>
							</c:forEach>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- blog pages start --> 
        <!-- End main content area -->
            <div class="product-widget-area">
                <div class="zigzag-bottom"></div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="single-product-widget">
                                <h2 class="product-wid-title">Popular Recipe</h2>
                                <a href="${pageContext.request.contextPath}/detailList?id=popular" class="wid-view-more" target="_blank">View All</a>
                                <c:forEach var="img" items="${popularImageList}">
								    <%-- <img src="data:image/png;base64, ${img}"/> --%>
								    <div class="single-wid-product">
                                    <a href="single-product.jsp"><img src="data:image/png;base64, ${img.imageString}" alt="" class="product-thumb"></a>
                                    <h2><a href="single-product.jsp">${img.blogName}</a></h2>
                                    <div class="product-wid-rating">
                                        <span class="meta-part"><i
									class="ti-calendar"></i><a href="#"> ${img.crtDate}</a></span>
                                    </div>
                                    <div class="product-wid-price">
                                        <a href="${pageContext.request.contextPath}/detail?id=${img.id}" class="view-details-link" target="_blank"><i
												class="fa fa-link"></i> See details</a>
                                    </div>
                                </div>
							</c:forEach>
                           </div>
                        </div>
                        <div class="col-md-4">
                            <div class="single-product-widget">
                                <h2 class="product-wid-title">Recently Recipe</h2>
                                <a href="${pageContext.request.contextPath}/detailList?id=recently" class="wid-view-more" target="_blank">View All</a>
                                <c:forEach var="recentlyimg" items="${recentlyImageList}">
								    <%-- <img src="data:image/png;base64, ${img}"/> --%>
								    <div class="single-wid-product">
                                    <a href="single-product.jsp"><img src="data:image/png;base64, ${recentlyimg.imageString}" alt="" class="product-thumb"></a>
                                    <h2><a href="single-product.jsp">${recentlyimg.blogName}</a></h2>
                                    <div class="product-wid-rating">
                                        <span class="meta-part"><i
									class="ti-calendar"></i><a href="#"> ${recentlyimg.crtDate}</a></span>
                                    </div>
                                    <div class="product-wid-price">
                                        <a href="${pageContext.request.contextPath}/detail?id=${recentlyimg.id}" class="view-details-link" target="_blank"><i
												class="fa fa-link"></i> See details</a>
                                    </div>
                                </div>
							</c:forEach>
                           </div>
                        </div>
                        <div class="col-md-4">
                            <div class="single-product-widget">
                                <h2 class="product-wid-title">New Recipe</h2>
                                <a href="${pageContext.request.contextPath}/detailList?id=new" class="wid-view-more" target="_blank">View All</a>
                                <c:forEach var="newimg" items="${newImageList}">
								    <%-- <img src="data:image/png;base64, ${img}"/> --%>
								    <div class="single-wid-product">
                                    <a href="single-product.jsp"><img src="data:image/png;base64, ${newimg.imageString}" alt="" class="product-thumb"></a>
                                    <h2><a href="single-product.jsp">${newimg.blogName}</a></h2>
                                    <div class="product-wid-rating">
                                        <span class="meta-part"><i
									class="ti-calendar"></i><a href="#"> ${newimg.crtDate}</a></span>
                                    </div>
                                    <div class="product-wid-price">
                                        <a href="${pageContext.request.contextPath}/detail?id=${newimg.id}" class="view-details-link" target="_blank"><i
												class="fa fa-link"></i> See details</a>
                                    </div>
                                </div>
							</c:forEach>
                           </div>
                        </div>
                    </div>
                </div>
            </div>
 <!-- blog pages end --> 

</body>
</html>