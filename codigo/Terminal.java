package mundimap.common;

public class Terminal {
  public static void main(String [] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);

    String user = (args.length >0) args[0]: "<nil>";

    System.out.println("Hello ["+user+"]);

    while(true) {
      System.out.print("> ");
      String orden = sc.next();
      String argumento;
      switch (orden) {
        case "Query": case "Ask": case "Show":
          argumento = sc.nextLine().trim();
          System.out.println("pregunta: ["+argumento+"]");
          break;
        case "Activate": case "Open": case "Disclose":
          argumento = sc.nextLine().trim();
          System.out.println("accion: "+argumento);
          break;
        case "Exit": case "Abandon": case "Surrender":
          System.out.println("final.!");
          System.exit(0);
          break;
        default:
          System.out.println("No entiendo.");
      }
    }

  }
}
