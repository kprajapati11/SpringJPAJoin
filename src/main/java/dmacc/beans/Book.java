package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	private Long bookIsbn;
	private String bookName;
	private String bookAuthor;
	
	public Book() {
		super();
	}

	public Book(Long bookIsbn,String bookName, String bookAuthor) {
		this.bookIsbn = bookIsbn;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;

	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Long getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(Long bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	/*
	 * public List<Borrower> getBorrowerList() { return borrowerList; }
	 * 
	 * public void setBorrowerList(List<Borrower> borrowerList) { this.borrowerList
	 * = borrowerList; }
	 * 
	 */

	
	
}
