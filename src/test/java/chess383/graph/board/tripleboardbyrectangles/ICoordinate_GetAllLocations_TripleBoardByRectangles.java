/*
 *  ICoordinate_GetAllLocations_TripleBoardByRectangles.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2016 - 2019 Jörg Dippel
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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ICoordinate;
import chess383.ICoordinateFactory;


/**
 * <p>
 * The class ICoordinate_GetAllLocations_TripleBoardByRectangles implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method Set<String> getAllLocations() for class ICoordinate_GetAllLocations_TripleBoardByRectangles is tested")
public class ICoordinate_GetAllLocations_TripleBoardByRectangles { 

    /**
     * the public method Set<String> getAllLocations( ) is tested.
     */
    
    private void compareSetOfLocations( String expected, Set<String> squares ) {
        
        String[] tokens = expected.split( "\\s+" );
        assertEquals( tokens.length, squares.size( ), "Sets must be of same size:" );
        for( String square : tokens ) {
            assertEquals( true, squares.contains( square ) );
        }
    }
    

    @Test
    @DisplayName("getAllLocations(): return all locations")
    public void compareTheDefinedSetOfLocations( ) {
        
        ICoordinate board = ICoordinateFactory.TRIPLE.get( );
        
        Set<String> squares = board.getAllLocations( );
        String boardSquares = 
                "a1 b1 c1 d1 e1 f1 g1 h1 " +
                "b1 b2 b3 b4 b5 b6 b7 b8 " + 
                "c1 c2 c3 c4 c5 c6 c7 c8 " +
                "d1 d2 d3 d4 d5 d6 d7 d8 " +
                "e1 e2 e3 e4 e9 e10 e11 e12 " +
                "f1 f2 f3 f4 f9 f10 f11 f12 " +
                "g1 g2 g3 g4 g9 g10 g11 g12 " +
                "h1 h2 h3 h4 h9 h10 h11 h12 " +
                "i5 i6 i7 i8 i9 i10 i11 i12 " +
                "j5 j6 j7 j8 j9 j10 j11 j12 " +
                "k5 k6 k7 k8 k9 k10 k11 k12 " +
                "l5 l6 l7 l8 l9 l10 l11 l12";
        
        compareSetOfLocations( boardSquares, squares );
    }
}

