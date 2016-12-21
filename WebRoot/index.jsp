<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<!--[if IE 8]> <html class="lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <title>博客首页</title>
    <meta name="description" content="Remodal example">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../static/dist/remodal.css">
    <link rel="stylesheet" href="../static/dist/remodal-default-theme.css">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link href="../static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="../static/bootstrap/js/jquery.min.js"></script>
    <script src="../static/bootstrap/js/bootstrap.min.js"></script>

    <style>
        hr{
           clear: both;
        }
        body{
            background-repeat: repeat;
            background-attachment: fixed;
            background-image: url("./static/xiaohuangren.jpg");
            height: 1000px;
        }
        .pagehead{
            opacity: 0.8;
            background-color: #FFFFFF;
            height: 70px;
            line-height: 70px;
        }
        #login_tip{
        	color: #761c19;
            font-size: medium;
        }
        .head_text{
        	display: block;
            font-size: 30px;
            float:right;
            margin-right: 15px;
            color: #000000;
        }
    </style>
</head>
<body>
<div class="remodal-bg pagehead">
	<c:if test="${user==null}"> <a href="#modal" class = "head_text">登陆</a><br></c:if>
    <c:if test="${user!=null}"> <div class = "head_text">欢迎,${user.name} <a style="font-size:15px" href="${pageContext.request.contextPath}/servlet/MainServlet?op=logoff">注销</a></div></c:if>  
</div>
<br/>
<div class="container">
    <div class="bg-info" style="height: 600px">
        这里是热门内容
    </div>
</div>
<div class="remodal" data-remodal-id="modal" role="dialog" aria-labelledby="modal1Title" aria-describedby="modal1Desc" data-remodal-options="closeOnConfirm: false">
    <button data-remodal-action="close" class="remodal-close" aria-label="Close"></button>
    <div>
        <h2 id="modal1Title">
        	登陆
        </h2>
        <form>
            <div class="form-group">
                <input type="text" class="form-control" id="username" placeholder="请输入你的用户名">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" id="password" placeholder="请输入你的密码">
            </div>
            <div id="login_tip"></div>
        </form>
    </div>
    <br>
    <button data-remodal-action="confirm" class="remodal-confirm" onclick="submit()">OK</button>
    <button data-remodal-action="cancel" class="remodal-cancel">Cancel</button>
</div>
<!-- You can define the global options -->
<script>
    function submit(){
        var inst = $('[data-remodal-id=modal]').remodal();
        var name = $('#username').val();
        var password = $('#password').val();
        $.post("${pageContext.request.contextPath}/servlet/MainServlet",{name:name,password:password},function(result){
            if(result=="0"){
            	$('#login_tip').html('用户名或密码错误');
            	return;
            }
            inst.close();
           location.href = "${pageContext.request.contextPath}/servlet/MainServlet";
        });
    }
</script>

<script src="../static/dist/jquery.min.js"></script>
<script src="../static/dist/remodal.js"></script>

<!-- Events -->
<script>
    $('[data-remodal-id=modal2]').remodal({
        modifier: 'with-red-theme'
    });
</script>
</body>
</html>
