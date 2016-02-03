package lowestCommonAncestorInBinaryTree;

import java.io.*;
import java.util.Hashtable;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by linyupeng on 12/7/15.
 */
public class WordCount {
    public static void main(String[] args) throws IOException{
        Hashtable<String, Integer>  freq = new Hashtable<>();
        String fileName = "license.txt";

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
           // StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {

                line = br.readLine();
                StringTokenizer st = new StringTokenizer(line);
                while(st.hasMoreTokens()) {
                    String token = st.nextToken();
                    if(freq.containsKey(token)) {
                        int num = freq.get(token);
                        num++;
                        freq.put(token, num);
                    } else {
                        freq.put(token, 1);
                    }
                }

            }

        } catch (IOException e) {
             System.out.println(e);
        } finally {
            br.close();
        }


        BufferedWriter output = null;
        try {
            File file = new File("stat.txt");
            output = new BufferedWriter(new FileWriter(file));

            Set<String> keys = freq.keySet();
            for(String key : keys) {
                String singleWord = "[ " + keys + " ] " + freq.get(keys);
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            output.close();
        }




    }


}
