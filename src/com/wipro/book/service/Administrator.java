package com.wipro.book.service;

import com.wipro.book.bean.BookBean;
import com.wipro.book.dao.BookDao;

public class Administrator {
	public String addBook(BookBean bookBean) {
		if(bookBean==null||bookBean.getBookName().equals("")||bookBean.getIsbn().equals("")||bookBean.getBookType()!='T'&&bookBean.getBookType()!='G'||bookBean.getCost()<=0||bookBean.getAuthor().getAuthorName()==null||bookBean.getAuthor().getAuthorName().equals("")){
			return "INVALID";
		}
		int res = new BookDao().createBook(bookBean);
		if(res == 1){
			return "SUCCESS";
			
		}
		else{
			return "FAILURE";
		}
	}
	public BookBean viewBook(String isbn) {
		if(isbn.equals(""))
			return null;
		return new BookDao().fetchBook(isbn);
	}
}
