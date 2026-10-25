package com.ebook.management.bookservice.controller;

import com.ebook.management.bookservice.dto.ApiResponse;
import com.ebook.management.bookservice.dto.BookDto;
import com.ebook.management.bookservice.service.BookService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/books")
@Slf4j
@CrossOrigin("*")
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping
  public ResponseEntity<ApiResponse<List<BookDto>>> getAllBooks() {
    try {
      List<BookDto> books = bookService.findAll();
      log.info("Fetched all books successfully. Total records: {}", books != null ? books.size() : 0);
      return ResponseEntity.ok(new ApiResponse<>(true, "Books fetched successfully", books));
    } catch (Exception e) {
      log.error("Error fetching all books", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(new ApiResponse<>(false, "Failed to fetch books: " + e.getMessage(), null));
    }
  }

  @GetMapping("/search")
  public ResponseEntity<ApiResponse<List<BookDto>>> searchBooks(

      @RequestParam(required = false) String title,
      @RequestParam(required = false) String author,
      @RequestParam(required = false) String isbn,
      @RequestParam(required = false) Long categoryId,
      @RequestParam(required = false) String status) {
    try {
      List<BookDto> books = bookService.searchBooks(title, author, isbn, categoryId, status);
      log.info(
          "Searched books with title={}, author{}, categoryId={}, status={}. Total records: {}",
          title,
          author,
          categoryId,
          status,
          books != null ? books.size() : 0);
      return ResponseEntity.ok(new ApiResponse<>(true, "Books filtered successfully", books));
    } catch (Exception e) {
      log.error("Error filtering books with  categoryId={}, status={}, title={}, author{}", categoryId, status, e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(new ApiResponse<>(false, "Failed to filter books: " + e.getMessage(), null));
    }
  }

  @GetMapping("/count")
  public ResponseEntity<ApiResponse<Integer>> getTotalBooks() {
    try {
      Integer totalBooks = bookService.getTotalBooks();
      log.info("Fetched total books count: {}", totalBooks);
      return ResponseEntity.ok(new ApiResponse<>(true, "Total books fetched successfully", totalBooks));
    } catch (Exception e) {
      log.error("Error fetching total books count", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(new ApiResponse<>(false, "Failed to fetch total books: " + e.getMessage(), null));
    }
  }

  @GetMapping("/categories/count")
  public ResponseEntity<ApiResponse<Integer>> getCategoryCount() {
    try {
      Integer categoryCount = bookService.getCategoryCount();
      log.info("Fetched category count: {}", categoryCount);
      return ResponseEntity.ok(new ApiResponse<>(true, "Category count fetched successfully", categoryCount));
    } catch (Exception e) {
      log.error("Error fetching category count", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(new ApiResponse<>(false, "Failed to fetch category count: " + e.getMessage(), null));
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse<BookDto>> getBook(@PathVariable("id") Long id) {
    try {
      BookDto book = bookService.findById(id);
      log.info("Fetched book by id {} successfully", id);
      return ResponseEntity.ok(new ApiResponse<>(true, "Book fetched successfully", book));
    } catch (Exception e) {
      log.error("Error fetching book by id {}", id, e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(new ApiResponse<>(false, "Failed to fetch book: " + e.getMessage(), null));
    }
  }

  @PostMapping("/create")
  public ResponseEntity<ApiResponse<BookDto>> createBook(
      @Valid @RequestBody BookDto dto) {
    try {

      BookDto createdBook = bookService.create(dto);
      log.info("Book created successfully with id {}", createdBook != null ? createdBook.getId() : null);
      return ResponseEntity.status(HttpStatus.CREATED)
          .body(new ApiResponse<>(true, "Book created successfully", createdBook));
    } catch (Exception e) {
      log.error("Error creating book: {}", dto, e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(new ApiResponse<>(false, "Failed to create book: " + e.getMessage(), null));
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<ApiResponse<BookDto>> updateBook(@PathVariable("id") Long id,
      @Valid @RequestBody BookDto dto) {
    try {
      BookDto updatedBook = bookService.update(id, dto);
      log.info("Book updated successfully with id {}", id);
      return ResponseEntity.ok(new ApiResponse<>(true, "Book updated successfully", updatedBook));
    } catch (Exception e) {
      log.error("Error updating book with id {}", id, e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(new ApiResponse<>(false, "Failed to update book: " + e.getMessage(), null));
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ApiResponse<Void>> deleteBook(@PathVariable("id") Long id) {
    try {
      bookService.delete(id);
      log.info("Book deleted successfully with id {}", id);
      return ResponseEntity.ok(new ApiResponse<>(true, "Book deleted successfully", null));
    } catch (Exception e) {
      log.error("Error deleting book with id {}", id, e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(new ApiResponse<>(false, "Failed to delete book: " + e.getMessage(), null));
    }
  }

  @GetMapping("/featured")
  public ResponseEntity<ApiResponse<List<BookDto>>> getFeaturedBooks() {
    try {
      List<BookDto> books = bookService.findFeaturedBooks();
      log.info("Fetched featured books successfully. Total records: {}", books != null ? books.size() : 0);
      return ResponseEntity.ok(new ApiResponse<>(true, "Featured books fetched successfully", books));
    } catch (Exception e) {
      log.error("Error fetching featured books", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(new ApiResponse<>(false, "Failed to fetch featured books: " + e.getMessage(), null));
    }
  }

  @GetMapping("/best-seller")
  public ResponseEntity<ApiResponse<List<BookDto>>> getBestSellerBooks() {
    try {
      List<BookDto> books = bookService.findBestSellerBooks();
      log.info("Fetched best seller books successfully. Total records: {}", books != null ? books.size() : 0);
      return ResponseEntity.ok(new ApiResponse<>(true, "Best seller books fetched successfully", books));
    } catch (Exception e) {
      log.error("Error fetching best seller books", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(new ApiResponse<>(false, "Failed to fetch best seller books: " + e.getMessage(), null));
    }
  }

  @GetMapping("/trending")
  public ResponseEntity<ApiResponse<List<BookDto>>> getTrendingBooks() {
    try {
      List<BookDto> books = bookService.findTrendingBooks();
      log.info("Fetched trending books successfully. Total records: {}", books != null ? books.size() : 0);
      return ResponseEntity.ok(new ApiResponse<>(true, "Trending books fetched successfully", books));
    } catch (Exception e) {
      log.error("Error fetching trending books", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(new ApiResponse<>(false, "Failed to fetch trending books: " + e.getMessage(), null));
    }
  }

  @GetMapping("/arrival")
  public ResponseEntity<ApiResponse<List<BookDto>>> getArrivalBooks() {
    try {
      List<BookDto> books = bookService.findNewArrivalBooks();
      log.info("Fetched new arrival books successfully. Total records: {}", books != null ? books.size() : 0);
      return ResponseEntity.ok(new ApiResponse<>(true, "New arrival books fetched successfully", books));
    } catch (Exception e) {
      log.error("Error fetching new arrival books", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(new ApiResponse<>(false, "Failed to fetch new arrival books: " + e.getMessage(), null));
    }
  }
}
