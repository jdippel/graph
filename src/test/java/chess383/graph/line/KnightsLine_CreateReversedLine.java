/*
 *  KnightsLine_CreateReversedLine.java
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
 * The class KnightsLine_CreateReversedLine implements an upper tester.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   January 2022
 */
@DisplayName("the public static method KnightsLine createReversedLine() for class KnightsLine is tested")
public class KnightsLine_CreateReversedLine {
 
    @Test
    @DisplayName("createReversedLine(): should return KnightsLine when locations are defined as a line")
    public void createReversedLine_shouldReturnKnightsLine_WhenLocationsAreDefined( ) {
        
        String passedString = "c3 d1 e3 f1";

        assertThat( KnightsLine.createReversedLine( passedString ) )
                  .as( "should return instance of KnightsLine" )
                  .isInstanceOf( KnightsLine.class );
    }
  
    @Test
    @DisplayName("createReversedLine(): should return locations from KnightsLine with reversed string when locations are defined")
    public void createReversedLine_shouldReturnLocationsFromKnightsLineWithReversedString_WhenLocationsAreDefined( ) {
        
        String passedString = " c3  d1 e3 f1";

        assertThat( KnightsLine.createReversedLine( passedString ).getLocations() )
                  .as( "should return reversed line" )
                  .isEqualTo( "f1 e3 d1 c3" );
    }
    
    @Test
    @DisplayName("createReversedLine(): should return KnightsLine ignoring string when less than two names are offered")
    public void createReversedLine_shouldReturnKnightsLineIgnoringString_WhenLessThanTwoNamesAreOffered( ) {

        String passedString = "e4 ";

        assertThat( KnightsLine.createReversedLine( passedString ).getLocations() )
                  .as( "should return empty line" )
                  .isEqualTo( "" );
    }
}

