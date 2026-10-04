package com.ebook.management.bookservice.repository;

import com.ebook.management.bookservice.domain.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
  List<Book> findByIsbnAndDeletedFalse(String isbn);
  List<Book> findByTitleContainingIgnoreCaseAndDeletedFalse(String title);
  List<Book> findByCategoryIdAndDeletedFalse(Long categoryId);
  List<Book> findByFeaturedTrueAndDeletedFalseOrderByCreatedAtDesc();
  List<Book> findByBestSellerTrueAndDeletedFalseOrderByCreatedAtDesc();
  List<Book> findByTrendingTrueAndDeletedFalseOrderByCreatedAtDesc();
  List<Book> findByNewArrivalTrueAndDeletedFalseOrderByCreatedAtDesc();

  @Query(
      value =
          "SELECT * FROM books b "
              + "WHERE b.is_deleted = false "
              + "AND ("
              + "(:title IS NULL OR :title = '' OR LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))) "
              + "OR (:isbn IS NULL OR :isbn = '' OR LOWER(b.isbn) LIKE LOWER(CONCAT('%', :isbn, '%'))) "
              + "OR (:author IS NULL OR :author = '' OR LOWER(CAST(b.author_id AS CHAR)) LIKE LOWER(CONCAT('%', :author, '%'))) "
              + ") "
              + "AND (:categoryId IS NULL OR b.category_id = :categoryId) "
              + "AND (:status IS NULL OR :status = '' OR :status = 'all' OR LOWER(b.status) = LOWER(:status)) "
              + "ORDER BY b.created_date DESC",
      nativeQuery = true)
  List<Book> searchBooks(
      @Param("title") String title,
      @Param("author") String author,
      @Param("isbn") String isbn,
      @Param("categoryId") Long categoryId,
      @Param("status") String status);

  long countByDeletedFalse();
  Long countDistinctCategoryIdByDeletedFalse();
}
