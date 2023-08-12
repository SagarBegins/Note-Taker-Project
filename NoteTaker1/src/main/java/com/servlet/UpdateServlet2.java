package com.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int noteId = Integer.parseInt(request.getParameter("noteId").trim());
			
			Session se = FactoryProvider.getFactory().openSession();
			Transaction tx = se.beginTransaction();
			
			Note note = se.get(Note.class,noteId);
			note.setTitle(title);
			note.setContent(content);
			note.setAdddate(new Date());
			tx.commit();

			se.close();
			response.sendRedirect("all_notes.jsp");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}