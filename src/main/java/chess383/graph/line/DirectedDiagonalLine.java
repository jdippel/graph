/*
 *  DirectedDiagonalLine.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2020 - 2022 Jörg Dippel
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

package chess383.graph.line;

import chess383.ColorEnum;
import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.direction.Direction;

/**
 * Provides locations on a line.
 *
 * @author    Jörg Dippel
 * @version   February 2020
 *
 */
public class DirectedDiagonalLine extends LineOfLocations {
    
	// for interface Serializable
	private static final long serialVersionUID = 325182219372119496L;

    private static final Direction STANDARD_DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
    private static final Direction REVERSED_DIRECTION = Direction.createReversedDirection( STANDARD_DIRECTION );

	/** ---------  Attributes  -------------------------------- */

	// inherited

	/** ---------  Constructors  ------------------------------ */

    private DirectedDiagonalLine( String locations ) {

    	super( AdjacencyEnum.BY_POINT, STANDARD_DIRECTION, locations );
    }

    private DirectedDiagonalLine( Direction direction, String locations ) {

        super( AdjacencyEnum.BY_POINT, direction, locations );
    }

    /** ---------  Getter and Setter  ------------------------- */

    // inherited

    /** ---------  Factory  ----------------------------------- */
    
    public static DirectedDiagonalLine createLine( String locations, Direction direction ) {

        DirectedDiagonalLine result;

        result = new DirectedDiagonalLine( direction, normalizeStandard( locations ) );
        
        return result;
    }

    public static DirectedDiagonalLine createLine( String locations ) {

        DirectedDiagonalLine result;

        result = new DirectedDiagonalLine( normalizeStandard( locations ) );

        return result;
    }

    public static DirectedDiagonalLine createReversedLine( String locations, Direction direction ) {

        DirectedDiagonalLine result;

        result = new DirectedDiagonalLine( Direction.createReversedDirection( direction ), normalizeReversed( locations ) );

        return result;
    }

    public static DirectedDiagonalLine createReversedLine( String locations ) {

        DirectedDiagonalLine result;

        result = new DirectedDiagonalLine( REVERSED_DIRECTION, normalizeReversed( locations ) );

        return result;
    }

    /** ------------------------------------------------------- */
    
    public boolean matchesAdjacency( AdjacencyEnum adjacency ) {
    	return ( adjacency == AdjacencyEnum.BY_POINT );
    }
    
    /** ---------  Inheritance from Object  ------------------- */

    @Override
    public String toString( ) {

        return( getClass().getName() + " : " + super.toString() );
    }

    @Override
    public boolean equals( Object value ) {

        boolean result;

        result = ( value instanceof DirectedDiagonalLine ) && 
        		 isMeaningfullyEquivalent( ( DirectedDiagonalLine ) value );
        
        return( result );
    }

    private boolean isMeaningfullyEquivalent( DirectedDiagonalLine value ) {

        boolean result;
        
        result = getDirection().equals( value.getDirection() ) 
              && getLocations().equals( value.getLocations() );

        return( result );
    }

    @Override public int hashCode( ) { return( toString( ).hashCode( ) ); }
}

