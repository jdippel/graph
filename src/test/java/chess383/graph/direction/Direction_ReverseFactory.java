/*
 *  Direction_Reverse.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2018, 2019 Jörg Dippel
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

package chess383.graph.direction;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ColorEnum;
import chess383.graph.direction.Direction;

/**
 * <p>
 * The class Direction_ReverseFactory implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public static factory method String createReversedDirection( ) for class Direction is tested")
public class Direction_ReverseFactory {

    final Direction BIDIRECTIONAL = Direction.createBidirectionalDirection( );
    final Direction UNIDIRECTIONAL = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
    final String ERROR_MESSAGE = "description of instances differ by method call toString()";
    
    @Test
    @DisplayName("createReversedDirection(): comparison should be equal when unidirectional instances of Direction are reversed and compared to the origin")
    public void identicalInstancesForUnidirectional( ) {

        final Direction direction = UNIDIRECTIONAL;

        assertEquals( Direction.createReversedDirection( Direction.createReversedDirection( direction ) ).toString( ), direction.toString( ), ERROR_MESSAGE );
    }
    
    @Test
    @DisplayName("createReversedDirection(): comparison should be equal when bidirectional instances of Direction are reversed and compared to the origin")
    public void identicalInstancesForBidirectional( ) {

        final Direction direction = BIDIRECTIONAL;

        assertEquals( Direction.createReversedDirection( Direction.createReversedDirection( direction ) ).toString( ), direction.toString( ), ERROR_MESSAGE );
    }
}
