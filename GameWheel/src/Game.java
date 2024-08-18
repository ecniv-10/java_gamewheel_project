import java.util.ArrayList;

public class Game
{
  public static void play(GameWheel g)
  {
    // Implement the play method here
    ArrayList<Slice> winSlices =  new ArrayList<Slice>();
    int sum = 0;
    boolean colorMatch = false;

    for (int i = 0; i < 3; i++) {
        Slice slice = g.spinWheel();
        winSlices.add(slice);
        sum = sum + slice.getPrizeAmount();
    }

    //are all slices the same color
    for (int i = 0; i < 2; i++) {
        if (winSlices.get(i).getColor() == winSlices.get(i+1).getColor()) {
            colorMatch = true;
        } else {
            colorMatch = false;
            break;

        };
    }

    if (colorMatch){
        sum = 2*sum;
    }

    System.out.println("Total prize money: $" + sum);
    System.out.println("");

    for (int i = 1; i < 4; i++) {
        System.out.println("Spin " + i + " - " + winSlices.get(i - 1));         
    }

    if (colorMatch){

        System.out.println("Three " + winSlices.get(0).getColor() + " = double your money!"); 

    }

  }
}

