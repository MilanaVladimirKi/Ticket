package ru.topacademy.javaqa.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {
    AviaSouls aviaSouls = new AviaSouls();
    TicketTimeComparator comparator = new TicketTimeComparator();

    Ticket ticket1 = new Ticket("Екатеринбург", "Москва", 7000, 8, 10);
    Ticket ticket2 = new Ticket("Екатеринбург", "Казань", 7000, 9, 10);
    Ticket ticket3 = new Ticket("Екатеринбург", "Владивосток", 20000, 22, 7);
    Ticket ticket4 = new Ticket("Екатеринбург", "Казань", 6000, 10, 12);
    Ticket ticket5 = new Ticket("Екатеринбург", "Тобольск", 3000, 14, 15);

    @Test
    public void testTicketPriceCompareTo() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        Assertions.assertEquals(1, ticket1.compareTo(ticket5));
        Assertions.assertEquals(-1, ticket1.compareTo(ticket3));
        Assertions.assertEquals(0, ticket1.compareTo(ticket2));
    }

    @Test
    public void testTicketTimeComparator() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        Ticket[] tickets = aviaSouls.findAll();
        Arrays.sort(tickets, comparator);
        Ticket[] expected = {ticket2, ticket5, ticket1, ticket4, ticket3};
        Ticket[] actual = tickets;
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearch() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        Ticket[] tickets = aviaSouls.search("Екатеринбург", "Казань");
        Ticket[] expected = {ticket2, ticket4};
        Ticket[] actual = tickets;
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchNo() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        Ticket[] tickets = aviaSouls.search("Казань", "Астана");
        Ticket[] expected = {};
        Ticket[] actual = tickets;
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortBy() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        Ticket[] tickets = aviaSouls.searchAndSortBy("Екатеринбург", "Казань", comparator);
        Ticket[] expected = {ticket2, ticket4};
        Ticket[] actual = tickets;
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortByNo() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        Ticket[] tickets = aviaSouls.searchAndSortBy("Казань", "Астана", comparator);
        Ticket[] expected = {};
        Ticket[] actual = tickets;
        Assertions.assertArrayEquals(expected, actual);
    }
}
