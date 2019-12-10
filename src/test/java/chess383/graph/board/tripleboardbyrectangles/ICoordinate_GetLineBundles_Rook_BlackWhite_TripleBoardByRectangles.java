/*
 *  ICoordinate_GetLineBundles_Rook_BlackWhite_TripleBoardByRectangles.java
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
 * The class ICoordinate_GetLineBundles_Rook_BlackWhite_TripleBoardByRectangles implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method Set<List<String>> getLineBundles() for class ICoordinate_GetLineBundles_Rook_BlackWhite_TripleBoardByRectangles is tested")
public class ICoordinate_GetLineBundles_Rook_BlackWhite_TripleBoardByRectangles extends ICoordinate_GetLineBundles_Wrapper { 

    final static ICoordinate   BOARD =     ICoordinateFactory.TRIPLE.get( );
    final static Direction     DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.BLACK, ColorEnum.WHITE );
    final static AdjacencyEnum ADJACENCY = AdjacencyEnum.BY_EDGE;
 
    
    @ParameterizedTest( name = "given a standard board from location {0} there will be lines {1} to walk along" )
    @MethodSource("stringAndListProvider")
    public void testWithMultiArgMethodSource( String origin, List<String> expectedResultList ) {
        assertTrue( testOfArguments( BOARD, origin, DIRECTION, ADJACENCY, expectedResultList ) );
    }

    public static Stream<Arguments> stringAndListProvider() {
        return Stream.of(
            
            Arguments.of( "a1", EMPTY_STRING_LIST ),
            Arguments.of( "a2", Arrays.asList( "a2 a1" ) ),
            Arguments.of( "a3", Arrays.asList( "a3 a2 a1" ) ),
            Arguments.of( "a4", Arrays.asList( "a4 a3 a2 a1" ) ),
            Arguments.of( "a5", Arrays.asList( "a5 a4 a3 a2 a1" ) ),
            Arguments.of( "a6", Arrays.asList( "a6 a5 a4 a3 a2 a1" ) ),
            Arguments.of( "a7", Arrays.asList( "a7 a6 a5 a4 a3 a2 a1" ) ),
            Arguments.of( "a8", Arrays.asList( "a8 a7 a6 a5 a4 a3 a2 a1" ) ),
        
            Arguments.of( "b1", EMPTY_STRING_LIST ),
            Arguments.of( "b2", Arrays.asList( "b2 b1" ) ),
            Arguments.of( "b3", Arrays.asList( "b3 b2 b1" ) ),
            Arguments.of( "b4", Arrays.asList( "b4 b3 b2 b1" ) ),
            Arguments.of( "b5", Arrays.asList( "b5 b4 b3 b2 b1" ) ),
            Arguments.of( "b6", Arrays.asList( "b6 b5 b4 b3 b2 b1" ) ),
            Arguments.of( "b7", Arrays.asList( "b7 b6 b5 b4 b3 b2 b1" ) ),
            Arguments.of( "b8", Arrays.asList( "b8 b7 b6 b5 b4 b3 b2 b1" ) ),
        
            Arguments.of( "c1", EMPTY_STRING_LIST ),
            Arguments.of( "c2", Arrays.asList( "c2 c1" ) ),
            Arguments.of( "c3", Arrays.asList( "c3 c2 c1" ) ),
            Arguments.of( "c4", Arrays.asList( "c4 c3 c2 c1" ) ),
            Arguments.of( "c5", Arrays.asList( "c5 c4 c3 c2 c1" ) ),
            Arguments.of( "c6", Arrays.asList( "c6 c5 c4 c3 c2 c1" ) ),
            Arguments.of( "c7", Arrays.asList( "c7 c6 c5 c4 c3 c2 c1" ) ),
            Arguments.of( "c8", Arrays.asList( "c8 c7 c6 c5 c4 c3 c2 c1" ) ),
        
            Arguments.of( "d1", EMPTY_STRING_LIST ),
            Arguments.of( "d2", Arrays.asList( "d2 d1" ) ),
            Arguments.of( "d3", Arrays.asList( "d3 d2 d1" ) ),
            Arguments.of( "d4", Arrays.asList( "d4 d3 d2 d1" ) ),
            Arguments.of( "d5", Arrays.asList( "d5 d4 d3 d2 d1" ) ),
            Arguments.of( "d6", Arrays.asList( "d6 d5 d4 d3 d2 d1" ) ),
            Arguments.of( "d7", Arrays.asList( "d7 d6 d5 d4 d3 d2 d1" ) ),
            Arguments.of( "d8", Arrays.asList( "d8 d7 d6 d5 d4 d3 d2 d1" ) ),
        
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

