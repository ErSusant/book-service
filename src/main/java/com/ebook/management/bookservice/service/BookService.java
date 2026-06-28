package com.ebook.management.bookservice.service;

import com.ebook.management.bookservice.domain.Book;
import com.ebook.management.bookservice.dto.BookDto;
import com.ebook.management.bookservice.exception.ResourceNotFoundException;
import com.ebook.management.bookservice.mapper.BookMapper;
import com.ebook.management.bookservice.repository.BookRepository;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

  private final BookRepository repository;

  public BookService(BookRepository repository) {
    this.repository = repository;
  }

  @Transactional(readOnly = true)
  public List<BookDto> findAll() {
    return repository.findAll().stream()
        .filter(book -> !book.isDeleted())
        .map(BookMapper::toDto)
        .collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public BookDto findById(Long id) {
    return repository.findById(id)
        .filter(book -> !book.isDeleted())
        .map(BookMapper::toDto)
        .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
  }

  @Transactional
  public BookDto create(BookDto dto) {
    Book book = BookMapper.toEntity(dto);
    book.setCreatedAt(Instant.now());
    book.setUpdatedAt(Instant.now());
    book.setDeleted(false);
    return BookMapper.toDto(repository.save(book));
  }

  @Transactional
  public BookDto update(Long id, BookDto dto) {
    Book existing = repository.findById(id)
        .filter(book -> !book.isDeleted())
        .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
    existing.setTitle(dto.getTitle());
    existing.setSubtitle(dto.getSubtitle());
    existing.setIsbn(dto.getIsbn());
    existing.setDescription(dto.getDescription());
    existing.setAuthorId(dto.getAuthorId());
    existing.setPublisherId(dto.getPublisherId());
    existing.setCategoryId(dto.getCategoryId());
    existing.setSubCategoryId(dto.getSubCategoryId());
    existing.setLanguage(dto.getLanguage());
    existing.setPages(dto.getPages());
    existing.setEdition(dto.getEdition());
    existing.setPrice(dto.getPrice());
    existing.setDiscountPrice(dto.getDiscountPrice());
    existing.setRating(dto.getRating());
    existing.setReviewCount(dto.getReviewCount());
    existing.setPublicationDate(dto.getPublicationDate());
    existing.setThumbnailUrl(dto.getThumbnailUrl());
    existing.setPreviewUrl(dto.getPreviewUrl());
    existing.setOriginalUrl(dto.getOriginalUrl());
    existing.setFileSize(dto.getFileSize());
    existing.setTags(dto.getTags());
    existing.setFeatured(dto.isFeatured());
    existing.setBestSeller(dto.isBestSeller());
    existing.setTrending(dto.isTrending());
    existing.setNewArrival(dto.isNewArrival());
    existing.setUpdatedAt(Instant.now());
    return BookMapper.toDto(repository.save(existing));
  }

  @Transactional
  public void delete(Long id) {
    Book book = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
    book.setDeleted(true);
    book.setUpdatedAt(Instant.now());
    repository.save(book);
  }
}
