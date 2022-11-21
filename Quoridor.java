
import java.util.*;
import java.util.ArrayList;

public class Quoridor
{
     public static void main (String [] beans)
     {
          Scanner in = new Scanner(System.in);
          String input = new String();
          String currentplayer_history;
          boolean isGameOver = false;
          Player[] players = new Player[2];
          ArrayList <String> history_p1 = new ArrayList<String>();
          ArrayList <String> history_p2 = new ArrayList<String>();
         
          
          //establece los dos jugadores , sus posiciones iniciales (x_pos, y_pos), el numero identificador (nb) y su nombre (nm)
          Player p1 = new Player(4, 8, 1, "Player 1");
          Player p2 = new Player(4, 0, 2, "Player 2");
          players[0] = p1;
          players[1] = p2;
          int count = 0;
          boolean moved=true;
          
          Player currentPlayer = new Player();
          
          Board Qboard = new Board(p1, p2);        
          
          System.out.println("BIENVENIDO A QUORIDOR");
         
          
          while(!isGameOver)
                { 
                    try {
                         System.out.println(Qboard);
                         currentPlayer = players[count]; // tengo que hacer que cambie cada turno
                         System.out.println("Turno de " + currentPlayer +"\n");
                         System.out.println("ENTER:|UP|+|DOWN|+|LEFT|+|RIGHT|");
                         input = in.nextLine();
                         //informacion del jugador 
                         currentplayer_history = currentPlayer.name+" x:"+currentPlayer.getX()+" y:"+currentPlayer.getY();
                         //para salir del juego
                         if(input.equals("quit") || input.equals("QUIT") ){
                              
                              //optenemos historial de movimientos de cada jugador
                              System.out.println("Historial de movimientos");
                              for (int i = 0; i < history_p1.size(); i++) {
                                   System.out.println(history_p1.get(i));

                                   
                              }
                              System.out.println("-----------------------------------------------------");
                              
                              for (int i = 0; i < history_p2.size(); i++) {
                                   System.out.println(history_p2.get(i));

                                   
                              }
                              break;
                             
                         }
                         //movemos
                         moved = currentPlayer.movePiece(input);
                        
                         while (!moved ) {
                              System.out.println("Error.");
                              System.out.println("ENTER:|UP|+|DOWN|+|LEFT|+|RIGHT|");
                              input = in.nextLine();
                              moved = currentPlayer.movePiece(input);
                              
                         }
                         

                         
                         
                         
                         Qboard.reDraw(p1, p2);
                         
                         //si el identificador de mi jugador actual es 1 le sumo uno mas 
                         //para que sea turno de dos , pero antes guardo su posicion actual en el array 
                         if (players[count].n == 1) {
                              history_p2.add(currentplayer_history);
                              count++;

                              
                         }              
                         else {
                              count--;
                              history_p1.add(currentplayer_history);
                         }
                         
                         
                         
                    
                    
                    } catch (Exception e) {
                         in.nextLine();
               
                    }
                   
          } 
          in.close();
    } 
                    
          
}//end Quoridor class
