package PeekIterator;

import java.util.ArrayList;
import java.util.Iterator;


public class RealList<Integer> extends ArrayList<Integer>{
	
	
	
	public PeekIterator getIterator() {
		return new PeekIterator(this.iterator());
	}
	
	public void test() {
		PeekIterator pk = this.getIterator();
		System.out.println(pk.peek());
	}
	
	private  class PeekIterator implements Iterator<Integer> {
		Integer next;
		Iterator<Integer> iter;
		
		public PeekIterator(Iterator<Integer> iterator) {
			iter = iterator;
			if(iterator.hasNext()) {
				next = iterator.next();
			}
		}
		
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (next != null) ? true : false;
		}

		
		public Integer next() {
			// TODO Auto-generated method stub
			Integer res = next;
			//Integer res = new Integer(next);
			next = iter.hasNext() ? iter.next() : null;
			return res;
		}
		
		public Integer peek() {
			return next;
		}

	}
	
	public static void main(String[] args) {
		RealList list = new RealList();
		list.add(1);
		list.test();
		
	}


}
