/*
 *  ICoordinate_GetLineBundles_Bishop_WhiteRed_TripleBoardByRectangles.java
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
 * The class ICoordinate_GetLineBundles_Bishop_WhiteRed_TripleBoardByRectangles implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method Set<List<String>> getLineBundles() for class ICoordinate_GetLineBundles_Bishop_WhiteRed_TripleBoardByRectangles is tested")
public class ICoordinate_GetLineBundles_Bishop_WhiteRed_TripleBoardByRectangles extends ICoordinate_GetLineBundles_Wrapper { 
    
    final static ICoordinate   BOARD =     ICoordinateFactory.TRIPLE.get( );
    final static Direction     DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.RED );
    final static AdjacencyEnum ADJACENCY = AdjacencyEnum.BY_POINT;
 
    
    @ParameterizedTest( name = "given a standard board from location {0} there will be lines {1} to walk along" )
    @MethodSource("stringAndListProvider")
    public void testWithMultiArgMethodSource( String origin, List<String> expectedResultList ) {
    	assertThat( testOfArguments( BOARD, origin, DIRECTION, ADJACENCY, expectedResultList ) ).as( describeOnError( origin ) ).isTrue();
    }

    public static Stream<Arguments> stringAndListProvider() {
        return Stream.of(
            
            Arguments.of( "a1", Arrays.asList( "a1 b2 c3 d4 e9 f10 g11 h12" ) ),
            Arguments.of( "a2", EMPTY_STRING_LIST ),
            Arguments.of( "a3", EMPTY_STRING_LIST ),
            Arguments.of( "a4", EMPTY_STRING_LIST ),
            Arguments.of( "a5", EMPTY_STRING_LIST ),
            Arguments.of( "a6", EMPTY_STRING_LIST ),
            Arguments.of( "a7", EMPTY_STRING_LIST ),
            Arguments.of( "a8", EMPTY_STRING_LIST ),
        
            Arguments.of( "b1", Arrays.asList( "b1 c2 d3 e4 f9 g10 h11" ) ),
            Arguments.of( "b2", Arrays.asList( "b2 c3 d4 e9 f10 g11 h12" ) ),
            Arguments.of( "b3", EMPTY_STRING_LIST ),
            Arguments.of( "b4", EMPTY_STRING_LIST ),
            Arguments.of( "b5", EMPTY_STRING_LIST ),
            Arguments.of( "b6", EMPTY_STRING_LIST ),
            Arguments.of( "b7", EMPTY_STRING_LIST ),
            Arguments.of( "b8", EMPTY_STRING_LIST ),
        
            Arguments.of( "c1", Arrays.asList( "c1 d2 e3 f4 g9 h10" ) ),
            Arguments.of( "c2", Arrays.asList( "c2 d3 e4 f9 g10 h11" ) ),
            Arguments.of( "c3", Arrays.asList( "c3 d4 e9 f10 g11 h12" ) ),
            Arguments.of( "c4", EMPTY_STRING_LIST ),
            Arguments.of( "c5", EMPTY_STRING_LIST ),
            Arguments.of( "c6", EMPTY_STRING_LIST ),
            Arguments.of( "c7", EMPTY_STRING_LIST ),
            Arguments.of( "c8", EMPTY_STRING_LIST ),
        
            Arguments.of( "d1", Arrays.asList( "d1 e2 f3 g4 h9" ) ),
            Arguments.of( "d2", Arrays.asList( "d2 e3 f4 g9 h10" ) ),
            Arguments.of( "d3", Arrays.asList( "d3 e4 f9 g10 h11" ) ),
            Arguments.of( "d4", Arrays.asList( "d4 e9 f10 g11 h12" ) ),
            Arguments.of( "d5", EMPTY_STRING_LIST ),
            Arguments.of( "d6", EMPTY_STRING_LIST ),
            Arguments.of( "d7", EMPTY_STRING_LIST ),
            Arguments.of( "d8", EMPTY_STRING_LIST ),
        
            Arguments.of( "e1", Arrays.asList( "e1 f2 g3 h4" ) ),
            Arguments.of( "e2", Arrays.asList( "e2 f3 g4 h9" ) ),
            Arguments.of( "e3", Arrays.asList( "e3 f4 g9 h10" ) ),
            Arguments.of( "e4", Arrays.asList( "e4 i9 j10 k11 l12", "e4 f9 g10 h11" ) ),
            Arguments.of( "e9", Arrays.asList( "e9 f10 g11 h12", "e9 i10 j11 k12" ) ),
            Arguments.of( "e10", Arrays.asList( "e10 i11 j12" ) ),
            Arguments.of( "e11", Arrays.asList( "e11 i12" ) ),
            Arguments.of( "e12", EMPTY_STRING_LIST ),
        
            Arguments.of( "f1", Arrays.asList( "f1 g2 h3" ) ),
            Arguments.of( "f2", Arrays.asList( "f2 g3 h4" ) ),
            Arguments.of( "f3", Arrays.asList( "f3 g4 h9", "f3 e4 i9 j10 k11 l12" ) ),
            Arguments.of( "f4", Arrays.asList( "f4 g9 h10", "f4 e9 i10 j11 k12" ) ),
            Arguments.of( "f9", Arrays.asList( "f9 g10 h11", "f9 e10 i11 j12" ) ),
            Arguments.of( "f10", Arrays.asList( "f10 g11 h12", "f10 e11 i12" ) ),
            Arguments.of( "f11", Arrays.asList( "f11 e12" ) ),
            Arguments.of( "f12", EMPTY_STRING_LIST ),
        
            Arguments.of( "g1", Arrays.asList( "g1 h2" ) ),
            Arguments.of( "g2", Arrays.asList( "g2 f3 e4 i9 j10 k11 l12", "g2 h3" ) ),
            Arguments.of( "g3", Arrays.asList( "g3 f4 e9 i10 j11 k12", "g3 h4" ) ),
            Arguments.of( "g4", Arrays.asList( "g4 f9 e10 i11 j12", "g4 h9" ) ),
            Arguments.of( "g9", Arrays.asList( "g9 h10", "g9 f10 e11 i12" ) ),
            Arguments.of( "g10", Arrays.asList( "g10 h11", "g10 f11 e12" ) ),
            Arguments.of( "g11", Arrays.asList( "g11 f12", "g11 h12" ) ),
            Arguments.of( "g12", EMPTY_STRING_LIST ),
        
            Arguments.of( "h1", Arrays.asList( "h1 g2 f3 e4 i9 j10 k11 l12" ) ),
            Arguments.of( "h2", Arrays.asList( "h2 g3 f4 e9 i10 j11 k12" ) ),
            Arguments.of( "h3", Arrays.asList( "h3 g4 f9 e10 i11 j12" ) ),
            Arguments.of( "h4", Arrays.asList( "h4 g9 f10 e11 i12" ) ),
            Arguments.of( "h9", Arrays.asList( "h9 g10 f11 e12" ) ),
            Arguments.of( "h10", Arrays.asList( "h10 g11 f12" ) ),
            Arguments.of( "h11", Arrays.asList( "h11 g12" ) ),
            Arguments.of( "h12", EMPTY_STRING_LIST ),
               
            Arguments.of( "i5", EMPTY_STRING_LIST ),
            Arguments.of( "i6", EMPTY_STRING_LIST ),
            Arguments.of( "i7", EMPTY_STRING_LIST ),
            Arguments.of( "i8", EMPTY_STRING_LIST ),
            Arguments.of( "i9", Arrays.asList( "i9 j10 k11 l12" ) ),
            Arguments.of( "i10", Arrays.asList( "i10 j11 k12" ) ),
            Arguments.of( "i11", Arrays.asList( "i11 j12" ) ),
            Arguments.of( "i12", EMPTY_STRING_LIST ),
        
            Arguments.of( "j5", EMPTY_STRING_LIST ),
            Arguments.of( "j6", EMPTY_STRING_LIST ),
            Arguments.of( "j7", EMPTY_STRING_LIST ),
            Arguments.of( "j8", EMPTY_STRING_LIST ),
            Arguments.of( "j9", EMPTY_STRING_LIST ),
            Arguments.of( "j10", Arrays.asList( "j10 k11 l12" ) ),
            Arguments.of( "j11", Arrays.asList( "j11 k12" ) ),
            Arguments.of( "j12", EMPTY_STRING_LIST ),
        
            Arguments.of( "k5", EMPTY_STRING_LIST ),
            Arguments.of( "k6", EMPTY_STRING_LIST ),
            Arguments.of( "k7", EMPTY_STRING_LIST ),
            Arguments.of( "k8", EMPTY_STRING_LIST ),
            Arguments.of( "k9", EMPTY_STRING_LIST ),
            Arguments.of( "k10", EMPTY_STRING_LIST ),
            Arguments.of( "k11", Arrays.asList( "k11 l12" ) ),
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

