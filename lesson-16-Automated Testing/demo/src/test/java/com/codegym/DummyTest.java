package com.codegym;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DummyTest {
    @Test
    void assertionWorked() {
        int actual = 1 + 1;
        int result = 2;
        assertEquals(result, actual);
    }

}
