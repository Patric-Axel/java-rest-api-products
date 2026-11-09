package org.gallegos.java_rest_api_lab.repository;

import org.gallegos.java_rest_api_lab.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
}
