package com.product.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.product.entity.ProductDTO;
import com.product.service.ProductService;
import com.product.service.ProductServiceImpl;

@MultipartConfig
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String err;
	String succ;
    public InsertServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try{
		ProductDTO product=new ProductDTO();
		ProductService service=new ProductServiceImpl();
      
		String name=request.getParameter("t1");
		String price=request.getParameter("t2");
		String quan=request.getParameter("t3");
		  
		         
		Serializable ser=null;
		if(!"".equals(name)&&!"".equals(price)&&!"".equals(quan)){
		
			product.setpName(name);
		product.setpPrice(Double.parseDouble(price));
		product.setQuan(Integer.parseInt(quan));
		if(UploadServlet.b==null){
			err="Photo not uploaded";
		}
		product.setPhoto(UploadServlet.b);
		ser=service.insertProduct(product);
		}
		if(ser==null){
			err="Product insertion failed";
			request.setAttribute("err", err);
		}else{
			succ="Product inserted successfull\nId="+ser;
			request.setAttribute("succ", succ);
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		 } catch(Exception ex) {
	            System.out.println(ex);
	         }
	}

}
