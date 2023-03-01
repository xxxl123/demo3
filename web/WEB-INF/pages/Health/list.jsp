<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>社区居民医疗管理系统</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css">

    <script src="${pageContext.request.contextPath}/lib/jquery-1.7.2.min.js" type="text/javascript"></script>

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height: 300px;
            width: 800px;
            margin: 0px auto;
            margin-top: 1em;
        }

        .brand {
            font-family: georgia, serif;
        }

        .brand .first {
            color: #ccc;
            font-style: italic;
        }

        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>
    <style>
        ul.pagination {
            display: inline-block;
            padding: 0;
            margin: 0;
        }

        ul.pagination li {display: inline;}

        ul.pagination li a {
            color: black;
            float: left;
            padding: 8px 16px;
            text-decoration: none;
        }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->


</head>

<!--[if lt IE 7 ]>
<body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]>
<body class="ie ie7 "> <![endif]-->
<!--[if IE 8 ]>
<body class="ie ie8 "> <![endif]-->
<!--[if IE 9 ]>
<body class="ie ie9 "> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body class="">
<!--<![endif]-->

<div class="navbar">
    <div class="navbar-inner">
        <ul class="nav pull-right">

            <li id="fat-menu" class="dropdown">
                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="icon-user"></i> ADMIN
                    <i class="icon-caret-down"></i>
                </a>

                <ul class="dropdown-menu">
                    <li><a tabindex="-1" href="${pageContext.request.contextPath}/login.jsp">退出</a></li>
                </ul>
            </li>

        </ul>
        <a class="brand" href="#"><span class="first">社区</span> <span class="second">居民医疗系统</span></a>
    </div>
</div>


<div class="sidebar-nav">
    <form class="search form-inline" method="#">
        <input type="text" placeholder="Search...">
    </form>


    <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>社区居民信息管理</a>
    <ul id="dashboard-menu" class="nav nav-list collapse in">
        <li><a href="${pageContext.request.contextPath}/Usertoadd">添加社区居民</a></li>
        <li><a href="${pageContext.request.contextPath}/Userlist">查看社区居民</a></li>
    </ul>

    <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>居民身体状况管理</a>
    <ul id="dashboard-menu" class="nav nav-list collapse in">
        <li><a href="${pageContext.request.contextPath}/Healthtoadd">添加居民身体状况</a></li>
        <li><a href="${pageContext.request.contextPath}/Healthlist">查看居民身体状况</a></li>
    </ul>

    <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>医生信息管理</a>
    <ul id="dashboard-menu" class="nav nav-list collapse in">
        <li><a href="${pageContext.request.contextPath}/Doctortoadd">添加医生</a></li>
        <li><a href="${pageContext.request.contextPath}/Doctorlist">查看医生</a></li>

    </ul>
    <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>病人信息管理</a>
    <ul id="dashboard-menu" class="nav nav-list collapse in">
        <li><a href="${pageContext.request.contextPath}/Patienttoadd">添加病人</a></li>
        <li><a href="${pageContext.request.contextPath}/Patientlist">查看病人</a></li>
    </ul>
</div>


<div class="content">

    <div class="header">
        <div class="stats">

        </div>

        <h1 class="page-title">查看社区居民身体状况</h1>
    </div>

    <ul class="breadcrumb">
        <li><a href="#">社区居民身体状况管理</a> <span class="divider">/</span></li>
        <li class="active">查看社区居民身体状况</li>
    </ul>

    <div class="container-fluid">
        <div class="row-fluid">


            <div class="row-fluid">

                <table class="table table-bordered">
                    <tr>
                        <td>居民ID</td>
                        <td>居民姓名</td>
                        <td>身份证</td>
                        <td>年龄</td>
                        <td>手机号</td>
                        <td>身体状况</td>
                        <td>记录时间</td>
                        <td>操作</td>
                    </tr>
                    <c:forEach varStatus="vs" var="v" items="${list}">
                        <tr>
                            <td>${v.id}</td>
                            <td>${v.name}</td>
                            <td>${v.idcard}</td>
                            <td>${v.age}</td>
                            <td>${v.phone}</td>
                            <td>${v.msg}</td>
                            <td>${v.times}</td>
                            <td>
                                <a type="button" class="btn btn-info"
                                   href="${pageContext.request.contextPath}/Healthtoupdate?id=${v.id}">编辑</a>
                                <a type="button" class="btn btn-danger"
                                   href="${pageContext.request.contextPath}/Healthdel?id=${v.id}"
                                   onclick="return  confirm('确定删除此居民身体状况登记吗');">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <ul class="pagination">
                    <li><a href="#">«</a></li>
                    <li><a href="${pageContext.request.contextPath}/Healthlist">1</a></li>
                    <li><a class="active" href="${pageContext.request.contextPath}/HealthlistbyId?id=2">2</a></li>
                    <li><a href="${pageContext.request.contextPath}/HealthlistbyId?id=3">3</a></li>
                    <li><a href="${pageContext.request.contextPath}/HealthlistbyId?id=4">4</a></li>
                    <li><a href="${pageContext.request.contextPath}/HealthlistbyId?id=5">5</a></li>
                    <li><a href="${pageContext.request.contextPath}/HealthlistbyId?id=6">6</a></li>
                    <li><a href="${pageContext.request.contextPath}/HealthlistbyId?id=7">7</a></li>
                    <li><a href="#">»</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
</div>
</div>


<footer>
    <hr>
    <p>&copy; 社区居民医疗管理系统</p>
</footer>

</div>
</div>
</div>


<script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
    $("[rel=tooltip]").tooltip();
    $(function () {
        $('.demo-cancel-click').click(function () {
            return false;
        });
    });
</script>

</body>
</html>


