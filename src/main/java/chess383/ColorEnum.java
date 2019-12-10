/*
 *  ColorEnum.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2010-2016 Jörg Dippel
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
 * Provides a color.
 *
 * @author    Jörg Dippel
 * @version   November 2016
 *
 */
public enum ColorEnum {

    NONE,
    
    WHITE                { @Override public String toString( ) { return( "white" ); }
                           @Override public boolean isOfWhiteColor( ) { return( true ); } }, 
    BLACK                { @Override public String toString( ) { return( "black" ); } 
                           @Override public boolean isOfBlackColor( ) { return( true ); } }, 
    RED                  { @Override public String toString( ) { return( "red" ); } 
                           @Override public boolean isOfRedColor( ) { return( true ); } };
    
    @Override 
    public String  toString( )       { return( "no color" ); }
    public boolean isOfWhiteColor( ) { return( false ); }
    public boolean isOfBlackColor( ) { return( false ); }
    public boolean isOfRedColor( )   { return( false ); }
}
