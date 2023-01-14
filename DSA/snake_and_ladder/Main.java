import java.io.*;
import java.util.*;

public class Main {
          static Scanner sc = new Scanner(System.in);

          public static void main(String[] args) {

                    System.out.println("Hey!!, would you like to play Snake and ladder?");
                    boolean repeat = true;

                    while (true) {
                              char choice = sc.next().charAt(0);
                              if (choice == 'y' || choice == 'Y') {
                                        play();
                                        break;
                              } else if (choice == 'n' || choice == 'N') {
                                        break;
                              } else {
                                        System.out.println("Please input valid choice Y/N or y/n");
                              }
                    }
                    System.out.println("*****Game Over*****");
          }

          public static boolean play() {
                    int bestMove = 4, worstMove = 1;
                    HashMap<Integer, Integer> ladder = new HashMap<>();
                    HashMap<Integer, Integer> snake = new HashMap<>();

                    ladder.put(4, 56);
                    ladder.put(12, 50);
                    ladder.put(14, 55);
                    ladder.put(22, 58);
                    ladder.put(41, 79);
                    ladder.put(54, 88);

                    snake.put(37, 3);
                    snake.put(28, 10);
                    snake.put(47, 16);
                    snake.put(96, 42);
                    snake.put(94, 71);
                    snake.put(75, 32);

                    boolean nextMove = true;
                    int n = 100;
                    int player = 0;
                    while (player < n - 1 && nextMove) {
                              System.out.println("Best Move was " + bestMove);
                              System.out.println("Worst Move was " + worstMove);
                              int dice = dice();
                              if (dice == bestMove) {
                                        System.out.println("You are in luck buddy");
                              } else if (dice == worstMove) {
                                        System.out.println("You are unluck buddy");
                              }
                              if (valid(player, dice, n)) {
                                        player += dice;
                                        System.out.println("you are at " + player);
                              } else {
                                        System.out.println("OOPs you need " + (n - player - 1) + " move");
                              }

                              if (ladder.containsKey(player)) {
                                        board(player, ladder, snake);
                                        System.out.print("WOOHOO!!  Took the ladder from " + player);
                                        player = ladder.get(player);
                                        System.out.println(" to " + player);

                              } else if (snake.containsKey(player)) {
                                        board(player, ladder, snake);
                                        System.out.print("OOHH NOO!!  Biten by snake at " + player);
                                        player = snake.get(player);
                                        System.out.println(" gone to " + player);

                              }
                              board(player, ladder, snake);
                              bestMove = bestMove(ladder, player);
                              System.out.println("next Best Move is " + bestMove);
                              worstMove = worstMove(snake, player);
                              System.out.println("next Worst Move is " + worstMove);
                              System.out.println("Play Dice?" + "\n" + "P to play Q to quit");
                              while (true) {
                                        char choice = sc.next().charAt(0);
                                        if (choice == 'p' || choice == 'P') {
                                                  nextMove = true;
                                                  break;
                                        } else if (choice == 'q' || choice == 'Q') {
                                                  nextMove = false;
                                                  break;
                                        } else {
                                                  System.out.println("Please input valid choice P/Q or p/q");
                                        }
                              }

                              clrscn();

                    }
                    return false;
          }

          public static int bestMove(HashMap<Integer, Integer> ladder, int player) {
                    for (int range = 1; range <= 6; range++) {
                              if (ladder.containsKey(player + range))
                                        return range;
                    }
                    return 6;
          }

          public static int worstMove(HashMap<Integer, Integer> snake, int player) {
                    for (int range = 1; range <= 6; range++) {
                              if (snake.containsKey(player + range))
                                        return range;
                    }
                    return 1;
          }

          public static boolean valid(int player, int dice, int n) {
                    if (player + dice <= n - 1)
                              return true;
                    else
                              return false;
          }

          public static void clrscn() {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
          }

          public static int dice() {
                    int dice = (int) Math.ceil((Math.random() * 6));
                    System.out.print("Dice = " + dice + " ");
                    return dice;
          }

          public static void board(int player, HashMap ladder, HashMap snake) {
                    String space = "";
                    System.out.println("--------------------------------");
                    for (int idx = 0; idx < (player % 10); idx++)
                              space += "     ";

                    if (player >= 0 && player <= 9)
                              System.out.println(space + "⬇️");
                    System.out.println("               S2   L1");
                    System.out.println("00   01   02   03   04   05   06   07   08   09");

                    if (player >= 10 && player <= 19)
                              System.out.println(space + "⬇️");
                    System.out.println("S1        L2        L3        S3");
                    System.out.println("10   11   12   13   14   15   16   17   18   19");

                    if (player >= 20 && player <= 29)
                              System.out.println(space + "⬇️");
                    System.out.println("          L4                            S1");
                    System.out.println("20   21   22   23   24   25   26   27   28   29");

                    if (player >= 30 && player <= 39)
                              System.out.println(space + "⬇️");
                    System.out.println("          S4                       S2");
                    System.out.println("30   31   32   33   34   35   36   37   38   39");

                    if (player >= 40 && player <= 49)
                              System.out.println(space + "⬇️");
                    System.out.println("     L5   S6                       S3");
                    System.out.println("40   41   42   43   44   45   46   47   48   49");

                    if (player >= 50 && player <= 59)
                              System.out.println(space + "⬇️");
                    System.out.println("L2                  L6   L3   L1        L4");
                    System.out.println("50   51   52   53   54   55   56   57   58   59");

                    if (player >= 60 && player <= 69)
                              System.out.println(space + "⬇️");
                    System.out.println("      ");
                    System.out.println("60   61   62   63   64   65   66   67   68   69");

                    if (player >= 70 && player <= 79)
                              System.out.println(space + "⬇️");
                    System.out.println("     S5                  S4                  L5");
                    System.out.println("70   71   72   73   74   75   76   77   78   79");

                    if (player >= 80 && player <= 89)
                              System.out.println(space + "⬇️");
                    System.out.println("      ");
                    System.out.println("80   81   82   83   84   85   86   87   88   89");

                    if (player >= 90 && player <= 99)
                              System.out.println(space + "⬇️");
                    System.out.println("                    S5        S6");
                    System.out.println("90   91   92   93   94   95   96   97   98   99");
                    System.out.println("---------------------------------");

          }
}
