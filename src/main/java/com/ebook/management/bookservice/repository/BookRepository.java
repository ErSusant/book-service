package com.ebook.management.bookservice.repository;

import com.ebook.management.bookservice.domain.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
  List<Book> findByIsbnAndDeletedFalse(String isbn);
  List<Book> findByTitleContainingIgnoreCaseAndDeletedFalse(String title);
  List<Book> findByCategoryIdAndDeletedFalse(Long categoryId);
  long countByDeletedFalse();
  Long countDistinctCategoryIdByDeletedFalse();
}
