/*
 *  ICoordinate_Consistency_TripleBoardByRectangles.java
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

package chess383.graph.board.tripleboardbyrectangles;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import chess383.ICoordinateFactory;
import chess383.graph.board.ICoordinate_Consistency_Wrapper;


/**
 * <p>
 * The class ICoordinate_Consistency_TripleBoardByRectangles implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   February 2021
 *
 */
@DisplayName("the public method Set<List<String>> getLineBundles() for class ICoordinate_Consistency_TripleBoardByRectangles is tested")
public class ICoordinate_Consistency_TripleBoardByRectangles { 

    private ICoordinate_Consistency_Wrapper wrapper = new ICoordinate_Consistency_Wrapper( ICoordinateFactory.TRIPLE );
    
    @ParameterizedTest( name = "given a triple board from location {0} someone can move to: {1}, {2} or {3}")
    @DisplayName("given a location then following locations can be reached in an area of distance two")
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
                 "c3, a3 b3 c1 c2 c4 c5 d3 e3, a1 a5 b2 b4 d2 d4 e1 e9 i5, a2 a4 b1 b5 d1 d5 e2 e4", 
                 "c4, a4 b4 c2 c3 c5 c6 d4 e4, a2 a6 b3 b5 d3 d5 e2 i6, a3 a5 b2 b6 d2 d6 e3 e9 i5", 
                 "c5, a5 b5 c3 c4 c6 c7 d5 i5, a3 a7 b4 b6 d4 d6 e3 i7, a4 a6 b3 b7 d3 d7 e4 i6 i9", 
                 "c6, a6 b6 c4 c5 c7 c8 d6 i6, a4 a8 b5 b7 d5 d7 e4 i8 i9, a5 a7 b4 b8 d4 d8 i5 i7", 
                 "c7, a7 b7 c5 c6 c8 d7 i7, a5 b6 b8 d6 d8 i5, a6 a8 b5 d5 i6 i8", 
                 "c8, a8 b8 c6 c7 d8 i8, a6 b7 d7 i6, a7 b6 d6 i7", 
                 "d1, b1 c1 d2 d3 e1 f1, b3 c2 e2 f3, b2 c3 e3 f2", 
                 "d2, b2 c2 d1 d3 d4 e2 f2, b4 c1 c3 e1 e3 f4, b1 b3 c4 e4 f1 f3", 
                 "d3, b3 c3 d1 d2 d4 d5 e3 f3, b1 b5 c2 c4 e2 e4 f1 f9, b2 b4 c1 c5 e1 e9 f2 f4 i5", 
                 "d4, b4 c4 d2 d3 d5 d6 e4 f4, b2 b6 c3 c5 e3 e9 f10 f2 i5 j6, b3 b5 c2 c6 e10 e2 f3 f9 i6 i9 j5", 
                 "d5, b5 c5 d3 d4 d6 d7 i5 j5, b3 b7 c4 c6 e4 f3 i6 i9 j10 j7, b4 b6 c3 c7 e3 e9 f4 i10 i7 j6 j9", 
                 "d6, b6 c6 d4 d5 d7 d8 i6 j6, b4 b8 c5 c7 i5 i7 j8 j9, b5 b7 c4 c8 e4 i8 i9 j5 j7", 
                 "d7, b7 c7 d5 d6 d8 i7 j7, b5 c6 c8 i6 i8 j5, b6 b8 c5 i5 j6 j8", 
                 "d8, b8 c8 d6 d7 i8 j8, b6 c7 i7 j6, b7 c6 i6 j7", 
                 "e1, c1 d1 e2 e3 f1 g1, c3 d2 f2 g3, c2 d3 f3 g2", 
                 "e10, e11 e12 e4 e9 f10 g10 i10 j10, f11 f9 g12 g4 i11 i9 j12 j5, d4 f12 f4 g11 g9 i12 i5 j11 j9", 
                 "e11, e10 e12 e9 f11 g11 i11 j11, f10 f12 g9 i10 i12 j9, f9 g10 g12 i9 j10 j12", 
                 "e12, e10 e11 f12 g12 i12 j12, f11 g10 i11 j10, f10 g11 i10 j11", 
                 "e2, c2 d2 e1 e3 e4 f2 g2, c4 d1 d3 f1 f3 g4, c1 c3 d4 f4 g1 g3", 
                 "e3, c3 d3 e1 e2 e4 e9 f3 g3, c1 c5 d2 d4 f2 f4 g1 g9, c2 c4 d1 d5 f1 f9 g2 g4 i9", 
                 "e4, c4 d4 e10 e2 e3 e9 f4 g4, c2 c6 d3 d5 f3 f9 g10 g2 i9 j10, c3 c5 d2 d6 f10 f2 g3 g9 i10 i5 j9", 
                 "e9, e10 e11 e3 e4 f9 g9 i9 j9, c3 d4 f10 f4 g11 g3 i10 i5 j11 j6, c4 d3 d5 f11 f3 g10 g4 i11 i6 j10 j5", 
                 "f1, d1 e1 f2 f3 g1 h1, d3 e2 g2 h3, d2 e3 g3 h2", 
                 "f10, e10 f11 f12 f4 f9 g10 h10 i10, d4 e11 e9 g11 g9 h12 h4 i12 i5, e12 e4 g12 g4 h11 h9 i11 i9", 
                 "f11, e11 f10 f12 f9 g11 h11 i11, e10 e12 g10 g12 h9 i9, e9 g9 h10 h12 i10 i12", 
                 "f12, e12 f10 f11 g12 h12 i12, e11 g11 h10 i10, e10 g10 h11 i11", 
                 "f2, d2 e2 f1 f3 f4 g2 h2, d4 e1 e3 g1 g3 h4, d1 d3 e4 g4 h1 h3", 
                 "f3, d3 e3 f1 f2 f4 f9 g3 h3, d1 d5 e2 e4 g2 g4 h1 h9 i9, d2 d4 e1 e9 g1 g9 h2 h4", 
                 "f4, d4 e4 f10 f2 f3 f9 g4 h4, d2 e3 e9 g3 g9 h10 h2 i10, d3 d5 e10 e2 g10 g2 h3 h9 i9", 
                 "f9, e9 f10 f11 f3 f4 g9 h9 i9, d3 e10 e4 g10 g4 h11 h3 i11, d4 e11 e3 g11 g3 h10 h4 i10 i5", 
                 "g1, e1 f1 g2 g3 h1, e3 f2 h2, e2 f3 h3", 
                 "g10, e10 f10 g11 g12 g4 g9 h10, e12 e4 f11 f9 h11 h9, e11 e9 f12 f4 h12 h4", 
                 "g11, e11 f11 g10 g12 g9 h11, e9 f10 f12 h10 h12, e10 e12 f9 h9", 
                 "g12, e12 f12 g10 g11 h12, e10 f11 h11, e11 f10 h10", 
                 "g2, e2 f2 g1 g3 g4 h2, e4 f1 f3 h1 h3, e1 e3 f4 h4", 
                 "g3, e3 f3 g1 g2 g4 g9 h3, e1 e9 f2 f4 h2 h4, e2 e4 f1 f9 h1 h9", 
                 "g4, e4 f4 g10 g2 g3 g9 h4, e10 e2 f3 f9 h3 h9, e3 e9 f10 f2 h10 h2", 
                 "g9, e9 f9 g10 g11 g3 g4 h9, e11 e3 f10 f4 h10 h4, e10 e4 f11 f3 h11 h3", 
                 "h1, f1 g1 h2 h3, f3 g2, f2 g3", 
                 "h10, f10 g10 h11 h12 h4 h9, f12 f4 g11 g9, f11 f9 g12 g4", 
                 "h11, f11 g11 h10 h12 h9, f9 g10 g12, f10 f12 g9", 
                 "h12, f12 g12 h10 h11, f10 g11, f11 g10", 
                 "h2, f2 g2 h1 h3 h4, f4 g1 g3, f1 f3 g4", 
                 "h3, f3 g3 h1 h2 h4 h9, f1 f9 g2 g4, f2 f4 g1 g9", 
                 "h4, f4 g4 h10 h2 h3 h9, f10 f2 g3 g9, f3 f9 g10 g2", 
                 "h9, f9 g9 h10 h11 h3 h4, f11 f3 g10 g4, f10 f4 g11 g3", 
                 "i10, e10 f10 i11 i12 i5 i9 j10 k10, e11 e9 f12 f4 j11 j9 k12 k5, d4 d5 e12 e4 f11 f9 j12 j5 k11 k9", 
                 "i11, e11 f11 i10 i12 i9 j11 k11, e10 e12 f9 j10 j12 k9, e9 f10 f12 j9 k10 k12", 
                 "i12, e12 f12 i10 i11 j12 k12, e11 f10 j11 k10, e10 f11 j10 k11", 
                 "i5, c5 d5 i10 i6 i7 i9 j5 k5, c3 c7 d4 d6 e9 f10 j6 j9 k10 k7, c4 c6 d3 d7 e10 f9 j10 j7 k6 k9", 
                 "i6, c6 d6 i5 i7 i8 i9 j6 k6, c4 c8 d5 d7 j5 j7 k8 k9 , c5 c7 d4 d8 e4 e9 j8 j9 k5 k7", 
                 "i7, c7 d7 i5 i6 i8 j7 k7, c5 d6 d8 j6 j8 k5, c6 c8 d5 j5 k6 k8", 
                 "i8, c8 d8 i6 i7 j8 k8, c6 d7 j7 k6, c7 d6 j6 k7", 
                 "i9, e9 f9 i10 i11 i5 i6 j9 k9, c6 d5 e10 e4 f11 f3 j10 j5 k11 k6 , c4 c5 d3 d4 d6 e11 e3 f10 f4 j11 j6 k10 k5", 
                 "j10, e10 i10 j11 j12 j5 j9 k10 l10, d5 e12 e4 i11 i9 k11 k9 l12 l5, e11 e9 i12 i5 k12 k5 l11 l9", 
                 "j11, e11 i11 j10 j12 j9 k11 l11, e9 i10 i12 k10 k12 l9, e10 e12 i9 k9 l10 l12", 
                 "j12, e12 i12 j10 j11 k12 l12, e10 i11 k11 l10, e11 i10 k10 l11", 
                 "j5, d5 i5 j10 j6 j7 j9 k5 l5, d7 e10 i6 i9 k6 k9 l10 l7, d4 d6 e4 e9 i10 i7 k10 k7 l6 l9", 
                 "j6, d6 i6 j5 j7 j8 j9 k6 l6, d4 d8 e9 i5 i7 k5 k7 l8 l9, d5 d7 i8 i9 k8 k9 l5 l7", 
                 "j7, d7 i7 j5 j6 j8 k7 l7, d5 i6 i8 k6 k8 l5, d6 d8 i5 k5 l6 l8", 
                 "j8, d8 i8 j6 j7 k8 l8, d6 i7 k7 l6, d7 i6 k6 l7", 
                 "j9, e9 i9 j10 j11 j5 j6 k9 l9, d6 e11 i10 i5 k10 k5 l11 l6, d4 d5 e10 e4 i11 i6 k11 k6 l10 l5", 
                 "k10, i10 j10 k11 k12 k5 k9 l10, i12 i5 j11 j9 l11 l9, i11 i9 j12 j5 l12 l5", 
                 "k11, i11 j11 k10 k12 k9 l11, i9 j10 j12 l10 l12, i10 i12 j9 l9", 
                 "k12, i12 j12 k10 k11 l12, i10 j11 l11, i11 j10 l10", 
                 "k5, i5 j5 k10 k6 k7 k9 l5, i10 i7 j6 j9 l6 l9, i6 i9 j10 j7 l10 l7", 
                 "k6, i6 j6 k5 k7 k8 k9 l6, i8 i9 j5 j7 l5 l7, i5 i7 j8 j9 l8 l9", 
                 "k7, i7 j7 k5 k6 k8 l7, i5 j6 j8 l6 l8, i6 i8 j5 l5", 
                 "k8, i8 j8 k6 k7 l8, i6 j7 l7, i7 j6 l6", 
                 "k9, i9 j9 k10 k11 k5 k6 l9, i11 i6 j10 j5 l10 l5, i10 i5 j11 j6 l11 l6", 
                 "l10, j10 k10 l11 l12 l5 l9, j12 j5 k11 k9, j11 j9 k12 k5", 
                 "l11, j11 k11 l10 l12 l9, j9 k10 k12, j10 j12 k9", 
                 "l12, j12 k12 l10 l11, j10 k11, j11 k10", 
                 "l5, j5 k5 l10 l6 l7 l9, j10 j7 k6 k9, j6 j9 k10 k7", 
                 "l6, j6 k6 l5 l7 l8 l9, j8 j9 k5 k7, j5 j7 k8 k9", 
                 "l7, j7 k7 l5 l6 l8, j5 k6 k8, j6 j8 k5", 
                 "l8, j8 k8 l6 l7, j6 k7, j7 k6",                  
                 "l9, j9 k9 l10 l11 l5 l6, j11 j6 k10 k5, j10 j5 k11 k6" })
    void test( String location, String expectedRooks, String expectedBishops, String expectedKnights ) {
        wrapper.givenALocation_verifyTheLocationsForVariousTransformations( location, expectedRooks, expectedBishops, expectedKnights );
    }
}

