package com.example.accessingdatajpa;

import com.example.tlw.CustomerRepositoryImpl;
import org.junit.jupiter.api.Test;

public class CustomRepositoryImplTest {

    @Test
    void testLTW() {
        new CustomerRepositoryImpl().save(null);
    }

}
