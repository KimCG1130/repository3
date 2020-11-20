package com.model2.mvc.service.user;

import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.service.user.vo.UserVO;

/*
 	< Business Logic Layer 의 모듈화 >
 	: Persistence layer (Dao) / service layer (Service, Serviceimpl) 를 구별해서 개발
 	
 	
 */
public interface UserService {

	public void addUser(UserVO userVO) throws Exception;

	public UserVO loginUser(UserVO userVO) throws Exception;

	public UserVO getUser(String userId) throws Exception;

	public HashMap<String, Object> getUserList(SearchVO searchVO) throws Exception;

	public void updateUser(UserVO userVO) throws Exception;

	public boolean checkDuplication(String userId) throws Exception;

}