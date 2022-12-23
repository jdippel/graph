/*
 *  UndirectedRowsLine.java
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

import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.direction.Direction;

/**
 * Provides locations on a line.
 *
 * @author    Jörg Dippel
 * @version   November 2022
 *
 */
public class UndirectedRowsLine extends LineOfLocations {
    
    // for interface Serializable
	private static final long serialVersionUID = 9129514009653420169L;
	
	private static final Direction UNDIRECTED_DIRECTION = Direction.createBidirectionalDirection();
	
	/** ---------  Attributes  -------------------------------- */

	// inherited 

    /** ---------  Constructors  ------------------------------ */

    private UndirectedRowsLine( String locations ) {

    	super( AdjacencyEnum.BY_EDGE, UNDIRECTED_DIRECTION, locations ); 
    }

    /** ---------  Getter and Setter  ------------------------- */

    // inherited 

    /** ---------  Factory  ----------------------------------- */
    
    public static UndirectedRowsLine createLine( String locations ) {

        return new UndirectedRowsLine( normalizeStandard( locations ) );
    }

    public static UndirectedRowsLine createReversedLine( String locations ) {

        return new UndirectedRowsLine( normalizeReversed( locations ) );
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

        return ( value instanceof UndirectedRowsLine )
                && isMeaningfullyEquivalent( ( UndirectedRowsLine ) value );
    }

    private boolean isMeaningfullyEquivalent( UndirectedRowsLine value ) {

        return getLocations().equals( value.getLocations() );
    }

    @Override public int hashCode( ) { return( toString( ).hashCode( ) ); }
}

