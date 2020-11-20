package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;


public class UpdateProductAction extends Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		
		System.out.println("UpdateProduct �׼� ���� ");
		int prodNo=(Integer.parseInt(request.getParameter("prodNo")));
		
		ProductVO productVO=new ProductVO();
		System.out.println("UpdateProductAction ���� ��1 ");
		productVO.setProdName(request.getParameter("prodName"));
		productVO.setProdDetail(request.getParameter("prodDetail"));
		productVO.setManuDate(request.getParameter("manuDate"));
		productVO.setPrice(Integer.parseInt(request.getParameter("price")));
		productVO.setFileName(request.getParameter("fileName"));
		
		System.out.println("UpdateProductAction ���� ��2");
		
		ProductService service=new ProductServiceImpl();
		service.updateProduct(productVO);
		
		System.out.println("UpdateProductAction ���� ��3 ");
		
		HttpSession session=request.getSession();
		System.out.println("UpdateProductAction ���� ��4 ");
		int sessionNo=((ProductVO)session.getAttribute("product")).getProdNo();//?
		System.out.println("UpdateProductAction ���� ��5 ");
		
	
		if(sessionNo==prodNo){ 
			session.setAttribute("product", productVO);
		}
		System.out.println("UpdateProductAction ���� ��6 ");
		
		return "redirect:/getProduct.do?prodNo="+prodNo;
	}
}