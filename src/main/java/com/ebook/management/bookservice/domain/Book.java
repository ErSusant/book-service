package com.ebook.management.bookservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "books")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  private String subtitle;

  @Column(nullable = false, unique = true)
  private String isbn;

  @Column(columnDefinition = "TEXT")
  private String description;

  @Column(name = "author_id")
  private Long authorId;

  @Column(name = "publisher_id")
  private Long publisherId;

  @Column(name = "category_id")
  private Long categoryId;

  @Column(name = "sub_category_id")
  private Long subCategoryId;

  private String language;
  private Integer pages;
  private String edition;

  @Column(nullable = false)
  private BigDecimal price;

  @Column(name = "discount_price")
  private BigDecimal discountPrice;

  private BigDecimal rating;

  @Column(name = "review_count")
  private Integer reviewCount;

  @Column(name = "publication_date")
  private LocalDate publicationDate;

  @Column(name = "thumbnail_url")
  private String thumbnailUrl;

  @Column(name = "preview_url")
  private String previewUrl;

  @Column(name = "original_url")
  private String originalUrl;

  @Column(name = "file_size")
  private String fileSize;

  private String tags;

  @Column(name = "is_featured")
  private boolean featured;

  @Column(name = "is_best_seller")
  private boolean bestSeller;

  @Column(name = "is_trending")
  private boolean trending;

  @Column(name = "is_new_arrival")
  private boolean newArrival;

  @Column(name = "is_deleted")
  private boolean deleted = false;

  @Column(name = "created_date", nullable = false, updatable = false)
  private LocalDate createdAt = LocalDate.now();

  @Column(name = "updated_date", nullable = false)
  private LocalDate updatedAt = LocalDate.now();

  @Column(name = "status")
  private String status;

  @Column(name="created_by")
  private String createdBy;

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSubtitle() {
    return subtitle;
  }

  public void setSubtitle(String subtitle) {
    this.subtitle = subtitle;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getAuthorId() {
    return authorId;
  }

  public void setAuthorId(Long authorId) {
    this.authorId = authorId;
  }

  public Long getPublisherId() {
    return publisherId;
  }

  public void setPublisherId(Long publisherId) {
    this.publisherId = publisherId;
  }

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public Long getSubCategoryId() {
    return subCategoryId;
  }

  public void setSubCategoryId(Long subCategoryId) {
    this.subCategoryId = subCategoryId;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public Integer getPages() {
    return pages;
  }

  public void setPages(Integer pages) {
    this.pages = pages;
  }

  public String getEdition() {
    return edition;
  }

  public void setEdition(String edition) {
    this.edition = edition;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public BigDecimal getDiscountPrice() {
    return discountPrice;
  }

  public void setDiscountPrice(BigDecimal discountPrice) {
    this.discountPrice = discountPrice;
  }

  public BigDecimal getRating() {
    return rating;
  }

  public void setRating(BigDecimal rating) {
    this.rating = rating;
  }

  public Integer getReviewCount() {
    return reviewCount;
  }

  public void setReviewCount(Integer reviewCount) {
    this.reviewCount = reviewCount;
  }

  public LocalDate getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(LocalDate publicationDate) {
    this.publicationDate = publicationDate;
  }

  public String getThumbnailUrl() {
    return thumbnailUrl;
  }

  public void setThumbnailUrl(String thumbnailUrl) {
    this.thumbnailUrl = thumbnailUrl;
  }

  public String getPreviewUrl() {
    return previewUrl;
  }

  public void setPreviewUrl(String previewUrl) {
    this.previewUrl = previewUrl;
  }

  public String getOriginalUrl() {
    return originalUrl;
  }

  public void setOriginalUrl(String originalUrl) {
    this.originalUrl = originalUrl;
  }

  public String getFileSize() {
    return fileSize;
  }

  public void setFileSize(String fileSize) {
    this.fileSize = fileSize;
  }

  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public boolean isFeatured() {
    return featured;
  }

  public void setFeatured(boolean featured) {
    this.featured = featured;
  }

  public boolean isBestSeller() {
    return bestSeller;
  }

  public void setBestSeller(boolean bestSeller) {
    this.bestSeller = bestSeller;
  }

  public boolean isTrending() {
    return trending;
  }

  public void setTrending(boolean trending) {
    this.trending = trending;
  }

  public boolean isNewArrival() {
    return newArrival;
  }

  public void setNewArrival(boolean newArrival) {
    this.newArrival = newArrival;
  }

  public boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDate getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDate updatedAt) {
    this.updatedAt = updatedAt;
  }
}
