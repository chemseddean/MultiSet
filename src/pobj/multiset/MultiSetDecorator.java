package pobj.multiset;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MultiSetDecorator<T>  implements MultiSet<T> {
	private MultiSet<T> decorated; 
	
	public MultiSetDecorator(MultiSet<T> decorated){
		this.decorated = decorated;
	}
	
	@Override
	public boolean add(T e, int count) {
		// TODO Auto-generated method stub
		return decorated.add(e, count);
		}

	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		return decorated.add(e);
	}

	@Override
	public boolean remove(Object e) {
		// TODO Auto-generated method stub
		return decorated.remove(e);
	}

	@Override
	public boolean remove(Object e, int count) {
		// TODO Auto-generated method stub
		return decorated.remove(e, count);
	}

	@Override
	public int count(T o) {
		// TODO Auto-generated method stub
		return decorated.count(o);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		decorated.clear();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return decorated.size();
	}

	@Override
	public List<T> elements() {
		// TODO Auto-generated method stub
		return decorated.elements();
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return decorated.iterator();
	}

	@Override
	public Comparator<T> getComparator() {
		// TODO Auto-generated method stub
		return decorated.getComparator();
	}
	
	public boolean isConsistent() {
		return this.decorated.isConsistent();
	}

}
