/*
 *  ICoordinate_GetLineBundles_Rook_WhiteRed_TripleBoardByRectangles.java
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
 * The class ICoordinate_GetLineBundles_Rook_WhiteRed_TripleBoardByRectangles implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method Set<List<String>> getLineBundles() for class ICoordinate_GetLineBundles_Rook_WhiteRed_TripleBoardByRectangles is tested")
public class ICoordinate_GetLineBundles_Rook_WhiteRed_TripleBoardByRectangles extends ICoordinate_GetLineBundles_Wrapper { 

    final static ICoordinate   BOARD =     ICoordinateFactory.TRIPLE.get( );
    final static Direction     DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.RED );
    final static AdjacencyEnum ADJACENCY = AdjacencyEnum.BY_EDGE;
    
    
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
            
            Arguments.of( "e1", Arrays.asList( "e1 e2 e3 e4 e9 e10 e11 e12" ) ),
            Arguments.of( "e2", Arrays.asList( "e2 e3 e4 e9 e10 e11 e12" ) ),
            Arguments.of( "e3", Arrays.asList( "e3 e4 e9 e10 e11 e12" ) ),
            Arguments.of( "e4", Arrays.asList( "e4 e9 e10 e11 e12" ) ),
            Arguments.of( "e9", Arrays.asList( "e9 e10 e11 e12" ) ),
            Arguments.of( "e10", Arrays.asList( "e10 e11 e12" ) ),
            Arguments.of( "e11", Arrays.asList( "e11 e12" ) ),
            Arguments.of( "e12", EMPTY_STRING_LIST ),
        
            Arguments.of( "f1", Arrays.asList( "f1 f2 f3 f4 f9 f10 f11 f12" ) ),
            Arguments.of( "f2", Arrays.asList( "f2 f3 f4 f9 f10 f11 f12" ) ),
            Arguments.of( "f3", Arrays.asList( "f3 f4 f9 f10 f11 f12" ) ),
            Arguments.of( "f4", Arrays.asList( "f4 f9 f10 f11 f12" ) ),
            Arguments.of( "f9", Arrays.asList( "f9 f10 f11 f12" ) ),
            Arguments.of( "f10", Arrays.asList( "f10 f11 f12" ) ),
            Arguments.of( "f11", Arrays.asList( "f11 f12" ) ),
            Arguments.of( "f12", EMPTY_STRING_LIST ),
        
            Arguments.of( "g1", Arrays.asList( "g1 g2 g3 g4 g9 g10 g11 g12" ) ),
            Arguments.of( "g2", Arrays.asList( "g2 g3 g4 g9 g10 g11 g12" ) ),
            Arguments.of( "g3", Arrays.asList( "g3 g4 g9 g10 g11 g12" ) ),
            Arguments.of( "g4", Arrays.asList( "g4 g9 g10 g11 g12" ) ),
            Arguments.of( "g9", Arrays.asList( "g9 g10 g11 g12" ) ),
            Arguments.of( "g10", Arrays.asList( "g10 g11 g12" ) ),
            Arguments.of( "g11", Arrays.asList( "g11 g12" ) ),
            Arguments.of( "g12", EMPTY_STRING_LIST ),
      
            Arguments.of( "h1", Arrays.asList( "h1 h2 h3 h4 h9 h10 h11 h12" ) ),
            Arguments.of( "h2", Arrays.asList( "h2 h3 h4 h9 h10 h11 h12" ) ),
            Arguments.of( "h3", Arrays.asList( "h3 h4 h9 h10 h11 h12" ) ),
            Arguments.of( "h4", Arrays.asList( "h4 h9 h10 h11 h12" ) ),
            Arguments.of( "h9", Arrays.asList( "h9 h10 h11 h12" ) ),
            Arguments.of( "h10", Arrays.asList( "h10 h11 h12" ) ),
            Arguments.of( "h11", Arrays.asList( "h11 h12" ) ),
            Arguments.of( "h12", EMPTY_STRING_LIST ),
              
            Arguments.of( "i5", EMPTY_STRING_LIST ),
            Arguments.of( "i6", EMPTY_STRING_LIST ),
            Arguments.of( "i7", EMPTY_STRING_LIST ),
            Arguments.of( "i8", EMPTY_STRING_LIST ),
            Arguments.of( "i9", EMPTY_STRING_LIST ),
            Arguments.of( "i10", EMPTY_STRING_LIST ),
            Arguments.of( "i11", EMPTY_STRING_LIST ),
            Arguments.of( "i12", EMPTY_STRING_LIST ),
        
            Arguments.of( "j5", EMPTY_STRING_LIST ),
            Arguments.of( "j6", EMPTY_STRING_LIST ),
            Arguments.of( "j7", EMPTY_STRING_LIST ),
            Arguments.of( "j8", EMPTY_STRING_LIST ),
            Arguments.of( "j9", EMPTY_STRING_LIST ),
            Arguments.of( "j10", EMPTY_STRING_LIST ),
            Arguments.of( "j11", EMPTY_STRING_LIST ),
            Arguments.of( "j12", EMPTY_STRING_LIST ),
        
            Arguments.of( "k5", EMPTY_STRING_LIST ),
            Arguments.of( "k6", EMPTY_STRING_LIST ),
            Arguments.of( "k7", EMPTY_STRING_LIST ),
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

