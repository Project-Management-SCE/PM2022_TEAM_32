package com.example.app;

import static org.junit.Assert.*;

import org.junit.Test;

public class MikvehTest {

    Mikveh m = new Mikveh("Habad", "Jerusalem","Baka","","","","","","","","","","");
    @Test
    public void getReligious_Council() {
        String c = m.getReligious_Council();
        assertEquals("Habad", c);
    }

    @Test
    public void getCity() {
        assertEquals("Jerusalem", m.getCity());
    }

    @Test
    public void getNeighborhood() {
        assertEquals("Baka", m.getNeighborhood());
    }
}