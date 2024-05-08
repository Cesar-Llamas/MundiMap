package mundimap.common;

import java.util.HashMap;

public class Door {
  /* *********************
   * Nombres de parametros
   * ********************* */
  public final String PlaceId = Constantes.PlaceId; // destino puerta
  public final String Name    = Constantes.DoorName;
  public final String Message = Constantes.DoorMessage;
  public final String MP      = Constantes.DoorMP;
  public final String HP      = Constantes.DoorHP;
  public final String Event   = Constantes.DoorEvent;

  private String id;
  private String name;
  private String message;
  private int    mp;
  private int    hp;
  private String event;

  public Door(final String id) {
    this.id = id;
    name    = Constantes.DefaultDoorName;
    message = Constantes.DefaultDoorMessage;
    hp      = Constantes.DefaultDoorHP;
    mp      = Constantes.DefaultDoorMP;
    event   = Constantes.DefaultDoorEvent;
  }
  public Door(final String id, String name, String message,
                 int hp, int mp, String event) {
    this.id      = id;
    this.name    = name;
    this.message = message;
    this.hp      = hp;
    this.mp      = mp;
    this.event   = event;
  }

  public java.util.Map<String, String> toMap() {
    java.util.Map<String, String> valor =
      java.util.Map.of(
         PlaceId, new String(id),
         Name,    new String(name),
         Message, new String(message),
         MP,      Integer.toString(mp),
         HP,      Integer.toString(hp),
         Event,   event);
    return valor;
  }

  /* **
   * Setters especiales
   */
  public void setNameMessage(String name, String message) {
    this.name    = new String(name);
    this.message = new String(message);
  }

  public void setHpMp(int hp, int mp) {
    this.hp     = hp;
    this.mp     = mp;
  }
  public void setEvent(String ev) {
    switch(ev) {
    case Constantes.EventReopens:
      this.event = Constantes.EventReopens; break;
    case Constantes.EventRecloses:
      this.event = Constantes.EventRecloses;
    }
  }

  /* **
   * Getters
   */
  public String getName()    { return name; }
  public String getMessage() { return message; }
  public int    getHP()      { return hp; }
  public int    getMP()      { return mp; }
  public String getEvent()   { return event; }
}
