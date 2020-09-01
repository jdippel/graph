/*
 *  StandardBoard.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2015-2020 Jörg Dippel
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

import java.util.ArrayList;
import java.util.List;

import chess383.graph.line.LineOfLocations;


/**
 * Provides locations on a bundle of lines for a standard board.
 *
 * @author    Jörg Dippel
 * @version   August 2020
 *
 */
public class StandardBoard extends LineBundle {
        
    public StandardBoard( ) {
        bundle = create( );
    }

    /** ------------------------------------------------------- */
    
    private List<LineOfLocations> create( ) {
        
        final int NUMBER_OF_LINES = 114;
        List<LineOfLocations> factory = new ArrayList<LineOfLocations>( NUMBER_OF_LINES );
        
        factory.add( createRankLine(       "a1 b1 c1 d1 e1 f1 g1 h1" ) );
        factory.add( createRankLine(       "a2 b2 c2 d2 e2 f2 g2 h2" ) );
        factory.add( createRankLine(       "a3 b3 c3 d3 e3 f3 g3 h3" ) );
        factory.add( createRankLine(       "a4 b4 c4 d4 e4 f4 g4 h4" ) );
        factory.add( createRankLine(       "a5 b5 c5 d5 e5 f5 g5 h5" ) );
        factory.add( createRankLine(       "a6 b6 c6 d6 e6 f6 g6 h6" ) );
        factory.add( createRankLine(       "a7 b7 c7 d7 e7 f7 g7 h7" ) );
        factory.add( createRankLine(       "a8 b8 c8 d8 e8 f8 g8 h8" ) );
        factory.add( createFileLine(       "a1 a2 a3 a4 a5 a6 a7 a8" ) );
        factory.add( createFileLine(       "b1 b2 b3 b4 b5 b6 b7 b8" ) );
        factory.add( createFileLine(       "c1 c2 c3 c4 c5 c6 c7 c8" ) );
        factory.add( createFileLine(       "d1 d2 d3 d4 d5 d6 d7 d8" ) );
        factory.add( createFileLine(       "e1 e2 e3 e4 e5 e6 e7 e8" ) );
        factory.add( createFileLine(       "f1 f2 f3 f4 f5 f6 f7 f8" ) );
        factory.add( createFileLine(       "g1 g2 g3 g4 g5 g6 g7 g8" ) );
        factory.add( createFileLine(       "h1 h2 h3 h4 h5 h6 h7 h8" ) );
        factory.add( createDiagonalLine(   "a1 b2 c3 d4 e5 f6 g7 h8" ) );
        factory.add( createDiagonalLine(   "a2 b3 c4 d5 e6 f7 g8" ) );
        factory.add( createDiagonalLine(   "a3 b4 c5 d6 e7 f8" ) );
        factory.add( createDiagonalLine(   "a4 b5 c6 d7 e8" ) );
        factory.add( createDiagonalLine(   "a5 b6 c7 d8" ) );
        factory.add( createDiagonalLine(   "a6 b7 c8" ) );
        factory.add( createDiagonalLine(   "a7 b8" ) );
        factory.add( createDiagonalLine(   "b1 c2 d3 e4 f5 g6 h7" ) );
        factory.add( createDiagonalLine(   "b1 a2" ) );
        factory.add( createDiagonalLine(   "c1 d2 e3 f4 g5 h6" ) );
        factory.add( createDiagonalLine(   "c1 b2 a3" ) );
        factory.add( createDiagonalLine(   "d1 e2 f3 g4 h5" ) );
        factory.add( createDiagonalLine(   "d1 c2 b3 a4" ) );
        factory.add( createDiagonalLine(   "e1 f2 g3 h4" ) );
        factory.add( createDiagonalLine(   "e1 d2 c3 b4 a5" ) );
        factory.add( createDiagonalLine(   "f1 g2 h3" ) );
        factory.add( createDiagonalLine(   "f1 e2 d3 c4 b5 a6" ) );
        factory.add( createDiagonalLine(   "g1 h2" ) );
        factory.add( createDiagonalLine(   "g1 f2 e3 d4 c5 b6 a7" ) );
        factory.add( createDiagonalLine(   "h1 g2 f3 e4 d5 c6 b7 a8" ) );
        factory.add( createDiagonalLine(   "h2 g3 f4 e5 d6 c7 b8" ) );
        factory.add( createDiagonalLine(   "h3 g4 f5 e6 d7 c8" ) );
        factory.add( createDiagonalLine(   "h4 g5 f6 e7 d8" ) );
        factory.add( createDiagonalLine(   "h5 g6 f7 e8" ) );
        factory.add( createDiagonalLine(   "h6 g7 f8" ) );
        factory.add( createDiagonalLine(   "h7 g8" ) );
        factory.add( createKnightLine(     "a1 b3 c5 d7" ) );
        factory.add( createKnightLine(     "a1 c2 e3 g4" ) );
        factory.add( createKnightLine(     "a2 b4 c6 d8" ) );
        factory.add( createKnightLine(     "a2 c3 e4 g5" ) );
        factory.add( createKnightLine(     "a2 c1" ) );
        factory.add( createKnightLine(     "a3 b5 c7" ) );
        factory.add( createKnightLine(     "a3 c4 e5 g6" ) );
        factory.add( createKnightLine(     "a3 c2 e1" ) );
        factory.add( createKnightLine(     "a3 b1" ) );
        factory.add( createKnightLine(     "a4 b6 c8" ) );
        factory.add( createKnightLine(     "a4 c5 e6 g7" ) );
        factory.add( createKnightLine(     "a4 c3 e2 g1" ) );
        factory.add( createKnightLine(     "a4 b2" ) );
        factory.add( createKnightLine(     "a5 b7" ) );
        factory.add( createKnightLine(     "a5 c6 e7 g8" ) );
        factory.add( createKnightLine(     "a5 c4 e3 g2" ) );
        factory.add( createKnightLine(     "a5 b3 c1" ) );
        factory.add( createKnightLine(     "a6 b8" ) );
        factory.add( createKnightLine(     "a6 c7 e8" ) );
        factory.add( createKnightLine(     "a6 c5 e4 g3" ) );
        factory.add( createKnightLine(     "a6 b4 c2" ) );
        factory.add( createKnightLine(     "a7 c8" ) );
        factory.add( createKnightLine(     "a7 c6 e5 g4" ) );
        factory.add( createKnightLine(     "a7 b5 c3 d1" ) );
        factory.add( createKnightLine(     "a8 c7 e6 g5" ) );
        factory.add( createKnightLine(     "a8 b6 c4 d2" ) );
        factory.add( createKnightLine(     "b1 c3 d5 e7" ) );
        factory.add( createKnightLine(     "b1 d2 f3 h4" ) );
        factory.add( createKnightLine(     "b2 c4 d6 e8" ) );
        factory.add( createKnightLine(     "b2 d3 f4 h5" ) );
        factory.add( createKnightLine(     "b2 d1" ) );
        factory.add( createKnightLine(     "b3 d4 f5 h6" ) );
        factory.add( createKnightLine(     "b3 d2 f1" ) );
        factory.add( createKnightLine(     "b4 d5 f6 h7" ) );
        factory.add( createKnightLine(     "b4 d3 f2 h1" ) );
        factory.add( createKnightLine(     "b5 d6 f7 h8" ) );
        factory.add( createKnightLine(     "b5 d4 f3 h2" ) );
        factory.add( createKnightLine(     "b6 d7 f8" ) );
        factory.add( createKnightLine(     "b6 d5 f4 h3" ) );
        factory.add( createKnightLine(     "b7 d8" ) );
        factory.add( createKnightLine(     "b7 d6 f5 h4" ) );
        factory.add( createKnightLine(     "b7 c5 d3 e1" ) );
        factory.add( createKnightLine(     "b8 d7 f6 h5" ) );
        factory.add( createKnightLine(     "b8 c6 d4 e2" ) );
        factory.add( createKnightLine(     "c1 d3 e5 f7" ) );
        factory.add( createKnightLine(     "c1 e2 g3" ) );
        factory.add( createKnightLine(     "c2 d4 e6 f8" ) );
        factory.add( createKnightLine(     "c7 d5 e3 f1" ) );
        factory.add( createKnightLine(     "c8 e7 g6" ) );
        factory.add( createKnightLine(     "c8 d6 e4 f2" ) );
        factory.add( createKnightLine(     "d1 e3 f5 g7" ) );
        factory.add( createKnightLine(     "d1 f2 h3" ) );
        factory.add( createKnightLine(     "d2 e4 f6 g8" ) );
        factory.add( createKnightLine(     "d7 e5 f3 g1" ) );
        factory.add( createKnightLine(     "d8 f7 h6" ) );
        factory.add( createKnightLine(     "d8 e6 f4 g2" ) );
        factory.add( createKnightLine(     "e1 f3 g5 h7" ) );
        factory.add( createKnightLine(     "e1 g2" ) );
        factory.add( createKnightLine(     "e2 f4 g6 h8" ) );
        factory.add( createKnightLine(     "e7 f5 g3 h1" ) );
        factory.add( createKnightLine(     "e8 g7" ) );
        factory.add( createKnightLine(     "e8 f6 g4 h2" ) );
        factory.add( createKnightLine(     "f1 g3 h5" ) );
        factory.add( createKnightLine(     "f1 h2" ) );
        factory.add( createKnightLine(     "f2 g4 h6" ) );
        factory.add( createKnightLine(     "f7 g5 h3" ) );
        factory.add( createKnightLine(     "f8 h7" ) );
        factory.add( createKnightLine(     "f8 g6 h4" ) );
        factory.add( createKnightLine(     "g1 h3" ) );
        factory.add( createKnightLine(     "g2 h4" ) );
        factory.add( createKnightLine(     "g7 h5" ) );
        factory.add( createKnightLine(     "g8 h6" ) );

        return( factory );
    }
}
