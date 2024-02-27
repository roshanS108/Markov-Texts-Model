package com.Markovcharactermodel;
import com.Markovcharactermodel.markov.MarkovOne;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MarkovOneTest {
    @Test
    public void testGetRandomTextFromFile() throws IOException {
        String testData = new String(Files.readAllBytes(Paths.get("data/alice.txt")));
        MarkovOne markovOne = new MarkovOne();
        markovOne.setTraining(testData);
        String randomText = markovOne.getRandomText(500);
        assertNotNull(randomText);
        assertEquals(500, randomText.length());
    }

    @Test
    public void testGetFollowsWithSingleChar() {
        MarkovOne markovOne = new MarkovOne();
        markovOne.setTraining("abracadabra");
        //b, c, d, r

        // Test the key "a"
        List<String> followsA = markovOne.getFollows("a");
        assertEquals(List.of("b", "c", "d", "b"), followsA);


    }
    @Test
    public void testGetRandomTextContainsOnlyCharacters() {
        String text = "this is a test yes this is a test.";
        MarkovOne markovOne = new MarkovOne();
        markovOne.setTraining(text);

        String result = markovOne.getRandomText(15); // Generate random text of length 15
        assertTrue(result.matches("^[a-zA-Z]+$"), "The text does not contain any numbers"); // Check if the result contains only characters
    }
    @Test
    public void testGetFollows(){




    }

}
