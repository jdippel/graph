/*
 *  ICoordinate_GetLineBundles_TripleBoardByRectangles.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2016 - 2019 Jörg Dippel
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
 * The class ICoordinate_GetLineBundles_TripleBoardByRectangles implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method Set<List<String>> getLineBundles() for class ICoordinate_GetLineBundles_TripleBoardByRectangles is tested")
public class ICoordinate_GetLineBundles_TripleBoardByRectangles extends ICoordinate_GetLineBundles_Wrapper { 

    final static ICoordinate   BOARD =     ICoordinateFactory.TRIPLE.get( );
    final static Direction     DIRECTION = ( Direction ) null;
    final static AdjacencyEnum ADJACENCY = ( AdjacencyEnum ) null;
    
    
    @ParameterizedTest( name = "given a standard board from location {0} there will be lines {1} to walk along" )
    @MethodSource("stringAndListProvider")
    public void testWithMultiArgMethodSource( String origin, List<String> expectedResultList ) {
        assertTrue( testOfArguments( BOARD, origin, DIRECTION, ADJACENCY, expectedResultList ) );
    }

    public static Stream<Arguments> stringAndListProvider() {
        return Stream.of(
            
            Arguments.of( "a1", Arrays.asList( "a1 b1 c1 d1 e1 f1 g1 h1", "a1 a2 a3 a4 a5 a6 a7 a8", "a1 b2 c3 d4 i5 j6 k7 l8", "a1 b2 c3 d4 e9 f10 g11 h12", "a1 c2", "a1 b3" ) ),
            Arguments.of( "a2", Arrays.asList( "a2 b2 c2 d2 e2 f2 g2 h2", "a1 a2 a3 a4 a5 a6 a7 a8", "b1 a2", "a2 b3 c4 d5 i6 j7 k8", "a2 c1", "a2 c3", "a2 b4" ) ),
            Arguments.of( "a3", Arrays.asList( "a3 b3 c3 d3 e3 f3 g3 h3", "a1 a2 a3 a4 a5 a6 a7 a8", "c1 b2 a3", "a3 b4 c5 d6 i7 j8", "a3 b1", "a3 c2", "a3 c4", "a3 b5" ) ),
            Arguments.of( "a4", Arrays.asList( "a4 b4 c4 d4 e4 f4 g4 h4", "a1 a2 a3 a4 a5 a6 a7 a8", "d1 c2 b3 a4", "a4 b5 c6 d7 i8", "a4 b2", "a4 c3", "a4 c5", "a4 b6" ) ),
            Arguments.of( "a5", Arrays.asList( "a5 b5 c5 d5 i5 j5 k5 l5", "a1 a2 a3 a4 a5 a6 a7 a8", "e1 d2 c3 b4 a5", "a5 b6 c7 d8", "a5 b3", "a5 c4", "a5 c6", "a5 b7" ) ),
            Arguments.of( "a6", Arrays.asList( "a6 b6 c6 d6 i6 j6 k6 l6", "a1 a2 a3 a4 a5 a6 a7 a8", "f1 e2 d3 c4 b5 a6", "a6 b7 c8", "a6 b4", "a6 c5", "a6 c7", "a6 b8" ) ),
            Arguments.of( "a7", Arrays.asList( "a7 b7 c7 d7 i7 j7 k7 l7", "a1 a2 a3 a4 a5 a6 a7 a8", "g1 f2 e3 d4 c5 b6 a7", "a7 b8", "a7 c6", "a7 b5", "a7 c8" ) ),
            Arguments.of( "a8", Arrays.asList( "a8 b8 c8 d8 i8 j8 k8 l8", "a1 a2 a3 a4 a5 a6 a7 a8", "h1 g2 f3 e4 d5 c6 b7 a8", "a8 b7 c6 d5 i9 j10 k11 l12", "a8 c7", "a8 b6" ) ),
        
            Arguments.of( "b1", Arrays.asList( "a1 b1 c1 d1 e1 f1 g1 h1", "b1 b2 b3 b4 b5 b6 b7 b8", "b1 a2", "b1 c2 d3 e4 f9 g10 h11", "b1 d2", "b1 c3", "a3 b1" ) ),
            Arguments.of( "b2", Arrays.asList( "a2 b2 c2 d2 e2 f2 g2 h2", "b1 b2 b3 b4 b5 b6 b7 b8", "a1 b2 c3 d4 i5 j6 k7 l8", "c1 b2 a3", "a1 b2 c3 d4 e9 f10 g11 h12", "b2 c4", "b2 d3", "b2 d1", "a4 b2" ) ),
            Arguments.of( "b3", Arrays.asList( "a3 b3 c3 d3 e3 f3 g3 h3", "b1 b2 b3 b4 b5 b6 b7 b8", "a2 b3 c4 d5 i6 j7 k8", "d1 c2 b3 a4", "b3 c5", "a1 b3", "b3 d4", "b3 c1", "b3 d2", "a5 b3" ) ),
            Arguments.of( "b4", Arrays.asList( "a4 b4 c4 d4 e4 f4 g4 h4", "b1 b2 b3 b4 b5 b6 b7 b8", "a3 b4 c5 d6 i7 j8", "e1 d2 c3 b4 a5", "b4 c6", "b4 d5", "b4 c2", "b4 d3", "a6 b4", "a2 b4" ) ),
            Arguments.of( "b5", Arrays.asList( "a5 b5 c5 d5 i5 j5 k5 l5", "b1 b2 b3 b4 b5 b6 b7 b8", "a4 b5 c6 d7 i8", "f1 e2 d3 c4 b5 a6", "b5 c7", "b5 d6", "b5 c3", "b5 d4", "a7 b5", "a3 b5" ) ),
            Arguments.of( "b6", Arrays.asList( "a6 b6 c6 d6 i6 j6 k6 l6", "b1 b2 b3 b4 b5 b6 b7 b8", "a5 b6 c7 d8", "g1 f2 e3 d4 c5 b6 a7", "b6 c8", "b6 d7", "b6 c4", "b6 d5", "a8 b6", "a4 b6" ) ),
            Arguments.of( "b7", Arrays.asList( "a7 b7 c7 d7 i7 j7 k7 l7", "b1 b2 b3 b4 b5 b6 b7 b8", "a6 b7 c8", "h1 g2 f3 e4 d5 c6 b7 a8", "a8 b7 c6 d5 i9 j10 k11 l12", "b7 d6", "b7 c5", "b7 d8", "a5 b7" ) ),
            Arguments.of( "b8", Arrays.asList( "a8 b8 c8 d8 i8 j8 k8 l8", "b1 b2 b3 b4 b5 b6 b7 b8", "a7 b8", "b8 c7 d6 i5 j9 k10 l11", "b8 d7", "b8 c6", "a6 b8" ) ),
        
            Arguments.of( "c1", Arrays.asList( "a1 b1 c1 d1 e1 f1 g1 h1", "c1 c2 c3 c4 c5 c6 c7 c8", "c1 b2 a3", "c1 d2 e3 f4 g9 h10", "b3 c1", "c1 d3", "c1 e2", "a2 c1" ) ),
            Arguments.of( "c2", Arrays.asList( "a2 b2 c2 d2 e2 f2 g2 h2", "c1 c2 c3 c4 c5 c6 c7 c8", "d1 c2 b3 a4", "b1 c2 d3 e4 f9 g10 h11", "c2 e3", "c2 d4", "a1 c2", "b4 c2", "c2 e1", "a3 c2" ) ),
            Arguments.of( "c3", Arrays.asList( "a3 b3 c3 d3 e3 f3 g3 h3", "c1 c2 c3 c4 c5 c6 c7 c8", "a1 b2 c3 d4 i5 j6 k7 l8", "a1 b2 c3 d4 e9 f10 g11 h12", "e1 d2 c3 b4 a5", "c3 e4", "c3 d5", "c3 d1", "c3 e2", "a4 c3", "a2 c3", "b1 c3", "b5 c3" ) ),
            Arguments.of( "c4", Arrays.asList( "a4 b4 c4 d4 e4 f4 g4 h4", "c1 c2 c3 c4 c5 c6 c7 c8", "f1 e2 d3 c4 b5 a6", "a2 b3 c4 d5 i6 j7 k8", "c4 d6", "c4 i5", "c4 d2", "c4 e3", "a5 c4", "a3 c4", "c4 e9", "b2 c4", "b6 c4" ) ),
            Arguments.of( "c5", Arrays.asList( "a5 b5 c5 d5 i5 j5 k5 l5", "c1 c2 c3 c4 c5 c6 c7 c8", "g1 f2 e3 d4 c5 b6 a7", "a3 b4 c5 d6 i7 j8", "c5 d7", "c5 i6", "c5 i9", "c5 d3", "c5 e4", "a6 c5", "a4 c5", "b3 c5", "b7 c5" ) ),
            Arguments.of( "c6", Arrays.asList( "a6 b6 c6 d6 i6 j6 k6 l6", "c1 c2 c3 c4 c5 c6 c7 c8", "a4 b5 c6 d7 i8", "h1 g2 f3 e4 d5 c6 b7 a8", "a8 b7 c6 d5 i9 j10 k11 l12", "c6 d8", "c6 d4", "c6 i7", "a7 c6", "a5 c6", "b4 c6", "c6 i5", "b8 c6" ) ),
            Arguments.of( "c7", Arrays.asList( "a7 b7 c7 d7 i7 j7 k7 l7", "c1 c2 c3 c4 c5 c6 c7 c8", "a5 b6 c7 d8", "b8 c7 d6 i5 j9 k10 l11", "b5 c7", "c7 d5", "c7 i8", "a8 c7", "c7 i6", "a6 c7" ) ),
            Arguments.of( "c8", Arrays.asList( "a8 b8 c8 d8 i8 j8 k8 l8", "c1 c2 c3 c4 c5 c6 c7 c8", "a6 b7 c8", "c8 d7 i6 j5 k9 l10", "b6 c8", "c8 d6", "c8 i7", "a7 c8" ) ),
        
            Arguments.of( "d1", Arrays.asList( "a1 b1 c1 d1 e1 f1 g1 h1", "d1 d2 d3 d4 d5 d6 d7 d8", "d1 c2 b3 a4", "d1 e2 f3 g4 h9", "b2 d1", "d1 f2", "c3 d1", "d1 e3" ) ),
            Arguments.of( "d2", Arrays.asList( "a2 b2 c2 d2 e2 f2 g2 h2", "d1 d2 d3 d4 d5 d6 d7 d8", "e1 d2 c3 b4 a5", "c1 d2 e3 f4 g9 h10", "d2 f1", "b1 d2", "b3 d2", "d2 e4", "d2 f3", "c4 d2" ) ),
            Arguments.of( "d3", Arrays.asList( "a3 b3 c3 d3 e3 f3 g3 h3", "d1 d2 d3 d4 d5 d6 d7 d8", "f1 e2 d3 c4 b5 a6", "b1 c2 d3 e4 f9 g10 h11", "d3 e1", "d3 f2", "b2 d3", "c1 d3", "b4 d3", "d3 f4", "c5 d3", "d3 e9" ) ),
            Arguments.of( "d4", Arrays.asList( "a4 b4 c4 d4 e4 f4 g4 h4", "d1 d2 d3 d4 d5 d6 d7 d8", "g1 f2 e3 d4 c5 b6 a7", "a1 b2 c3 d4 i5 j6 k7 l8", "a1 b2 c3 d4 e9 f10 g11 h12", "c2 d4", "c6 d4", "d4 e2", "d4 f3", "d4 i6", "b3 d4", "d4 j5", "b5 d4", "d4 e10", "d4 f9" ) ),
            Arguments.of( "d5", Arrays.asList( "a5 b5 c5 d5 i5 j5 k5 l5", "d1 d2 d3 d4 d5 d6 d7 d8", "h1 g2 f3 e4 d5 c6 b7 a8", "a2 b3 c4 d5 i6 j7 k8", "a8 b7 c6 d5 i9 j10 k11 l12", "c3 d5", "c7 d5", "d5 j9", "d5 e3", "d5 f4", "d5 i7", "b4 d5", "d5 j6", "b6 d5" ) ),
            Arguments.of( "d6", Arrays.asList( "a6 b6 c6 d6 i6 j6 k6 l6", "d1 d2 d3 d4 d5 d6 d7 d8", "a3 b4 c5 d6 i7 j8", "b8 c7 d6 i5 j9 k10 l11", "c4 d6", "c8 d6", "d6 j5", "b5 d6", "d6 j7", "d6 i8", "d6 e4", "d6 i9", "b7 d6" ) ),
            Arguments.of( "d7", Arrays.asList( "a7 b7 c7 d7 i7 j7 k7 l7", "d1 d2 d3 d4 d5 d6 d7 d8", "a4 b5 c6 d7 i8", "c8 d7 i6 j5 k9 l10", "c5 d7", "b6 d7", "d7 j8", "b8 d7", "d7 j6", "d7 i5" ) ),
            Arguments.of( "d8", Arrays.asList( "a8 b8 c8 d8 i8 j8 k8 l8", "d1 d2 d3 d4 d5 d6 d7 d8", "a5 b6 c7 d8", "d8 i7 j6 k5 l9", "c6 d8", "d8 j7", "d8 i6", "b7 d8" ) ),
        
            Arguments.of( "e1", Arrays.asList( "a1 b1 c1 d1 e1 f1 g1 h1", "e1 e2 e3 e4 e9 e10 e11 e12", "e1 d2 c3 b4 a5", "e1 f2 g3 h4", "c2 e1", "e1 f3", "d3 e1", "e1 g2" ) ),
            Arguments.of( "e2", Arrays.asList( "a2 b2 c2 d2 e2 f2 g2 h2", "e1 e2 e3 e4 e9 e10 e11 e12", "f1 e2 d3 c4 b5 a6", "d1 e2 f3 g4 h9", "d4 e2", "e2 g1", "e2 g3", "c3 e2", "e2 f4", "c1 e2" ) ),
            Arguments.of( "e3", Arrays.asList( "a3 b3 c3 d3 e3 f3 g3 h3", "e1 e2 e3 e4 e9 e10 e11 e12", "c1 d2 e3 f4 g9 h10", "g1 f2 e3 d4 c5 b6 a7", "c2 e3", "d5 e3", "e3 f1", "e3 g2", "e3 g4", "d1 e3", "c4 e3", "e3 f9" ) ),
            Arguments.of( "e4", Arrays.asList( "a4 b4 c4 d4 e4 f4 g4 h4", "e1 e2 e3 e4 e9 e10 e11 e12", "h1 g2 f3 e4 d5 c6 b7 a8", "h1 g2 f3 e4 i9 j10 k11 l12", "b1 c2 d3 e4 f9 g10 h11", "c3 e4", "e4 f2", "e4 g3", "e4 j9", "e4 f10", "c5 e4", "e4 g9", "d2 e4", "d6 e4", "e4 i10" ) ),
            Arguments.of( "e9", Arrays.asList( "h9 g9 f9 e9 i9 j9 k9 l9", "e1 e2 e3 e4 e9 e10 e11 e12", "a1 b2 c3 d4 e9 f10 g11 h12", "h2 g3 f4 e9 i10 j11 k12", "l8 k7 j6 i5 e9 f10 g11 h12", "e9 f11", "e9 g10", "e9 i11", "e9 j10", "c4 e9", "d3 e9", "e9 f3", "e9 g4", "e9 i6", "e9 j5" ) ),
            Arguments.of( "e10", Arrays.asList( "h10 g10 f10 e10 i10 j10 k10 l10", "e1 e2 e3 e4 e9 e10 e11 e12", "h3 g4 f9 e10 i11 j12", "l7 k6 j5 i9 e10 f11 g12", "e10 j9", "e10 f4", "e10 i5", "e10 f12", "e10 g11", "e10 i12", "e10 j11", "e10 g9", "d4 e10" ) ),
            Arguments.of( "e11", Arrays.asList( "h11 g11 f11 e11 i11 j11 k11 l11", "e1 e2 e3 e4 e9 e10 e11 e12", "h4 g9 f10 e11 i12", "l6 k5 j9 i10 e11 f12", "e11 i9", "e11 j10", "e11 g12", "e11 g10", "e11 j12", "e11 f9" ) ),
            Arguments.of( "e12", Arrays.asList( "h12 g12 f12 e12 i12 j12 k12 l12", "e1 e2 e3 e4 e9 e10 e11 e12", "h9 g10 f11 e12", "l5 k9 j10 i11 e12", "e12 g11", "e12 f10", "e12 i10", "e12 j11" ) ),
        
            Arguments.of( "f1", Arrays.asList( "a1 b1 c1 d1 e1 f1 g1 h1", "f1 f2 f3 f4 f9 f10 f11 f12", "f1 e2 d3 c4 b5 a6", "f1 g2 h3", "d2 f1", "e3 f1", "f1 g3", "f1 h2" ) ),
            Arguments.of( "f2", Arrays.asList( "a2 b2 c2 d2 e2 f2 g2 h2", "f1 f2 f3 f4 f9 f10 f11 f12", "g1 f2 e3 d4 c5 b6 a7", "e1 f2 g3 h4", "d3 f2", "e4 f2", "d1 f2", "f2 g4", "f2 h3", "f2 h1" ) ),
            Arguments.of( "f3", Arrays.asList( "a3 b3 c3 d3 e3 f3 g3 h3", "f1 f2 f3 f4 f9 f10 f11 f12", "h1 g2 f3 e4 d5 c6 b7 a8", "d1 e2 f3 g4 h9", "h1 g2 f3 e4 i9 j10 k11 l12", "f3 g9", "f3 h4", "f3 g1", "f3 h2", "d4 f3", "d2 f3", "e1 f3", "e9 f3" ) ),
            Arguments.of( "f4", Arrays.asList( "a4 b4 c4 d4 e4 f4 g4 h4", "f1 f2 f3 f4 f9 f10 f11 f12", "c1 d2 e3 f4 g9 h10", "h2 g3 f4 e9 i10 j11 k12", "e10 f4", "e2 f4", "f4 h9", "f4 i9", "f4 g2", "f4 h3", "d5 f4", "f4 g10", "d3 f4" ) ),
            Arguments.of( "f9", Arrays.asList( "h9 g9 f9 e9 i9 j9 k9 l9", "f1 f2 f3 f4 f9 f10 f11 f12", "b1 c2 d3 e4 f9 g10 h11", "h3 g4 f9 e10 i11 j12", "e3 f9", "f9 g3", "f9 h4", "e11 f9", "f9 i5", "f9 g11", "f9 h10", "f9 i10", "d4 f9" ) ),
            Arguments.of( "f10", Arrays.asList( "h10 g10 f10 e10 i10 j10 k10 l10", "f1 f2 f3 f4 f9 f10 f11 f12", "a1 b2 c3 d4 e9 f10 g11 h12", "h4 g9 f10 e11 i12", "l8 k7 j6 i5 e9 f10 g11 h12", "e4 f10", "e12 f10", "f10 g12", "f10 h11", "f10 i11", "f10 g4", "f10 i9", "f10 h9" ) ),
            Arguments.of( "f11", Arrays.asList( "h11 g11 f11 e11 i11 j11 k11 l11", "f1 f2 f3 f4 f9 f10 f11 f12", "l7 k6 j5 i9 e10 f11 g12", "h9 g10 f11 e12", "f11 h10", "f11 i10", "e9 f11", "f11 h12", "f11 i12", "f11 g9" ) ),
            Arguments.of( "f12", Arrays.asList( "h12 g12 f12 e12 i12 j12 k12 l12", "f1 f2 f3 f4 f9 f10 f11 f12", "h10 g11 f12", "l6 k5 j9 i10 e11 f12", "f12 g10", "f12 h11", "f12 i11", "e10 f12" ) ),
        
            Arguments.of( "g1", Arrays.asList( "a1 b1 c1 d1 e1 f1 g1 h1", "g1 g2 g3 g4 g9 g10 g11 g12", "g1 h2", "g1 f2 e3 d4 c5 b6 a7", "e2 g1", "g1 h3", "f3 g1" ) ),
            Arguments.of( "g2", Arrays.asList( "a2 b2 c2 d2 e2 f2 g2 h2", "g1 g2 g3 g4 g9 g10 g11 g12", "h1 g2 f3 e4 i9 j10 k11 l12", "f1 g2 h3", "h1 g2 f3 e4 d5 c6 b7 a8", "e3 g2", "g2 h4", "e1 g2", "f4 g2" ) ),
            Arguments.of( "g3", Arrays.asList( "a3 b3 c3 d3 e3 f3 g3 h3", "g1 g2 g3 g4 g9 g10 g11 g12", "h2 g3 f4 e9 i10 j11 k12", "e1 f2 g3 h4", "e4 g3", "e2 g3", "g3 h9", "f1 g3", "g3 h1", "f9 g3" ) ),
            Arguments.of( "g4", Arrays.asList( "a4 b4 c4 d4 e4 f4 g4 h4", "g1 g2 g3 g4 g9 g10 g11 g12", "h3 g4 f9 e10 i11 j12", "d1 e2 f3 g4 h9", "e3 g4", "f2 g4", "f10 g4", "g4 h10", "e9 g4", "g4 h2" ) ),
            Arguments.of( "g9", Arrays.asList( "h9 g9 f9 e9 i9 j9 k9 l9", "g1 g2 g3 g4 g9 g10 g11 g12", "c1 d2 e3 f4 g9 h10", "h4 g9 f10 e11 i12", "g9 h3", "f3 g9", "e4 g9", "f11 g9", "g9 h11", "e10 g9" ) ),
            Arguments.of( "g10", Arrays.asList( "h10 g10 f10 e10 i10 j10 k10 l10", "g1 g2 g3 g4 g9 g10 g11 g12", "b1 c2 d3 e4 f9 g10 h11", "h9 g10 f11 e12", "f4 g10", "f12 g10", "e9 g10", "e11 g10", "g10 h4", "g10 h12" ) ),
            Arguments.of( "g11", Arrays.asList( "h11 g11 f11 e11 i11 j11 k11 l11", "g1 g2 g3 g4 g9 g10 g11 g12", "l8 k7 j6 i5 e9 f10 g11 h12", "h10 g11 f12", "a1 b2 c3 d4 e9 f10 g11 h12", "f9 g11", "g11 h9", "e12 g11", "e10 g11" ) ),
            Arguments.of( "g12", Arrays.asList( "h12 g12 f12 e12 i12 j12 k12 l12", "g1 g2 g3 g4 g9 g10 g11 g12", "l7 k6 j5 i9 e10 f11 g12", "h11 g12", "g12 h10", "f10 g12", "e11 g12" ) ),
        
            Arguments.of( "h1", Arrays.asList( "a1 b1 c1 d1 e1 f1 g1 h1", "h1 h2 h3 h4 h9 h10 h11 h12", "h1 g2 f3 e4 d5 c6 b7 a8", "h1 g2 f3 e4 i9 j10 k11 l12", "f2 h1", "g3 h1" ) ),
            Arguments.of( "h2", Arrays.asList( "a2 b2 c2 d2 e2 f2 g2 h2", "h1 h2 h3 h4 h9 h10 h11 h12", "g1 h2", "h2 g3 f4 e9 i10 j11 k12", "f1 h2", "f3 h2", "g4 h2" ) ),
            Arguments.of( "h3", Arrays.asList( "a3 b3 c3 d3 e3 f3 g3 h3", "h1 h2 h3 h4 h9 h10 h11 h12", "h3 g4 f9 e10 i11 j12", "f1 g2 h3", "g9 h3", "g1 h3", "f2 h3", "f4 h3" ) ),
            Arguments.of( "h4", Arrays.asList( "a4 b4 c4 d4 e4 f4 g4 h4", "h1 h2 h3 h4 h9 h10 h11 h12", "h4 g9 f10 e11 i12", "e1 f2 g3 h4", "g2 h4", "f3 h4", "g10 h4", "f9 h4" ) ),
            Arguments.of( "h9", Arrays.asList( "h9 g9 f9 e9 i9 j9 k9 l9", "h1 h2 h3 h4 h9 h10 h11 h12", "d1 e2 f3 g4 h9", "h9 g10 f11 e12", "g11 h9", "g3 h9", "f4 h9", "f10 h9" ) ),
            Arguments.of( "h10", Arrays.asList( "h10 g10 f10 e10 i10 j10 k10 l10", "h1 h2 h3 h4 h9 h10 h11 h12", "c1 d2 e3 f4 g9 h10", "h10 g11 f12", "f11 h10", "f9 h10", "g12 h10", "g4 h10" ) ),
            Arguments.of( "h11", Arrays.asList( "h11 g11 f11 e11 i11 j11 k11 l11", "h1 h2 h3 h4 h9 h10 h11 h12", "b1 c2 d3 e4 f9 g10 h11", "h11 g12", "f12 h11", "f10 h11", "g9 h11" ) ),
            Arguments.of( "h12", Arrays.asList( "h12 g12 f12 e12 i12 j12 k12 l12", "h1 h2 h3 h4 h9 h10 h11 h12", "l8 k7 j6 i5 e9 f10 g11 h12", "a1 b2 c3 d4 e9 f10 g11 h12", "f11 h12", "g10 h12" ) ),
               
            Arguments.of( "i5", Arrays.asList( "a5 b5 c5 d5 i5 j5 k5 l5", "i8 i7 i6 i5 i9 i10 i11 i12", "a1 b2 c3 d4 i5 j6 k7 l8", "b8 c7 d6 i5 j9 k10 l11", "l8 k7 j6 i5 e9 f10 g11 h12", "c4 i5", "e10 i5", "d7 i5", "f9 i5", "c6 i5", "i5 j10", "i5 j7", "i5 k9", "i5 k6" ) ),
            Arguments.of( "i6", Arrays.asList( "a6 b6 c6 d6 i6 j6 k6 l6", "i8 i7 i6 i5 i9 i10 i11 i12", "a2 b3 c4 d5 i6 j7 k8", "c8 d7 i6 j5 k9 l10", "d8 i6", "d4 i6", "c7 i6", "i6 k5", "i6 j8", "i6 j9", "e9 i6", "i6 k7", "c5 i6" ) ),
            Arguments.of( "i7", Arrays.asList( "a7 b7 c7 d7 i7 j7 k7 l7", "i8 i7 i6 i5 i9 i10 i11 i12", "d8 i7 j6 k5 l9", "a3 b4 c5 d6 i7 j8", "d5 i7", "c6 i7", "c8 i7", "i7 k6", "i7 j5", "i7 k8" ) ),
            Arguments.of( "i8", Arrays.asList( "a8 b8 c8 d8 i8 j8 k8 l8", "i8 i7 i6 i5 i9 i10 i11 i12", "a4 b5 c6 d7 i8", "i8 j7 k6 l5", "d6 i8", "c7 i8", "i8 k7", "i8 j6" ) ),
            Arguments.of( "i9", Arrays.asList( "h9 g9 f9 e9 i9 j9 k9 l9", "i8 i7 i6 i5 i9 i10 i11 i12", "h1 g2 f3 e4 i9 j10 k11 l12", "a8 b7 c6 d5 i9 j10 k11 l12", "l7 k6 j5 i9 e10 f11 g12", "e11 i9", "i9 k5", "c5 i9", "f4 i9", "i9 j11", "i9 k10", "d6 i9", "f10 i9", "i9 j6" ) ),
            Arguments.of( "i10", Arrays.asList( "h10 g10 f10 e10 i10 j10 k10 l10", "i8 i7 i6 i5 i9 i10 i11 i12", "h2 g3 f4 e9 i10 j11 k12", "l6 k5 j9 i10 e11 f12", "f11 i10", "f9 i10", "i10 j5", "e4 i10", "i10 k9", "e12 i10", "i10 j12", "i10 k11" ) ),
            Arguments.of( "i11", Arrays.asList( "h11 g11 f11 e11 i11 j11 k11 l11", "i8 i7 i6 i5 i9 i10 i11 i12", "h3 g4 f9 e10 i11 j12", "l5 k9 j10 i11 e12", "f12 i11", "f10 i11", "e9 i11", "i11 j9", "i11 k10", "i11 k12" ) ),
            Arguments.of( "i12", Arrays.asList( "h12 g12 f12 e12 i12 j12 k12 l12", "i8 i7 i6 i5 i9 i10 i11 i12", "l9 k10 j11 i12", "h4 g9 f10 e11 i12", "f11 i12", "i12 k11", "i12 j10", "e10 i12" ) ),
        
            Arguments.of( "j5", Arrays.asList( "a5 b5 c5 d5 i5 j5 k5 l5", "j8 j7 j6 j5 j9 j10 j11 j12", "c8 d7 i6 j5 k9 l10", "l7 k6 j5 i9 e10 f11 g12", "i10 j5", "d6 j5", "j5 l6", "j5 k7", "j5 l9", "j5 k10", "d4 j5", "i7 j5", "e9 j5" ) ),
            Arguments.of( "j6", Arrays.asList( "a6 b6 c6 d6 i6 j6 k6 l6", "j8 j7 j6 j5 j9 j10 j11 j12", "d8 i7 j6 k5 l9", "a1 b2 c3 d4 i5 j6 k7 l8", "l8 k7 j6 i5 e9 f10 g11 h12", "d7 j6", "j6 l5", "j6 l7", "j6 k8", "j6 k9", "d5 j6", "i8 j6", "i9 j6" ) ),
            Arguments.of( "j7", Arrays.asList( "a7 b7 c7 d7 i7 j7 k7 l7", "j8 j7 j6 j5 j9 j10 j11 j12", "i8 j7 k6 l5", "a2 b3 c4 d5 i6 j7 k8", "d6 j7", "d8 j7", "j7 l6", "j7 k5", "i5 j7", "j7 l8" ) ),
            Arguments.of( "j8", Arrays.asList( "a8 b8 c8 d8 i8 j8 k8 l8", "j8 j7 j6 j5 j9 j10 j11 j12", "j8 k7 l6", "a3 b4 c5 d6 i7 j8", "d7 j8", "j8 l7", "j8 k6", "i6 j8" ) ),
            Arguments.of( "j9", Arrays.asList( "h9 g9 f9 e9 i9 j9 k9 l9", "j8 j7 j6 j5 j9 j10 j11 j12", "b8 c7 d6 i5 j9 k10 l11", "l6 k5 j9 i10 e11 f12", "e10 j9", "e4 j9", "j9 k6", "j9 k11", "j9 l10", "d5 j9", "j9 l5", "i11 j9", "i6 j9" ) ),
            Arguments.of( "j10", Arrays.asList( "h10 g10 f10 e10 i10 j10 k10 l10", "j8 j7 j6 j5 j9 j10 j11 j12", "h1 g2 f3 e4 i9 j10 k11 l12", "a8 b7 c6 d5 i9 j10 k11 l12", "l5 k9 j10 i11 e12", "j10 k12", "j10 l11", "e9 j10", "i12 j10", "j10 l9", "j10 k5", "e11 j10", "i5 j10" ) ),
            Arguments.of( "j11", Arrays.asList( "h11 g11 f11 e11 i11 j11 k11 l11", "j8 j7 j6 j5 j9 j10 j11 j12", "l9 k10 j11 i12", "h2 g3 f4 e9 i10 j11 k12", "i9 j11", "j11 k9", "j11 l10", "j11 l12", "e10 j11", "e12 j11" ) ),
            Arguments.of( "j12", Arrays.asList( "h12 g12 f12 e12 i12 j12 k12 l12", "j8 j7 j6 j5 j9 j10 j11 j12", "l10 k11 j12", "h3 g4 f9 e10 i11 j12", "j12 k10", "j12 l11", "e11 j12", "i10 j12" ) ),
        
            Arguments.of( "k5", Arrays.asList( "a5 b5 c5 d5 i5 j5 k5 l5", "k8 k7 k6 k5 k9 k10 k11 k12", "d8 i7 j6 k5 l9", "l6 k5 j9 i10 e11 f12", "k5 l7", "j10 k5", "i9 k5", "k5 l10", "i6 k5", "j7 k5" ) ),
            Arguments.of( "k6", Arrays.asList( "a6 b6 c6 d6 i6 j6 k6 l6", "k8 k7 k6 k5 k9 k10 k11 k12", "i8 j7 k6 l5", "l7 k6 j5 i9 e10 f11 g12", "j9 k6", "j8 k6", "i5 k6", "k6 l8", "k6 l9", "i7 k6" ) ),
            Arguments.of( "k7", Arrays.asList( "a7 b7 c7 d7 i7 j7 k7 l7", "k8 k7 k6 k5 k9 k10 k11 k12", "a1 b2 c3 d4 i5 j6 k7 l8", "j8 k7 l6", "l8 k7 j6 i5 e9 f10 g11 h12", "k7 l5", "i8 k7", "j5 k7", "i6 k7" ) ),
            Arguments.of( "k8", Arrays.asList( "a8 b8 c8 d8 i8 j8 k8 l8", "k8 k7 k6 k5 k9 k10 k11 k12", "k8 l7", "a2 b3 c4 d5 i6 j7 k8", "k8 l6", "j6 k8", "i7 k8" ) ),
            Arguments.of( "k9", Arrays.asList( "h9 g9 f9 e9 i9 j9 k9 l9", "k8 k7 k6 k5 k9 k10 k11 k12", "c8 d7 i6 j5 k9 l10", "l5 k9 j10 i11 e12", "k9 l11", "i10 k9", "k9 l6", "i5 k9", "j6 k9", "j11 k9" ) ),
            Arguments.of( "k10", Arrays.asList( "h10 g10 f10 e10 i10 j10 k10 l10", "k8 k7 k6 k5 k9 k10 k11 k12", "l9 k10 j11 i12", "b8 c7 d6 i5 j9 k10 l11", "j5 k10", "i9 k10", "j12 k10", "k10 l5", "i11 k10", "k10 l12" ) ),
            Arguments.of( "k11", Arrays.asList( "h11 g11 f11 e11 i11 j11 k11 l11", "k8 k7 k6 k5 k9 k10 k11 k12", "l10 k11 j12", "a8 b7 c6 d5 i9 j10 k11 l12", "h1 g2 f3 e4 i9 j10 k11 l12", "i12 k11", "j9 k11", "i10 k11", "k11 l9" ) ),
            Arguments.of( "k12", Arrays.asList( "h12 g12 f12 e12 i12 j12 k12 l12", "k8 k7 k6 k5 k9 k10 k11 k12", "h2 g3 f4 e9 i10 j11 k12", "l11 k12", "k12 l10", "j10 k12", "i11 k12" ) ),
        
            Arguments.of( "l5", Arrays.asList( "a5 b5 c5 d5 i5 j5 k5 l5", "l8 l7 l6 l5 l9 l10 l11 l12", "l5 k9 j10 i11 e12", "i8 j7 k6 l5", "j9 l5", "k7 l5", "k10 l5", "j6 l5" ) ),
            Arguments.of( "l6", Arrays.asList( "a6 b6 c6 d6 i6 j6 k6 l6", "l8 l7 l6 l5 l9 l10 l11 l12", "j8 k7 l6", "l6 k5 j9 i10 e11 f12", "k8 l6", "k9 l6", "j7 l6", "j5 l6" ) ),
            Arguments.of( "l7", Arrays.asList( "a7 b7 c7 d7 i7 j7 k7 l7", "l8 l7 l6 l5 l9 l10 l11 l12", "k8 l7", "l7 k6 j5 i9 e10 f11 g12", "k5 l7", "j8 l7", "j6 l7" ) ),
            Arguments.of( "l8", Arrays.asList( "a8 b8 c8 d8 i8 j8 k8 l8", "l8 l7 l6 l5 l9 l10 l11 l12", "a1 b2 c3 d4 i5 j6 k7 l8", "l8 k7 j6 i5 e9 f10 g11 h12", "k6 l8", "j7 l8" ) ),
            Arguments.of( "l9", Arrays.asList( "h9 g9 f9 e9 i9 j9 k9 l9", "l8 l7 l6 l5 l9 l10 l11 l12", "d8 i7 j6 k5 l9", "l9 k10 j11 i12", "j10 l9", "k6 l9", "k11 l9", "j5 l9" ) ),
            Arguments.of( "l10", Arrays.asList( "h10 g10 f10 e10 i10 j10 k10 l10", "l8 l7 l6 l5 l9 l10 l11 l12", "c8 d7 i6 j5 k9 l10", "l10 k11 j12", "j11 l10", "k12 l10", "k5 l10", "j9 l10" ) ),
            Arguments.of( "l11", Arrays.asList( "h11 g11 f11 e11 i11 j11 k11 l11", "l8 l7 l6 l5 l9 l10 l11 l12", "l11 k12", "b8 c7 d6 i5 j9 k10 l11", "j12 l11", "j10 l11", "k9 l11" ) ),
            Arguments.of( "l12", Arrays.asList( "h12 g12 f12 e12 i12 j12 k12 l12", "l8 l7 l6 l5 l9 l10 l11 l12", "h1 g2 f3 e4 i9 j10 k11 l12", "a8 b7 c6 d5 i9 j10 k11 l12", "j11 l12", "k10 l12" ) )

        ); }
}

