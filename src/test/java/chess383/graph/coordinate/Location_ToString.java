/*
 *  Location_ToString.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2015 - 2020 Jörg Dippel
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

/**
 * The class Location_ToString implements an upper tester
 *
 * @author    Jörg Dippel
 * @version   July 2020
 *
 */
@DisplayName("the public method String toString( ) for class Location is tested")
public class Location_ToString {

    @Test
    @DisplayName("toString(): should be equal when name for location and coordinate are matching")
    public void checkForStringCreation( ) {

        final String COORDINATE_NAME = "e5";

        Location location = Location.getInstance( COORDINATE_NAME );

        assertThat( location.toString( ) )
                  .as("name for coordinate and location should match")
                  .isEqualTo( COORDINATE_NAME );
    }
}
