/*
 *  LineOfLocations.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2019 Jörg Dippel
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

package chess383.graph.coordinate;

import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.Collectors;

import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.direction.Direction;

/**
 * Provides locations on a line.
 *
 * @author    Jörg Dippel
 * @version   July 2019
 *
 */
public class LineOfLocations implements Serializable {
    
    // for interface Serializable
	private static final long serialVersionUID = 3544070056343946501L;
	
	/** ---------  Attributes  -------------------------------- */

    private AdjacencyEnum adjacency;
    private Direction direction;
    private String locations;

    /** ---------  Constructors  ------------------------------ */

    private LineOfLocations( AdjacencyEnum adjacency, Direction direction, String locations ) {

        setAdjacency( adjacency );
        setDirection( direction );
        setLocations( locations );
    }

    /** ---------  Getter and Setter  ------------------------- */

    // adjacency is another relic of the description of a game representation: a two-dimensional board.
    // names as locations are connected in the plane by edges or corners, or the are not connected.
    // adjacency is an attribute which describes that connection.
    // But if there is no longer a plane there will be only an attribute.

    private void setAdjacency( AdjacencyEnum value ) { this.adjacency = value; }
    public AdjacencyEnum getAdjacency( )             { return( this.adjacency ); }
    
    private void setDirection( Direction value )     { this.direction = value; }
    public Direction getDirection( )                 { return( this.direction ); }
    
    private void setLocations( String value )        { this.locations = value; }
    public String getLocations( )                    { return( this.locations ); }

    /** ---------  Factory  ----------------------------------- */
    
    public static LineOfLocations createLine( AdjacencyEnum adjacency, Direction direction, String locations ) {

        LineOfLocations result;

        result = new LineOfLocations( adjacency, direction, normalize( locations, direction.isDirected() ) );
        
        return result;
    }

    /** ------------------------------------------------------- */
    
    // only let pass strings with at least two tokens separated by white space
    // then pass the list of all remaining tokens each separated with a single space
    private static String normalize( String value, boolean directed ) {

        if( value == null ) {
            return( "" );
        }
        else {
            String[] tokens = value.trim( ).split( "\\s+" );
            if( tokens.length <= 1 ) {
                return( "" );
            }
            else {
                String directedString = Arrays.stream( tokens ).collect( Collectors.joining( " " ) );
                if ( directed == true ) {
                    return( directedString );
                }

                String reversedString = Arrays.stream( reverse( tokens ) ).collect( Collectors.joining( " " ) );
                String result = ( reversedString.compareTo( directedString ) < 0 ) ? reversedString : directedString;
                return( result );

            }
        }
    }

    private static String[] reverse( String[] tokens ) {

        String[] reversedTokens = new String[ tokens.length ];
        for( int cursor = 0; cursor < tokens.length; cursor++ ) {
            reversedTokens[ tokens.length - 1 - cursor ] = tokens[ cursor ];
        }

        return reversedTokens;
    }

    /** ------------------------------------------------------- */

    public boolean contains( String location ) {

        if( location == null || location.trim().length() == 0 ) {
            return( false );
        }
        else {
            String[] tokens = getLocations().trim( ).split( "\\s+" );

            String trimmedLocation = location.trim();
            boolean result = false;
            int cursor = 0;
            while( cursor < tokens.length ) {
                if( tokens[ cursor ].equalsIgnoreCase( trimmedLocation ) ) {
                    return( true );     // break
                }
                cursor++;
            }
            return( result );
        }
    }

    /** ---------  Inheritance from Object  ------------------- */

    @Override
    public String toString( ) {

        return( getAdjacency().toString() + " : " + getDirection().toString() + " : " + getLocations() );
    }

    @Override
    public boolean equals( Object value ) {

        boolean result;

        result = ( value instanceof LineOfLocations ) && 
        		 isMeaningfullyEquivalent( ( LineOfLocations ) value );
        
        return( result );
    }

    private boolean isMeaningfullyEquivalent( LineOfLocations value ) {

        boolean result;
        
        result = getAdjacency().equals( value.getAdjacency() ) 
        	  && getDirection().equals( value.getDirection() ) 
              && getLocations().equals( value.getLocations() );

        return( result );
    }

    @Override public int hashCode( ) { return( toString( ).hashCode( ) ); }
}

