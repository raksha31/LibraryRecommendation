package zenjob.config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.h2.tools.Csv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zenjob.dao.BookRepository;
import zenjob.model.Book;
@Component
public class FileReader {
	@Autowired
	BookRepository bookRepository;

	@PostConstruct
	public  void loadBooks() throws SQLException
	{
		ResultSet rs = new Csv().read("src/main/resources/bookdata.csv", null, null);
		ResultSetMetaData meta = rs.getMetaData();
		Book book = null;
		List<Book> books = new ArrayList<>();
		while (rs.next()) {
			book = new Book();
			for (int i = 0; i < meta.getColumnCount(); i++) {
				if(meta.getColumnLabel(i + 1).equalsIgnoreCase("ISBN")) {
					book.setIsbn(rs.getString(i + 1));
				} else if(meta.getColumnLabel(i + 1).equalsIgnoreCase("TITLE")) {
					book.setTitle(rs.getString(i + 1));
				} else if(meta.getColumnLabel(i + 1).equalsIgnoreCase("AUTHOR")) {
					book.setAuthor(rs.getString(i + 1));
				} else if(meta.getColumnLabel(i + 1).equalsIgnoreCase("CATEGORY_ID")) {
					book.setCategoryId(Integer.parseInt(rs.getString(i + 1)));
				}
			}
			books.add(book);

		}
		bookRepository.saveAll(books);
		rs.close();
	}
}
