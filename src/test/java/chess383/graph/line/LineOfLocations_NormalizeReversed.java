/*
 *  LineOfLocations_NormalizeReversed.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2022 Jörg Dippel
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

package chess383.graph.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <p>
 * The class LineOfLocations_NormalizeReversed implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   Janary 2022
 *
 */
@DisplayName("the public method String normalizeStandard( ) for class LineOfLocations is tested")
public class LineOfLocations_NormalizeReversed {

    @Test
    @DisplayName("normalizeReversed(): return value should be an empty line for a passed NullPointer" )
    public void normalizeReversed_shouldReturnEmptyString_WhenPassedLocationsIsNull( ) {

        final String locations = null;
        String line = LineOfLocations.normalizeReversed( locations );

        assertThat( line )
                  .as( "reformatting and normalizing locations to a string" )
                  .isEqualTo( "" );
    }

    @Test
    @DisplayName("normalizeReversed(): return value should be an empty line for empty locations" )
    public void normalizeReversed_shouldReturnEmptyString_WhenLocationsAreEmpty( ) {

        final String locations = "";
        String line = LineOfLocations.normalizeReversed( locations );

        assertThat( line )
                .as("reformatting and normalizing locations to a string" )
                .isEqualTo( "" );
    }

    @Test
    @DisplayName("normalizeReversed(): return value should be an empty line if locations contains only a singe location" )
    public void normalizeReversed_shouldReturnEmptyString_WhenLocationsContainsOnlyASingleLocation( ) {

        final String locations = "   e5 ";
        String line = LineOfLocations.normalizeReversed( locations );

        assertThat( line )
                .as("reformatting and normalizing locations to a string" )
                .isEqualTo( "" );
    }

    @Test
    @DisplayName("normalizeReversed(): return value should be a normalized line when locations contains at least two locations" )
    public void normalizeReversed_shouldReturnANormalizedString_WhenLocationsContainsAtLeastTwoLocations( ) {

        final String locations = "   e5   f6  g7\n";
        String line = LineOfLocations.normalizeReversed( locations );

        assertThat( line )
                .as( "reformatting and normalizing locations to a string" )
                .isEqualTo( "g7 f6 e5" );
    }
}

