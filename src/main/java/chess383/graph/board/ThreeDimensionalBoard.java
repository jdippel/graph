/*
 *  ThreeDimensionalBoard.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2016 - 2022 Jörg Dippel
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

package chess383.graph.board;

import java.util.List;

import chess383.ICoordinate;
import chess383.graph.line.*;

/**
 * Provides locations on a bundle of lines for a three dimensional board for two players.
 * Please have a look to the descriptions of rules, search for rules by Jens Meder ...
 *
 * @author    Jörg Dippel
 * @version   January 2022
 *
 */
public class ThreeDimensionalBoard extends LineBundle {
    
    static private final ThreeDimensionalBoard singleton = new ThreeDimensionalBoard();
    static public  ICoordinate getInstance() { return singleton; }
    static public List<LineOfLocations> getStaticBundle() { return ThreeDimensionalBoard.bundle; }
    
    public List<LineOfLocations> getBundle() { return getStaticBundle(); }
       
    private ThreeDimensionalBoard( ) {}

    /** ------------------------------------------------------- */
    
    //  final int NUMBER_OF_LINES = 12 + 6 + 26 + 66;
    static private final List<LineOfLocations> bundle = List.of(

            UndirectedRowsLine.createLine(           "z0 a0" ),
            UndirectedRowsLine.createReversedLine(   "z0 a0" ),
            UndirectedRowsLine.createLine(           "d0 e0" ),
            UndirectedRowsLine.createReversedLine(   "d0 e0" ),
            UndirectedRowsLine.createLine(           "z1 a1 b1 c1 d1 e1" ),
            UndirectedRowsLine.createReversedLine(   "z1 a1 b1 c1 d1 e1" ),
            UndirectedRowsLine.createLine(           "z2 a2 b2 c2 d2 e2" ),
            UndirectedRowsLine.createReversedLine(   "z2 a2 b2 c2 d2 e2" ),
            UndirectedRowsLine.createLine(           "z3 a3 b3 c3 d3 e3" ),
            UndirectedRowsLine.createReversedLine(   "z3 a3 b3 c3 d3 e3" ),
            UndirectedRowsLine.createLine(           "z4 a4 b4 c4 d4 e4" ),
            UndirectedRowsLine.createReversedLine(   "z4 a4 b4 c4 d4 e4" ),
            UndirectedRowsLine.createLine(           "z5 a5 b5 c5 d5 e5" ),
            UndirectedRowsLine.createReversedLine(   "z5 a5 b5 c5 d5 e5" ),
            UndirectedRowsLine.createLine(           "z6 a6 b6 c6 d6 e6" ),
            UndirectedRowsLine.createReversedLine(   "z6 a6 b6 c6 d6 e6" ),
            UndirectedRowsLine.createLine(           "z7 a7 b7 c7 d7 e7" ),
            UndirectedRowsLine.createReversedLine(   "z7 a7 b7 c7 d7 e7" ),
            UndirectedRowsLine.createLine(           "z8 a8 b8 c8 d8 e8" ),
            UndirectedRowsLine.createReversedLine(   "z8 a8 b8 c8 d8 e8" ),
            UndirectedRowsLine.createLine(           "z9 a9" ),
            UndirectedRowsLine.createReversedLine(   "z9 a9" ),
            UndirectedRowsLine.createLine(           "d9 e9" ),
            UndirectedRowsLine.createReversedLine(   "d9 e9" ),

            DirectedFilesLine.createLine(            "z0 z1 z2 z3 z4 z5 z6 z7 z8 z9" ),
            DirectedFilesLine.createReversedLine(    "z0 z1 z2 z3 z4 z5 z6 z7 z8 z9" ),
            DirectedFilesLine.createLine(            "a0 a1 a2 a3 a4 a5 a6 a7 a8 a9" ),
            DirectedFilesLine.createReversedLine(    "a0 a1 a2 a3 a4 a5 a6 a7 a8 a9" ),
            DirectedFilesLine.createLine(            "b1 b2 b3 b4 b5 b6 b7 b8" ),
            DirectedFilesLine.createReversedLine(    "b1 b2 b3 b4 b5 b6 b7 b8" ),
            DirectedFilesLine.createLine(            "c1 c2 c3 c4 c5 c6 c7 c8" ),
            DirectedFilesLine.createReversedLine(    "c1 c2 c3 c4 c5 c6 c7 c8" ),
            DirectedFilesLine.createLine(            "d0 d1 d2 d3 d4 d5 d6 d7 d8 d9" ),
            DirectedFilesLine.createReversedLine(    "d0 d1 d2 d3 d4 d5 d6 d7 d8 d9" ),
            DirectedFilesLine.createLine(            "e0 e1 e2 e3 e4 e5 e6 e7 e8 e9" ),
            DirectedFilesLine.createReversedLine(    "e0 e1 e2 e3 e4 e5 e6 e7 e8 e9" ),

            DirectedDiagonalLine.createLine(         "z0 a1 b2 c3 d4 e5" ),
            DirectedDiagonalLine.createReversedLine( "z0 a1 b2 c3 d4 e5" ),
            DirectedDiagonalLine.createLine(         "a0 z1" ),
            DirectedDiagonalLine.createReversedLine( "a0 z1" ),
            DirectedDiagonalLine.createLine(         "a0 b1 c2 d3 e4" ),
            DirectedDiagonalLine.createReversedLine( "a0 b1 c2 d3 e4" ),
            DirectedDiagonalLine.createLine(         "d0 c1 b2 a3 z4" ),
            DirectedDiagonalLine.createReversedLine( "d0 c1 b2 a3 z4" ),
            DirectedDiagonalLine.createLine(         "d0 e1" ),
            DirectedDiagonalLine.createReversedLine( "d0 e1" ),
            DirectedDiagonalLine.createLine(         "e0 d1 c2 b3 a4 z5" ),
            DirectedDiagonalLine.createReversedLine( "e0 d1 c2 b3 a4 z5" ),
            DirectedDiagonalLine.createLine(         "z1 a2 b3 c4 d5 e6" ),
            DirectedDiagonalLine.createReversedLine( "z1 a2 b3 c4 d5 e6" ),
            DirectedDiagonalLine.createLine(         "a1 z2" ),
            DirectedDiagonalLine.createReversedLine( "a1 z2" ),
            DirectedDiagonalLine.createLine(         "b1 a2 z3" ),
            DirectedDiagonalLine.createReversedLine( "b1 a2 z3" ),
            DirectedDiagonalLine.createLine(         "c1 d2 e3" ),
            DirectedDiagonalLine.createReversedLine( "c1 d2 e3" ),
            DirectedDiagonalLine.createLine(         "d1 e2" ),
            DirectedDiagonalLine.createReversedLine( "d1 e2" ),
            DirectedDiagonalLine.createLine(         "e1 d2 c3 b4 a5 z6" ),
            DirectedDiagonalLine.createReversedLine( "e1 d2 c3 b4 a5 z6" ),
            DirectedDiagonalLine.createLine(         "z2 a3 b4 c5 d6 e7" ),
            DirectedDiagonalLine.createReversedLine( "z2 a3 b4 c5 d6 e7" ),
            DirectedDiagonalLine.createLine(         "e2 d3 c4 b5 a6 z7" ),
            DirectedDiagonalLine.createReversedLine( "e2 d3 c4 b5 a6 z7" ),
            DirectedDiagonalLine.createLine(         "z3 a4 b5 c6 d7 e8" ),
            DirectedDiagonalLine.createReversedLine( "z3 a4 b5 c6 d7 e8" ),
            DirectedDiagonalLine.createLine(         "e3 d4 c5 b6 a7 z8" ),
            DirectedDiagonalLine.createReversedLine( "e3 d4 c5 b6 a7 z8" ),
            DirectedDiagonalLine.createLine(         "z4 a5 b6 c7 d8 e9" ),
            DirectedDiagonalLine.createReversedLine( "z4 a5 b6 c7 d8 e9" ),
            DirectedDiagonalLine.createLine(         "e4 d5 c6 b7 a8 z9" ),
            DirectedDiagonalLine.createReversedLine( "e4 d5 c6 b7 a8 z9" ),
            DirectedDiagonalLine.createLine(         "z5 a6 b7 c8 d9" ),
            DirectedDiagonalLine.createReversedLine( "z5 a6 b7 c8 d9" ),
            DirectedDiagonalLine.createLine(         "e5 d6 c7 b8 a9" ),
            DirectedDiagonalLine.createReversedLine( "e5 d6 c7 b8 a9" ),
            DirectedDiagonalLine.createLine(         "z6 a7 b8" ),
            DirectedDiagonalLine.createReversedLine( "z6 a7 b8" ),
            DirectedDiagonalLine.createLine(         "e6 d7 c8" ),
            DirectedDiagonalLine.createReversedLine( "e6 d7 c8" ),
            DirectedDiagonalLine.createLine(         "z7 a8" ),
            DirectedDiagonalLine.createReversedLine( "z7 a8" ),
            DirectedDiagonalLine.createLine(         "e7 d8" ),
            DirectedDiagonalLine.createReversedLine( "e7 d8" ),
            DirectedDiagonalLine.createLine(         "z8 a9" ),
            DirectedDiagonalLine.createReversedLine( "z8 a9" ),
            DirectedDiagonalLine.createLine(         "e8 d9" ),
            DirectedDiagonalLine.createReversedLine( "e8 d9" ),

            KnightsLine.createLine(                  "z0 b1 d2" ),
            KnightsLine.createReversedLine(          "z0 b1 d2" ),
            KnightsLine.createLine(                  "z0 a2 b4 c6 d8" ),
            KnightsLine.createReversedLine(          "z0 a2 b4 c6 d8" ),
            KnightsLine.createLine(                  "a0 c1 e2" ),
            KnightsLine.createReversedLine(          "a0 c1 e2" ),
            KnightsLine.createLine(                  "a0 b2 c4 d6 e8" ),
            KnightsLine.createReversedLine(          "a0 b2 c4 d6 e8" ),
            KnightsLine.createLine(                  "a0 z2" ),
            KnightsLine.createReversedLine(          "a0 z2" ),
            KnightsLine.createLine(                  "d0 b1 z2" ),
            KnightsLine.createReversedLine(          "d0 b1 z2" ),
            KnightsLine.createLine(                  "d0 c2 b4 a6 z8" ),
            KnightsLine.createReversedLine(          "d0 c2 b4 a6 z8" ),
            KnightsLine.createLine(                  "d0 e2" ),
            KnightsLine.createReversedLine(          "d0 e2" ),
            KnightsLine.createLine(                  "e0 c1 a2" ),
            KnightsLine.createReversedLine(          "e0 c1 a2" ),
            KnightsLine.createLine(                  "e0 d2 c4 b6 a8" ),
            KnightsLine.createReversedLine(          "e0 d2 c4 b6 a8" ),
            KnightsLine.createLine(                  "z1 b2 d3" ),
            KnightsLine.createReversedLine(          "z1 b2 d3" ),
            KnightsLine.createLine(                  "z1 a3 b5 c7 d9" ),
            KnightsLine.createReversedLine(          "z1 a3 b5 c7 d9" ),
            KnightsLine.createLine(                  "a1 c2 e3" ),
            KnightsLine.createReversedLine(          "a1 c2 e3" ),
            KnightsLine.createLine(                  "a1 b3 c5 d7 e9" ),
            KnightsLine.createReversedLine(          "a1 b3 c5 d7 e9" ),
            KnightsLine.createLine(                  "a1 z3" ),
            KnightsLine.createReversedLine(          "a1 z3" ),
            KnightsLine.createLine(                  "b1 c3 d5 e7" ),
            KnightsLine.createReversedLine(          "b1 c3 d5 e7" ),
            KnightsLine.createLine(                  "b1 a3 z5" ),
            KnightsLine.createReversedLine(          "b1 a3 z5" ),
            KnightsLine.createLine(                  "c1 d3 e5" ),
            KnightsLine.createReversedLine(          "c1 d3 e5" ),
            KnightsLine.createLine(                  "c1 b3 a5 z7" ),
            KnightsLine.createReversedLine(          "c1 b3 a5 z7" ),
            KnightsLine.createLine(                  "d1 e3" ),
            KnightsLine.createReversedLine(          "d1 e3" ),
            KnightsLine.createLine(                  "d1 c3 b5 a7 z9" ),
            KnightsLine.createReversedLine(          "d1 c3 b5 a7 z9" ),
            KnightsLine.createLine(                  "d1 b2 z3" ),
            KnightsLine.createReversedLine(          "d1 b2 z3" ),
            KnightsLine.createLine(                  "e1 d3 c5 b7 a9" ),
            KnightsLine.createReversedLine(          "e1 d3 c5 b7 a9" ),
            KnightsLine.createLine(                  "e1 c2 a3" ),
            KnightsLine.createReversedLine(          "e1 c2 a3" ),
            KnightsLine.createLine(                  "z2 b3 d4" ),
            KnightsLine.createReversedLine(          "z2 b3 d4" ),
            KnightsLine.createLine(                  "z2 a4 b6 c8" ),
            KnightsLine.createReversedLine(          "z2 a4 b6 c8" ),
            KnightsLine.createLine(                  "a2 c3 e4" ),
            KnightsLine.createReversedLine(          "a2 c3 e4" ),
            KnightsLine.createLine(                  "a2 z4" ),
            KnightsLine.createReversedLine(          "a2 z4" ),
            KnightsLine.createLine(                  "b2 a4 z6" ),
            KnightsLine.createReversedLine(          "b2 a4 z6" ),
            KnightsLine.createLine(                  "c2 d4 e6" ),
            KnightsLine.createReversedLine(          "c2 d4 e6" ),
            KnightsLine.createLine(                  "d2 e4" ),
            KnightsLine.createReversedLine(          "d2 e4" ),
            KnightsLine.createLine(                  "d2 b3 z4" ),
            KnightsLine.createReversedLine(          "d2 b3 z4" ),
            KnightsLine.createLine(                  "e2 d4 c6 b8" ),
            KnightsLine.createReversedLine(          "e2 d4 c6 b8" ),
            KnightsLine.createLine(                  "z3 b4 d5" ),
            KnightsLine.createReversedLine(          "z3 b4 d5" ),
            KnightsLine.createLine(                  "z3 a5 b7" ),
            KnightsLine.createReversedLine(          "z3 a5 b7" ),
            KnightsLine.createLine(                  "a3 c4 e5" ),
            KnightsLine.createReversedLine(          "a3 c4 e5" ),
            KnightsLine.createLine(                  "d3 b4 z5" ),
            KnightsLine.createReversedLine(          "d3 b4 z5" ),
            KnightsLine.createLine(                  "e3 d5 c7" ),
            KnightsLine.createReversedLine(          "e3 d5 c7" ),
            KnightsLine.createLine(                  "e3 c4 a5" ),
            KnightsLine.createReversedLine(          "e3 c4 a5" ),
            KnightsLine.createLine(                  "z4 b5 d6" ),
            KnightsLine.createReversedLine(          "z4 b5 d6" ),
            KnightsLine.createLine(                  "z4 a6 b8" ),
            KnightsLine.createReversedLine(          "z4 a6 b8" ),
            KnightsLine.createLine(                  "a4 c5 e6" ),
            KnightsLine.createReversedLine(          "a4 c5 e6" ),
            KnightsLine.createLine(                  "a4 c3 e2" ),
            KnightsLine.createReversedLine(          "a4 c3 e2" ),
            KnightsLine.createLine(                  "d4 b5 z6" ),
            KnightsLine.createReversedLine(          "d4 b5 z6" ),
            KnightsLine.createLine(                  "e4 c5 a6" ),
            KnightsLine.createReversedLine(          "e4 c5 a6" ),
            KnightsLine.createLine(                  "e4 d6 c8" ),
            KnightsLine.createReversedLine(          "e4 d6 c8" ),
            KnightsLine.createLine(                  "z5 b6 d7" ),
            KnightsLine.createReversedLine(          "z5 b6 d7" ),
            KnightsLine.createLine(                  "z5 a7" ),
            KnightsLine.createReversedLine(          "z5 a7" ),
            KnightsLine.createLine(                  "a5 c6 e7" ),
            KnightsLine.createReversedLine(          "a5 c6 e7" ),
            KnightsLine.createLine(                  "d5 b6 z7" ),
            KnightsLine.createReversedLine(          "d5 b6 z7" ),
            KnightsLine.createLine(                  "e5 c6 a7" ),
            KnightsLine.createReversedLine(          "e5 c6 a7" ),
            KnightsLine.createLine(                  "e5 d7" ),
            KnightsLine.createReversedLine(          "e5 d7" ),
            KnightsLine.createLine(                  "z6 b7 d8" ),
            KnightsLine.createReversedLine(          "z6 b7 d8" ),
            KnightsLine.createLine(                  "z6 a8" ),
            KnightsLine.createReversedLine(          "z6 a8" ),
            KnightsLine.createLine(                  "a6 c7 e8" ),
            KnightsLine.createReversedLine(          "a6 c7 e8" ),
            KnightsLine.createLine(                  "d6 b7 z8" ),
            KnightsLine.createReversedLine(          "d6 b7 z8" ),
            KnightsLine.createLine(                  "e6 c7 a8" ),
            KnightsLine.createReversedLine(          "e6 c7 a8" ),
            KnightsLine.createLine(                  "e6 d8" ),
            KnightsLine.createReversedLine(          "e6 d8" ),
            KnightsLine.createLine(                  "z7 b8 d9" ),
            KnightsLine.createReversedLine(          "z7 b8 d9" ),
            KnightsLine.createLine(                  "z7 a9" ),
            KnightsLine.createReversedLine(          "z7 a9" ),
            KnightsLine.createLine(                  "a7 c8 e9" ),
            KnightsLine.createReversedLine(          "a7 c8 e9" ),
            KnightsLine.createLine(                  "d7 b8 z9" ),
            KnightsLine.createReversedLine(          "d7 b8 z9" ),
            KnightsLine.createLine(                  "e7 c8 a9" ),
            KnightsLine.createReversedLine(          "e7 c8 a9" ),
            KnightsLine.createLine(                  "e7 d9" ),
            KnightsLine.createReversedLine(          "e7 d9" )
  
    );
}

