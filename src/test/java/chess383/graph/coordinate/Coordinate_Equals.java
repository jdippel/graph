/*
 *  Coordinate_Equals.java
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
 * The class Coordinate_Equals implements an upper tester
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method boolean equals( ) for interface Coordinate is tested")
public class Coordinate_Equals {

    @Test
    @DisplayName("equals(): return should be true when identical instances of Coordinate are compared")
    public void equals_shouldBeTrue_WhenIdenticalInstancesOfCoordinatesAreCompared( ) {

    	final String LOCATION = "h8";
        final Coordinate COORDINATE = new CoordinateImpl( LOCATION );

        assertThat( COORDINATE.equals( COORDINATE ) )
                  .as( "identical instances should be equal" )
                  .isTrue();
    }

    @Test
    @DisplayName("equals(): return should be true when similar instances of Coordinate are compared")
    public void equals_shouldBeTrue_WhenSimilarInstancesOfCoordinatesAreCompared( ) {

    	final String LOCATION = "h8";
        final Coordinate COORDINATE = new CoordinateImpl( LOCATION );
        
        assertThat( new CoordinateImpl( LOCATION ).equals( COORDINATE ) )
                  .as( "meaningfully equivalent instances should be equal" )
                  .isTrue();
    }

    @Test
    @DisplayName("equals(): return should be false when different instances of Coordinate are compared")
    public void differentInstances( ) {

    	final String LOCATION = "h8";
        final Coordinate COORDINATE = new CoordinateImpl( LOCATION );

        assertThat( new CoordinateImpl( "a1" ).equals( COORDINATE ) )
                  .as( "different instances must not be equal" )
                  .isFalse();
    }
}
