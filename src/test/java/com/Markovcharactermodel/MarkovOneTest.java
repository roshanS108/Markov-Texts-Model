package com.Markovcharactermodel;
import com.Markovcharactermodel.markov.MarkovOne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class MarkovOneTest {
    private MarkovOne markovOne;
    @BeforeEach
    void setUp() {
        markovOne = new MarkovOne();
        // Assuming there's a method to set 'myText' for testing
        markovOne.setMyText("some test text");
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

    @Test
    public void testGetFollowsWithSingleChar() throws IOException {
        String testData = new String(Files.readAllBytes(Paths.get("data/alice.txt")));
        MarkovOne markovOne = new MarkovOne();
        markovOne.setTraining(testData);
        String randomText = markovOne.getRandomText(500);
        assertNotNull(randomText);
        String key = markovOne.getKeyForTesting();
        System.out.println("key is: " + key);
        List<String> expectedFollows = new ArrayList<>();
        //Iterate through input text
        for(int i = 0; i<markovOne.getMyText().length()-1; i++){
            if (markovOne.getMyText().substring(i, i+1).equals(key)){
                //store that data in expectedFollows
                expectedFollows.add(markovOne.getMyText().substring(i+1, i+2));
            }
        }
        // Test the any key
        List<String> followsA = markovOne.getFollows(key);
        assertEquals(expectedFollows, followsA);
        assertEquals(500, randomText.length());

    }

    @Test
    void testGetRandomTextReturnsEmptyOnNullMyText() {
        markovOne.setMyText(null);
        assertEquals("", markovOne.getRandomText(5));
    }
    @Test
    public void testGetRandomTextContainsOnlyCharacters() {
        String text = "this is a test yes this is a test.";
        MarkovOne markovOne = new MarkovOne();
        markovOne.setTraining(text);

        String result = markovOne.getRandomText(15); // Generate random text of length 15

    }

}
