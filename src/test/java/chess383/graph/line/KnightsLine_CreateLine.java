/*
 *  KnightsLine_CreateLine.java
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
 * The class KnightsLine_CreateLine implements an upper tester.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   February 2020
 */
@DisplayName("the public static method KnightsLine createLine() for class KnightsLine is tested")
public class KnightsLine_CreateLine { 
 
    @Test
    @DisplayName("createLine(): should return KnightsLine when locations are defined")
    public void createLine_shouldReturnKnightsLine_WhenLocationsAreDefined( ) {
        
        String passedString = "c3 d1 e3 f1";

        assertThat( KnightsLine.createLine( passedString ) )
                  .as( "should return instance of KnightsLine" )
                  .isInstanceOf( KnightsLine.class );
    }
  
    @Test
    @DisplayName("createLine(): should return locations from KnightsLine with normalized string when locations are defined")
    public void createLine_shouldReturnKLocationsFromKnightsLineWithNormalizedString_WhenLocationsAreDefined( ) {
        
        String passedString = " c3  d1 e3 f1";

        assertThat( KnightsLine.createLine( passedString ).getLocations() )
                  .as( "should return instance of KnightsLine" )
                  .isEqualTo( "c3 d1 e3 f1" );
    }
    
    @Test
    @DisplayName("createLine(): should return KnightsLine ignoring string when less than two names are offered")
    public void createLine_shouldReturnKnightsLineIgnoringString_WhenLessThanTwoNamesAreOffered( ) {

        String passedString = "e4 ";
        String expectedString = "";

        assertThat( KnightsLine.createLine( passedString ).getLocations() )
                  .as( "should return instance of KnightsLine" )
                  .isEqualTo( "" );
    }
}

