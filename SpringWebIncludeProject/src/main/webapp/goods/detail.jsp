<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let bclick=true
$(function(){
	// span태그 클릭
	$('.rgupdates').click(function(){
		$('.rgups').hide();
		let rgno=$(this).attr("data-rgno")
		if(bclick==true)
		{
			bclick=false;
			$(this).text("취소")
			$('#rgu'+rgno).show()
		}
		else
		{
			bclick=true;
			$(this).text("수정")
			$('#rgu'+rgno).hide()
		}
	})
})
</script>
</head>
<body>
  <div class="container">
    <div class="row">
      <table class="table">
        <tr>
          <td width=30% class="text-center" rowspan="3">
            <img src="${vo.goods_poster }" style="width:290px;height:400px">
          </td>
          <td colspan="2">
            <h2 style="font-weight:bold">${vo.goods_name }</h2>
            <h3 style="color:gray">${vo.goods_sub }</h3>
          </td>
        </tr>
        <tr>
        <th width=20% class="text-right">가격</th>
          <td width=50%>
            <h4 style="text-decoration:line-through">${vo.goods_price }</h4>
		    <h2 style="color:orange">${vo.goods_discount }%&nbsp;${vo.goods_first_price }</h2>
          </td>
        </tr>
        <tr>
          <th width=20% class="text-right">배송</th>
          <td width=50%>${vo.goods_delivery }</td>
        </tr>
        <tr>
          <td colspan="3" class="text-right">
            <a href="javascript:history.back()" class="btn btn-xs btn-primary">목록</a>
          </td>
        </tr>
      </table>
    </div>
    <div style="height:20px"></div>
    <div class="col-sm-8">
      <table class="table">
        <tr>
          <td>
            <c:forEach var="rgvo" items="${rgList }">
              <table class="table">
                <tr>
                  <td class="text-left">◑${rgvo.name }(${rgvo.dbday })</td>
                  <td class="text-right">
                    <c:if test="${rgvo.id==sessionScope.id }">
                      <span class="btn btn-xs btn-info rgupdates" data-rgno="${rgvo.gno }">수정</span>
                      <a href="../greply/greply_delete.do?gno=${rgvo.gno }&no=${vo.no}" class="btn btn-xs btn-success">삭제</a>
                    </c:if>
                  </td>
                </tr>
                <tr>
                  <td colspan="2" class="text-left" valign="top">
                    <pre style="white-space:pre;border: none;background-color: white;">${rgvo.msg }</pre>
                  </td>
                </tr>
                <tr style="display:none" id="rgu${rgvo.gno }" class="rgups">
                  <td colspan="2">
                    <form method="post" action="../greply/greply_update.do">
		              <input type=hidden name="no" value="${vo.no }">
		              <input type=hidden name="gno" value="${rgvo.gno }">
		              <textarea rows="4" cols="60" name="msg" style="float: left">${rgvo.msg }</textarea>
		              <button class="btn-primary" style="width:100px;height:105px;float:left">댓글수정</button>
		            </form>
                  </td>
                </tr>
              </table>
            </c:forEach>
          </td>
        </tr>
      </table>
      <c:if test="${sessionScope.id!=null }">
      <table class="table">
        <tr>
          <td>
            <form method="post" action="../greply/greply_insert.do">
              <input type=hidden name="no" value="${vo.no }">
              <textarea rows="4" cols="65" name="msg" style="float: left"></textarea>
              <button class="btn-primary" style="width:100px;height:105px;float:left">댓글쓰기</button>
            </form>
          </td>
        </tr>
      </table>
      </c:if>
    </div>
  </div>
</body>
</html>