package com.product.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.product.entity.ProductEntity;
import com.product.util.ProductUtil;

public class ViewPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewPhotoServlet() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		
		Integer pid=Integer.parseInt(request.getParameter("pid"));
		Session hs=ProductUtil.gestSF().openSession();
		ProductEntity pe=hs.get(ProductEntity.class, pid);
		
	byte[] b=pe.getPhoto();
	BufferedInputStream bis=null;
	BufferedOutputStream bos=null;
	try{
		bis=new BufferedInputStream(new ByteArrayInputStream(b));
		bos=new BufferedOutputStream(response.getOutputStream());
		byte[] buffer=new byte[b.length];
		int length;
		while((length=bis.read(buffer))>0)
		bos.write(buffer, 0, length);
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(bis!=null)
			bis.close();
		if(bos!=null)
			bos.close();
	}


		
		
		request.getRequestDispatcher("./viewPhoto.jsp");
	}

	
}
