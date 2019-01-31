<%@ page isELIgnored="false"%>
<%@page import="javax.servlet.*,javax.servlet.http.*,java.sql.*,java.io.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

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
                                    <a href="#"><img src="data:image/png;base64, ${img.imageString}" alt="" class="product-thumb"></a>
                                    <h2 style="color: #5a5555;">${img.blogName}</h2>
                                    <div class="product-wid-rating">
                                        <span class="meta-part" style="color: #5a5555;"><i class="ti-calendar"></i>${img.crtDate}</span>
                                    </div>
                                    <div class="product-wid-price">
                                        <a href="${pageContext.request.contextPath}/detail?id=${img.id}" style="background-color: lightgrey;" class="view-details-link" target="_blank"><i
												class="fa fa-link" "></i> See details</a>
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
                                    <a href="#"><img src="data:image/png;base64, ${recentlyimg.imageString}" alt="" class="product-thumb"></a>
                                    <h2 style="color: #5a5555;">${recentlyimg.blogName}</h2>
                                    <div class="product-wid-rating">
                                        <span class="meta-part" style="color: #5a5555;"><i class="ti-calendar"></i> ${recentlyimg.crtDate}</span>
                                    </div>
                                    <div class="product-wid-price">
                                        <a href="${pageContext.request.contextPath}/detail?id=${recentlyimg.id}" style="background-color: lightgrey;" class="view-details-link" target="_blank"><i
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
                                    <a href="#"><img src="data:image/png;base64, ${newimg.imageString}" alt="" class="product-thumb"></a>
                                    <h2 style="color: #5a5555;">${newimg.blogName}</h2>
                                    <div class="product-wid-rating">
                                        <span class="meta-part" style="color: #5a5555;"><i class="ti-calendar"></i> ${newimg.crtDate}</span>
                                    </div>
                                    <div class="product-wid-price">
                                        <a href="${pageContext.request.contextPath}/detail?id=${newimg.id}" style="background-color: lightgrey;" class="view-details-link" target="_blank"><i
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