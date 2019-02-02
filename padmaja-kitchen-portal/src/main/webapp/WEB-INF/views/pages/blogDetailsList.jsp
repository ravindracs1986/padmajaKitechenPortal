<%@ page isELIgnored="false"%>
<%@page
	import="javax.servlet.*,javax.servlet.http.*,java.sql.*,java.io.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <!-- Custom CSS -->
	  <link rel="stylesheet" href="assets/css/main.css">
<style>
 
   #myTable {
    border-collapse: separate;
    border-spacing: 0 1em;

 }
</style>
</head>
<body>
<!-- End main content area -->
	
	<!-- <div class="container">
<div class="row header" style="text-align:center;color:green">
<h3>Bootstrap</h3>
</div> -->

	  
	
<!-- End mainmenu area -->
			 <section class="job-browse section">
                <div class="container">
                    <div class="row">
						<div class="col-md-9 col-sm-8" >
						<table id="myTable" class="table table-striped" >
							<thead>  
						          <tr>  
						            <th></th>  
						            <th></th>  
						            <th></th>  
						            <th></th>
						            <h4>Records are below</h4>  
						          </tr>  
						        </thead>
						        <c:forEach var="img" items="${imageDetailList}">
								<tbody> 
									<tr>
										  <td><div class="thumb"><img src="data:image/png;base64, ${img.imageString}" alt="" class="product-thumb"></div></td>  
								          <td><h4>${img.title}</h4></td>  
								          <td><p>${img.description}</p></td>  
								          <td><a href="${pageContext.request.contextPath}/detail?id=${img.id}" class="btn btn-common btn-rm"" target="_blank"><i
												class="fa fa-link"></i> See details</a></td>
									 </tr>
							     </tbody>
							    
						     </c:forEach> 
						   </table>
						
						   
							<%-- <c:forEach var="img" items="${imageDetailList}"> --%>
						
							<%-- <div class="job-list">
                                <div class="thumb">
                                    <img src="data:image/png;base64, ${img.imageString}" alt="" class="product-thumb">
                                </div>
                                <div class="job-list-content">
                                    <h4>${img.title}</h4>
                                    <p>${img.description}</p>
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
                            </div> --%>
                          
                          <%--  </c:forEach> --%>
                           
                         <!--  <ul class="pagination">
                                <li class="active"><a href="#" class="btn btn-common"><i class="ti-angle-left"></i> prev</a></li>
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                                <li class="active"><a href="#" class="btn btn-common">Next<i class="ti-angle-right"></i></a></li>
                            </ul> -->

                        </div>
                        
                        <div class="col-md-3 col-sm-4">
                            <aside>
                                <div class="sidebar">
                                    <div class="inner-box">
                                        <h3>Categories</h3>
                                        <ul class="cat-list">
                                            <li><a href="#">BreakFast Creeds <span class="num-posts">(${breakCount})
										</span></a></li>
                                            <li><a href="#">Launch Creeds <span class="num-posts">(${launchCount})
										</span></a></li>
                                            <li><a href="#">Morning Creeds<span class="num-posts">(${morningCount})
										</span></a></li>
                                            <li><a href="#">Evening Creeds <span class="num-posts">(${eveningCount})
										</span></a></li>
                                            <li><a href="#">Dinar Creeds <span class="num-posts">(${dinarCount})</span></a></li>
                                            <li><a href="#">Sweets Creeds <span class="num-posts">(${sweetsCount})</span></a></li>
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
	<script type="text/javascript">
		$(document).ready(function(){
			
			$('#myTable').DataTable( {
		        "ordering": false,
		        "info":     false,
		        "searching": false,
		        "lengthChange": false
		    } );
		   
		});
		</script>
</html>