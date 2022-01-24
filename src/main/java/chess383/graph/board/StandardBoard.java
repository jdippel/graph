/*
 *  StandardBoard.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2015-2022 Jörg Dippel
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

import chess383.ColorEnum;
import chess383.ICoordinate;
import chess383.graph.direction.Direction;
import chess383.graph.line.*;


/**
 * Provides locations on a bundle of lines for a standard board.
 *
 * @author    Jörg Dippel
 * @version   January 2022
 *
 */
public class StandardBoard extends LineBundle {
        
    static final private StandardBoard singleton = new StandardBoard();
    static public ICoordinate getInstance() { return singleton; }
    static public List<LineOfLocations> getStaticBundle() { return StandardBoard.bundle; }
    
    public List<LineOfLocations> getBundle() { return getStaticBundle(); }
       
    private StandardBoard( ) {}

    /** ------------------------------------------------------- */

    static final private List<LineOfLocations> bundle = List.of(

            UndirectedRowsLine.createLine(           "a1 b1 c1 d1 e1 f1 g1 h1" ),
            UndirectedRowsLine.createReversedLine(   "a1 b1 c1 d1 e1 f1 g1 h1" ),
            UndirectedRowsLine.createLine(           "a2 b2 c2 d2 e2 f2 g2 h2" ),
            UndirectedRowsLine.createReversedLine(   "a2 b2 c2 d2 e2 f2 g2 h2" ),
            UndirectedRowsLine.createLine(           "a3 b3 c3 d3 e3 f3 g3 h3" ),
            UndirectedRowsLine.createReversedLine(   "a3 b3 c3 d3 e3 f3 g3 h3" ),
            UndirectedRowsLine.createLine(           "a4 b4 c4 d4 e4 f4 g4 h4" ),
            UndirectedRowsLine.createReversedLine(   "a4 b4 c4 d4 e4 f4 g4 h4" ),
            UndirectedRowsLine.createLine(           "a5 b5 c5 d5 e5 f5 g5 h5" ),
            UndirectedRowsLine.createReversedLine(   "a5 b5 c5 d5 e5 f5 g5 h5" ),
            UndirectedRowsLine.createLine(           "a6 b6 c6 d6 e6 f6 g6 h6" ),
            UndirectedRowsLine.createReversedLine(   "a6 b6 c6 d6 e6 f6 g6 h6" ),
            UndirectedRowsLine.createLine(           "a7 b7 c7 d7 e7 f7 g7 h7" ),
            UndirectedRowsLine.createReversedLine(   "a7 b7 c7 d7 e7 f7 g7 h7" ),
            UndirectedRowsLine.createLine(           "a8 b8 c8 d8 e8 f8 g8 h8" ),
            UndirectedRowsLine.createReversedLine(   "a8 b8 c8 d8 e8 f8 g8 h8" ),

            DirectedFilesLine.createLine(            "a1 a2 a3 a4 a5 a6 a7 a8" ),
            DirectedFilesLine.createReversedLine(    "a1 a2 a3 a4 a5 a6 a7 a8" ),
            DirectedFilesLine.createLine(            "b1 b2 b3 b4 b5 b6 b7 b8" ),
            DirectedFilesLine.createReversedLine(    "b1 b2 b3 b4 b5 b6 b7 b8" ),
            DirectedFilesLine.createLine(            "c1 c2 c3 c4 c5 c6 c7 c8" ),
            DirectedFilesLine.createReversedLine(    "c1 c2 c3 c4 c5 c6 c7 c8" ),
            DirectedFilesLine.createLine(            "d1 d2 d3 d4 d5 d6 d7 d8" ),
            DirectedFilesLine.createReversedLine(    "d1 d2 d3 d4 d5 d6 d7 d8" ),
            DirectedFilesLine.createLine(            "e1 e2 e3 e4 e5 e6 e7 e8" ),
            DirectedFilesLine.createReversedLine(    "e1 e2 e3 e4 e5 e6 e7 e8" ),
            DirectedFilesLine.createLine(            "f1 f2 f3 f4 f5 f6 f7 f8" ),
            DirectedFilesLine.createReversedLine(    "f1 f2 f3 f4 f5 f6 f7 f8" ),
            DirectedFilesLine.createLine(            "g1 g2 g3 g4 g5 g6 g7 g8" ),
            DirectedFilesLine.createReversedLine(    "g1 g2 g3 g4 g5 g6 g7 g8" ),
            DirectedFilesLine.createLine(            "h1 h2 h3 h4 h5 h6 h7 h8" ),
            DirectedFilesLine.createReversedLine(    "h1 h2 h3 h4 h5 h6 h7 h8" ),

            DirectedDiagonalLine.createLine(         "a1 b2 c3 d4 e5 f6 g7 h8" ),
            DirectedDiagonalLine.createReversedLine( "a1 b2 c3 d4 e5 f6 g7 h8" ),
            DirectedDiagonalLine.createLine(         "a2 b3 c4 d5 e6 f7 g8" ),
            DirectedDiagonalLine.createReversedLine( "a2 b3 c4 d5 e6 f7 g8" ),
            DirectedDiagonalLine.createLine(         "a3 b4 c5 d6 e7 f8" ),
            DirectedDiagonalLine.createReversedLine( "a3 b4 c5 d6 e7 f8" ),
            DirectedDiagonalLine.createLine(         "a4 b5 c6 d7 e8" ),
            DirectedDiagonalLine.createReversedLine( "a4 b5 c6 d7 e8" ),
            DirectedDiagonalLine.createLine(         "a5 b6 c7 d8" ),
            DirectedDiagonalLine.createReversedLine( "a5 b6 c7 d8" ),
            DirectedDiagonalLine.createLine(         "a6 b7 c8" ),
            DirectedDiagonalLine.createReversedLine( "a6 b7 c8" ),
            DirectedDiagonalLine.createLine(         "a7 b8" ),
            DirectedDiagonalLine.createReversedLine( "a7 b8" ),
            DirectedDiagonalLine.createLine(         "b1 c2 d3 e4 f5 g6 h7" ),
            DirectedDiagonalLine.createReversedLine( "b1 c2 d3 e4 f5 g6 h7" ),
            DirectedDiagonalLine.createLine(         "b1 a2" ),
            DirectedDiagonalLine.createReversedLine( "b1 a2" ),
            DirectedDiagonalLine.createLine(         "c1 d2 e3 f4 g5 h6" ),
            DirectedDiagonalLine.createReversedLine( "c1 d2 e3 f4 g5 h6" ),
            DirectedDiagonalLine.createLine(         "c1 b2 a3" ),
            DirectedDiagonalLine.createReversedLine( "c1 b2 a3" ),
            DirectedDiagonalLine.createLine(         "d1 e2 f3 g4 h5" ),
            DirectedDiagonalLine.createReversedLine( "d1 e2 f3 g4 h5" ),
            DirectedDiagonalLine.createLine(         "d1 c2 b3 a4" ),
            DirectedDiagonalLine.createReversedLine( "d1 c2 b3 a4" ),
            DirectedDiagonalLine.createLine(         "e1 f2 g3 h4" ),
            DirectedDiagonalLine.createReversedLine( "e1 f2 g3 h4" ),
            DirectedDiagonalLine.createLine(         "e1 d2 c3 b4 a5" ),
            DirectedDiagonalLine.createReversedLine( "e1 d2 c3 b4 a5" ),
            DirectedDiagonalLine.createLine(         "f1 g2 h3" ),
            DirectedDiagonalLine.createReversedLine( "f1 g2 h3" ),
            DirectedDiagonalLine.createLine(         "f1 e2 d3 c4 b5 a6" ),
            DirectedDiagonalLine.createReversedLine( "f1 e2 d3 c4 b5 a6" ),
            DirectedDiagonalLine.createLine(         "g1 h2" ),
            DirectedDiagonalLine.createReversedLine( "g1 h2" ),
            DirectedDiagonalLine.createLine(         "g1 f2 e3 d4 c5 b6 a7" ),
            DirectedDiagonalLine.createReversedLine( "g1 f2 e3 d4 c5 b6 a7" ),
            DirectedDiagonalLine.createLine(         "h1 g2 f3 e4 d5 c6 b7 a8" ),
            DirectedDiagonalLine.createReversedLine( "h1 g2 f3 e4 d5 c6 b7 a8" ),
            DirectedDiagonalLine.createLine(         "h2 g3 f4 e5 d6 c7 b8" ),
            DirectedDiagonalLine.createReversedLine( "h2 g3 f4 e5 d6 c7 b8" ),
            DirectedDiagonalLine.createLine(         "h3 g4 f5 e6 d7 c8" ),
            DirectedDiagonalLine.createReversedLine( "h3 g4 f5 e6 d7 c8" ),
            DirectedDiagonalLine.createLine(         "h4 g5 f6 e7 d8" ),
            DirectedDiagonalLine.createReversedLine( "h4 g5 f6 e7 d8" ),
            DirectedDiagonalLine.createLine(         "h5 g6 f7 e8" ),
            DirectedDiagonalLine.createReversedLine( "h5 g6 f7 e8" ),
            DirectedDiagonalLine.createLine(         "h6 g7 f8" ),
            DirectedDiagonalLine.createReversedLine( "h6 g7 f8" ),
            DirectedDiagonalLine.createLine(         "h7 g8" ),
            DirectedDiagonalLine.createReversedLine( "h7 g8" ),

            KnightsLine.createLine(                 "a1 b3 c5 d7" ),
            KnightsLine.createReversedLine(         "a1 b3 c5 d7" ),
            KnightsLine.createLine(                 "a1 c2 e3 g4" ),
            KnightsLine.createReversedLine(         "a1 c2 e3 g4" ),
            KnightsLine.createLine(                 "a2 b4 c6 d8" ),
            KnightsLine.createReversedLine(         "a2 b4 c6 d8" ),
            KnightsLine.createLine(                 "a2 c3 e4 g5" ),
            KnightsLine.createReversedLine(         "a2 c3 e4 g5" ),
            KnightsLine.createLine(                 "a2 c1" ),
            KnightsLine.createReversedLine(         "a2 c1" ),
            KnightsLine.createLine(                 "a3 b5 c7" ),
            KnightsLine.createReversedLine(         "a3 b5 c7" ),
            KnightsLine.createLine(                 "a3 c4 e5 g6" ),
            KnightsLine.createReversedLine(         "a3 c4 e5 g6" ),
            KnightsLine.createReversedLine(         "a3 c2 e1" ),
            KnightsLine.createLine(                 "a3 c2 e1" ),
            KnightsLine.createReversedLine(         "a3 b1" ),
            KnightsLine.createLine(                 "a3 b1" ),
            KnightsLine.createReversedLine(         "a4 b6 c8" ),
            KnightsLine.createLine(                 "a4 b6 c8" ),
            KnightsLine.createReversedLine(         "a4 c5 e6 g7" ),
            KnightsLine.createLine(                 "a4 c5 e6 g7" ),
            KnightsLine.createReversedLine(         "a4 c3 e2 g1" ),
            KnightsLine.createLine(                 "a4 c3 e2 g1" ),
            KnightsLine.createReversedLine(         "a4 b2" ),
            KnightsLine.createLine(                 "a4 b2" ),
            KnightsLine.createReversedLine(         "a5 b7" ),
            KnightsLine.createLine(                 "a5 b7" ),
            KnightsLine.createReversedLine(         "a5 c6 e7 g8" ),
            KnightsLine.createLine(                 "a5 c6 e7 g8" ),
            KnightsLine.createReversedLine(         "a5 c4 e3 g2" ),
            KnightsLine.createLine(                 "a5 c4 e3 g2" ),
            KnightsLine.createLine(                 "a5 b3 c1" ),
            KnightsLine.createReversedLine(         "a5 b3 c1" ),
            KnightsLine.createLine(                 "a6 b8" ),
            KnightsLine.createReversedLine(         "a6 b8" ),
            KnightsLine.createLine(                 "a6 c7 e8" ),
            KnightsLine.createReversedLine(         "a6 c7 e8" ),
            KnightsLine.createLine(                 "a6 c5 e4 g3" ),
            KnightsLine.createReversedLine(         "a6 c5 e4 g3" ),
            KnightsLine.createLine(                 "a6 b4 c2" ),
            KnightsLine.createReversedLine(         "a6 b4 c2" ),
            KnightsLine.createLine(                 "a7 c8" ),
            KnightsLine.createReversedLine(         "a7 c8" ),
            KnightsLine.createLine(                 "a7 c6 e5 g4" ),
            KnightsLine.createReversedLine(         "a7 c6 e5 g4" ),
            KnightsLine.createLine(                 "a7 b5 c3 d1" ),
            KnightsLine.createReversedLine(         "a7 b5 c3 d1" ),
            KnightsLine.createLine(                 "a8 c7 e6 g5" ),
            KnightsLine.createReversedLine(         "a8 c7 e6 g5" ),
            KnightsLine.createLine(                 "a8 b6 c4 d2" ),
            KnightsLine.createReversedLine(         "a8 b6 c4 d2" ),
            KnightsLine.createLine(                 "b1 c3 d5 e7" ),
            KnightsLine.createReversedLine(         "b1 c3 d5 e7" ),
            KnightsLine.createLine(                 "b1 d2 f3 h4" ),
            KnightsLine.createReversedLine(         "b1 d2 f3 h4" ),
            KnightsLine.createLine(                 "b2 c4 d6 e8" ),
            KnightsLine.createReversedLine(         "b2 c4 d6 e8" ),
            KnightsLine.createLine(                 "b2 d3 f4 h5" ),
            KnightsLine.createReversedLine(         "b2 d3 f4 h5" ),
            KnightsLine.createLine(                 "b2 d1" ),
            KnightsLine.createReversedLine(         "b2 d1" ),
            KnightsLine.createLine(                 "b3 d4 f5 h6" ),
            KnightsLine.createReversedLine(         "b3 d4 f5 h6" ),
            KnightsLine.createLine(                 "b3 d2 f1" ),
            KnightsLine.createReversedLine(         "b3 d2 f1" ),
            KnightsLine.createLine(                 "b4 d5 f6 h7" ),
            KnightsLine.createReversedLine(         "b4 d5 f6 h7" ),
            KnightsLine.createLine(                 "b4 d3 f2 h1" ),
            KnightsLine.createReversedLine(         "b4 d3 f2 h1" ),
            KnightsLine.createLine(                 "b5 d6 f7 h8" ),
            KnightsLine.createReversedLine(         "b5 d6 f7 h8" ),
            KnightsLine.createLine(                 "b5 d4 f3 h2" ),
            KnightsLine.createReversedLine(         "b5 d4 f3 h2" ),
            KnightsLine.createLine(                 "b6 d7 f8" ),
            KnightsLine.createReversedLine(         "b6 d7 f8" ),
            KnightsLine.createLine(                 "b6 d5 f4 h3" ),
            KnightsLine.createReversedLine(         "b6 d5 f4 h3" ),
            KnightsLine.createLine(                 "b7 d8" ),
            KnightsLine.createReversedLine(         "b7 d8" ),
            KnightsLine.createLine(                 "b7 d6 f5 h4" ),
            KnightsLine.createReversedLine(         "b7 d6 f5 h4" ),
            KnightsLine.createLine(                 "b7 c5 d3 e1" ),
            KnightsLine.createReversedLine(         "b7 c5 d3 e1" ),
            KnightsLine.createLine(                 "b8 d7 f6 h5" ),
            KnightsLine.createReversedLine(         "b8 d7 f6 h5" ),
            KnightsLine.createLine(                 "b8 c6 d4 e2" ),
            KnightsLine.createReversedLine(         "b8 c6 d4 e2" ),
            KnightsLine.createLine(                 "c1 d3 e5 f7" ),
            KnightsLine.createReversedLine(         "c1 d3 e5 f7" ),
            KnightsLine.createLine(                 "c1 e2 g3" ),
            KnightsLine.createReversedLine(         "c1 e2 g3" ),
            KnightsLine.createLine(                 "c2 d4 e6 f8" ),
            KnightsLine.createReversedLine(         "c2 d4 e6 f8" ),
            KnightsLine.createLine(                 "c7 d5 e3 f1" ),
            KnightsLine.createReversedLine(         "c7 d5 e3 f1" ),
            KnightsLine.createLine(                 "c8 e7 g6" ),
            KnightsLine.createReversedLine(         "c8 e7 g6" ),
            KnightsLine.createLine(                 "c8 d6 e4 f2" ),
            KnightsLine.createReversedLine(         "c8 d6 e4 f2" ),
            KnightsLine.createLine(                 "d1 e3 f5 g7" ),
            KnightsLine.createReversedLine(         "d1 e3 f5 g7" ),
            KnightsLine.createLine(                 "d1 f2 h3" ),
            KnightsLine.createReversedLine(         "d1 f2 h3" ),
            KnightsLine.createLine(                 "d2 e4 f6 g8" ),
            KnightsLine.createReversedLine(         "d2 e4 f6 g8" ),
            KnightsLine.createLine(                 "d7 e5 f3 g1" ),
            KnightsLine.createReversedLine(         "d7 e5 f3 g1" ),
            KnightsLine.createLine(                 "d8 f7 h6" ),
            KnightsLine.createReversedLine(         "d8 f7 h6" ),
            KnightsLine.createLine(                 "d8 e6 f4 g2" ),
            KnightsLine.createReversedLine(         "d8 e6 f4 g2" ),
            KnightsLine.createLine(                 "e1 f3 g5 h7" ),
            KnightsLine.createReversedLine(         "e1 f3 g5 h7" ),
            KnightsLine.createLine(                 "e1 g2" ),
            KnightsLine.createReversedLine(         "e1 g2" ),
            KnightsLine.createLine(                 "e2 f4 g6 h8" ),
            KnightsLine.createReversedLine(         "e2 f4 g6 h8" ),
            KnightsLine.createLine(                 "e7 f5 g3 h1" ),
            KnightsLine.createReversedLine(         "e7 f5 g3 h1" ),
            KnightsLine.createLine(                 "e8 g7" ),
            KnightsLine.createReversedLine(         "e8 g7" ),
            KnightsLine.createLine(                 "e8 f6 g4 h2" ),
            KnightsLine.createReversedLine(         "e8 f6 g4 h2" ),
            KnightsLine.createLine(                 "f1 g3 h5" ),
            KnightsLine.createReversedLine(         "f1 g3 h5" ),
            KnightsLine.createLine(                 "f1 h2" ),
            KnightsLine.createReversedLine(         "f1 h2" ),
            KnightsLine.createLine(                 "f2 g4 h6" ),
            KnightsLine.createReversedLine(         "f2 g4 h6" ),
            KnightsLine.createLine(                 "f7 g5 h3" ),
            KnightsLine.createReversedLine(         "f7 g5 h3" ),
            KnightsLine.createLine(                 "f8 h7" ),
            KnightsLine.createReversedLine(         "f8 h7" ),
            KnightsLine.createLine(                 "f8 g6 h4" ),
            KnightsLine.createReversedLine(         "f8 g6 h4" ),
            KnightsLine.createLine(                 "g1 h3" ),
            KnightsLine.createReversedLine(         "g1 h3" ),
            KnightsLine.createLine(                 "g2 h4" ),
            KnightsLine.createReversedLine(         "g2 h4" ),
            KnightsLine.createLine(                 "g7 h5" ),
            KnightsLine.createReversedLine(         "g7 h5" ),
            KnightsLine.createLine(                 "g8 h6" ),
            KnightsLine.createReversedLine(         "g8 h6" )

    );
}

