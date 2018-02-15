package com.nit.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.dto.ProductDTO;
import com.nit.service.ProductService;
import com.nit.service.ProductServiceImpl;

@WebServlet("/insert")
public class InsertProductController extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html");

		// capture form data
		String pname = req.getParameter("pname");
		String price = req.getParameter("price");
		String quantity = req.getParameter("quantity");

		// convert data to Dto object
		ProductDTO dto = new ProductDTO();
		dto.setPname(pname);
		dto.setQuantity(Integer.parseInt(quantity));
		dto.setPrice(Double.parseDouble(price));

		// call service layer method using dto object
		ProductService service = new ProductServiceImpl();
		Serializable id = service.insert(dto);

		// based on service method return type display success|failure msg
		if (null != id && !"".equals(id)) {
			// success msg
			req.setAttribute("succMsg", "Product Inserted with pid as:" + id);
		} else {
			// failure msg
			req.setAttribute("errMsg", "Failed to insert record");
		}

		// Redirect the user to same page
		RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
		rd.forward(req, resp);
	}

}