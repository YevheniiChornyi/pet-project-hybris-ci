package com.test.consolestore.service;

import com.test.consolestore.console.enums.EasterEgg;
import com.test.consolestore.entity.Product;
import com.test.consolestore.repository.ProductRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepoMock;

    @Mock
    private Product productMock;

    private final InputStream stdin = System.in;

    @Before
    public void setUp() {
        System.setIn(new ByteArrayInputStream("S\n2".getBytes()));
        String magicString = "magic";
        when(productMock.toString()).thenReturn(magicString);
    }


    @Test
    public void createProductTest() {
        when(productRepoMock.save(any())).thenReturn(productMock);
        productService.createProduct(new Scanner(System.in));
    }

    @Test
    public void showAllProductsTest() {
        when(productRepoMock.findAll()).thenReturn(new ArrayList<>());
        productService.showAllProducts();
        verify(productRepoMock, times(1)).findAll();
    }

    @Test
    public void findProductByIdTest() {
        when(productRepoMock.findById(anyInt())).thenReturn(Optional.of(productMock));
        assertEquals(productMock, productService.findProductById(5));
    }

    @Test
    public void removeByIdWithPasswordTest() {
        doNothing().when(productRepoMock).removeById(anyInt());
        System.setIn(new ByteArrayInputStream(("1\n" + EasterEgg.PASSWORD.getName()).getBytes()));
        productService.removeById(new Scanner(System.in));
        verify(productRepoMock, times(1)).removeById(anyInt());
    }

    @After
    public void returnSystemIn() {
        System.setIn(stdin);
    }
}