package com.TaxiApp;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.TaxiApp.repository.BookRepository;

@SpringBootApplication
public class TaxiAppApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(TaxiAppApplication.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	// @Qualifier("jdbcBookRepository") // Test JdbcTemplate
	@Qualifier("namedParameterJdbcBookRepository") // Test NamedParameterJdbcTemplate

	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(TaxiAppApplication.class, args);
	}

	public void run(String... args) {
		log.info("StartApplication...");
		runJDBC();
	}

	void runJDBC() {

		log.info("Creating tables for testing...");

		// Rider
		//Drop Rider Table
		//jdbcTemplate.execute("DROP TABLE IF EXISTS rider;");
		
		// Created Rider Table
//		jdbcTemplate.execute("CREATE TABLE rider(" + "id SERIAL," + " name VARCHAR(255)," + " joined_date TIMESTAMP,"
//				+ "  gender VARCHAR(255)," + "  country VARCHAR(255)," + "  phone_no VARCHAR(12)," + "  dob Date,"
//				+ "  current_payment_type VARCHAR(255)," + "  current_payement_ac VARCHAR(255)," + " PRIMARY KEY (phone_no) )");

//		System.out.println("Rider Table Created");
		
		
		

		// DROP Table
		jdbcTemplate.execute("DROP TABLE IF EXISTS books;");
		System.out.println("Test 1 - DROP TABLE IF EXISTS books");

		// Created Table
		jdbcTemplate.execute("CREATE TABLE books(" + "id SERIAL, name VARCHAR(255), price NUMERIC(15, 2))");
		System.out.println("Test 2 - Create Table Books");

		// Insert Book
		List<Book> books = Arrays.asList(new Book("Thinking in Java", new BigDecimal("46.32")),
				new Book("Mkyong in Java", new BigDecimal("1.99")), new Book("Getting Clojure", new BigDecimal("37.3")),
				new Book("Head First Android Development", new BigDecimal("41.19")));

		log.info("[SAVE]");
		books.forEach(book -> {
			log.info("Saving...{}", book.getName());
			bookRepository.save(book);
		});
		System.out.println("Test 3 - Add Data to the Table Books");

		// count
		log.info("[COUNT] Total books: {}", bookRepository.count());
		System.out.println("Test 4 - Total books in Database : " + bookRepository.count());

		// find all
		log.info("[FIND_ALL] {}", bookRepository.findAll());
		List<Book> b = bookRepository.findAll();

		System.out.println("Test 5 - All books Name, Price in Database : ");
		for (Book boo : b) {
			System.out.println(boo.getName());
			System.out.println(boo.getPrice());
		}

		// find by id
		log.info("[FIND_BY_ID] :2L");
		Book book = bookRepository.findById(2L).orElseThrow(IllegalArgumentException::new);
		log.info("{}", book);
		System.out.println("Test 6 - FIND BY ID = 2 Book Name : " + book.getName());

		// find by name (like) and price
		log.info("[FIND_BY_NAME_AND_PRICE] : like '%Java%' and price <= 10");
		log.info("{}", bookRepository.findByNameAndPrice("Java", new BigDecimal(10)));

		List<Book> sbook = bookRepository.findByNameAndPrice("Java", new BigDecimal(10));

		for (Book sb : sbook) {

			System.out.println("Test 7 - FIND BY NAME AND PRICE = java , 10 : " + sb.getId() + " " + sb.getName() + " "
					+ sb.getPrice());
		}

		// get name (string) by id
		log.info("[GET_NAME_BY_ID] :1L = {}", bookRepository.getNameById(1L));
		System.out.println("Test 8 - GET NAME BY ID = 1 Book Name : " + bookRepository.getNameById(1L));

//	        // update
		log.info("[UPDATE] :2L :99.99");
		book.setPrice(new BigDecimal("99.99"));
		log.info("rows affected: {}", bookRepository.update(book));
		System.out.println("Test 9 - UPDATE price in id = 1 Book Name : " + bookRepository.getNameById(1L));

//	        // delete
		log.info("[DELETE] :3L");
		log.info("rows affected: {}", bookRepository.deleteById(4L));
		System.out.println("Test 10 - DELETE id = 3  ");

	}

}
