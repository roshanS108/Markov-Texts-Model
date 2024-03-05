package com.Markovcharactermodel;

import com.Markovcharactermodel.efficient.EfficientMarkovModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EfficientMarkovModelTest {

    private EfficientMarkovModel efficientMarkovModel;

    @BeforeEach
    void setUp(){
        efficientMarkovModel = new EfficientMarkovModel(2);
    }

    /**
     * Test case to verify the constructor of EfficientMarkovModel class
     * Checks if the markov model is initialized correct with n-->2 parameter.
     */
    @Test
    void testConstructor(){
        assertEquals(2, efficientMarkovModel.getN());
    }

    /**
     * Test cases to verify .getFollowsMa doesn't returns null value
     */
    @Test
    void testGetFollowsMap(){
        assertNotNull(efficientMarkovModel.getFollowsMap());
    }


}
