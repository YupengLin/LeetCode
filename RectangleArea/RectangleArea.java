package RectangleArea;

/**
 * Created by linyupeng on 9/10/15.
 */
public class RectangleArea {
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
         int xOverlap  = 0;
        if(A <= E && E <= C ){
             xOverlap = C - E;
         }
        if(A <= G && G <= C) {
            xOverlap = G - A;
        }
        if( E<= A && C <= G) {
            xOverlap = C -A;
        }
        if( A <= E && G <= C) {
            xOverlap = G - E;
        }
        int yOverlap = 0;
        if(B <= H && H <= D) {
            yOverlap = H - B;
        }
        if(B <= F && F <= D) {
            yOverlap = D - F;
        }
        if(F <= B && D <= H) {
            yOverlap = D - B;
        }
        if(B <= F && H <= D) {
            yOverlap = H - F;
        }

       int overlap = xOverlap * yOverlap;
       int aArea = (C - A) * (D - B);
       int bArea = (G - E) * (H - F);
        return aArea + bArea - overlap;
    }

    public static void main(String[] args) {
        System.out.println(computeArea(-2, -2, 2, 2, 1, -3, 3, 3));
    }
}

