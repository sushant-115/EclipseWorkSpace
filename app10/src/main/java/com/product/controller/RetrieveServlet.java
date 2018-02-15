package com.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.entity.ProductDTO;
import com.product.entity.ProductEntity;
import com.product.service.ProductService;
import com.product.service.ProductServiceImpl;
import com.product.util.ProductUtil;


public class RetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RetrieveServlet() {
        super();
           }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	ProductService service=new ProductServiceImpl();
	int start=1;
	int max=3;
	int currentPage=1;
	String str=request.getParameter("pageNo");
	if(null!=str&&!"".equals(str)){
		start=Integer.parseInt(str);
		currentPage=Integer.parseInt(str);
	}
	Long totalRecord=service.getResultCount();
	Integer pageRequired=(int) (totalRecord/max)+((totalRecord%max>0)?1:0);
	List<ProductDTO> pDto=service.retrieveProduct(start, max);
request.setAttribute("currentPage", currentPage);
	request.setAttribute("pDto", pDto);
	request.setAttribute("pageRequired",pageRequired);
	request.setAttribute("start", start);
request.getRequestDispatcher("./viewProduct.jsp").forward(request, response);
}


	
}
