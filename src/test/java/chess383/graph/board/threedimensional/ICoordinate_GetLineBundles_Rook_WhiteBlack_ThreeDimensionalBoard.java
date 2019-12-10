/*
 *  ICoordinate_GetLineBundles_Rook_WhiteBlack_ThreeDimensionalBoard.java
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
 * The class ICoordinate_GetLineBundles_Rook_WhiteBlack_ThreeDimensionalBoard implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method Set<List<String>> getLineBundles() for class ICoordinate_GetLineBundles_Rook_WhiteBlack_ThreeDimensionalBoard is tested")
public class ICoordinate_GetLineBundles_Rook_WhiteBlack_ThreeDimensionalBoard extends ICoordinate_GetLineBundles_Wrapper { 

    final static ICoordinate   BOARD =     ICoordinateFactory.THREE_DIMENSIONAL.get( );
    final static Direction     DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
    final static AdjacencyEnum ADJACENCY = AdjacencyEnum.BY_EDGE;

    
    @ParameterizedTest( name = "given a standard board from location {0} there will be lines {1} to walk along" )
    @MethodSource("stringAndListProvider")
    public void testWithMultiArgMethodSource( String origin, List<String> expectedResultList ) {
        assertTrue( testOfArguments( BOARD, origin, DIRECTION, ADJACENCY, expectedResultList ) );
    }

    public static Stream<Arguments> stringAndListProvider() {
        return Stream.of(
            
            Arguments.of( "z0", Arrays.asList( "z0 z1 z2 z3 z4 z5 z6 z7 z8 z9" ) ),
            Arguments.of( "z1", Arrays.asList( "z1 z2 z3 z4 z5 z6 z7 z8 z9" ) ),
            Arguments.of( "z2", Arrays.asList( "z2 z3 z4 z5 z6 z7 z8 z9" ) ),
            Arguments.of( "z3", Arrays.asList( "z3 z4 z5 z6 z7 z8 z9" ) ),
            Arguments.of( "z4", Arrays.asList( "z4 z5 z6 z7 z8 z9" ) ),
            Arguments.of( "z5", Arrays.asList( "z5 z6 z7 z8 z9" ) ),
            Arguments.of( "z6", Arrays.asList( "z6 z7 z8 z9" ) ),
            Arguments.of( "z7", Arrays.asList( "z7 z8 z9" ) ),
            Arguments.of( "z8", Arrays.asList( "z8 z9" ) ),
            Arguments.of( "z9", EMPTY_STRING_LIST ),
            Arguments.of( "a0", Arrays.asList( "a0 a1 a2 a3 a4 a5 a6 a7 a8 a9" ) ),        
            Arguments.of( "a1", Arrays.asList( "a1 a2 a3 a4 a5 a6 a7 a8 a9" ) ),
            Arguments.of( "a2", Arrays.asList( "a2 a3 a4 a5 a6 a7 a8 a9" ) ),
            Arguments.of( "a3", Arrays.asList( "a3 a4 a5 a6 a7 a8 a9" ) ),
            Arguments.of( "a4", Arrays.asList( "a4 a5 a6 a7 a8 a9" ) ),
            Arguments.of( "a5", Arrays.asList( "a5 a6 a7 a8 a9" ) ),
            Arguments.of( "a6", Arrays.asList( "a6 a7 a8 a9" ) ),
            Arguments.of( "a7", Arrays.asList( "a7 a8 a9" ) ),
            Arguments.of( "a8", Arrays.asList( "a8 a9" ) ),
            Arguments.of( "a9", EMPTY_STRING_LIST ),
            Arguments.of( "b1", Arrays.asList( "b1 b2 b3 b4 b5 b6 b7 b8" ) ),
            Arguments.of( "b2", Arrays.asList( "b2 b3 b4 b5 b6 b7 b8" ) ),
            Arguments.of( "b3", Arrays.asList( "b3 b4 b5 b6 b7 b8" ) ),
            Arguments.of( "b4", Arrays.asList( "b4 b5 b6 b7 b8" ) ),
            Arguments.of( "b5", Arrays.asList( "b5 b6 b7 b8" ) ),
            Arguments.of( "b6", Arrays.asList( "b6 b7 b8" ) ),
            Arguments.of( "b7", Arrays.asList( "b7 b8" ) ),
            Arguments.of( "b8", EMPTY_STRING_LIST ),
            Arguments.of( "c1", Arrays.asList( "c1 c2 c3 c4 c5 c6 c7 c8" ) ),
            Arguments.of( "c2", Arrays.asList( "c2 c3 c4 c5 c6 c7 c8" ) ),
            Arguments.of( "c3", Arrays.asList( "c3 c4 c5 c6 c7 c8" ) ),
            Arguments.of( "c4", Arrays.asList( "c4 c5 c6 c7 c8" ) ),
            Arguments.of( "c5", Arrays.asList( "c5 c6 c7 c8" ) ),
            Arguments.of( "c6", Arrays.asList( "c6 c7 c8" ) ),
            Arguments.of( "c7", Arrays.asList( "c7 c8" ) ),
            Arguments.of( "c8", EMPTY_STRING_LIST ),
            Arguments.of( "d0", Arrays.asList( "d0 d1 d2 d3 d4 d5 d6 d7 d8 d9" ) ),
            Arguments.of( "d1", Arrays.asList( "d1 d2 d3 d4 d5 d6 d7 d8 d9" ) ),
            Arguments.of( "d2", Arrays.asList( "d2 d3 d4 d5 d6 d7 d8 d9" ) ),
            Arguments.of( "d3", Arrays.asList( "d3 d4 d5 d6 d7 d8 d9" ) ),
            Arguments.of( "d4", Arrays.asList( "d4 d5 d6 d7 d8 d9" ) ),
            Arguments.of( "d5", Arrays.asList( "d5 d6 d7 d8 d9" ) ),
            Arguments.of( "d6", Arrays.asList( "d6 d7 d8 d9" ) ),
            Arguments.of( "d7", Arrays.asList( "d7 d8 d9" ) ),
            Arguments.of( "d8", Arrays.asList( "d8 d9" ) ),
            Arguments.of( "d9", EMPTY_STRING_LIST ),
            Arguments.of( "e0", Arrays.asList( "e0 e1 e2 e3 e4 e5 e6 e7 e8 e9" ) ),
            Arguments.of( "e1", Arrays.asList( "e1 e2 e3 e4 e5 e6 e7 e8 e9" ) ),
            Arguments.of( "e2", Arrays.asList( "e2 e3 e4 e5 e6 e7 e8 e9" ) ),
            Arguments.of( "e3", Arrays.asList( "e3 e4 e5 e6 e7 e8 e9" ) ),
            Arguments.of( "e4", Arrays.asList( "e4 e5 e6 e7 e8 e9" ) ),
            Arguments.of( "e5", Arrays.asList( "e5 e6 e7 e8 e9" ) ),
            Arguments.of( "e6", Arrays.asList( "e6 e7 e8 e9" ) ),
            Arguments.of( "e7", Arrays.asList( "e7 e8 e9" ) ),
            Arguments.of( "e8", Arrays.asList( "e8 e9" ) ),
            Arguments.of( "e9", EMPTY_STRING_LIST )
        
        ); }
}

