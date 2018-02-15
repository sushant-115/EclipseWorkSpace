package com.nit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.dto.ProductDTO;
import com.nit.service.ProductService;
import com.nit.service.ProductServiceImpl;

@WebServlet("/viewProducts")
public class ViewProductDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ProductService service = new ProductServiceImpl();

		Integer currPageNo = 1;
		Integer pageSize = 3;

		String str = request.getParameter("pageNo");
		if (null != str && !"".equals(str)) {
			currPageNo = Integer.parseInt(str);
		}
		// getting total records count
		Long totRecords = service.getRecordsCnt();
		System.out.println("Total Records : " + totRecords);
		Long totalPages = (totRecords / pageSize)
				+ ((totRecords % pageSize) > 0 ? 1 : 0);
		System.out.println("Total pages:" + totalPages);

		request.setAttribute("totalPages", totalPages);

		List<ProductDTO> pDtos = service.retrieve(currPageNo, pageSize);

		
		request.setAttribute("currPageNo", currPageNo);
		
		// send data to jsp
		request.setAttribute("products", pDtos);

		request.getRequestDispatcher("viewProducts.jsp").forward(request,
				response);

	}

}
