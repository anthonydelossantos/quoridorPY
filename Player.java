public class Player
{
     public int x, y, n, x1_wall, y1_wall;
     int[] P1wall_history = new int[20]; // historial de jugador 1 (muros)
     int[] P2wall_history = new int[20]; // historial de jugador 2 (muros)
     
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
     
     public boolean moverPeon(String dir)
     {
          boolean wasMoved = true;
          
          if(dir.equalsIgnoreCase("ARRIBA") || dir.equalsIgnoreCase("A"))
          {
               y--;
               if (y < 0)
               {
                    y++;
                    wasMoved = false;
               }
          }
          else if(dir.equalsIgnoreCase("ABAJO") || dir.equalsIgnoreCase("AB") )
          {
               y++;
               if (y > 8)
               {
                    y--;
                    wasMoved = false;
               }
          }
          else if(dir.equalsIgnoreCase("IZQUIERDA") || dir.equalsIgnoreCase("I"))
          {
               x--;
               if (x < 0)
               {
                    x++;
                    wasMoved = false;
               }
          }
          else if(dir.equalsIgnoreCase("DERECHA")  || dir.equalsIgnoreCase("D"))
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
     /* 
     public int getwallX2()
     {
          return x2_wall;
     }
     
     public int getwallY2()
     {
          return y2_wall;
     }
     */
     
     
     public String toString()
     {
          return name;
     }
     
}
