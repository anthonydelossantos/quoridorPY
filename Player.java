public class Player
{
     public int x, y, n, x1_wall, y1_wall, x2_wall, y2_wall;
     public String name;
     
     public Player()
     {
          x = 0;
          y = 0;
          n = 1;
          name = new String("Player " + Integer.toString(n));
     }
     
     public Player(int x_pos, int y_pos)
     {
          x = x_pos;
          y = y_pos;
          n = 1;
          name = new String("Player " + Integer.toString(n));
     }
     
     public Player(int x_pos, int y_pos, int nb)
     {
          x = x_pos;
          y = y_pos;
          n = nb;
          name = new String("Player " + Integer.toString(n));
     }
     
     public Player(int x_pos, int y_pos, int nb, String nm)
     {
          x = x_pos;
          y = y_pos;
          n = nb;
          name = nm;
     }
     
     public boolean movePiece(String dir)
     {
          boolean wasMoved = true;
          
          if(dir.equalsIgnoreCase("UP") || dir.equalsIgnoreCase("U"))
          {
               y--;
               if (y < 0)
               {
                    y++;
                    wasMoved = false;
               }
          }
          else if(dir.equalsIgnoreCase("DOWN") || dir.equalsIgnoreCase("D") )
          {
               y++;
               if (y > 8)
               {
                    y--;
                    wasMoved = false;
               }
          }
          else if(dir.equalsIgnoreCase("LEFT") || dir.equalsIgnoreCase("L"))
          {
               x--;
               if (x < 0)
               {
                    x++;
                    wasMoved = false;
               }
          }
          else if(dir.equalsIgnoreCase("RIGHT")  || dir.equalsIgnoreCase("R"))
          {
               x++;
               if (x > 8)
               {
                    x--;
                    wasMoved = false;
               }
          }
          else
               wasMoved = false;
          
          return wasMoved;
     }
     
     public int getX()
     {
          return x;
     }
     
     public int getY()
     {
          return y;
     }

     public int getwallX1()
     {
          return x1_wall;
     }
     
     public int getwallY1()
     {
          return y1_wall;
     }
     public int getwallX2()
     {
          return x2_wall;
     }
     
     public int getwallY2()
     {
          return y2_wall;
     }
     
     
     
     
     public String toString()
     {
          return name;
     }
     
}
