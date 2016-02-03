package PeekIterator;

import java.util.Iterator;

public class PeekIterator implements Iterator<Integer> {
	Integer next;
	Iterator<Integer> iter;
	
	public PeekIterator(Iterator<Integer> iterator) {
		iter = iterator;
		if(iterator.hasNext()) {
			next = iterator.next();
		}
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return (next != null) ? true : false;
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		Integer res = new Integer(next);
		next = iter.hasNext() ? iter.next() : null;
		return res;
	}
	
	

}
