package com.test.consolestore.service;

import com.test.consolestore.console.enums.EasterEgg;
import com.test.consolestore.entity.Product;
import com.test.consolestore.entity.enums.ProductStatus;
import com.test.consolestore.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(Scanner scanner) {

        System.out.println("Creating product");
        System.out.println("Input product name:");
        String name = scanner.next();

        System.out.println("Input product price: ");
        int price = scanner.nextInt();
        System.out.println("Input product status(by number): 1.OUT_OF_STOCK; 2.IN_STOCK; 3.RUNNING_SLOW ");
        int status = scanner.nextInt();

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
    //    product.setCreatedAt(GregorianCalendar.getInstance().getTime());
        Date now = new Date();
        product.setCreatedAt(now);
        if(status == 1){ //TODO more data about possible stats
            product.setProductStatus(ProductStatus.OUT_OF_STOCK);
        } else if (status == 3) {
            product.setProductStatus(ProductStatus.RUNNING_SLOW);
        } else {
            product.setProductStatus(ProductStatus.IN_STOCK);
        }

        Product savedProduct = productRepository.save(product);
        System.out.println("Product has been created " + savedProduct);

    }

    public void showAllProducts() {
        System.out.println("Showing all products");
        productRepository.findAll().forEach(System.out::println);
    }

    public Product findProductById(Integer id) {
        return productRepository.findById(id).orElse(new Product());
    }

    @Transactional
    public void removeById(Scanner scanner) {//TODO remove ordered if possible
        System.out.println("Input id of product to remove: ");
        Integer id = scanner.nextInt();
        System.out.println("Input password: ");
        if (scanner.next().equalsIgnoreCase(EasterEgg.PASSWORD.getName())) {
            productRepository.removeById(id);
        }
    }
}
