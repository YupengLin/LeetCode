package epic;

public class MergeTwoList {
	public static int[] merge(int[] l1,int[] l2){
		if(l1.length==0){
			return l2;
		}
		if(l2.length==0){
			return l1;
		}
		int[] merge =new int[l1.length+l1.length];
		int i=0;
		int j=0;
		int count=0;
		while(i<l1.length && j<l2.length){
			if(l1[i]<l2[j]){
				if(count-1<0){
					merge[0]=l1[i];
					count++;
					
				}
				else if(merge[count-1]<l1[i]){
					merge[count]=l1[i];
					count++;
					
				}
				
				i++;
			}else{
				if(i+j-1<0){
					merge[0]=l2[j];
				    count++;
				}
				else if(merge[count-1]<l2[j]){
					merge[count]=l2[j];
					count++;
				}
				
				j++;
			}
			
		}
		if(i==l1.length){
			for(;j<l2.length;j++){
				if(merge[count-1]<l2[j]){
					merge[count]=l2[j];
					count++;
					
				}
			}
			
		}
		
		if(j==l2.length){
			for(;i<l1.length;i++){
				if(merge[count-1]<l1[i]){
					merge[count]=l1[i];
					count++;
				}
			}
		}
		
		
		return merge;
		
	}
	
	public static void main(String[] args){
		int[] l1={1,2,2,3,4,67,89,110,120,150};
		int[] l2={2,3,3,4,34,68,90};
		int[] ans=merge(l1,l2);
		for(int i=0;i<ans.length;i++){
			System.out.println(ans[i]);
		}
	}

}
