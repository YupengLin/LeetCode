package ThreeSum;
import java.util.*;

public class CorrectSolution {
	public List<List<Integer>> threenum(int[] num){
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		if(num.length<3){
			return result;
		}

		for(int i=0;i<=num.length-2;i++){
			int negate=-num[i];
			HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();

			

			for(int j=i+1;j<num.length;j++){
				int toFind=negate-num[j];
				if(map.containsKey(toFind)){
					int k=map.get(toFind);
					List<Integer> triple=new ArrayList<Integer>();
					triple.add(num[i]);
					triple.add(num[j]);
					triple.add(num[k]);
					result.add(triple);

				}
				map.put(num[j],j);
			}

		}
		
		return result;
	}
	public static void main(String[] args){
		int[] array={-1,0,1,2,-1,-4};
		CorrectSolution threeS=new CorrectSolution();
		List<List<Integer>> ans=threeS.threenum(array);
		for(List<Integer> list:ans){
			System.out.println(list.toString());
		}
	}
	
}
