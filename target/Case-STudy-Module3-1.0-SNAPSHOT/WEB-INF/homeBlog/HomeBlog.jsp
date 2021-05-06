<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 3/2/2021
  Time: 3:10 PM
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
    <title>Blog Home</title>

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
                <a href="/homeBlog"><img src="${pageContext.request.contextPath}/resources/home-blog/img/logo.png" alt="" title="" /></a>
            </div>
            <nav id="nav-menu-container">
                <ul class="nav-menu">
                    <li><a href="/homeBlog">Home</a></li>
                    <li><a href="/homeBlog?action=about">About</a></li>
                    <li><a href="/homeBlog?action=contact">Contact</a></li>
                    <li><a href="/loginBlog">Log in</a></li>
                    <li><a href="#">Registration</a></li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<!-- end header Area -->

<!-- start banner Area -->
<section class="home_banner_area blog_banner">
    <div class="banner_inner d-flex align-items-center">
        <div class="overlay bg-parallax" data-stellar-ratio="0.9" data-stellar-vertical-offset="0" data-background=""></div>
        <div class="container">
            <div class="blog_b_text text-center">
                <h2 class="text-white">Dude You’re Getting
                    <br /> a Telescope</h2>
                <p>There is a moment in the life of any aspiring astronomer that it is time to buy that first</p>
                <a class="white_bg_btn" href="#">View More</a>
            </div>
        </div>
    </div>
</section>
<!-- End banner Area -->

<!-- Start top-category-widget Area -->
<section class="top-category-widget-area pt-90 pb-90 ">
    <div class="container">
        <div class="row">
            <c:forEach var="list" items="${limitNewPost}">
                <div class="col-lg-4">
                    <div class="single-cat-widget">
                        <div class="content relative">
                            <div class="overlay overlay-bg"></div>
                            <a href="/homeBlog?action=blogSingle&id=${list.id}" target="_blank">
                                <div class="thumb" >
                                    <img style="height: 240px" class="content-image img-fluid d-block mx-auto" src="${list.image}" alt="">
                                </div>
                                <div class="content-details">
                                    <h4 class="content-title mx-auto text-uppercase">${list.category.nameCategory}</h4>
                                    <span></span>
                                    <p style="margin-top: 1rem">${list.title}</p>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<!-- End top-category-widget Area -->

<!-- Start post-content Area -->
<section class="post-content-area">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 posts-list">
                <c:forEach items="${listPost}" var="list">
                    <div class="single-post row">
                        <div class="col-lg-3  col-md-3 meta-details">
                            <ul class="tags">
                                <li><a href="/homeBlog?action=blogSingle&id=${list.id}">${list.title}</a></li>
                            </ul>
                            <div class="user-details row">
                                <p class="user-name col-lg-12 col-md-12 col-6"><a href="/homeBlog?action=blogSingle">Mark wiens</a> <span class="lnr lnr-user"></span></p>
                                <p class="date col-lg-12 col-md-12 col-6"><a href="/homeBlog?action=blogSingle">${list.publisht}</a> <span class="lnr lnr-calendar-full"></span></p>
                                <p class="view col-lg-12 col-md-12 col-6"><a href="/homeBlog?action=blogSingle">1.2M Views</a> <span class="lnr lnr-eye"></span></p>
                                <p class="comments col-lg-12 col-md-12 col-6"><a href="/homeBlog?action=blogSingle">06 Comments</a> <span class="lnr lnr-bubble"></span></p>
                            </div>
                        </div>
                        <div class="col-lg-9 col-md-9 ">
                            <div class="feature-img">
                                <img class="img-fluid" src="${list.image}" alt="">
                            </div>
                            <a class="posts-title" href="/homeBlog?action=blogSingle&id=${list.id}">
                                <h3>${list.title}</h3>
                            </a>
                            <p class="excert">
                               ${list.shortContent}
                            </p>
                            <a href="/homeBlog?action=blogSingle&id=${list.id}" class="white_bg_btn">View More</a>
                        </div>
                    </div>
                </c:forEach>
                <nav class="blog-pagination justify-content-center d-flex">
                    <ul class="pagination">
                        <li class="page-item">
                            <a href="#" class="page-link" aria-label="Previous">
									<span aria-hidden="true">
										<span class="lnr lnr-chevron-left"></span>
									</span>
                            </a>
                        </li>
                        <li class="page-item"><a href="#" class="page-link">01</a></li>
                        <li class="page-item active"><a href="#" class="page-link">02</a></li>
                        <li class="page-item"><a href="#" class="page-link">03</a></li>
                        <li class="page-item"><a href="#" class="page-link">04</a></li>
                        <li class="page-item"><a href="#" class="page-link">09</a></li>
                        <li class="page-item">
                            <a href="#" class="page-link" aria-label="Next">
									<span aria-hidden="true">
										<span class="lnr lnr-chevron-right"></span>
									</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-4 sidebar-widgets">
                <div class="widget-wrap">
                    <div class="single-sidebar-widget search-widget">
                        <form class="search-form">
                            <input placeholder="Search Posts" name="search" type="text" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Search Posts'">
                            <button style="padding: 15px;" type="submit"><i class="fa fa-search"></i></button>
                        </form>
                    </div>
                    <div class="single-sidebar-widget user-info-widget">
                        <img style="width: 120px" src="https://scontent.fpnh22-1.fna.fbcdn.net/v/t1.0-9/152339864_458226202042624_7818306232296619865_n.jpg?_nc_cat=111&ccb=1-3&_nc_sid=8bfeb9&_nc_ohc=pMf8GV8zGHYAX8UHQro&_nc_ht=scontent.fpnh22-1.fna&oh=ca7496851757730841db493e0939330b&oe=60695712" alt="">
                        <a href="#">
                            <h4>Quang Phuoc</h4>
                        </a>
                        <p>
                            Senior blog writer
                        </p>
                        <ul class="social-links">
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-github"></i></a></li>
                            <li><a href="#"><i class="fa fa-behance"></i></a></li>
                        </ul>
                        <p>
                            Boot camps have its supporters andit sdetractors. Some people do not understand why you should have to spend
                            money on boot
                            camp when you can get. Boot camps have itssuppor ters andits detractors.
                        </p>
                    </div>
                    <div class="single-sidebar-widget popular-post-widget">
                        <h4 class="popular-title">Popular Posts</h4>
                        <div class="popular-post-list">
                            <c:forEach items="${limitNewPost}" var="list">
                                <div class="single-post-list d-flex flex-row align-items-center">
                                    <div class="thumb">
                                        <img class="img-fluid" src="${list.image}" alt="">
                                    </div>
                                    <div class="details">
                                        <a href="/homeBlog?action=blogSingle&id=${list.id}">
                                            <h6>${list.title}</h6>
                                        </a>
                                        <p>${list.publisht}</p>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="single-sidebar-widget ads-widget">
                        <a href="#"><img class="img-fluid" src="${pageContext.request.contextPath}/resources/home-blog/img/blog/ads-banner.jpg" alt=""></a>
                    </div>
                    <div class="single-sidebar-widget post-category-widget">
                        <h4 class="category-title">Post Catgories</h4>
                        <ul class="cat-list">
                            <li>
                                <a href="#" class="d-flex justify-content-between">
                                    <p>Technology</p>
                                    <p>37</p>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="d-flex justify-content-between">
                                    <p>Lifestyle</p>
                                    <p>24</p>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="d-flex justify-content-between">
                                    <p>Fashion</p>
                                    <p>59</p>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="d-flex justify-content-between">
                                    <p>Art</p>
                                    <p>29</p>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="d-flex justify-content-between">
                                    <p>Food</p>
                                    <p>15</p>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="d-flex justify-content-between">
                                    <p>Architecture</p>
                                    <p>09</p>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="d-flex justify-content-between">
                                    <p>Adventure</p>
                                    <p>44</p>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <div class="single-sidebar-widget newsletter-widget">
                        <h4 class="newsletter-title">Newsletter</h4>
                        <p>
                            Here, I focus on a range of items and features that we use in life without giving them a second thought.
                        </p>
                        <div class="form-group d-flex flex-row">
                            <div class="col-autos">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text"><i class="fa fa-envelope" aria-hidden="true"></i>
                                        </div>
                                    </div>
                                    <input type="text" class="form-control" id="inlineFormInputGroup" placeholder="Enter email" onfocus="this.placeholder = ''"
                                           onblur="this.placeholder = 'Enter email'">
                                </div>
                            </div>
                            <a href="#" class="bbtns">Subcribe</a>
                        </div>
                        <p class="text-bottom">
                            You can unsubscribe at any time
                        </p>
                    </div>
                    <div class="single-sidebar-widget tag-cloud-widget">
                        <h4 class="tagcloud-title">Tag Clouds</h4>
                        <ul>
                            <li><a href="#">Technology</a></li>
                            <li><a href="#">Fashion</a></li>
                            <li><a href="#">Architecture</a></li>
                            <li><a href="#">Fashion</a></li>
                            <li><a href="#">Food</a></li>
                            <li><a href="#">Technology</a></li>
                            <li><a href="#">Lifestyle</a></li>
                            <li><a href="#">Art</a></li>
                            <li><a href="#">Adventure</a></li>
                            <li><a href="#">Food</a></li>
                            <li><a href="#">Lifestyle</a></li>
                            <li><a href="#">Adventure</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- End post-content Area -->

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
