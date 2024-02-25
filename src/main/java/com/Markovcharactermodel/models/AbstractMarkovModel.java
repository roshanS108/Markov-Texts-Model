package com.Markovcharactermodel.models;

import com.Markovcharactermodel.interfaces.IMarkovModel;
import java.util.*;
public abstract class AbstractMarkovModel implements IMarkovModel {

    protected String myText;
    protected Random myRandom;
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    @Override
    public void setTraining(String s) {
        myText = s.trim();
    }
    @Override
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    protected ArrayList<String> getFollows(String key) {
        ArrayList<String> result = new ArrayList<String>();
        int startPos = 0;

        while(true) {
            int index = myText.indexOf(key, startPos);

            if (index == -1 || index == myText.length() - key.length()) {
                break;
            }

            result.add(myText.substring(index + key.length(), index + key.length() + 1));
            startPos = index + key.length();
        }
        return result;
    }
    @Override
    abstract public String getRandomText(int numChars);
}
