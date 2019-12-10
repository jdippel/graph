/*
 *  ICoordinate_GetLineBundles_Bishop_RedBlack_TripleBoardByRectangles.java
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

import chess383.ColorEnum;
import chess383.ICoordinate;
import chess383.ICoordinateFactory;
import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.board.ICoordinate_GetLineBundles_Wrapper;
import chess383.graph.direction.Direction;

/**
 * <p>
 * The class ICoordinate_GetLineBundles_Bishop_RedBlack_TripleBoardByRectangles implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method Set<List<String>> getLineBundles() for class ICoordinate_GetLineBundles_Bishop_RedBlack_TripleBoardByRectangles is tested")
public class ICoordinate_GetLineBundles_Bishop_RedBlack_TripleBoardByRectangles extends ICoordinate_GetLineBundles_Wrapper { 
    
    final static ICoordinate   BOARD =     ICoordinateFactory.TRIPLE.get( );
    final static Direction     DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.RED, ColorEnum.BLACK );
    final static AdjacencyEnum ADJACENCY = AdjacencyEnum.BY_POINT;

    
    @ParameterizedTest( name = "given a standard board from location {0} there will be lines {1} to walk along" )
    @MethodSource("stringAndListProvider")
    public void testWithMultiArgMethodSource( String origin, List<String> expectedResultList ) {
        assertTrue( testOfArguments( BOARD, origin, DIRECTION, ADJACENCY, expectedResultList ) );
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
            Arguments.of( "b7", Arrays.asList( "b7 a8" ) ),
            Arguments.of( "b8", EMPTY_STRING_LIST ),
        
            Arguments.of( "c1", EMPTY_STRING_LIST ),
            Arguments.of( "c2", EMPTY_STRING_LIST ),
            Arguments.of( "c3", EMPTY_STRING_LIST ),
            Arguments.of( "c4", EMPTY_STRING_LIST ),
            Arguments.of( "c5", EMPTY_STRING_LIST ),
            Arguments.of( "c6", Arrays.asList( "c6 b7 a8" ) ),
            Arguments.of( "c7", Arrays.asList( "c7 b8" ) ),
            Arguments.of( "c8", EMPTY_STRING_LIST ),
        
            Arguments.of( "d1", EMPTY_STRING_LIST ),
            Arguments.of( "d2", EMPTY_STRING_LIST ),
            Arguments.of( "d3", EMPTY_STRING_LIST ),
            Arguments.of( "d4", EMPTY_STRING_LIST ),
            Arguments.of( "d5", Arrays.asList( "d5 c6 b7 a8" ) ),
            Arguments.of( "d6", Arrays.asList( "d6 c7 b8" ) ),
            Arguments.of( "d7", Arrays.asList( "d7 c8" ) ),
            Arguments.of( "d8", EMPTY_STRING_LIST ),     
        
            Arguments.of( "e1", EMPTY_STRING_LIST ),
            Arguments.of( "e2", EMPTY_STRING_LIST ),
            Arguments.of( "e3", EMPTY_STRING_LIST ),
            Arguments.of( "e4", EMPTY_STRING_LIST ),
            Arguments.of( "e9", Arrays.asList( "e9 i5 j6 k7 l8" ) ),
            Arguments.of( "e10", Arrays.asList( "e10 i9 j5 k6 l7" ) ),
            Arguments.of( "e11", Arrays.asList( "e11 i10 j9 k5 l6" ) ),
            Arguments.of( "e12", Arrays.asList( "e12 i11 j10 k9 l5" ) ),
        
            Arguments.of( "f1", EMPTY_STRING_LIST ),
            Arguments.of( "f2", EMPTY_STRING_LIST ),
            Arguments.of( "f3", EMPTY_STRING_LIST ),
            Arguments.of( "f4", EMPTY_STRING_LIST ),
            Arguments.of( "f9", EMPTY_STRING_LIST ),
            Arguments.of( "f10", Arrays.asList( "f10 e9 i5 j6 k7 l8" ) ),
            Arguments.of( "f11", Arrays.asList( "f11 e10 i9 j5 k6 l7" ) ),
            Arguments.of( "f12", Arrays.asList( "f12 e11 i10 j9 k5 l6" ) ),
        
            Arguments.of( "g1", EMPTY_STRING_LIST ),
            Arguments.of( "g2", EMPTY_STRING_LIST ),
            Arguments.of( "g3", EMPTY_STRING_LIST ),
            Arguments.of( "g4", EMPTY_STRING_LIST ),
            Arguments.of( "g9", EMPTY_STRING_LIST ),
            Arguments.of( "g10", EMPTY_STRING_LIST ),
            Arguments.of( "g11", Arrays.asList( "g11 f10 e9 i5 j6 k7 l8" ) ),
            Arguments.of( "g12", Arrays.asList( "g12 f11 e10 i9 j5 k6 l7" ) ),
        
            Arguments.of( "h1", EMPTY_STRING_LIST ),
            Arguments.of( "h2", EMPTY_STRING_LIST ),
            Arguments.of( "h3", EMPTY_STRING_LIST ),
            Arguments.of( "h4", EMPTY_STRING_LIST ),
            Arguments.of( "h9", EMPTY_STRING_LIST ),
            Arguments.of( "h10", EMPTY_STRING_LIST ),
            Arguments.of( "h11", EMPTY_STRING_LIST ),
            Arguments.of( "h12", Arrays.asList( "h12 g11 f10 e9 i5 j6 k7 l8" ) ),
        
            Arguments.of( "i5", Arrays.asList( "i5 j6 k7 l8", "i5 d6 c7 b8" ) ),
            Arguments.of( "i6", Arrays.asList( "i6 d7 c8" ) ),
            Arguments.of( "i7", Arrays.asList( "i7 d8" ) ),
            Arguments.of( "i8", EMPTY_STRING_LIST ),
            Arguments.of( "i9", Arrays.asList( "i9 j5 k6 l7", "i9 d5 c6 b7 a8" ) ),
            Arguments.of( "i10", Arrays.asList( "i10 j9 k5 l6" ) ),
            Arguments.of( "i11", Arrays.asList( "i11 j10 k9 l5" ) ),
            Arguments.of( "i12", Arrays.asList( "i12 j11 k10 l9" ) ),
        
            Arguments.of( "j5", Arrays.asList( "j5 i6 d7 c8", "j5 k6 l7" ) ),
            Arguments.of( "j6", Arrays.asList( "j6 i7 d8", "j6 k7 l8" ) ),
            Arguments.of( "j7", Arrays.asList( "j7 i8" ) ),
            Arguments.of( "j8", EMPTY_STRING_LIST ),
            Arguments.of( "j9", Arrays.asList( "j9 k5 l6", "j9 i5 d6 c7 b8" ) ),
            Arguments.of( "j10", Arrays.asList( "j10 i9 d5 c6 b7 a8", "j10 k9 l5" ) ),
            Arguments.of( "j11", Arrays.asList( "j11 k10 l9" ) ),
            Arguments.of( "j12", Arrays.asList( "j12 k11 l10" ) ),
        
            Arguments.of( "k5", Arrays.asList( "k5 l6", "k5 j6 i7 d8" ) ),
            Arguments.of( "k6", Arrays.asList( "k6 l7", "k6 j7 i8" ) ),
            Arguments.of( "k7", Arrays.asList( "k7 l8", "k7 j8" ) ),
            Arguments.of( "k8", EMPTY_STRING_LIST ),
            Arguments.of( "k9", Arrays.asList( "k9 l5", "k9 j5 i6 d7 c8" ) ),
            Arguments.of( "k10", Arrays.asList( "k10 l9", "k10 j9 i5 d6 c7 b8" ) ),
            Arguments.of( "k11", Arrays.asList( "k11 j10 i9 d5 c6 b7 a8", "k11 l10" ) ),
            Arguments.of( "k12", Arrays.asList( "k12 l11" ) ),
        
            Arguments.of( "l5", Arrays.asList( "l5 k6 j7 i8" ) ),
            Arguments.of( "l6", Arrays.asList( "l6 k7 j8" ) ),
            Arguments.of( "l7", Arrays.asList( "l7 k8" ) ),
            Arguments.of( "l8", EMPTY_STRING_LIST ),
            Arguments.of( "l9", Arrays.asList( "l9 k5 j6 i7 d8" ) ),
            Arguments.of( "l10", Arrays.asList( "l10 k9 j5 i6 d7 c8" ) ),
            Arguments.of( "l11", Arrays.asList( "l11 k10 j9 i5 d6 c7 b8" ) ),
            Arguments.of( "l12", Arrays.asList( "l12 k11 j10 i9 d5 c6 b7 a8" ) )

       ); }
}

