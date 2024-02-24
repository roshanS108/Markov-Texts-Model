package com.Markovcharactermodel.markov;
import edu.duke.*;
import java.util.ArrayList;

public class Tester {

    public void testGetFollows(){

        MarkovOne markovOne = new MarkovOne();
        markovOne.setTraining("this is a test yes this is a test.");

        ArrayList<String> followList = markovOne.getFollows("es");

        System.out.println("size = " + followList.size());
        System.out.println(followList);
    }

    public void testGetFollowsWithFile(){
        MarkovOne markovOne = new MarkovOne();
        FileResource fr = new FileResource();
        String text = fr.asString();
        text = text.replace('\n', ' ');
        MarkovOne markov = new MarkovOne();
        markov.setTraining(text);
        ArrayList<String> followList = markov.getFollows("th");
        System.out.println("size = " + followList.size());
        System.out.println(followList);
    }

    public static void main(String[] args) {

        Tester test = new Tester();
        test.testGetFollows();

    }
}
