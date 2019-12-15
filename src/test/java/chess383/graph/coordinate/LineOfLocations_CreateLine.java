/*
 *  LineOfLocations_CreateLine.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2019 Jörg Dippel
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

package chess383.graph.coordinate;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ColorEnum;
import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.coordinate.LineOfLocations;
import chess383.graph.direction.Direction;


/**
 * <p>
 * The class LineOfLocations_CreateLine implements an upper tester.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 */
@DisplayName("the public static method LineOfLocations createLine() for class LineOfLocations is tested")
public class LineOfLocations_CreateLine { 
 
    @Test
    @DisplayName("createLine(): should return LineOfLocations when locations are defined as a rank")
    public void createLine_shouldReturnLineOfLocations_WhenLocationsAreDefinedAsARank( ) {
        
        AdjacencyEnum ADJACENCY = AdjacencyEnum.BY_EDGE;
        Direction DIRECTION = Direction.createBidirectionalDirection();
        String passedString = "e4 e5 e6 e7 e8";

        assertThat( LineOfLocations.createLine( ADJACENCY, DIRECTION, passedString ) )
                  .as( "should return instance of LineOfLocations" )
                  .isInstanceOf( LineOfLocations.class );
    }
    
    @Test
    @DisplayName("createLine(): should return LineOfLocations when locations are defined as a diagonal from black to white")
    public void createLine_shouldReturnLineOfLocations_WhenLocationsAreDefinedAsADiagonalFromBlackToWhite( ) {
        
        AdjacencyEnum ADJACENCY = AdjacencyEnum.BY_POINT;
        Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.BLACK, ColorEnum.WHITE );
        String passedString = "g7 f6 e5 d4";
        String expectedString = "g7 f6 e5 d4";

        assertThat( LineOfLocations.createLine( ADJACENCY, DIRECTION, passedString ) )
                  .as( "should return instance of LineOfLocations" )
                  .isEqualTo( LineOfLocations.createLine( ADJACENCY, DIRECTION, expectedString ));
    }
    
    @Test
    @DisplayName("createLine(): should return LineOfLocations when locations are defined as a diagonal from white to black")
    public void createLine_shouldReturnLineOfLocations_WhenLocationsAreDefinedAsADiagonalFromWhiteToBlack( ) {
        
        AdjacencyEnum ADJACENCY = AdjacencyEnum.BY_POINT;
        Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        String passedString = "d4 e5 f6 g7";
        String expectedString = "d4 e5 f6 g7";

        assertThat( LineOfLocations.createLine( ADJACENCY, DIRECTION, passedString ) )
                  .as( "should return instance of LineOfLocations" )
                  .isEqualTo( LineOfLocations.createLine( ADJACENCY, DIRECTION, expectedString ));
    }
    
    @Test
    @DisplayName("createLine(): should return LineOfLocations with normalized string when locations are defined")
    public void createLine_shouldReturnLineOfLocationsWithNormalizedString_WhenLocationsAreDefined( ) {
        
        AdjacencyEnum ADJACENCY = AdjacencyEnum.BY_EDGE;
        Direction DIRECTION = Direction.createBidirectionalDirection();
        String passedString = "e4 e5  e6 e7 e8 ";
        String expectedString = "e4 e5 e6 e7 e8";

        assertThat( LineOfLocations.createLine( ADJACENCY, DIRECTION, passedString ) )
                  .as( "should return instance of LineOfLocations" )
                  .isEqualTo( LineOfLocations.createLine( ADJACENCY, DIRECTION, expectedString ));
    }
    
    @Test
    @DisplayName("createLine(): should return LineOfLocations with normalized reversed string when locations are defined")
    public void createLine_shouldReturnLineOfLocationsWithNormalizedReversedString_WhenLocationsAreDefined( ) {
        
        AdjacencyEnum ADJACENCY = AdjacencyEnum.BY_EDGE;
        Direction DIRECTION = Direction.createBidirectionalDirection();
        String passedString = " e8 e7  e6  e5 e4";
        String expectedString = "e4 e5 e6 e7 e8";

        assertThat( LineOfLocations.createLine( ADJACENCY, DIRECTION, passedString ) )
                  .as( "should return instance of LineOfLocations" )
                  .isEqualTo( LineOfLocations.createLine( ADJACENCY, DIRECTION, expectedString ));
    }
    
    @Test
    @DisplayName("createLine(): should return LineOfLocations with normalized reversed string when locations are defined")
    public void createLine_shouldReturnLineOfLocationsWithNormalizedString_WhenLocationsAreDefinedANDDirectioIsUnidirectional( ) {
        
        AdjacencyEnum ADJACENCY = AdjacencyEnum.BY_EDGE;
        Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        String passedString = " e8 e7  e6  e5 e4";
        String expectedString = "e8 e7 e6 e5 e4";

        assertThat( LineOfLocations.createLine( ADJACENCY, DIRECTION, passedString ) )
                  .as( "should return instance of LineOfLocations" )
                  .isEqualTo( LineOfLocations.createLine( ADJACENCY, DIRECTION, expectedString ));
    }
    
    @Test
    @DisplayName("createLine(): should return LineOfLocations ignoring string when less than two names are offered")
    public void createLine_shouldReturnLineOfLocationsIgnoringString_WhenLessThanTwoNamesAreOffered( ) {
        
        AdjacencyEnum ADJACENCY = AdjacencyEnum.BY_EDGE;
        Direction DIRECTION = Direction.createBidirectionalDirection();
        String passedString = "e4 ";
        String expectedString = "";

        assertThat( LineOfLocations.createLine( ADJACENCY, DIRECTION, passedString ) )
                  .as( "should return instance of LineOfLocations" )
                  .isEqualTo( LineOfLocations.createLine( ADJACENCY, DIRECTION, expectedString ));
    }
}

