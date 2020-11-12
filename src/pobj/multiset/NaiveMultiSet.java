package pobj.multiset;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import java.util.AbstractCollection;
import java.util.ArrayList;

public class NaiveMultiSet<T> extends AbstractCollection<T> implements MultiSet<T> {

	private List<T> list;

	public NaiveMultiSet() {
		list = new ArrayList<T>();
	}
	
	public boolean add(T e, int count) {
		if (count == 0) { return false; }
		for (int i=0; i<count; i++) {
			list.add(e);
		}
		return true;
	}
	
	public boolean add(T e) {
		list.add(e);
		return true;
	}
	
	public boolean remove(Object e) {
		T t = (T) e;
		if (list.contains(t)) {
			for (int i=0; i<list.size(); i++) {
				if (list.get(i).equals(e)) {
					list.remove(i);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean remove(Object e, int count) {
		if(count<=0 || list.contains(e)==false) return false;
		T t = (T) e;	
		
		int supp=0;//supprimés
		
		for (int i=0; i<list.size() && supp<count; i++) {
			if (list.get(i).equals(e)) {
				list.remove(i);
				supp++;
			}
		}
		return true;
	}
	
	public int count(T t) {
		int cpt = 0;
		for (T e : list) {
			if (e.equals(t)) {
				cpt++;
			}
		}
		return cpt;
	}
	
	public void clear() {
		list.clear();
	}
	
	public int size() {
		return list.size();
	}
	
	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}
	
	public List<T> elements() {
		Set<T> set = new HashSet<>(list);
		return new ArrayList<T>(set);
	}

	public Comparator<T> getComparator() {
		return new NaiveMultiSetComparator();
	}
	
	private class NaiveMultiSetComparator implements Comparator<T>{
		
		@Override
		public int compare(T t1, T t2) {
			int nb1 = count(t1);
			int nb2 = count(t2);
			
			//inversé pour ordre décroissant 
			if(nb1<nb2) return 1;
			if(nb1>nb2) return -1;
			return 0;
		}
		
	}

	@Override
	public boolean isConsistent() {
		// TODO Auto-generated method stub
		int size = 0;
		int cpt;
		for (T elt : this.elements()) {
			cpt = count(elt);
			if (cpt < 0)
				return false;
			size += cpt;
		}
		return size == this.size();
	}
}