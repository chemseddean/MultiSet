package pobj.multiset;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import pobj.util.Chrono;

public class WordCount {
	
	public static void wordcount (MultiSet<String> ms) throws IOException {
		
		//chargement du fichier et decoupage en mots
		
		String file = "data/WarAndPeace.txt";
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while ((line = br.readLine())!=null) {
			for (String word : line.split("\\P{L}+")) {
				if (word.equals("")) continue; // ignorer les mots vides (espaces)
				ms.add(word);
			}
		}
		br.close(); 
		
		//liste sans doublons
		
		List<String> list = ms.elements();
		
		//On doit comparer pour trier
		
		list.sort(ms.getComparator());
		
		//affichage
		int nbAffiche = 10;
		if(nbAffiche>list.size()) nbAffiche=list.size();
		
		String s = "";
		
		for (int i=0; i<nbAffiche; i++) {
			s += list.get(i)+"  (" + ms.count(list.get(i))+" fois)\n";
		}
		System.out.println(s);
		
	}
	
	
	public static void main(String args[]) {
		
		HashMultiSet<String> HashMultiSet = new HashMultiSet<String>();
		System.out.println("---HashMultiSet---");
		Chrono chrono = new Chrono(); 
		try {
			wordcount(HashMultiSet);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		chrono.stop();
		
		System.out.println("---NaiveMultiSet---");
		
		NaiveMultiSet<String> naive = new NaiveMultiSet<String>();
		Chrono chronoNaive = new Chrono();
		try {
			wordcount(naive);
		} catch (IOException e) {
			e.printStackTrace();
		}
		chronoNaive.stop();
	}
	
	
}