/*
 *  ICoordinate_GetLineBundles_Rook_NotDirected_TripleBoardByRectangles.java
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
import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.board.ICoordinate_GetLineBundles_Wrapper;
import chess383.graph.direction.Direction;

/**
 * <p>
 * The class ICoordinate_GetLineBundles_Rook_NotDirected_TripleBoardByRectangles implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method Set<List<String>> getLineBundles() for class ICoordinate_GetLineBundles_Rook_NotDirected_TripleBoardByRectangles is tested")
public class ICoordinate_GetLineBundles_Rook_NotDirected_TripleBoardByRectangles extends ICoordinate_GetLineBundles_Wrapper { 

    final static ICoordinate   BOARD =     ICoordinateFactory.TRIPLE.get( );
    final static Direction     DIRECTION = Direction.createBidirectionalDirection( );
    final static AdjacencyEnum ADJACENCY = AdjacencyEnum.BY_EDGE;
 
    
    @ParameterizedTest( name = "given a standard board from location {0} there will be lines {1} to walk along" )
    @MethodSource("stringAndListProvider")
    public void testWithMultiArgMethodSource( String origin, List<String> expectedResultList ) {
    	assertThat( testOfArguments( BOARD, origin, DIRECTION, ADJACENCY, expectedResultList ) ).as( describeOnError( origin ) ).isTrue();
    }

    public static Stream<Arguments> stringAndListProvider() {
        return Stream.of(
            
            Arguments.of( "a1", Arrays.asList( "a1 b1 c1 d1 e1 f1 g1 h1" ) ),
            Arguments.of( "a2", Arrays.asList( "a2 b2 c2 d2 e2 f2 g2 h2" ) ),
            Arguments.of( "a3", Arrays.asList( "a3 b3 c3 d3 e3 f3 g3 h3" ) ),
            Arguments.of( "a4", Arrays.asList( "a4 b4 c4 d4 e4 f4 g4 h4" ) ),
            Arguments.of( "a5", Arrays.asList( "a5 b5 c5 d5 i5 j5 k5 l5" ) ),
            Arguments.of( "a6", Arrays.asList( "a6 b6 c6 d6 i6 j6 k6 l6" ) ),
            Arguments.of( "a7", Arrays.asList( "a7 b7 c7 d7 i7 j7 k7 l7" ) ),
            Arguments.of( "a8", Arrays.asList( "a8 b8 c8 d8 i8 j8 k8 l8" ) ),
        
            Arguments.of( "b1", Arrays.asList( "b1 c1 d1 e1 f1 g1 h1", "b1 a1" ) ),
            Arguments.of( "b2", Arrays.asList( "b2 a2", "b2 c2 d2 e2 f2 g2 h2" ) ),
            Arguments.of( "b3", Arrays.asList( "b3 c3 d3 e3 f3 g3 h3", "b3 a3" ) ),
            Arguments.of( "b4", Arrays.asList( "b4 a4", "b4 c4 d4 e4 f4 g4 h4" ) ),
            Arguments.of( "b5", Arrays.asList( "b5 a5", "b5 c5 d5 i5 j5 k5 l5" ) ),
            Arguments.of( "b6", Arrays.asList( "b6 c6 d6 i6 j6 k6 l6", "b6 a6" ) ),
            Arguments.of( "b7", Arrays.asList( "b7 a7", "b7 c7 d7 i7 j7 k7 l7" ) ),
            Arguments.of( "b8", Arrays.asList( "b8 a8", "b8 c8 d8 i8 j8 k8 l8" ) ),
        
            Arguments.of( "c1", Arrays.asList( "c1 b1 a1", "c1 d1 e1 f1 g1 h1" ) ),
            Arguments.of( "c2", Arrays.asList( "c2 b2 a2", "c2 d2 e2 f2 g2 h2" ) ),
            Arguments.of( "c3", Arrays.asList( "c3 d3 e3 f3 g3 h3", "c3 b3 a3" ) ),
            Arguments.of( "c4", Arrays.asList( "c4 d4 e4 f4 g4 h4", "c4 b4 a4" ) ),
            Arguments.of( "c5", Arrays.asList( "c5 b5 a5", "c5 d5 i5 j5 k5 l5" ) ),
            Arguments.of( "c6", Arrays.asList( "c6 d6 i6 j6 k6 l6", "c6 b6 a6" ) ),
            Arguments.of( "c7", Arrays.asList( "c7 d7 i7 j7 k7 l7", "c7 b7 a7" ) ),
            Arguments.of( "c8", Arrays.asList( "c8 d8 i8 j8 k8 l8", "c8 b8 a8" ) ),
        
            Arguments.of( "d1", Arrays.asList( "d1 c1 b1 a1", "d1 e1 f1 g1 h1" ) ),
            Arguments.of( "d2", Arrays.asList( "d2 c2 b2 a2", "d2 e2 f2 g2 h2" ) ),
            Arguments.of( "d3", Arrays.asList( "d3 e3 f3 g3 h3", "d3 c3 b3 a3" ) ),
            Arguments.of( "d4", Arrays.asList( "d4 e4 f4 g4 h4", "d4 c4 b4 a4" ) ),
            Arguments.of( "d5", Arrays.asList( "d5 c5 b5 a5", "d5 i5 j5 k5 l5" ) ),
            Arguments.of( "d6", Arrays.asList( "d6 c6 b6 a6", "d6 i6 j6 k6 l6" ) ),
            Arguments.of( "d7", Arrays.asList( "d7 i7 j7 k7 l7", "d7 c7 b7 a7" ) ),
            Arguments.of( "d8", Arrays.asList( "d8 i8 j8 k8 l8", "d8 c8 b8 a8" ) ),
        
            Arguments.of( "e1", Arrays.asList( "e1 d1 c1 b1 a1", "e1 f1 g1 h1" ) ),
            Arguments.of( "e2", Arrays.asList( "e2 d2 c2 b2 a2", "e2 f2 g2 h2" ) ),
            Arguments.of( "e3", Arrays.asList( "e3 f3 g3 h3", "e3 d3 c3 b3 a3" ) ),
            Arguments.of( "e4", Arrays.asList( "e4 d4 c4 b4 a4", "e4 f4 g4 h4" ) ),
            Arguments.of( "e9", Arrays.asList( "e9 i9 j9 k9 l9", "e9 f9 g9 h9" ) ),
            Arguments.of( "e10", Arrays.asList( "e10 i10 j10 k10 l10", "e10 f10 g10 h10" ) ),
            Arguments.of( "e11", Arrays.asList( "e11 f11 g11 h11", "e11 i11 j11 k11 l11" ) ),
            Arguments.of( "e12", Arrays.asList( "e12 f12 g12 h12", "e12 i12 j12 k12 l12" ) ),
        
            Arguments.of( "f1", Arrays.asList( "f1 e1 d1 c1 b1 a1", "f1 g1 h1" ) ),
            Arguments.of( "f2", Arrays.asList( "f2 e2 d2 c2 b2 a2", "f2 g2 h2" ) ),
            Arguments.of( "f3", Arrays.asList( "f3 g3 h3", "f3 e3 d3 c3 b3 a3" ) ),
            Arguments.of( "f4", Arrays.asList( "f4 e4 d4 c4 b4 a4", "f4 g4 h4" ) ),
            Arguments.of( "f9", Arrays.asList( "f9 g9 h9", "f9 e9 i9 j9 k9 l9" ) ),
            Arguments.of( "f10", Arrays.asList( "f10 g10 h10", "f10 e10 i10 j10 k10 l10" ) ),
            Arguments.of( "f11", Arrays.asList( "f11 g11 h11", "f11 e11 i11 j11 k11 l11" ) ),
            Arguments.of( "f12", Arrays.asList( "f12 g12 h12", "f12 e12 i12 j12 k12 l12" ) ),
        
            Arguments.of( "g1", Arrays.asList( "g1 h1", "g1 f1 e1 d1 c1 b1 a1" ) ),
            Arguments.of( "g2", Arrays.asList( "g2 h2", "g2 f2 e2 d2 c2 b2 a2" ) ),
            Arguments.of( "g3", Arrays.asList( "g3 h3", "g3 f3 e3 d3 c3 b3 a3" ) ),
            Arguments.of( "g4", Arrays.asList( "g4 h4", "g4 f4 e4 d4 c4 b4 a4" ) ),
            Arguments.of( "g9", Arrays.asList( "g9 h9", "g9 f9 e9 i9 j9 k9 l9" ) ),
            Arguments.of( "g10", Arrays.asList( "g10 h10", "g10 f10 e10 i10 j10 k10 l10" ) ),
            Arguments.of( "g11", Arrays.asList( "g11 f11 e11 i11 j11 k11 l11", "g11 h11" ) ),
            Arguments.of( "g12", Arrays.asList( "g12 h12", "g12 f12 e12 i12 j12 k12 l12" ) ),
        
            Arguments.of( "h1", Arrays.asList( "h1 g1 f1 e1 d1 c1 b1 a1" ) ),
            Arguments.of( "h2", Arrays.asList( "h2 g2 f2 e2 d2 c2 b2 a2" ) ),
            Arguments.of( "h3", Arrays.asList( "h3 g3 f3 e3 d3 c3 b3 a3" ) ),
            Arguments.of( "h4", Arrays.asList( "h4 g4 f4 e4 d4 c4 b4 a4" ) ),
            Arguments.of( "h9", Arrays.asList( "h9 g9 f9 e9 i9 j9 k9 l9" ) ),
            Arguments.of( "h10", Arrays.asList( "h10 g10 f10 e10 i10 j10 k10 l10" ) ),
            Arguments.of( "h11", Arrays.asList( "h11 g11 f11 e11 i11 j11 k11 l11" ) ),
            Arguments.of( "h12", Arrays.asList( "h12 g12 f12 e12 i12 j12 k12 l12" ) ),
               
            Arguments.of( "i5", Arrays.asList( "i5 d5 c5 b5 a5", "i5 j5 k5 l5" ) ),
            Arguments.of( "i6", Arrays.asList( "i6 d6 c6 b6 a6", "i6 j6 k6 l6" ) ),
            Arguments.of( "i7", Arrays.asList( "i7 d7 c7 b7 a7", "i7 j7 k7 l7" ) ),
            Arguments.of( "i8", Arrays.asList( "i8 d8 c8 b8 a8", "i8 j8 k8 l8" ) ),
            Arguments.of( "i9", Arrays.asList( "i9 e9 f9 g9 h9", "i9 j9 k9 l9" ) ),
            Arguments.of( "i10", Arrays.asList( "i10 j10 k10 l10", "i10 e10 f10 g10 h10" ) ),
            Arguments.of( "i11", Arrays.asList( "i11 j11 k11 l11", "i11 e11 f11 g11 h11" ) ),
            Arguments.of( "i12", Arrays.asList( "i12 j12 k12 l12", "i12 e12 f12 g12 h12" ) ),
        
            Arguments.of( "j5", Arrays.asList( "j5 k5 l5", "j5 i5 d5 c5 b5 a5" ) ),
            Arguments.of( "j6", Arrays.asList( "j6 k6 l6", "j6 i6 d6 c6 b6 a6" ) ),
            Arguments.of( "j7", Arrays.asList( "j7 i7 d7 c7 b7 a7", "j7 k7 l7" ) ),
            Arguments.of( "j8", Arrays.asList( "j8 i8 d8 c8 b8 a8", "j8 k8 l8" ) ),
            Arguments.of( "j9", Arrays.asList( "j9 i9 e9 f9 g9 h9", "j9 k9 l9" ) ),
            Arguments.of( "j10", Arrays.asList( "j10 i10 e10 f10 g10 h10", "j10 k10 l10" ) ),
            Arguments.of( "j11", Arrays.asList( "j11 i11 e11 f11 g11 h11", "j11 k11 l11" ) ),
            Arguments.of( "j12", Arrays.asList( "j12 i12 e12 f12 g12 h12", "j12 k12 l12" ) ),
        
            Arguments.of( "k5", Arrays.asList( "k5 l5", "k5 j5 i5 d5 c5 b5 a5" ) ),
            Arguments.of( "k6", Arrays.asList( "k6 l6", "k6 j6 i6 d6 c6 b6 a6" ) ),
            Arguments.of( "k7", Arrays.asList( "k7 l7", "k7 j7 i7 d7 c7 b7 a7" ) ),
            Arguments.of( "k8", Arrays.asList( "k8 l8", "k8 j8 i8 d8 c8 b8 a8" ) ),
            Arguments.of( "k9", Arrays.asList( "k9 l9", "k9 j9 i9 e9 f9 g9 h9" ) ),
            Arguments.of( "k10", Arrays.asList( "k10 l10", "k10 j10 i10 e10 f10 g10 h10" ) ),
            Arguments.of( "k11", Arrays.asList( "k11 l11", "k11 j11 i11 e11 f11 g11 h11" ) ),
            Arguments.of( "k12", Arrays.asList( "k12 l12", "k12 j12 i12 e12 f12 g12 h12" ) ),
        
            Arguments.of( "l5", Arrays.asList( "l5 k5 j5 i5 d5 c5 b5 a5" ) ),
            Arguments.of( "l6", Arrays.asList( "l6 k6 j6 i6 d6 c6 b6 a6" ) ),
            Arguments.of( "l7", Arrays.asList( "l7 k7 j7 i7 d7 c7 b7 a7" ) ),
            Arguments.of( "l8", Arrays.asList( "l8 k8 j8 i8 d8 c8 b8 a8" ) ),
            Arguments.of( "l9", Arrays.asList( "l9 k9 j9 i9 e9 f9 g9 h9" ) ),
            Arguments.of( "l10", Arrays.asList( "l10 k10 j10 i10 e10 f10 g10 h10" ) ),
            Arguments.of( "l11", Arrays.asList( "l11 k11 j11 i11 e11 f11 g11 h11" ) ),
            Arguments.of( "l12", Arrays.asList( "l12 k12 j12 i12 e12 f12 g12 h12" ) )
        
        ); }
}

