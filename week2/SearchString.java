package week2;

public class SearchString {
  
  private static String[] strArray;
  //Input ["cat", "dog", "cxxt"]
  //void setup(String[] arr)
  //boolean isInDic("cat") // true
  //boolean isInDict ("cata") // false

  // boolean isInDict("*at") // true
  //boolean isInDict("c*t") // true
  //boolean isInDict("ct*") // false

  public static void setup(String[] strArray) {
 SearchString.strArray = strArray;
  }

public static boolean isInArray(String input) {

  //Approach 1: String substring
 //Approach 2: char[] -> String.toCharArray() 
for (String str: strArray){
  if(str.contains(input)){
    return true;
 }
}
return false;
}

//public static boolean isInArray(String input) {
  //char[] inputChars = input.toCharArray();
  //for (String str : strArray) {
   // char[] strChars = str.toCharArray();
   // if (Arrays.equals(strChars, inputChars)) {
   //   return true;
    //}
  //}
  //return false;
}



//}





public static void main(String[] args) {
  setup(new String[] {"cat", "dog", "cxxxt"});


}  
}
