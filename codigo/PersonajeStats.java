package mundimap.common;

import java.util.HashMap;

public class PersonajeStats {
  /* Inicializa los parametros aleatoriamente */
  private java.util.Random rand ;

  /* *********************
   * Nombres de parametros
   * ********************* */
  public final String Title          = Constantes.Title;
  public final String TitleSmall     = Constantes.TitleSmall;
  public final String HealthPower    = Constantes.HealthPower;
  public final String FacHealthPower = Constantes.FacHealthPower;
  public final String MagicPower     = Constantes.MagicPower;
  public final String FacMagicPower  = Constantes.FacMagicPower;
  public final String AccessAbility  = Constantes.AccessAbility;

  private String type; /* fighter, wizard, thief */
  private String title;
  private String titleSmall;
  private int    healthPower;
  private int    facHealthPower;
  private int    magicPower;
  private int    facMagicPower;
  private int    accessAbility;

  /* Prefiero hacer seudoconstructores */
  private PersonajeStats() {
    rand =  new java.util.Random((long) System.currentTimeMillis());
  }

  public java.util.Map<String, String> toMap() {
    java.util.Map<String, String> valor =
      java.util.Map.of(
             Constantes.Type,           new String(type),
             Constantes.Title,          new String(title),
             Constantes.TitleSmall,     new String(TitleSmall),
             Constantes.HealthPower,    Integer.toString(healthPower),
             Constantes.FacHealthPower, Integer.toString(facHealthPower),
             Constantes.MagicPower,     Integer.toString(magicPower),
             Constantes.FacMagicPower,  Integer.toString(facMagicPower),
             Constantes.AccessAbility,  Integer.toString(accessAbility));
    return valor;
  }

  /* **
   * Getters
   */
  public String getType()           { return type; }
  public String getTitle()          { return title; }
  public String getTitleSmall()     { return titleSmall; }
  public int    getHealthPower()    { return healthPower; }
  public int    getFacHealthPower() { return facHealthPower; }
  public int    getMagicPower()     { return magicPower; }
  public int    getFacMagicPower()  { return facMagicPower; }
  public int    getAccessAbility()  { return accessAbility; }

  /* Crea un Fighter */
  public PersonajeStats createFighter() {
    PersonajeStats p = new PersonajeStats();
    p.type           = Constantes.FighterType;
    p.title          = Constantes.FighterTitle;
    p.titleSmall     = Constantes.FighterTitleSmall;
    p.healthPower    =
	  entre(Constantes.FighterMinHealthPower, Constantes.FighterMaxHealthPower);
    p.facHealthPower = Constantes.FighterFacHealthPower;
    p.magicPower     = 
	  entre(Constantes.FighterMinMagicPower, Constantes.FighterMaxMagicPower);
    p.facMagicPower  = Constantes.FighterFacMagicPower;
    p.accessAbility  = Constantes.FighterAccessAbility;

    return p;
  }

  /* Crea un Wizard */
  public PersonajeStats createWizard() {
    PersonajeStats p = new PersonajeStats();
    p.type           = Constantes.WizardType;
    p.title          = Constantes.WizardTitle;
    p.titleSmall     = Constantes.WizardTitleSmall;
    p.healthPower    =
	  entre(Constantes.WizardMinHealthPower, Constantes.WizardMaxHealthPower);
    p.facHealthPower = Constantes.WizardFacHealthPower;
    p.magicPower     = 
	  entre(Constantes.WizardMinMagicPower, Constantes.WizardMaxMagicPower);
    p.facMagicPower  = Constantes.WizardFacMagicPower;
    p.accessAbility  = Constantes.WizardAccessAbility;

    return p;
  }

  /* Crea un Thief */
  public PersonajeStats createThief() {
    PersonajeStats p = new PersonajeStats();
    p.type           = Constantes.ThiefType;
    p.title          = Constantes.ThiefTitle;
    p.titleSmall     = Constantes.ThiefTitleSmall;
    p.healthPower    =
	  entre(Constantes.ThiefMinHealthPower, Constantes.ThiefMaxHealthPower);
    p.facHealthPower = Constantes.ThiefFacHealthPower;
    p.magicPower     = 
	  entre(Constantes.ThiefMinMagicPower, Constantes.ThiefMaxMagicPower);
    p.facMagicPower  = Constantes.ThiefFacMagicPower;
    p.accessAbility  = Constantes.ThiefAccessAbility;

    return p;
  }

  /**
   * Obtiene un valor aleatorio entre el min y el max. Ints coded in Strings
   */
  private int entre(int min, int max) {
    return rand.nextInt(max - min + 1) + min;
  }
}
