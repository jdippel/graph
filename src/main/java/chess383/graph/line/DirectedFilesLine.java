/*
 *  DirectedFilesLine.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2020 -2022 Jörg Dippel
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
 * @version   January 2022
 *
 */
public class DirectedFilesLine extends LineOfLocations {
    
	// for interface Serializable
	private static final long serialVersionUID = 2912077828438255186L;

    private static final Direction STANDARD_DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
    private static final Direction REVERSED_DIRECTION = Direction.createReversedDirection( STANDARD_DIRECTION );

	/** ---------  Attributes  -------------------------------- */

	// inherited 

	/** ---------  Constructors  ------------------------------ */

    private DirectedFilesLine( String locations ) {

        super( AdjacencyEnum.BY_EDGE, STANDARD_DIRECTION, locations );
    }

    private DirectedFilesLine( String locations, Direction direction ) {

    	super( AdjacencyEnum.BY_EDGE, direction, locations );
    }

    /** ---------  Getter and Setter  ------------------------- */

    // inherited 

    /** ---------  Factory  ----------------------------------- */
    
    public static DirectedFilesLine createLine( String locations, Direction direction ) {

        DirectedFilesLine result;

        result = new DirectedFilesLine( normalizeStandard( locations ), direction );
        
        return result;
    }

    public static DirectedFilesLine createLine( String locations ) {

        DirectedFilesLine result;

        result = new DirectedFilesLine( normalizeStandard( locations ) );

        return result;
    }

    public static DirectedFilesLine createReversedLine( String locations, Direction direction ) {

        DirectedFilesLine result;

        result = new DirectedFilesLine( normalizeReversed( locations ), Direction.createReversedDirection( direction ) );

        return result;
    }

    public static DirectedFilesLine createReversedLine( String locations ) {

        DirectedFilesLine result;

        result = new DirectedFilesLine( normalizeReversed( locations ), REVERSED_DIRECTION );

        return result;
    }

    /** ------------------------------------------------------- */
    
    public boolean matchesAdjacency( AdjacencyEnum adjacency ) {
    	return ( adjacency == AdjacencyEnum.BY_EDGE );
    }
    
    /** ---------  Inheritance from Object  ------------------- */

    @Override
    public String toString( ) {

        return( getClass().getName() + " : " + super.toString() );
    }

    @Override
    public boolean equals( Object value ) {

        boolean result;

        result = ( value instanceof DirectedFilesLine ) && 
        		 isMeaningfullyEquivalent( ( DirectedFilesLine ) value );
        
        return( result );
    }

    private boolean isMeaningfullyEquivalent( DirectedFilesLine value ) {

        boolean result;
        
        result = getLocations().equals( value.getLocations() );

        return( result );
    }

    @Override public int hashCode( ) { return( toString( ).hashCode( ) ); }
}

