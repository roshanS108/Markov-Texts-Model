package com.Markovmodel.compile;
import com.Markovmodel.interfaces.IMarkovModel;
import com.Markovmodel.markov.MarkovWordOne;
import edu.duke.*;
public class MarkovRunnerWord {
    public void runModel(IMarkovModel markov, String text, int size){
        markov.setTraining(text);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
            String st = markov.getRandomText(size);
            printOut(st);
        }
    }
    public void runModel(IMarkovModel markov, String text, int size, int seed){
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
            String st = markov.getRandomText(size);
            printOut(st);
        }
    }

    public void runMarkov() {
        FileResource fr = new FileResource();
        String st = fr.asString();

        st = st.replace('\n', ' ');

        MarkovWordOne markovWordOne = new MarkovWordOne();

//        MarkovWordTwo markovWordTwo = new MarkovWordTwo();
        runModel(markovWordOne, st, 120,175);
//
//        runModel(markovWordTwo, st, 120, 832);

    }

    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }

    public static void main(String[] args) {
        MarkovRunner markovRunner = new MarkovRunner();
        markovRunner.runMarkov();
    }

}
