/*
 *  ThreeDimensionalBoard.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2016 - 2021 Jörg Dippel
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
import chess383.graph.line.LineOfLocations;

/**
 * Provides locations on a bundle of lines for a three dimensional board for two players.
 * Please have a look to the descriptions of rules, search for rules by Jens Meder ...
 *
 * @author    Jörg Dippel
 * @version   February 2021
 *
 */
public class ThreeDimensionalBoard extends LineBundle {
    
    static private ThreeDimensionalBoard singleton = new ThreeDimensionalBoard();
    static public  ICoordinate getInstance() { return singleton; }
    static public List<LineOfLocations> getStaticBundle() { return ThreeDimensionalBoard.bundle; }
    
    public List<LineOfLocations> getBundle() { return getStaticBundle(); }
       
    private ThreeDimensionalBoard( ) {}

    /** ------------------------------------------------------- */
    
    //  final int NUMBER_OF_LINES = 12 + 6 + 26 + 66;
    static private List<LineOfLocations> bundle = List.of( 
       
        createRankLine( "z0 a0" ),
        createRankLine( "d0 e0" ),
        createRankLine( "z1 a1 b1 c1 d1 e1" ),
        createRankLine( "z2 a2 b2 c2 d2 e2" ),
        createRankLine( "z3 a3 b3 c3 d3 e3" ),
        createRankLine( "z4 a4 b4 c4 d4 e4" ),
        createRankLine( "z5 a5 b5 c5 d5 e5" ),
        createRankLine( "z6 a6 b6 c6 d6 e6" ),
        createRankLine( "z7 a7 b7 c7 d7 e7" ),
        createRankLine( "z8 a8 b8 c8 d8 e8" ),       
        createRankLine( "z9 a9" ),
        createRankLine( "d9 e9" ),
        
        createFileLine( "z0 z1 z2 z3 z4 z5 z6 z7 z8 z9" ),
        createFileLine( "a0 a1 a2 a3 a4 a5 a6 a7 a8 a9" ),
        createFileLine(    "b1 b2 b3 b4 b5 b6 b7 b8" ),
        createFileLine(    "c1 c2 c3 c4 c5 c6 c7 c8" ),
        createFileLine( "d0 d1 d2 d3 d4 d5 d6 d7 d8 d9" ),
        createFileLine( "e0 e1 e2 e3 e4 e5 e6 e7 e8 e9" ),
        
        createDiagonalLine( "z0 a1 b2 c3 d4 e5" ),
        createDiagonalLine( "a0 z1" ),
        createDiagonalLine( "a0 b1 c2 d3 e4" ),
        createDiagonalLine( "d0 c1 b2 a3 z4" ),
        createDiagonalLine( "d0 e1" ),
        createDiagonalLine( "e0 d1 c2 b3 a4 z5" ),
        createDiagonalLine( "z1 a2 b3 c4 d5 e6" ),
        createDiagonalLine( "a1 z2" ),
        createDiagonalLine( "b1 a2 z3" ),
        createDiagonalLine( "c1 d2 e3" ),
        createDiagonalLine( "d1 e2" ),
        createDiagonalLine( "e1 d2 c3 b4 a5 z6" ),
        createDiagonalLine( "z2 a3 b4 c5 d6 e7" ),
        createDiagonalLine( "e2 d3 c4 b5 a6 z7" ),
        createDiagonalLine( "z3 a4 b5 c6 d7 e8" ),
        createDiagonalLine( "e3 d4 c5 b6 a7 z8" ),
        createDiagonalLine( "z4 a5 b6 c7 d8 e9" ),
        createDiagonalLine( "e4 d5 c6 b7 a8 z9" ),
        createDiagonalLine( "z5 a6 b7 c8 d9" ),
        createDiagonalLine( "e5 d6 c7 b8 a9" ),
        createDiagonalLine( "z6 a7 b8" ),
        createDiagonalLine( "e6 d7 c8" ),
        createDiagonalLine( "z7 a8" ),
        createDiagonalLine( "e7 d8" ),
        createDiagonalLine( "z8 a9" ),
        createDiagonalLine( "e8 d9" ),      

        createKnightLine( "z0 b1 d2" ),
        createKnightLine( "z0 a2 b4 c6 d8" ),
        createKnightLine( "a0 c1 e2" ),
        createKnightLine( "a0 b2 c4 d6 e8" ),
        createKnightLine( "a0 z2" ),
        createKnightLine( "d0 b1 z2" ),
        createKnightLine( "d0 c2 b4 a6 z8" ),
        createKnightLine( "d0 e2" ),
        createKnightLine( "e0 c1 a2" ),
        createKnightLine( "e0 d2 c4 b6 a8" ),
        createKnightLine( "z1 b2 d3" ),
        createKnightLine( "z1 a3 b5 c7 d9" ),
        createKnightLine( "a1 c2 e3" ),
        createKnightLine( "a1 b3 c5 d7 e9" ),
        createKnightLine( "a1 z3" ),
        createKnightLine( "b1 c3 d5 e7" ),
        createKnightLine( "b1 a3 z5" ),
        createKnightLine( "c1 d3 e5" ),
        createKnightLine( "c1 b3 a5 z7" ),
        createKnightLine( "d1 e3" ),
        createKnightLine( "d1 c3 b5 a7 z9" ),
        createKnightLine( "d1 b2 z3" ),
        createKnightLine( "e1 d3 c5 b7 a9" ),
        createKnightLine( "e1 c2 a3" ),
        createKnightLine( "z2 b3 d4" ),
        createKnightLine( "z2 a4 b6 c8" ),
        createKnightLine( "a2 c3 e4" ),
        createKnightLine( "a2 z4" ),
        createKnightLine( "b2 a4 z6" ),
        createKnightLine( "c2 d4 e6" ),
        createKnightLine( "d2 e4" ),
        createKnightLine( "d2 b3 z4" ),
        createKnightLine( "e2 d4 c6 b8" ),
        createKnightLine( "z3 b4 d5" ),
        createKnightLine( "z3 a5 b7" ),
        createKnightLine( "a3 c4 e5" ),
        createKnightLine( "d3 b4 z5" ),
        createKnightLine( "e3 d5 c7" ),
        createKnightLine( "e3 c4 a5" ),
        createKnightLine( "z4 b5 d6" ),
        createKnightLine( "z4 a6 b8" ),
        createKnightLine( "a4 c5 e6" ),
        createKnightLine( "a4 c3 e2" ),
        createKnightLine( "d4 b5 z6" ),
        createKnightLine( "e4 c5 a6" ),
        createKnightLine( "e4 d6 c8" ),
        createKnightLine( "z5 b6 d7" ),
        createKnightLine( "z5 a7" ),
        createKnightLine( "a5 c6 e7" ),
        createKnightLine( "d5 b6 z7" ),
        createKnightLine( "e5 c6 a7" ),
        createKnightLine( "e5 d7" ),
        createKnightLine( "z6 b7 d8" ),
        createKnightLine( "z6 a8" ),
        createKnightLine( "a6 c7 e8" ),
        createKnightLine( "d6 b7 z8" ),
        createKnightLine( "e6 c7 a8" ),
        createKnightLine( "e6 d8" ),
        createKnightLine( "z7 b8 d9" ),
        createKnightLine( "z7 a9" ),
        createKnightLine( "a7 c8 e9" ),
        createKnightLine( "d7 b8 z9" ),
        createKnightLine( "e7 c8 a9" ),
        createKnightLine( "e7 d9" )
  
    );
}

