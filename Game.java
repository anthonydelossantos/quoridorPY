/*
 * ANTHONY DE LOS SANTOS
 * LUIS SERGENT
 * DANIEL DIAZ
 * CHRISTOPHER JOGG
 * RUBEN GUILLEN
 */
/*
 * Estado actual no se guardan las posiciones de los muros
 */
import java.util.*;

public class Game
{

     public static void main (String [] beans)
     {
          
          variables var = new variables();
          Scanner in = new Scanner(System.in);
          var.players[0] =var.pb;
          var.players[1]=var.pr;
          //CREAMOS OBJETO Qboard Y LE PASAMOS LOS JUGADORES A LA CLASE BOARD, ESTOS JUGADORES CON SUS POSICIONES
          Board Qboard = new Board(var.pb, var.pr);         
          System.out.println("\nBIENVENIDO A QUORIDOR\n");
          while(!var.isGameOver)
                { 
                    try {
                   in.nextLine();
                    //GANADORES
                    if (var.pb.getY() == 0) {
                        var.getWiner();
                         break;

                         
                    } else if (var.pr.getY() == 8) {
                        var.getWiner();
                         break;
                         
                    } 

                    //IMPRIME EL  TABLERO
                    System.out.println(Qboard);

                    //ESTABLECE EL JUGADOR ACTUAL
                    var.currentPlayer = var.players[var.count];
                    System.out.println("Turno de " + var.currentPlayer +"\n");
                    System.out.println("Posicion actual del " + var.currentPlayer +" -> "+ "x:"+var.currentPlayer.x+" y:"+var.currentPlayer.y);
                    //escogemos que queremos mover 
                    System.out.println("Que deseas mover?\n moverse: Mov || Colocar Muro: M");
                    var.accion = in.nextLine();
                    while (!var.accion.equalsIgnoreCase("Mov") && !var.accion.equalsIgnoreCase("M")) {
                         System.out.print("ERROR: Introduce Mov o M ->");
                         var.accion = in.nextLine();
                         
                    }
                              
                    //CONDICIONALES DE ACCION
                    //muro
                    if (var.accion.equalsIgnoreCase("M")) {
                         
                         if (var.currentPlayer.walls == 0) {
                              System.out.print("Ya utilizaste todos tus muros.");
                              var.moved = false;

                         }
                         System.out.println("v) Vertical\nh) Horizontal?");
                         System.out.print("-> ");
                         var.position = in.nextLine();
                         while (!var.position.equalsIgnoreCase("v") && !var.position.equalsIgnoreCase("h")) {
                              System.out.println("Error! Introduce un valor correcto.");
                              System.out.println("v) Vertical\nh) Horizontal?");
                              System.out.print("-> ");
                              var.position = in.nextLine();
                              
                         }
                         //vertical
                         if (var.position.equalsIgnoreCase("v")) {
                              var.verticalWalls();
                              

                         }
                         //horizontall
                         else if (var.position.equalsIgnoreCase("h")) {
                              var.horizontalWalls();
                              
                         } 
                         
                    }
                    //peon

                    if (var.accion.equalsIgnoreCase("mov")) {
                              var.moverPeon();

                              //para salir del juego
                              if (var.input.equalsIgnoreCase("EXIT") || var.input.equalsIgnoreCase("E")) {
                                   System.out.println("PARTIDA INTERRUMPIDA\n");
                                   var.getHistory(var.history_pb,var.history_pr, var.currentPlayer.P1wallV_history,var.currentPlayer.P1wallH_history,var.currentPlayer.P2wallV_history,var.currentPlayer.P2wallH_history);
                                   break;
                              }
                              while (!var.moved) {
                                   var.moverPeon();
                                  
                              }

                         }

               
                    //para salir del juego
                         if(var.accion.equalsIgnoreCase("EXIT") || var.accion.equalsIgnoreCase("E")){  
                              System.out.println("PARTIDA INTERRUMPIDA\n"); 
                              var.getHistory(var.history_pb,var.history_pr, var.currentPlayer.P1wallV_history,var.currentPlayer.P1wallH_history,var.currentPlayer.P2wallV_history,var.currentPlayer.P2wallH_history);
                              break;
                         }

               
                    //FIN DE CONDICIONALES DE ACCION
                         

                         
                    //VUELVE A DIBUJAR EL TABLERO
                         Qboard.reDraw(var.pb, var.pr);
                         
            
                    
                         
                     //informacion del jugador 
                         var.currentplayer_history = var.currentPlayer.name+" x:"+var.currentPlayer.getX()+" y:"+var.currentPlayer.getY();
                        
                    //si el identificador de mi jugador actual es 1 le sumo uno mas 
                    //para que sea turno de dos , pero antes guardo su posicion actual en el array 
                         if (var.players[var.count].n == 1) {
                              var.history_pb.add(var.currentplayer_history);
                              var.count++;

                              
                         }              
                         else {
                              var.count--;
                              var.history_pr.add(var.currentplayer_history);
                         }
                         
                    
                    
                    
                    
               }   
               catch (Exception e) {
                  //error aqui se escriben varios historiales
                    System.out.println("PARTIDA INTERRUMPIDA");
                   var.getHistory(var.history_pb,var.history_pr, var.currentPlayer.P1wallV_history,var.currentPlayer.P1wallH_history,var.currentPlayer.P2wallV_history,var.currentPlayer.P2wallH_history);
               }      
          } 
          
          
          in.close();
    } 
                    
          
}//end Quoridor class
