/*
 * ANTHONY DE LOS SANTOS
 * LUIS SERGENT
 * DANIEL DIAZ
 * CHRISTOPHER JOGG
 * RUBEN GUILLEN
 */
import java.util.*;
public class variables {
     String direction = "";
    String currentplayer_history;
    boolean isGameOver = false;
    String input = new String();
    int count = 0;
    boolean moved=true;
    String accion;
    int[] wall_position=new int[2];
    Player[] players = new Player[2];
    ArrayList <String> history_pb = new ArrayList<String>();
    ArrayList <String> history_pr = new ArrayList<String>();

    // historial
    public void getHistory(ArrayList <String> history1, ArrayList <String> history2) {
        System.out.println("Historial de movimientos");
                                      for (int i = 0; i < history1.size(); i++) {
                                           System.out.println(history1.get(i));

                                           
                                      }
                                      System.out.println("-----------------------------------------------------");
                                      
                                      for (int i = 0; i < history2.size(); i++) {
                                           System.out.println(history2.get(i));

                                           
                                      }
        
   }
}
