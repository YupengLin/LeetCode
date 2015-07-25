package Parentheses;

import java.util.*;

public class Parentheses{
	public List<String> generateParenthesis(int n){
       int currLeft=0;
       int currRight=0;
       List<String> record=new ArrayList<String>();
       if(n==0){
       	return record;
       }
       generate(0,0,n,record,"");
       return record;
      
	}

	private void generate(int currLeft,int currRight, int n,List<String>record, String parentheses){
            if(currRight==n){
            	String newAns=new String(parentheses);
            	record.add(newAns);
            	return;
            }

            if(currLeft==currRight){
            	generate(currLeft+1,currRight,n,record,parentheses+"(");
            }

            if(currLeft>currRight && currLeft<n){
            	generate(currLeft+1,currRight,n,record,parentheses+"(");
            	generate(currLeft,currRight+1,n,record,parentheses+")");

            }
            if(currLeft==n){
            	generate(currLeft,currRight+1,n,record,parentheses+")");
            }


	}
	public static void main(String[] args){
		Parentheses pp=new Parentheses();
		List<String> ans=pp.generateParenthesis(3);
		for(String p: ans){
			System.out.println(p);
		}
	}
}
