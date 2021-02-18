package com.test.consolestore.service;

import com.test.consolestore.entity.OrderItem;
import com.test.consolestore.entity.OrderItemId;
import com.test.consolestore.entity.Orders;
import com.test.consolestore.entity.Product;
import com.test.consolestore.repository.OrderItemRepository;
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
public class OrderItemServiceTest {

    @InjectMocks
    private OrderItemService orderItemService;

    @Mock
    private OrderItem orderItemMock;

//    @Mock
//    private OrderItemId orderItemIdMock;

    @Mock
    private Product productMock;

    @Mock
    private Orders ordersMock;

    @Mock
    private OrderItemRepository orderItemRepoMock;

    //private final InputStream stdin = System.in;

//    @Before
//    public void setUp() {
//        System.setIn(new ByteArrayInputStream("S\n2".getBytes()));
//    }

    @Test
    public void createOrderItemTest() {
        when(orderItemRepoMock.findById(any())).thenReturn(Optional.of(orderItemMock));
        when(orderItemRepoMock.save(any())).thenReturn(orderItemMock);

        assertEquals(orderItemMock, orderItemService.createOrderItem(productMock, ordersMock));
    }

    @Test
    public void showAllWhichOrderedTest() {
        when(orderItemRepoMock.findAllWhichOrdered()).thenReturn(new ArrayList<>());
        orderItemService.showAllWhichOrdered();
        verify(orderItemRepoMock, times(1)).findAllWhichOrdered();
    }

//    @After
//    public void returnSystemIn() {
//        System.setIn(stdin);
//    }
}