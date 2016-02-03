package ZigzagIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZigzagIterator {
	Iterator<Integer> iter1;
	Iterator<Integer> iter2;
	boolean v1Next = false;
	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		iter1 = v1.iterator();
		iter2 = v2.iterator();
		v1Next = true;
	}
	
	public int next() {
		if(v1Next) {
			v1Next = !v1Next;
			if(iter1.hasNext()) {
				return iter1.next();
			} else {
				return iter2.next();
			}
		} else {
			v1Next = !v1Next;
			if(iter2.hasNext()) {
				return iter2.next();
			} else {
				return iter1.next();
			}
		}
	}
	
	public boolean hasNext() {
		if(v1Next && iter1.hasNext()) {
			return true;
		} else if(v1Next && !iter1.hasNext()) {
			return iter2.hasNext();
		} else if(!v1Next && iter2.hasNext()) {
			return true;
		} else {
			return iter1.hasNext();
		}
 	}
	
	public static void main(String[] args) {
		List<Integer> v1 = new ArrayList<>();
		v1.add(1); v1.add(2);
		List<Integer> v2 = new ArrayList<>();
		v2.add(3); v2.add(4); v2.add(5); v2.add(6);
		ZigzagIterator zi = new ZigzagIterator(v1, v2);
		while(zi.hasNext()) {
			System.out.println(zi.next());
		}
	}
}
