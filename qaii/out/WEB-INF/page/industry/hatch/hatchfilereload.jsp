<!DOCTYPE html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>科研成果管理系统</title>
  <link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/layui.css">
  <link rel="stylesheet" href="${basePath}/css/layuiAdd.css">
  <script src="${basePath}/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<form action="updateLicense.do" method="post" enctype="multipart/form-data">
    <input type="file" name="file" id="path">
    <input type="hidden" name="fid" id="fid" value="${requestScope.Info[0]}">
    <input type="hidden" name="nid" id="nid" value="${requestScope.Info[1]}">
    <input type="hidden" name="type" id="imgtype2" value="License">

<%--<input type="hidden" name="style" id="style" value="${requestScope.utflist[2]}">--%>
  <%--<input type="hidden" name="tid" id="tid" value="${requestScope.utflist[3]}">--%>
  <input type="submit" style="float:right;" class="layui-btn layui-btn-xs" value="上传文件"></input>
</form>

</body>
</html>