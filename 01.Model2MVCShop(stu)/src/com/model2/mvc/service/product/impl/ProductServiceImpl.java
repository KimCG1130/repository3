package com.model2.mvc.service.product.impl;

import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.dao.ProductDAO;
import com.model2.mvc.service.product.vo.ProductVO;

public class ProductServiceImpl implements ProductService{

	private ProductDAO productDAO;

	public ProductServiceImpl() { // ������
		productDAO = new ProductDAO();
	}

	public void addProduct(ProductVO productVO) throws Exception {
		productDAO.insertProduct(productVO);
	}

	/*public ProductVO loginProduct(ProductVO productVO) throws Exception {
		ProductVO dbProduct = productDAO.findProduct(productVO.getProductId());

		if (!dbProduct.getPassword().equals(productVO.getPassword()))
			throw new Exception("�α��ο� �����߽��ϴ�.");

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


	// ���̵� �ߺ� üũ 
	/*public boolean checkDuplication(String productId) throws Exception {
		boolean result = true; // �ߺ� �ƴ� 
		ProductVO productVO = productDAO.findProduct(productId);
		if (productVO != null) { // productId�� �ش��ϴ� productVO�� ������ 
			result = false; // �ߺ��̶�� �� 
		}
		return result;
	}*/
}