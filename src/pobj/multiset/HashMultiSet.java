package pobj.multiset;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class HashMultiSet<T> extends AbstractCollection<T> implements MultiSet<T>{
	
	private Map<T,Integer> HashMap;
	
	public HashMultiSet(){
		
		HashMap= new HashMap<T,Integer>();
	}
	
	
	public HashMultiSet(Collection<T> collect) {
		
		HashMap= new HashMap<T,Integer>();
		for (T c:collect)
			this.add(c);
	}
	
	public boolean add(T e,int count) {

		if (count==0)
			return false;
		
		if (count==1)
			this.add(e);
		
		int i = 0;
		if (HashMap.containsKey(e)) {
			i = HashMap.get(e); 

				HashMap.put(e, count+i);

		return HashMap.get(e)==i+count; }
		
		
		HashMap.put(e, count+i);
		
		return HashMap.get(e)==i+count; 
	}
	
	@Override
	public boolean add(T e) {
		
		if (!HashMap.containsKey(e)) {
			
			return (HashMap.put(e, 1) == null) ;
		}
	return false;
	}
	
	@Override
	public boolean remove(Object e) {
		// TODO Auto-generated method stub
		Object res	=	HashMap.replace((T)e,HashMap.get(e)-1);
		if (res == null )
				return false;
		
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object e, int count) {
		// TODO Auto-generated method stub
		Integer res= HashMap.get(e);/// get 
		if( HashMap.containsKey(e)) {
			if(count==1)
			
			HashMap.remove(e);
			
		}
		if (count==0)  
			return false;
		if(res == null) return false;
		
		if(count>=res)
			HashMap.replace((T) e,0);
			
		
		if(count<HashMap.get(e))
			
			HashMap.replace((T)e, HashMap.get(e) - count); 
			
		
		return true;

	}
	
	@Override
	public int count(T o) {
		
		if(!HashMap.containsKey(o))
			return 0;
		Object res = HashMap.get(o);
		if (res == null)
				return 0; 
		else 
			return (Integer)res;
	}	
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		HashMap.clear(); 
		
	}
	@Override
	public int size() {
	
		int result=0;
		
		for(T e:HashMap.keySet())

			result+=HashMap.get(e);
		
		return result;
	
	}
	
	@Override
	public List<T> elements() {
		return new ArrayList<>(this.HashMap.keySet());
	}

	
	@Override
	public Iterator<T> iterator() {
		return new HashMultiSetIterator();
	}
	
	
	private class HashMultiSetIterator implements Iterator<T>{
		
		private Iterator<Map.Entry<T, Integer>> mapIter;
		private int cpt; //nombre de fois qu'on a retourné l'element actuel
		private Map.Entry<T, Integer> courant; //element courant 
		
		private HashMultiSetIterator() {
			
			mapIter = HashMap.entrySet().iterator();
			
			if(mapIter.hasNext()) {
				
				courant = mapIter.next();
				cpt = 0;
			}
			else {
				cpt=-1; //vide (courant=null)
			}
			
		}

		@Override
		public boolean hasNext() {
			
			if(cpt==-1) { //vide
				return false;
			}
			if(mapIter.hasNext()) {
				return true;
			}
			//dernier tuple
			int nbOccur = courant.getValue();
			return cpt<nbOccur;
		}

		@Override
		public T next() {
			if( hasNext() ) {
				int nbOccur = courant.getValue();
				if(cpt<nbOccur) {
					
					//retourner le meme element
					
					cpt++;
					return courant.getKey();
				}
				else { // cas ou cpt==nbOccur
					
					courant = mapIter.next();	 //passe au suivant
					
					cpt = 1;//on retourne une occurence de l'element
					
					return courant.getKey();
				}
			}
			
			throw new NoSuchElementException();
		}
		
	}
	
	
	public Comparator<T> getComparator() {
		return new HashMultiSetComparator();
	}
	
	private class HashMultiSetComparator implements Comparator<T>{
		
		@Override
		public int compare(T t1, T t2) {
			int nb1 = HashMap.get(t1);
			int nb2 = HashMap.get(t2);
			
			// inversé pour ordre décroissant
			if(nb1<nb2) return 1;
			if(nb1>nb2) return -1;
			return 0;
		}

	}
	
}
