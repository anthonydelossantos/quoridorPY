
/*
 * ANTHONY DE LOS SANTOS
 * LUIS SERGENT
 * DANIEL DIAZ
 * CHRISTOPHER JOGG
 * RUBEN GUILLEN
 */
import java.util.*;

public class variables {
     Scanner in = new Scanner(System.in);
     String direction = "";
     String currentplayer_history;
     boolean isGameOver = false;
     String position;
     String input = new String();
     int count = 0;
     int wcount_history = 0;
     boolean moved = true;
     String accion = "";
     int[] wall_position = new int[2];
     Player[] players = new Player[2];
     ArrayList<String> history_pb = new ArrayList<String>();
     ArrayList<String> history_pr = new ArrayList<String>();
     Player pb = new Player(4, 8, 1, "PB", 10);
    Player pr = new Player(4, 0, 2, "PR", 10);
     Player currentPlayer = new Player();

     // historial
    public void getHistory(ArrayList<String> history1, ArrayList<String> history2, ArrayList<Integer>  P1wallV_history, ArrayList<Integer>  P1wallH_history, ArrayList<Integer>  P2wallV_history,ArrayList<Integer>  P2wallH_history) {
         System.out.println("Historial de movimientos");
         for (int i = 0; i < history1.size(); i++) {
              System.out.println(history1.get(i));
              for (int j = 0; j < P1wallV_history.size(); j++) {
                   System.out.println(P1wallV_history.get(i));

              }
              for (int j = 0; j < P1wallH_history.size(); j++) {
               System.out.println(P1wallH_history.get(i));
               
              }
              
              

         }
         System.out.println("-----------------------------------------------------");

         for (int i = 0; i < history2.size(); i++) {
              System.out.println(history2.get(i));
              for (int j = 0; j < P2wallV_history.size(); j++) {
                   System.out.println(P1wallV_history.get(i));

              }
              for (int j = 0; j <P2wallH_history.size(); j++) {
               System.out.println(P2wallH_history.get(i));
               
              }

         }

    }

    public void verticalWalls() {
         System.out.println("ENTER: (x1,y1)");
         for (int j = 0; j < 2; j++) {
              System.out.print("->");
              wall_position[j] = in.nextInt();
         }

         currentPlayer.x1v_wall = wall_position[0];
         currentPlayer.y1v_wall = wall_position[1];
         currentPlayer.x2v_wall = wall_position[0];
         currentPlayer.y2v_wall = wall_position[1] - 1;

         if (currentPlayer.x1v_wall == currentPlayer.x1h_wall && currentPlayer.y1v_wall == currentPlayer.x2h_wall) {
              System.out.println("ERROR: La posicion ya esta ocupada por otro muro.");
              System.out.println("ENTER: (x1,y1)");
              for (int j = 0; j < 2; j++) {
                   System.out.print("->");
                   wall_position[j] = in.nextInt();
                    while (!(wall_position[j] < 9 && wall_position[j] >= 0)) {
                    System.out.println("Error! debes introducir un numero dentro del rango que ves en tablero.");
                    System.out.print("->");
                    wall_position[j] = in.nextInt();
               
                    }
              }

              currentPlayer.x1v_wall = wall_position[0];
              currentPlayer.y1v_wall = wall_position[1];
              currentPlayer.x2v_wall = wall_position[0];
              currentPlayer.y2v_wall = wall_position[1] - 1;
         }

         if (currentPlayer.n == 1) {

                   currentPlayer.P1wallV_history.add(currentPlayer.x1v_wall);
                   currentPlayer.P1wallV_history.add(currentPlayer.y1v_wall);
                   currentPlayer.P1wallV_history.add(currentPlayer.x2v_wall);
                   currentPlayer.P1wallV_history.add(currentPlayer.y2v_wall);
                   currentPlayer.walls -= 1;
              

         } else if (currentPlayer.n == 2) {
             
                   currentPlayer.P2wallV_history.add(currentPlayer.x1v_wall);
                   currentPlayer.P2wallV_history.add(currentPlayer.y1v_wall);
                   currentPlayer.P2wallV_history.add(currentPlayer.x2v_wall);
                   currentPlayer.P2wallV_history.add(currentPlayer.y2v_wall);
                   currentPlayer.walls -= 1;
         }

         wcount_history += 1;
         moved = true;

    }
    

    public void getWalls() {

         if (currentPlayer.n == 1) {

              currentPlayer.x1v_wall = wall_position[0];
              currentPlayer.y1v_wall = wall_position[1];
              currentPlayer.x2v_wall = wall_position[0];
              currentPlayer.y2v_wall = wall_position[1] - 1;

         }
          
         if (currentPlayer.n == 2) {
          
          currentPlayer.x1v_wall = wall_position[0];
          currentPlayer.y1v_wall = wall_position[1];
          currentPlayer.x2v_wall = wall_position[0];
          currentPlayer.y2v_wall = wall_position[1] - 1;
          
          }
     
     
    }

    public void horizontalWalls() {
         System.out.println("ENTER: (x1,x2)");
         for (int j = 0; j < 2; j++) {
              System.out.print("->");
              wall_position[j] = in.nextInt();
              while (!(wall_position[j] < 9 && wall_position[j] >= 0)) {
               System.out.println("Error! debes introducir un numero dentro del rango que ves en tablero.");
               System.out.print("->");
               wall_position[j] = in.nextInt();
               
              }
         }

         currentPlayer.x1h_wall = wall_position[0];
         currentPlayer.x2h_wall = wall_position[1];
         if (currentPlayer.x1v_wall == currentPlayer.x1h_wall && currentPlayer.y1v_wall == currentPlayer.x2h_wall) {
               System.out.println("ERROR: La posicion ya esta ocupada por otro muro.");
               System.out.println("ENTER: (x1,x2)");
               for (int j = 0; j < 2; j++) {
                    System.out.print("->");
                    wall_position[j] = in.nextInt();
               }

               currentPlayer.x1h_wall = wall_position[0];
               currentPlayer.x2h_wall = wall_position[1];
          }

         if (currentPlayer.n == 1) {
              currentPlayer.P1wallH_history.add(currentPlayer.x1h_wall);
              currentPlayer.P1wallH_history.add(currentPlayer.x2h_wall);
              currentPlayer.walls -= 1;

         } else if (currentPlayer.n == 2) {
               currentPlayer.P1wallH_history.add(currentPlayer.x1h_wall);
              currentPlayer.P1wallH_history.add(currentPlayer.x2h_wall);
              currentPlayer.walls -= 1;
         }

         wcount_history += 1;
         moved = true;

    }

    public void moverPeon() {
         System.out.println("ENTER:|ARRIBA|+|ABAJO|+|IZQUIERDA|+|DERECHA|");
         input = in.nextLine();
         moved = currentPlayer.moverPeon(input);

    }
     
    public void getWiner() {
          System.out.println("FELICIDADES!! "+pb.name+" GANASTE!!");
          getHistory(history_pb, history_pr, currentPlayer.P1wallV_history,currentPlayer.P1wallH_history,currentPlayer.P2wallV_history,currentPlayer.P2wallH_history);
     
    }

}


