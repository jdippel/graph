/*
 *  LineBundle.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2015-2022 Jörg Dippel
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

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import chess383.ICoordinate;
import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.direction.Direction;
import chess383.graph.line.LineOfLocations;

/**
 * Provides locations on a bundle of lines.
 * A line is an ordered list of locations (names).
 * A bundle of lines through a given location is a set of lines which contain the location each.
 *
 * @author    Jörg Dippel
 * @version   January 2022
 *
 */
public abstract class LineBundle implements ICoordinate {

    /** ---------  Getter and Setter  ------------------------- */

    abstract List<LineOfLocations> getBundle( );

    /** ------------------------------------------------------- */

    private final Predicate<List<String>>                     lineContainsAtLeastTwoLocations = line -> line.size() > 1;
//  private final BiPredicate<LineOfLocations, String>        lineContainsSourceLocation = LineOfLocations::contains;
    private final BiPredicate<LineOfLocations, AdjacencyEnum> lineMatchesAdjacency = LineOfLocations::matchesAdjacency;
    private final BiPredicate<LineOfLocations, Direction>     lineMatchesDirection = ( line, orientation ) -> orientation == null || orientation.equals( line.getDirection() );

    public Set<List<String>> getLineBundles( String location ) {
    
        return getBundle( ).stream()
//                         .filter( line -> lineContainsSourceLocation.test( line, location ) )
                           .map( line -> line.extract( location ) )
                           .filter( lineContainsAtLeastTwoLocations )
                           .collect( Collectors.toSet() );
    }

    public Set<List<String>> getLineBundles( String location, Direction orientation ) {

        if( orientation == null ) return( getLineBundles( location ) );

        return getBundle().stream()
//                        .filter( line -> lineContainsSourceLocation.test( line, location ) )
                          .filter( line -> lineMatchesDirection.test( line, orientation ) )
                          .map( line -> line.extract( location ) )
                          .filter( lineContainsAtLeastTwoLocations )
                          .collect( Collectors.toSet() );
    }
   
    public Set<List<String>> getLineBundles( String location, Direction orientation, AdjacencyEnum adjacency ) {

        if( adjacency == null ) return( getLineBundles( location, orientation ) );

        return getBundle().stream()
//                       .filter( line -> lineContainsSourceLocation.test( line, location ) )
                         .filter( line -> lineMatchesDirection.test( line, orientation ) )
                         .filter( line -> lineMatchesAdjacency.test( line, adjacency ) )
                         .map( line -> line.extract( location ) )
                         .filter( lineContainsAtLeastTwoLocations )
                         .collect( Collectors.toSet() );
    }

    public Set<String> getAllLocations() {

        return getBundle().stream()
                          .flatMap( line -> Stream.of( line.split( ) ) )
                          .collect( Collectors.toSet() );
    }
}

