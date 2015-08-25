package ValidSudoku;

import java.awt.List;
import java.util.ArrayList;

public class ValidSudoku {
 public boolean isValidSudoku(char[][] board){
	    ArrayList<boolean[]> rowChecker=new ArrayList<boolean[]>();
		 ArrayList<boolean[]> colChecker=new ArrayList<boolean[]>();
		 ArrayList<boolean[]> blockChecker=new ArrayList<boolean[]>();
		 for(int i=0;i<9;i++){
		     rowChecker.add(new boolean[9]);
		     colChecker.add(new boolean[9]);
		     blockChecker.add(new boolean[9]);
		 }
		 for(int i=0;i<9;i++){
			 for(int j=0;j<9;j++){
				 if(board[i][j]=='.'){
					 continue;
				 }
				 int value=board[i][j]-'1';
				 if(rowChecker.get(i)[value]==true 
						 || colChecker.get(j)[value]==true 
						 || blockChecker.get(i/3*3+j/3)[value]==true){
							 return false;
						 }
				 else{
					 rowChecker.get(i)[value]=true; 
					 colChecker.get(j)[value]=true ;
					 blockChecker.get(i/3*3+j/3)[value]=true;
				 }
			 }
		 }
		 return true;
 }
 
 public static void main(String[] args){
	 
 }
}
