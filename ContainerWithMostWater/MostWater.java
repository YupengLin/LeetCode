package ContainerWithMostWater;

public class MostWater {
  public int maxArea(int [] height){
	  int maxV=0;
	  int start=0;
	  int end=height.length-1;
	  while(start<end){
		  int volume=Math.min(height[start],height[end])*(end-start);
		  System.out.println("temp="+volume);
		  maxV=Math.max(volume, maxV);
		  if(height[start]>height[end]){
			  end--;
		  }else{
			  start++;
		  }
	  }
	  
	  return maxV;
  }
  public static void main(String[] args){
	  MostWater mw=new MostWater();
	  int [] area={1,1};
	  System.out.println(mw.maxArea(area));
  }
}
