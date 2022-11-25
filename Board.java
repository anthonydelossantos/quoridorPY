import javax.swing.*;


public class Board extends JComponent
{     
     private String board;
     
     public Board(Player p1, Player p2)
     {          
          board = new String();
          
          for(int i = 0; i < 9; i++)
          {               
               board += i+" .";
               
               for(int j = 0; j < 9; j++)
               {

                    if(p1.getX() == j && p1.getY() == i)
                    {
                         board += "o.";
                    }
                    else if(p2.getX() == j && p2.getY() == i)
                    {
                         board += "x.";
                    }
                    else if(p1.getwallX1() == j && p1.getwallY1() == i && p1.x1_wall > 0)  
                    {
                         board += "|";
                    }
                   
                   else if(p2.getwallX1() == j && p1.getwallY1() == i && p2.x1_wall > 0)
                    {
                         board += " |";
                    }
                   
                    
                    else
                         board += " .";
               }//end for    
               
               board += " \n";
               
          }//end for 
     }     
     
     public String reDraw(Player p1, Player p2)
     {
          board = new String();
          
          for(int i = 0; i < 9; i++)
          {               
               board += i+" .";
               
               for(int j = 0; j < 9; j++)
               {

                    // si el jugador se encuentra en una posicion x ,y este dibuja su respectivo simbolo
                    if(p1.getX() == j && p1.getY() == i)
                    {
                         board += "o.";
                    }
                    else if(p2.getX() == j && p2.getY() == i)
                    {
                         board += "x.";
                    }

                    // si el valor de la posicion de un muro de cierto jugador estaa, este es dibujado
                    else if(p1.getwallX1() == j && p1.getwallY1() == i && p1.x1_wall > 0)
                    {
                         board += " |";
                    }
                   
                    else if(p2.getwallX1() == j && p2.getwallY1() == i && p2.x1_wall > 0)
                    {
                         board += " |";
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
          return new String("  0 1 2 3 4 5 6 7 8 \n" + board);
     }
}//Board class
