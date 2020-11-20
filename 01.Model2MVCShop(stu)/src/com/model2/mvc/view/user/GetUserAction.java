package com.model2.mvc.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.impl.UserServiceImpl;
import com.model2.mvc.service.user.vo.UserVO;

public class GetUserAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("GetUser �׼� ���� ");
		String userId = request.getParameter("userId");

		UserService service = new UserServiceImpl();
		UserVO vo = service.getUser(userId); // ���̵� ������� ȸ������ ã�� 

		request.setAttribute("vo", vo); // request �� ���� 
		System.out.println("GetUser �׼� �� ");
		return "forward:/user/readUser.jsp";
	}
}