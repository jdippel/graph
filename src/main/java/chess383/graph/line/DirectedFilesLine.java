/*
 *  DirectedFilesLine.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2020 Jörg Dippel
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

import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.direction.Direction;

/**
 * Provides locations on a line.
 *
 * @author    Jörg Dippel
 * @version   February 2020
 *
 */
public class DirectedFilesLine extends LineOfLocations {
    
	// for interface Serializable
	private static final long serialVersionUID = 2912077828438255186L;

	/** ---------  Attributes  -------------------------------- */

	// inherited 

	/** ---------  Constructors  ------------------------------ */

    private DirectedFilesLine( AdjacencyEnum adjacency, Direction direction, String locations ) {

    	super( AdjacencyEnum.BY_EDGE, direction, locations );
    }

    /** ---------  Getter and Setter  ------------------------- */

    // inherited 

    /** ---------  Factory  ----------------------------------- */
    
    public static DirectedFilesLine createLine( Direction direction, String locations ) {

        DirectedFilesLine result;

        result = new DirectedFilesLine( AdjacencyEnum.BY_EDGE, direction, normalize( locations, direction.isDirected() ) );
        
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

