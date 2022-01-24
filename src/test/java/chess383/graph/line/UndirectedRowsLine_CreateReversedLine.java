/*
 *  UndirectedRowsLine_CreateReversedLine.java
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
 * The class UndirectedRowsLine_CreateReversedLine implements an upper tester.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   January 2022
 */
@DisplayName("the public static method UndirectedRowsLine createReversedLine() for class UndirectedRowsLine is tested")
public class UndirectedRowsLine_CreateReversedLine {
 
    @Test
    @DisplayName("createReversedLine(): should return UndirectedRowsLine when locations are defined as a rank")
    public void createReversedLine_shouldReturnUndirectedRowsLine_WhenLocationsAreDefinedAsARank( ) {
        
        String passedString = "b2 c2 d2 e2";

        assertThat( UndirectedRowsLine.createReversedLine( passedString ) )
                  .as( "should return instance of UndirectedRowsLine" )
                  .isInstanceOf( UndirectedRowsLine.class );
    }
   
    @Test
    @DisplayName("createReversedLine(): should return UndirectedRowsLine with normalized string when locations are defined")
    public void createReversedLine_shouldReturnLocationsFromUndirectedRowsLineWithNormalizedString_WhenLocationsAreDefined( ) {
        
        String passedString = "b2 c2  d2 e2 ";
        String expectedString = "e2 d2 c2 b2";

        assertThat( UndirectedRowsLine.createReversedLine( passedString ).getLocations() )
                  .as( "should return normalized string" )
                  .isEqualTo( expectedString );
    }
    
    @Test
    @DisplayName("createReversedLine(): should return empty line From UndirectedRowsLine ignoring string when less than two names are offered")
    public void createReversedLine_shouldReturnEmptyLineFromUndirectedRowsLineIgnoringString_WhenLessThanTwoNamesAreOffered( ) {

        String passedString = "e4 ";

        assertThat( UndirectedRowsLine.createReversedLine( passedString ).getLocations() )
                  .as( "should return instance of UndirectedRowsLine" )
                  .isEqualTo( "" );
    }
}

