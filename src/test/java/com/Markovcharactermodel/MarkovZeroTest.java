package com.Markovcharactermodel;
import com.Markovcharactermodel.markov.MarkovOne;
import com.Markovcharactermodel.markov.MarkovZero;
import edu.duke.FileResource;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
public class MarkovZeroTest {
    // Testing for generating random text of the specified length


    @Test
    public void testToString(){
        MarkovZero markovZero = new MarkovZero();
        assertEquals("MarkovModel of order 0.", markovZero.toString());
    }

    @Test
    public void testGetRandomTextFromFile() throws IOException {
        String testData = new String(Files.readAllBytes(Paths.get("data/alice.txt")));
        MarkovOne markovOne = new MarkovOne();
        markovOne.setTraining(testData);
        String randomText = markovOne.getRandomText(500);
        assertNotNull(randomText);
        assertEquals(500, randomText.length());
    }
}
