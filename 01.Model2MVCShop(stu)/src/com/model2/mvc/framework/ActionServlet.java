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
		
		String resources=getServletConfig().getInitParameter("resources"); //meta-data 가져옴
		mapper=RequestMapping.getInstance(resources); //properties 파일을 파싱함 
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
														throws ServletException, IOException {
		
		System.out.println("[ service 메소드 시작 ]"); //콘솔 디버깅
		
		
		String url = request.getRequestURI(); // 프로젝트 안의 getRequestURI : '/getUser.jsp',product도 비슷한 방식으로 가져오기
		String contextPath = request.getContextPath(); // 프로젝트 안의 Context path : '/'
		String path = url.substring(contextPath.length()); // 파싱
		System.out.println("path : "  + path); // 주소 가져옴 => 어떤 Action 실행되는지 확인
		
		try{ 
			Action action = mapper.getAction(path);
			action.setServletContext(getServletContext());
			
			String resultPage=action.execute(request, response);//현재 에러 메시지 뜨는곳
			String result=resultPage.substring(resultPage.indexOf(":")+1);
			
			if(resultPage.startsWith("forward:"))
				HttpUtil.forward(request, response, result);
			else
				HttpUtil.redirect(response, result);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		System.out.println("[ service 메소드 끝 ]"); // 디버깅
	}
}