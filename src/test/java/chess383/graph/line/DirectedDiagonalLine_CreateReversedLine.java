/*
 *  DirectedDiagonalLine_createReversedLine.java
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

import chess383.ColorEnum;
import chess383.graph.direction.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * <p>
 * The class DirectedDiagonalLine_createReversedLine implements an upper tester.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   January 2022
 */
@DisplayName("the public static method DirectedDiagonalLine createReversedLine() for class DirectedDiagonalLine is tested")
public class DirectedDiagonalLine_CreateReversedLine {
 
    private final Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
    
    @Test
    @DisplayName("createReversedLine(): should return DirectedDiagonalLine when locations are defined as a diagonal line")
    public void createReversedLine_shouldReturnDirectedDiagonalLine_WhenLocationsAreDefinedAsADiagonalLine( ) {
        
        String passedString = "b4 c5 d6 e7";

        assertThat( DirectedDiagonalLine.createReversedLine( passedString, DIRECTION ) )
                  .as( "should return instance of DirectedDiagonalLine" )
                  .isInstanceOf( DirectedDiagonalLine.class );
    }
    
    @Test
    @DisplayName("createReversedLine(): should return direction for DirectedDiagonalLine when locations are defined as a diagonal from black to white")
    public void createReversedLine_shouldReturnDirectionForDirectedDiagonalLine_WhenLocationsAreDefinedAsADiagonalFromBlackToWhite( ) {
        
        Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.BLACK, ColorEnum.WHITE );
        String passedString = "g7 f6 e5 d4";

        assertThat( DirectedDiagonalLine.createReversedLine( passedString, DIRECTION ).getDirection() )
                  .as( "should return instance of DirectedDiagonalLine" )
                  .isEqualTo( Direction.createReversedDirection( DIRECTION ) );
    }

    @Test
    @DisplayName("createReversedLine(): should return locations for DirectedDiagonalLine when locations are defined as a diagonal from black to white")
    public void createReversedLine_shouldReturnLocationsForDirectedDiagonalLine_WhenLocationsAreDefinedAsADiagonalFromBlackToWhite( ) {

        Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.BLACK, ColorEnum.WHITE );
        String passedString = "g7 f6 e5 d4";

        assertThat( DirectedDiagonalLine.createReversedLine( passedString, DIRECTION ).getLocations() )
                .as( "should return instance of DirectedDiagonalLine" )
                .isEqualTo( "d4 e5 f6 g7" );
    }
    
    @Test
    @DisplayName("createReversedLine(): should return direction for DirectedDiagonalLine when locations are defined as a diagonal from white to black")
    public void createReversedLine_shouldReturnDirectionForDirectedDiagonalLine_WhenLocationsAreDefinedAsADiagonalFromWhiteToBlack( ) {
        
        Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        String passedString = "d4 e5 f6 g7";

        assertThat( DirectedDiagonalLine.createReversedLine( passedString, DIRECTION ).getDirection() )
                  .as( "should return instance of DirectedDiagonalLine" )
                  .isEqualTo( Direction.createReversedDirection( DIRECTION ) );
    }

    @Test
    @DisplayName("createReversedLine(): should return direction for DirectedDiagonalLine when locations are defined as a diagonal from white to black")
    public void createReversedLine_shouldReturnDirectionForDirectedDiagonalLine_WhenLocationsAreDefined( ) {

        Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        String passedString = "d4 e5 f6 g7";

        assertThat( DirectedDiagonalLine.createReversedLine( passedString ).getDirection() )
                .as( "should return instance of DirectedDiagonalLine" )
                .isEqualTo( Direction.createReversedDirection( DIRECTION ) );
    }

    @Test
    @DisplayName("createReversedLine(): should return locations for DirectedDiagonalLine when locations are defined as a diagonal from white to black")
    public void createReversedLine_shouldReturnLocationsForDirectedDiagonalLine_WhenLocationsAreDefinedAsADiagonalFromWhiteToBlack( ) {

        Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        String passedString = "d4 e5 f6 g7";

        assertThat( DirectedDiagonalLine.createReversedLine( passedString, DIRECTION ).getLocations() )
                .as( "should return instance of DirectedDiagonalLine" )
                .isEqualTo( "g7 f6 e5 d4" );
    }

    @Test
    @DisplayName("createReversedLine(): should return locations for DirectedDiagonalLine when locations are defined as a diagonal from white to black")
    public void createReversedLine_shouldReturnLocationsForDirectedDiagonalLine_WhenLocationsAreDefined( ) {

        String passedString = "d4 e5 f6 g7";

        assertThat( DirectedDiagonalLine.createReversedLine( passedString ).getLocations() )
                .as( "should return instance of DirectedDiagonalLine" )
                .isEqualTo( "g7 f6 e5 d4" );
    }
  
    @Test
    @DisplayName("createReversedLine(): should return DirectedDiagonalLine ignoring string when less than two names are offered")
    public void createReversedLine_shouldReturnDirectedDiagonalLineIgnoringString_WhenLessThanTwoNamesAreOffered( ) {

        Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        String passedString = "e4 ";

        assertThat( DirectedDiagonalLine.createReversedLine( passedString, DIRECTION ).getLocations() )
                  .as( "should return instance of DirectedDiagonalLine" )
                  .isEqualTo( "" );
    }
}

