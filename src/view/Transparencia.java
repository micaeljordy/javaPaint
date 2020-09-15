
package view;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *  Classe para deixar um JFrame transparente
 * @author Micael Jordy
 */
public class Transparencia {
    
    /**
     * Contrutor de aplicarTransparencia
     * @param frame 
     */
    
    public void aplicarTransparencia(JFrame frame){
       frame.setUndecorated(true);
       frame.setBackground(new Color(0,0,0,0));
    }
        
}
