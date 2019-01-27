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
	</body>
</html>