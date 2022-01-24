/*
 *  UndirectedRowsLine_GetLocations.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2020 Jörg Dippel
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

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * <p>
 * The class UndirectedRowsLine_GetLocations implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   January 2022
 *
 */

@DisplayName("the public method String getLocations( ) for class UndirectedRowsLine is tested")
public class UndirectedRowsLine_GetLocations {

//    private final Direction DIRECTED = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
    
    @ParameterizedTest
    @CsvSource({
        "b2 c2 d2 e2, b2 c2 d2 e2",
         "  b2 c2    d2 e2   , b2 c2 d2 e2"
    })
    @DisplayName("getLocations(): should return a similar line of locations, but trimmed and normalized")
    void containsLocation( String inputLine, String expected ) {

        UndirectedRowsLine discreteLine = UndirectedRowsLine.createLine( inputLine );
        
        assertThat( discreteLine.getLocations( ) )
                  .as( "line of locations must be similar" )
                  .isEqualTo( expected );
    }

    @Test
    @DisplayName("getLocations(): should return a similar line of locations, but trimmed and normalized") 
    void getLocations_shouldBeEqual_WhenInputOnlyDiffersInTrimming( ) {

        String inputLine = "  b2 c2    d2 e2   ";
        String expected = "b2 c2 d2 e2";
        
        UndirectedRowsLine discreteLine = UndirectedRowsLine.createLine( inputLine );
        
        assertThat( discreteLine.getLocations( ) )
                  .as( "createLine() must process and trim String elements" )
                  .isEqualTo( expected );
    }
    
    @Test
    @DisplayName("getLocations(): should return empty string when null is passed by calling UndirectedRowsLine.createLine()") 
    void getLocations_returnsEmptyString_WhenNullIsPassed( ) {

        String inputLine = null;
        String expected = "";
        
        UndirectedRowsLine discreteLine = UndirectedRowsLine.createLine( inputLine );
        
        assertThat( discreteLine.getLocations( ) )
                  .as( "createLine() must handle NullPointer" )
                  .isEqualTo( expected );
    }
    
    @Test
    @DisplayName("getLocations(): should return empty string when only white spaces are passed by calling UndirectedRowsLine.createLine()") 
    void getLocations_shouldBeEmptyString_WhenStringWithOnlyWhiteSpacesIsPassed( ) {

        String inputLine = "       ";
        String expected = "";
        
        UndirectedRowsLine discreteLine = UndirectedRowsLine.createLine( inputLine );
        
        assertThat( discreteLine.getLocations() )
                  .as( "createLine() must handle untrimmed strings" )
                  .isEqualTo( expected );
    }
}

