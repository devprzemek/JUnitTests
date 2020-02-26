package com.example;

import org.junit.*;

public class AnnotationOrderTest {

    public AnnotationOrderTest(){
        System.out.println("Constructor");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("@BeforeClass");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("@AfterClass");
    }

    @Before
    public void before(){
        System.out.println("@Before");
    }

    @After
    public void after(){
        System.out.println("@After");
    }

    @Test
    public void testMethod(){
        System.out.println("TestMethod - successful");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodWithException(){
        System.out.println("TestMethodWithException - successful");
        throw new IllegalArgumentException();
    }

    @Test
    @Ignore
    public void failMethod(){
        System.out.println("FailMethod");
        throw new IllegalArgumentException();
    }
}
