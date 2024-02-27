package com.Markovcharactermodel;
import com.Markovcharactermodel.markov.MarkovOne;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class MarkovOneTest {
    @Test
    public void testGetRandomText(){

        MarkovOne markovOne = new MarkovOne();

        markovOne.setTraining("this is a test yes this is a test.");

        String result = markovOne.getRandomText(15);
        assertEquals(15, result.length());
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
