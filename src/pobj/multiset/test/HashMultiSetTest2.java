package pobj.multiset.test;
import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

import pobj.multiset.HashMultiSet;
import pobj.multiset.InvalidCountException;
import pobj.multiset.MultiSet;
import pobj.multiset.MultiSetDecorator;
import pobj.multiset.NaiveMultiSet;

public class HashMultiSetTest2{
	@Test
	public void testAdd1() throws InvalidCountException {
	MultiSet<String> m = new HashMultiSet<>();
	m.add("a");
	m.add("a",5);
	assertEquals(m.count("a"), 6);
	}

	@Test
	(expected = IllegalArgumentException.class) 
	public void testAdd2() throws InvalidCountException {
	MultiSet<String> m = new HashMultiSet<>();
	m.add("a");
	m.add("a",-1);
	}
	
	@Test
	public void testToString() {
		MultiSet<String> m = new HashMultiSet<>();
		for (String c : "lorem ipsum lorem dolor sit amet".split(" ")) {
			m.add(c);
		}
		assertEquals(m.toString(), "[lorem:2; dolor:1; amet:1; ipsum:1; sit:1; ]");
	}
	@Test
	public void testSize() {
		MultiSet<String> m = new HashMultiSet<>();
		for (String c : "helloworld".split("")) {
			m.add(c);
		}

		for (String c : "world".split("")) {
			m.remove(c);
		}

		assertEquals(m.size(), 5);
	}
	
	@Test
	public void testClear() {
		MultiSet<String> m = new HashMultiSet<>();
		for (String c : "lorem ipsum lorem dolor sit amet".split("")) {
			m.add(c);
		}
		m.clear();
		assertEquals(m.size(), 0);
	}
	
	@Test
	public void testSequence() {
		MultiSet<String> m = new HashMultiSet<>(); 
		m.add("c",4); 
		m.add("x");
		m.remove("c", 3); 
		
		assertFalse(m.add("b", 0)); 
		assertEquals(m.size(), 2);
		assertFalse(m.remove("b")); 
	}
	
	@Test
	public void testCasParticulier() {
		MultiSet<String> m = new HashMultiSet<>();
		assertFalse(m.add("c", 0));
		assertFalse(m.remove("c", 0));
		assertEquals(m.count("e"), 0);
	}
	
	@Test
	public void testDecorateur() {
		MultiSet<String> m = new MultiSetDecorator<String>(new HashMultiSet<String>());
		for (String c : "loremipsum".split("")) {
			m.add(c);
		}

		for (String c : "lorem".split("")) {
			m.remove(c);
		}

		assertEquals(m.size(), 5);

		MultiSet<String> n = new MultiSetDecorator<String>(new NaiveMultiSet<String>());
		for (String c : "loremipsum".split("")) {
			n.add(c);
		}

		for (String c : "ipsum".split("")) {
			n.remove(c);
		}
		assertEquals(n.size(), 5);

	}
	
}
