package com.ebook.management.bookservice.mapper;

import com.ebook.management.bookservice.domain.Book;
import com.ebook.management.bookservice.dto.BookDto;

public class BookMapper {

  public static BookDto toDto(Book book) {
    if (book == null) {
      return null;
    }
    BookDto dto = new BookDto();
    dto.setId(book.getId());
    dto.setTitle(book.getTitle());
    dto.setSubtitle(book.getSubtitle());
    dto.setIsbn(book.getIsbn());
    dto.setDescription(book.getDescription());
    dto.setAuthorId(book.getAuthorId());
    dto.setPublisherId(book.getPublisherId());
    dto.setCategoryId(book.getCategoryId());
    dto.setSubCategoryId(book.getSubCategoryId());
    dto.setLanguage(book.getLanguage());
    dto.setPages(book.getPages());
    dto.setEdition(book.getEdition());
    dto.setPrice(book.getPrice());
    dto.setDiscountPrice(book.getDiscountPrice());
    dto.setRating(book.getRating());
    dto.setReviewCount(book.getReviewCount());
    dto.setPublicationDate(book.getPublicationDate());
    dto.setThumbnailUrl(book.getThumbnailUrl());
    dto.setPreviewUrl(book.getPreviewUrl());
    dto.setOriginalUrl(book.getOriginalUrl());
    dto.setFileSize(book.getFileSize());
    dto.setTags(book.getTags());
    dto.setFeatured(book.isFeatured());
    dto.setBestSeller(book.isBestSeller());
    dto.setTrending(book.isTrending());
    dto.setNewArrival(book.isNewArrival());
    dto.setStatus(book.getStatus());
    dto.setCreatedBy(book.getCreatedBy());
    return dto;
  }

  public static Book toEntity(BookDto dto) {
    if (dto == null) {
      return null;
    }
    Book book = new Book();
    book.setId(dto.getId());
    book.setTitle(dto.getTitle());
    book.setSubtitle(dto.getSubtitle());
    book.setIsbn(dto.getIsbn());
    book.setDescription(dto.getDescription());
    book.setAuthorId(dto.getAuthorId());
    book.setPublisherId(dto.getPublisherId());
    book.setCategoryId(dto.getCategoryId());
    book.setSubCategoryId(dto.getSubCategoryId());
    book.setLanguage(dto.getLanguage());
    book.setPages(dto.getPages());
    book.setEdition(dto.getEdition());
    book.setPrice(dto.getPrice());
    book.setDiscountPrice(dto.getDiscountPrice());
    book.setRating(dto.getRating());
    book.setReviewCount(dto.getReviewCount());
    book.setPublicationDate(dto.getPublicationDate());
    book.setThumbnailUrl(dto.getThumbnailUrl());
    book.setPreviewUrl(dto.getPreviewUrl());
    book.setOriginalUrl(dto.getOriginalUrl());
    book.setFileSize(dto.getFileSize());
    book.setTags(dto.getTags());
    book.setFeatured(dto.isFeatured());
    book.setBestSeller(dto.isBestSeller());
    book.setTrending(dto.isTrending());
    book.setNewArrival(dto.isNewArrival());
    book.setStatus(dto.getStatus());
    book.setCreatedBy(dto.getCreatedBy());
    return book;
  }
}
