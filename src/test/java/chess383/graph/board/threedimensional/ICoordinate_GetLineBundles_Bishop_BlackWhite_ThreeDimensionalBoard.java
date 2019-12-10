/*
 *  ICoordinate_GetLineBundles_Bishop_BlackWhite_ThreeDimensionalBoard.java
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

import chess383.ColorEnum;
import chess383.ICoordinate;
import chess383.ICoordinateFactory;
import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.board.ICoordinate_GetLineBundles_Wrapper;
import chess383.graph.direction.Direction;

/**
 * <p>
 * The class ICoordinate_GetLineBundles_Bishop_BlackWhite_ThreeDimensionalBoard implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method Set<List<String>> getLineBundles() for class ICoordinate_GetLineBundles_Bishop_BlackWhite_ThreeDimensionalBoard is tested")
public class ICoordinate_GetLineBundles_Bishop_BlackWhite_ThreeDimensionalBoard extends ICoordinate_GetLineBundles_Wrapper { 

    final static ICoordinate   BOARD =     ICoordinateFactory.THREE_DIMENSIONAL.get( );
    final static Direction     DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.BLACK, ColorEnum.WHITE );
    final static AdjacencyEnum ADJACENCY = AdjacencyEnum.BY_POINT;

    
    @ParameterizedTest( name = "given a standard board from location {0} there will be lines {1} to walk along" )
    @MethodSource("stringAndListProvider")
    public void testWithMultiArgMethodSource( String origin, List<String> expectedResultList ) {
        assertTrue( testOfArguments( BOARD, origin, DIRECTION, ADJACENCY, expectedResultList ) );
    }

    public static Stream<Arguments> stringAndListProvider() {
        return Stream.of(
            
            Arguments.of( "z0", EMPTY_STRING_LIST ),
            Arguments.of( "z1", Arrays.asList( "z1 a0" ) ),
            Arguments.of( "z2", Arrays.asList( "z2 a1" ) ),
            Arguments.of( "z3", Arrays.asList( "z3 a2 b1" ) ),
            Arguments.of( "z4", Arrays.asList( "z4 a3 b2 c1 d0" ) ),
            Arguments.of( "z5", Arrays.asList( "z5 a4 b3 c2 d1 e0" ) ),
            Arguments.of( "z6", Arrays.asList( "z6 a5 b4 c3 d2 e1" ) ),
            Arguments.of( "z7", Arrays.asList( "z7 a6 b5 c4 d3 e2" ) ),
            Arguments.of( "z8", Arrays.asList( "z8 a7 b6 c5 d4 e3" ) ),
            Arguments.of( "z9", Arrays.asList( "z9 a8 b7 c6 d5 e4" ) ),
            Arguments.of( "a0", EMPTY_STRING_LIST ),        
            Arguments.of( "a1", Arrays.asList( "a1 z0" ) ),
            Arguments.of( "a2", Arrays.asList( "a2 z1", "a2 b1" ) ),
            Arguments.of( "a3", Arrays.asList( "a3 z2", "a3 b2 c1 d0" ) ),
            Arguments.of( "a4", Arrays.asList( "a4 z3", "a4 b3 c2 d1 e0" ) ),
            Arguments.of( "a5", Arrays.asList( "a5 z4", "a5 b4 c3 d2 e1" ) ),
            Arguments.of( "a6", Arrays.asList( "a6 b5 c4 d3 e2", "a6 z5" ) ),
            Arguments.of( "a7", Arrays.asList( "a7 z6", "a7 b6 c5 d4 e3" ) ),
            Arguments.of( "a8", Arrays.asList( "a8 z7", "a8 b7 c6 d5 e4" ) ),
            Arguments.of( "a9", Arrays.asList( "a9 z8", "a9 b8 c7 d6 e5" ) ),
            Arguments.of( "b1", Arrays.asList( "b1 a0" ) ),
            Arguments.of( "b2", Arrays.asList( "b2 c1 d0", "b2 a1 z0" ) ),
            Arguments.of( "b3", Arrays.asList( "b3 c2 d1 e0", "b3 a2 z1" ) ),
            Arguments.of( "b4", Arrays.asList( "b4 c3 d2 e1", "b4 a3 z2" ) ),
            Arguments.of( "b5", Arrays.asList( "b5 c4 d3 e2", "b5 a4 z3" ) ),
            Arguments.of( "b6", Arrays.asList( "b6 a5 z4", "b6 c5 d4 e3" ) ),
            Arguments.of( "b7", Arrays.asList( "b7 a6 z5", "b7 c6 d5 e4" ) ),
            Arguments.of( "b8", Arrays.asList( "b8 a7 z6", "b8 c7 d6 e5" ) ),
            Arguments.of( "c1", Arrays.asList( "c1 d0" ) ),
            Arguments.of( "c2", Arrays.asList( "c2 b1 a0", "c2 d1 e0" ) ),
            Arguments.of( "c3", Arrays.asList( "c3 b2 a1 z0", "c3 d2 e1" ) ),
            Arguments.of( "c4", Arrays.asList( "c4 b3 a2 z1", "c4 d3 e2" ) ),
            Arguments.of( "c5", Arrays.asList( "c5 d4 e3", "c5 b4 a3 z2" ) ),
            Arguments.of( "c6", Arrays.asList( "c6 b5 a4 z3", "c6 d5 e4" ) ),
            Arguments.of( "c7", Arrays.asList( "c7 b6 a5 z4", "c7 d6 e5" ) ),
            Arguments.of( "c8", Arrays.asList( "c8 d7 e6", "c8 b7 a6 z5" ) ),
            Arguments.of( "d0", EMPTY_STRING_LIST ),
            Arguments.of( "d1", Arrays.asList( "d1 e0" ) ),
            Arguments.of( "d2", Arrays.asList( "d2 c1", "d2 e1" ) ),
            Arguments.of( "d3", Arrays.asList( "d3 c2 b1 a0", "d3 e2" ) ),
            Arguments.of( "d4", Arrays.asList( "d4 c3 b2 a1 z0", "d4 e3" ) ),
            Arguments.of( "d5", Arrays.asList( "d5 c4 b3 a2 z1", "d5 e4" ) ),
            Arguments.of( "d6", Arrays.asList( "d6 c5 b4 a3 z2", "d6 e5" ) ),
            Arguments.of( "d7", Arrays.asList( "d7 c6 b5 a4 z3", "d7 e6" ) ),
            Arguments.of( "d8", Arrays.asList( "d8 c7 b6 a5 z4", "d8 e7" ) ),
            Arguments.of( "d9", Arrays.asList( "d9 c8 b7 a6 z5", "d9 e8" ) ),
            Arguments.of( "e0", EMPTY_STRING_LIST ),
            Arguments.of( "e1", Arrays.asList( "e1 d0" ) ),
            Arguments.of( "e2", Arrays.asList( "e2 d1" ) ),
            Arguments.of( "e3", Arrays.asList( "e3 d2 c1" ) ),
            Arguments.of( "e4", Arrays.asList( "e4 d3 c2 b1 a0" ) ),
            Arguments.of( "e5", Arrays.asList( "e5 d4 c3 b2 a1 z0" ) ),
            Arguments.of( "e6", Arrays.asList( "e6 d5 c4 b3 a2 z1" ) ),
            Arguments.of( "e7", Arrays.asList( "e7 d6 c5 b4 a3 z2" ) ),
            Arguments.of( "e8", Arrays.asList( "e8 d7 c6 b5 a4 z3" ) ),
            Arguments.of( "e9", Arrays.asList( "e9 d8 c7 b6 a5 z4" ) )
        
        ); }
}

