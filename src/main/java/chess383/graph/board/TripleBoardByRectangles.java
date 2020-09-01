/*
 *  TripleBoardByRectangles.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2015 - 2020 Jörg Dippel
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

import chess383.ColorEnum;
import chess383.graph.direction.Direction;
import chess383.graph.line.LineOfLocations;

/**
 * Provides locations on a bundle of lines for a board for three players: rectangles within a hexagon.
 *
 * @author    Jörg Dippel
 * @version   August 2020
 *
 */
public class TripleBoardByRectangles extends LineBundle {

    public TripleBoardByRectangles( ) {
        bundle = create( );
    }

    /** ------------------------------------------------------- */
    
    private final Direction DIRECTED_WHITE_BLACK = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
    private final Direction DIRECTED_WHITE_RED =   Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.RED );
    private final Direction DIRECTED_BLACK_RED =   Direction.createUnidirectionalDirection( ColorEnum.BLACK, ColorEnum.RED );
    
    
    private List<LineOfLocations> create( ) {
        
        List<LineOfLocations> factory = new ArrayList<LineOfLocations>( 407 );
        
        // createFileLine( VERTICAL, value )
        
        factory.add( createRankLine( "a1 b1 c1 d1 e1 f1 g1 h1" ) );
        factory.add( createRankLine( "a2 b2 c2 d2 e2 f2 g2 h2" ) );
        factory.add( createRankLine( "a3 b3 c3 d3 e3 f3 g3 h3" ) );
        factory.add( createRankLine( "a4 b4 c4 d4 e4 f4 g4 h4" ) );
        
        factory.add( createRankLine( "a8 b8 c8 d8 i8 j8 k8 l8" ) );
        factory.add( createRankLine( "a7 b7 c7 d7 i7 j7 k7 l7" ) );
        factory.add( createRankLine( "a6 b6 c6 d6 i6 j6 k6 l6" ) );
        factory.add( createRankLine( "a5 b5 c5 d5 i5 j5 k5 l5" ) );
        
        factory.add( createRankLine( "h12 g12 f12 e12 i12 j12 k12 l12" ) );
        factory.add( createRankLine( "h11 g11 f11 e11 i11 j11 k11 l11" ) );
        factory.add( createRankLine( "h10 g10 f10 e10 i10 j10 k10 l10" ) );
        factory.add( createRankLine( "h9 g9 f9 e9 i9 j9 k9 l9" ) );
        
        factory.add( createFileLine( "a1 a2 a3 a4 a5 a6 a7 a8", DIRECTED_WHITE_BLACK ) );
        factory.add( createFileLine( "b1 b2 b3 b4 b5 b6 b7 b8", DIRECTED_WHITE_BLACK ) );
        factory.add( createFileLine( "c1 c2 c3 c4 c5 c6 c7 c8", DIRECTED_WHITE_BLACK ) );
        factory.add( createFileLine( "d1 d2 d3 d4 d5 d6 d7 d8", DIRECTED_WHITE_BLACK ) );
        
        factory.add( createFileLine( "e1 e2 e3 e4 e9 e10 e11 e12", DIRECTED_WHITE_RED ) );
        factory.add( createFileLine( "f1 f2 f3 f4 f9 f10 f11 f12", DIRECTED_WHITE_RED ) );
        factory.add( createFileLine( "g1 g2 g3 g4 g9 g10 g11 g12", DIRECTED_WHITE_RED ) );
        factory.add( createFileLine( "h1 h2 h3 h4 h9 h10 h11 h12", DIRECTED_WHITE_RED ) );
        
        factory.add( createFileLine( "i8 i7 i6 i5 i9 i10 i11 i12", DIRECTED_BLACK_RED ) );
        factory.add( createFileLine( "j8 j7 j6 j5 j9 j10 j11 j12", DIRECTED_BLACK_RED ) );
        factory.add( createFileLine( "k8 k7 k6 k5 k9 k10 k11 k12", DIRECTED_BLACK_RED ) );
        factory.add( createFileLine( "l8 l7 l6 l5 l9 l10 l11 l12", DIRECTED_BLACK_RED ) );
        
        factory.add( createDiagonalLine( "a1 b2 c3 d4 i5 j6 k7 l8", DIRECTED_WHITE_BLACK ) );
        factory.add( createDiagonalLine( "b1 a2", DIRECTED_WHITE_BLACK ) );
        factory.add( createDiagonalLine( "c1 b2 a3", DIRECTED_WHITE_BLACK ) );
        factory.add( createDiagonalLine( "d1 c2 b3 a4", DIRECTED_WHITE_BLACK ) );
        factory.add( createDiagonalLine( "e1 d2 c3 b4 a5", DIRECTED_WHITE_BLACK ) );
        factory.add( createDiagonalLine( "f1 e2 d3 c4 b5 a6", DIRECTED_WHITE_BLACK ) );
        factory.add( createDiagonalLine( "g1 f2 e3 d4 c5 b6 a7", DIRECTED_WHITE_BLACK ) );
        factory.add( createDiagonalLine( "h1 g2 f3 e4 d5 c6 b7 a8", DIRECTED_WHITE_BLACK ) );
        factory.add( createDiagonalLine( "a2 b3 c4 d5 i6 j7 k8", DIRECTED_WHITE_BLACK ) );
        factory.add( createDiagonalLine( "a3 b4 c5 d6 i7 j8", DIRECTED_WHITE_BLACK ) );
        factory.add( createDiagonalLine( "a4 b5 c6 d7 i8", DIRECTED_WHITE_BLACK ) );
        factory.add( createDiagonalLine( "a5 b6 c7 d8", DIRECTED_WHITE_BLACK ) );
        factory.add( createDiagonalLine( "a6 b7 c8" , DIRECTED_WHITE_BLACK) );
        factory.add( createDiagonalLine( "a7 b8", DIRECTED_WHITE_BLACK ) );
        
        factory.add( createDiagonalLine( "h1 g2 f3 e4 i9 j10 k11 l12", DIRECTED_WHITE_RED ) );
        factory.add( createDiagonalLine( "h2 g3 f4 e9 i10 j11 k12", DIRECTED_WHITE_RED ) );
        factory.add( createDiagonalLine( "h3 g4 f9 e10 i11 j12", DIRECTED_WHITE_RED ) );
        factory.add( createDiagonalLine( "h4 g9 f10 e11 i12", DIRECTED_WHITE_RED ) );
        factory.add( createDiagonalLine( "h9 g10 f11 e12", DIRECTED_WHITE_RED ) );
        factory.add( createDiagonalLine( "h10 g11 f12", DIRECTED_WHITE_RED ) );
        factory.add( createDiagonalLine( "h11 g12", DIRECTED_WHITE_RED ) );
        factory.add( createDiagonalLine( "a1 b2 c3 d4 e9 f10 g11 h12", DIRECTED_WHITE_RED ) );
        factory.add( createDiagonalLine( "b1 c2 d3 e4 f9 g10 h11", DIRECTED_WHITE_RED ) );
        factory.add( createDiagonalLine( "c1 d2 e3 f4 g9 h10", DIRECTED_WHITE_RED ) );
        factory.add( createDiagonalLine( "d1 e2 f3 g4 h9", DIRECTED_WHITE_RED ) );
        factory.add( createDiagonalLine( "e1 f2 g3 h4", DIRECTED_WHITE_RED ) );
        factory.add( createDiagonalLine( "f1 g2 h3", DIRECTED_WHITE_RED ) );
        factory.add( createDiagonalLine( "g1 h2", DIRECTED_WHITE_RED ) );

        factory.add( createDiagonalLine( "l8 k7 j6 i5 e9 f10 g11 h12", DIRECTED_BLACK_RED ) );
        factory.add( createDiagonalLine( "l7 k6 j5 i9 e10 f11 g12", DIRECTED_BLACK_RED  ) );
        factory.add( createDiagonalLine( "l6 k5 j9 i10 e11 f12", DIRECTED_BLACK_RED  ) );
        factory.add( createDiagonalLine( "l5 k9 j10 i11 e12", DIRECTED_BLACK_RED  ) );
        factory.add( createDiagonalLine( "l9 k10 j11 i12", DIRECTED_BLACK_RED  ) );
        factory.add( createDiagonalLine( "l10 k11 j12", DIRECTED_BLACK_RED  ) );
        factory.add( createDiagonalLine( "l11 k12", DIRECTED_BLACK_RED  ) );
        factory.add( createDiagonalLine( "a8 b7 c6 d5 i9 j10 k11 l12", DIRECTED_BLACK_RED  ) );
        factory.add( createDiagonalLine( "b8 c7 d6 i5 j9 k10 l11", DIRECTED_BLACK_RED  ) );
        factory.add( createDiagonalLine( "c8 d7 i6 j5 k9 l10", DIRECTED_BLACK_RED  ) );
        factory.add( createDiagonalLine( "d8 i7 j6 k5 l9", DIRECTED_BLACK_RED  ) );
        factory.add( createDiagonalLine( "i8 j7 k6 l5", DIRECTED_BLACK_RED  ) );
        factory.add( createDiagonalLine( "j8 k7 l6", DIRECTED_BLACK_RED  ) );
        factory.add( createDiagonalLine( "k8 l7", DIRECTED_BLACK_RED  ) );
        
        factory.add( createKnightLine( "a1 b3" ) );
        factory.add( createKnightLine( "a1 c2" ) );
        factory.add( createKnightLine( "b1 a3" ) );        
        factory.add( createKnightLine( "b1 c3" ) );
        factory.add( createKnightLine( "b1 d2" ) );
        factory.add( createKnightLine( "c1 a2" ) );
        factory.add( createKnightLine( "c1 b3" ) );        
        factory.add( createKnightLine( "c1 d3" ) );
        factory.add( createKnightLine( "c1 e2" ) );
        factory.add( createKnightLine( "d1 b2" ) );
        factory.add( createKnightLine( "d1 c3" ) );        
        factory.add( createKnightLine( "d1 e3" ) );
        factory.add( createKnightLine( "d1 f2" ) );
        factory.add( createKnightLine( "e1 c2" ) );
        factory.add( createKnightLine( "e1 d3" ) );        
        factory.add( createKnightLine( "e1 f3" ) );
        factory.add( createKnightLine( "e1 g2" ) );
        factory.add( createKnightLine( "f1 d2" ) );
        factory.add( createKnightLine( "f1 e3" ) );        
        factory.add( createKnightLine( "f1 g3" ) );
        factory.add( createKnightLine( "f1 h2" ) );
        factory.add( createKnightLine( "g1 e2" ) );
        factory.add( createKnightLine( "g1 f3" ) );        
        factory.add( createKnightLine( "g1 h3" ) );
        factory.add( createKnightLine( "h1 f2" ) );        
        factory.add( createKnightLine( "h1 g3" ) );
        
        factory.add( createKnightLine( "a2 b4" ) );
        factory.add( createKnightLine( "a2 c3" ) );
        factory.add( createKnightLine( "b2 a4" ) );
        factory.add( createKnightLine( "b2 c4" ) );
        factory.add( createKnightLine( "b2 d3" ) );
        factory.add( createKnightLine( "c2 a3" ) );
        factory.add( createKnightLine( "c2 b4" ) );
        factory.add( createKnightLine( "c2 d4" ) );
        factory.add( createKnightLine( "c2 e3" ) );
        factory.add( createKnightLine( "d2 b3" ) );
        factory.add( createKnightLine( "d2 c4" ) );
        factory.add( createKnightLine( "d2 e4" ) );
        factory.add( createKnightLine( "d2 f3" ) );
        factory.add( createKnightLine( "e2 c3" ) );
        factory.add( createKnightLine( "e2 d4" ) );
        factory.add( createKnightLine( "e2 f4" ) );
        factory.add( createKnightLine( "e2 g3" ) );
        factory.add( createKnightLine( "f2 d3" ) );
        factory.add( createKnightLine( "f2 e4" ) );
        factory.add( createKnightLine( "f2 g4" ) );
        factory.add( createKnightLine( "f2 h3" ) );
        factory.add( createKnightLine( "g2 e3" ) );
        factory.add( createKnightLine( "g2 f4" ) );
        factory.add( createKnightLine( "g2 h4" ) );
        factory.add( createKnightLine( "h2 f3" ) );
        factory.add( createKnightLine( "h2 g4" ) );
        
        factory.add( createKnightLine( "a3 b5" ) );
        factory.add( createKnightLine( "a3 c4" ) );
        factory.add( createKnightLine( "b3 a5" ) );
        factory.add( createKnightLine( "b3 c5" ) );
        factory.add( createKnightLine( "b3 d4" ) );
        factory.add( createKnightLine( "c3 a4" ) );
        factory.add( createKnightLine( "c3 b5" ) );
        factory.add( createKnightLine( "c3 d5" ) );
        factory.add( createKnightLine( "c3 e4" ) );
        factory.add( createKnightLine( "d3 b4" ) );
        factory.add( createKnightLine( "d3 c5" ) );
        factory.add( createKnightLine( "d3 e9" ) );
        factory.add( createKnightLine( "d3 f4" ) );
        factory.add( createKnightLine( "e3 c4" ) );
        factory.add( createKnightLine( "e3 d5" ) );
        factory.add( createKnightLine( "e3 f9" ) );
        factory.add( createKnightLine( "e3 g4" ) );
        factory.add( createKnightLine( "f3 d4" ) );
        factory.add( createKnightLine( "f3 e9" ) );
        factory.add( createKnightLine( "f3 g9" ) );
        factory.add( createKnightLine( "f3 h4" ) );
        factory.add( createKnightLine( "g3 e4" ) );
        factory.add( createKnightLine( "g3 f9" ) );
        factory.add( createKnightLine( "g3 h9" ) );
        factory.add( createKnightLine( "h3 f4" ) );
        factory.add( createKnightLine( "h3 g9" ) );        
        
        factory.add( createKnightLine( "a4 b6" ) );
        factory.add( createKnightLine( "a4 c5" ) );
        factory.add( createKnightLine( "b4 a6" ) );
        factory.add( createKnightLine( "b4 c6" ) );
        factory.add( createKnightLine( "b4 d5" ) );
        factory.add( createKnightLine( "c4 a5" ) );
        factory.add( createKnightLine( "c4 b6" ) );
        factory.add( createKnightLine( "c4 d6" ) );
        factory.add( createKnightLine( "c4 e9" ) );
        factory.add( createKnightLine( "c4 i5" ) );
        factory.add( createKnightLine( "d4 b5" ) );
        factory.add( createKnightLine( "d4 c6" ) );
        factory.add( createKnightLine( "d4 i6" ) );
        factory.add( createKnightLine( "d4 f9" ) );
        factory.add( createKnightLine( "e4 c5" ) );
        factory.add( createKnightLine( "e4 f10" ) );
        factory.add( createKnightLine( "e4 i10" ) );
        factory.add( createKnightLine( "e4 g9" ) );
        factory.add( createKnightLine( "f4 d5" ) );
        factory.add( createKnightLine( "f4 i9" ) );
        factory.add( createKnightLine( "f4 e10" ) );
        factory.add( createKnightLine( "f4 g10" ) );
        factory.add( createKnightLine( "f4 h9" ) );
        factory.add( createKnightLine( "g4 e9" ) );
        factory.add( createKnightLine( "g4 f10" ) );
        factory.add( createKnightLine( "g4 h10" ) );
        factory.add( createKnightLine( "h4 f9" ) );
        factory.add( createKnightLine( "h4 g10" ) );
        
        factory.add( createKnightLine( "h12 g10" ) );
        factory.add( createKnightLine( "h12 f11" ) );
        factory.add( createKnightLine( "g12 h10" ) );
        factory.add( createKnightLine( "g12 f10" ) );
        factory.add( createKnightLine( "g12 e11" ) );
        factory.add( createKnightLine( "f12 h11" ) );
        factory.add( createKnightLine( "f12 g10" ) );
        factory.add( createKnightLine( "f12 e10" ) );
        factory.add( createKnightLine( "f12 i11" ) );
        factory.add( createKnightLine( "e12 g11" ) );
        factory.add( createKnightLine( "e12 f10" ) );
        factory.add( createKnightLine( "e12 i10" ) );
        factory.add( createKnightLine( "e12 j11" ) );
        factory.add( createKnightLine( "i12 f11" ) );
        factory.add( createKnightLine( "i12 e10" ) );
        factory.add( createKnightLine( "i12 j10" ) );
        factory.add( createKnightLine( "i12 k11" ) );
        factory.add( createKnightLine( "j12 e11" ) );
        factory.add( createKnightLine( "j12 i10" ) );
        factory.add( createKnightLine( "j12 k10" ) );
        factory.add( createKnightLine( "j12 l11" ) );
        factory.add( createKnightLine( "k12 i11" ) );
        factory.add( createKnightLine( "k12 j10" ) );
        factory.add( createKnightLine( "k12 l10" ) );
        factory.add( createKnightLine( "l12 j11" ) );
        factory.add( createKnightLine( "l12 k10" ) );
        
        factory.add( createKnightLine( "h11 g9" ) );
        factory.add( createKnightLine( "h11 f10" ) );
        factory.add( createKnightLine( "g11 h9" ) );
        factory.add( createKnightLine( "g11 f9" ) );
        factory.add( createKnightLine( "g11 e10" ) );
        factory.add( createKnightLine( "f11 h10" ) );
        factory.add( createKnightLine( "f11 g9" ) );
        factory.add( createKnightLine( "f11 e9" ) );
        factory.add( createKnightLine( "f11 i10" ) );
        factory.add( createKnightLine( "e11 g10" ) );
        factory.add( createKnightLine( "e11 f9" ) );
        factory.add( createKnightLine( "e11 i9" ) );
        factory.add( createKnightLine( "e11 j10" ) );
        factory.add( createKnightLine( "i11 f10" ) );
        factory.add( createKnightLine( "i11 e9" ) );
        factory.add( createKnightLine( "i11 j9" ) );
        factory.add( createKnightLine( "i11 k10" ) );
        factory.add( createKnightLine( "j11 e10" ) );
        factory.add( createKnightLine( "j11 i9" ) );
        factory.add( createKnightLine( "j11 k9" ) );
        factory.add( createKnightLine( "j11 l10" ) );
        factory.add( createKnightLine( "k11 i10" ) );
        factory.add( createKnightLine( "k11 j9" ) );
        factory.add( createKnightLine( "k11 l9" ) );
        factory.add( createKnightLine( "l11 j10" ) );
        factory.add( createKnightLine( "l11 k9" ) );
        
        factory.add( createKnightLine( "h10 g4" ) );
        factory.add( createKnightLine( "h10 f9" ) );
        factory.add( createKnightLine( "g10 h4" ) );
        factory.add( createKnightLine( "g10 f4" ) );
        factory.add( createKnightLine( "g10 e9" ) );
        factory.add( createKnightLine( "f10 h9" ) );
        factory.add( createKnightLine( "f10 g4" ) );
        factory.add( createKnightLine( "f10 e4" ) );
        factory.add( createKnightLine( "f10 i9" ) );
        factory.add( createKnightLine( "f10 i11" ) );
        factory.add( createKnightLine( "e10 g9" ) );
        factory.add( createKnightLine( "e10 f4" ) );
        factory.add( createKnightLine( "e10 d4" ) );
        factory.add( createKnightLine( "e10 i5" ) );
        factory.add( createKnightLine( "e10 j9" ) );
        factory.add( createKnightLine( "i10 f9" ) );
        factory.add( createKnightLine( "i10 e4" ) );
        factory.add( createKnightLine( "i10 j5" ) );
        factory.add( createKnightLine( "i10 k9" ) );
        factory.add( createKnightLine( "j10 e9" ) );
        factory.add( createKnightLine( "j10 i5" ) );
        factory.add( createKnightLine( "j10 k5" ) );
        factory.add( createKnightLine( "j10 l9" ) );
        factory.add( createKnightLine( "k10 i9" ) );
        factory.add( createKnightLine( "k10 j5" ) );
        factory.add( createKnightLine( "k10 l5" ) );
        factory.add( createKnightLine( "l10 j9" ) );
        factory.add( createKnightLine( "l10 k5" ) );
        
        factory.add( createKnightLine( "h9 g3" ) );
        factory.add( createKnightLine( "h9 f4" ) );
        factory.add( createKnightLine( "g9 h3" ) );
        factory.add( createKnightLine( "g9 f3" ) );
        factory.add( createKnightLine( "g9 e4" ) );
        factory.add( createKnightLine( "f9 h4" ) );
        factory.add( createKnightLine( "f9 g3" ) );
        factory.add( createKnightLine( "f9 e3" ) );
        factory.add( createKnightLine( "f9 d4" ) );
        factory.add( createKnightLine( "f9 i5" ) );
        factory.add( createKnightLine( "e9 g4" ) );
        factory.add( createKnightLine( "e9 f3" ) );
        factory.add( createKnightLine( "e9 d3" ) );
        factory.add( createKnightLine( "e9 j5" ) );
        factory.add( createKnightLine( "i9 f4" ) );
        factory.add( createKnightLine( "i9 d6" ) );
        factory.add( createKnightLine( "i9 j6" ) );
        factory.add( createKnightLine( "i9 k5" ) );
        factory.add( createKnightLine( "j9 d5" ) );
        factory.add( createKnightLine( "j9 e4" ) );
        factory.add( createKnightLine( "j9 i6" ) );
        factory.add( createKnightLine( "j9 k6" ) );
        factory.add( createKnightLine( "j9 l5" ) );
        factory.add( createKnightLine( "k9 i5" ) );
        factory.add( createKnightLine( "k9 j6" ) );
        factory.add( createKnightLine( "k9 l6" ) );
        factory.add( createKnightLine( "l9 j5" ) );
        factory.add( createKnightLine( "l9 k6" ) );
        
        factory.add( createKnightLine( "l8 k6" ) );
        factory.add( createKnightLine( "l8 j7" ) );
        factory.add( createKnightLine( "k8 l6" ) );
        factory.add( createKnightLine( "k8 j6" ) );
        factory.add( createKnightLine( "k8 i7" ) );
        factory.add( createKnightLine( "j8 l7" ) );
        factory.add( createKnightLine( "j8 k6" ) );
        factory.add( createKnightLine( "j8 i6" ) );
        factory.add( createKnightLine( "j8 d7" ) );
        factory.add( createKnightLine( "i8 k7" ) );
        factory.add( createKnightLine( "i8 j6" ) );
        factory.add( createKnightLine( "i8 d6" ) );
        factory.add( createKnightLine( "i8 c7" ) );
        factory.add( createKnightLine( "d8 j7" ) );
        factory.add( createKnightLine( "d8 i6" ) );
        factory.add( createKnightLine( "d8 c6" ) );
        factory.add( createKnightLine( "d8 b7" ) );
        factory.add( createKnightLine( "c8 i7" ) );
        factory.add( createKnightLine( "c8 d6" ) );
        factory.add( createKnightLine( "c8 b6" ) );
        factory.add( createKnightLine( "c8 a7" ) );
        factory.add( createKnightLine( "b8 d7" ) );
        factory.add( createKnightLine( "b8 c6" ) );
        factory.add( createKnightLine( "b8 a6" ) );
        factory.add( createKnightLine( "a8 c7" ) );
        factory.add( createKnightLine( "a8 b6" ) );
        
        factory.add( createKnightLine( "l7 k5" ) );
        factory.add( createKnightLine( "l7 j6" ) );
        factory.add( createKnightLine( "k7 l5" ) );
        factory.add( createKnightLine( "k7 j5" ) );
        factory.add( createKnightLine( "k7 i6" ) );
        factory.add( createKnightLine( "j7 l6" ) );
        factory.add( createKnightLine( "j7 k5" ) );
        factory.add( createKnightLine( "j7 i5" ) );
        factory.add( createKnightLine( "j7 d6" ) );
        factory.add( createKnightLine( "i7 k6" ) );
        factory.add( createKnightLine( "i7 j5" ) );
        factory.add( createKnightLine( "i7 d5" ) );
        factory.add( createKnightLine( "i7 c6" ) );
        factory.add( createKnightLine( "d7 j6" ) );
        factory.add( createKnightLine( "d7 i5" ) );
        factory.add( createKnightLine( "d7 c5" ) );
        factory.add( createKnightLine( "d7 b6" ) );
        factory.add( createKnightLine( "c7 i6" ) );
        factory.add( createKnightLine( "c7 d5" ) );
        factory.add( createKnightLine( "c7 b5" ) );
        factory.add( createKnightLine( "c7 a6" ) );
        factory.add( createKnightLine( "b7 d6" ) );
        factory.add( createKnightLine( "b7 c5" ) );
        factory.add( createKnightLine( "b7 a5" ) );
        factory.add( createKnightLine( "a7 c6" ) );
        factory.add( createKnightLine( "a7 b5" ) );
        
        factory.add( createKnightLine( "l6 k9" ) );
        factory.add( createKnightLine( "l6 j5" ) );
        factory.add( createKnightLine( "k6 l9" ) );
        factory.add( createKnightLine( "k6 j9" ) );
        factory.add( createKnightLine( "k6 i5" ) );
        factory.add( createKnightLine( "j6 l5" ) );
        factory.add( createKnightLine( "j6 k9" ) );
        factory.add( createKnightLine( "j6 i9" ) );
        factory.add( createKnightLine( "j6 d5" ) );
        factory.add( createKnightLine( "i6 k5" ) );
        factory.add( createKnightLine( "i6 j9" ) );
        factory.add( createKnightLine( "i6 e9" ) );
        factory.add( createKnightLine( "i6 d4" ) );
        factory.add( createKnightLine( "i6 c5" ) );
        factory.add( createKnightLine( "d6 j5" ) );
        factory.add( createKnightLine( "d6 i9" ) );
        factory.add( createKnightLine( "d6 e4" ) );
        factory.add( createKnightLine( "d6 c4" ) );
        factory.add( createKnightLine( "d6 b5" ) );
        factory.add( createKnightLine( "c6 i5" ) );
        factory.add( createKnightLine( "c6 d4" ) );
        factory.add( createKnightLine( "c6 b4" ) );
        factory.add( createKnightLine( "c6 a5" ) );
        factory.add( createKnightLine( "b6 d5" ) );
        factory.add( createKnightLine( "b6 c4" ) );
        factory.add( createKnightLine( "b6 a4" ) );
        factory.add( createKnightLine( "a6 c5" ) );
        factory.add( createKnightLine( "a6 b4" ) );
                
        factory.add( createKnightLine( "l5 k10" ) );
        factory.add( createKnightLine( "l5 j9" ) );
        factory.add( createKnightLine( "k5 l10" ) );
        factory.add( createKnightLine( "k5 j10" ) );
        factory.add( createKnightLine( "k5 i9" ) );
        factory.add( createKnightLine( "j5 l9" ) );
        factory.add( createKnightLine( "j5 k10" ) );
        factory.add( createKnightLine( "j5 i10" ) );
        factory.add( createKnightLine( "j5 e9" ) );
        factory.add( createKnightLine( "j5 d4" ) );
        factory.add( createKnightLine( "i5 k9" ) );
        factory.add( createKnightLine( "i5 j10" ) );
        factory.add( createKnightLine( "i5 e10" ) );
        factory.add( createKnightLine( "i5 c4" ) );
        factory.add( createKnightLine( "d5 j9" ) );
        factory.add( createKnightLine( "d5 e3" ) );
        factory.add( createKnightLine( "d5 c3" ) );
        factory.add( createKnightLine( "d5 b4" ) );
        factory.add( createKnightLine( "c5 i9" ) );
        factory.add( createKnightLine( "c5 e4" ) );
        factory.add( createKnightLine( "c5 d3" ) );
        factory.add( createKnightLine( "c5 b3" ) );
        factory.add( createKnightLine( "c5 a4" ) );
        factory.add( createKnightLine( "b5 d4" ) );
        factory.add( createKnightLine( "b5 c3" ) );
        factory.add( createKnightLine( "b5 a3" ) );
        factory.add( createKnightLine( "a5 c4" ) );
        factory.add( createKnightLine( "a5 b3" ) );
 
        return( factory );
    }
}

