/*
 *  ICoordinate_GetAllLocations_ThreeDimensionalBoard.java
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

package chess383.graph.board.threedimensional;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ICoordinate;
import chess383.ICoordinateFactory;


/**
 * <p>
 * The class ICoordinate_GetAllLocations_ThreeDimensionalBoard implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method Set<String> getAllLocations() for class ICoordinate_GetAllLocations_ThreeDimensionalBoard is tested")
public class ICoordinate_GetAllLocations_ThreeDimensionalBoard { 

    /**
     * the public method Set<String> getAllLocations( ) is tested.
     */
    
    private void compareSetOfLocations( String expected, Set<String> squares ) {
        
        String[] tokens = expected.split( "\\s+" );
        assertThat( squares.size( ) ).as ( "Sets must be of same size:" ).isEqualTo( tokens.length );
        for( String square : tokens ) {
            assertThat( squares.contains( square ) ).as( "each element must be included").isTrue();
        }
    }
    

    @Test
    @DisplayName("getAllLocation(): return all locations")
    public void compareTheDefinedSetOfLocations( ) {
        
        ICoordinate board = ICoordinateFactory.THREE_DIMENSIONAL.get( );
        
        Set<String> squares = board.getAllLocations( );
        String boardSquares = 
                "z0 z1 z2 z3 z4 z5 z6 z7 z8 z9 " +
                "a0 a1 a2 a3 a4 a5 a6 a7 a8 a9 " +
                   "b1 b2 b3 b4 b5 b6 b7 b8 " +
                   "c1 c2 c3 c4 c5 c6 c7 c8 " +
                "d0 d1 d2 d3 d4 d5 d6 d7 d8 d9 " +
                "e0 e1 e2 e3 e4 e5 e6 e7 e8 e9";
        
        compareSetOfLocations( boardSquares, squares );
    }
}

