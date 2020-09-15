
package exceptions;

/**
 * Esta classe retornará a String: "Atributo Inválido! no terminal"
 * @author Micael Jordy
 */
public class ValorInvalido extends RuntimeException{
    
    @Override
    public String toString(){
        return "Atributo Inválido!";
    }
}
