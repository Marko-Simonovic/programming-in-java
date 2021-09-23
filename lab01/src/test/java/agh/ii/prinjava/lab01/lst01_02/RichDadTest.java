package agh.ii.prinjava.lab01.lst01_02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RichDadTest {

    @BeforeEach
    void setUp() {
        System.out.println("TestRichDad.setUp...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("TestRichDad.tearDown...");
    }

    // The purpose of the unit test is to see if we get back a List correctly
    @Test
    void TestgetContacts() {
        RichDad richDad = new RichDad("R", "Doe", BigDecimal.valueOf(1), List.of("School Marko", "Valere", "Benjamin", "Elon"));

        List<String> list_receive = new ArrayList<String>();
        list_receive = richDad.getContacts();
        for(String contact:list_receive)
            System.out.println(contact);
    }
}