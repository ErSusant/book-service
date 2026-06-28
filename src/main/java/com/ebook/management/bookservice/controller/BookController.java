package com.ebook.management.bookservice.controller;

import com.ebook.management.bookservice.dto.BookDto;
import com.ebook.management.bookservice.service.BookService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping
  public ResponseEntity<List<BookDto>> getAllBooks() {
    return ResponseEntity.ok(bookService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<BookDto> getBook(@PathVariable Long id) {
    return ResponseEntity.ok(bookService.findById(id));
  }

  @PostMapping
  public ResponseEntity<BookDto> createBook(@Valid @RequestBody BookDto dto) {
    return ResponseEntity.ok(bookService.create(dto));
  }

  @PutMapping("/{id}")
  public ResponseEntity<BookDto> updateBook(@PathVariable Long id, @Valid @RequestBody BookDto dto) {
    return ResponseEntity.ok(bookService.update(id, dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
    bookService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
