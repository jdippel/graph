/*
 *  LineBundle.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2015-2021 Jörg Dippel
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

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import chess383.ColorEnum;
import chess383.ICoordinate;
import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.direction.Direction;
import chess383.graph.line.DirectedDiagonalLine;
import chess383.graph.line.DirectedFilesLine;
import chess383.graph.line.KnightsLine;
import chess383.graph.line.LineOfLocations;
import chess383.graph.line.UndirectedRowsLine;

/**
 * Provides locations on a bundle of lines.
 * A line is an ordered list of locations (names).
 * A bundle of lines through a given location is a set of lines which contain the location each.
 *
 * @author    Jörg Dippel
 * @version   March 2021
 *
 */
public abstract class LineBundle implements ICoordinate {

    /** ---------  Getter and Setter  ------------------------- */

    abstract List<LineOfLocations> getBundle( );
    
    /** ------------------------------------------------------- */
    
    static LineOfLocations createRankLine( String locations ) {
        
        return( UndirectedRowsLine.createLine( locations ) );
    }
    
    static LineOfLocations createFileLine( String locations, Direction direction ) {
        
        return( DirectedFilesLine.createLine( direction, locations ) );
    }
    
    static LineOfLocations createFileLine( String locations ) {
        
        final Direction direction = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        return( createFileLine( locations, direction ) );
    }
    
    static LineOfLocations createDiagonalLine( String locations, Direction direction ) {
        
        return( DirectedDiagonalLine.createLine( direction, locations ) );
    }
    
    static LineOfLocations createDiagonalLine( String locations ) {
        
        final Direction direction = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        return( createDiagonalLine( locations, direction ) );
    }

    static LineOfLocations createKnightLine( String value ) {
    
        return( KnightsLine.createLine( value ) );
    }
    
    /** ------------------------------------------------------- */
    
    public Set<List<String>> getLineBundles( String location ) {
    
        return getBundle( ).stream()
                           .filter( line -> line.contains( location ) )
                           .map( line -> Arrays.asList( line.getLocations().split( "//s+", 0 ) ) )
                           .collect( Collectors.toSet() );
    }
        
    private Predicate<List<String>> lineContainsTargetLocations = line -> line.size() > 1;
    private BiPredicate<LineOfLocations, String> lineContainsSourceLocation = ( line, location ) -> line.contains( location );
    private BiPredicate<LineOfLocations, AdjacencyEnum> lineMatchesAdjacency = ( line, adjacency ) -> line.matchesAdjacency( adjacency );
    private BiPredicate<LineOfLocations, Direction> lineIsUndirected = ( line, orientation ) -> orientation == null || ( !orientation.isDirected() && !line.getDirection().isDirected() );
    private BiPredicate<LineOfLocations, Direction> lineIsDirectedInGivenDirection = ( line, orientation ) -> orientation != null && orientation.isDirected() && line.getDirection( ).equals( orientation );
    private BiPredicate<LineOfLocations, Direction> lineIsDirectedInReverseDirection = ( line, orientation ) -> orientation != null && orientation.isDirected() && line.getDirection( ).equals( Direction.createReversedDirection( orientation ) );
    
    public Set<List<String>> getLineBundles( String location, Direction orientation ) {

        if( orientation == null ) return( getLineBundles( location ) );
        
        return Stream.of(
               getBundle().stream().filter( line -> lineContainsSourceLocation.test( line , location ) && lineIsUndirected.test( line, orientation ) )
                                   .map( line -> LineBundleMigration.extractListForGivenDirection( line.getLocations( ), location ) )
                                   .filter( lineContainsTargetLocations ),
               getBundle().stream().filter( line -> lineContainsSourceLocation.test( line , location ) && lineIsUndirected.test( line, orientation ) )
                                   .map( line -> LineBundleMigration.extractListForReversedDirection( line.getLocations( ), location ) )
                                   .filter( lineContainsTargetLocations ),
               getBundle().stream().filter( line -> lineContainsSourceLocation.test( line , location ) && lineIsDirectedInGivenDirection.test( line, orientation ) )
                                   .map( line -> LineBundleMigration.extractListForGivenDirection( line.getLocations( ), location ) )
                                   .filter( lineContainsTargetLocations ),
               getBundle().stream().filter( line -> lineContainsSourceLocation.test( line , location ) && lineIsDirectedInReverseDirection.test( line, orientation ) )
                                   .map( line -> LineBundleMigration.extractListForReversedDirection( line.getLocations( ), location ) )
                                   .filter( lineContainsTargetLocations ) )
                     .flatMap( id -> id )
                     .collect( Collectors.toSet() );
    }
   
    public Set<List<String>> getLineBundles( String location, Direction orientation, AdjacencyEnum adjacency ) {

        if( adjacency == null ) return( getLineBundles( location, orientation ) );

        return Stream.of(
                getBundle().stream().filter( line -> lineContainsSourceLocation.test( line , location ) && lineMatchesAdjacency.test( line, adjacency ) && lineIsUndirected.test( line, orientation ) )
                                    .map( line -> LineBundleMigration.extractListForGivenDirection( line.getLocations( ), location ) )
                                    .filter( lineContainsTargetLocations ),
                getBundle().stream().filter( line -> lineContainsSourceLocation.test( line , location ) && lineMatchesAdjacency.test( line, adjacency ) && lineIsUndirected.test( line, orientation ) )
                                    .map( line -> LineBundleMigration.extractListForReversedDirection( line.getLocations( ), location ) )
                                    .filter( lineContainsTargetLocations ),
                getBundle().stream().filter( line -> lineContainsSourceLocation.test( line , location ) && lineMatchesAdjacency.test( line, adjacency ) && lineIsDirectedInGivenDirection.test( line, orientation ) )
                                    .map( line -> LineBundleMigration.extractListForGivenDirection( line.getLocations( ), location ) )
                                    .filter( lineContainsTargetLocations ),
                getBundle().stream().filter( line -> lineContainsSourceLocation.test( line , location ) && lineMatchesAdjacency.test( line, adjacency ) && lineIsDirectedInReverseDirection.test( line, orientation ) )
                                    .map( line -> LineBundleMigration.extractListForReversedDirection( line.getLocations( ), location ) )
                                    .filter( lineContainsTargetLocations ) )
                      .flatMap( id -> id )
                      .collect( Collectors.toSet() );
    }

    public Set<String> getAllLocations() {

        Set<String> resultSet = new HashSet<String>();
        
        Collections.addAll( resultSet, getBundle().stream().map( line -> line.getLocations() ).collect( Collectors.joining( " " )).split( "\\s+", 0 ) );
        
        return( resultSet );
    }
}

