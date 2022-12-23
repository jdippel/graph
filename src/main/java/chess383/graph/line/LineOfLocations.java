/*
 *  LineOfLocations.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2019 - 2022 Jörg Dippel
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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.direction.Direction;

/**
 * Provides locations on a line.
 *
 * @author    Jörg Dippel
 * @version   November 2022
 *
 */
public abstract class LineOfLocations implements Serializable {
    
    // for interface Serializable
	private static final long serialVersionUID = 3544070056343946501L;
	
	/** ---------  Attributes  -------------------------------- */

//    private AdjacencyEnum adjacency;            // adjacency is defined by polymorphism
    private Direction direction;
    private String locations;

    /** ---------  Constructors  ------------------------------ */

    protected LineOfLocations( AdjacencyEnum adjacency, Direction direction, String locations ) {

//        setAdjacency( adjacency );            // adjacency is defined by polymorphism
        setDirection( direction );
        setLocations( locations );
    }

    /** ---------  Getter and Setter  ------------------------- */
    
    private void setDirection( Direction value )     { this.direction = value; }
    public Direction getDirection( )                 { return( this.direction ); }
    
    private void setLocations( String value )        { this.locations = value; }
    public String getLocations( )                    { return( this.locations ); }

    /** ------------------------------------------------------- */
    
    public abstract boolean matchesAdjacency( AdjacencyEnum adjacency );

    private static String[] convertString( String value ) {

        return value.trim( ).split( "\\s+" );
    }
    private static boolean tooSmallString( String value ) {

        return( value == null ) || ( convertString( value ).length <= 1 );
    }
    protected static String normalizeStandard( String value ) {

        return tooSmallString( value ) ? "" : String.join( " ", convertString( value ) );
    }

    private static String[] reverseArray( String[] tokens ) {

        String[] reversedTokens = new String[ tokens.length ];
        for( int cursor = 0; cursor < tokens.length; cursor++ ) {
            reversedTokens[ tokens.length - 1 - cursor ] = tokens[ cursor ];
        }
        return reversedTokens;
    }
    protected static String normalizeReversed( String value ) {

        return tooSmallString( value ) ? "" : String.join( " ", reverseArray( convertString( value ) ) );
    }

    /** ------------------------------------------------------- */

    private int containingCursor(String location, String locations ) {

        return locations.indexOf( location );
    }
    private boolean containsTwice(String location, String locations, int cursor ) {

        return ( locations.length() > cursor )
                && ( containingCursor( location, locations.substring( cursor ) ) >= 0 );
    }
    private boolean containsNoSpace( String location ) {

        return containingCursor( " ", location ) < 0;
    }
    private boolean containsOnce( String location, String locations ) {

        return containingCursor( location, locations ) >= 0;
    }
    private boolean containsExactlyOnce( String location, String locations ) {

        return containsOnce( location, locations )
                && ! containsTwice( location, locations, containingCursor( location, locations ) + 3 );
    }
    public boolean contains( String location ) {

        return ( location != null )
                && ( location.length() > 1 )
                && containsNoSpace( location )
                && containsExactlyOnce( location, getLocations() );
    }

    public String[] split() {

        return getLocations().split( "\\s+", 0 );
    }

    private List<String> extract( List<String> locations, String location ) {

        return ( locations.contains( location ) ) ? locations.subList( locations.indexOf( location ), locations.size() ) : List.of() ;
    }

    public List<String> extract( String location ) {

        return extract( new ArrayList<>( Arrays.asList( split() ) ), location );
    }

    /** ---------  Inheritance from Object  ------------------- */

    @Override
    public String toString( ) {

        return( getDirection().toString() + " : " + getLocations() );
    }
}

