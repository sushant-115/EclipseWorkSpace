package com.messaging.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CaptchaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     public CaptchaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Max-Age", 0);
	
	BufferedImage image=new BufferedImage(120, 30, BufferedImage.TYPE_INT_RGB);
	Graphics2D graphics2D=image.createGraphics();
	Hashtable map=new Hashtable();
	Random r=new Random();
	String token=Long.toString(Math.abs(r.nextLong()),36);
	String ch=token.substring(0, 6);
	Color c=new Color(0.662f,0.4569f, 0.3232f);
	GradientPaint gp=new GradientPaint(30, 30, c, 15, 25, Color.white,true);
	graphics2D.setPaint(gp);
	Font font =new Font("Verdana",Font.CENTER_BASELINE,26);
	graphics2D.setFont(font);
	graphics2D.drawString(ch, 2, 20);
	graphics2D.dispose();
	
	HttpSession session=request.getSession(true);
	session.setAttribute("CAPTCHA_KEY", ch);
	
	BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
	ImageIO.write(image,"jpeg", bos);
	bos.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
