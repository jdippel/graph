/*
 *  ICoordinate_GetLineBundles_Rook_RedBlack_TripleBoardByRectangles.java
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

import chess383.ColorEnum;
import chess383.ICoordinate;
import chess383.ICoordinateFactory;
import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.board.ICoordinate_GetLineBundles_Wrapper;
import chess383.graph.direction.Direction;

/**
 * <p>
 * The class ICoordinate_GetLineBundles_Rook_RedBlack_TripleBoardByRectangles implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method Set<List<String>> getLineBundles() for class ICoordinate_GetLineBundles_Rook_RedBlack_TripleBoardByRectangles is tested")
public class ICoordinate_GetLineBundles_Rook_RedBlack_TripleBoardByRectangles extends ICoordinate_GetLineBundles_Wrapper { 

    final static ICoordinate   BOARD =     ICoordinateFactory.TRIPLE.get( );
    final static Direction     DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.RED, ColorEnum.BLACK );
    final static AdjacencyEnum ADJACENCY = AdjacencyEnum.BY_EDGE;
 
    
    @ParameterizedTest( name = "given a standard board from location {0} there will be lines {1} to walk along" )
    @MethodSource("stringAndListProvider")
    public void testWithMultiArgMethodSource( String origin, List<String> expectedResultList ) {
    	assertThat( testOfArguments( BOARD, origin, DIRECTION, ADJACENCY, expectedResultList ) ).as( describeOnError( origin ) ).isTrue();
    }

    public static Stream<Arguments> stringAndListProvider() {
        return Stream.of(
            
            Arguments.of( "a1", EMPTY_STRING_LIST ),
            Arguments.of( "a2", EMPTY_STRING_LIST ),
            Arguments.of( "a3", EMPTY_STRING_LIST ),
            Arguments.of( "a4", EMPTY_STRING_LIST ),
            Arguments.of( "a5", EMPTY_STRING_LIST ),
            Arguments.of( "a6", EMPTY_STRING_LIST ),
            Arguments.of( "a7", EMPTY_STRING_LIST ),
            Arguments.of( "a8", EMPTY_STRING_LIST ),
        
            Arguments.of( "b1", EMPTY_STRING_LIST ),
            Arguments.of( "b2", EMPTY_STRING_LIST ),
            Arguments.of( "b3", EMPTY_STRING_LIST ),
            Arguments.of( "b4", EMPTY_STRING_LIST ),
            Arguments.of( "b5", EMPTY_STRING_LIST ),
            Arguments.of( "b6", EMPTY_STRING_LIST ),
            Arguments.of( "b7", EMPTY_STRING_LIST ),
            Arguments.of( "b8", EMPTY_STRING_LIST ),
        
            Arguments.of( "c1", EMPTY_STRING_LIST ),
            Arguments.of( "c2", EMPTY_STRING_LIST ),
            Arguments.of( "c3", EMPTY_STRING_LIST ),
            Arguments.of( "c4", EMPTY_STRING_LIST ),
            Arguments.of( "c5", EMPTY_STRING_LIST ),
            Arguments.of( "c6", EMPTY_STRING_LIST ),
            Arguments.of( "c7", EMPTY_STRING_LIST ),
            Arguments.of( "c8", EMPTY_STRING_LIST ),
        
            Arguments.of( "d1", EMPTY_STRING_LIST ),
            Arguments.of( "d2", EMPTY_STRING_LIST ),
            Arguments.of( "d3", EMPTY_STRING_LIST ),
            Arguments.of( "d4", EMPTY_STRING_LIST ),
            Arguments.of( "d5", EMPTY_STRING_LIST ),
            Arguments.of( "d6", EMPTY_STRING_LIST ),
            Arguments.of( "d7", EMPTY_STRING_LIST ),
            Arguments.of( "d8", EMPTY_STRING_LIST ),     
        
            Arguments.of( "e1", EMPTY_STRING_LIST ),
            Arguments.of( "e2", EMPTY_STRING_LIST ),
            Arguments.of( "e3", EMPTY_STRING_LIST ),
            Arguments.of( "e4", EMPTY_STRING_LIST ),
            Arguments.of( "e9", EMPTY_STRING_LIST ),
            Arguments.of( "e10", EMPTY_STRING_LIST ),
            Arguments.of( "e11", EMPTY_STRING_LIST ),
            Arguments.of( "e12", EMPTY_STRING_LIST ),
        
            Arguments.of( "f1", EMPTY_STRING_LIST ),
            Arguments.of( "f2", EMPTY_STRING_LIST ),
            Arguments.of( "f3", EMPTY_STRING_LIST ),
            Arguments.of( "f4", EMPTY_STRING_LIST ),
            Arguments.of( "f9", EMPTY_STRING_LIST ),
            Arguments.of( "f10", EMPTY_STRING_LIST ),
            Arguments.of( "f11", EMPTY_STRING_LIST ),
            Arguments.of( "f12", EMPTY_STRING_LIST ),
        
            Arguments.of( "g1", EMPTY_STRING_LIST ),
            Arguments.of( "g2", EMPTY_STRING_LIST ),
            Arguments.of( "g3", EMPTY_STRING_LIST ),
            Arguments.of( "g4", EMPTY_STRING_LIST ),
            Arguments.of( "g9", EMPTY_STRING_LIST ),
            Arguments.of( "g10", EMPTY_STRING_LIST ),
            Arguments.of( "g11", EMPTY_STRING_LIST ),
            Arguments.of( "g12", EMPTY_STRING_LIST ),
        
            Arguments.of( "h1", EMPTY_STRING_LIST ),
            Arguments.of( "h2", EMPTY_STRING_LIST ),
            Arguments.of( "h3", EMPTY_STRING_LIST ),
            Arguments.of( "h4", EMPTY_STRING_LIST ),
            Arguments.of( "h9", EMPTY_STRING_LIST ),
            Arguments.of( "h10", EMPTY_STRING_LIST ),
            Arguments.of( "h11", EMPTY_STRING_LIST ),
            Arguments.of( "h12", EMPTY_STRING_LIST ),
        
            Arguments.of( "i5", Arrays.asList( "i5 i6 i7 i8" ) ),
            Arguments.of( "i6", Arrays.asList( "i6 i7 i8" ) ),
            Arguments.of( "i7", Arrays.asList( "i7 i8" ) ),
            Arguments.of( "i8", EMPTY_STRING_LIST ),
            Arguments.of( "i9", Arrays.asList( "i9 i5 i6 i7 i8" ) ),
            Arguments.of( "i10", Arrays.asList( "i10 i9 i5 i6 i7 i8" ) ),
            Arguments.of( "i11", Arrays.asList( "i11 i10 i9 i5 i6 i7 i8" ) ),
            Arguments.of( "i12", Arrays.asList( "i12 i11 i10 i9 i5 i6 i7 i8" ) ),
        
            Arguments.of( "j5", Arrays.asList( "j5 j6 j7 j8" ) ),
            Arguments.of( "j6", Arrays.asList( "j6 j7 j8" ) ),
            Arguments.of( "j7", Arrays.asList( "j7 j8" ) ),
            Arguments.of( "j8", EMPTY_STRING_LIST ),
            Arguments.of( "j9", Arrays.asList( "j9 j5 j6 j7 j8" ) ),
            Arguments.of( "j10", Arrays.asList( "j10 j9 j5 j6 j7 j8" ) ),
            Arguments.of( "j11", Arrays.asList( "j11 j10 j9 j5 j6 j7 j8" ) ),
            Arguments.of( "j12", Arrays.asList( "j12 j11 j10 j9 j5 j6 j7 j8" ) ),
        
            Arguments.of( "k5", Arrays.asList( "k5 k6 k7 k8" ) ),
            Arguments.of( "k6", Arrays.asList( "k6 k7 k8" ) ),
            Arguments.of( "k7", Arrays.asList( "k7 k8" ) ),
            Arguments.of( "k8", EMPTY_STRING_LIST ),
            Arguments.of( "k9", Arrays.asList( "k9 k5 k6 k7 k8" ) ),
            Arguments.of( "k10", Arrays.asList( "k10 k9 k5 k6 k7 k8" ) ),
            Arguments.of( "k11", Arrays.asList( "k11 k10 k9 k5 k6 k7 k8" ) ),
            Arguments.of( "k12", Arrays.asList( "k12 k11 k10 k9 k5 k6 k7 k8" ) ),
        
            Arguments.of( "l5", Arrays.asList( "l5 l6 l7 l8" ) ),
            Arguments.of( "l6", Arrays.asList( "l6 l7 l8" ) ),
            Arguments.of( "l7", Arrays.asList( "l7 l8" ) ),
            Arguments.of( "l8", EMPTY_STRING_LIST ),
            Arguments.of( "l9", Arrays.asList( "l9 l5 l6 l7 l8" ) ),
            Arguments.of( "l10", Arrays.asList( "l10 l9 l5 l6 l7 l8" ) ),
            Arguments.of( "l11", Arrays.asList( "l11 l10 l9 l5 l6 l7 l8" ) ),
            Arguments.of( "l12", Arrays.asList( "l12 l11 l10 l9 l5 l6 l7 l8" ) )
        
        ); }
}

