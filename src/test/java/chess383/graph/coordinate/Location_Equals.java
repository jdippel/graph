/*
 *  Location_Equals.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2015 -2020 Jörg Dippel
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
 * The class Location_Equals implements an upper tester
 *
 * @author    Jörg Dippel
 * @version   July 2020
 *
 */
@DisplayName("the public method boolean equals( ) for class Location is tested")
public class Location_Equals {

    static private String COORDINATE_NAME = "e5";
    static private Location LOCATION = Location.getInstance( COORDINATE_NAME );
    
    @Test
    @DisplayName("equals(): should be true for identical instances of locations")
    public void identicalInstances( ) {

        assertThat( LOCATION.equals( LOCATION ) )
                  .as( "representation for identical instances should match for coordinate " + COORDINATE_NAME )
                  .isTrue();
    }

    @Test
    @DisplayName("equals(): should be true for similar instances of locations")
    public void meaningfullyEquivalentInstances( ) {

        assertThat( Location.getInstance( COORDINATE_NAME ).equals( LOCATION ) )
                  .as( "representation for meaningfully equivalent instances should match for coordinate " + COORDINATE_NAME )
                  .isTrue();
    }

    @Test
    @DisplayName("equals(): should be false for different instances of locations")
    public void differentInstances( ) {

        assertThat( Location.getInstance( "a1" ).equals( LOCATION ) )
                  .as( "representation for different instances should not match" )
                  .isFalse();
    }
}
