/*
 *  Direction_HashCode.java
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
 * The class Direction_HashCode implements an upper tester
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method int hashCode( ) from class Direction is tested")
public class Direction_HashCode {

    final Direction BIDIRECTIONAL = Direction.createBidirectionalDirection( );
    final Direction UNIDIRECTIONAL = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
    
    @Test
    @DisplayName("hashCode(): comparing two identical unidirectional instances of Direction should return equal hash codes")
    public void identicalInstances( ) {

        final Direction direction = UNIDIRECTIONAL;
        final int hashCode = direction.hashCode( );
        final String message = "identical instances are compared";

        assertThat( hashCode ).as( message ).isEqualTo( UNIDIRECTIONAL.hashCode( ) );
    }

    @Test
    @DisplayName("hashCode(): comparing two identical Bidirectional instances of Direction should return equal hash codes")
    public void meaningfullyEquivalentInstances( ) {

        final Direction direction = BIDIRECTIONAL;
        final int hashCode = direction.hashCode( );
        final String message = "meaningfully equivalent instances are compared";

        assertThat( hashCode ).as( message ).isEqualTo( Direction.createBidirectionalDirection( ).hashCode( ) );
    }

    @Test
    @DisplayName("hashCode(): comparing two different instances of Direction should return different hash codes")
    public void differentInstances( ) {

        final Direction direction = UNIDIRECTIONAL;
        final int hashCode = direction.hashCode( );
        final String message = "different instances are compared";

        assertThat( hashCode ).as( message ).isNotEqualTo( Direction.createBidirectionalDirection( ).hashCode( ) );
    }
}
