/*
 *  Direction_IsDirected.java
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


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ColorEnum;
import chess383.graph.direction.Direction;

/**
 * <p>
 * The class Direction_IsDirected implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method boolean isDirected( ) from class Direction is tested")
public class Direction_IsDirected {

    final Direction BIDIRECTIONAL = Direction.createBidirectionalDirection( );
    final Direction UNIDIRECTIONAL = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
    final String ERROR_MESSAGE = "method results differ by method call isDirected()";
    
    @Test
    @DisplayName("isDirected(): return should be true for unidirectional instances of Direction")
    public void directionForUnidirectional( ) {

        final Direction direction = UNIDIRECTIONAL;

        assertTrue( direction.isDirected( ), ERROR_MESSAGE );
    }
    
    @Test
    @DisplayName("isDirected(): return should be false for bidirectional instances of Direction")

    public void identicalInstancesForBidirectional( ) {

        final Direction direction = BIDIRECTIONAL;

        assertFalse( direction.isDirected( ), ERROR_MESSAGE );
    }
}
