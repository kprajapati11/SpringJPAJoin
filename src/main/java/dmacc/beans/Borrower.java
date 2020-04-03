package dmacc.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Borrower {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String phone;

	@Autowired
	private Address address;
	
	
	@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(name="Borrower_books", joinColumns= {@JoinColumn(name="borrowerId", referencedColumnName="id")},
	inverseJoinColumns= {@JoinColumn(name="bookId", referencedColumnName="bookId", unique=true)})
	private List<Book> bookList;

	public Borrower() {

	}

	public Borrower(String name) {
		this.name = name;
	}

	public Borrower(String name, String phone, Address address, List<Book> bookList) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.bookList = bookList;
	}

	public Borrower(int id, String name, String phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
	
}
