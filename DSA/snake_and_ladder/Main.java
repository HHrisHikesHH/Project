import java.util.*;

class player {
          private int level = 0;
          private String name;
          private boolean status = true;
          private int id;

          public int getId() {
                    return id;
          }

          public player() {
          }

          public player(String name, int id) {
                    this.name = name;
                    this.id = id;
          }

          public int getLevel() {
                    return level;
          }

          public void setLevel(int level) {
                    this.level = level;
          }

          public String getName() {
                    return name;
          }

          public boolean getStatus() {
                    return status;
          }

          public void setStatus(boolean status) {
                    this.status = status;
          }
}

public class Main {
          static ArrayList<String> rank = new ArrayList<>();
          static Scanner sc = new Scanner(System.in);
          static final HashMap<Integer, Integer> ladder = new HashMap<>();
          static final HashMap<Integer, Integer> snake = new HashMap<>();

          static {
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
          }

          public static void main(String[] args) {
                    System.out.println("Hii!! whats your name?");
                    String name = sc.next();

                    System.out.println("Please select one of the below modes");
                    System.out.println("1 = play alone" + "\n" + "2 = play with CPU" + "\n" + "3 = play multiplayer");
                    int mode = sc.nextInt();
                    ArrayList<player> players = new ArrayList<>();
                    int p = 0;
                    // boolean CPU = false;
                    while (true) {
                              if (mode == 1) {
                                        player p1 = new player(name, 1);
                                        players.add(p1);
                                        break;
                              } else if (mode == 2) {
                                        player p1 = new player(name, 1);
                                        player p2 = new player("CPU", 2);
                                        players.add(p1);
                                        players.add(p2);
                                        // CPU = true;
                                        break;
                              } else if (mode == 3) {
                                        System.out.println("Enter how many Players");
                                        p = sc.nextInt();

                                        for (int idx = 1; idx <= p; idx++) {
                                                  System.out.println("Enter name of Player " + idx);
                                                  String n = sc.next();
                                                  player p1 = new player(n, idx);
                                                  players.add(p1);
                                        }
                                        break;
                              } else {
                                        System.out.println("Please Enter Valid 1, 2, 3");
                              }
                    }

                    System.out.println("Hey!!, " + name + " would you like to Start the Snake and ladder?");
                    while (true) {
                              char choice = sc.next().charAt(0);
                              if (choice == 'y' || choice == 'Y') {
                                        start(players);
                                        break;
                              } else if (choice == 'n' || choice == 'N') {
                                        break;
                              } else {
                                        System.out.println("Please input valid choice Y/N or y/n");
                              }
                    }
                    int place = 1;
                    for (String names : rank)
                              System.out.println(place++ + "place is " + names);
                    System.out.println("*****Game Over*****");
                    System.out.println("Made by -> Hrishikesh Kalekinge");
          }

          public static void start(ArrayList<player> players) {
                    while (players.size() > 0) {
                              for (int idx = 0; idx < players.size() && players.size() > 0; idx++) {
                                        player p = players.get(idx);
                                        player n = null;
                                        if ((idx + 1) < players.size())
                                                  n = players.get(idx + 1);
                                        else
                                                  n = players.get((idx + 1) % players.size());
                                        if (!p.getStatus())
                                                  players.remove(idx);
                                        play(p, n);
                              }
                    }
          }

          public static boolean play(player player, player next) {
                    int bestMove = 4, worstMove = 1;
                    boolean curr = true, nxt = false;
                    boolean nextMove = true;
                    int n = 100;
                    while (player.getLevel() < n - 1 && nextMove) {
                              System.out.println("Best Move was " + bestMove);
                              System.out.println("Worst Move was " + worstMove);
                              int dice = dice();
                              if (dice == bestMove) {
                                        System.out.println("You are in luck buddy");
                              } else if (dice == worstMove) {
                                        System.out.println("Your badluck buddy");
                              }
                              if (valid(player.getLevel(), dice, n)) {
                                        player.setLevel((player.getLevel() + dice));
                                        System.out.println(player.getName() + " you are at " + player.getLevel());
                              } else {
                                        System.out.println("OOPs you need " + (n - player.getLevel() - 1) + " move");
                              }

                              if (ladder.containsKey(player.getLevel())) {
                                        board(player);
                                        System.out.print("WOOHOO!!  Took the ladder from " + player.getLevel());
                                        player.setLevel(ladder.get(player.getLevel()));
                                        System.out.println(" to " + player.getLevel());

                              } else if (snake.containsKey(player.getLevel())) {
                                        board(player);
                                        System.out.print("OOHH NOO!!  Biten by snake at " + player.getLevel());
                                        player.setLevel(snake.get(player.getLevel()));
                                        System.out.println(" gone to " + player.getLevel());

                              }
                              board(player);
                              bestMove = bestMove(player.getLevel());
                              System.out.println("next Best Move is " + bestMove);
                              worstMove = worstMove(player.getLevel());
                              System.out.println("next Worst Move is " + worstMove);
                              if (curr) {
                                        System.out.println(next.getName() + " Its your chance Play Dice?" + "\n"
                                                            + "P to play Q to quit");
                                        curr = false;
                                        nxt = true;
                              } else {
                                        System.out.println(player.getName() + " Its your chance Play Dice?" + "\n"
                                                            + "P to play Q to quit");
                                        curr = true;
                                        nxt = false;
                              }

                              while (true) {
                                        char choice = sc.next().charAt(0);
                                        if (choice == 'p' || choice == 'P') {
                                                  nextMove = true;
                                                  break;
                                        } else if (choice == 'q' || choice == 'Q') {
                                                  nextMove = false;
                                                  return false;
                                        } else {
                                                  System.out.println("Please input valid choice P/Q or p/q");
                                        }
                              }
                              clrscn();
                              return player.getStatus();
                    }
                    player.setStatus(false);
                    if (!rank.contains(player.getName()))
                              rank.add(player.getName());
                    return player.getStatus();
          }

          public static int bestMove(int player) {
                    for (int range = 1; range <= 6; range++) {
                              if (ladder.containsKey(player + range))
                                        return range;
                    }
                    return 6;
          }

          public static int worstMove(int player) {
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

          public static void board(player p) {
                    String goti = "";
                    int player = p.getLevel();
                    if (p.getId() == 1) {
                              if (p.getName().equals("CPU"))
                                        goti = "🖥️";
                              else
                                        goti = "🔴";
                    } else if (p.getId() == 2) {
                              if (p.getName().equals("CPU"))
                                        goti = "🖥️";
                              else
                                        goti = "🟢";
                    } else if (p.getId() == 3) {
                              if (p.getName().equals("CPU"))
                                        goti = "🖥️";
                              else
                                        goti = "🔵";
                    } else if (p.getId() == 4) {
                              if (p.getName().equals("CPU"))
                                        goti = "🖥️";
                              else
                                        goti = "🟡";
                    } else {
                              goti = "⚪️";
                    }
                    String space = "";
                    System.out.println("--------------------------------");
                    for (int idx = 0; idx < (player % 10); idx++)
                              space += "     ";

                    if (player >= 0 && player <= 9)
                              System.out.println(space + goti);
                    System.out.println("               S2   L1");
                    System.out.println("00   01   02   03   04   05   06   07   08   09");

                    if (player >= 10 && player <= 19)
                              System.out.println(space + goti);
                    System.out.println("S1        L2        L3        S3");
                    System.out.println("10   11   12   13   14   15   16   17   18   19");

                    if (player >= 20 && player <= 29)
                              System.out.println(space + goti);
                    System.out.println("          L4                            S1");
                    System.out.println("20   21   22   23   24   25   26   27   28   29");

                    if (player >= 30 && player <= 39)
                              System.out.println(space + goti);
                    System.out.println("          S4                       S2");
                    System.out.println("30   31   32   33   34   35   36   37   38   39");

                    if (player >= 40 && player <= 49)
                              System.out.println(space + goti);
                    System.out.println("     L5   S6                       S3");
                    System.out.println("40   41   42   43   44   45   46   47   48   49");

                    if (player >= 50 && player <= 59)
                              System.out.println(space + goti);
                    System.out.println("L2                  L6   L3   L1        L4");
                    System.out.println("50   51   52   53   54   55   56   57   58   59");

                    if (player >= 60 && player <= 69)
                              System.out.println(space + goti);
                    System.out.println("      ");
                    System.out.println("60   61   62   63   64   65   66   67   68   69");

                    if (player >= 70 && player <= 79)
                              System.out.println(space + goti);
                    System.out.println("     S5                  S4                  L5");
                    System.out.println("70   71   72   73   74   75   76   77   78   79");

                    if (player >= 80 && player <= 89)
                              System.out.println(space + goti);
                    System.out.println("      ");
                    System.out.println("80   81   82   83   84   85   86   87   88   89");

                    if (player >= 90 && player <= 99)
                              System.out.println(space + goti);
                    System.out.println("                    S5        S6");
                    System.out.println("90   91   92   93   94   95   96   97   98   99");
                    System.out.println("---------------------------------");

          }
}
