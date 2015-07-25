package SimplifyPath;

import java.util.Stack;

public class SimplifyPath {
  public String simplifyPath(String path){
	  if(path == null){
		  return null;
	  }
	  if(path.length()==0){
		  return "/";
	  }
	  Stack<String> store=new Stack<String>();
	  String[] dictionaries=path.split("/");
	  for(String dir: dictionaries){
		  if(dir.length()==0){
			  continue;
		  }
		  if(dir.equals("..")){
			  if(!store.isEmpty()){
				  store.pop();
			  }
		  }
		  if(dir.equals(".")){
			  continue;
		  }
		  if(!dir.equals("..") && !dir.equals(".")){
			  store.push(dir);
		  }
		  
	  }
	  if(store.isEmpty()){
		  return "/";
	  }
	  String[] simpleDics=store.toArray(new String[store.size()]);
	  String simplePath="";
	  for(String n : simpleDics){
		  simplePath=simplePath+"/"+n;
	  }
	  return simplePath;
	  
  }
  
  public static void main(String[] args){
	  SimplifyPath sp=new SimplifyPath();
	  System.out.println(sp.simplifyPath("/home/"));
	  System.out.println(sp.simplifyPath("/a/./b/../../c/"));
	  System.out.println(sp.simplifyPath("/home//foo"));
  }
}
