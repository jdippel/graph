/*
 *  Location_GetCoordinate.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2015 - 2019 Jörg Dippel
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

import chess383.graph.coordinate.Location;

/**
 * The class Location_GetCoordinate implements an upper tester
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method Coordinate getCoordinate( ) for class Location is tested")
public class Location_GetCoordinate {

    @Test
    @DisplayName("getCoordinate(): should be equal for location and coordinate names")
    public void checkForCorrectNaming( ) {

        final String COORDINATE_NAME = "e5";

        Location location = Location.getInstance( COORDINATE_NAME );
        
        assertThat( location.getCoordinate( ).toString( ) )
                  .as( "name for location and coordinate should match for location " + COORDINATE_NAME )
                  .isEqualTo( COORDINATE_NAME );
    }
}
