<%@ page isELIgnored="false"%>
<%@page
	import="javax.servlet.*,javax.servlet.http.*,java.sql.*,java.io.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <!-- Custom CSS -->
	  <link rel="stylesheet" href="assets/css/main.css">
</head>
<body>
<!-- End main content area -->
	
	<!-- End mainmenu area -->
			 <section class="job-browse section">
                <div class="container">
                    <div class="row">
						<div class="col-md-9 col-sm-8">
						<c:forEach var="img" items="${imageDetailList}">
						
                            <div class="job-list">
                                <div class="thumb">
                                    <img src="data:image/png;base64, ${img.imageString}" alt="" class="product-thumb">
                                </div>
                                <div class="job-list-content">
                                    <h4>We need a web designer</h4>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Illum quaerat aut veniam molestiae atque dolorum omnis temporibus consequuntur saepe. Nemo atque consectetur saepe corporis odit in dicta reprehenderit, officiis, praesentium?</p>
                                    <div class="job-tag">
                                        <div class="pull-left">
                                            <div class="meta-tag">
                                                <span><a href="browsecategories.do"><i class="ti-brush"></i>Art/Design</a></span> 
                                                <span><i class="ti-location-pin"></i>Cupertino, CA, USA</span> 
                                                <span><i class="ti-time"></i>60/Hour</span>
                                            </div>
                                        </div>
                                        <div class="pull-right">
                                            <!-- <div class="btn btn-common btn-rm">More Detail</div> -->
                                            <a href="${pageContext.request.contextPath}/detail?id=${img.id}" class="btn btn-common btn-rm"" target="_blank"><i
												class="fa fa-link"></i> See details</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                           </c:forEach>
                            

                            <ul class="pagination">
                                <li class="active"><a href="#" class="btn btn-common"><i class="ti-angle-left"></i> prev</a></li>
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                                <li class="active"><a href="#" class="btn btn-common">Next<i class="ti-angle-right"></i></a></li>
                            </ul>

                        </div>
                        
                        <div class="col-md-3 col-sm-4">
                            <aside>
                                <div class="sidebar">
                                    <div class="inner-box">
                                        <h3>Categories</h3>
                                        <ul class="cat-list">
                                            <li><a href="#">Finance <span class="num-posts">4,287
										Jobs</span></a></li>
                                            <li><a href="#">Techonologies <span class="num-posts">4,256
										Jobs</span></a></li>
                                            <li><a href="#">Art/Design<span class="num-posts">3,245
										Jobs</span></a></li>
                                            <li><a href="#">Science <span class="num-posts">4,256
										Jobs</span></a></li>
                                            <li><a href="#">Education Training <span
									class="num-posts">4,560 Jobs</span></a></li>
                                            <li><a href="#">Logistics <span class="num-posts">3,256
										Jobs</span></a></li>
                                            <li><a href="#">Food Services <span class="num-posts">1,256
										Jobs</span></a></li>
                                        </ul>
                                    </div>
                                   
                                </div>
                            </aside>
                        </div>
                    </div>
                </div>
            </section>

            <!-- End main content area -->
	
        
       <!-- blog pages start --> 
        <!-- End main content area -->
            <div class="product-widget-area">
                <div class="zigzag-bottom"></div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="single-product-widget">
                                <h2 class="product-wid-title">Popular Recipe</h2>
                                <a href="" class="wid-view-more">View All</a>
                                <div class="single-wid-product">
                                    <a href="single-product.jsp"><img src="assets/img/product-thumb-1.jpg" alt="" class="product-thumb"></a>
                                    <h2><a href="single-product.jsp">Sony Smart TV - 2015</a></h2>
                                    <div class="product-wid-rating">
                                        <span class="meta-part"><i
									class="ti-calendar"></i><a href="#"> Date:20.02.2018</a></span>
                                    </div>
                                    <div class="product-wid-price">
                                        <a href="https://youtu.be/${product.youtube_id}" class="view-details-link" target="_blank"><i
												class="fa fa-link"></i> See details</a>
                                    </div>
                                </div>
                                <div class="single-wid-product">
                                    <a href="single-product.jsp"><img src="assets/img/product-thumb-2.jpg" alt="" class="product-thumb"></a>
                                    <h2><a href="single-product.jsp">Apple new mac book 2015</a></h2>
                                    <div class="product-wid-rating">
                                        <span class="meta-part"><i
									class="ti-calendar"></i><a href="#"> Date:20.02.2018</a></span>
                                    </div>
                                    <div class="product-wid-price">
                                        <a href="https://youtu.be/${product.youtube_id}" class="view-details-link" target="_blank"><i
												class="fa fa-link"></i> See details</a>
                                    </div>
                                </div>
                                <div class="single-wid-product">
                                    <a href="single-product.jsp"><img src="assets/img/product-thumb-3.jpg" alt="" class="product-thumb"></a>
                                    <h2><a href="single-product.jsp">Apple new i phone 6</a></h2>
                                    <div class="product-wid-rating">
                                        <span class="meta-part"><i
									class="ti-calendar"></i><a href="#"> Date:20.02.2018</a></span>
                                    </div>
                                    <div class="product-wid-price">
                                        <a href="https://youtu.be/${product.youtube_id}" class="view-details-link" target="_blank"><i
												class="fa fa-link"></i> See details</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="single-product-widget">
                                <h2 class="product-wid-title">Recently Recipe</h2>
                                <a href="#" class="wid-view-more">View All</a>
                                <div class="single-wid-product">
                                    <a href="single-product.jsp"><img src="assets/img/product-thumb-4.jpg" alt="" class="product-thumb"></a>
                                    <h2>
								<a href="single-product.jsp">Sony playstation microsoft</a>
							</h2>
                                    <div class="product-wid-rating">
                                        <span class="meta-part"><i
									class="ti-calendar"></i><a href="#"> Date:20.02.2018</a></span>
                                    </div>
                                    <div class="product-wid-price">
                                        <a href="https://youtu.be/${product.youtube_id}" class="view-details-link" target="_blank"><i
												class="fa fa-link"></i> See details</a>
                                    </div>
                                </div>
                                <div class="single-wid-product">
                                    <a href="single-product.jsp"><img src="assets/img/product-thumb-1.jpg" alt="" class="product-thumb"></a>
                                    <h2>
								<a href="single-product.jsp">Sony Smart Air Condtion</a>
							</h2>
                                    <div class="product-wid-rating">
                                        <span class="meta-part"><i
									class="ti-calendar"></i><a href="#"> Date:20.02.2018</a></span>
                                    </div>
                                    <div class="product-wid-price">
                                        <a href="https://youtu.be/${product.youtube_id}" class="view-details-link" target="_blank"><i
												class="fa fa-link"></i> See details</a>
                                    </div>
                                </div>
                                <div class="single-wid-product">
                                    <a href="single-product.jsp"><img src="assets/img/product-thumb-2.jpg" alt="" class="product-thumb"></a>
                                    <h2>
								<a href="single-product.jsp">Samsung gallaxy note 4</a>
							</h2>
                                    <div class="product-wid-rating">
                                        <span class="meta-part"><i
									class="ti-calendar"></i><a href="#"> Date:20.02.2018</a></span>
                                    </div>
                                    <div class="product-wid-price">
                                        <a href="https://youtu.be/${product.youtube_id}" class="view-details-link" target="_blank"><i
												class="fa fa-link"></i> See details</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="single-product-widget">
                                <h2 class="product-wid-title">New Recipe</h2>
                                <a href="#" class="wid-view-more">View All</a>
                                <div class="single-wid-product">
                                    <a href="single-product.jsp"><img src="assets/img/product-thumb-3.jpg" alt="" class="product-thumb"></a>
                                    <h2>
								<a href="single-product.jsp">Apple new i phone 6</a>
							</h2>
                                    <div class="product-wid-rating">
                                        <span class="meta-part"><i
									class="ti-calendar"></i><a href="#"> Date:20.02.2018</a></span>
                                    </div>
                                    <div class="product-wid-price">
                                        <a href="https://youtu.be/${product.youtube_id}" class="view-details-link" target="_blank"><i
												class="fa fa-link"></i> See details</a>
                                    </div>
                                </div>
                                <div class="single-wid-product">
                                    <a href="single-product.jsp"><img src="assets/img/product-thumb-4.jpg" alt="" class="product-thumb"></a>
                                    <h2>
								<a href="single-product.html">Samsung gallaxy note 4</a>
							</h2>
                                    <div class="product-wid-rating">
                                        <span class="meta-part"><i
									class="ti-calendar"></i><a href="#"> Date:20.02.2018</a></span>
                                    </div>
                                    <div class="product-wid-price">
                                        <a href="https://youtu.be/${product.youtube_id}" class="view-details-link" target="_blank"><i
												class="fa fa-link"></i> See details</a>
                                    </div>
                                </div>
                                <div class="single-wid-product">
                                    <a href="single-product.jsp"><img src="assets/img/product-thumb-1.jpg" alt="" class="product-thumb"></a>
                                    <h2>
								<a href="single-product.html">Sony playstation microsoft</a>
							</h2>
                                    <div class="product-wid-rating">
                                        <span class="meta-part"><i
									class="ti-calendar"></i><a href="#"> Date:20.02.2018</a></span>
                                    </div>
                                    <div class="product-wid-price">
                                        <a href="https://youtu.be/${product.youtube_id}" class="view-details-link" target="_blank"><i
												class="fa fa-link"></i> See details</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
 <!-- blog pages end --> 

</body>
</html>