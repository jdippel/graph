/*
 *  ICoordinate_GetLineBundles_Knight_TripleBoardByRectangles.java
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

package chess383.graph.board.tripleboardbyrectangles;

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
 * The class ICoordinate_GetLineBundles_Knight_TripleBoardByRectangles implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method Set<List<String>> getLineBundles() for class ICoordinate_GetLineBundles_Knight_TripleBoardByRectangles is tested")
public class ICoordinate_GetLineBundles_Knight_TripleBoardByRectangles extends ICoordinate_GetLineBundles_Wrapper { 

    final static ICoordinate   BOARD =     ICoordinateFactory.TRIPLE.get( );
    final static Direction     DIRECTION = Direction.createBidirectionalDirection( );
    final static AdjacencyEnum ADJACENCY = AdjacencyEnum.UNSPECIFIED;
 
    
    @ParameterizedTest( name = "given a standard board from location {0} there will be lines {1} to walk along" )
    @MethodSource("stringAndListProvider")
    public void testWithMultiArgMethodSource( String origin, List<String> expectedResultList ) {
        assertTrue( testOfArguments( BOARD, origin, DIRECTION, ADJACENCY, expectedResultList ) );
    }

    public static Stream<Arguments> stringAndListProvider() {
        return Stream.of(
            
            Arguments.of( "a1", Arrays.asList( "a1 c2", "a1 b3" ) ),
            Arguments.of( "a2", Arrays.asList( "a2 c1", "a2 c3", "a2 b4" ) ),
            Arguments.of( "a3", Arrays.asList( "a3 b1", "a3 c2", "a3 c4", "a3 b5" ) ),
            Arguments.of( "a4", Arrays.asList( "a4 b2", "a4 c3", "a4 c5", "a4 b6" ) ),
            Arguments.of( "a5", Arrays.asList( "a5 b3", "a5 c4", "a5 c6", "a5 b7" ) ),
            Arguments.of( "a6", Arrays.asList( "a6 b4", "a6 c5", "a6 c7", "a6 b8" ) ),
            Arguments.of( "a7", Arrays.asList( "a7 c6", "a7 b5", "a7 c8" ) ),
            Arguments.of( "a8", Arrays.asList( "a8 c7", "a8 b6" ) ),
        
            Arguments.of( "b1", Arrays.asList( "b1 d2", "b1 c3", "b1 a3" ) ),
            Arguments.of( "b2", Arrays.asList( "b2 d3", "b2 c4", "b2 a4", "b2 d1" ) ),
            Arguments.of( "b3", Arrays.asList( "b3 a1", "b3 d4", "b3 c5", "b3 a5", "b3 c1", "b3 d2" ) ),
            Arguments.of( "b4", Arrays.asList( "b4 a2", "b4 d5", "b4 c6", "b4 a6", "b4 c2", "b4 d3" ) ),
            Arguments.of( "b5", Arrays.asList( "b5 a3", "b5 d6", "b5 c7", "b5 a7", "b5 c3", "b5 d4" ) ),
            Arguments.of( "b6", Arrays.asList( "b6 a4", "b6 d7", "b6 c8", "b6 a8", "b6 c4", "b6 d5" ) ),
            Arguments.of( "b7", Arrays.asList( "b7 d8", "b7 a5", "b7 d6", "b7 c5" ) ),
            Arguments.of( "b8", Arrays.asList( "b8 a6", "b8 d7", "b8 c6" ) ),
        
            Arguments.of( "c1", Arrays.asList( "c1 e2", "c1 d3", "c1 a2", "c1 b3" ) ),
            Arguments.of( "c2", Arrays.asList( "c2 e3", "c2 a1", "c2 d4", "c2 a3", "c2 b4", "c2 e1" ) ),
            Arguments.of( "c3", Arrays.asList( "c3 b1", "c3 e4", "c3 a2", "c3 d5", "c3 a4", "c3 b5", "c3 d1", "c3 e2" ) ),
            Arguments.of( "c4", Arrays.asList( "c4 b2", "c4 a3", "c4 d6", "c4 a5", "c4 b6", "c4 e9", "c4 i5", "c4 d2", "c4 e3" ) ),
            Arguments.of( "c5", Arrays.asList( "c5 b3", "c5 a4", "c5 d7", "c5 b7", "c5 a6", "c5 i6", "c5 i9", "c5 d3", "c5 e4" ) ),
            Arguments.of( "c6", Arrays.asList( "c6 b4", "c6 d8", "c6 a5", "c6 b8", "c6 a7", "c6 i5", "c6 i7", "c6 d4" ) ),
            Arguments.of( "c7", Arrays.asList( "c7 b5", "c7 a6", "c7 a8", "c7 i6", "c7 i8", "c7 d5" ) ),
            Arguments.of( "c8", Arrays.asList( "c8 b6", "c8 a7", "c8 i7", "c8 d6" ) ),
        
            Arguments.of( "d1", Arrays.asList( "d1 f2", "d1 e3", "d1 b2", "d1 c3" ) ),
            Arguments.of( "d2", Arrays.asList( "d2 f3", "d2 b1", "d2 e4", "d2 b3", "d2 c4", "d2 f1" ) ),
            Arguments.of( "d3", Arrays.asList( "d3 c1", "d3 f4", "d3 b2", "d3 b4", "d3 c5", "d3 e9", "d3 e1", "d3 f2" ) ),
            Arguments.of( "d4", Arrays.asList( "d4 c2", "d4 b3", "d4 b5", "d4 c6", "d4 f9", "d4 e10", "d4 j5", "d4 e2", "d4 f3", "d4 i6" ) ),
            Arguments.of( "d5", Arrays.asList( "d5 c3", "d5 b4", "d5 c7", "d5 b6", "d5 j6", "d5 j9", "d5 e3", "d5 f4", "d5 i7" ) ),
            Arguments.of( "d6", Arrays.asList( "d6 c4", "d6 b5", "d6 c8", "d6 b7", "d6 j5", "d6 j7", "d6 i9", "d6 i8", "d6 e4" ) ),
            Arguments.of( "d7", Arrays.asList( "d7 c5", "d7 b6", "d7 b8", "d7 j6", "d7 i5", "d7 j8" ) ),
            Arguments.of( "d8", Arrays.asList( "d8 c6", "d8 b7", "d8 j7", "d8 i6" ) ),
        
            Arguments.of( "e1", Arrays.asList( "e1 g2", "e1 f3", "e1 c2", "e1 d3" ) ),
            Arguments.of( "e2", Arrays.asList( "e2 g3", "e2 c1", "e2 f4", "e2 c3", "e2 d4", "e2 g1" ) ),
            Arguments.of( "e3", Arrays.asList( "e3 d1", "e3 g4", "e3 c2", "e3 c4", "e3 d5", "e3 f9", "e3 f1", "e3 g2" ) ),
            Arguments.of( "e4", Arrays.asList( "e4 j9", "e4 d2", "e4 c3", "e4 f10", "e4 c5", "e4 g9", "e4 d6", "e4 i10", "e4 f2", "e4 g3" ) ),
            Arguments.of( "e9", Arrays.asList( "e9 f11", "e9 g10", "e9 i11", "e9 j10", "e9 j5", "e9 f3", "e9 g4", "e9 i6", "e9 d3", "e9 c4" ) ),
            Arguments.of( "e10", Arrays.asList( "e10 g9", "e10 j9", "e10 d4", "e10 f12", "e10 g11", "e10 f4", "e10 i12", "e10 j11", "e10 i5" ) ),
            Arguments.of( "e11", Arrays.asList( "e11 i9", "e11 j10", "e11 g12", "e11 g10", "e11 j12", "e11 f9" ) ),
            Arguments.of( "e12", Arrays.asList( "e12 g11", "e12 f10", "e12 i10", "e12 j11" ) ),
        
            Arguments.of( "f1", Arrays.asList( "f1 h2", "f1 g3", "f1 d2", "f1 e3" ) ),
            Arguments.of( "f2", Arrays.asList( "f2 h3", "f2 d1", "f2 g4", "f2 d3", "f2 e4", "f2 h1" ) ),
            Arguments.of( "f3", Arrays.asList( "f3 e1", "f3 h4", "f3 d2", "f3 d4", "f3 g9", "f3 e9", "f3 g1", "f3 h2" ) ),
            Arguments.of( "f4", Arrays.asList( "f4 e2", "f4 i9", "f4 d3", "f4 e10", "f4 d5", "f4 h9", "f4 g10", "f4 g2", "f4 h3" ) ),
            Arguments.of( "f9", Arrays.asList( "f9 e11", "f9 i10", "f9 g11", "f9 h10", "f9 g3", "f9 h4", "f9 i5", "f9 e3", "f9 d4" ) ),
            Arguments.of( "f10", Arrays.asList( "f10 e12", "f10 h9", "f10 i9", "f10 e4", "f10 g12", "f10 h11", "f10 i11", "f10 g4" ) ),
            Arguments.of( "f11", Arrays.asList( "f11 e9", "f11 h10", "f11 g9", "f11 i10", "f11 h12", "f11 i12" ) ),
            Arguments.of( "f12", Arrays.asList( "f12 g10", "f12 h11", "f12 i11", "f12 e10" ) ),
        
            Arguments.of( "g1", Arrays.asList( "g1 h3", "g1 e2", "g1 f3" ) ),
            Arguments.of( "g2", Arrays.asList( "g2 e1", "g2 h4", "g2 e3", "g2 f4" ) ),
            Arguments.of( "g3", Arrays.asList( "g3 f1", "g3 e2", "g3 e4", "g3 h9", "g3 f9", "g3 h1" ) ),
            Arguments.of( "g4", Arrays.asList( "g4 f2", "g4 e3", "g4 h10", "g4 e9", "g4 f10", "g4 h2" ) ),
            Arguments.of( "g9", Arrays.asList( "g9 e10", "g9 h11", "g9 f11", "g9 h3", "g9 f3", "g9 e4" ) ),
            Arguments.of( "g10", Arrays.asList( "g10 e9", "g10 e11", "g10 f12", "g10 h12", "g10 f4", "g10 h4" ) ),
            Arguments.of( "g11", Arrays.asList( "g11 e12", "g11 f9", "g11 h9", "g11 e10" ) ),
            Arguments.of( "g12", Arrays.asList( "g12 h10", "g12 f10", "g12 e11" ) ),
        
            Arguments.of( "h1", Arrays.asList( "h1 f2", "h1 g3" ) ),
            Arguments.of( "h2", Arrays.asList( "h2 f1", "h2 f3", "h2 g4" ) ),
            Arguments.of( "h3", Arrays.asList( "h3 g1", "h3 f2", "h3 f4", "h3 g9" ) ),
            Arguments.of( "h4", Arrays.asList( "h4 g2", "h4 f3", "h4 g10", "h4 f9" ) ),
            Arguments.of( "h9", Arrays.asList( "h9 g11", "h9 f10", "h9 g3", "h9 f4" ) ),
            Arguments.of( "h10", Arrays.asList( "h10 f11", "h10 g12", "h10 g4", "h10 f9" ) ),
            Arguments.of( "h11", Arrays.asList( "h11 f12", "h11 g9", "h11 f10" ) ),
            Arguments.of( "h12", Arrays.asList( "h12 g10", "h12 f11" ) ),
               
            Arguments.of( "i5", Arrays.asList( "i5 k6", "i5 k9", "i5 j7", "i5 c4", "i5 f9", "i5 d7", "i5 c6", "i5 e10", "i5 j10" ) ),
            Arguments.of( "i6", Arrays.asList( "i6 k7", "i6 j9", "i6 j8", "i6 d4", "i6 c5", "i6 d8", "i6 c7", "i6 e9", "i6 k5" ) ),
            Arguments.of( "i7", Arrays.asList( "i7 k8", "i7 d5", "i7 c6", "i7 c8", "i7 k6", "i7 j5" ) ),
            Arguments.of( "i8", Arrays.asList( "i8 d6", "i8 c7", "i8 k7", "i8 j6" ) ),
            Arguments.of( "i9", Arrays.asList( "i9 d6", "i9 c5", "i9 e11", "i9 f10", "i9 j11", "i9 k10", "i9 k5", "i9 j6", "i9 f4" ) ),
            Arguments.of( "i10", Arrays.asList( "i10 j5", "i10 j12", "i10 k11", "i10 k9", "i10 e4", "i10 f9", "i10 f11", "i10 e12" ) ),
            Arguments.of( "i11", Arrays.asList( "i11 k10", "i11 k12", "i11 j9", "i11 e9", "i11 f12", "i11 f10" ) ),
            Arguments.of( "i12", Arrays.asList( "i12 k11", "i12 j10", "i12 e10", "i12 f11" ) ),
        
            Arguments.of( "j5", Arrays.asList( "j5 l6", "j5 l9", "j5 k10", "j5 k7", "j5 i7", "j5 d4", "j5 d6", "j5 e9", "j5 i10" ) ),
            Arguments.of( "j6", Arrays.asList( "j6 l7", "j6 k9", "j6 k8", "j6 i9", "j6 i8", "j6 d5", "j6 d7", "j6 l5" ) ),
            Arguments.of( "j7", Arrays.asList( "j7 l8", "j7 i5", "j7 d6", "j7 d8", "j7 l6", "j7 k5" ) ),
            Arguments.of( "j8", Arrays.asList( "j8 i6", "j8 d7", "j8 l7", "j8 k6" ) ),
            Arguments.of( "j9", Arrays.asList( "j9 e4", "j9 d5", "j9 e10", "j9 i11", "j9 l5", "j9 k6", "j9 k11", "j9 l10", "j9 i6" ) ),
            Arguments.of( "j10", Arrays.asList( "j10 i12", "j10 k5", "j10 i5", "j10 l9", "j10 k12", "j10 l11", "j10 e9", "j10 e11" ) ),
            Arguments.of( "j11", Arrays.asList( "j11 l10", "j11 k9", "j11 l12", "j11 i9", "j11 e10", "j11 e12" ) ),
            Arguments.of( "j12", Arrays.asList( "j12 l11", "j12 k10", "j12 e11", "j12 i10" ) ),
        
            Arguments.of( "k5", Arrays.asList( "k5 l10", "k5 j10", "k5 l7", "k5 j7", "k5 i6", "k5 i9" ) ),
            Arguments.of( "k6", Arrays.asList( "k6 l9", "k6 l8", "k6 i5", "k6 j9", "k6 j8", "k6 i7" ) ),
            Arguments.of( "k7", Arrays.asList( "k7 j5", "k7 i6", "k7 i8", "k7 l5" ) ),
            Arguments.of( "k8", Arrays.asList( "k8 j6", "k8 i7", "k8 l6" ) ),
            Arguments.of( "k9", Arrays.asList( "k9 i10", "k9 l11", "k9 l6", "k9 j11", "k9 i5", "k9 j6" ) ),
            Arguments.of( "k10", Arrays.asList( "k10 j12", "k10 l5", "k10 i11", "k10 j5", "k10 i9", "k10 l12" ) ),
            Arguments.of( "k11", Arrays.asList( "k11 i12", "k11 l9", "k11 j9", "k11 i10" ) ),
            Arguments.of( "k12", Arrays.asList( "k12 l10", "k12 i11", "k12 j10" ) ),
        
            Arguments.of( "l5", Arrays.asList( "l5 k10", "l5 k7", "l5 j6", "l5 j9" ) ),
            Arguments.of( "l6", Arrays.asList( "l6 j5", "l6 k9", "l6 k8", "l6 j7" ) ),
            Arguments.of( "l7", Arrays.asList( "l7 k5", "l7 j6", "l7 j8" ) ),
            Arguments.of( "l8", Arrays.asList( "l8 k6", "l8 j7" ) ),
            Arguments.of( "l9", Arrays.asList( "l9 k11", "l9 j10", "l9 j5", "l9 k6" ) ),
            Arguments.of( "l10", Arrays.asList( "l10 k12", "l10 k5", "l10 j11", "l10 j9" ) ),
            Arguments.of( "l11", Arrays.asList( "l11 k9", "l11 j12", "l11 j10" ) ),
            Arguments.of( "l12", Arrays.asList( "l12 j11", "l12 k10" ) )
        
        ); }
}

