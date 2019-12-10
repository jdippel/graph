/*
 *  ICoordinate_GetLineBundles_Bishop_WiteBlack_StandardBoard.java
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

package chess383.graph.board.standard;

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
 * The class ICoordinate_GetLineBundles_Bishop_WhiteBlack_StandardBoard implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method Set<List<String>> getLineBundles() for class ICoordinate_GetLineBundles_Bishop_WhiteBlack_StandardBoard is tested")
public class ICoordinate_GetLineBundles_Bishop_WhiteBlack_StandardBoard extends ICoordinate_GetLineBundles_Wrapper { 

    final static ICoordinate   BOARD =     ICoordinateFactory.STANDARD.get( );
    final static Direction     DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
    final static AdjacencyEnum ADJACENCY = AdjacencyEnum.BY_POINT;
    
    
    @ParameterizedTest( name = "given a standard board from location {0} there will be lines {1} to walk along" )
    @MethodSource("stringAndListProvider")
    public void testWithMultiArgMethodSource( String origin, List<String> expectedResultList ) {
        assertTrue( testOfArguments( BOARD, origin, DIRECTION, ADJACENCY, expectedResultList ) );
    }

    public static Stream<Arguments> stringAndListProvider() {
        return Stream.of(
            
            Arguments.of( "a1", Arrays.asList( "a1 b2 c3 d4 e5 f6 g7 h8" ) ),
            Arguments.of( "a2", Arrays.asList( "a2 b3 c4 d5 e6 f7 g8" ) ),
            Arguments.of( "a3", Arrays.asList( "a3 b4 c5 d6 e7 f8" ) ),
            Arguments.of( "a4", Arrays.asList( "a4 b5 c6 d7 e8" ) ),
            Arguments.of( "a5", Arrays.asList( "a5 b6 c7 d8" ) ),
            Arguments.of( "a6", Arrays.asList( "a6 b7 c8" ) ),
            Arguments.of( "a7", Arrays.asList( "a7 b8" ) ),
            Arguments.of( "a8", EMPTY_STRING_LIST ),
            Arguments.of( "b1", Arrays.asList( "b1 c2 d3 e4 f5 g6 h7", "b1 a2" ) ),
            Arguments.of( "b2", Arrays.asList( "b2 c3 d4 e5 f6 g7 h8", "b2 a3" ) ),
            Arguments.of( "b3", Arrays.asList( "b3 c4 d5 e6 f7 g8", "b3 a4" ) ),
            Arguments.of( "b4", Arrays.asList( "b4 c5 d6 e7 f8", "b4 a5" ) ),
            Arguments.of( "b5", Arrays.asList( "b5 c6 d7 e8", "b5 a6" ) ),
            Arguments.of( "b6", Arrays.asList( "b6 c7 d8", "b6 a7" ) ),
            Arguments.of( "b7", Arrays.asList( "b7 c8", "b7 a8" ) ),
            Arguments.of( "b8", EMPTY_STRING_LIST ),
            Arguments.of( "c1", Arrays.asList( "c1 d2 e3 f4 g5 h6", "c1 b2 a3" ) ),
            Arguments.of( "c2", Arrays.asList( "c2 d3 e4 f5 g6 h7", "c2 b3 a4" ) ),
            Arguments.of( "c3", Arrays.asList( "c3 d4 e5 f6 g7 h8", "c3 b4 a5" ) ),
            Arguments.of( "c4", Arrays.asList( "c4 d5 e6 f7 g8", "c4 b5 a6" ) ),
            Arguments.of( "c5", Arrays.asList( "c5 d6 e7 f8", "c5 b6 a7" ) ),
            Arguments.of( "c6", Arrays.asList( "c6 d7 e8", "c6 b7 a8" ) ),
            Arguments.of( "c7", Arrays.asList( "c7 d8", "c7 b8" ) ),
            Arguments.of( "c8", EMPTY_STRING_LIST ),
            Arguments.of( "d1", Arrays.asList( "d1 e2 f3 g4 h5", "d1 c2 b3 a4" ) ),
            Arguments.of( "d2", Arrays.asList( "d2 e3 f4 g5 h6", "d2 c3 b4 a5" ) ),
            Arguments.of( "d3", Arrays.asList( "d3 e4 f5 g6 h7", "d3 c4 b5 a6" ) ),
            Arguments.of( "d4", Arrays.asList( "d4 e5 f6 g7 h8", "d4 c5 b6 a7" ) ),
            Arguments.of( "d5", Arrays.asList( "d5 e6 f7 g8", "d5 c6 b7 a8" ) ),
            Arguments.of( "d6", Arrays.asList( "d6 e7 f8", "d6 c7 b8" ) ),
            Arguments.of( "d7", Arrays.asList( "d7 e8", "d7 c8" ) ),
            Arguments.of( "d8", EMPTY_STRING_LIST ),
            Arguments.of( "e1", Arrays.asList( "e1 f2 g3 h4", "e1 d2 c3 b4 a5" ) ),
            Arguments.of( "e2", Arrays.asList( "e2 f3 g4 h5", "e2 d3 c4 b5 a6" ) ),
            Arguments.of( "e3", Arrays.asList( "e3 f4 g5 h6", "e3 d4 c5 b6 a7" ) ),
            Arguments.of( "e4", Arrays.asList( "e4 f5 g6 h7", "e4 d5 c6 b7 a8" ) ),
            Arguments.of( "e5", Arrays.asList( "e5 f6 g7 h8", "e5 d6 c7 b8" ) ),
            Arguments.of( "e6", Arrays.asList( "e6 f7 g8", "e6 d7 c8" ) ),
            Arguments.of( "e7", Arrays.asList( "e7 f8", "e7 d8" ) ),
            Arguments.of( "e8", EMPTY_STRING_LIST ),
            Arguments.of( "f1", Arrays.asList( "f1 g2 h3", "f1 e2 d3 c4 b5 a6" ) ),
            Arguments.of( "f2", Arrays.asList( "f2 g3 h4", "f2 e3 d4 c5 b6 a7" ) ),
            Arguments.of( "f3", Arrays.asList( "f3 g4 h5", "f3 e4 d5 c6 b7 a8" ) ),
            Arguments.of( "f4", Arrays.asList( "f4 g5 h6", "f4 e5 d6 c7 b8" ) ),
            Arguments.of( "f5", Arrays.asList( "f5 g6 h7", "f5 e6 d7 c8" ) ),
            Arguments.of( "f6", Arrays.asList( "f6 g7 h8", "f6 e7 d8" ) ),
            Arguments.of( "f7", Arrays.asList( "f7 g8", "f7 e8" ) ),
            Arguments.of( "f8", EMPTY_STRING_LIST ),
            Arguments.of( "g1", Arrays.asList( "g1 h2", "g1 f2 e3 d4 c5 b6 a7" ) ),
            Arguments.of( "g2", Arrays.asList( "g2 h3", "g2 f3 e4 d5 c6 b7 a8" ) ),
            Arguments.of( "g3", Arrays.asList( "g3 h4", "g3 f4 e5 d6 c7 b8" ) ),
            Arguments.of( "g4", Arrays.asList( "g4 h5", "g4 f5 e6 d7 c8" ) ),
            Arguments.of( "g5", Arrays.asList( "g5 h6", "g5 f6 e7 d8" ) ),
            Arguments.of( "g6", Arrays.asList( "g6 h7", "g6 f7 e8" ) ),
            Arguments.of( "g7", Arrays.asList( "g7 h8", "g7 f8" ) ),
            Arguments.of( "g8", EMPTY_STRING_LIST ),
            Arguments.of( "h1", Arrays.asList( "h1 g2 f3 e4 d5 c6 b7 a8" ) ),
            Arguments.of( "h2", Arrays.asList( "h2 g3 f4 e5 d6 c7 b8" ) ),
            Arguments.of( "h3", Arrays.asList( "h3 g4 f5 e6 d7 c8" ) ),
            Arguments.of( "h4", Arrays.asList( "h4 g5 f6 e7 d8" ) ),
            Arguments.of( "h5", Arrays.asList( "h5 g6 f7 e8" ) ),
            Arguments.of( "h6", Arrays.asList( "h6 g7 f8" ) ),
            Arguments.of( "h7", Arrays.asList( "h7 g8" ) ),
            Arguments.of( "h8", EMPTY_STRING_LIST )
            
        ); }
}

