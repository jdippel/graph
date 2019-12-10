/*
 *  Coordinate_HashCode.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2015 -2019 Jörg Dippel
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

package chess383.graph.coordinate;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.graph.coordinate.CoordinateImpl;

/**
 * The class Coordinate_HashCode implements an upper tester
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method int hashCode( ) for interface Coordinate is tested")
public class Coordinate_HashCode {

    @Test
    @DisplayName("hashCode(): return values should be equal when identical instances of coordinates are compared")
    public void hashCode_shouldBeEqual_WhenIdenticalInstancesOfCoordinatesAreCompared( ) {

    	final String LOCATION = "h8";
        final Coordinate COORDINATE = new CoordinateImpl( LOCATION );
        final int HASH_CODE = COORDINATE.hashCode( );

        assertThat( HASH_CODE )
                  .as( "identical instances are compared" )
                  .isEqualTo( COORDINATE.hashCode( ) );
    }

    @Test
    @DisplayName("hashCode(): return values should be equal when similar instances of coordinates are compared")
    public void hashCode_shouldBeEqual_WhenSimilarInstancesOfCoordinatesAreCompared( ) {

    	final String LOCATION = "h8";
        final Coordinate COORDINATE = new CoordinateImpl( LOCATION );
        final int HASH_CODE = COORDINATE.hashCode( );

        assertThat( HASH_CODE )
                  .as( "meaningfully equivalent instances are compared" )
                  .isEqualTo( new CoordinateImpl( LOCATION ).hashCode( ) );
    }

    @Test
    @DisplayName("hashCode(): return values should be different when different instances of coordinates are compared")
    public void hashCode_shouldNotBeEqual_WhenDifferentInstancesOfCoordinatesAreCompared( ) {

    	final String LOCATION = "h8";
        final Coordinate COORDINATE = new CoordinateImpl( LOCATION );
        final int HASH_CODE = COORDINATE.hashCode( );

        assertThat( HASH_CODE )
                  .as( "different instances are compared" )
                  .isNotEqualTo( new CoordinateImpl( "a1" ).hashCode( ) );
    }
}
