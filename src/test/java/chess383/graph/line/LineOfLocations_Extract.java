/*
 *  LineOfLocations_Extract.java
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

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <p>
 * The class LineOfLocations_Extract implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   January 2022
 *
 */
@DisplayName("the public method List<String> extract( ) for class LineOfLocations is tested")
public class LineOfLocations_Extract {

    @Test
    @DisplayName("extract(): returns valid line when location matches - location at the beginning")
    public void extract_shouldReturnValidLine_WhenLocationMatchesAtTheBeginning( ) {

        LineOfLocations line = UndirectedRowsLine.createLine( "c3 d4 e5 f6 g7" );
        String location = "c3";

        assertThat( line.extract( location ) )
                  .as( String.format( "location starts with %s", location ) )
                  .isEqualTo( Arrays.asList( "c3", "d4", "e5", "f6", "g7" ) );
    }

    @Test
    @DisplayName("extract(): returns valid line when location matches - location in the middle")
    public void extract_shouldReturnValidLine_WhenLocationMatchesInTheMiddle( ) {

        LineOfLocations line = UndirectedRowsLine.createLine( "c3 d4 e5 f6 g7" );
        String location = "e5";

        assertThat( line.extract( location ) )
                .as( String.format( "location starts with %s", location ) )
                .isEqualTo( Arrays.asList( "e5", "f6", "g7" ) );
    }

    @Test
    @DisplayName("extract(): returns valid line when location matches - location at the end")
    public void extract_shouldReturnValidLine_WhenLocationMatchesAtTheEnd( ) {

        LineOfLocations line = UndirectedRowsLine.createLine( "c3 d4 e5 f6 g7" );
        String location = "g7";

        assertThat( line.extract( location ) )
                .as( String.format( "location starts with %s", location ) )
                .isEqualTo( List.of( "g7" ) );
    }

    @Test
    @DisplayName("extract(): returns no line when location is not part of the line")
    public void extract_shouldReturnNoLine_WhenLocationIsNotPartOfLine( ) {

        LineOfLocations line = UndirectedRowsLine.createLine( "c3 d4 e5 f6 g7" );
        String location = "f7";

        assertThat( line.extract( location ) )
                .as( String.format( "location starts with %s", location ) )
                .isEqualTo( List.of() );
    }
}

