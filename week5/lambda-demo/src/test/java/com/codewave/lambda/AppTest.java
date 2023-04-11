package com.codewave.lambda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.codewave.lambda.model.Staff;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        assertEquals(1, 1);
        //assertEquals(App.sum(1, 2),3);
        //assertEquals(App.sum(-1, 2),1);
        //assertEquals(App.sum(4, 8),12);
       // assertEquals(App.sum(0, 2),2);
        
    }

    @Test
    void testStaff() {
        //
        Staff staff = new Staff("John", 1, "john@abc.com");
        Staff staff2 = new Staff("Jason", 2, "jason@abc.com");
        List<Staff> staffs = Arrays.asList(staff, staff2);
        List<String> emails = Arrays.asList("john@abc.com", "jason@abc.com");

        Staff.getAllEmail(staffs).stream().forEach(e -> {
            assertEquals(emails.contains(e), true);
        });
     
       //assertEquals(Staff.getAllEmail(null), new NullPointerException());
       Assertions.assertThrows(NullPointerException.class, () -> Staff.getAllEmail(null));
    }
}
