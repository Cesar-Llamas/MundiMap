package mundimap.common;

import java.util.HashMap;

public class Place {
  /* *********************
   * Nombres de parametros
   * ********************* */
  public final String Id      = Constantes.PlaceId;
  public final String Name    = Constantes.PlaceName;
  public final String Message = Constantes.PlaceMessage;

  private HashMap<String, Door>  puertas ;
  private HashMap<String, Chest> cofres  ;

  private final String id;
  private String name;
  private String message;

  public Place(final String id) {
    this.id      = id;
    this.name    = Constantes.DefaultPlaceName;
    this.message = Constantes.DefaultPlaceMessage;
    this.puertas = new HashMap<String, Door>();
    this.cofres  = new HashMap<String, Chest>();
  }

  public java.util.Map<String, String> toMap() {
    java.util.Map<String, String> valor =
      java.util.Map.of(
         Id,      new String(id),
         Name,    new String(name),
         Message, new String(message));
    return valor;
  }

  /* **
   * Setters especiales
   */
  public void setNameMessage(String name, String message) {
    this.name    = new String(name);
    this.message = new String(message);
  }
  public void setDoors(java.util.ArrayList<Door> doors) {
    for (Door puerta : doors) {
      this.puertas.put(puerta.getName(), puerta);
    }
  }
  public void setChests(java.util.ArrayList<Chest> chests) {
    for (Chest cofre : chests) {
      this.cofres.put(cofre.getName(), cofre);
    }
  }

  /* **
   * Getters
   */
  public String getName()    { return name; }
  public String getMessage() { return message; }
  public Door getDoor(String nombre) {
    return puertas.get(nombre) ;
  }
  public Chest getChest(String nombre) {
    return cofres.get(nombre) ;
  }
  /*
   * Lista de nombres de puertas y cofres de una estancia.
   */
  public HashMap<String,String> toList() {
    HashMap<String, String> lista = new HashMap<>();
    for (String nombre : puertas.keySet()) {
      lista.put(nombre, puertas.get(nombre).getMessage());
    }
    for (String nombre : cofres.keySet()) {
      lista.put(nombre, cofres.get(nombre).getMessage());
    }
    return lista;
  }
}
