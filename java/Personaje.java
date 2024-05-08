package mundomap.common;

import java.util.HashMap;

/**
 * Personaje.java
 * Tipo de dato remoto para un personaje de MundoMap
 *
 * @version 1.0
 * @author CesarLlamas
 *
 * @since 04-15-2024
 */

public interface Personaje extends java.rmi.Remote {
  /** muestra un letrero generico sobre el personaje
   * @return mensaje literario para mostrar al usuario.
   * @throws java.rmi.RemoteException Error en RMI.
   */
  public String info() throws java.rmi.RemoteException;

  /** muestra la definicion del personaje: title, stats, limits, skills...
   * @return mensaje con pares de "atributo+valor" para el usuario.
   * @throws java.rmi.RemoteException Error en RMI.
   */
  public String status() throws java.rmi.RemoteException;

  /** muestra las acciones de que dispone en este momento y sus valores
   * @return mapa para el usuario en formato Java.
   * @throws java.rmi.RemoteException Error en RMI.
   */
  public HashMap<String, String> acciones() throws java.rmi.RemoteException;

  /** aplica en presente jugada un valor a una opcion, sin consolidarlo
   *
   * @param accion  una de las acciones mostradas en accion()
   * @param valor   uno de los valores admisibles para una accion
   * @return        un mensaje con el resultado previsible de la accion
   * @throws BadActionException se ha indicado una accion o valor no admitido
   * @throws java.rmi.RemoteException Error en RMI.
   * @see acciones() para ver acciones o valores admisibles
   */
  public String actua(String accion, String valor)
	  throws BadActionException, java.rmi.RemoteException;

  /** consolida en la presente jugada las acciones acumuladas con actua()
   * @return        un mensaje con el resultado global de las acciones
   * @throws BadCommitException no pueden consolidarse las acciones indicadas
   * @throws java.rmi.RemoteException Error en RMI.
   */
  public String commit() throws BadCommitException, java.rmi.RemoteException;
}
