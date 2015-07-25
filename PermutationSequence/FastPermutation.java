package PermutationSequence;

import java.util.*;

public class FastPermutation {
  public String getPermutation(int n, int k){
	  int t=1;
	  ArrayList<Integer> numbers=new ArrayList<Integer>();
	  StringBuilder kth=new StringBuilder();
	  for(int i=1;i<=n;i++){
		  t=t*i;
		  numbers.add(i);
	  }
	  t=t/n;  //t=(n-1)!
	  k=k-1; //array are 0 based index
	  for(int i=n-1;i>=1;i--){
		  int index=k/t;
		  int num=numbers.get(index);
		  kth.append(num);
		  numbers.remove(index);
		  k=k%t;    
		  t=t/i;  //(n-2)!
	  }
	      kth.append(String.valueOf(numbers.get(0)));
		  return kth.toString();
	  }
  public static void main(String[] args){
	  FastPermutation fp=new FastPermutation();
	  System.out.println(fp.getPermutation(9, 113));
  }
  }

