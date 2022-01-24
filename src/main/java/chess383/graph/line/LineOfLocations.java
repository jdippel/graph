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
import java.util.List;

import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.direction.Direction;

/**
 * Provides locations on a line.
 *
 * @author    Jörg Dippel
 * @version   January 2022
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

    protected static String normalizeStandard( String value ) {

        if( value == null ) {
            return( "" );
        }
        else {
            String[] tokens = value.trim( ).split( "\\s+" );
            if( tokens.length <= 1 ) {
                return( "" );
            }
            else {
                return String.join( " ", tokens );
            }
        }
    }

    protected static String normalizeReversed( String value ) {

        if( value == null ) {
            return( "" );
        }
        else {
            String[] tokens = value.trim( ).split( "\\s+" );
            if( tokens.length <= 1 ) {
                return( "" );
            }
            else {
                String[] reversedTokens = new String[ tokens.length ];
                for( int cursor = 0; cursor < tokens.length; cursor++ ) {
                    reversedTokens[ tokens.length - 1 - cursor ] = tokens[ cursor ];
                }
                return String.join( " ", reversedTokens );
            }
        }
    }

    /** ------------------------------------------------------- */

    public boolean contains( String location ) {

        if( location == null || location.trim().length() == 0 ) {
            return( false );
        }
        else {
            String[] tokens = getLocations().trim( ).split( "\\s+" );

            String trimmedLocation = location.trim();
            int cursor = 0;
            while( cursor < tokens.length ) {
                if( tokens[ cursor ].equalsIgnoreCase( trimmedLocation ) ) {
                    return( true );     // break
                }
                cursor++;
            }
            return( false );
        }
    }

    public String[] split() {

        return getLocations().split( "\\s+", 0 );
    }

    public List<String> extract( String location ) {

        List<String> result = new ArrayList<>();

        String[] tokens = split();
        int cursor = 0;
        while( cursor < tokens.length ) {

            if( location.compareTo( tokens[ cursor ] ) == 0 ) break;
            cursor++;
        }

        while( cursor < tokens.length ) {
            result.add( tokens[ cursor ] );
            cursor++;
        }

        return( result );
    }

    /** ---------  Inheritance from Object  ------------------- */

    @Override
    public String toString( ) {

        return( getDirection().toString() + " : " + getLocations() );
    }
}

