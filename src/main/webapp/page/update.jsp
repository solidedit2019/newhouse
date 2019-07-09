<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 -发布房屋信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514">
  <script language="JavaScript" src="../admin/js/jquery-1.8.3.js"></script>
  <script language="JavaScript" src="../admin/js/jquery.form.js"></script>

  <script language="JavaScript">
      $(function () {
          $("#district_id").change(function () {
              var did = $(this).val();
              $.post("getStreetByDid", {id: did}, function (data) {
                  $("#street_id>option").remove();
                  for (var i = 0; i < data.length; i++) {
                      var opt = $("<option value=" + data[i].id + ">" + data[i].name + "</option>");
                      $("#street_id").append(opt);
                  }

              }, "json")
          });

          var did = $("#district_id").val();
          var sname=$("#sname").val();
          $.post("getStreetByDid", {id: did}, function (data) {
              $("#street_id>option").remove();
              for (var i = 0; i < data.length; i++) {
                  var opt = $("<option  value=" + data[i].id + ">" + data[i].name + "</option>");
                  var opt1 = $("<option selected value=" + data[i].id + ">" + data[i].name + "</option>");
                  if(data[i].name==sname){
                      $("#street_id").append(opt1);

                  }else {
                      $("#street_id").append(opt);
                  }


              }

          }, "json");


          $("#pfile").change(function () {
              $("#update_action").ajaxSubmit({
                  url:"getpic",
                  type:"post",
                  success:function (data) {
                      $("#path").val(data);
                      $("#img").attr("src","http://localhost:80/"+data)
                  }

              })
          })

      });







  </script>
</HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>新房屋信息发布</DT>
  <DD class=past>填写房屋信息</DD></DL>
<DIV class=box>
<FORM id=update_action method=post name=add.action action=updateHouse enctype="multipart/form-data">

<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>标　　题：</TD>
    <TD><INPUT id=add_action_title class=text type=text name=title value="${house.title}"> </TD></TR>
  <TR>
    <TD class=field>户　　型：</TD>
    <TD><SELECT class=text name=typeId>
      <c:forEach items="${types}" var="t">
        <OPTION  value=${t.id}>${t.name}</OPTION>
      </c:forEach>
    </SELECT></TD></TR>
  <TR>
    <TD class=field>面　　积：</TD>
    <TD><INPUT id=add_action_floorage class=text type=text 
name=floorage value="${house.floorage}"></TD></TR>
  <TR>
    <TD class=field>价　　格：</TD>
    <TD><INPUT id=add_action_price class=text type=text name=price value="${house.price}"> </TD></TR>
  <TR>
    <TD class=field>发布日期：</TD>
    <TD><INPUT class=text type=date name=pubdate
               value=<fmt:formatDate value="${house.pubdate}" pattern="yyyy-MM-dd"/>
    ></TD></TR>
  <TR>
    <TD class=field>位　　置：</TD>
    <TD>区：<SELECT class=text name=district_id id="district_id">
      <c:forEach items="${allDistrict}" var="d">
        <OPTION
                <c:if test="${d.name==house.dname}">selected="selected"</c:if>
                value=${d.id}>${d.name}</OPTION>
      </c:forEach>

    </SELECT> 街：
      <SELECT class=text name=streetId id="street_id">

    </SELECT>
      <input type="hidden" id="sname" value="${house.sname}">
      <input type="hidden" name="id" value="${house.id}">
    </TD></TR>
  <TR>
    <TD class=field>联系方式：</TD>
    <TD><INPUT id=add_action_contact class=text type=text name=contact value="${house.contact}"></TD>
  </TR>
  <TR>
    <TD class=field ></TD>
    <TD><img  id="img" width="100px" height="75px" src="http://localhost:80/${house.path}"></TD>
  </TR>
  <TR>
    <TD class=field>修改图片：</TD>
    <TD><input type="file" id="pfile" name="pfile"></TD>
    <input type="hidden" name="path" id="path" value="${house.path}">

  </TR>


  <TR>
    <TD class=field>详细信息：</TD>
    <TD><TEXTAREA name=description>${house.description}</TEXTAREA></TD>
  </TR>
  </TBODY>
</TABLE>
  <DIV class=buttons>
    <INPUT  value="修  改" type="submit">
  <INPUT  value="返   回" type=button onclick="history.go(-1)"></DIV>
</DIV>
</FORM>
</DIV>
</DIV>
</DIV>
</BODY>

</HTML>