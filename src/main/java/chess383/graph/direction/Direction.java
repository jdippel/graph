/*
 *  Direction.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2015-2019 Jörg Dippel
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

package chess383.graph.direction;

import java.io.Serializable;

import chess383.ColorEnum;


/**
 * Defines directions based on colors.
 *
 * @author    Jörg Dippel
 * @version   January 2019
 *
 */
public class Direction implements Serializable {
    
    // for interface Serializable
    private static final long serialVersionUID = 7454011750372686374L;
    
    /** ---------  Attributes  -------------------------------- */

     private ColorEnum start;
     private ColorEnum end;

    /** ---------  Constructors  ------------------------------ */
    
    private Direction( ColorEnum start, ColorEnum end ) {

        setStart( start );
        setEnd( end );
    }
    
    /** ---------  Getter and Setter  ------------------------- */
    
    private void setStart( ColorEnum value ) { this.start = value; }
    public ColorEnum getStart( )             { return( this.start ); }
    private void setEnd( ColorEnum value )   { this.end = value; }
    public ColorEnum getEnd( )               { return( this.end ); }
    
    /** ---------  Factory  ----------------------------------- */
    
    static public Direction createUnidirectionalDirection( ColorEnum start, ColorEnum end ) {

        return new Direction( start, end );
    }
    
    static public Direction createBidirectionalDirection( ) {

        return new Direction( ColorEnum.NONE, ColorEnum.NONE );
    }
    
    static public Direction createReversedDirection( Direction direction ) {
        
        return createUnidirectionalDirection( direction.getEnd( ), direction.getStart( ) );
    }

    /** ------------------------------------------------------- */
    
    public boolean isDirected( ) {
        
        return( getStart() != ColorEnum.NONE );
    }
   
    /** ---------  Inheritance from Object  ------------------- */

    @Override
    public String toString( ) {
        
        return( isDirected( ) ? "directed from " + getStart( ) + " to " + getEnd( ) : "not directed" );
    }

    @Override
    public boolean equals( Object value ) {

        boolean result;

        result = ( value instanceof Direction ) && isMeaningfullyEquivalent( ( Direction ) value );

        return( result );
    }

    private boolean isMeaningfullyEquivalent( Direction value ) {

        boolean result;
        
        result = ( getStart( ) == value.getStart( ) ) && ( getEnd( ) == value.getEnd( ) );

        return( result );
    }

    @Override public int hashCode( ) { return( getStart( ).toString( ).hashCode( ) + 7 * getEnd( ).toString( ).hashCode( ) ); }
}

