package com.Markovmodel.markov;

import com.Markovmodel.models.AbstractMarkovModel;

import java.util.ArrayList;

public class MarkovThree extends AbstractMarkovModel {

    //this field is for testing
    private String keyForTesting;
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - 3);
        String key = myText.substring(index, index + 3);
        sb.append(key);

        for(int k=0; k < numChars - 2; k++){
            ArrayList<String> followList = getFollows(key);
            if (followList.size() == 0) {
                break;
            }
            index = myRandom.nextInt(followList.size());
            String next = followList.get(index);
            sb.append(next);

            key = key.substring(1) + next;
        }
        return sb.toString();
    }
    public String toString(){
        return "MarkovModel of order 3.";
    }



}
