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
<form action="reloadAwardCollegeFile.do" method="post" enctype="multipart/form-data">
  <input type="file" name="file" id="path">
  <input type="hidden" name="id" id="id" value="${param.id}">
  <input type="hidden" name="fid" id="fid" value="${param.fid}">
  <input type="hidden" name="fpath" id="fpath" value="${param.fpath}">
  <input type="submit" style="float:right;" class="layui-btn layui-btn-xs" value="上传文件"></input>
</form>

</body>
</html>