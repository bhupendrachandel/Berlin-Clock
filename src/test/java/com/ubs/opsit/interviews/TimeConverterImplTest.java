package com.ubs.opsit.interviews;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeConverterImplTest {

    TimeConverterImpl testTimeConverter;

    public TimeConverterImplTest() {
        testTimeConverter = new TimeConverterImpl();
    }

    @Test
    public void testGetHours(){
        assertEquals("RROO\nRRRO\n",testTimeConverter.getHours(13));
        //assertEquals("RROO\nRROO\n",testTimeConverter.getHours(13));
    }

    @Test
    public void testGetMinutes(){
        assertEquals("YYROOOOOOOO\nYYOO",testTimeConverter.getMinutes(17));
    }

    @Test
    public void testGetSeconds(){
        assertEquals("O",testTimeConverter.getSeconds(01));
    }

    @Test
    public void testConvertTime(){
        assertEquals("O\nRROO\nRRRO\nYYROOOOOOOO\nYYOO",testTimeConverter.convertTime("13:17:01"));
    }

}