package PascalTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static void main(String[] args){
		
		System.out.println(getRow(3).toString());
	}
	public static List<Integer> getRow(int rowIndex){
		if(rowIndex < 0){
			return null;
		}
		List<List<Integer>> triangle = pascalTriangleGenerator(rowIndex+1);
		return triangle.get(rowIndex);
	}
	
	public static List<List<Integer>> pascalTriangleGenerator(int layer){
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		
		List<Integer> level=new ArrayList<Integer>();
		level.add(new Integer(1));
		triangle.add(level);
	
		if(layer == 1){
			return triangle;
		}
		
			List<Integer> secondLevel = new ArrayList<Integer>(2);
			secondLevel.add(new Integer(1));
			secondLevel.add(new Integer(1));
			triangle.add(secondLevel);
		if(layer == 2){
			return triangle;
		}
		for(int currentLayer =3; currentLayer<=layer; currentLayer++){
			List<Integer> thisLevel = new ArrayList<Integer>(currentLayer);
			thisLevel.add(new Integer(1));
			for(int i=1;i<currentLayer-1;i++){
				List<Integer> prevLevel = triangle.get(currentLayer-2);
				int element = prevLevel.get(i-1) + prevLevel.get(i);
				thisLevel.add(new Integer(element));
			}
			thisLevel.add(1);
			triangle.add(thisLevel);
		}
			
		return triangle;
	}

}
