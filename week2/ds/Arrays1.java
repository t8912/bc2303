package week2.ds;

public class Arrays1 {
  //Assumption: You are already familar with data types (e.g String ....)
  public static void main(String[] args) {
    //Declare array referenece: String[] strs
    //Initialize instance of array, and assign to object reference 
    
    String[] strs = new String [10];
    String[] strs2 = new String[]{"123","abc"};

    // update values in the String array
    //cannot reduce or add array.length

    strs [0] = new String("hello");
    strs [1] = "hello";
    int length = strs.length; //3
    length = strs2.length; //2 

    //for loop
    for (String s : strs) {
      System.out.println(s);
    }
////////////////////////////////
 ///   String [] result = new String[strs.length + strs2.length];
     //int index = 0;
///////    for (int i =0; i < strs.length; i++){
    //  result[index] = strs[i];
   //   index++; 
  //  }
  ////  for (int j = 0; j < strs2.length; j++){
  //    result[index] = strs2[j];
  //    index++;
  //  }
 ////   return result;
 //   }

   // String result = "";

/////////////////////////////////////

//for (int i =0; i < max.length; ++1){
  //result += strs[i];
//}
//if (i < strs2.length){ 
  //result+= strs2
//}
//System.out.println(result);

//for (String s1 : strs) {
  //result += S1;
//}
//for (String S1 : strs2) {
 // result += 1;
//}



  }
  
}
