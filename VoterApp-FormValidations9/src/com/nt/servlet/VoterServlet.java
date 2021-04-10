//VoterServlet.java
package com.nt.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet
{
	public  void process(HttpServletRequest req,
		                                    HttpServletResponse res)throws ServletException,IOException
	{  PrintWriter pw=null;
	   String name=null,page=null;
	   int age=0;
	   List<String> listErrors=new ArrayList<String>();
	   String vstatus=null;
	   
	   System.out.println("VoterServlet:process(-,-) method");
		//get PrintWriter
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read form data
		name=req.getParameter("pname");
		page=req.getParameter("page");
		
		//read vflag value to know wheather client side form validations are done or not done
		vstatus=req.getParameter("vflag");
		
	if(vstatus.equalsIgnoreCase("no")){
		  //write SErver Side form validation logic
		  if(name==null || name.length()==0 || name.equals("")){ //required rule
			listErrors.add("<p style='color:red'> name is required </p>");
		}
		
		 System.out.println("Server side form validations....."); 
		 if(page==null || page.equals("") || page.length()==0){ //required rule
			listErrors.add("<p style='color:red'> age is required </p>");
		}
		else{  //To check wheather age is numeric value or not
			try{
				age=Integer.parseInt(page);
				if(age<=0 || age>150){
				 listErrors.add("<p style='color:red'> age must be in the range of 1-150  </p>");
				}//if
			}//try
			catch(NumberFormatException nfe){
				nfe.printStackTrace();
				listErrors.add("<p style='color:red'> Person age must be numeric value </p>");
			}//catch
		}//else
		//Display form validation Error Messages
		if(listErrors.size()!=0){
		    for(String msg:listErrors)
		    	pw.println(msg);
		    //add hyperlink
		    pw.println("<a href='input.html'>home</a>");
		    return;
		}//if 
	}//if
	else{
		age=Integer.parseInt(page);
	}
			
		//write request processing logic(b.logic)
		if(age>=18)
			pw.println("<h1 style='color:green'>"+name+
			                       " u  r elgible to vote </h1>");
		else
			pw.println("<h1 style='color:red'>"+name+
			                      " u  r not elgible to vote </h1>");
       //add graphical hyperlink
	   pw.println("<a href='input.html'><img src='james.png' width='100' height='100'/></a>");
	   //close stream
	   pw.close();
	}//process(-,-)
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("VoterServlet:doGet(-,-) method");
		  process(req,res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("VoterServlet:doPost(-,-) method");
		 process(req,res);
	}
}//class

