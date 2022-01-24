/*
 *  ICoordinate_GetLineBundles_DyadicCall_Undirected_StandardBoard.java
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

package chess383.graph.board.standard;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import chess383.ICoordinate;
import chess383.ICoordinateFactory;
import chess383.graph.board.ICoordinate_GetLineBundles_Wrapper;
import chess383.graph.direction.Direction;

/**
 * <p>
 * The class ICoordinate_GetLineBundles_DyadicCall_Undirected_StandardBoard implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   January 2022
 *
 */
@DisplayName("the public method Set<List<String>> getLineBundles() for class ICoordinate_GetLineBundles_DyadicCall_Undirected_StandardBoard is tested")
public class ICoordinate_GetLineBundles_DyadicCall_Undirected_StandardBoard extends ICoordinate_GetLineBundles_Wrapper { 

    final static ICoordinate   BOARD =     ICoordinateFactory.STANDARD.get( );
    final static Direction     DIRECTION = Direction.createBidirectionalDirection( );
    
    @ParameterizedTest( name = "given a standard board from location {0} there will be lines {1} to walk along" )
    @MethodSource("stringAndListProvider")
    public void testWithMultiArgMethodSource( String origin, List<String> expectedResultList ) {
    	assertThat( compareCollections( BOARD.getLineBundles( origin, DIRECTION ), expectedResultList ) ).as( describeOnError( origin ) ).isTrue();
    }

    public static Stream<Arguments> stringAndListProvider() {
        return Stream.of(
            
            Arguments.of( "a1", Arrays.asList( "a1 b1 c1 d1 e1 f1 g1 h1", "a1 b3", "a1 c2" ) ),
            Arguments.of( "a2", Arrays.asList( "a2 b2 c2 d2 e2 f2 g2 h2", "a2 b4", "a2 c3", "a2 c1" ) ),
            Arguments.of( "a3", Arrays.asList( "a3 b3 c3 d3 e3 f3 g3 h3", "a3 b5", "a3 b1", "a3 c4", "a3 c2" ) ),
            Arguments.of( "a4", Arrays.asList( "a4 b4 c4 d4 e4 f4 g4 h4", "a4 b6", "a4 b2", "a4 c5", "a4 c3" ) ),
            Arguments.of( "a5", Arrays.asList( "a5 b5 c5 d5 e5 f5 g5 h5", "a5 b7", "a5 b3", "a5 c6", "a5 c4" ) ),
            Arguments.of( "a6", Arrays.asList( "a6 b6 c6 d6 e6 f6 g6 h6", "a6 b8", "a6 b4", "a6 c7", "a6 c5" ) ),
            Arguments.of( "a7", Arrays.asList( "a7 b7 c7 d7 e7 f7 g7 h7", "a7 c8", "a7 b5", "a7 c6" ) ),
            Arguments.of( "a8", Arrays.asList( "a8 b8 c8 d8 e8 f8 g8 h8", "a8 b6", "a8 c7" ) ),
            Arguments.of( "b1", Arrays.asList( "b1 c1 d1 e1 f1 g1 h1", "b1 a1", "b1 c3", "b1 d2", "b1 a3" ) ),
            Arguments.of( "b2", Arrays.asList( "b2 a2", "b2 c2 d2 e2 f2 g2 h2", "b2 c4", "b2 d3", "b2 d1", "b2 a4" ) ),
            Arguments.of( "b3", Arrays.asList( "b3 c3 d3 e3 f3 g3 h3", "b3 a3", "b3 c5", "b3 d4", "b3 d2", "b3 c1", "b3 a1", "b3 a5" ) ),
            Arguments.of( "b4", Arrays.asList( "b4 a4", "b4 c4 d4 e4 f4 g4 h4", "b4 c6", "b4 d5", "b4 d3", "b4 c2", "b4 a2", "b4 a6" ) ),
            Arguments.of( "b5", Arrays.asList( "b5 c5 d5 e5 f5 g5 h5", "b5 a5", "b5 c7", "b5 d6", "b5 d4", "b5 c3", "b5 a3", "b5 a7" ) ),
            Arguments.of( "b6", Arrays.asList( "b6 a6", "b6 c6 d6 e6 f6 g6 h6", "b6 c8", "b6 d7", "b6 d5", "b6 c4", "b6 a4", "b6 a8" ) ),
            Arguments.of( "b7", Arrays.asList( "b7 c7 d7 e7 f7 g7 h7", "b7 a7", "b7 d8", "b7 d6", "b7 c5", "b7 a5" ) ),
            Arguments.of( "b8", Arrays.asList( "b8 a8", "b8 c8 d8 e8 f8 g8 h8", "b8 d7", "b8 c6", "b8 a6" ) ),
            Arguments.of( "c1", Arrays.asList( "c1 b1 a1", "c1 d1 e1 f1 g1 h1", "c1 d3", "c1 e2", "c1 a2", "c1 b3" ) ),
            Arguments.of( "c2", Arrays.asList( "c2 b2 a2", "c2 d2 e2 f2 g2 h2", "c2 d4", "c2 e3", "c2 e1", "c2 a1", "c2 a3", "c2 b4" ) ),
            Arguments.of( "c3", Arrays.asList( "c3 d3 e3 f3 g3 h3", "c3 b3 a3", "c3 d5", "c3 e4", "c3 e2", "c3 d1", "c3 b1", "c3 a2", "c3 a4", "c3 b5" ) ),
            Arguments.of( "c4", Arrays.asList( "c4 d4 e4 f4 g4 h4", "c4 b4 a4", "c4 d6", "c4 e5", "c4 e3", "c4 d2", "c4 b2", "c4 a3", "c4 a5", "c4 b6" ) ),
            Arguments.of( "c5", Arrays.asList( "c5 d5 e5 f5 g5 h5", "c5 b5 a5", "c5 d7", "c5 e6", "c5 e4", "c5 d3", "c5 b3", "c5 a4", "c5 a6", "c5 b7" ) ),
            Arguments.of( "c6", Arrays.asList( "c6 d6 e6 f6 g6 h6", "c6 b6 a6", "c6 d8", "c6 e7", "c6 e5", "c6 d4", "c6 b4", "c6 a5", "c6 a7", "c6 b8" ) ),
            Arguments.of( "c7", Arrays.asList( "c7 d7 e7 f7 g7 h7", "c7 b7 a7", "c7 e8", "c7 e6", "c7 d5", "c7 b5", "c7 a6", "c7 a8" ) ),
            Arguments.of( "c8", Arrays.asList( "c8 b8 a8", "c8 d8 e8 f8 g8 h8", "c8 e7", "c8 d6", "c8 b6", "c8 a7" ) ),
            Arguments.of( "d1", Arrays.asList( "d1 c1 b1 a1", "d1 e1 f1 g1 h1", "d1 e3", "d1 f2", "d1 b2", "d1 c3" ) ),
            Arguments.of( "d2", Arrays.asList( "d2 c2 b2 a2", "d2 e2 f2 g2 h2", "d2 e4", "d2 f3", "d2 f1", "d2 b1", "d2 b3", "d2 c4" ) ),
            Arguments.of( "d3", Arrays.asList( "d3 e3 f3 g3 h3", "d3 c3 b3 a3", "d3 e5", "d3 f4", "d3 f2", "d3 e1", "d3 c1", "d3 b2", "d3 b4", "d3 c5" ) ),
            Arguments.of( "d4", Arrays.asList( "d4 e4 f4 g4 h4", "d4 c4 b4 a4", "d4 e6", "d4 f5", "d4 f3", "d4 e2", "d4 c2", "d4 b3", "d4 b5", "d4 c6" ) ),
            Arguments.of( "d5", Arrays.asList( "d5 e5 f5 g5 h5", "d5 c5 b5 a5", "d5 e7", "d5 f6", "d5 f4", "d5 e3", "d5 c3", "d5 b4", "d5 b6", "d5 c7" ) ),
            Arguments.of( "d6", Arrays.asList( "d6 c6 b6 a6", "d6 e6 f6 g6 h6", "d6 e8", "d6 f7", "d6 f5", "d6 e4", "d6 c4", "d6 b5", "d6 b7", "d6 c8" ) ),
            Arguments.of( "d7", Arrays.asList( "d7 c7 b7 a7", "d7 e7 f7 g7 h7", "d7 f8", "d7 f6", "d7 e5", "d7 c5", "d7 b6", "d7 b8" ) ),
            Arguments.of( "d8", Arrays.asList( "d8 e8 f8 g8 h8", "d8 c8 b8 a8", "d8 f7", "d8 e6", "d8 c6", "d8 b7" ) ),
            Arguments.of( "e1", Arrays.asList( "e1 d1 c1 b1 a1", "e1 f1 g1 h1", "e1 f3", "e1 g2", "e1 c2", "e1 d3" ) ),
            Arguments.of( "e2", Arrays.asList( "e2 d2 c2 b2 a2", "e2 f2 g2 h2", "e2 f4", "e2 g3", "e2 g1", "e2 c1", "e2 c3", "e2 d4" ) ),
            Arguments.of( "e3", Arrays.asList( "e3 f3 g3 h3", "e3 d3 c3 b3 a3", "e3 f5", "e3 g4", "e3 g2", "e3 f1", "e3 d1", "e3 c2", "e3 c4", "e3 d5" ) ),
            Arguments.of( "e4", Arrays.asList( "e4 d4 c4 b4 a4", "e4 f4 g4 h4", "e4 f6", "e4 g5", "e4 g3", "e4 f2", "e4 d2", "e4 c3", "e4 c5", "e4 d6" ) ),
            Arguments.of( "e5", Arrays.asList( "e5 d5 c5 b5 a5", "e5 f5 g5 h5", "e5 f7", "e5 g6", "e5 g4", "e5 f3", "e5 d3", "e5 c4", "e5 c6", "e5 d7" ) ),
            Arguments.of( "e6", Arrays.asList( "e6 d6 c6 b6 a6", "e6 f6 g6 h6", "e6 f8", "e6 g7", "e6 g5", "e6 f4", "e6 d4", "e6 c5", "e6 c7", "e6 d8" ) ),
            Arguments.of( "e7", Arrays.asList( "e7 f7 g7 h7", "e7 d7 c7 b7 a7", "e7 g8", "e7 g6", "e7 f5", "e7 d5", "e7 c6", "e7 c8" ) ),
            Arguments.of( "e8", Arrays.asList( "e8 f8 g8 h8", "e8 d8 c8 b8 a8", "e8 g7", "e8 f6", "e8 d6", "e8 c7" ) ),
            Arguments.of( "f1", Arrays.asList( "f1 e1 d1 c1 b1 a1", "f1 g1 h1", "f1 g3", "f1 h2", "f1 d2", "f1 e3" ) ),
            Arguments.of( "f2", Arrays.asList( "f2 e2 d2 c2 b2 a2", "f2 g2 h2", "f2 g4", "f2 h3", "f2 h1", "f2 d1", "f2 d3", "f2 e4" ) ),
            Arguments.of( "f3", Arrays.asList( "f3 g3 h3", "f3 e3 d3 c3 b3 a3", "f3 g5", "f3 h4", "f3 h2", "f3 g1", "f3 e1", "f3 d2", "f3 d4", "f3 e5" ) ),
            Arguments.of( "f4", Arrays.asList( "f4 e4 d4 c4 b4 a4", "f4 g4 h4", "f4 g6", "f4 h5", "f4 h3", "f4 g2", "f4 e2", "f4 d3", "f4 d5", "f4 e6" ) ),
            Arguments.of( "f5", Arrays.asList( "f5 e5 d5 c5 b5 a5", "f5 g5 h5", "f5 g7", "f5 h6", "f5 h4", "f5 g3", "f5 e3", "f5 d4", "f5 d6", "f5 e7" ) ),
            Arguments.of( "f6", Arrays.asList( "f6 e6 d6 c6 b6 a6", "f6 g6 h6", "f6 g8", "f6 h7", "f6 h5", "f6 g4", "f6 e4", "f6 d5", "f6 d7", "f6 e8" ) ),
            Arguments.of( "f7", Arrays.asList( "f7 e7 d7 c7 b7 a7", "f7 g7 h7", "f7 h8", "f7 h6", "f7 g5", "f7 e5", "f7 d6", "f7 d8" ) ),
            Arguments.of( "f8", Arrays.asList( "f8 g8 h8", "f8 e8 d8 c8 b8 a8", "f8 h7", "f8 g6", "f8 e6", "f8 d7" ) ),
            Arguments.of( "g1", Arrays.asList( "g1 h1", "g1 f1 e1 d1 c1 b1 a1", "g1 h3", "g1 e2", "g1 f3" ) ),
            Arguments.of( "g2", Arrays.asList( "g2 h2", "g2 f2 e2 d2 c2 b2 a2", "g2 h4", "g2 e1", "g2 e3", "g2 f4" ) ),
            Arguments.of( "g3", Arrays.asList( "g3 h3", "g3 f3 e3 d3 c3 b3 a3", "g3 h5", "g3 h1", "g3 f1", "g3 e2", "g3 e4", "g3 f5" ) ),
            Arguments.of( "g4", Arrays.asList( "g4 h4", "g4 f4 e4 d4 c4 b4 a4", "g4 h6", "g4 h2", "g4 f2", "g4 e3", "g4 e5", "g4 f6" ) ),
            Arguments.of( "g5", Arrays.asList( "g5 h5", "g5 f5 e5 d5 c5 b5 a5", "g5 h7", "g5 h3", "g5 f3", "g5 e4", "g5 e6", "g5 f7" ) ),
            Arguments.of( "g6", Arrays.asList( "g6 h6", "g6 f6 e6 d6 c6 b6 a6", "g6 h8", "g6 h4", "g6 f4", "g6 e5", "g6 e7", "g6 f8" ) ),
            Arguments.of( "g7", Arrays.asList( "g7 h7", "g7 f7 e7 d7 c7 b7 a7", "g7 h5", "g7 f5", "g7 e6", "g7 e8" ) ),
            Arguments.of( "g8", Arrays.asList( "g8 h8", "g8 f8 e8 d8 c8 b8 a8", "g8 h6", "g8 f6", "g8 e7" ) ),
            Arguments.of( "h1", Arrays.asList( "h1 g1 f1 e1 d1 c1 b1 a1", "h1 f2", "h1 g3" ) ),
            Arguments.of( "h2", Arrays.asList( "h2 g2 f2 e2 d2 c2 b2 a2", "h2 f1", "h2 f3", "h2 g4" ) ),
            Arguments.of( "h3", Arrays.asList( "h3 g3 f3 e3 d3 c3 b3 a3", "h3 g1", "h3 f2", "h3 f4", "h3 g5" ) ),
            Arguments.of( "h4", Arrays.asList( "h4 g4 f4 e4 d4 c4 b4 a4", "h4 g2", "h4 f3", "h4 f5", "h4 g6" ) ),
            Arguments.of( "h5", Arrays.asList( "h5 g5 f5 e5 d5 c5 b5 a5", "h5 g3", "h5 f4", "h5 f6", "h5 g7" ) ),
            Arguments.of( "h6", Arrays.asList( "h6 g6 f6 e6 d6 c6 b6 a6", "h6 g4", "h6 f5", "h6 f7", "h6 g8" ) ),
            Arguments.of( "h7", Arrays.asList( "h7 g7 f7 e7 d7 c7 b7 a7", "h7 g5", "h7 f6", "h7 f8" ) ),
            Arguments.of( "h8", Arrays.asList( "h8 g8 f8 e8 d8 c8 b8 a8", "h8 f7", "h8 g6" ) )

        ); }
}

