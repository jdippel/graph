/*
 *  LineOfLocations_Split.java
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
 * The class LineOfLocations_Split implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   January 2022
 *
 */
@DisplayName("the public method String[] split( ) for class LineOfLocations is tested")
public class LineOfLocations_Split {

    final String GIVEN_LINE = "b2 c2 d2 e2";

    @Test
    @DisplayName("split(): return each string for the given line")
    public void split_shouldReturnEachToken_WhenStringsAreSeparatedByASingleSpace( ) {

        LineOfLocations line = UndirectedRowsLine.createLine( GIVEN_LINE );

        assertThat( line.split() )
                  .as( String.format( "defined line %s with location %s should separated in tokens", GIVEN_LINE, GIVEN_LINE ) )
                  .isEqualTo( GIVEN_LINE.split( "\\s+", 0 ) );
    }

    @Test
    @DisplayName("split(): return each string for the given line also if there are several white spaces")
    public void split_shouldReturnEachToken_WhenStringsAreSeparatedBySpaces( ) {

        String location = "  b2 c2\td2  e2\n";
        LineOfLocations line = UndirectedRowsLine.createLine( GIVEN_LINE );

        assertThat( line.split() )
                .as( String.format( "defined line %s with location %s should separated in tokens", GIVEN_LINE, location ) )
                .isEqualTo( GIVEN_LINE.split( "\\s+", 0 ) );
    }
}

