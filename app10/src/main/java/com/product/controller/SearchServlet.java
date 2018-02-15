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

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String pName=request.getParameter("t4");
			ProductService service=new ProductServiceImpl();
			List<ProductDTO> plist=null;
			String err="Product Not Found::-"+pName;
			if(""!=pName){
			plist=service.searchProduct(pName);
			System.out.println(plist.size());
			if(plist.size()==0){
				request.setAttribute("err", err);
			}}
			else{
				err="Please some keyword";
			request.setAttribute("err", err);
			}
			if(null!=plist)
			request.setAttribute("plist", plist);
			
				
			request.getRequestDispatcher("./searchProduct.jsp").forward(request, response);
	}

}
