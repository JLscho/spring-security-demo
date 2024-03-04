package com.jl.springsecuritydemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SpringSecurityDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testJwt(){
        assertThat("test").isEqualTo("testa");
    }

}
