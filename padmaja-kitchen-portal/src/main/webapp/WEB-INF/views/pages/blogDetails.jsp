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
<!-- End mainmenu area -->
            <section class="job-browse section" style="padding: 5px 0;">
                <div class="container">
                    <div class="row">
                        <div class="col-md-9 col-sm-8">
                            <div class="blog-post">
                                <div class="post-content">
                                    <h3 class="post-title"><a href="#"><u>${details.title}:</u></a></h3>
                                    <div class="meta">
                                        <span class="meta-part"><a href="#"><i
										class="ti-user"></i> By Admin</a></span> <span class="meta-part"><i
									class="ti-calendar"></i>${details.crtDate}</span> <span class="meta-part"><a href="#"><i
										class="ti-comment-alt"></i></a></span>
                                    </div>
                                    <br/>
                                    <p><b>${details.title}recipe</b>${details.paragraphOne}</p>
                                    <img src="${details.imageOneUrl}" alt="">
                                    <p>${details.paragraphTwo}</p>
                                    <p>,${details.paragraphThree}</p>

                                    <img src="${details.imageTwoUrl}" alt="">
                                    <p>${details.paragraphFour}</p>
                                    <h3><b>${details.youTubeVideoTitle}:</b></h3>
                                    <iframe width="670" height="315" src="${details.youTubeVideoUrl}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

                                    <br/>
                                    <h3><b>${details.recipeCardTitle}:</b></h3>

                                    <blockquote>
                                        <span class="quote-text">
											<div style="border-style: dotted;">
											<h4><b>${details.recipeCardInsideTitle}</b></h4>
											<h3><b>Ingredients:</b></h3>
											<p>
												
											${details.ingredientsDetails}
											</p>
											<h3><b>Instructions:</b></h3>
											<p>
												${details.instructionsDetails}

											</p>

										</div></span>
								</blockquote>
							<div class="widget widget-categories">
								<h5 class="widget-title"><b>Notes:</b></h5>
								<ul class="cat-list">
									${details.notes}
                                  </ul>
                                </div>

                            </div>
                        </div>

                    </div>
                 
                 	<div class="col-md-3 col-sm-4">
                            <aside>
                                <div class="sidebar">
                                    <div class="inner-box">
                                        <h3>Categories</h3>
                                        <ul class="cat-list">
                                            <li><a href="#">BreakFast Creeds <span class="num-posts">(${details.brekFastCount})
										</span></a></li>
                                            <li><a href="#">Launch Creeds <span class="num-posts">(${details.launchCount})
										</span></a></li>
                                            <li><a href="#">Morning Creeds<span class="num-posts">(${details.morningCount})
										</span></a></li>
                                            <li><a href="#">Evening Creeds <span class="num-posts">(${details.eveningCount})
										</span></a></li>
                                            <li><a href="#">Dinar Creeds <span class="num-posts">(${details.dinarCount})</span></a></li>
                                             <li><a href="#">Sweets Creeds <span class="num-posts">(${details.sweetsCount})</span></a></li>
                                        </ul>
                                    </div>
                                   
                                </div>
                            </aside>
                        </div>
                 
                 
                </div>
            </div>
            </section><!-- content close -->
	

</body>
</html>