package mundimap.common;

/*
 * Parametros y carteles de Personajes, estancias, objetos y puertas
 */

class Constantes {
/* ********************************************************
 * Parametros y carteles de Estancias, objetos y puertas
 * ******************************************************** */
  /* ---------------------
   *       General
   * --------------------- */
 final static String PositiveMessage = "PositiveMessage";
 final static String NegativeMessage = "NegativeMessage";
 final static String EventReopens    = "reopens";
 final static String EventRecloses   = "recloses";
 final static String DefaultPositiveMessage = "As you wish!";
 final static String DefaultNegativeMessage = "Sorry, you don't have enough power or magic!";

  /* ---------------------
   *       Estancias
   * --------------------- */
 final static String PlaceId         = "Id";
 final static String PlaceName       = "Name";
 final static String PlaceMessage    = "PlaceMessage";

 final static String DefaultPlaceName       = "Here, where you are now.";
 final static String DefaultPlaceMessage    = "<...>";
              /* say something, please, like "Random dark place." */

  /* ---------------------
   *       Cofres
   * --------------------- */
 final static String ChestName       = "ChestName";
 final static String ChestMessage    = "ChestMessage";
 final static String ChestMP         = "ChestMP";
 final static String ChestHP         = "ChestHP";
 final static String ChestFood       = "ChestFood";
 final static String ChestPotion     = "ChestPotion";
 final static String ChestEvent      = "ChestEvent";

 final static String DefaultChestName    = "Chest";
              /* si ya existe el nombre se agrega una 'X' y se prueba de nuevo */
 final static String DefaultChestMessage = "A simple chest.";
 final static int DefaultChestHP       = 0;
 final static int DefaultChestMP       = 0;
 final static int DefaultChestFood     = 0;
 final static int DefaultChestPotion   = 0;
 final static String DefaultChestEvent = EventRecloses;
              /* vuelve a cerrarse al salir del lugar */

  /* ---------------------
   *       Puertas
   * --------------------- */
 final static String DoorName        = "DoorName";
 final static String DoorMessage     = "DoorMessage";
 final static String DoorHP          = "DoorHP";
 final static String DoorMP          = "DoorMP";
 final static String DoorEvent       = "DoorEvent";

 final static String DefaultDoorName    = "Door";
              /* si existe el nombre se agrega una 'X' y se prueba de nuevo */
 final static String DefaultDoorMessage = "A simple door to pass through.";
 final static int DefaultDoorHP         = 0;
 final static int DefaultDoorMP         = 0;
 final static String DefaultDoorEvent   = EventRecloses;
              /* vuelve a cerrarse al salir del lugar */

/* **************************************
 * Parametros y carteles de Personajes
 * ************************************** */
  /* ---------------------
   * Nombres de parametros
   * --------------------- */
  final static String Type           = "Type";
  final static String Title          = "Title";
  final static String TitleSmall     = "TitleSmall";
  final static String HealthPower    = "HealthPower";
  final static String FacHealthPower = "FacHealthPower";
  final static String MagicPower     = "MagicPower";
  final static String FacMagicPower  = "FacMagicPower";
  final static String AccessAbility  = "AccessAbility";

  /* ---------------------------
   * Interno para PersonajeStats
   * --------------------------- */
  final static String MaxHealthPower = "MaxHealthPower";
  final static String MinHealthPower = "MinHealthPower";
  final static String MaxMagicPower  = "MaxMagicPower";
  final static String MinMagicPower  = "MinMagicPower";

  /* ------------
   *   THIEF
   * ------------ */
  final static String ThiefType  = "Thief";
  final static String ThiefTitle =
              "_________         _________ _______  _______ \n"
            + "\\__   __/|\\     /|\\__   __/(  ____ \\(  ____ \\n"
            + "   ) (   | )   ( |   ) (   | (    \\/| (    \\/\n"
            + "   | |   | (___) |   | |   | (__    | (__    \n"
            + "   | |   |  ___  |   | |   |  __)   |  __)   \n"
            + "   | |   | (   ) |   | |   | (      | (      \n"
            + "   | |   | )   ( |___) (___| (____/\\| )      \n"
            + "   )_(   |/     \\|\\_______/(_______/|/       \n"
            + "                                             ";

  final static String ThiefTitleSmall =
              "  _____ _    _      __ \n"
            + " |_   _| |_ (_)___ / _|\n"
            + "   | | | ' \\| / -_)  _|\n"
            + "   |_| |_||_|_\\___|_|  \n"
            + "                       \n";

  final static int ThiefMaxHealthPower =  60;
  final static int ThiefMinHealthPower =  40;
  final static int ThiefFacHealthPower = 100; /* factor 1.0 */
  final static int ThiefMaxMagicPower  =  60;
  final static int ThiefMinMagicPower  =  40;
  final static int ThiefFacMagicPower  = 100; /* factor 1.0 */
  final static int ThiefAccessAbility  = 150;
                     /* HP o MP se multiplica por 3/2 en cofres y puertas */

  /* ------------
   *   WIZARD
   * ------------ */
  final static String WizardType  = "Wizard";
  final static String WizardTitle =
               "         _________ _______  _______  _______  ______  \n"
             + "|\\     /|\\__   __// ___   )(  ___  )(  ____ )(  __  \\ \n"
             + "| )   ( |   ) (   \\/   )  || (   ) || (    )|| (  \\  )\n"
             + "| | _ | |   | |       /   )| (___) || (____)|| |   ) |\n"
             + "| |( )| |   | |      /   / |  ___  ||     __)| |   | |\n"
             + "| || || |   | |     /   /  | (   ) || (\\ (   | |   ) |\n"
             + "| () () |___) (___ /   (_/\\| )   ( || ) \\ \\__| (__/  )\n"
             + "(_______)\\_______/(_______/|/     \\||/   \\__/(______/ \n"
             + "                                                      ";

  final static String WizardTitleSmall =
               " __      ___                _ \n"
             + " \\ \\    / (_)_____ _ _ _ __| |\n"
             + "  \\ \\/\\/ /| |_ / _` | '_/ _` |\n"
             + "   \\_/\\_/ |_/__\\__,_|_| \\__,_|\n"
             + "                              \n";

  final static int WizardMaxHealthPower =  40;
  final static int WizardMinHealthPower =  20;
  final static int WizardFacHealthPower =  50;  /* factor 1/2 */
  final static int WizardMaxMagicPower  = 100;
  final static int WizardMinMagicPower  =  85;
  final static int WizardFacMagicPower  = 150; /* factor 3/2 */
  final static int WizardAccessAbility  = 100;
                            /* necesita todo el nivel para acceder */

  /* ------------
   *   FIGHTER
   * ------------ */
  final static String FighterType  = "Fighter";
  final static String FighterTitle =
                " _______ _________ _______          _________ _______  _______ "
              + "(  ____ \\__   __/(  ____ \\|\\     /|\\__   __/(  ____ \\(  ____ )"
              + "| (    \\/   ) (   | (    \\/| )   ( |   ) (   | (    \\/| (    )|"
              + "| (__       | |   | |      | (___) |   | |   | (__    | (____)|"
              + "|  __)      | |   | | ____ |  ___  |   | |   |  __)   |     __)"
              + "| (         | |   | | \\_  )| (   ) |   | |   | (      | (\\ (   "
              + "| )      ___) (___| (___) || )   ( |   | |   | (____/\\| ) \\ \\__"
              + "|/       \\_______/(_______)|/     \\|   )_(   (_______/|/   \\__/";
                                                               

  final static String FighterTitleSmall =
                "  ___ _      _   _           \n"
              + " | __(_)__ _| |_| |_ ___ _ _ \n"
              + " | _|| / _` | ' \\  _/ -_) '_|\n"
              + " |_| |_\\__, |_||_\\__\\___|_|  \n"
              + "       |___/                 ";

  final static int FighterMaxHealthPower = 100;
  final static int FighterMinHealthPower =  85;
  final static int FighterFacHealthPower = 150; /* factor 3/2 */
  final static int FighterMaxMagicPower  =  20;
  final static int FighterMinMagicPower  =  10;
  final static int FighterFacMagicPower  =  50; /* factor 1/2 */
  final static int FighterAccessAbility  = 100;
                           /* necesita todo el nivel para acceder */
}
