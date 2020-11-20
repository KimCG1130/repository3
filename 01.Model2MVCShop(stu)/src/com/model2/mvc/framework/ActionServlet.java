package com.model2.mvc.framework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.common.util.HttpUtil;


public class ActionServlet extends HttpServlet {
	
	private RequestMapping mapper;

	@Override
	public void init() throws ServletException {
		super.init();
		
		String resources=getServletConfig().getInitParameter("resources"); //meta-data ������
		mapper=RequestMapping.getInstance(resources); //properties ������ �Ľ��� 
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
														throws ServletException, IOException {
		
		System.out.println("[ service �޼ҵ� ���� ]"); //�ܼ� �����
		
		
		String url = request.getRequestURI(); // ������Ʈ ���� getRequestURI : '/getUser.jsp',product�� ����� ������� ��������
		String contextPath = request.getContextPath(); // ������Ʈ ���� Context path : '/'
		String path = url.substring(contextPath.length()); // �Ľ�
		System.out.println("path : "  + path); // �ּ� ������ => � Action ����Ǵ��� Ȯ��
		
		try{ 
			Action action = mapper.getAction(path);
			action.setServletContext(getServletContext());
			
			String resultPage=action.execute(request, response);//���� ���� �޽��� �ߴ°�
			String result=resultPage.substring(resultPage.indexOf(":")+1);
			
			if(resultPage.startsWith("forward:"))
				HttpUtil.forward(request, response, result);
			else
				HttpUtil.redirect(response, result);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		System.out.println("[ service �޼ҵ� �� ]"); // �����
	}
}