<%@ page import="java.sql.*"%>
    <%@ page isELIgnored="false"%>
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
            
             <div class="maincontent-area">
         <div class="zigzag-bottom"></div>
         <div class="container">
            <div class="row">
               <div class="col-md-12">
                  <div class="product-content-right">
                    <!-- save blogs start -->
                     
                     <div class="woocommerce">
						   <div class="woocommerce-info">Want to save Video? <a class="showlogin" data-toggle="collapse" href="#login-collapse-wrap" aria-expanded="false" aria-controls="login-collapse-wrap">Click here Save YouTube Video</a>
						   </div>
						   <form class="checkout_coupon collapse" method="post" action="${pageContext.request.contextPath}/SaveVideoController" id="login-collapse-wrap" >
									  
									  <div class="form-row">
										    <div class="form-group col-md-6">
										      <label for="category">Category:</label>
										      <select id="category" class="form-control"  name="category">
										        <option selected>Select a Category€¦</option>
	                                 			<option value="NONVEG">NON-VEG</option>
	                                			<option value="VEG">VEG</option>
										        
										      </select>
										    </div>
										    <div class="form-group col-md-6">
										      <label for="videoName">Video Name:</label>
										      <input type="text" class="form-control"  name="videoName" placeholder="VideoName">
										    </div>
									  </div>
									  
									  <div class="form-row">
									    <div class="form-group col-md-6">
									      <label for="videoUrl">Video Url:</label>
									      <input type="text" class="form-control"  placeholder="VideoUrl" name="videoUrl">
									    </div>
									    <div class="form-group col-md-6">
									      <label for="youTubeId">YouTube Id:</label>
									      <input type="text" class="form-control"  placeholder="YouTubeId" name="youTubeId">
									    </div>
									  </div>
									  <!-- <div class="btn pull-right">
									      <button type="submit" class="btn btn-primary">Save Video</button>
									    </div> -->
									  <input type="submit" value="Save Video" name="Save" class="button btn btn-primary"/>
								<!-- 	<button type="submit" class="btn btn-primary">Save Video</button>  -->
									</form>
						   
						   <!-- Blog Page -->
						   <div class="woocommerce-info">Want to Write full Blog Details? <a class="showcoupon" data-toggle="collapse" href="#coupon-collapse-wrap" aria-expanded="false" aria-controls="coupon-collapse-wrap">Click here Write Blog Details</a>
						   </div>
						    <form enctype="multipart/form-data" action="#" class="checkout_coupon collapse" method="post" name="checkout" id="coupon-collapse-wrap">
									  <div class="form-row">
									    <div class="form-group col-md-6">
									      <label for="inputEmail4">Email</label>
									      <input type="email" class="form-control" id="inputEmail4" placeholder="Email">
									    </div>
									    <div class="form-group col-md-6">
									      <label for="inputPassword4">Password</label>
									      <input type="password" class="form-control" id="inputPassword4" placeholder="Password">
									    </div>
									  </div>
									  <div class="form-group">
									    <label for="inputAddress">Address</label>
									    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
									  </div>
									  <div class="form-group">
									    <label for="inputAddress2">Address 2</label>
									    <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
									  </div>
									  <div class="form-row">
									    <div class="form-group col-md-6">
									      <label for="inputCity">City</label>
									      <input type="text" class="form-control" id="inputCity">
									    </div>
									    <div class="form-group col-md-4">
									      <label for="inputState">State</label>
									      <select id="inputState" class="form-control">
									        <option selected>Choose...</option>
									        <option>...</option>
									      </select>
									    </div>
									    <div class="form-group col-md-2">
									      <label for="inputZip">Zip</label>
									      <input type="text" class="form-control" id="inputZip">
									    </div>
									  </div>
									  <div class="form-group">
									    <div class="form-check">
									      <input class="form-check-input" type="checkbox" id="gridCheck">
									      <label class="form-check-label" for="gridCheck">
									        Check me out
									      </label>
									    </div>
									  </div>
									  <button type="submit" class="btn btn-primary">save Blogs</button>
									</form>
						   
						   
						   
						</div>
					 <!-- save blogs end -->
                     <div class="woocommerce-info">Your List of Videos:</div>
                     <div class="woocommerce" id="videoListId">
                            <form method="post" action="#">
                                <table cellspacing="0" class="shop_table cart">
                                    <thead>
                                        <tr>
                                            <th class="product-remove">&nbsp;</th>
                                            <th class="product-thumbnail">&nbsp;</th>
                                            <th class="product-name">Product</th>
                                            <th class="product-price">Price</th>
                                            <th class="product-quantity">Quantity</th>
                                            <th class="product-subtotal">Total</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="cart_item">
                                            <td class="product-remove">
                                                <a title="Remove this item" class="remove" href="#">×</a> 
                                            </td>

                                            <td class="product-thumbnail">
                                                <a href="single-product.html"><img width="145" height="145" alt="poster_1_up" class="shop_thumbnail" src="img/product-thumb-2.jpg"></a>
                                            </td>

                                            <td class="product-name">
                                                <a href="single-product.html">Ship Your Idea</a> 
                                            </td>

                                            <td class="product-price">
                                                <span class="amount">£15.00</span> 
                                            </td>

                                            <td class="product-quantity">
                                                <div class="quantity buttons_added">
                                                    <input type="button" class="minus" value="-">
                                                    <input type="number" size="4" class="input-text qty text" title="Qty" value="1" min="0" step="1">
                                                    <input type="button" class="plus" value="+">
                                                </div>
                                            </td>

                                            <td class="product-subtotal">
                                                <span class="amount">£15.00</span> 
                                            </td>
                                        </tr>
                                        
                                    </tbody>
                                </table>
                            </form>
                     
                      </div>
                     
                  </div>
               </div>
            </div>
         </div>
      </div>
            
            
            
            
        </body>

        </html>