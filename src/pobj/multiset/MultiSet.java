package pobj.multiset;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public interface MultiSet<T> {
	public boolean add(T e, int count);
	public boolean add(T e);
	public boolean remove(Object e);
	public boolean remove(Object e, int count);
	public int count(T o);
	public void clear();	
	public int size();
	List<T> elements();
	Iterator<T> iterator();
	public Comparator<T> getComparator();
	public boolean isConsistent();
}
