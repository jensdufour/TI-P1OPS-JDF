/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author timgr
 */
public class IllegalNameException extends Exception{

    public IllegalNameException() {
    }

    public IllegalNameException(String message) {
        super(message);
    }

    public IllegalNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalNameException(Throwable cause) {
        super(cause);
    }
    
    
    
}
