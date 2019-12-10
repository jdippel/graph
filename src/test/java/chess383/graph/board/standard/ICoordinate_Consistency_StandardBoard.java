/*
 *  ICoordinate_Consistency_StandardBoard.java
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

package chess383.graph.board.standard;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import chess383.ICoordinateFactory;
import chess383.graph.board.ICoordinate_Consistency_Wrapper;

/**
 * <p>
 * The class ICoordinate_Consistency_StandardBoard implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method Set<List<String>> getLineBundles() for class ICoordinate_Consistency_StandardBoard is tested")
public class ICoordinate_Consistency_StandardBoard extends ICoordinate_Consistency_Wrapper { 

    static { setBoard( ICoordinateFactory.STANDARD.get( ) ); }
    
    @ParameterizedTest( name = "given a standard board from location {0} someone can move to: {1}, {2} or {3}" )
    @DisplayName("given a location then following locations can be reached in  an area of distance two")
    @CsvSource({ "a1, a2 a3 b1 c1, b2 c3, b3 c2",
                 "a2, a1 a3 a4 b2 c2, b1 b3 c4, b4 c1 c3",
                 "a3, a1 a2 a4 a5 b3 c3, b2 b4 c1 c5, b1 b5 c2 c4",
                 "a4, a2 a3 a5 a6 b4 c4, b3 b5 c2 c6, b2 b6 c3 c5",
                 "a5, a3 a4 a6 a7 b5 c5, b4 b6 c3 c7, b3 b7 c4 c6",
                 "a6, a4 a5 a7 a8 b6 c6, b5 b7 c4 c8, b4 b8 c5 c7",
                 "a7, a5 a6 a8 b7 c7, b6 b8 c5, b5 c6 c8",
                 "a8, a6 a7 b8 c8, b7 c6, b6 c7",
                 "b1, a1 b2 b3 c1 d1, a2 c2 d3, a3 c3 d2",
                 "b2, a2 b1 b3 b4 c2 d2, a1 a3 c1 c3 d4, a4 c4 d1 d3",
                 "b3, a3 b1 b2 b4 b5 c3 d3, a2 a4 c2 c4 d1 d5, a1 a5 c1 c5 d2 d4",
                 "b4, a4 b2 b3 b5 b6 c4 d4, a3 a5 c3 c5 d2 d6, a2 a6 c2 c6 d3 d5",
                 "b5, a5 b3 b4 b6 b7 c5 d5, a4 a6 c4 c6 d3 d7, a3 a7 c3 c7 d4 d6",
                 "b6, a6 b4 b5 b7 b8 c6 d6, a5 a7 c5 c7 d4 d8, a4 a8 c4 c8 d5 d7",
                 "b7, a7 b5 b6 b8 c7 d7, a6 a8 c6 c8 d5, a5 c5 d6 d8",
                 "b8, a8 b6 b7 c8 d8, a7 c7 d6, a6 c6 d7",
                 "c1, a1 b1 c2 c3 d1 e1, a3 b2 d2 e3, a2 b3 d3 e2",
                 "c2, a2 b2 c1 c3 c4 d2 e2, a4 b1 b3 d1 d3 e4, a1 a3 b4 d4 e1 e3",
                 "c3, a3 b3 c1 c2 c4 c5 d3 e3, a1 a5 b2 b4 d2 d4 e1 e5, a2 a4 b1 b5 d1 d5 e2 e4",
                 "c4, a4 b4 c2 c3 c5 c6 d4 e4, a2 a6 b3 b5 d3 d5 e2 e6, a3 a5 b2 b6 d2 d6 e3 e5",
                 "c5, a5 b5 c3 c4 c6 c7 d5 e5, a3 a7 b4 b6 d4 d6 e3 e7, a4 a6 b3 b7 d3 d7 e4 e6",
                 "c6, a6 b6 c4 c5 c7 c8 d6 e6, a4 a8 b5 b7 d5 d7 e4 e8, a5 a7 b4 b8 d4 d8 e5 e7",
                 "c7, a7 b7 c5 c6 c8 d7 e7, a5 b6 b8 d6 d8 e5, a6 a8 b5 d5 e6 e8",
                 "c8, a8 b8 c6 c7 d8 e8, a6 b7 d7 e6, a7 b6 d6 e7",
                 "d1, b1 c1 d2 d3 e1 f1, b3 c2 e2 f3, b2 c3 e3 f2",
                 "d2, b2 c2 d1 d3 d4 e2 f2, b4 c1 c3 e1 e3 f4, b1 b3 c4 e4 f1 f3",
                 "d3, b3 c3 d1 d2 d4 d5 e3 f3, b1 b5 c2 c4 e2 e4 f1 f5, b2 b4 c1 c5 e1 e5 f2 f4",
                 "d4, b4 c4 d2 d3 d5 d6 e4 f4, b2 b6 c3 c5 e3 e5 f2 f6, b3 b5 c2 c6 e2 e6 f3 f5",
                 "d5, b5 c5 d3 d4 d6 d7 e5 f5, b3 b7 c4 c6 e4 e6 f3 f7, b4 b6 c3 c7 e3 e7 f4 f6",
                 "d6, b6 c6 d4 d5 d7 d8 e6 f6, b4 b8 c5 c7 e5 e7 f4 f8, b5 b7 c4 c8 e4 e8 f5 f7",
                 "d7, b7 c7 d5 d6 d8 e7 f7, b5 c6 c8 e6 e8 f5, b6 b8 c5 e5 f6 f8",
                 "d8, b8 c8 d6 d7 e8 f8, b6 c7 e7 f6, b7 c6 e6 f7",
                 "e1, c1 d1 e2 e3 f1 g1, c3 d2 f2 g3, c2 d3 f3 g2",
                 "e2, c2 d2 e1 e3 e4 f2 g2, c4 d1 d3 f1 f3 g4, c1 c3 d4 f4 g1 g3",
                 "e3, c3 d3 e1 e2 e4 e5 f3 g3, c1 c5 d2 d4 f2 f4 g1 g5, c2 c4 d1 d5 f1 f5 g2 g4",
                 "e4, c4 d4 e2 e3 e5 e6 f4 g4, c2 c6 d3 d5 f3 f5 g2 g6, c3 c5 d2 d6 f2 f6 g3 g5",
                 "e5, c5 d5 e3 e4 e6 e7 f5 g5, c3 c7 d4 d6 f4 f6 g3 g7, c4 c6 d3 d7 f3 f7 g4 g6",
                 "e6, c6 d6 e4 e5 e7 e8 f6 g6, c4 c8 d5 d7 f5 f7 g4 g8, c5 c7 d4 d8 f4 f8 g5 g7",
                 "e7, c7 d7 e5 e6 e8 f7 g7, c5 d6 d8 f6 f8 g5, c6 c8 d5 f5 g6 g8",
                 "e8, c8 d8 e6 e7 f8 g8, c6 d7 f7 g6, c7 d6 f6 g7",
                 "f1, d1 e1 f2 f3 g1 h1, d3 e2 g2 h3, d2 e3 g3 h2",
                 "f2, d2 e2 f1 f3 f4 g2 h2, d4 e1 e3 g1 g3 h4, d1 d3 e4 g4 h1 h3",
                 "f3, d3 e3 f1 f2 f4 f5 g3 h3, d1 d5 e2 e4 g2 g4 h1 h5, d2 d4 e1 e5 g1 g5 h2 h4",
                 "f4, d4 e4 f2 f3 f5 f6 g4 h4, d2 d6 e3 e5 g3 g5 h2 h6, d3 d5 e2 e6 g2 g6 h3 h5",
                 "f5, d5 e5 f3 f4 f6 f7 g5 h5, d3 d7 e4 e6 g4 g6 h3 h7, d4 d6 e3 e7 g3 g7 h4 h6",
                 "f6, d6 e6 f4 f5 f7 f8 g6 h6, d4 d8 e5 e7 g5 g7 h4 h8, d5 d7 e4 e8 g4 g8 h5 h7",
                 "f7, d7 e7 f5 f6 f8 g7 h7, d5 e6 e8 g6 g8 h5, d6 d8 e5 g5 h6 h8",
                 "f8, d8 e8 f6 f7 g8 h8, d6 e7 g7 h6, d7 e6 g6 h7",
                 "g1, e1 f1 g2 g3 h1, e3 f2 h2, e2 f3 h3",
                 "g2, e2 f2 g1 g3 g4 h2, e4 f1 f3 h1 h3, e1 e3 f4 h4",
                 "g3, e3 f3 g1 g2 g4 g5 h3, e1 e5 f2 f4 h2 h4, e2 e4 f1 f5 h1 h5",
                 "g4, e4 f4 g2 g3 g5 g6 h4, e2 e6 f3 f5 h3 h5, e3 e5 f2 f6 h2 h6",
                 "g5, e5 f5 g3 g4 g6 g7 h5, e3 e7 f4 f6 h4 h6, e4 e6 f3 f7 h3 h7",
                 "g6, e6 f6 g4 g5 g7 g8 h6, e4 e8 f5 f7 h5 h7, e5 e7 f4 f8 h4 h8",
                 "g7, e7 f7 g5 g6 g8 h7, e5 f6 f8 h6 h8, e6 e8 f5 h5",
                 "g8, e8 f8 g6 g7 h8, e6 f7 h7, e7 f6 h6",
                 "h1, f1 g1 h2 h3, f3 g2, f2 g3",
                 "h2, f2 g2 h1 h3 h4, f4 g1 g3, f1 f3 g4",
                 "h3, f3 g3 h1 h2 h4 h5, f1 f5 g2 g4, f2 f4 g1 g5",
                 "h4, f4 g4 h2 h3 h5 h6, f2 f6 g3 g5, f3 f5 g2 g6",
                 "h5, f5 g5 h3 h4 h6 h7, f3 f7 g4 g6, f4 f6 g3 g7",
                 "h6, f6 g6 h4 h5 h7 h8, f4 f8 g5 g7, f5 f7 g4 g8",
                 "h7, f7 g7 h5 h6 h8, f5 g6 g8, f6 f8 g5",  
                 "h8, f8 g8 h6 h7, f6 g7, f7 g6" })
    void test( String location, String expectedRooks, String expectedBishops, String expectedKnights ) {
        givenALocation_verifyTheLocationsForVariousTransformations( location, expectedRooks, expectedBishops, expectedKnights );
    }
}

