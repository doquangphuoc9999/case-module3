<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 3/4/2021
  Time: 8:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8" />
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="au theme template" />
    <meta name="author" content="Hau Nguyen" />
    <meta name="keywords" content="au theme template" />

    <!-- Title Page-->
    <title>List User</title>

    <!-- Fontfaces CSS-->
    <link href="${pageContext.request.contextPath}/resources/admin/css/font-face.css" rel="stylesheet" media="all" />
    <link
            href="${pageContext.request.contextPath}/resources/admin/vendor/font-awesome-4.7/css/font-awesome.min.css"
            rel="stylesheet"
            media="all"
    />
    <link
            href="${pageContext.request.contextPath}/resources/admin/vendor/font-awesome-5/css/fontawesome-all.min.css"
            rel="stylesheet"
            media="all"
    />
    <link
            href="${pageContext.request.contextPath}/resources/admin/vendor/mdi-font/css/material-design-iconic-font.min.css"
            rel="stylesheet"
            media="all"
    />

    <!-- Bootstrap CSS-->
    <link
            href="${pageContext.request.contextPath}/resources/admin/vendor/bootstrap-4.1/bootstrap.min.css"
            rel="stylesheet"
            media="all"
    />

    <!-- Vendor CSS-->
    <link
            href="${pageContext.request.contextPath}/resources/admin/vendor/animsition/animsition.min.css"
            rel="stylesheet"
            media="all"
    />
    <link
            href="${pageContext.request.contextPath}/resources/admin/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css"
            rel="stylesheet"
            media="all"
    />
    <link href="${pageContext.request.contextPath}/resources/admin/vendor/wow/animate.css" rel="stylesheet" media="all" />
    <link
            href="${pageContext.request.contextPath}/resources/admin/vendor/css-hamburgers/hamburgers.min.css"
            rel="stylesheet"
            media="all"
    />
    <link href="${pageContext.request.contextPath}/resources/admin/vendor/slick/slick.css" rel="stylesheet" media="all" />
    <link href="${pageContext.request.contextPath}/resources/admin/vendor/select2/select2.min.css" rel="stylesheet" media="all" />
    <link
            href="${pageContext.request.contextPath}/resources/admin/vendor/perfect-scrollbar/perfect-scrollbar.css"
            rel="stylesheet"
            media="all"
    />

    <!-- Main CSS-->
    <link href="${pageContext.request.contextPath}/resources/admin/css/theme.css" rel="stylesheet" media="all" />
</head>

<body class="animsition">
<div class="page-wrapper">
    <!-- HEADER MOBILE-->
    <header class="header-mobile d-block d-lg-none">
        <div class="header-mobile__bar">
            <div class="container-fluid">
                <div class="header-mobile-inner">
                    <a class="logo" href="index.html">
                        <img src="${pageContext.request.contextPath}/resources/admin/images/icon/logo.png" alt="CoolAdmin" />
                    </a>
                    <button class="hamburger hamburger--slider" type="button">
                <span class="hamburger-box">
                  <span class="hamburger-inner"></span>
                </span>
                    </button>
                </div>
            </div>
        </div>
        <nav class="navbar-mobile">
            <div class="container-fluid">
                <ul class="navbar-mobile__list list-unstyled">
                    <li>
                        <a href="chart.html"> <i class="fas fa-chart-bar"></i>Charts</a>
                    </li>
                    <li>
                        <a href="table.html"> <i class="fas fa-table"></i>Tables</a>
                    </li>
                    <li>
                        <a href="form.html">
                            <i class="fas fa-user"></i>Quản Lý Tài Khoản</a>

                    </li>
                    <li>
                        <a href="calendar.html">
                            <i class="fas fa-book-open"></i>Quản lý bài viết</a
                        >
                    </li>
                    <li>
                        <a href="map.html">
                            <i class="fas fa-map-marker-alt"></i>Maps</a
                        >
                    </li>
                    <li class="has-sub">
                        <a class="js-arrow" href="#">
                            <i class="fas fa-copy"></i>Pages</a
                        >
                        <ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
                            <li>
                                <a href="login.html">Login</a>
                            </li>
                            <li>
                                <a href="register.html">Register</a>
                            </li>
                            <li>
                                <a href="forget-pass.html">Forget Password</a>
                            </li>
                        </ul>
                    </li>
                    <li class="has-sub">
                        <a class="js-arrow" href="#">
                            <i class="fas fa-desktop"></i>UI Elements</a
                        >
                        <ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
                            <li>
                                <a href="button.html">Button</a>
                            </li>
                            <li>
                                <a href="badge.html">Badges</a>
                            </li>
                            <li>
                                <a href="tab.html">Tabs</a>
                            </li>
                            <li>
                                <a href="card.html">Cards</a>
                            </li>
                            <li>
                                <a href="alert.html">Alerts</a>
                            </li>
                            <li>
                                <a href="progress-bar.html">Progress Bars</a>
                            </li>
                            <li>
                                <a href="modal.html">Modals</a>
                            </li>
                            <li>
                                <a href="switch.html">Switchs</a>
                            </li>
                            <li>
                                <a href="grid.html">Grids</a>
                            </li>
                            <li>
                                <a href="fontawesome.html">Fontawesome Icon</a>
                            </li>
                            <li>
                                <a href="typo.html">Typography</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- END HEADER MOBILE-->

    <!-- MENU SIDEBAR-->
    <aside class="menu-sidebar d-none d-lg-block">
        <div class="logo">
            <a href="/homeBlog">
                <img src="${pageContext.request.contextPath}/resources/admin/images/icon/logo.png" alt="Cool Admin" />
            </a>
        </div>
        <div class="menu-sidebar__content js-scrollbar1">
            <nav class="navbar-sidebar">
                <ul class="list-unstyled navbar__list">

                    <c:if test="${sessionScope.user.statusUser == 0}">
                        <li>
                            <a href="/admin?action=listAuthor">
                                <i class="fas fa-user"></i>Manege User</a
                            >
                        </li>
                    </c:if>
                    <li>
                        <a href="/admin">
                            <i class="fas fa-address-book"></i>Manage Post</a
                        >
                    </li>

                    <c:if test="${sessionScope.user.statusUser != 2}">
                        <li>
                            <a href="/admin?action=trashCan">
                                <i class="fas fa-trash-alt"></i>Trash
                            </a>
                        </li>
                        <li>
                            <a href="/admin?action=listCategory">
                                <i class="fas fa-list-ol"></i>Manage category</a
                            >
                        </li>
                    </c:if>


                </ul>
            </nav>
        </div>
    </aside>
    <!-- END MENU SIDEBAR-->

    <!-- PAGE CONTAINER-->
    <div class="page-container">
        <!-- HEADER DESKTOP-->
        <header class="header-desktop">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="header-wrap">
                        <div class="form-header">
                            <c:choose>
                                <c:when test="${mess}">
                                    <div class="alert alert-success" role="alert" style="height: 40px; margin-top: 38px">Delete is success</div>
                                </c:when>
                            </c:choose>
                        </div>
                        <div class="header-button">
                            <div class="account-wrap">
                                <div class="account-item clearfix js-item-menu">
                                    <div class="image">
                                        <img src="${sessionScope.user.image}" alt="${sessionScope.user.nameUser}" />
                                    </div>
                                    <div class="content">
                                        <a class="js-acc-btn" href="javascriPt:;">${sessionScope.user.nameUser}</a>
                                    </div>
                                    <div class="account-dropdown js-dropdown">
                                        <div class="info clearfix">
                                            <div class="image">
                                                <a href="javascript:;">
                                                    <img
                                                            src="${sessionScope.user.image}"
                                                            alt="${sessionScope.user.nameUser}"
                                                            style="width: 100px;"
                                                    />
                                                </a>
                                            </div>
                                            <div class="content">
                                                <h5 class="name">
                                                    <a href="javascript:;">${sessionScope.user.nameUser}</a>
                                                </h5>
                                                <span class="email">${sessionScope.user.gmailUser}</span>
                                            </div>
                                        </div>
                                        <div class="account-dropdown__body">
                                            <div class="account-dropdown__item">
                                                <a href="#">
                                                    <i class="zmdi zmdi-account"></i>Account</a
                                                >
                                            </div>
                                            <div class="account-dropdown__item">
                                                <!-- <a href="#">
                                                  <i class="zmdi zmdi-settings"></i>Setting</a
                                                > -->
                                            </div>

                                        </div>
                                        <div class="account-dropdown__footer">
                                            <a href="/LogOut"> <i class="zmdi zmdi-power"></i>Logout</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- END HEADER DESKTOP-->

        <!-- MAIN CONTENT-->
        <div class="main-content">
            <div class="section__content section__content--p30">
                <div class="container-fluid">

                </div>
                <div class="row">
                    <div class="col-md-12">
                        <!-- DATA TABLE -->
                        <h3 class="title-5 m-b-35">data table</h3>
                        <div class="table-data__tool">

                            <div class="table-data__tool-right">
                                <a href="/admin?action=addUser">
                                    <button class="au-btn au-btn-icon au-btn--green au-btn--small">
                                        <i class="zmdi zmdi-plus"></i>add User
                                    </button>
                                </a>
                                <div
                                        class="rs-select2--dark rs-select2--sm rs-select2--dark2"
                                >

                                    <div class="dropDownSelect2"></div>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive table-responsive-data2">
                            <table class="table table-data2">
                                <thead>
                                <tr>
                                    <th></th>
                                    <th>id</th>
                                    <th>Name</th>
                                    <th>Images</th>
                                    <th>Gmail</th>
                                    <th>Nickname</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="list" items="${listUser}">
                                    <tr class="tr-shadow">
                                        <td></td>
                                        <td>${list.id}</td>
                                        <td>${list.nameUser}</td>
                                        <td><img src="${list.image}" width="100px" alt="Image"></td>
                                        <td>${list.gmailUser}</td>
                                        <td>${list.nickname}</td>
                                        <td>
                                            <div class="table-data-feature">
                                                <button class="item" data-toggle="tooltip" data-placement="top"  title="Edit">
                                                    <a href="admin?action=editUser&id=${list.id}">
                                                        <i class="zmdi zmdi-edit"></i>
                                                    </a>
                                                </button>
                                                <button class="item" data-toggle="tooltip" data-placement="top" title="Delete">
                                                    <a href="admin?action=deleteUser&id=${list.id}" onclick="return confirm( 'Bạn có chắc chắn muốn xóa người dùng này')">
                                                        <i class="zmdi zmdi-delete"></i>
                                                    </a>
                                                </button>

                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="spacer"></tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- END DATA TABLE -->
                    </div>
                </div>
                <div class="row m-t-30">
                    <div class="col-md-12">
                        <!-- DATA TABLE-->

                        <!-- END DATA TABLE-->
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="copyright">
                            <p>
                                Copyright © 2018 Colorlib. All rights reserved. Template
                                by <a href="https://colorlib.com">Colorlib</a>.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<!-- Jquery JS-->
<script src="${pageContext.request.contextPath}/resources/admin/vendor/jquery-3.2.1.min.js"></script>
<!-- Bootstrap JS-->
<script src="${pageContext.request.contextPath}/resources/admin/vendor/bootstrap-4.1/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendor/bootstrap-4.1/bootstrap.min.js"></script>
<!-- Vendor JS       -->
<script src="${pageContext.request.contextPath}/resources/admin/vendor/slick/slick.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendor/wow/wow.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendor/animsition/animsition.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendor/counter-up/jquery.waypoints.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendor/counter-up/jquery.counterup.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendor/circle-progress/circle-progress.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendor/chartjs/Chart.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/admin/vendor/select2/select2.min.js"></script>

<!-- Main JS-->
<script src="${pageContext.request.contextPath}/resources/admin/js/main.js"></script>
</body>
</html>
