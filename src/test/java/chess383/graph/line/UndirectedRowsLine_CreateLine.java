/*
 *  UndirectedRowsLine_CreateLine.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2020 Jörg Dippel
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

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <p>
 * The class UndirectedRowsLine_CreateLine implements an upper tester.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   February 2020
 */
@DisplayName("the public static method UndirectedRowsLine createLine() for class UndirectedRowsLine is tested")
public class UndirectedRowsLine_CreateLine { 
 
    @Test
    @DisplayName("createLine(): should return UndirectedRowsLine when locations are defined as a rank")
    public void createLine_shouldReturnUndirectedRowsLine_WhenLocationsAreDefinedAsARank( ) {
        
        String passedString = "b2 c2 d2 e2";

        assertThat( UndirectedRowsLine.createLine( passedString ) )
                  .as( "should return instance of UndirectedRowsLine" )
                  .isInstanceOf( UndirectedRowsLine.class );
    }
   
    @Test
    @DisplayName("createLine(): should return UndirectedRowsLine with normalized string when locations are defined")
    public void createLine_shouldReturnUndirectedRowsLineWithNormalizedString_WhenLocationsAreDefined( ) {
        
        String passedString = "b2 c2  d2 e2 ";
        String expectedString = "b2 c2 d2 e2";

        assertThat( UndirectedRowsLine.createLine( passedString ) )
                  .as( "should return normalized string" )
                  .isEqualTo( UndirectedRowsLine.createLine( expectedString ));
    }
    
    @Test
    @DisplayName("createLine(): should return UndirectedRowsLine with normalized reversed string when locations are defined")
    public void createLine_shouldReturnUndirectedRowsLineWithNormalizedReversedString_WhenLocationsAreDefined( ) {

        String passedString = " e2 d2  c2  b2  ";
        String expectedString = "b2 c2 d2 e2";

        assertThat( UndirectedRowsLine.createLine( passedString ) )
                  .as( "should return normalized string" )
                  .isEqualTo( UndirectedRowsLine.createLine( expectedString ));
    }
    
    @Test
    @DisplayName("createLine(): should return UndirectedRowsLine ignoring string when less than two names are offered")
    public void createLine_shouldReturnUndirectedRowsLineIgnoringString_WhenLessThanTwoNamesAreOffered( ) {

        String passedString = "e4 ";
        String expectedString = "";

        assertThat( UndirectedRowsLine.createLine( passedString ) )
                  .as( "should return instance of UndirectedRowsLine" )
                  .isEqualTo( UndirectedRowsLine.createLine( expectedString ));
    }
}

