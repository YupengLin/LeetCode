package NQueens;
import java.util.*;

public class NQueens {
  public List<String[]> solveNQueens(int n){
	  ArrayList<String[]> result=new ArrayList<String[]>();
	  if(n<1){
		  return result;
	  }
	  String[] rows=new String[n];
	  
	  int row=0;
	  
	  solutions(row,n,rows,result);
	  
	  return result;
  }
  
  public void solutions(int currRow, int n, String[] rows, ArrayList<String[]> result ){
	  if(currRow>=n){
		  result.add(rows.clone());
		  return;
	  }
	  for(int col=0;col<n;col++){
		  if(!isValid(col,currRow,rows)){
			  continue;
		  }
		  
		  char[] queen=new char[n];
		  Arrays.fill(queen, '.');
		  queen[col]='Q';
		  rows[currRow]=new String(queen);
		  solutions(currRow+1,n,rows,result);
	  }
	  
	  
  }
  private boolean isValid(int col,int currRow,String[] rows){
	  for(int i=0;i<currRow;i++){
		  int qCol=rows[i].indexOf("Q");
		  if(qCol==col){
			  return false;
		  }
		  int rowDistance=Math.abs(currRow-i);
		  int colDistance=Math.abs(qCol-col);
		  if(rowDistance==colDistance){
			  return false;
		  }
		  
	  }
	  return true;
	  
  }
}
