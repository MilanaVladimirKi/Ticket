package ru.topacademy.javaqa.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

public class TicketTest {

    Ticket ticket1 = new Ticket("Екатеринбург", "Москва", 7000, 8, 10);
    TicketTimeComparator comparator = new TicketTimeComparator();

    @Test
    public void testHashCode() {
       int expected = Objects.hash(ticket1.getFrom(), ticket1.getTo(), ticket1.getPrice(), ticket1.getTimeFrom(), ticket1.getTimeTo());
       int actual = ticket1.hashCode();
       Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEqualsTrue() {
        Ticket ticket2 = new Ticket("Екатеринбург", "Москва", 7000, 8, 10);
        Boolean expected = true;
        Boolean actual = ticket1.equals(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEqualsSelf() {
        Boolean expected = true;
        Boolean actual = ticket1.equals(ticket1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEqualsNotFrom() {
        Ticket ticket2 = new Ticket("Казань", "Москва", 7000, 8, 10);
        Boolean expected = false;
        Boolean actual = ticket1.equals(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEqualsNotTo() {
        Ticket ticket2 = new Ticket("Екатеринбург", "Казань", 7000, 8, 10);
        Boolean expected = false;
        Boolean actual = ticket1.equals(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEqualsNotPrice() {
        Ticket ticket2 = new Ticket("Екатеринбург", "Москва", 6000, 8, 10);
        Boolean expected = false;
        Boolean actual = ticket1.equals(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEqualsNotTimeFrom() {
        Ticket ticket2 = new Ticket("Екатеринбург", "Москва", 7000, 7, 10);
        Boolean expected = false;
        Boolean actual = ticket1.equals(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEqualsNotTimeTo() {
        Ticket ticket2 = new Ticket("Екатеринбург", "Москва", 7000, 8, 11);
        Boolean expected = false;
        Boolean actual = ticket1.equals(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEqualsNull() {
        Boolean expected = false;
        Boolean actual = ticket1.equals(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEqualsWrongObject() {
        Boolean expected = false;
        Boolean actual = ticket1.equals(comparator);
        Assertions.assertEquals(expected, actual);
    }
}
