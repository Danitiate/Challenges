import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

class Dice_Roller{
  public static void main(String[] args) {
    try{
      File challengeFile = new File("challenge.txt");
      Scanner fn = new Scanner(challengeFile);
      Scanner in = new Scanner(System.in);

      while(fn.hasNext()){
        System.out.println(solve(fn.nextLine()));
      }

      System.out.println("\nPRESS ANY KEY TO EXIT");
      System.out.println("OR TYPE A NEW DICEROLL WITH 'NdM'\n");
      while(true){
        String line = in.nextLine();
        if(line.matches("\\d+d\\d+")){
          System.out.println(solve(line));
        }else{
          break;
        }
      }

    }catch(FileNotFoundException e){
      System.out.println(e);
      System.exit(0);
    }
  }

  public static String solve(String diceFormat){
    String[] dice = diceFormat.split("d");
    Random rand = new Random();
    int amount = Integer.parseInt(dice[0]);
    int sides = Integer.parseInt(dice[1]);
    int sum = 0;

    diceFormat += ": [";
    for (int i = amount; i > 0; i--){
      int roll = rand.nextInt(sides) + 1;
      sum += roll;

      diceFormat += (i == 1) ? roll + "] - " + sum : roll + ", ";
    }

    return diceFormat;
  }
}
