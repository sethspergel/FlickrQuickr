package com.sethsoft.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sethsoft.flickr.PhotoList;

/**
 * Servlet implementation class FlickrQuickrServlet
 */
@WebServlet(description = "main servlet for handling requests", urlPatterns = { "/FlickrQuickrServlet" })
public class FlickrQuickrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// set the default address to forward to, assuming nothing goes wrong
		String address = "/allThumbs.jsp";
		try{
		request.setAttribute("photoList", PhotoList.getPhotoList());
	
		}
		catch (Exception e)
		{
			address = "/errorNotice.jsp";
			request.setAttribute("error", e.getMessage());
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request,response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//pass this along to doGet and let it handle all the logic in case someone wants to use GET params instead of POST
		doGet(request, response);
	}

}
