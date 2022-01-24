/*
 *  DirectedFilesLine_GetLocations.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2020 - 2022 Jörg Dippel
 *
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

import chess383.ColorEnum;
import chess383.graph.direction.Direction;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * <p>
 * The class DirectedFilesLine_GetLocations implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   January 2022
 *
 */

@DisplayName("the public method String getLocations( ) for class DirectedFilesLine is tested")
public class DirectedFilesLine_GetLocations {

    private final Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
    
    @ParameterizedTest
    @CsvSource({
        "b2 b3 b4 b5, b2 b3 b4 b5",
         "  b2  b3     b4 b5   , b2 b3 b4 b5"
    })
    @DisplayName("getLocations(): should return a similar line of locations, but trimmed and normalized")
    void containsLocation( String inputLine, String expected ) {

        DirectedFilesLine discreteLine = DirectedFilesLine.createLine( inputLine, DIRECTION );
        
        assertThat( discreteLine.getLocations( ) )
                  .as( "line of locations must be similar" )
                  .isEqualTo( expected );
    }
    
    @ParameterizedTest
    @CsvSource({
        "  b2  b3     b4 b5   , b2 b4 b3 b5"
    })
    @DisplayName("getLocations(): for a directed line the order of the locations is important")
    void lacksOrderofLocations( String inputLine, String expected ) {

        DirectedFilesLine discreteLine = DirectedFilesLine.createLine( inputLine, DIRECTION );
        
        assertThat( discreteLine.getLocations( ) )
                  .as( "line of locations should not be similar" )
                  .isNotEqualTo( expected );
    }
    
    @Test
    @DisplayName("getLocations(): should return empty string when null is passed by calling DirectedFilesLine.createLine()") 
    void getLocations_returnsEmptyString_WhenNullIsPassed( ) {

        String inputLine = null;
        String expected = "";
        
        DirectedFilesLine discreteLine = DirectedFilesLine.createLine( inputLine, DIRECTION );
        
        assertThat( discreteLine.getLocations( ) )
                  .as( "createLine() must handle NullPointer" )
                  .isEqualTo( expected );
    }
    
    @Test
    @DisplayName("getLocations(): should return empty string when only white spaces are passed by calling DirectedFilesLine.createLine()") 
    void getLocations_shouldBeEmptyString_WhenStringWithOnlyWhiteSpacesIsPassed( ) {

        String inputLine = "       ";
        String expected = "";
        
        DirectedFilesLine discreteLine = DirectedFilesLine.createLine( inputLine, DIRECTION );
        
        assertThat( discreteLine.getLocations() )
                  .as( "createLine() must handle untrimmed strings" )
                  .isEqualTo( expected );
    }
}

