package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Book;
import dmacc.beans.Borrower;
import dmacc.repository.BookRepository;
import dmacc.repository.BorrowerRepository;

@Controller
public class WebController {
	@Autowired
	BorrowerRepository repo;

	@Autowired
	BookRepository bookRepo;

	@GetMapping("/viewAll")
	public String viewAllBorrower(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewBorrower(model);
		}
		model.addAttribute("borrower", repo.findAll());
		return "results";
	}


	@GetMapping("/inputBorrower")
	public String addNewBorrower(Model model) {
		Borrower b = new Borrower();
		model.addAttribute("newBorrower", b);
		return "borrower";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateBorrower(@PathVariable("id") Integer id, Model model) {
		Borrower b = repo.findById(id).orElse(null);
		System.out.println("ITEM TO EDIT: " + b.toString());
		model.addAttribute("newBorrower", b);
		return "borrower";
	}

	@PostMapping("/update/{id}")
	public String reviseBorrower(Borrower b, Model model) {
		repo.save(b);
		return viewAllBorrower(model);
	}

	@GetMapping("/delete/{id}")
	public String deleteBorrower(@PathVariable("id") Integer id, Model model) {
		Borrower b = repo.findById(id).orElse(null);
		repo.delete(b);
		return viewAllBorrower(model);

	}
	
	
	
	/**    Book operations  here  **/
	
	
	@GetMapping("/viewAllBooks")
	public String viewAllBooks(Model model) {
		if (bookRepo.findAll().isEmpty()) {
			return addNewBook(model);
		}
		model.addAttribute("book", bookRepo.findAll());
		return "bookResults";
	}
	
	
	@GetMapping("/inputBook")
	public String addNewBook(Model model) {
		Book book = new Book();
		model.addAttribute("newBook", book);
		return "book";
	}

	@PostMapping("/updateBook/{bookId}")
	public String updateBook(Book book, Model model) {
		bookRepo.save(book);
		return viewAllBooks(model);
	}
	
	@GetMapping("/editBook/{bookId}")
	public String editBook(@PathVariable("bookId") Integer id, Model model) {
		Book b = bookRepo.findById(id).orElse(null);
		System.out.println("ITEM TO EDIT: " + b.toString());
		model.addAttribute("newBook", b);
		return "book";
	}
	
	@GetMapping("/deleteBook/{bookId}")
	public String deleteBook(@PathVariable("bookId") Integer id, Model model) {
		Book b = bookRepo.findById(id).orElse(null);
		bookRepo.delete(b);
		return viewAllBooks(model);

	}
	
	/**    End of Book operations  here  **/

}
