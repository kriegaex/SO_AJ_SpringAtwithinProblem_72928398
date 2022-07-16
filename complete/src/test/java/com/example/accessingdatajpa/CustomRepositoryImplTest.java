package com.example.accessingdatajpa;

import com.example.tlw.CustomerRepositoryImpl;
import org.junit.jupiter.api.Test;

public class CustomRepositoryImplTest {

    @Test
    void testLTW() {
        CustomerRepositoryImpl repository = new CustomerRepositoryImpl();
        // This method is woven as expected
        repository.saveAll(null);
        // These methods are not woven with the 'annotated()' pointcut, only with 'impl()', which is puzzling
        repository.save(null);
        repository.foo();
    }

}
