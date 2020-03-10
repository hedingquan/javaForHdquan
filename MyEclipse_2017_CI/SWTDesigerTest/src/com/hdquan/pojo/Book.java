package com.hdquan.pojo;

public class Book {

	private String ISBN;
	private String bookName;
	private String author;
	private String sex;
	private String category;
	private String BorrowerName;
	private String uploaderPhone;
	private String uploaderName;
	private String BorrowerPhone;
	private String Id;
	public String getUploaderPhone() {
		return uploaderPhone;
	}
	public void setUploaderPhone(String uploaderPhone) {
		this.uploaderPhone = uploaderPhone;
	}
	public String getUploaderName() {
		return uploaderName;
	}
	public void setUploaderName(String uploaderName) {
		this.uploaderName = uploaderName;
	}
	public String getId() {
		return Id;
	}
	public void setId(String i) {
		Id = i;
	}
	public Book() {
		super();
	}
	public Book(String bookName, String author, String sex, float price,
			String bookDesc, int bookTypeId) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.sex = sex;
	}
	
	
	public Book(String ISBN, String bookName, String author, String sex,
			float price, String bookDesc, int bookTypeId) {
		super();
		this.ISBN = ISBN;
		this.bookName = bookName;
		this.author = author;
		this.sex = sex;
	}
	public Book(String bookName, String author, String sex, int bookTypeId) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.sex = sex;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBorrowerName() {
		return BorrowerName;
	}
	public void setBorrowerName(String borrowerName) {
		BorrowerName = borrowerName;
	}
	public String getBorrowerPhone() {
		return BorrowerPhone;
	}
	public void setBorrowerPhone(String BorrowerPhone) {
		this.BorrowerPhone = BorrowerPhone;
	}
	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", bookName=" + bookName + ", author=" + author + ", sex="
				+ sex + ", category=" + category + ", bookTypeId="
				+ ", BorrowerName=" + BorrowerName + ", uploaderPhone=" + uploaderPhone + ", uploaderName="
				+ uploaderName + ", BorrowerPhone=" + BorrowerPhone + ", Id=" + Id + "]";
	}
	
	
}
