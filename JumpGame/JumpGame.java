package JumpGame;

public class JumpGame {
	public boolean canJump(int[] A){
		int jumpRange=0;
		for(int i=0;i<jumpRange;i++){
			if(A[i]+i>jumpRange){
				jumpRange=A[i]+i;
			}
			if(jumpRange>A.length-1){
				return true;
			}
		}
		return false;
	}
}
