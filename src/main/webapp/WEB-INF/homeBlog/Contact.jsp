<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 3/8/2021
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zxx" class="no-js">

<head>
    <!-- Mobile Specific Meta -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Favicon-->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/home-blog/img/fav.png">
    <!-- Author Meta -->
    <meta name="author" content="codepixer">
    <!-- Meta Description -->
    <meta name="description" content="">
    <!-- Meta Keyword -->
    <meta name="keywords" content="">
    <!-- meta character set -->
    <meta charset="UTF-8">
    <!-- Site Title -->
    <title>Contact</title>

    <link href="https://fonts.googleapis.com/css?family=Poppins:400,600|Roboto:400,400i,500" rel="stylesheet">
    <!--
            CSS
            ============================================= -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/home-blog/css/linearicons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/home-blog/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/home-blog/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/home-blog/css/magnific-popup.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/home-blog/css/nice-select.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/home-blog/css/hexagons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/home-blog/css/owl.carousel.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/home-blog/css/main.css">
</head>

<body>
<!-- start header Area -->
<header id="header">
    <div class="container main-menu">
        <div class="row align-items-center justify-content-between d-flex">
            <div id="logo">
                <a href="index.html"><img src="img/logo.png" alt="" title="" /></a>
            </div>
            <nav id="nav-menu-container">
                <ul class="nav-menu">
                    <li><a href="/homeBlog">Home</a></li>
                    <li><a href="/homeBlog?action=about">About</a></li>
                    <li class="menu-active"><a href="/homeBlog?action=contact">Contact</a></li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<!-- end header Area -->

<!-- start banner Area -->
<section class="banner-area">
    <div class="container">
        <div class="row banner-content">
            <div class="col-lg-12 d-flex align-items-center justify-content-between">
                <div class="left-part">
                    <h1>
                        Contact Us
                    </h1>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore
                        magna aliqua.
                    </p>
                </div>
                <div class="right-part">
                    <a href="index.html">home</a>
                    <span class="fa fa-caret-right"></span>
                    <a href="contact.html">contact</a>
                </div>
            </div>
        </div>
    </div>
    </div>
</section>
<!-- End banner Area -->

<!-- Start contact-page Area -->
<section class="contact-page-area section-gap">
    <div class="container">
        <div class="row">
            <div class="map-wrap" style="width:100%; height: 445px;" id="map"></div>
            <div class="col-lg-4 d-flex flex-column address-wrap">
                <div class="single-contact-address d-flex flex-row">
                    <div class="icon">
                        <span class="lnr lnr-home"></span>
                    </div>
                    <div class="contact-details">
                        <h5>Dhaka, Bangladesh</h5>
                        <p>56/8, West Panthapath</p>
                    </div>
                </div>
                <div class="single-contact-address d-flex flex-row">
                    <div class="icon">
                        <span class="lnr lnr-phone-handset"></span>
                    </div>
                    <div class="contact-details">
                        <h5>00 (880) 9865 562</h5>
                        <p>Mon to Fri 9am to 6 pm</p>
                    </div>
                </div>
                <div class="single-contact-address d-flex flex-row">
                    <div class="icon">
                        <span class="lnr lnr-envelope"></span>
                    </div>
                    <div class="contact-details">
                        <h5>support@codethemes.com</h5>
                        <p>Send us your query anytime!</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-8">
                <form class="form-area " id="myForm" action="mail.php" method="post" class="contact-form text-right">
                    <div class="row">
                        <div class="col-lg-6 form-group">
                            <input name="name" placeholder="Enter your name" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter your name'"
                                   class="common-input mb-20 form-control" required="" type="text">

                            <input name="email" placeholder="Enter email address" pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,63}$"
                                   onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter email address'" class="common-input mb-20 form-control"
                                   required="" type="email">

                            <input name="subject" placeholder="Enter your subject" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter your subject'"
                                   class="common-input mb-20 form-control" required="" type="text">
                        </div>
                        <div class="col-lg-6 form-group">
								<textarea class="common-textarea form-control" name="message" placeholder="Messege" onfocus="this.placeholder = ''"
                                          onblur="this.placeholder = 'Messege'" required=""></textarea>
                        </div>
                        <div class="col-lg-12 d-flex justify-content-between">
                            <div class="alert-msg" style="text-align: left;"></div>
                            <button class="primary-btn" style="float: right;">Send Message</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<!-- End contact-page Area -->

<!-- Start Footer Area -->
<footer class="footer-area section-gap">
    <div class="container">
        <div class="row">
            <div class="col-lg-2 col-md-6 single-footer-widget">
                <h4>Top Products</h4>
                <ul>
                    <li><a href="#">Managed Website</a></li>
                    <li><a href="#">Manage Reputation</a></li>
                    <li><a href="#">Power Tools</a></li>
                    <li><a href="#">Marketing Service</a></li>
                </ul>
            </div>
            <div class="col-lg-2 col-md-6 single-footer-widget">
                <h4>Quick Links</h4>
                <ul>
                    <li><a href="#">Jobs</a></li>
                    <li><a href="#">Brand Assets</a></li>
                    <li><a href="#">Investor Relations</a></li>
                    <li><a href="#">Terms of Service</a></li>
                </ul>
            </div>
            <div class="col-lg-2 col-md-6 single-footer-widget">
                <h4>Features</h4>
                <ul>
                    <li><a href="#">Jobs</a></li>
                    <li><a href="#">Brand Assets</a></li>
                    <li><a href="#">Investor Relations</a></li>
                    <li><a href="#">Terms of Service</a></li>
                </ul>
            </div>
            <div class="col-lg-2 col-md-6 single-footer-widget">
                <h4>Resources</h4>
                <ul>
                    <li><a href="#">Guides</a></li>
                    <li><a href="#">Research</a></li>
                    <li><a href="#">Experts</a></li>
                    <li><a href="#">Agencies</a></li>
                </ul>
            </div>
            <div class="col-lg-4 col-md-6 single-footer-widget">
                <h4>Newsletter</h4>
                <p>You can trust us. we only send promo offers,</p>
                <div class="form-wrap" id="mc_embed_signup">
                    <form target="_blank" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
                          method="get" class="form-inline">
                        <input class="form-control" name="EMAIL" placeholder="Your Email Address" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Your Email Address '"
                               required="" type="email">
                        <button class="click-btn btn btn-default"><span class="lnr lnr-arrow-right"></span></button>
                        <div style="position: absolute; left: -5000px;">
                            <input name="b_36c4fd991d266f23781ded980_aefe40901a" tabindex="-1" value="" type="text">
                        </div>

                        <div class="info"></div>
                    </form>
                </div>
            </div>
        </div>
        <div class="footer-bottom row align-items-center">
            <p class="footer-text m-0 col-lg-6 col-md-12"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
            <div class="col-lg-6 col-md-6 social-link">
                <div class="download-button d-flex flex-row justify-content-end">
                    <div class="buttons gray flex-row d-flex">
                        <i class="fa fa-apple" aria-hidden="true"></i>
                        <div class="desc">
                            <a href="#">
                                <p>
                                    <span>Available</span> <br>
                                    on App Store
                                </p>
                            </a>
                        </div>
                    </div>
                    <div class="buttons gray flex-row d-flex">
                        <i class="fa fa-android" aria-hidden="true"></i>
                        <div class="desc">
                            <a href="#">
                                <p>
                                    <span>Available</span> <br>
                                    on Play Store
                                </p>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- End Footer Area -->

<script src="${pageContext.request.contextPath}/resources/home-blog/js/vendor/jquery-2.2.4.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/home-blog/https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/home-blog/js/tilt.jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/home-blog/js/vendor/bootstrap.min.js"></script>
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
<script src="${pageContext.request.contextPath}/resources/home-blog/js/easing.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/home-blog/js/hoverIntent.js"></script>
<script src="${pageContext.request.contextPath}/resources/home-blog/js/superfish.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/home-blog/js/jquery.ajaxchimp.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/home-blog/js/jquery.magnific-popup.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/home-blog/js/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/home-blog/js/owl-carousel-thumb.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/home-blog/js/hexagons.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/home-blog/js/jquery.nice-select.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/home-blog/js/waypoints.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/home-blog/js/mail-script.js"></script>
<script src="${pageContext.request.contextPath}/resources/home-blog/js/main.js"></script>
</body>

</html>
