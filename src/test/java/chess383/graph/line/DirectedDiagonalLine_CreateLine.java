/*
 *  DirectedDiagonalLine_CreateLine.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2020 -2022 Jörg Dippel
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
 * The class DirectedDiagonalLine_CreateLine implements an upper tester.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   January 2022
 */
@DisplayName("the public static method DirectedDiagonalLine createLine() for class DirectedDiagonalLine is tested")
public class DirectedDiagonalLine_CreateLine { 
 
    private final Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
    
    @Test
    @DisplayName("createLine(): should return DirectedDiagonalLine when locations are defined as a diagonal line")
    public void createLine_shouldReturnDirectedDiagonalLine_WhenLocationsAreDefinedAsADiagonalLine( ) {
        
        String passedString = "b4 c5 d6 e7";

        assertThat( DirectedDiagonalLine.createLine( passedString, DIRECTION ) )
                  .as( "should return instance of DirectedDiagonalLine" )
                  .isInstanceOf( DirectedDiagonalLine.class );
    }

    @Test
    @DisplayName("createLine(): should return DirectedDiagonalLine when locations are defined as a diagonal line")
    public void createLine_shouldReturnDirectedDiagonalLine_WhenLocationsAreDefinedAsADiagonalLine_WithoutDirection( ) {

        String passedString = "b4 c5 d6 e7";

        assertThat( DirectedDiagonalLine.createLine( passedString ) )
                .as( "should return instance of DirectedDiagonalLine" )
                .isInstanceOf( DirectedDiagonalLine.class );
    }
    
    @Test
    @DisplayName("createLine(): should return direction for DirectedDiagonalLine when locations are defined as a diagonal from black to white")
    public void createLine_shouldReturnDirectionForDirectedDiagonalLine_WhenLocationsAreDefinedAsADiagonalFromBlackToWhite( ) {
        
        Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.BLACK, ColorEnum.WHITE );
        String passedString = "g7 f6 e5 d4";

        assertThat( DirectedDiagonalLine.createLine( passedString, DIRECTION ).getDirection() )
                  .as( "should return instance of DirectedDiagonalLine" )
                  .isEqualTo( DIRECTION );
    }

    @Test
    @DisplayName("createLine(): should return locations for DirectedDiagonalLine when locations are defined as a diagonal from black to white")
    public void createLine_shouldReturnDirectedDiagonalLine_WhenLocationsAreDefinedAsADiagonalFromBlackToWhite( ) {

        Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.BLACK, ColorEnum.WHITE );
        String passedString = "g7 f6 e5 d4";

        assertThat( DirectedDiagonalLine.createLine( passedString, DIRECTION ).getLocations() )
                .as( "should return instance of DirectedDiagonalLine" )
                .isEqualTo( passedString );
    }
    
    @Test
    @DisplayName("createLine(): should return direction for DirectedDiagonalLine when locations are defined as a diagonal from white to black")
    public void createLine_shouldReturnDirectionForDirectedDiagonalLine_WhenLocationsAreDefinedAsADiagonalFromWhiteToBlack( ) {
        
        Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        String passedString = "d4 e5 f6 g7";

        assertThat( DirectedDiagonalLine.createLine( passedString, DIRECTION ).getDirection() )
                  .as( "should return instance of DirectedDiagonalLine" )
                  .isEqualTo( DIRECTION );
    }

    @Test
    @DisplayName("createLine(): should return direction for DirectedDiagonalLine when locations are defined as a diagonal from white to black")
    public void createLine_shouldReturnDirectionForDirectedDiagonalLine_WhenLocationsAreDefined( ) {

        Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        String passedString = "d4 e5 f6 g7";

        assertThat( DirectedDiagonalLine.createLine( passedString ).getDirection() )
                .as( "should return instance of DirectedDiagonalLine" )
                .isEqualTo( DIRECTION );
    }

    @Test
    @DisplayName("createLine(): should return locations for DirectedDiagonalLine when locations are defined as a diagonal from white to black")
    public void createLine_shouldReturnLocationsForDirectedDiagonalLine_WhenLocationsAreDefinedAsADiagonalFromWhiteToBlack( ) {

        Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        String passedString = "d4 e5 f6 g7";

        assertThat( DirectedDiagonalLine.createLine( passedString, DIRECTION ).getLocations() )
                .as( "should return instance of DirectedDiagonalLine" )
                .isEqualTo( passedString );
    }

    @Test
    @DisplayName("createLine(): should return locations for DirectedDiagonalLine when locations are defined as a diagonal from white to black")
    public void createLine_shouldReturnLocationsForDirectedDiagonalLine_WhenLocationsAreDefined( ) {

        Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        String passedString = "d4 e5 f6 g7";

        assertThat( DirectedDiagonalLine.createLine( passedString ).getLocations() )
                .as( "should return instance of DirectedDiagonalLine" )
                .isEqualTo( passedString );
    }
  
    @Test
    @DisplayName("createLine(): should return DirectedDiagonalLine ignoring string when less than two names are offered")
    public void createLine_shouldReturnDirectedDiagonalLineIgnoringString_WhenLessThanTwoNamesAreOffered( ) {

        Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        String passedString = "e4 ";

        assertThat( DirectedDiagonalLine.createLine( passedString, DIRECTION ).getLocations() )
                  .as( "should return instance of DirectedDiagonalLine" )
                  .isEqualTo( "" );
    }
}

