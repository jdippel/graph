/*
 *  ICoordinate_GetLineBundles_DyadicCall_DirectedBlackToWhite_StandardBoard.java
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

package chess383.graph.board.standard;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
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
import chess383.graph.board.ICoordinate_GetLineBundles_Wrapper;
import chess383.graph.direction.Direction;

/**
 * <p>
 * The class ICoordinate_GetLineBundles_DyadicCall_DirectedBlackToWhite_StandardBoard implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method Set<List<String>> getLineBundles() for class ICoordinate_GetLineBundles_DyadicCall_DirectedBlackToWhite_StandardBoard is tested")
public class ICoordinate_GetLineBundles_DyadicCall_DirectedBlackToWhite_StandardBoard extends ICoordinate_GetLineBundles_Wrapper { 

    final static ICoordinate   BOARD =     ICoordinateFactory.STANDARD.get( );
    final static Direction     DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.BLACK	, ColorEnum.WHITE );
    final static List<String>  EMPTY_LIST = new ArrayList<String>();
    
    @ParameterizedTest( name = "given a standard board from location {0} there will be lines {1} to walk along" )
    @MethodSource("stringAndListProvider")
    public void testWithMultiArgMethodSource( String origin, List<String> expectedResultList ) {
    	assertThat( compareLists( BOARD.getLineBundles( origin, DIRECTION ), expectedResultList ) ).as( describeOnError( origin ) ).isTrue();
    }

    public static Stream<Arguments> stringAndListProvider() {
        return Stream.of(
            
            Arguments.of( "a1", EMPTY_LIST ),
            Arguments.of( "a2", Arrays.asList( "a2 a1", "a2 b1" ) ),
            Arguments.of( "a3", Arrays.asList( "a3 a2 a1", "a3 b2 c1" ) ),
            Arguments.of( "a4", Arrays.asList( "a4 a3 a2 a1", "a4 b3 c2 d1" ) ),
            Arguments.of( "a5", Arrays.asList( "a5 a4 a3 a2 a1", "a5 b4 c3 d2 e1" ) ),
            Arguments.of( "a6", Arrays.asList( "a6 a5 a4 a3 a2 a1", "a6 b5 c4 d3 e2 f1" ) ),
            Arguments.of( "a7", Arrays.asList( "a7 a6 a5 a4 a3 a2 a1", "a7 b6 c5 d4 e3 f2 g1" ) ),
            Arguments.of( "a8", Arrays.asList( "a8 a7 a6 a5 a4 a3 a2 a1", "a8 b7 c6 d5 e4 f3 g2 h1" ) ),
            Arguments.of( "b1", EMPTY_LIST ),
            Arguments.of( "b2", Arrays.asList( "b2 b1", "b2 c1", "b2 a1" ) ),
            Arguments.of( "b3", Arrays.asList( "b3 b2 b1", "b3 c2 d1", "b3 a2" ) ),
            Arguments.of( "b4", Arrays.asList( "b4 b3 b2 b1", "b4 c3 d2 e1", "b4 a3" ) ),
            Arguments.of( "b5", Arrays.asList( "b5 b4 b3 b2 b1", "b5 c4 d3 e2 f1", "b5 a4" ) ),
            Arguments.of( "b6", Arrays.asList( "b6 b5 b4 b3 b2 b1", "b6 c5 d4 e3 f2 g1", "b6 a5" ) ),
            Arguments.of( "b7", Arrays.asList( "b7 b6 b5 b4 b3 b2 b1", "b7 c6 d5 e4 f3 g2 h1", "b7 a6" ) ),
            Arguments.of( "b8", Arrays.asList( "b8 b7 b6 b5 b4 b3 b2 b1", "b8 c7 d6 e5 f4 g3 h2", "b8 a7" ) ),
            Arguments.of( "c1", EMPTY_LIST ),
            Arguments.of( "c2", Arrays.asList( "c2 c1", "c2 d1", "c2 b1" ) ),
            Arguments.of( "c3", Arrays.asList( "c3 c2 c1", "c3 d2 e1", "c3 b2 a1" ) ),
            Arguments.of( "c4", Arrays.asList( "c4 c3 c2 c1", "c4 d3 e2 f1", "c4 b3 a2" ) ),
            Arguments.of( "c5", Arrays.asList( "c5 c4 c3 c2 c1", "c5 d4 e3 f2 g1", "c5 b4 a3" ) ),
            Arguments.of( "c6", Arrays.asList( "c6 c5 c4 c3 c2 c1", "c6 d5 e4 f3 g2 h1", "c6 b5 a4" ) ),
            Arguments.of( "c7", Arrays.asList( "c7 c6 c5 c4 c3 c2 c1", "c7 d6 e5 f4 g3 h2", "c7 b6 a5" ) ),
            Arguments.of( "c8", Arrays.asList( "c8 c7 c6 c5 c4 c3 c2 c1", "c8 d7 e6 f5 g4 h3", "c8 b7 a6" ) ),
            Arguments.of( "d1", EMPTY_LIST ),
            Arguments.of( "d2", Arrays.asList( "d2 d1", "d2 e1", "d2 c1" ) ),
            Arguments.of( "d3", Arrays.asList( "d3 d2 d1", "d3 e2 f1", "d3 c2 b1" ) ),
            Arguments.of( "d4", Arrays.asList( "d4 d3 d2 d1", "d4 e3 f2 g1", "d4 c3 b2 a1" ) ),
            Arguments.of( "d5", Arrays.asList( "d5 d4 d3 d2 d1", "d5 e4 f3 g2 h1", "d5 c4 b3 a2" ) ),
            Arguments.of( "d6", Arrays.asList( "d6 d5 d4 d3 d2 d1", "d6 e5 f4 g3 h2", "d6 c5 b4 a3" ) ),
            Arguments.of( "d7", Arrays.asList( "d7 d6 d5 d4 d3 d2 d1", "d7 e6 f5 g4 h3", "d7 c6 b5 a4" ) ),
            Arguments.of( "d8", Arrays.asList( "d8 d7 d6 d5 d4 d3 d2 d1", "d8 e7 f6 g5 h4", "d8 c7 b6 a5" ) ),
            Arguments.of( "e1", EMPTY_LIST ),
            Arguments.of( "e2", Arrays.asList( "e2 e1", "e2 f1", "e2 d1" ) ),
            Arguments.of( "e3", Arrays.asList( "e3 e2 e1", "e3 f2 g1", "e3 d2 c1" ) ),
            Arguments.of( "e4", Arrays.asList( "e4 e3 e2 e1", "e4 f3 g2 h1", "e4 d3 c2 b1" ) ),
            Arguments.of( "e5", Arrays.asList( "e5 e4 e3 e2 e1", "e5 f4 g3 h2", "e5 d4 c3 b2 a1" ) ),
            Arguments.of( "e6", Arrays.asList( "e6 e5 e4 e3 e2 e1", "e6 f5 g4 h3", "e6 d5 c4 b3 a2" ) ),
            Arguments.of( "e7", Arrays.asList( "e7 e6 e5 e4 e3 e2 e1", "e7 f6 g5 h4", "e7 d6 c5 b4 a3" ) ),
            Arguments.of( "e8", Arrays.asList( "e8 e7 e6 e5 e4 e3 e2 e1", "e8 f7 g6 h5", "e8 d7 c6 b5 a4" ) ),
            Arguments.of( "f1", EMPTY_LIST ),
            Arguments.of( "f2", Arrays.asList( "f2 f1", "f2 g1", "f2 e1" ) ),
            Arguments.of( "f3", Arrays.asList( "f3 f2 f1", "f3 g2 h1", "f3 e2 d1" ) ),
            Arguments.of( "f4", Arrays.asList( "f4 f3 f2 f1", "f4 g3 h2", "f4 e3 d2 c1" ) ),
            Arguments.of( "f5", Arrays.asList( "f5 f4 f3 f2 f1", "f5 g4 h3", "f5 e4 d3 c2 b1" ) ),
            Arguments.of( "f6", Arrays.asList( "f6 f5 f4 f3 f2 f1", "f6 g5 h4", "f6 e5 d4 c3 b2 a1" ) ),
            Arguments.of( "f7", Arrays.asList( "f7 f6 f5 f4 f3 f2 f1", "f7 g6 h5", "f7 e6 d5 c4 b3 a2" ) ),
            Arguments.of( "f8", Arrays.asList( "f8 f7 f6 f5 f4 f3 f2 f1", "f8 g7 h6", "f8 e7 d6 c5 b4 a3" ) ),
            Arguments.of( "g1", EMPTY_LIST ),
            Arguments.of( "g2", Arrays.asList( "g2 g1", "g2 h1", "g2 f1" ) ),
            Arguments.of( "g3", Arrays.asList( "g3 g2 g1", "g3 h2", "g3 f2 e1" ) ),
            Arguments.of( "g4", Arrays.asList( "g4 g3 g2 g1", "g4 h3", "g4 f3 e2 d1" ) ),
            Arguments.of( "g5", Arrays.asList( "g5 g4 g3 g2 g1", "g5 h4", "g5 f4 e3 d2 c1" ) ),
            Arguments.of( "g6", Arrays.asList( "g6 g5 g4 g3 g2 g1", "g6 h5", "g6 f5 e4 d3 c2 b1" ) ),
            Arguments.of( "g7", Arrays.asList( "g7 g6 g5 g4 g3 g2 g1", "g7 h6", "g7 f6 e5 d4 c3 b2 a1" ) ),
            Arguments.of( "g8", Arrays.asList( "g8 g7 g6 g5 g4 g3 g2 g1", "g8 h7", "g8 f7 e6 d5 c4 b3 a2" ) ),
            Arguments.of( "h1", EMPTY_LIST ),
            Arguments.of( "h2", Arrays.asList( "h2 h1", "h2 g1" ) ),
            Arguments.of( "h3", Arrays.asList( "h3 h2 h1", "h3 g2 f1" ) ),
            Arguments.of( "h4", Arrays.asList( "h4 h3 h2 h1", "h4 g3 f2 e1" ) ),
            Arguments.of( "h5", Arrays.asList( "h5 h4 h3 h2 h1", "h5 g4 f3 e2 d1" ) ),
            Arguments.of( "h6", Arrays.asList( "h6 h5 h4 h3 h2 h1", "h6 g5 f4 e3 d2 c1" ) ),
            Arguments.of( "h7", Arrays.asList( "h7 h6 h5 h4 h3 h2 h1", "h7 g6 f5 e4 d3 c2 b1" ) ),
            Arguments.of( "h8", Arrays.asList( "h8 h7 h6 h5 h4 h3 h2 h1", "h8 g7 f6 e5 d4 c3 b2 a1" ) )

        ); }
}

