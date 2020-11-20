package com.model2.mvc.service.product.impl;

import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.dao.ProductDAO;
import com.model2.mvc.service.product.vo.ProductVO;

public class ProductServiceImpl implements ProductService{

	private ProductDAO productDAO;

	public ProductServiceImpl() { // 생성자
		productDAO = new ProductDAO();
	}

	public void addProduct(ProductVO productVO) throws Exception {
		productDAO.insertProduct(productVO);
	}

	/*public ProductVO loginProduct(ProductVO productVO) throws Exception {
		ProductVO dbProduct = productDAO.findProduct(productVO.getProductId());

		if (!dbProduct.getPassword().equals(productVO.getPassword()))
			throw new Exception("로그인에 실패했습니다.");

		return dbProduct;
	}
*/
	public ProductVO getProduct(int prodNo) throws Exception {
		return productDAO.findProduct(prodNo);
	}
	

	public HashMap<String, Object> getProductList(SearchVO searchVO) throws Exception {
		return productDAO.getProductList(searchVO);
	}

	public void updateProduct(ProductVO productVO) throws Exception {
		productDAO.updateProduct(productVO);
	}


	// 아이디 중복 체크 
	/*public boolean checkDuplication(String productId) throws Exception {
		boolean result = true; // 중복 아님 
		ProductVO productVO = productDAO.findProduct(productId);
		if (productVO != null) { // productId에 해당하는 productVO가 있으면 
			result = false; // 중복이라는 것 
		}
		return result;
	}*/
}