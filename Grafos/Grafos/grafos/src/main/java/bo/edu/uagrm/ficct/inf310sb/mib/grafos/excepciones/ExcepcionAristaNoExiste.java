/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.edu.uagrm.ficct.inf310sb.mib.grafos.excepciones;

/**
 *
 * @author HP 240 G5
 */
public class ExcepcionAristaNoExiste extends Exception {
    public ExcepcionAristaNoExiste() {
        super("Arista No Existe");
    }

    public ExcepcionAristaNoExiste(String message) {
        super(message);
    }
}

