import java.util.ArrayList;

/*
 * ANTHONY DE LOS SANTOS
 * LUIS SERGENT
 * DANIEL DIAZ
 * CHRISTOPHER JOGG
 * RUBEN GUILLEN
 */
public class Player
{
     public int x, y, n, x1v_wall, y1v_wall, x2v_wall, y2v_wall, walls, x1h_wall, x2h_wall,x3h_wall,x4h_wall;
     ArrayList <Integer> P1wallV_history = new ArrayList<Integer>(); // historial de jugador 1 (muros)
     ArrayList<Integer> P2wallV_history = new ArrayList<Integer>(); // historial de jugador 2 (muros)
      ArrayList <Integer> P1wallH_history = new ArrayList<Integer>(); // historial de jugador 1 (muros)
      ArrayList <Integer>  P2wallH_history = new ArrayList<Integer>(); // historial de jugador 2 (muros)
     
     public String name;
     
     public Player()
     {
          x = 0;
          y = 0;
          n = 1;
          walls = 10;
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
     
     public Player(int x_pos, int y_pos, int nb, String nm,int walls_count)
     {
          x = x_pos;
          y = y_pos;
          n = nb;
          walls = walls_count;
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
               if((y == getHwallX2() && x == getHwallX1()) || (x == getHwallX3() && y == getHwallX4()))
               {
                    System.out.println("nope");
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
               if((y == getHwallX2() && x == getHwallX1()) || (x == getHwallX3() && y == getHwallX4()))
               {
                    System.out.println("nope");
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
               if((x == getVwallX1() && y == getVwallY1()) || (y == getVwallY2() && x == getVwallX2()))
               {
                    System.out.println("nope");
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
               if((x == getVwallX1() && y == getVwallY1()) || (y == getVwallY2() && x == getVwallX2()))
               {
                    System.out.println("nope");
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

     public int getVwallX1()
     {
          return x1v_wall;
     }
     
     public int getVwallY1()
     {
          return y1v_wall;
     }
      public int getVwallX2()
     {
          return x2v_wall;
     }
     
     public int getVwallY2()
     {
          return y2v_wall;
     }
     public int getHwallX1()
     {
          return x1h_wall;
     }
     public int getHwallX2()
     {
          return x2h_wall;
     }
     public int getHwallX3()
     {
          return x3h_wall;
     }
     public int getHwallX4()
     {
          return x4h_wall;
     }
    
     

     
     public String toString()
     {
          return name;
     }   
}
