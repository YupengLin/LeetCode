package Flatten2DVector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Vector2D {
		Iterator<List<Integer>> row;
		Iterator<Integer> col;
	 	public Vector2D(List<List<Integer>> vec2d) {
	        row = vec2d.iterator();
	        List<Integer> firstRow = null;
	        if(row.hasNext()) {
	        	firstRow = row.next();
	        	col = firstRow.iterator();
	        }
	        
	    }

	    public int next() {
	    	return col.next();
	    }

	    public boolean hasNext() {
	    	 if(row == null || col == null) return false;
	       if(col.hasNext()) {
	    	   return true;
	       } else {
	    	 while(row.hasNext() ) {
	    		 List<Integer> nextRow = row.next();
	    		 col = nextRow.iterator();
	    		 if(col.hasNext()) {
	    			 return true;
	    		 }
	    	 }
	    	 return false;
	       }
	    }
	    
	    public static void main(String[] args) {
	    	List<List<Integer>> vec2d = new ArrayList<>();
	    	List<Integer> row1 = new ArrayList<>();
	    	//row1.add(1); row1.add(2); row1.add(3);
	    	List<Integer> row2 = new ArrayList<>();
	    	//row2.add(3);
	    	List<Integer> row3 = new ArrayList<>();
	    	row3.add(4); row3.add(5);
	    	
	    	vec2d.add(row1); vec2d.add(row2); vec2d.add(row3);
	    	
	    	Vector2D v2 = new Vector2D(vec2d);
	    	while(v2.hasNext()){
	    		System.out.println(v2.next());
	    	}
	    	
	    }
}
