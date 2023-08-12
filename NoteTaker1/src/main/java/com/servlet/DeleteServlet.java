package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			 
			 int noteId=Integer.parseInt(req.getParameter("note_id").trim());
			 
			 Session s=FactoryProvider.getFactory().openSession();
			 Transaction tx=s.beginTransaction();
			 Note note=(Note)s.get(Note.class,noteId);
			 s.delete(note);
			 tx.commit();
			 s.close();
			 res.sendRedirect("all_notes.jsp");
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
	}

}
