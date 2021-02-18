package com.test.consolestore.service;

import com.test.consolestore.entity.User;
import com.test.consolestore.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Optional;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepoMock;

    @Mock
    private User userMock;

    private final InputStream stdin = System.in;

    @Before
    public void setUp() {
        System.setIn(new ByteArrayInputStream("S\nyes".getBytes()));
    }

    @Test
    public void authorizeOrCreateUserWhenUserExistsTest() {
        when(userRepoMock.findByLogin(anyString())).thenReturn(Optional.of(userMock));
        assertEquals(userMock, userService.authorizeOrCreateUser(new Scanner(System.in)));
    }

    @Test
    public void authorizeOrCreateUserWhenUserDoesNotExistsTest() {
        when(userRepoMock.findByLogin(anyString())).thenReturn(Optional.empty());
        userService.authorizeOrCreateUser(new Scanner(System.in));

        verify(userRepoMock, times(1)).save(any());
    }

    @Test(expected = IllegalArgumentException.class)
    public void authorizeUserThrowsExceptionTest() {
        when(userRepoMock.findByLogin(anyString())).thenReturn(Optional.empty());
        System.setIn(new ByteArrayInputStream("S\nno".getBytes()));
        userService.authorizeOrCreateUser(new Scanner(System.in));
    }

    @After
    public void returnSystemIn() {
        System.setIn(stdin);
    }

}