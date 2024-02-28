package com.Markovcharactermodel;
import com.Markovcharactermodel.markov.MarkovZero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MarkovZeroTest{
    // Testing for generating random text of the specified length

    @Test
    public void testToString(){
        MarkovZero markovZero = new MarkovZero();
        assertEquals("MarkovModel of order 0.", markovZero.toString());
    }




}
