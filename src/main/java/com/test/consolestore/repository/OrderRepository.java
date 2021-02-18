package com.test.consolestore.repository;

import com.test.consolestore.entity.Orders;
import com.test.consolestore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

   // Optional<Orders> findById(Integer id);

    List<Orders> findByUser(User user);
}
