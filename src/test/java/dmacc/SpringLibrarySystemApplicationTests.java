
package dmacc;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dmacc.beans.Book;
import dmacc.beans.Borrower;
import dmacc.repository.BookRepository;
import dmacc.repository.BorrowerRepository;

@SpringBootTest
class SpringLibrarySystemApplicationTests {
	
	@Autowired
	private BorrowerRepository borrowerRepository;
	
	@Autowired
	private BookRepository bookRepository;
	

	@Test
	public void testJoin() {
		List<Book> bookList =  new ArrayList<>();
		
		Borrower borrower = borrowerRepository.findById(1).orElse(null);
		
		Book book1 = bookRepository.findById(1).orElse(null);
		Book book2 = bookRepository.findById(3).orElse(null);
		Book book3 = bookRepository.findById(4).orElse(null);
		
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		
		
		borrower.setBookList(bookList);
		
		borrowerRepository.save(borrower);
		
	}

}
