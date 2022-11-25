
import java.util.*;
import java.util.ArrayList;

public class Quoridor
{
// historial
     static void getHistory(ArrayList <String> history1, ArrayList <String> history2) {
          System.out.println("Historial de movimientos");
                                        for (int i = 0; i < history1.size(); i++) {
                                             System.out.println(history1.get(i));

                                             
                                        }
                                        System.out.println("-----------------------------------------------------");
                                        
                                        for (int i = 0; i < history2.size(); i++) {
                                             System.out.println(history2.get(i));

                                             
                                        }
          
     }
     public static void main (String [] beans)
     {
          String currentplayer_history;
          boolean isGameOver = false;
          int count = 0;
          boolean moved=true;
          String accion;

          Scanner in = new Scanner(System.in);
          String input = new String();
          int[] wall_position=new int[2];
          Player[] players = new Player[2];
          ArrayList <String> history_p1 = new ArrayList<String>();
          ArrayList <String> history_p2 = new ArrayList<String>();
          
          //establece los dos jugadores , sus posiciones iniciales (x_pos, y_pos), el numero identificador (nb) y su nombre (nm)
          Player p1 = new Player(4, 8, 1, "Player 1");
          Player p2 = new Player(4, 0, 2, "Player 2");
          //INTRODUCE USUARIOS DENTRO DE ARRAY QUE FUNCIONARA PARA ITERAR EN EL
          players[0] = p1;
          players[1] = p2;
          
          //CREAMOS OBJETO CURRENTPLAYER CON LA CLASE PLAYER
          Player currentPlayer = new Player(); 
          //CREAMOS OBJETO Qboard Y LE PASAMOS LOS JUGADORES A LA CLASE BOARD, ESTOS JUGADORES CON SUS POSICIONES
          Board Qboard = new Board(p1, p2);         
          System.out.println("\nBIENVENIDO A QUORIDOR\n");
         
          
          while(!isGameOver)
                { 
                   in.nextLine();
                    //GANADORES

                    if (p1.getY() == 0) {
                         System.out.println("FELICIDADES!! "+p1.name+" GANASTE!!");
                         getHistory(history_p1, history_p2);
                         break;

                         
                    } else if (p2.getY() == 8) {
                         System.out.println("FELICIDADES!! "+p2.name+" GANASTE!!");
                         getHistory(history_p1, history_p2);
                         break;
                         
                    } 

                    //FIN DE GANADORES

                    //IMPRIME EL  TABLERO
                         System.out.println(Qboard);

                    //ESTABLECE EL JUGADOR ACTUAL
                         currentPlayer = players[count];
                         System.out.println("Turno de " + currentPlayer +"\n");
                         //escogemos que queremos mover 
                         System.out.println("Que deseas mover?\nPeon: P || Muro: M");
                         accion = in.nextLine();


                         /* 
                         if (accion.equalsIgnoreCase("PICOTA")) {
                              System.out.println("FELICIDADES GANASTE EL JUEGO!! Y nosotros ganamos una A+");
                              break;
                              
                              
                         } 
                         */
                         
                         
                    //CONDICIONALES DE ACCION
                        if (accion.equalsIgnoreCase("M")) {
                                   System.out.println("ENTER: (x1,y1)");
                                   for (int j = 0; j < 2; j++) {
                                        System.out.print("->");
                                        wall_position[j] = in.nextInt();
                                   }
                                   currentPlayer.x1_wall = wall_position[0];
                                   currentPlayer.y1_wall = wall_position[1];
                                   moved = true;
                                   
                         }    
                                   
                         if (accion.equalsIgnoreCase("P")) { 
                                   System.out.println("ENTER:|ARRIBA|+|ABAJO|+|IZQUIERDA|+|DERECHA|");
                                   input = in.nextLine();
                                   moved = currentPlayer.moverPeon(input);
                              
                                   //para salir del juego
                                   if(input.equalsIgnoreCase("EXIT") || input.equalsIgnoreCase("E")){
                                        getHistory(history_p1,history_p2);
                                        break;
                                      }
                                   while (!moved ) {
                                        System.out.println("Error.");
                                        System.out.println("ENTER:|ARRIBA|+|ABAJO|+|IZQUIERDA|+|DERECHA|");
                                        input = in.nextLine();
                                        moved = currentPlayer.moverPeon(input);
                                   }

                                   
                         }


                    //para salir del juego
                         if(accion.equalsIgnoreCase("EXIT") || accion.equalsIgnoreCase("E")){   
                             getHistory(history_p1,history_p2);
                              break;
                         }

                         // SI NO RECONOCE ALGUNA ACCION
                         else if(!accion.equalsIgnoreCase("P") && !accion.equalsIgnoreCase("M") ){
                                   System.out.print("ERROR: Introduce P o M ->");
                                   accion = in.nextLine();

                              }
                    //FIN DE CONDICIONALES DE ACCION
                         

                         
                    //VUELVE A DIBUJAR EL TABLERO
                         Qboard.reDraw(p1, p2);
                         
            
                    
                         
                     //informacion del jugador 
                         currentplayer_history = currentPlayer.name+" x:"+currentPlayer.getX()+" y:"+currentPlayer.getY();
                    //si el identificador de mi jugador actual es 1 le sumo uno mas 
                    //para que sea turno de dos , pero antes guardo su posicion actual en el array 
                         if (players[count].n == 1) {
                              history_p1.add(currentplayer_history);
                              count++;

                              
                         }              
                         else {
                              count--;
                              history_p2.add(currentplayer_history);
                         }
                         
                    
                    
                    
                    
                   
          } 
          in.close();
    } 
                    
          
}//end Quoridor class
