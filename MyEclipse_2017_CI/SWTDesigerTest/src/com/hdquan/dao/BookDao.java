package com.hdquan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.hdquan.pojo.Book;
import com.hdquan.pojo.User;
import com.hdquan.util.DbUtil;
import com.hdquan.util.StringUtil;

public class BookDao {
	User user =new User();
    public void addBook(Book book) throws Exception{
        Connection con = DbUtil.getCon();
        String sql="insert into book (ISBN, bookName, author, sex,category, uploaderName, uploaderPhone) "
        		+ "values(?,?,?,?,?,?,?)";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1, book.getISBN());
        psmt.setString(2, book.getBookName());
        psmt.setString(3, book.getAuthor());
        psmt.setString(4, User.getSex());
        psmt.setString(5, book.getCategory());
    	psmt.setString(6, User.getUserName());
    	psmt.setString(7, User.getUserPhone());
        psmt.execute();

    }
    public void updateBook(String bookName) throws Exception{
        Connection con = DbUtil.getCon();
        String sql="update book set book.BorrowerName=?,book.BorrowerPhone=? where book.bookName=?";      
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1, User.getUserName());
        psmt.setString(2, User.getUserPhone());
        psmt.setString(3, bookName);
        System.out.println(User.getUserName());
        psmt.execute();
    }
    public void updateBook1() throws Exception{
        Connection con = DbUtil.getCon();
        String sql="update book,borrowerbook set book.BorrowerName=? where book.bookName=borrowerbook.bookName";      
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1, null);
        System.out.println(User.getUserName());
        psmt.execute();
    }
    public void updateBook2(String Id) throws Exception{
        Connection con = DbUtil.getCon();
        String sql="update book,borrowerbook set book.BorrowerName=? where Id=?";      
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1, User.getUserName());
        psmt.setString(2, Id);
        System.out.println(User.getUserName());
        psmt.execute();
    }
    public void addBorrowerBook(String Bookname)
    {	
    	try {
			Connection con = DbUtil.getCon();
			 String sql="insert into borrowerbook (bookName,BorrowerName,BorrowerPhone) values (?,?,?)";
			   PreparedStatement psmt = con.prepareStatement(sql);
			   psmt.setString(1, Bookname);
			   psmt.setString(2, User.getUserName());
			   psmt.setString(3, User.getUserPhone());
			   psmt.execute();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }
      public static void delBook(Book  book) throws SQLException{
          Connection con=null;
		try {
			con = DbUtil.getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
          String sql="" + 
                  "DELETE FROM book "+          
                  "WHERE id=?";
          PreparedStatement psmt = con.prepareStatement(sql);
          psmt.setString(1,book.getId());
          System.out.println(book.getId());
          psmt.execute();    
      }
    public static void changeBook(Book book) throws SQLException{
        Connection con=null;
		try {
			con = DbUtil.getCon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String sql="update book "
        		+ "set ISBN = ?, bookName = ?, author = ?"
                + ", category = ? where Id=?";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1, book.getISBN());
        psmt.setString(2, book.getBookName());
        psmt.setString(3, book.getAuthor());
        psmt.setString(4, book.getCategory());
        psmt.setString(5, book.getId());
        psmt.execute();    
    }
	public static List<Book> query() throws Exception{	       
		Connection con = DbUtil.getCon();	        
		Statement stmt = con.createStatement();	     
		String sql="select Id,ISBN, bookName, author, category, uploaderName, uploaderPhone,"
				+" BorrowerName, BorrowerPhone"
				+ " from book";
		ResultSet rs = stmt.executeQuery(sql);	      
		List<Book> bookList = new ArrayList<Book>();	       
		Book book = null;	   
		while (rs.next()){	           
			book = new Book();	  
			book.setId(rs.getString("Id"));
			book.setISBN(rs.getString("ISBN"));
			book.setBookName(rs.getString("bookName"));	       
			book.setAuthor(rs.getString("author"));
			book.setCategory(rs.getString("category"));
			book.setUploaderName(rs.getString("uploaderName"));
			book.setUploaderPhone(rs.getString("uploaderPhone"));
			book.setBorrowerName(rs.getString("BorrowerName"));
			book.setBorrowerPhone(rs.getString("BorrowerPhone"));
			bookList.add(book);	        
		}	       
		return bookList;	  
	}
	public static List<Book> borrowQuery() throws Exception{	       
		Connection con = DbUtil.getCon();	        
		Statement stmt = con.createStatement();	       
		ResultSet rs = stmt.executeQuery(""
				+ "SELECT ID, bookName, BorrowerName, BorrowerPhone "
				+ "FROM borrowerbook "
				);	      
		List<Book> bookList = new ArrayList<Book>();	       
		Book book = null;	     
		while (rs.next()){	           
			book = new Book();	     
			book.setId(rs.getString(1));
			book.setBookName(rs.getString(2));	       
			book.setBorrowerName(rs.getString(3));
			book.setBorrowerPhone(rs.getString(4));
			bookList.add(book);	        
		}	       
		return bookList;	  
	}
	public static List<Book> borrowQuery1() throws Exception{	       
		Connection con = DbUtil.getCon();	        
		Statement stmt = con.createStatement();	       
		ResultSet rs = stmt.executeQuery(""
				+ "select borrowerbook.ID, borrowerbook.bookName, borrowerbook.BorrowerName, borrowerbook.BorrowerPhone "
				+ "FROM borrowerbook,book "
				+ "where book.bookName=borrowerbook.bookName"
				);	      
		List<Book> bookList = new ArrayList<Book>();	       
		Book book = null;	     
		while (rs.next()){	           
			book = new Book();	     
			book.setId(rs.getString(1));
			book.setBookName(rs.getString(2));	       
			book.setBorrowerName(rs.getString(3));
			book.setBorrowerPhone(rs.getString(4));
			bookList.add(book);	        
		}	       
		return bookList;	  
	}
	
	
    public void returnBook(Book book) throws SQLException{
        Connection con=null;
		try {
			con = DbUtil.getCon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String sql="DELETE FROM borrowerbook WHERE ID = ?";
        PreparedStatement psmt = con.prepareStatement(sql);
//        System.out.println(sql.toString());
//		System.out.println(book.getId());
        psmt.setString(1, book.getId());
        psmt.execute();    
    }

    public static List<Book> bookList()throws Exception{
        Connection con=null;
 		try {
 			con = DbUtil.getCon();
 		} catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}        
		Statement stmt = con.createStatement();	       
		ResultSet rs = stmt.executeQuery("select ISBN,bookName,author,category,Id"+" from book");
		List<Book> bookList = new ArrayList<Book>();	       
		Book book = null;	     
		while (rs.next()){	           
			book = new Book();	     
			book.setISBN(rs.getString(1));
			book.setBookName(rs.getString(2));	       
			book.setAuthor(rs.getString(3));
			book.setCategory(rs.getString(4));
			book.setId(rs.getString(5));
			bookList.add(book);	        
		}	       
		return bookList;
    }
    
    public ResultSet bookList(Book book)throws Exception{
        Connection con=null;
 		try {
 			con = DbUtil.getCon();
 		} catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
		StringBuffer sb=new StringBuffer("select ISBN,bookName,author,category,uploaderPhone,uploaderName,BorrowerPhone,BorrowerName,Id"+" from book");
		if(StringUtil.isNotEmpty(book.getBookName())){
			sb.append(" where bookName like '%"+book.getBookName()+"%'");
			if(StringUtil.isNotEmpty(book.getAuthor())){
				sb.append(" and author like '%"+book.getAuthor()+"%'");
			}
			if(StringUtil.isNotEmpty(book.getCategory())){
				sb.append(" and category = "+book.getCategory());
			}
			if(StringUtil.isNotEmpty(book.getUploaderName())){
				sb.append(" and uploaderName = "+book.getUploaderName());
			}
		}
		
		else if(StringUtil.isNotEmpty(book.getAuthor())){
				sb.append(" where author like '%"+book.getAuthor()+"%'");
			if(StringUtil.isNotEmpty(book.getBookName())){
					sb.append(" and bookName like '%"+book.getBookName()+"%'");	}
			if(StringUtil.isNotEmpty(book.getCategory())){
				sb.append(" and category = "+book.getCategory());}
			if(StringUtil.isNotEmpty(book.getUploaderName())){
				sb.append(" and uploaderName = "+book.getUploaderName());
			}
					}
		else if(StringUtil.isNotEmpty(book.getCategory())){
			sb.append(" where category = "+book.getCategory());
		if(StringUtil.isNotEmpty(book.getAuthor())){
			sb.append(" and author like '%"+book.getAuthor()+"%'");}
		if(StringUtil.isNotEmpty(book.getBookName())){
				sb.append(" and bookName like '%"+book.getBookName()+"%'");}	
		if(StringUtil.isNotEmpty(book.getUploaderName())){
			sb.append(" and uploaderName = "+book.getUploaderName());
								}
		}
		else if(StringUtil.isNotEmpty(book.getUploaderName())){
			sb.append(" where uploaderName = "+book.getUploaderName());
		if(StringUtil.isNotEmpty(book.getCategory())){
			sb.append(" and category = "+book.getCategory());}
		if(StringUtil.isNotEmpty(book.getAuthor())){
			sb.append(" and author like '%"+book.getAuthor()+"%'");}
		if(StringUtil.isNotEmpty(book.getBookName())){
				sb.append(" and bookName like '%"+book.getBookName()+"%'");}	
		}
		
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		System.out.println(sb.toString());
		return pstmt.executeQuery();
	}
    
}
