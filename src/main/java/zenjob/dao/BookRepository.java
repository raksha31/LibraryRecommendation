package zenjob.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import zenjob.model.Book;

@Resource
public interface BookRepository extends CrudRepository<Book, Long>{
	@Query(value="select b.* from book b where b.category_id =:categoryId",nativeQuery = true)
	List<Book> findBooksByCategory(@Param("categoryId") Integer categoryId, Pageable pageable);

	Book findByTitle(String title);
}
