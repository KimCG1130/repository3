<%@ page contentType="text/html; charset=EUC-KR" %>

<html>
<head>

<title>열어본 상품 보기</title>

</head>
<body>
	열어본 상품목록 번호(쿠키)
<br>
<br>
<%
	request.setCharacterEncoding("euc-kr");
	response.setCharacterEncoding("euc-kr");//요청하고 받는 문자열 엔코딩(한글)
	String history = null;
	Cookie[] cookies = request.getCookies();
	if (cookies!=null && cookies.length > 0) {//쿠키내용이없을경우 도메인길이만큼 포문 실행
		out.println("쿠키가 존재합니다.");
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if (cookie.getName().equals("history")) {
				out.println("히스토리에 쿠키값을 집어넣습니다.");
				history = cookie.getValue();//쿠키의 값을 history에 저장
			}
		}
		if (history != null) {//history 값이 빈 값(null)이 아닐경우
			String[] h = history.split(",");//(콤마로 스플릿 파싱)
			for (int i = 0; i < h.length; i++) {
				if (!h[i].equals("null")) {
%>
<a href="/getProduct.do?prodNo=<%=h[i]%>&menu=search"	target="rightFrame"><%=h[i]%></a>
<br>
<%
				}
			}
		}
	}else{
		out.println("");
	}
%>

</body>
</html>

<!-- CookieGenerator cg = new CookieGenerator();

cg.setCookieName("쿠키이름");
cg.addCookie(response, 값); -->

