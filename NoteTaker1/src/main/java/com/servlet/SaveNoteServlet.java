package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class SaveNoteServlet
 */
public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		Note nt = new Note(title,content, new Date());
		
		Session s=FactoryProvider.getFactory().openSession();
		Transaction tx=s.beginTransaction();

		s.save(nt);
		tx.commit();
		s.close();
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<h1>Notes Successfully Added</h1>");
		out.println("<a href='all_notes.jsp'>View All notes</a>");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

}