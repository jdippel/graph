/*
 *  ICoordinate_GetLineBundles_Bishop_WhiteBlack_TripleBoardByRectangles.java
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
 * The class ICoordinate_GetLineBundles_Bishop_WhiteBlack_TripleBoardByRectangles implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method Set<List<String>> getLineBundles() for class ICoordinate_GetLineBundles_Bishop_WhiteBlack_TripleBoardByRectangles is tested")
public class ICoordinate_GetLineBundles_Bishop_WhiteBlack_TripleBoardByRectangles extends ICoordinate_GetLineBundles_Wrapper { 

    final static ICoordinate   BOARD =     ICoordinateFactory.TRIPLE.get( );
    final static Direction     DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
    final static AdjacencyEnum ADJACENCY = AdjacencyEnum.BY_POINT;
 
    
    @ParameterizedTest( name = "given a standard board from location {0} there will be lines {1} to walk along" )
    @MethodSource("stringAndListProvider")
    public void testWithMultiArgMethodSource( String origin, List<String> expectedResultList ) {
    	assertThat( testOfArguments( BOARD, origin, DIRECTION, ADJACENCY, expectedResultList ) ).as( describeOnError( origin ) ).isTrue();
    }

    public static Stream<Arguments> stringAndListProvider() {
        return Stream.of(
            
            Arguments.of( "a1", Arrays.asList( "a1 b2 c3 d4 i5 j6 k7 l8" ) ),
            Arguments.of( "a2", Arrays.asList( "a2 b3 c4 d5 i6 j7 k8" ) ),
            Arguments.of( "a3", Arrays.asList( "a3 b4 c5 d6 i7 j8" ) ),
            Arguments.of( "a4", Arrays.asList( "a4 b5 c6 d7 i8" ) ),
            Arguments.of( "a5", Arrays.asList( "a5 b6 c7 d8" ) ),
            Arguments.of( "a6", Arrays.asList( "a6 b7 c8" ) ),
            Arguments.of( "a7", Arrays.asList( "a7 b8" ) ),
            Arguments.of( "a8", EMPTY_STRING_LIST ),
        
            Arguments.of( "b1", Arrays.asList( "b1 a2" ) ),
            Arguments.of( "b2", Arrays.asList( "b2 c3 d4 i5 j6 k7 l8", "b2 a3" ) ),
            Arguments.of( "b3", Arrays.asList( "b3 c4 d5 i6 j7 k8", "b3 a4" ) ),
            Arguments.of( "b4", Arrays.asList( "b4 c5 d6 i7 j8", "b4 a5" ) ),
            Arguments.of( "b5", Arrays.asList( "b5 c6 d7 i8", "b5 a6" ) ),
            Arguments.of( "b6", Arrays.asList( "b6 c7 d8", "b6 a7" ) ),
            Arguments.of( "b7", Arrays.asList( "b7 c8", "b7 a8" ) ),
            Arguments.of( "b8", EMPTY_STRING_LIST ),
        
            Arguments.of( "c1", Arrays.asList( "c1 b2 a3" ) ),
            Arguments.of( "c2", Arrays.asList( "c2 b3 a4" ) ),
            Arguments.of( "c3", Arrays.asList( "c3 d4 i5 j6 k7 l8", "c3 b4 a5" ) ),
            Arguments.of( "c4", Arrays.asList( "c4 b5 a6", "c4 d5 i6 j7 k8" ) ),
            Arguments.of( "c5", Arrays.asList( "c5 b6 a7", "c5 d6 i7 j8" ) ),
            Arguments.of( "c6", Arrays.asList( "c6 d7 i8", "c6 b7 a8" ) ),
            Arguments.of( "c7", Arrays.asList( "c7 d8" ) ),
            Arguments.of( "c8", EMPTY_STRING_LIST ),
        
            Arguments.of( "d1", Arrays.asList( "d1 c2 b3 a4" ) ),
            Arguments.of( "d2", Arrays.asList( "d2 c3 b4 a5" ) ),
            Arguments.of( "d3", Arrays.asList( "d3 c4 b5 a6" ) ),
            Arguments.of( "d4", Arrays.asList( "d4 c5 b6 a7", "d4 i5 j6 k7 l8" ) ),
            Arguments.of( "d5", Arrays.asList( "d5 c6 b7 a8", "d5 i6 j7 k8" ) ),
            Arguments.of( "d6", Arrays.asList( "d6 i7 j8" ) ),
            Arguments.of( "d7", Arrays.asList( "d7 i8" ) ),
            Arguments.of( "d8", EMPTY_STRING_LIST ),
        
            Arguments.of( "e1", Arrays.asList( "e1 d2 c3 b4 a5" ) ),
            Arguments.of( "e2", Arrays.asList( "e2 d3 c4 b5 a6" ) ),
            Arguments.of( "e3", Arrays.asList( "e3 d4 c5 b6 a7" ) ),
            Arguments.of( "e4", Arrays.asList( "e4 d5 c6 b7 a8" ) ),
            Arguments.of( "e9", EMPTY_STRING_LIST ),
            Arguments.of( "e10", EMPTY_STRING_LIST ),
            Arguments.of( "e11", EMPTY_STRING_LIST ),
            Arguments.of( "e12", EMPTY_STRING_LIST ),
        
            Arguments.of( "f1", Arrays.asList( "f1 e2 d3 c4 b5 a6" ) ),
            Arguments.of( "f2", Arrays.asList( "f2 e3 d4 c5 b6 a7" ) ),
            Arguments.of( "f3", Arrays.asList( "f3 e4 d5 c6 b7 a8" ) ),
            Arguments.of( "f4", EMPTY_STRING_LIST ),
            Arguments.of( "f9", EMPTY_STRING_LIST ),
            Arguments.of( "f10", EMPTY_STRING_LIST ),
            Arguments.of( "f11", EMPTY_STRING_LIST ),
            Arguments.of( "f12", EMPTY_STRING_LIST ),
        
            Arguments.of( "g1", Arrays.asList( "g1 f2 e3 d4 c5 b6 a7" ) ),
            Arguments.of( "g2", Arrays.asList( "g2 f3 e4 d5 c6 b7 a8" ) ),
            Arguments.of( "g3", EMPTY_STRING_LIST ),
            Arguments.of( "g4", EMPTY_STRING_LIST ),
            Arguments.of( "g9", EMPTY_STRING_LIST ),
            Arguments.of( "g10", EMPTY_STRING_LIST ),
            Arguments.of( "g11", EMPTY_STRING_LIST ),
            Arguments.of( "g12", EMPTY_STRING_LIST ),
        
            Arguments.of( "h1", Arrays.asList( "h1 g2 f3 e4 d5 c6 b7 a8" ) ),
            Arguments.of( "h2", EMPTY_STRING_LIST ),
            Arguments.of( "h3", EMPTY_STRING_LIST ),
            Arguments.of( "h4", EMPTY_STRING_LIST ),
            Arguments.of( "h9", EMPTY_STRING_LIST ),
            Arguments.of( "h10", EMPTY_STRING_LIST ),
            Arguments.of( "h11", EMPTY_STRING_LIST ),
            Arguments.of( "h12", EMPTY_STRING_LIST ),
        
            Arguments.of( "i5", Arrays.asList( "i5 j6 k7 l8" ) ),
            Arguments.of( "i6", Arrays.asList( "i6 j7 k8" ) ),
            Arguments.of( "i7", Arrays.asList( "i7 j8" ) ),
            Arguments.of( "i8", EMPTY_STRING_LIST ),
            Arguments.of( "i9", EMPTY_STRING_LIST ),
            Arguments.of( "i10", EMPTY_STRING_LIST ),
            Arguments.of( "i11", EMPTY_STRING_LIST ),
            Arguments.of( "i12", EMPTY_STRING_LIST ),
        
            Arguments.of( "j5", EMPTY_STRING_LIST ),
            Arguments.of( "j6", Arrays.asList( "j6 k7 l8" ) ),
            Arguments.of( "j7", Arrays.asList( "j7 k8" ) ),
            Arguments.of( "j8", EMPTY_STRING_LIST ),
            Arguments.of( "j9", EMPTY_STRING_LIST ),
            Arguments.of( "j10", EMPTY_STRING_LIST ),
            Arguments.of( "j11", EMPTY_STRING_LIST ),
            Arguments.of( "j12", EMPTY_STRING_LIST ),
      
            Arguments.of( "k5", EMPTY_STRING_LIST ),
            Arguments.of( "k6", EMPTY_STRING_LIST ),
            Arguments.of( "k7", Arrays.asList( "k7 l8" ) ),
            Arguments.of( "k8", EMPTY_STRING_LIST ),
            Arguments.of( "k9", EMPTY_STRING_LIST ),
            Arguments.of( "k10", EMPTY_STRING_LIST ),
            Arguments.of( "k11", EMPTY_STRING_LIST ),
            Arguments.of( "k12", EMPTY_STRING_LIST ),
     
            Arguments.of( "l5", EMPTY_STRING_LIST ),
            Arguments.of( "l6", EMPTY_STRING_LIST ),
            Arguments.of( "l7", EMPTY_STRING_LIST ),
            Arguments.of( "l8", EMPTY_STRING_LIST ),
            Arguments.of( "l9", EMPTY_STRING_LIST ),
            Arguments.of( "l10", EMPTY_STRING_LIST ),
            Arguments.of( "l11", EMPTY_STRING_LIST ),
            Arguments.of( "l12", EMPTY_STRING_LIST )
        
        ); }
}

