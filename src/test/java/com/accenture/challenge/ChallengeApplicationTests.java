package com.accenture.challenge;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChallengeApplicationTests {
    @Test
    void contextLoads() {
        // Verifica que el contexto de Spring arranca sin errores
    }

    @Test
    void testMainMethod() {
    	ChallengeApplication.main(new String[] {});
    }
}
