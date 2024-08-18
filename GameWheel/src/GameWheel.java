import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameWheel
{
  private ArrayList<Slice> slices; // List of slices making up the wheel
  private int currentPos;   // Position of currently selected slice on wheel


  /* Returns string representation of GameWheel with each numbered slice
   * on a new line
   */
  public String toString(){
    //Returns a string representation of the slice in the following format: “Color: red, Prize amount: $50”.
    String result = "";
    int count = 0;
    for (Slice e : slices){
      result = result + count + " - " + e + "\n";
      count++;
    }
    return result;
  }


  /* Randomizes the positions of the slices that are in the wheel, but without
   * changing the pattern of the colors
   */
  public void scramble()
  {
    int[] arrBlack = new int[4];
    int[] arrBlue = new int[8];
    int[] arrRed = new int[8];
    int arrBlackCtr = 0;
    int arrRedCtr = 0;
    int arrBlueCtr = 0;

 
    //Implement the scramble method here

    //extract the seperate slice price values in to seperate arrays
    //then shuffle those seperate areas (helper functions)
    //then combine them back into the primary array

    for(Slice s:slices){//extract price values

      if (s.getColor() == "black" )//black
        {arrBlack[arrBlackCtr] = s.getPrizeAmount();
        arrBlackCtr++;
      }
      else if (s.getColor() == "red" ) //red
        {arrRed[arrRedCtr] = s.getPrizeAmount();
        arrRedCtr++;   
      }  
      else if (s.getColor() == "blue" )///blue
        {arrBlue[arrBlueCtr] = s.getPrizeAmount();
        arrBlueCtr++;  
      } 
    }

    /* for (int e : arrBlack) {
      System.out.println("arrBlack:" + e);
    }
    for (int e : arrRed) {
      System.out.println("arrRed:" + e);
    }
    for (int e : arrBlue) {
      System.out.println("arrBlue:" + e);
    } */

    scrambleArray_helper(arrBlack);
    scrambleArray_helper(arrBlue);
    scrambleArray_helper(arrRed);

    /* for (int e : arrBlack) {
      System.out.println("arrBlack:" + e);
    }
    for (int e : arrRed) {
      System.out.println("arrRed:" + e);
    }
    for (int e : arrBlue) {
      System.out.println("arrBlue:" + e);
    } */

    //update the main array with the scrambled values
    arrBlackCtr = 0;
    arrRedCtr = 0;
    arrBlueCtr = 0;
    for(int i = 0; i < 20; i++){

      if (i%5 == 0)//black
      {
        slices.set(i, new Slice("black", arrBlack[arrBlackCtr]));
        arrBlackCtr++;
      }
      else if (i%2 == 1) //red
        {
        slices.set(i, new Slice("red", arrRed[arrRedCtr]));
        arrRedCtr++;   
      }  
      else{//blue
        slices.set(i, new Slice("blue", arrBlue[arrBlueCtr]));
        arrBlueCtr++;  
      } 
    }

    /* for (Slice s : slices) {
      System.out.println(s);
      
    } */


  }

  public void scrambleArray_helper(int[] array) 
  {
    Random rand = new Random();  
    for (int i = array.length - 1; i > 0; i--) {  
        // Generate a random index between 0 and i (inclusive)  
        int j = rand.nextInt(i + 1);  

        // Swap the elements at indices i and j  
        int temp = array[i];  
        array[i] = array[j];  
        array[j] = temp;  
    }  

    
  }


  /* Sorts the positions of the slices that are in the wheel by prize amount,
   * but without changing the pattern of the colors.
   */
  public void sort(){
    int[] arrBlack = new int[4];
    int[] arrBlue = new int[8];
    int[] arrRed = new int[8];
    int arrBlackCtr = 0;
    int arrRedCtr = 0;
    int arrBlueCtr = 0;

    //Implement the sort method here

    //extract the seperate slice price values in to seperate arrays
    //then shuffle those seperate areas (helper functions)
    //then combine them back into the primary array

    for(Slice s:slices){//extract price values

      if (s.getColor() == "black" )//black
        {arrBlack[arrBlackCtr] = s.getPrizeAmount();
        arrBlackCtr++;
      }
      else if (s.getColor() == "red" ) //red
        {arrRed[arrRedCtr] = s.getPrizeAmount();
        arrRedCtr++;   
      }  
      else if (s.getColor() == "blue" )///blue
        {arrBlue[arrBlueCtr] = s.getPrizeAmount();
        arrBlueCtr++;  
      } 
    }

    sort_helper(arrBlack);
    sort_helper(arrBlue);
    sort_helper(arrRed);

    /* for (int e : arrBlack) {
      System.out.println("arrBlack:" + e);
    }
    for (int e : arrRed) {
      System.out.println("arrRed:" + e);
    }
    for (int e : arrBlue) {
      System.out.println("arrBlue:" + e); 
    }*/

    //update the main array with the sorted values
    arrBlackCtr = 0;
    arrRedCtr = 0;
    arrBlueCtr = 0;
    for(int i = 0; i < 20; i++){

      if (i%5 == 0)//black
      {
        slices.set(i, new Slice("black", arrBlack[arrBlackCtr]));
        arrBlackCtr++;
      }
      else if (i%2 == 1) //red
        {
        slices.set(i, new Slice("red", arrRed[arrRedCtr]));
        arrRedCtr++;   
      }  
      else{//blue
        slices.set(i, new Slice("blue", arrBlue[arrBlueCtr]));
        arrBlueCtr++;  
      } 
    }

  }

  public static void sort_helper(int[] array) {//selectionm sort
    int temp = 0;

    for (int index = 0; index < array.length; index++) {
      int minval = 10000000;
      int swapindex = 0;

      //look for smallest
      for (int index2 = index; index2 < array.length; index2++) {
        if (array[index2] < minval) {
          minval = array[index2];
          swapindex = index2;
        }
      }

      //swap
      temp = array[index];
      array[index] = minval;
      array[swapindex] = temp;
    }
  }


  /* COMPLETED METHODS - YOU DO NOT NEED TO CHANGE THESE */

  /* Creates a wheel with 20 preset slices
   */
  public GameWheel()
  {
    this(getStandardPrizes());
  }

  /* Creates a wheel with 20 slices, using values from array parameter
   */
  public GameWheel(int[] prizes)
  {
    currentPos = 0;
    slices = new ArrayList<Slice>();
    for(int i = 0; i < 20; i++){
      int pa = 0;
      String col = "blue";
      if(i < prizes.length)
        pa = prizes[i];
      if (i%5 == 0)
        col = "black";
      else if (i%2 == 1)
        col = "red";
      slices.add(new Slice(col, pa));
    }
  }

  /* Spins the wheel by so that a different slice is selected. Returns that
   * slice (Note: the 10 slices following the current slice are more likely to
   * be returned than the other 10).
   */
  public Slice spinWheel()
  {
    //spin power between range of 1-50 (inclusive)
    int power = (int)(Math.random()*50 + 1);
    int newPos = (currentPos + power) % slices.size();
    currentPos = newPos;
    return slices.get(currentPos);
  }

  public Slice getSlice(int i){
    int sliceNum = i;
    if(i < 0 || i > 19)
      sliceNum = 0;
    return slices.get(sliceNum);
  }

  // Makes an array with a standard list of prizes
  private static int[] getStandardPrizes()
  {
    int[] arr = new int[20];
    for (int i=0; i < 20; i++)
    {
      if (i%5 == 0)
        arr[i] = i*1000;
      else if (i%2 == 1)
        arr[i] = i*100;
      else
        arr[i] = i*200;
    }
    return arr;
  }
}
