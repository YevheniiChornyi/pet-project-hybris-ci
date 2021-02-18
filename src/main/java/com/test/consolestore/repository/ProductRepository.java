package com.test.consolestore.repository;

import com.test.consolestore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    void removeById(Integer id);
}
