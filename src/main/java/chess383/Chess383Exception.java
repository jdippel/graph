/*
 *  Chess383Exception.java
 * 
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2010-2011 Jörg Dippel
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package chess383;

/**
 * This class defines a derived exception.
 *
 * @author    Jörg Dippel
 * @version   December 2018
 * 
 */
public class Chess383Exception extends RuntimeException {

    /**
     * exception is derived from Exception which implements interface java.io.Serializable
     */
    private static final long serialVersionUID = -5589072119962995160L;

    /**
     * Constructor creates a special exception
     */    
    public Chess383Exception( ) { }
    
    /**
     * Constructor creates a special exception
     * 
     * @param message is a description of the exception
     */    
    public Chess383Exception( String message ) {
        
        super( message );
    }
}
