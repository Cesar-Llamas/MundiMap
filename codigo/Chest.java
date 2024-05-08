package mundimap.common;

import java.util.HashMap;

public class Chest {
  /* *********************
   * Nombres de parametros
   * ********************* */
  public final String Name    = Constantes.ChestName;
  public final String Message = Constantes.ChestMessage;
  public final String MP      = Constantes.ChestMP;
  public final String HP      = Constantes.ChestHP;
  public final String Food    = Constantes.ChestFood;
  public final String Potion  = Constantes.ChestPotion;
  public final String Event   = Constantes.ChestEvent;

  private String name;
  private String message;
  private int    mp;
  private int    hp;
  private int    food;
  private int    potion;
  private String event;

  private Chest() {
    name    = Constantes.DefaultChestName;
    message = Constantes.DefaultChestMessage;
    hp      = Constantes.DefaultChestHP;
    mp      = Constantes.DefaultChestMP;
    food    = Constantes.DefaultChestFood;
    potion  = Constantes.DefaultChestPotion;
    event   = Constantes.DefaultChestEvent;
  }

  public Chest(String name, String message, int hp, int mp,
            int food, int potion, String event) {
    this.name    = name;
    this.message = message;
    this.hp      = hp;
    this.mp      = mp;
    this.food    = food;
    this.potion  = potion;
    this.event   = event;
  }

  public java.util.Map<String, String> toMap() {
    java.util.Map<String, String> valor =
      java.util.Map.of(
         Name,    new String(name),
         Message, new String(message),
         MP,      Integer.toString(mp),
         HP,      Integer.toString(hp),
         Food,    Integer.toString(food),
         Potion,  Integer.toString(potion),
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

  public void setHpMpFoodPotion(int hp, int mp, int food, int potion) {
    this.hp     = hp;
    this.mp     = mp;
    this.food   = food;
    this.potion = potion;
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
  public int    getFood()    { return food; }
  public int    getPotion()  { return potion; }
  public String getEvent()   { return event; }
}
