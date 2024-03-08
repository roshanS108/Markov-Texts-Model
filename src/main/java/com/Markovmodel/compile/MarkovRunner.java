package com.Markovcharactermodel.compile;
import com.Markovcharactermodel.markov.*;
import edu.duke.*;

public class MarkovRunner {
    public void runMarkovZero() {
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovZero markov = new MarkovZero();
		markov.setTraining(st);
		markov.setRandom(101);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}

	public void runMarkov(){
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovThree markov = new MarkovThree();
		markov.setTraining(st);
//		markov.setRandom(101);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}
	public void runMarkovOne() {
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovOne markOne = new MarkovOne();
		markOne.setTraining(st);
		markOne.setRandom(273);
		for(int k=0; k < 3; k++){
			String text = markOne.getRandomText(500);
			printOut(text);
		}
	}
	public void runMarkovFour() {
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovFour markov = new MarkovFour();
		markov.setTraining(st);
		for(int k=0; k < 3; k++){
			markov.setRandom(25);
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}
	public void runMarkovModel() {
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovModel markov = new MarkovModel(100);
		markov.setTraining(st);
		for(int k=0; k < 3; k++){
			markov.setRandom(38);
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}
/*	private void printOut(String s){
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
	}*/

	public void printOut(String s){
		String[] words = s.split("\\s+");
		System.out.println("The words is: " + words.toString());
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


	
}
