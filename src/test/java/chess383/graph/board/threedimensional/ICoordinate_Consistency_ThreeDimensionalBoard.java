/*
 *  ICoordinate_Consistency_ThreeDimensionalBoard.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2017 - 2021 Jörg Dippel
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

package chess383.graph.board.threedimensional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import chess383.ICoordinateFactory;
import chess383.graph.board.ICoordinate_Consistency_Wrapper;


/**
 * <p>
 * The class ICoordinate_Consistency_ThreeDimensionalBoard implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   February 2021
 *
 */
@DisplayName("the public method Set<List<String>> getLineBundles() for class ICoordinate_Consistency_ThreeDimensionalBoard is tested")
public class ICoordinate_Consistency_ThreeDimensionalBoard { 

    private ICoordinate_Consistency_Wrapper wrapper = new ICoordinate_Consistency_Wrapper( ICoordinateFactory.THREE_DIMENSIONAL );
    
    @ParameterizedTest( name = "given a three-dimensional board from location {0} someone can move to: {1}, {2} or {3}")
    @DisplayName("given a alocation then following locations can be reached in an area of distance two")
    @CsvSource({ "a0, a1 a2 z0, b1 c2 z1, b2 c1 z2",
                 "a1, a0 a2 a3 b1 c1 z1, b2 c3 z0 z2, b3 c2 z3", 
                 "a2, a0 a1 a3 a4 b2 c2 z2, b1 b3 c4 z1 z3, b4 c1 c3 z0 z4", 
                 "a3, a1 a2 a4 a5 b3 c3 z3, b2 b4 c1 c5 z2 z4, b1 b5 c2 c4 z1 z5", 
                 "a4, a2 a3 a5 a6 b4 c4 z4, b3 b5 c2 c6 z3 z5, b2 b6 c3 c5 z2 z6", 
                 "a5, a3 a4 a6 a7 b5 c5 z5, b4 b6 c3 c7 z4 z6, b3 b7 c4 c6 z3 z7", 
                 "a6, a4 a5 a7 a8 b6 c6 z6, b5 b7 c4 c8 z5 z7, b4 b8 c5 c7 z4 z8", 
                 "a7, a5 a6 a8 a9 b7 c7 z7, b6 b8 c5 z6 z8, b5 c6 c8 z5 z9", 
                 "a8, a6 a7 a9 b8 c8 z8, b7 c6 z7 z9, b6 c7 z6", 
                 "a9, a7 a8 z9, b8 c7 z8, b7 c8 z7", 
                 "b1, a1 b2 b3 c1 d1 z1, a0 a2 c2 d3 z3, a3 c3 d0 d2 z0 z2", 
                 "b2, a2 b1 b3 b4 c2 d2 z2, a1 a3 c1 c3 d0 d4 z0 z4, a0 a4 c4 d1 d3 z1 z3", 
                 "b3, a3 b1 b2 b4 b5 c3 d3 z3, a2 a4 c2 c4 d1 d5 z1 z5, a1 a5 c1 c5 d2 d4 z2 z4", 
                 "b4, a4 b2 b3 b5 b6 c4 d4 z4, a3 a5 c3 c5 d2 d6 z2 z6, a2 a6 c2 c6 d3 d5 z3 z5", 
                 "b5, a5 b3 b4 b6 b7 c5 d5 z5, a4 a6 c4 c6 d3 d7 z3 z7, a3 a7 c3 c7 d4 d6 z4 z6", 
                 "b6, a6 b4 b5 b7 b8 c6 d6 z6, a5 a7 c5 c7 d4 d8 z4 z8, a4 a8 c4 c8 d5 d7 z5 z7", 
                 "b7, a7 b5 b6 b8 c7 d7 z7, a6 a8 c6 c8 d5 d9 z5 z9, a5 a9 c5 d6 d8 z6 z8", 
                 "b8, a8 b6 b7 c8 d8 z8, a7 a9 c7 d6 z6, a6 c6 d7 d9 z7 z9", 
                 "c1, a1 b1 c2 c3 d1 e1, a3 b2 d0 d2 e3, a0 a2 b3 d3 e0 e2", 
                 "c2, a2 b2 c1 c3 c4 d2 e2, a0 a4 b1 b3 d1 d3 e0 e4, a1 a3 b4 d0 d4 e1 e3", 
                 "c3, a3 b3 c1 c2 c4 c5 d3 e3, a1 a5 b2 b4 d2 d4 e1 e5, a2 a4 b1 b5 d1 d5 e2 e4", 
                 "c4, a4 b4 c2 c3 c5 c6 d4 e4, a2 a6 b3 b5 d3 d5 e2 e6, a3 a5 b2 b6 d2 d6 e3 e5", 
                 "c5, a5 b5 c3 c4 c6 c7 d5 e5, a3 a7 b4 b6 d4 d6 e3 e7, a4 a6 b3 b7 d3 d7 e4 e6", 
                 "c6, a6 b6 c4 c5 c7 c8 d6 e6, a4 a8 b5 b7 d5 d7 e4 e8, a5 a7 b4 b8 d4 d8 e5 e7", 
                 "c7, a7 b7 c5 c6 c8 d7 e7, a5 a9 b6 b8 d6 d8 e5 e9, a6 a8 b5 d5 d9 e6 e8", 
                 "c8, a8 b8 c6 c7 d8 e8, a6 b7 d7 d9 e6, a7 a9 b6 d6 e7 e9", 
                 "d0, d1 d2 e0, b2 c1 e1, b1 c2 e2", 
                 "d1, b1 c1 d0 d2 d3 e1, b3 c2 e0 e2, b2 c3 e3", 
                 "d2, b2 c2 d0 d1 d3 d4 e2, b4 c1 c3 e1 e3, b1 b3 c4 e0 e4", 
                 "d3, b3 c3 d1 d2 d4 d5 e3, b1 b5 c2 c4 e2 e4, b2 b4 c1 c5 e1 e5", 
                 "d4, b4 c4 d2 d3 d5 d6 e4, b2 b6 c3 c5 e3 e5, b3 b5 c2 c6 e2 e6", 
                 "d5, b5 c5 d3 d4 d6 d7 e5, b3 b7 c4 c6 e4 e6, b4 b6 c3 c7 e3 e7", 
                 "d6, b6 c6 d4 d5 d7 d8 e6, b4 b8 c5 c7 e5 e7, b5 b7 c4 c8 e4 e8", 
                 "d7, b7 c7 d5 d6 d8 d9 e7, b5 c6 c8 e6 e8, b6 b8 c5 e5 e9", 
                 "d8, b8 c8 d6 d7 d9 e8, b6 c7 e7 e9, b7 c6 e6", 
                 "d9, d7 d8 e9, b7 c8 e8, b8 c7 e7", 
                 "e0, d0 e1 e2, c2 d1, c1 d2", 
                 "e1, c1 d1 e0 e2 e3, c3 d0 d2, c2 d3", 
                 "e2, c2 d2 e0 e1 e3 e4, c4 d1 d3, c1 c3 d0 d4", 
                 "e3, c3 d3 e1 e2 e4 e5, c1 c5 d2 d4, c2 c4 d1 d5", 
                 "e4, c4 d4 e2 e3 e5 e6, c2 c6 d3 d5, c3 c5 d2 d6", 
                 "e5, c5 d5 e3 e4 e6 e7, c3 c7 d4 d6, c4 c6 d3 d7", 
                 "e6, c6 d6 e4 e5 e7 e8, c4 c8 d5 d7, c5 c7 d4 d8", 
                 "e7, c7 d7 e5 e6 e8 e9, c5 d6 d8, c6 c8 d5 d9", 
                 "e8, c8 d8 e6 e7 e9, c6 d7 d9, c7 d6", 
                 "e9, d9 e7 e8, c7 d8, c8 d7", 
                 "z0, a0 z1 z2, a1 b2, a2 b1", 
                 "z1, a1 b1 z0 z2 z3, a0 a2 b3, a3 b2", 
                 "z2, a2 b2 z0 z1 z3 z4, a1 a3 b4, a0 a4 b1 b3", 
                 "z3, a3 b3 z1 z2 z4 z5, a2 a4 b1 b5, a1 a5 b2 b4", 
                 "z4, a4 b4 z2 z3 z5 z6, a3 a5 b2 b6, a2 a6 b3 b5", 
                 "z5, a5 b5 z3 z4 z6 z7, a4 a6 b3 b7, a3 a7 b4 b6", 
                 "z6, a6 b6 z4 z5 z7 z8, a5 a7 b4 b8, a4 a8 b5 b7", 
                 "z7, a7 b7 z5 z6 z8 z9, a6 a8 b5, a5 a9 b6 b8",
                 "z8, a8 b8 z6 z7 z9, a7 a9 b6, a6 b7", 
                 "z9, a9 z7 z8, a8 b7, a7 b8"
    })
    void test( String location, String expectedRooks, String expectedBishops, String expectedKnights ) {
        wrapper.givenALocation_verifyTheLocationsForVariousTransformations( location, expectedRooks, expectedBishops, expectedKnights );
    }
}

