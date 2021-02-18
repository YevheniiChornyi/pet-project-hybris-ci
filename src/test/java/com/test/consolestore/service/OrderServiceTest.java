package com.test.consolestore.service;

import com.test.consolestore.entity.Orders;
import com.test.consolestore.entity.User;
import com.test.consolestore.repository.OrderRepository;
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

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @Mock
    private User userMock;

    @Mock
    private Orders ordersMock;

    @Mock
    private OrderRepository orderRepoMock;

    @InjectMocks
    private OrderService orderService;

    private final InputStream stdin = System.in;

    @Before
    public void setUp() {
        System.setIn(new ByteArrayInputStream("S\n2".getBytes()));
    }

    @Test
    public void saveOrderTest() {
        when(orderRepoMock.save(any())).thenReturn(ordersMock);
        assertEquals(ordersMock, orderService.saveOrder(userMock, new Scanner(System.in)));
    }

    @Test
    public void showAllOrdersForUserTest() {
        when(orderRepoMock.findByUser(any())).thenReturn(new ArrayList<>());
        orderService.showAllOrdersForUser(userMock);
        verify(orderRepoMock, times(1)).findByUser(any());
    }

    @Test
    public void showOrderByIdTest() {
        when(orderRepoMock.findById(anyInt())).thenReturn(Optional.of(ordersMock));
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        orderService.showOrderById(new Scanner(System.in));
        verify(orderRepoMock, times(1)).findById(anyInt());
    }

    @After
    public void returnSystemIn() {
        System.setIn(stdin);
    }
}