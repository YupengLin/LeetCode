package WallsAndGates;

import java.util.ArrayList;
import java.util.List;

public class WallsAndGates {
	 public static void wallsAndGates(int[][] rooms) {
		 List<int[]> gates = new ArrayList<>();
		 if(rooms.length == 0 || rooms[0].length == 0 ) {
			 return;
		 }
		 for(int i = 0; i < rooms.length; i++) {
			 for(int j = 0; j < rooms[0].length; j++) {
				 if(rooms[i][j] == 0) {
					 int[] pos = {i, j};
					 gates.add(pos);
				 }
			 }
		 }
		 
		 while(!gates.isEmpty()) {
			 int[] pos = gates.get(0); gates.remove(0);
			 int row = pos[0]; int col = pos[1];
			 if(row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
				 rooms[row - 1][col] = rooms[row][col] + 1;
				 gates.add(new int[]{row - 1, col});
			 }
			 if(row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
				 rooms[row + 1][col] = rooms[row][col] + 1;
				 gates.add(new int[]{row + 1, col});
			 }
			 if(col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
				 rooms[row][col - 1] = rooms[row][col] + 1;
				 gates.add(new int[]{row, col - 1});
			 }
			 if(col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
				 rooms[row][col + 1] = rooms[row][col] + 1;
				 gates.add(new int[]{row, col + 1});
			 }
			 
		 }
		 
	 }
	 
	 public static void main(String[] args) {
		 int inf = Integer.MAX_VALUE;
		 int[][] room = {{0, inf, inf, inf},
				 		 {inf, inf, inf, inf},
				 		 {inf, inf, inf, 0}};
		 wallsAndGates(room);
		 for(int i = 0; i < room.length; i++) {
			 for(int j = 0; j < room[0].length; j++) {
				 System.out.print(room[i][j]);
			 }
			 System.out.println("");
		 }
	 }
}
