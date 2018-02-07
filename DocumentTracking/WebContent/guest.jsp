<%@ page import="com.mytechnopal.*" %>
<%@ page import="com.mytechnopal.dto.*" %>
<%@ page import="com.mytechnopal.util.*" %>
<%@ page import="com.mytechnopal.webcontrol.*" %>
<%@ page import="com.ezshop.util.*" %>
<%@ page import="java.util.*" %>
<%
	SessionInfo sessionInfo = (SessionInfo) session.getAttribute(SessionInfo.SESSION_INFO);
	UserDTO user = (UserDTO)session.getAttribute(UserDTO.SESSION_USER);
%>

<link rel="stylesheet" href="common/guest/css/normalize.css">
<link rel="stylesheet" href="common/guest/css/bootstrap.min.css">
<link rel="stylesheet" href="common/guest/css/font-awesome/common/guest/css/font-awesome.min.css" />
<link rel="stylesheet" href="common/guest/elegant_font/style.css" />
<link rel="stylesheet" href="common/guest/css/magnific-popup.css">
<link rel="stylesheet" href="common/guest/css/slider-pro.css">
<link rel="stylesheet" href="common/guest/css/owl.carousel.css">
<link rel="stylesheet" href="common/guest/css/owl.theme.css">
<link rel="stylesheet" href="common/guest/css/owl.transitions.css">
<link rel="stylesheet" href="common/guest/css/animate.css">
<link rel="stylesheet" href="common/guest/elegant_font/style.css"> 
<link rel="stylesheet" href="common/guest/css/style.css"> 

</br>
<div class="container">	 
	<center>
		<div class="col-lg-12">
			<div class="col-lg-3">
			</div>
				<div class="col-lg-6">
					<h4>CITY GOVERNMENT OF BAGO DOCUMENT TRACKING SYSTEM</h4>	
				</div>
			<div class="col-lg-3">
			</div>
		</div>
	</center>
</div>

<div class="container">	 
	<center>
		<div class="col-lg-12">
			<div class="col-lg-3">
			</div>
				<div class="col-lg-6">
						<center>
							<img class="img-responsive" src="common/bagoCityHall/cityHall.png" style="width: 40%">
							<%-- <td colspan="3"><img src="common/barcode/<%=documenttracking.getCode()%>.JPG"></td> --%>
						</center>
				</div>
			<div class="col-lg-3">
			</div>
		</div>
	</center>
</div>
	

<div class="container">	 
	<center>
		<div class="col-lg-12">
			<div class="col-lg-4">
			</div>
				<div class="col-lg-4">
					<input class="form-control" name="txtUserName" id="txtUserName" type="text" placeholder="Username"><br>
					<input class="form-control" name="txtPassword" id="txtPassword" type="password" placeholder="Password"><br>
					<button type="button" class="btn col-sm-12"  onclick="openLink('G002')">Login</button>
				</div>
			<div class="col-lg-4">
			</div>
		</div>
	</center>
</div> 	
</br>
<div class="col-lg-12">  
</div>
	<footer>
	   <div class="container">
	       <div class="row">
	           <div class="footer-containertent">
	               <ul class="footer-social-info">
	                   <li>
	                       <a href="https://www.facebook.com/toby.care" target="_blank"><i class="fa fa-facebook"></i></a>
	                   </li>
	               </ul>
					<br/><br/>
					<p>Powered by <a href="http://mytechnopal.com/" target="_blank">Technopal Software</a> | 2017</p>
	           </div>
	       </div>
	   </div>
	</footer>

<!-- Footer End -->
<script src="common/guest/js/jquery-1.11.3.min.js"></script>
<script src="common/guest/js/bootstrap.min.js"></script>
<script src="common/guest/js/modernizr.min.js"></script>
<script src="common/guest/js/jquery.easing.1.3.js"></script>
<script src="common/guest/js/jquery.scrollUp.min.js"></script>
<script src="common/guest/js/jquery.easypiechart.js"></script>
<script src="common/guest/js/isotope.pkgd.min.js"></script>
<script src="common/guest/js/jquery.fitvids.js"></script>
<script src="common/guest/js/jquery.stellar.min.js"></script>
<script src="common/guest/js/jquery.waypoints.min.js"></script>
<script src="common/guest/js/wow.min.js"></script>
<script src="common/guest/js/jquery.nav.js"></script>
<script src="common/guest/js/imagesloaded.pkgd.min.js"></script>
<script src="common/guest/js/smooth-scroll.min.js"></script>
<script src="common/guest/js/jquery.magnific-popup.min.js"></script>
<script src="common/guest/js/jquery.sliderPro.min.js"></script>
<script src="common/guest/js/owl.carousel.min.js"></script>
<script src="common/guest/contact/jqBootstrapValidation.js"></script>
<script src="common/guest/contact/contact_me.js"></script>
<script src="common/guest/js/custom.js"></script>
