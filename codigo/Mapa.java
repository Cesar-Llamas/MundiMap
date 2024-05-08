package mundimap.common;

import java.util.HashMap;
import java.util.ArrayList;

public class Mapa {
  public HashMap<String, Place> lugares;
  public boolean init() {
    this.lugares = new HashMap<>();

    /* Aquí ponemos el array con los nombres de las
     * habitaciones (que aquí son sólo números).
     */
    String [] vectorId = {
      "1", "2", "3", "4", "5", "6", "7"
    };

    for (String id : vectorId) {
      lugares.put(id, new Place(id));
    }

    Place lugar;
    /* Lugar "1": antesala */
      lugar = lugares.get("1");
      lugar.setNameMessage("Antesala", "Aqui empieza todo");
      lugar.setDoors(new ArrayList<Door>() { {
         add(new Door("2", "a", "Puerta a.", 20, 20,
				 Constantes.EventReopens));
         add(new Door("3", "b", "Puerta b.", 200, 200,
				 Constantes.EventReopens));
      }});
      lugar.setChests(new ArrayList<Chest>() {{
         add(new Chest("A", "Cofre A.", 0, 0, -30, -30,
				 Constantes.EventReopens));
      }});
    /* Lugar "2": pasillo */
      lugar = lugares.get("2");
      lugar.setNameMessage("Pasillo", "Largo pasillo");
      lugar.setDooors(new ArrayList<Door>() { {
	 add(new Door("1", "a", "Puerta a.", .....
	 add(new Door("4", "b", "Puerta b.", .....
         add(new Door("5", "c", "Puerta c.", ...
       
      // no hay cofres
    /* Lugar "3": habitacion del tesoro */
      lugar = lugares.get("3");
      lugar.setNameMessage("Sala", "Gran salon sin salida");
      // no hay salida
      
      lugar.setChests(new ArrayList<Chest>() {{
         add(new Chest("A", "Gran Cofre A.", 0, 0, -30, -30,
				 Constantes.EventReopens));


       return true;
  }
}
