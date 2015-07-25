package MaxPoint;

import java.util.HashMap;
import java.util.Iterator;

public class MaxPoint {
    public int maxPointSolution(Point[] points){
    	int maxNum=0;
    	
    	for(int i=0;i<points.length;i++){
    		HashMap<Double,Integer> pointRecord=new HashMap<Double,Integer>();
    		int localMax=0;
    		for(int j=0;j<points.length;j++){
    			if(i==j){
    				continue;
    			}
    			double lineSlope=slope(points[i],points[j]);
    			//System.out.println("i= "+i+";j= "+j);
    			//System.out.println("slope= "+lineSlope);
    			if(!pointRecord.containsKey(lineSlope)){
    				pointRecord.put(lineSlope, 2);
    			}else{
    				int record=pointRecord.get(lineSlope);
    				record++;
    				pointRecord.put(lineSlope, record);
    			}
    			localMax=maxNum(pointRecord);
    			
    			
    		}
    		maxNum=Math.max(maxNum, localMax);
    		
    		
    	}
    	return maxNum;
    	
    	
    	
    	
    	
    	
    }
    private double slope(Point a,Point b){
    	if(a.x==b.x){
    		return Double.POSITIVE_INFINITY;
    	}else{
    		double lineSp=((double)(a.y-b.y)*1.0/(double)(a.x-b.x));
    		//System.out.println(lineSp);
    		return lineSp;
    	}
    	
    	
    }
    private int maxNum(HashMap<Double,Integer> map){
    	int max=0;
    	Iterator it=map.keySet().iterator();
    	while(it.hasNext()){
    		max=Math.max(max,  map.get(it.next()));
    	}
    	return max;
    	
    }
    public static void main(String[] args){
    	Point p1=new Point(1,1);
    	Point p2=new Point(2,2);
    	Point p3=new Point(3,3);
    	Point p4=new Point(3,4);
    	Point p6=new Point(6,6);
    	Point p5=new Point(4,3);
    	Point p7=new Point(8,12);
    	Point[] Serial={p1,p2,p3,p4,p5,p7,p6};
    	MaxPoint test=new MaxPoint();
    	int ans=test.maxPointSolution(Serial);
    	System.out.println(ans);
    }
    
}
