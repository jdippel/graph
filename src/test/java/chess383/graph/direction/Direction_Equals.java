/*
 *  Direction_Equals.java
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

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ColorEnum;

/**
 * The class Direction_Equals implements an upper tester
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method boolean equals() form class Direction is tested")
public class Direction_Equals {

    final Direction BIDIRECTIONAL = Direction.createBidirectionalDirection( );
    final Direction UNIDIRECTIONAL = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
    
    @Test
    @DisplayName("equals(): return should be true when two identical bidirectional instances of Direction are compared")
    public void identicalBidirectionalInstances( ) {

        final Direction direction = BIDIRECTIONAL;
        final String message = "identical instances are compared";

        assertThat( direction.equals( direction ) ).as( message ).isTrue();
    }
    
    @Test
    @DisplayName("equals(): return should be true when two identical unidirectional instances of Direction are compared")
    public void identicalUnidirectionalInstances( ) {

        final Direction direction = UNIDIRECTIONAL;
        final String message = "identical instances are compared";

        assertThat( direction.equals( direction ) ).as( message ).isTrue();
    }

    @Test
    @DisplayName("equals(): return should be true when two unidirectional instances of Direction are compared")
    public void meaningfullyEquivalentUnidirectionalInstances( ) {

        final Direction direction = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        final String message = "meaningfully equivalent instances are compared";

        assertThat( UNIDIRECTIONAL.equals( direction ) ).as( message ).isTrue();
    }
    
    @Test
    @DisplayName("equals(): return should be true when two bidirectional instances of Direction are compared")
    public void meaningfullyEquivalentBidirectionalInstances( ) {

        final Direction direction = Direction.createBidirectionalDirection( );
        final String message = "meaningfully equivalent instances are compared";

        assertThat( BIDIRECTIONAL.equals( direction ) ).as( message ).isTrue();
    }

    @Test
    @DisplayName("equals(): return should be false when two different instances of Direction are compared")
    public void differentInstances( ) {

        final String message = "different instances are compared";

        assertThat( BIDIRECTIONAL.equals( UNIDIRECTIONAL ) ).as( message ).isFalse();
    }
}
