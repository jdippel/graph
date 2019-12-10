/*
 *  ICoordinate_GetLineBundles_Knight_ThreeDimensionalBoard.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2017 - 2019 Jörg Dippel
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

package chess383.graph.board.threedimensional;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import chess383.ICoordinate;
import chess383.ICoordinateFactory;
import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.board.ICoordinate_GetLineBundles_Wrapper;
import chess383.graph.direction.Direction;

/**
 * <p>
 * The class ICoordinate_GetLineBundles_Knight_ThreeDimensionalBoard implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method Set<List<String>> getLineBundles() for class ICoordinate_GetLineBundles_Knight_ThreeDimensionalBoard is tested")
public class ICoordinate_GetLineBundles_Knight_ThreeDimensionalBoard extends ICoordinate_GetLineBundles_Wrapper { 

    final static ICoordinate   BOARD =     ICoordinateFactory.THREE_DIMENSIONAL.get( );
    final static Direction     DIRECTION = Direction.createBidirectionalDirection( );
    final static AdjacencyEnum ADJACENCY = AdjacencyEnum.UNSPECIFIED;

    
    @ParameterizedTest( name = "given a standard board from location {0} there will be lines {1} to walk along" )
    @MethodSource("stringAndListProvider")
    public void testWithMultiArgMethodSource( String origin, List<String> expectedResultList ) {
        assertTrue( testOfArguments( BOARD, origin, DIRECTION, ADJACENCY, expectedResultList ) );
    }

    public static Stream<Arguments> stringAndListProvider() {
        return Stream.of(
            
            Arguments.of( "z0", Arrays.asList( "z0 a2 b4 c6 d8", "z0 b1 d2" ) ),
            Arguments.of( "z1", Arrays.asList( "z1 a3 b5 c7 d9", "z1 b2 d3" ) ),
            Arguments.of( "z2", Arrays.asList( "z2 a4 b6 c8", "z2 a0", "z2 b3 d4", "z2 b1 d0" ) ),
            Arguments.of( "z3", Arrays.asList( "z3 a5 b7", "z3 a1", "z3 b4 d5", "z3 b2 d1" ) ),
            Arguments.of( "z4", Arrays.asList( "z4 a6 b8", "z4 b5 d6", "z4 a2", "z4 b3 d2" ) ),
            Arguments.of( "z5", Arrays.asList( "z5 b6 d7", "z5 a3 b1", "z5 b4 d3", "z5 a7" ) ),
            Arguments.of( "z6", Arrays.asList( "z6 b7 d8", "z6 a4 b2", "z6 b5 d4", "z6 a8" ) ),
            Arguments.of( "z7", Arrays.asList( "z7 b8 d9", "z7 b6 d5", "z7 a5 b3 c1", "z7 a9" ) ),
            Arguments.of( "z8", Arrays.asList( "z8 a6 b4 c2 d0", "z8 b7 d6" ) ),
            Arguments.of( "z9", Arrays.asList( "z9 b8 d7", "z9 a7 b5 c3 d1" ) ),
            Arguments.of( "a0", Arrays.asList( "a0 c1 e2", "a0 z2", "a0 b2 c4 d6 e8" ) ),        
            Arguments.of( "a1", Arrays.asList( "a1 c2 e3", "a1 z3", "a1 b3 c5 d7 e9" ) ),
            Arguments.of( "a2", Arrays.asList( "a2 c3 e4", "a2 c1 e0", "a2 z0", "a2 b4 c6 d8", "a2 z4" ) ),
            Arguments.of( "a3", Arrays.asList( "a3 c2 e1", "a3 z1", "a3 b5 c7 d9", "a3 z5", "a3 c4 e5", "a3 b1" ) ),
            Arguments.of( "a4", Arrays.asList( "a4 c3 e2", "a4 z2", "a4 z6", "a4 b6 c8", "a4 b2", "a4 c5 e6" ) ),
            Arguments.of( "a5", Arrays.asList( "a5 b7", "a5 z3", "a5 z7", "a5 c6 e7", "a5 b3 c1", "a5 c4 e3" ) ),
            Arguments.of( "a6", Arrays.asList( "a6 b8", "a6 b4 c2 d0", "a6 z4", "a6 z8", "a6 c7 e8", "a6 c5 e4" ) ),
            Arguments.of( "a7", Arrays.asList( "a7 b5 c3 d1", "a7 z5", "a7 c8 e9", "a7 z9", "a7 c6 e5" ) ),
            Arguments.of( "a8", Arrays.asList( "a8 b6 c4 d2 e0", "a8 z6", "a8 c7 e6" ) ),
            Arguments.of( "a9", Arrays.asList( "a9 z7", "a9 b7 c5 d3 e1", "a9 c8 e7" ) ),
            Arguments.of( "b1", Arrays.asList( "b1 d2", "b1 a3 z5", "b1 z0", "b1 z2", "b1 c3 d5 e7", "b1 d0" ) ),
            Arguments.of( "b2", Arrays.asList( "b2 a0", "b2 d3", "b2 a4 z6", "b2 z1", "b2 c4 d6 e8", "b2 z3", "b2 d1" ) ),
            Arguments.of( "b3", Arrays.asList( "b3 a1", "b3 d4", "b3 a5 z7", "b3 z2", "b3 c5 d7 e9", "b3 z4", "b3 c1", "b3 d2" ) ),
            Arguments.of( "b4", Arrays.asList( "b4 c2 d0", "b4 d5", "b4 a6 z8", "b4 a2 z0", "b4 z3", "b4 z5", "b4 c6 d8", "b4 d3" ) ),
            Arguments.of( "b5", Arrays.asList( "b5 c3 d1", "b5 d6", "b5 a7 z9", "b5 a3 z1", "b5 z4", "b5 z6", "b5 c7 d9", "b5 d4" ) ),
            Arguments.of( "b6", Arrays.asList( "b6 c4 d2 e0", "b6 d7", "b6 c8", "b6 a8", "b6 a4 z2", "b6 z5", "b6 z7", "b6 d5" ) ),
            Arguments.of( "b7", Arrays.asList( "b7 c5 d3 e1", "b7 d8", "b7 a9", "b7 a5 z3", "b7 z6", "b7 z8", "b7 d6" ) ),
            Arguments.of( "b8", Arrays.asList( "b8 c6 d4 e2", "b8 d9", "b8 a6 z4", "b8 z7", "b8 z9", "b8 d7" ) ),
            Arguments.of( "c1", Arrays.asList( "c1 e2", "c1 d3 e5", "c1 a0", "c1 a2", "c1 b3 a5 z7", "c1 e0" ) ),
            Arguments.of( "c2", Arrays.asList( "c2 d4 e6", "c2 e3", "c2 a1", "c2 a3", "c2 b4 a6 z8", "c2 d0", "c2 e1" ) ),
            Arguments.of( "c3", Arrays.asList( "c3 b1", "c3 e4", "c3 a2", "c3 a4", "c3 b5 a7 z9", "c3 d5 e7", "c3 d1", "c3 e2" ) ),
            Arguments.of( "c4", Arrays.asList( "c4 b2 a0", "c4 e5", "c4 d2 e0", "c4 a3", "c4 a5", "c4 b6 a8", "c4 d6 e8", "c4 e3" ) ),
            Arguments.of( "c5", Arrays.asList( "c5 d3 e1", "c5 e6", "c5 a4", "c5 a6", "c5 b7 a9", "c5 d7 e9", "c5 b3 a1", "c5 e4" ) ),
            Arguments.of( "c6", Arrays.asList( "c6 d4 e2", "c6 e7", "c6 d8", "c6 a5", "c6 b8", "c6 a7", "c6 b4 a2 z0", "c6 e5" ) ),
            Arguments.of( "c7", Arrays.asList( "c7 e8", "c7 d9", "c7 a6", "c7 a8", "c7 b5 a3 z1", "c7 d5 e3", "c7 e6" ) ),
            Arguments.of( "c8", Arrays.asList( "c8 e9", "c8 a7", "c8 a9", "c8 b6 a4 z2", "c8 d6 e4", "c8 e7" ) ),
            Arguments.of( "d0", Arrays.asList( "d0 c2 b4 a6 z8", "d0 b1 z2", "d0 e2" ) ),
            Arguments.of( "d1", Arrays.asList( "d1 c3 b5 a7 z9", "d1 b2 z3", "d1 e3" ) ),
            Arguments.of( "d2", Arrays.asList( "d2 c4 b6 a8", "d2 e4", "d2 b1 z0", "d2 b3 z4", "d2 e0" ) ),
            Arguments.of( "d3", Arrays.asList( "d3 c1", "d3 c5 b7 a9", "d3 e5", "d3 b2 z1", "d3 b4 z5", "d3 e1" ) ),
            Arguments.of( "d4", Arrays.asList( "d4 c2", "d4 c6 b8", "d4 e6", "d4 b3 z2", "d4 b5 z6", "d4 e2" ) ),
            Arguments.of( "d5", Arrays.asList( "d5 e7", "d5 c7", "d5 b4 z3", "d5 b6 z7", "d5 c3 b1", "d5 e3" ) ),
            Arguments.of( "d6", Arrays.asList( "d6 e8", "d6 c8", "d6 c4 b2 a0", "d6 b5 z4", "d6 b7 z8", "d6 e4" ) ),
            Arguments.of( "d7", Arrays.asList( "d7 e9", "d7 c5 b3 a1", "d7 b6 z5", "d7 b8 z9", "d7 e5" ) ),
            Arguments.of( "d8", Arrays.asList( "d8 b7 z6", "d8 e6", "d8 c6 b4 a2 z0" ) ),
            Arguments.of( "d9", Arrays.asList( "d9 c7 b5 a3 z1", "d9 e7", "d9 b8 z7" ) ),
            Arguments.of( "e0", Arrays.asList( "e0 d2 c4 b6 a8", "e0 c1 a2" ) ),
            Arguments.of( "e1", Arrays.asList( "e1 d3 c5 b7 a9", "e1 c2 a3" ) ),
            Arguments.of( "e2", Arrays.asList( "e2 d0", "e2 d4 c6 b8", "e2 c1 a0", "e2 c3 a4" ) ),
            Arguments.of( "e3", Arrays.asList( "e3 d5 c7", "e3 c4 a5", "e3 d1", "e3 c2 a1" ) ),
            Arguments.of( "e4", Arrays.asList( "e4 d2", "e4 c5 a6", "e4 d6 c8", "e4 c3 a2" ) ),
            Arguments.of( "e5", Arrays.asList( "e5 c4 a3", "e5 c6 a7", "e5 d7", "e5 d3 c1" ) ),
            Arguments.of( "e6", Arrays.asList( "e6 c5 a4", "e6 c7 a8", "e6 d8", "e6 d4 c2" ) ),
            Arguments.of( "e7", Arrays.asList( "e7 c6 a5", "e7 c8 a9", "e7 d9", "e7 d5 c3 b1" ) ),
            Arguments.of( "e8", Arrays.asList( "e8 c7 a6", "e8 d6 c4 b2 a0" ) ),
            Arguments.of( "e9", Arrays.asList( "e9 c8 a7", "e9 d7 c5 b3 a1" ) )
        
        ); }
}

