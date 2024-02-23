package com.Markovcharactermodel.markov;

import java.util.ArrayList;
import java.util.Random;

public class MarkovThree {

    private String myText;
    private Random myRandom;

    public MarkovThree() {
        myRandom = new Random();
    }

    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    public void setTraining(String s){
        myText = s.trim();
    }

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

    public ArrayList<String> getFollows(String key){

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

}
