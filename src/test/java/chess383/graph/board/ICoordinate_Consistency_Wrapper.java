/*
 *  ICoordinate_Consistency_Wrapper.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2017 - 2021 Jörg Dippel
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

package chess383.graph.board;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import chess383.ColorEnum;
import chess383.ICoordinate;
import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.direction.Direction;


/**
 * <p>
 * The class ICoordinate_Consistency_Wrapper implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   January 2021
 *
 */
public class ICoordinate_Consistency_Wrapper { 

    final Direction STANDARD_DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
    final Direction REVERSED_DIRECTION = Direction.createReversedDirection( STANDARD_DIRECTION );
    final Direction UNSPECIFIED_DIRECTION = Direction.createBidirectionalDirection( );
    
    final int AREA_SIZE = 2;

    private void includeSetOfLocations( String expected, Set<String> locations ) {
        
        String[] tokens = expected.split( "\\s+" );
        assertThat( tokens.length <= locations.size( ) ).as( "sets must be of size to hold all the locations" ).isTrue();
        for( String location : tokens ) {
            assertThat( locations.contains( location ) ).as( String.format( "Locations %s must be within the set", location ) ).isTrue();
        }
    }
    
    private void compareSetOfLocations( String expected, Set<String> locations ) {
        
        String[] tokens = expected.split( "\\s+" );
        assertThat( tokens.length ).as( "sets must be of same size" ).isEqualTo( locations.size() );
        for( String location : tokens ) {
            assertThat( locations.contains( location ) ).as( String.format( "Locations %s must be within the set", location ) ).isTrue();
        }
    }
    
    private Set<String> getDirectlyConnectedLocations( ICoordinate board, String origin ) {

        final int DIRECTLY_CONNECTED_DISTANCE = 1;
        Set<String> result = new TreeSet<String>( );
        
        result = join( result, getByPointConnectedLocationsOfGivenDistance( board, origin, DIRECTLY_CONNECTED_DISTANCE  ) );
        result = join( result, getByEdgeConnectedLocationsOfGivenDistance( board, origin, DIRECTLY_CONNECTED_DISTANCE  ) );
        
        return( result );
    }
    
    private Set<String> getConnectedLocationsOfArea( ICoordinate board, String origin ) {
        
        Set<String> result = new TreeSet<String>( );
        Set<String> directlyConnectedLocations =  getDirectlyConnectedLocations( board, origin );
        
        for( String location : directlyConnectedLocations ) {
            result = join( result, getDirectlyConnectedLocations( board, location ) );
        }
        
        result.remove( origin );
        return( result );
    }
    
    private Set<String> join( Set<String> set, Set<String> add ) {
    
        Set<String> result = set;
        
        for( String element : add ) {
            result .add( element );
        }
        return( result );
    }
    
    private Set<String> getReachableLocations( Set<List<String>> bundle, int distance ) {
        
        Set<String> result = new TreeSet<String>( );
        
        for( List<String> list : bundle ) {
            int cursor = 1;
            while( ( cursor <= distance ) && ( cursor < list.size( ) ) ) {
                result.add( list.get( cursor ) );
                cursor++;
            }
        }
        
        return( result );
    }
    
    private Set<String> getByEdgeConnectedLocationsOfGivenDistance( ICoordinate board, String origin, int distance ) {
        
        Set<List<String>> bundle;
        Set<String> result = new TreeSet<String>( );
        
        bundle = board.getLineBundles( origin, null, AdjacencyEnum.BY_EDGE );
        result = join( result, getReachableLocations( bundle, distance ) );
        
        return( result );
    }
    
    private Set<String> getByEdgeConnectedLocationsOfArea( ICoordinate board, String origin ) {

        Set<String> result;
        
        result = getByEdgeConnectedLocationsOfGivenDistance( board, origin, AREA_SIZE );
        
        return( result );
    }
    
    private Set<String> getByPointConnectedLocationsOfGivenDistance( ICoordinate board, String origin, int distance ) {
        
        final AdjacencyEnum ADJACENCY = AdjacencyEnum.BY_POINT;
        
        Set<List<String>> bundle;
        Set<String> result = new TreeSet<String>( );
        
        bundle = board.getLineBundles( origin, null, ADJACENCY );
        result = join( result, getReachableLocations( bundle, distance ) );
        
        return( result );
    }
    
    private Set<String> getByPointConnectedLocationsOfArea( ICoordinate board, String origin ) {
        
        Set<String> result;
        
        result = getByPointConnectedLocationsOfGivenDistance( board, origin, AREA_SIZE );
        
        return( result );
    }
    
    private Set<String> getOtherConnectedLocationsOfArea( ICoordinate board, Set<String> all, Set<String> rooks, Set<String> bishops ) {
        
        Set<String> result = new TreeSet<String>( );
        
        for( String location : all ) {
            result.add( location );
        }
        for( String location : rooks ) {
            result.remove( location );
        }
        for( String location : bishops ) {
            result.remove( location );
        }
        return( result );
    }

    private boolean isSubset( Set<String> set , Set<String> subset ) {
        
        for( String element : subset ) {
            if( ! set.contains( element ) ) {
                return( false );
            }
        }
        return( true );
    }
    
    private boolean isDisjunctive( Set<String> setOne , Set<String> setTwo ) {
        
        for( String element : setOne ) {
            if( setTwo.contains( element ) ) {
                return( false );
            }
        }
        for( String element : setTwo ) {
            if( setOne.contains( element ) ) {
                return( false );
            }
        }
        return( true );
    }
    
    public void givenALocation_verifyTheLocationsForVariousTransformations ( ICoordinate board, String location, String expectedRooks, String expectedBishops, String expectedKnights ) {
        
        Set<String> rooks = getByEdgeConnectedLocationsOfArea( board, location );
        Set<String> bishops = getByPointConnectedLocationsOfArea( board, location );
        Set<String> all = getConnectedLocationsOfArea( board, location );
        Set<String> knights = getOtherConnectedLocationsOfArea( board, all, rooks, bishops );
    
        assertThat( isSubset( all, rooks ) ).as( String.format( "connected by edge relation for '%s' does not match. All: %s,  Edged: %s", location, all.toString(), rooks.toString() ) ).isTrue();
        assertThat( isSubset( all, bishops ) ).as( String.format( "connected by point relation for '%s' does not match. All: %s,  Pointed: %s", location, all.toString(), bishops.toString() ) ).isTrue();
        
        compareSetOfLocations( expectedRooks, rooks );
        compareSetOfLocations( expectedBishops, bishops );
        includeSetOfLocations( expectedKnights, knights );
        
        assertThat( isDisjunctive( rooks, bishops ) ).as( "edged and pointed are not disjunctive sets" ).isTrue();
        assertThat( isDisjunctive( rooks, knights ) ).as( "edged and knights are not disjunctive sets" ).isTrue();
        assertThat( isDisjunctive( bishops, knights ) ).as( "pointed and knights are not disjunctive sets" ).isTrue();     
    }
}
