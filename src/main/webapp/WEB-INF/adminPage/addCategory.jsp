<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 3/4/2021
  Time: 10:17 PM
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
    <title>Add Category</title>

    <!-- Fontfaces CSS-->
    <link href="${pageContext.request.contextPath}/resources/admin/css/font-face.css" rel="stylesheet" media="all" />
    <link
            href="${pageContext.request.contextPath}/resources/admin/vendor/font-awesome-5/css/fontawesome-all.min.css"
            rel="stylesheet"
            media="all"
    />
    <link
            href="${pageContext.request.contextPath}/resources/admin/vendor/font-awesome-4.7/css/font-awesome.min.css"
            rel="stylesheet"
            media="all"
    />
    <link
            href="${pageContext.request.contextPath}/resources/admin/vendor/mdi-font/css/material-design-iconic-font.min.css"
            rel="stylesheet"
            media="all"
    />

    <!-- link summernote -->
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
            integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
            crossorigin="anonymous"
    />
    <link
            href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css"
            rel="stylesheet"
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

    <!-- css selected category -->
<%--    toast  --%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js" integrity="sha512-VEd+nq25CkR676O+pLBnDW09R7VQX9Mdiij052gVCp5yVH3jGtH70Ho/UUv4mJDsEdTvqRCFZg0NKGiojGnUCw==" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js" integrity="sha512-VEd+nq25CkR676O+pLBnDW09R7VQX9Mdiij052gVCp5yVH3jGtH70Ho/UUv4mJDsEdTvqRCFZg0NKGiojGnUCw==" crossorigin="anonymous"></script>


    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.21.0/moment.min.js" type="text/javascript"></script>
    <style>
        .select {
            padding: 8px 12px;
            color: #333333;
            background-color: #eeeeee;
            border: 1px solid #dddddd;
            cursor: pointer;
            border-radius: 5px;
        }
        .select:focus,
        .select:hover {
            outline: none;
            border: 1px solid #bbbbbb;
        }
        .select option {
            background: #ffffff;
        }
    </style>
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
                        <li class="active">
                            <a href="/admin?action=listAuthor"> <i class="fas fa-user"></i>Manege User</a>
                        </li>
                    </c:if>

                    <c:if test="${sessionScope.user.statusUser == 0}">
                        <li>
                            <a href="/admin?action=trashCan">
                                <i class="fas fa-trash-alt"></i>Trash
                            </a>
                        </li>
                    </c:if>

                    <li>
                        <a href="/admin">
                            <i class="fas fa-address-book"></i>Manage Post</a
                        >
                    </li>

                    <c:if test="${sessionScope.user.statusUser != 2}">
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
                        <form class="form-header" method="POST"></form>
                        <div class="header-button">
                            <div class="account-wrap">
                                <div class="account-item clearfix js-item-menu">
                                    <div class="image">
                                        <img src="${sessionScope.user.image}" alt="${sessionScope.user.nameUser}" />
                                    </div>
                                    <div class="content">
                                        <a class="js-acc-btn" href="javascript:;">${sessionScope.user.nameUser}</a>
                                    </div>
                                    <div class="account-dropdown js-dropdown">
                                        <div class="info clearfix">
                                            <div class="image">
                                                <a href="javascript:;">
                                                    <img
                                                            src="${sessionScope.user.image}"
                                                            alt="${sessionScope.user.nameUser}"
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
        <!-- HEADER DESKTOP-->

        <!-- MAIN CONTENT-->
        <div class="main-content">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div>
                                    <c:if test="${mess.size() != 0}">
                                        <c:forEach items="${mess}" var="error">
                                            <div class="alert alert-danger" role="alert" style="height: 40px; margin-top: 38px">${error}</div>
                                        </c:forEach>
                                    </c:if>
                                </div>
                                <div class="card-header">
                                    <strong>Add Category</strong> Form
                                </div>
                                <div class="card-body card-block">
                                    <form action="/admin?action=addCategory" method="post" class="form-horizontal">
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label  class="form-control-label"
                                                >Name Category</label
                                                >
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input name="nameCategory" required placeholder="Enter nameCategory..." class="form-control" />
                                            </div>
                                        </div>
                                        <div class="card-footer">
                                            <button type="submit" class="btn btn-primary btn-sm">
                                                <i class="fa fa-dot-circle-o"></i> Submit
                                            </button>
                                            <button type="reset" class="btn btn-danger btn-sm">
                                                <i class="fa fa-ban"></i> Reset
                                            </button>
                                            <button
                                                    type="submit"
                                                    style="float: right"
                                                    class="btn btn-dark btn-sm"
                                            >
                                                <a style="color: #fff" href="/admin?action=listCategory">
                                                    <i class="fas fa-arrow-left"></i> Back
                                                </a>
                                            </button>
                                        </div>
                                    </form>
                                </div>

                            </div>
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
<c:if test="${mess.size() == 0}">
    <%--                                        <div class="alert alert-success" role="alert" style="height: 40px; margin-top: 38px">Thêm thành công</div>--%>
    <script>
        toastr.success("Thêm mới thành công");
    </script>
</c:if>
<!-- js select option -->
<!-- Jquery JS-->
<script
        src="https://code.jquery.com/jquery-3.5.1.min.js"
        crossorigin="anonymous"
></script>
<script
        src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"
></script>
<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"
></script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<script>
    $("#summernote").summernote({
        placeholder: "Enter short content",
        tabsize: 2,
        height: 100,
    });
</script>

<script>
    $("#fullcontentSummernote").summernote({
        placeholder: "Enter full content",
        tabsize: 2,
        height: 200,
    });
</script>
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
