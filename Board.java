/*
 * ANTHONY DE LOS SANTOS
 * LUIS SERGENT
 * DANIEL DIAZ
 * CHRISTOPHER JOGG
 * RUBEN GUILLEN
 */
public class Board 
{     
     private String board;
     variables var = new variables();
     
     public Board(Player pb, Player pr)
     {          
          board = new String();
          
          for(int i = 0; i < 9; i++)
          {               
               board += i+" .";
               
               for(int j = 0; j < 9; j++)
               {

                    if(pb.getX() == j && pb.getY() == i)
                    {

                         board += "B ";
                         

                      }
                     else if(pr.getX() == j && pr.getY() == i)
                       {
                          board += "R ";

                      }
                    // vertical
                    else if (pb.getVwallX1() == j && pb.getVwallY1() == i && pb.x1v_wall > 0) {
                         board += " |";
                    } else if (pb.getVwallX2() == j && pb.getVwallY2() == i && pb.x2v_wall > 0) {
                         board += " |";

                    }
                    else if (pr.getVwallX1() == j && pr.getVwallY1() == i && pr.x1v_wall > 0) {
                         board += " |";
                    } else if (pr.getVwallX2() == j && pr.getVwallY2() == i && pr.x2v_wall > 0) {
                         board += " |";

                    }
                    //-----------------------------------------------------------------------
                    //horizontal

                    else if (pb.getHwallX1() == j && pb.getHwallX2() == i && pb.x1h_wall > 0) {
                         board += "__";

                    
                    } else if (pr.getHwallX1() == j && pr.getHwallX2() == i && pr.x1h_wall > 0) {
                         board += "__";

                    }

                    else
                        board += " .";
               } //end for    
               
               board += " \n";
               
          }//end for 
     }     
     
     public String reDraw(Player pb, Player pr)
     {
          board = new String();
          
          for(int i = 0; i < 9; i++)
          {               
               board += i+" .";
               
               for(int j = 0; j < 9; j++)
               {
                    
                    // si el jugador se encuentra en una posicion x ,y este dibuja su respectivo simbolo
                    if(pb.getX() == j && pb.getY() == i)
                    {
                        
                         board += "B ";
                        
                    }
                    else if(pr.getX() == j && pr.getY() == i)
                    {
                         board += "R ";
                         
                    }
                  // si el valor de la posicion de un muro de cierto jugador estaa, este es dibujado
                  

                     // vertical
                    else if (pb.getVwallX1() == j && pb.getVwallY1() == i && pb.x1v_wall > 0) {
                         board += " |";
                    } else if (pb.getVwallX2() == j && pb.getVwallY2() == i && pb.x2v_wall > 0) {
                         board += " |";

                    }
                    else if (pr.getVwallX1() == j && pr.getVwallY1() == i && pr.x1v_wall > 0) {
                         board += " |";
                    } else if (pr.getVwallX2() == j && pr.getVwallY2() == i && pr.x2v_wall > 0) {
                         board += " |";

                    }
                    //-----------------------------------------------------------------------
                    //horizontal

                    else if (pb.getHwallX1() == j && pb.getHwallX2() == i && pb.x1h_wall > 0) {
                         board += "__";

                    }
                    else if (pb.getHwallX3() == j && pb.getHwallX4() == i && pb.x1h_wall > 0) {
                         board += "__";

                    
                    } 
                    else if (pr.getHwallX1() == j && pr.getHwallX2() == i && pr.x1h_wall > 0) {
                         board += "__";

                    }
                     else if (pr.getHwallX3() == j && pb.getHwallX4() == i && pr.x1h_wall > 0) {
                         board += "__";

                    
                    } 
                    else
                         board += " .";
               }//end for    
               
               board += " \n";
               
          }//end for 
          
          return new String(board);
     }
     
     public String toString()
     { 
          return new String("  0 1 2 3 4  5 6 7 8 \n" + board);
     }
}//Board class
