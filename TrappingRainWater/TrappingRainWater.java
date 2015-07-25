package TrappingRainWater;

public class TrappingRainWater {
	
  public int trap(int[] A){
	  int[] lmax=new int[A.length];
	  int[] rmax=new int[A.length];
	  lmax[0]=0;
	  for(int i=1;i<A.length;i++){
		  lmax[i]=Math.max(lmax[i-1], A[i-1]);
	  }
	  rmax[A.length-1]=0;
	  for(int i=A.length-2;i>=0;i--){
		  rmax[i]=Math.max(rmax[i+1], A[i+1]);
	  }
	  int water=0;
	  for(int i=1;i<A.length-1;i++){
		  int temp=Math.min(lmax[i], rmax[i])-A[i];
		  water=water+temp;
	  }
	  return water;
  }
}
