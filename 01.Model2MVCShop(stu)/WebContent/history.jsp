<%@ page contentType="text/html; charset=EUC-KR" %>

<html>
<head>

<title>��� ��ǰ ����</title>

</head>
<body>
	��� ��ǰ��� ��ȣ(��Ű)
<br>
<br>
<%
	request.setCharacterEncoding("euc-kr");
	response.setCharacterEncoding("euc-kr");//��û�ϰ� �޴� ���ڿ� ���ڵ�(�ѱ�)
	String history = null;
	Cookie[] cookies = request.getCookies();
	if (cookies!=null && cookies.length > 0) {//��Ű�����̾������ �����α��̸�ŭ ���� ����
		out.println("��Ű�� �����մϴ�.");
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if (cookie.getName().equals("history")) {
				out.println("�����丮�� ��Ű���� ����ֽ��ϴ�.");
				history = cookie.getValue();//��Ű�� ���� history�� ����
			}
		}
		if (history != null) {//history ���� �� ��(null)�� �ƴҰ��
			String[] h = history.split(",");//(�޸��� ���ø� �Ľ�)
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

cg.setCookieName("��Ű�̸�");
cg.addCookie(response, ��); -->

