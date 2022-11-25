/*
 * ANTHONY DE LOS SANTOS
 * LUIS SERGENT
 * DANIEL DIAZ
 * CHRISTOPHER JOGG
 * RUBEN GUILLEN
 */
import javax.swing.*;


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
                         board += "o.";
                        
                    }
                    else if(pr.getX() == j && pr.getY() == i)
                    {
                         board += "@.";
                         
                    }
                    else if(pb.getwallX1() == j && pb.getwallY1() == i && pb.x1_wall > 0 && var.direction.equalsIgnoreCase("vertical") )
                    {
                         board += " |";
                    }
                    else if(pb.getwallX2() == j && pb.getwallY2() == i && pb.x2_wall > 0 && var.direction.equalsIgnoreCase("vertical"))  
                    {
                         board += " |";
                         
                    }
                    
                   
                    else if(pr.getwallX1() == j && pr.getwallY1() == i && pr.x1_wall > 0 && var.direction.equalsIgnoreCase("vertical"))
                    {
                         board += " |";
                    }
                    else if(pr.getwallX2() == j && pr.getwallY2() == i && pr.x2_wall > 0 && var.direction.equalsIgnoreCase("vertical"))  
                    {
                         board += " |";
                         
                    }
                    else if(pb.getwallX1() == j && pb.getwallX3() == i && pb.x1_wall > 0 )  
                    {
                         board += "__";
                         
                    }
                    else if(pb.getwallX2() == j && pb.getwallX4() == i && pb.x1_wall > 0 )  
                    {
                         board += "__";
                         
                    }
                    else if(pr.getwallX1() == j && pr.getwallX3() == i && pr.x1_wall > 0 )  
                    {
                         board += "__";
                         
                    }
                    else if(pr.getwallX2() == j && pr.getwallX4() == i && pr.x1_wall > 0 )  
                    {
                         board += "__";
                         
                    }
                    
                    else
                         board += " .";
               }//end for    
               
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
                         board += "o.";
                        
                    }
                    else if(pr.getX() == j && pr.getY() == i)
                    {
                         board += "@.";
                         
                    }

                    // si el valor de la posicion de un muro de cierto jugador estaa, este es dibujado
                    else if(pb.getwallX1() == j && pb.getwallY1() == i && pb.x1_wall > 0 && var.direction.equalsIgnoreCase("vertical") )
                    {
                         board += " |";
                    }
                    else if(pb.getwallX2() == j && pb.getwallY2() == i && pb.x2_wall > 0 && var.direction.equalsIgnoreCase("vertical"))  
                    {
                         board += " |";
                         
                    }
                    
                   
                    else if(pr.getwallX1() == j && pr.getwallY1() == i && pr.x1_wall > 0 && var.direction.equalsIgnoreCase("vertical"))
                    {
                         board += " |";
                    }
                    else if(pr.getwallX2() == j && pr.getwallY2() == i && pr.x2_wall > 0 && var.direction.equalsIgnoreCase("vertical"))  
                    {
                         board += " |";
                         
                    }
                    else if(pb.getwallX1() == j && pb.getwallX3() == i && pb.x1_wall > 0 )  
                    {
                         board += "__";
                         
                    }
                    else if(pb.getwallX2() == j && pb.getwallX4() == i && pb.x1_wall > 0 )  
                    {
                         board += "__";
                         
                    }
                    else if(pr.getwallX1() == j && pr.getwallX3() == i && pr.x1_wall > 0 )  
                    {
                         board += "__";
                         
                    }
                    else if(pr.getwallX2() == j && pr.getwallX4() == i && pr.x1_wall > 0 )  
                    {
                         board += "__";
                         
                    }
                    else
                         board += " .";
               }//end for    
               
               board += " \n";
               
          }//end for 
          
          return new String(" _ _ _ _ _ _ _ _ _ _\n" + board);
     }
     
     public String toString()
     {
          return new String("  0 1 2 3 4 5 6 7 8  \n" + board);
     }
}//Board class
