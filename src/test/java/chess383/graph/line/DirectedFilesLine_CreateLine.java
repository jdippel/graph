/*
 *  DirectedFilesLine_CreateLine.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2020 - 2022 Jörg Dippel
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

import chess383.ColorEnum;
import chess383.graph.direction.Direction;

/**
 * <p>
 * The class DirectedFilesLine_CreateLine implements an upper tester.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   January 2022
 */
@DisplayName("the public static method DirectedFilesLine_CreateLine createLine() for class DirectedFilesLine is tested")
public class DirectedFilesLine_CreateLine { 
 
    private final Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
    
    @Test
    @DisplayName("createLine(): should return direction for DirectedFilesLine when locations are defined as a file from black to white")
    public void createLine_shouldReturnDirectionForDirectedFilesLine_WhenLocationsAreDefinedAsAFileFromBlackToWhite( ) {
        
        Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.BLACK, ColorEnum.WHITE );
        String passedString = "b5 b4 b3 b2 b1";
        String expectedString = "b5 b4 b3 b2 b1";

        assertThat( DirectedFilesLine.createLine( passedString, DIRECTION ).getDirection() )
                  .as( "should return instance of DirectedFilesLine with related direction" )
                  .isEqualTo( DIRECTION );
    }
    
    @Test
    @DisplayName("createLine(): should return locations for DirectedFilesLine when locations are defined as a file from white to black")
    public void createLine_shouldReturnDLocationsForDirectedFilesLineWithNormalizedString_WhenLocationsAreDefinedFromWhiteToBlack( ) {
        
        Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        String passedString = "e3 e3  e4  e5 e6 e7";
        String expectedString = "e3 e3 e4 e5 e6 e7";

        assertThat( DirectedFilesLine.createLine( passedString, DIRECTION ).getLocations() )
                  .as( "should return instance of DirectedFilesLine with related locations" )
                  .isEqualTo( expectedString );
    }

    @Test
    @DisplayName("createLine(): should return locations for DirectedFilesLine when locations are defined as a file")
    public void createLine_shouldReturnLocationsForDirectedFilesLineWithNormalizedString_WhenLocationsAreDefined( ) {

        Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        String passedString = "e3 e3  e4  e5 e6 e7";
        String expectedString = "e3 e3 e4 e5 e6 e7";

        assertThat( DirectedFilesLine.createLine( passedString ).getLocations() )
                .as( "should return instance of DirectedFilesLine with related locations" )
                .isEqualTo( expectedString );
    }
    
    @Test
    @DisplayName("createLine(): should return no locations for DirectedFilesLine when there are not at least two locations ")
    public void createLine_shouldReturnEmptyLocationsForDirectedFilesLine_WhenLessThanTwoNamesAreOffered( ) {

        String passedString = "e4 \t";
        String expectedString = "";

        assertThat( DirectedFilesLine.createLine( passedString, DIRECTION ).getLocations() )
                  .as( "should return instance of DirectedFilesLine" )
                  .isEqualTo( "" );
    } 
}

