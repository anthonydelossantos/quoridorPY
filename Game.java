
import java.util.*;

public class Game
{

     public static void main (String [] beans)
     {
          
          variables var = new variables();
          Scanner in = new Scanner(System.in);
          
          //establece los dos jugadores , sus posiciones iniciales (x_pos, y_pos), el numero identificador (nb) y su nombre (nm)
          Player pb = new Player(4, 8, 1, "PB", 10);
          Player pr = new Player(4, 0, 2, "PR", 10);
          //INTRODUCE USUARIOS DENTRO DE ARRAY QUE FUNCIONARA PARA ITERAR EN EL
          var.players[0] = pb;
          var.players[1] = pr;
          
          //CREAMOS OBJETO CURRENTPLAYER CON LA CLASE PLAYER
          Player currentPlayer = new Player(); 
          //CREAMOS OBJETO Qboard Y LE PASAMOS LOS JUGADORES A LA CLASE BOARD, ESTOS JUGADORES CON SUS POSICIONES
          Board Qboard = new Board(pb, pr);         
          System.out.println("\nBIENVENIDO A QUORIDOR\n");
         
          
          while(!var.isGameOver)
                { 
                    try {
                         
                   
                   in.nextLine();
                    //GANADORES

                    if (pb.getY() == 0) {
                         System.out.println("FELICIDADES!! "+pb.name+" GANASTE!!");
                         var.getHistory(var.history_pb, var.history_pr);
                         break;

                         
                    } else if (pr.getY() == 8) {
                         System.out.println("FELICIDADES!! "+pr.name+" GANASTE!!");
                         var.getHistory(var.history_pb, var.history_pr);
                         break;
                         
                    } 

                    //FIN DE GANADORES

                    //IMPRIME EL  TABLERO
                         System.out.println(Qboard);

                    //ESTABLECE EL JUGADOR ACTUAL
                         currentPlayer = var.players[var.count];
                         System.out.println("Turno de " + currentPlayer +"\n");
                         System.out.println("Posicion actual del " + currentPlayer +" -> "+ "x:"+currentPlayer.x+" y:"+currentPlayer.y);
                         //escogemos que queremos mover 
                         System.out.println("Que deseas mover?\n moverse: Mov || Colocar Muro: M");
                         var.accion = in.nextLine();


                         
                         if (var.accion.equalsIgnoreCase("PICOTA")) {
                              System.out.println("FELICIDADES GANASTE EL JUEGO!! Y nosotros ganamos una A+");
                              break;
                              
                              
                         } 
                         
                         
                         
                    //CONDICIONALES DE ACCION
                        if (var.accion.equalsIgnoreCase("M")) {
                                   if (currentPlayer.walls == 0 ) {
                                        System.out.print("Ya utilizaste todos tus muros.");
                                        var.moved = false;
                                        
                                   } else {
                                   int wall_dir=0;
                                   System.out.print("1) Horizontal o 2) Vertical?\n->");
                                   wall_dir = in.nextInt();
                                   switch (wall_dir) {
                                        case 2:
                                             System.out.println("ENTER: (x1,y1)");
                                             for (int j = 0; j < 2; j++) {
                                                  System.out.print("->");
                                                  var.wall_position[j] = in.nextInt();
                                             }
                                             currentPlayer.x1_wall = var.wall_position[0];
                                             currentPlayer.y1_wall = var.wall_position[1];
                                             currentPlayer.x2_wall = var.wall_position[0];
                                             currentPlayer.y2_wall = var.wall_position[1]-1;
                                            // var.direction = "vartical";
                                                  
                                             break;
                                        case 1:
                                             System.out.println("ENTER: (x1,x2)");
                                             for (int j = 0; j < 2; j++) {
                                                  System.out.print("->");
                                                  var.wall_position[j] = in.nextInt();
                                             }
                                             currentPlayer.x1_wall = var.wall_position[0];
                                             currentPlayer.x3_wall = var.wall_position[1];
                                             currentPlayer.x2_wall = var.wall_position[0];
                                             currentPlayer.x4_wall = var.wall_position[1]-1;
                                             //var.direction = "horizontal";
                                             
                                             break;
                                   
                                        default:
                                             break;
                                   }

                                        
                                        if (pb.getX() == pb.getwallX1() && pb.getY() == pb.getwallY1()) {
                                             var.moved = false;
                         
                                        }

                                        if(currentPlayer.n == 1){
                                             //currentPlayer.pbwall_history[wcount_history] =  currentPlayer.x1_wall;
                                             //currentPlayer.pbwall_history[wcount_history+1] = currentPlayer.y1_wall;
                                             currentPlayer.walls -=1;

                                        }
                                        else if (currentPlayer.n == 2) {
                                        // currentPlayer.prwall_history[wcount_history] =  currentPlayer.x1_wall;
                                             //currentPlayer.prwall_history[wcount_history+1] = currentPlayer.y1_wall;
                                             currentPlayer.walls -=1;
                                        }

                                        //wcount_history+=1;
                                        var.moved = true;

                                        
                                   }
                                   
                                   
                         }    
                                   
                         if (var.accion.equalsIgnoreCase("mov")) { 
                                   System.out.println("ENTER:|ARRIBA|+|ABAJO|+|IZQUIERDA|+|DERECHA|");
                                   var.input = in.nextLine();
                                   var.moved = currentPlayer.moverPeon(var.input);
                              
                                   //para salir del juego
                                   if(var.input.equalsIgnoreCase("EXIT") || var.input.equalsIgnoreCase("E")){
                                        System.out.println("PARTIDA INTERRUMPIDA\n"); 
                                        var.getHistory(var.history_pb,var.history_pr);
                                        break;
                                      }
                                   while (!var.moved ) {
                                        System.out.println("Error.");
                                        System.out.println("ENTER:|ARRIBA|+|ABAJO|+|IZQUIERDA|+|DERECHA|");
                                        var.input = in.nextLine();
                                        var.moved = currentPlayer.moverPeon(var.input);
                                   }

                                   
                         }


                    //para salir del juego
                         if(var.accion.equalsIgnoreCase("EXIT") || var.accion.equalsIgnoreCase("E")){  
                              System.out.println("PARTIDA INTERRUMPIDA\n"); 
                             var.getHistory(var.history_pb,var.history_pr);
                              break;
                         }

                         // SI NO RECONOCE ALGUNA ACCION
                         else if(!var.accion.equalsIgnoreCase("Mov") && !var.accion.equalsIgnoreCase("M") ){
                                   System.out.print("ERROR: Introduce Mov o M ->");
                                   var.accion = in.nextLine();

                              }
                    //FIN DE CONDICIONALES DE ACCION
                         

                         
                    //VUELVE A DIBUJAR EL TABLERO
                         Qboard.reDraw(pb, pr);
                         
            
                    
                         
                     //informacion del jugador 
                         var.currentplayer_history = currentPlayer.name+" x:"+currentPlayer.getX()+" y:"+currentPlayer.getY();
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
                   System.out.println("PARTIDA INTERRUMPIDA");
                   var.getHistory(var.history_pb, var.history_pr);
               }      
          } 
          
          
          in.close();
    } 
                    
          
}//end Quoridor class
