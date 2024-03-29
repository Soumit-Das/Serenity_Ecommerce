package com.serenity.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.serenity.model.Users;
import com.serenity.model.Products;

@Repository
public interface ProductRepository
		extends JpaRepository<Products, Integer>, PagingAndSortingRepository<Products, Integer> {

	@Query("SELECT p FROM Products p WHERE p.productName = ?1")
	public List<Products> findByName(String productName);

	public boolean existsByproductName(String productName);

	@Query("SELECT p FROM Products p WHERE p.productBrand = ?1")
	public List<Products> findByBrand(String productBrand);

	public boolean existsByproductBrand(String productBrand);

	@Query("SELECT p FROM Products p WHERE p.productType = ?1")
	public List<Products> findByType(String productType);

	public boolean existsByproductType(String productType);

	@Query("SELECT p FROM Products p WHERE p.rating = ?1")
	public List<Products> findByRating(double rating);

	public boolean existsByRating(double rating);

	@Query("SELECT p FROM Products p WHERE p.isAvailable = ?1")
	public List<Products> findByisAvailable(boolean isAvailable);

	@Query("SELECT p FROM Products p WHERE p.productType = ?1")
	List<Products> findByType(String type, Sort sort);

	@Query("SELECT p FROM Products p WHERE p.productType = ?1")
	Page<Products> findByTypeofProduct(String type, Pageable p);
		
	@Query("SELECT p FROM Products p WHERE p.productType = ?1 AND p.salePrice BETWEEN ?2 AND ?3")
	List<Products> findByPriceRangeAndType(String productType, double startingPrice, double endingPrice);

	@Query("SELECT p FROM Products p WHERE p.productType = ?1 AND p.discountPercentage BETWEEN ?2 AND ?3")
	List<Products> findByDiscountPercentageRangeAndType(String productType, double startingDiscount, double endingDiscount);


}
