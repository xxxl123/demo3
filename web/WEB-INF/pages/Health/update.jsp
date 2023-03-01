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

        <h1 class="page-title">修改社区居民身体状况</h1>
    </div>

    <ul class="breadcrumb">
        <li><a href="#">社区居民身体状况信息管理</a> <span class="divider">/</span></li>
        <li class="active">修改社区居民身体状况</li>
    </ul>

    <div class="container-fluid">
        <div class="row-fluid">


            <div class="row-fluid">
                <h3 style="color: red">
                    <c:if test="${not empty msg}">
                        修改社区居民
                    </c:if>

                </h3>

                <ul class="nav nav-tabs">
                </ul>
                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane active in" id="home">
                        <form id="tab" action="${pageContext.request.contextPath}/Healthupdate" method="post">

                            <input type="hidden" name="id" value="${v.id}"/>
                            <input type="hidden" name="times" value="${v.times}"/>

                            <label>居民id</label>
                            <input type="text" readonly class="input-xlarge" name="userid" value="${v.userid}">

                            <br/>
                            <label>选择身体状况</label>
                            <select class="input-xlarge" name="msg">
                                <option
                                        <c:if test="${v.msg eq '身体正常'}">selected</c:if> >身体正常
                                </option>
                                <option
                                        <c:if test="${v.msg eq '身体异样'}">selected</c:if>  >身体异样
                                </option>
                                <option
                                        <c:if test="${v.msg eq '其他'}">selected</c:if>  >其他
                                </option>
                            </select>


                            <br/> <br/>
                            <input type="submit" value="修改" class="btn btn-success">
                        </form>
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


