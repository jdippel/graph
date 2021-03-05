/*
 *  LineBundle_CreateLine.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2021 Jörg Dippel
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

package chess383.graph.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ColorEnum;
import chess383.graph.direction.Direction;
import chess383.graph.line.DirectedDiagonalLine;
import chess383.graph.line.DirectedFilesLine;
import chess383.graph.line.KnightsLine;
import chess383.graph.line.LineOfLocations;
import chess383.graph.line.UndirectedRowsLine;


/**
 * <p>
 * The class LineBundle_CreateLine implements an upper tester.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   February 2021
 *
 */
@DisplayName("the public static method LineOfLocations createLine() for class LineBundle is tested")
public class LineBundle_CreateLine { 
    
    final String explanationForDirection = "direction should match";
    final String explanationForLocations = "structure should be mapped, regarding order and elements";
    
    @Test
    @DisplayName("UndirectedRowsLine.createLine(): should return equality if the order and the list elements each are equal")
    public void createLine_shouldReturnCorrectDirectionAndLocations_ForUndirectedRowsLine( ) {
        
        String locations = "e4 e5 e6";
        LineOfLocations receivedCreatedLine = UndirectedRowsLine.createLine( locations );

        assertThat( receivedCreatedLine.getDirection() ).as( explanationForDirection ).isEqualTo(( Direction.createBidirectionalDirection() ) );
        assertThat( receivedCreatedLine.getLocations() ).as( explanationForLocations ).isEqualTo( locations );
    }
    
    @Test
    @DisplayName("createRankLine(): should return equality if the order and the list elements each are equal")
    public void createLine_shouldReturnCorrectDirectionAndLocations_ForCreateRankLine( ) {
        
        String locations = "e4 e5 e6";
        LineOfLocations receivedCreatedLine = LineBundle.createRankLine( locations );

        assertThat( receivedCreatedLine.getDirection() ).as( explanationForDirection ).isEqualTo(( Direction.createBidirectionalDirection() ) );
        assertThat( receivedCreatedLine.getLocations() ).as( explanationForLocations ).isEqualTo( locations );
    }
    
    
    @Test
    @DisplayName("DirectedFilesLine.createLine(): should return equality if the order and the list elements each are equal")
    public void createLine_shouldReturnCorrectDirectionAndLocations_ForDirectedFilesLine( ) {
        
        Direction direction = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        String locations = "e4 e5 e6";
        LineOfLocations receivedCreatedLine = DirectedFilesLine.createLine( direction, locations );

        assertThat( receivedCreatedLine.getDirection() ).as( explanationForDirection ).isEqualTo(( direction ) );
        assertThat( receivedCreatedLine.getLocations() ).as( explanationForLocations ).isEqualTo( locations );
    }
    
    @Test
    @DisplayName("createFileLine(): should return equality if the order and the list elements each are equal")
    public void createLine_shouldReturnCorrectDirectionAndLocations_ForCreateFileLineCalledWithTwoArguments( ) {
        
        Direction direction = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        String locations = "e4 e5 e6";
        LineOfLocations receivedCreatedLine = LineBundle.createFileLine( locations, direction );

        assertThat( receivedCreatedLine.getDirection() ).as( explanationForDirection ).isEqualTo(( direction ) );
        assertThat( receivedCreatedLine.getLocations() ).as( explanationForLocations ).isEqualTo( locations );
    }
    
    @Test
    @DisplayName("createFileLine(): should return equality if the order and the list elements each are equal")
    public void createLine_shouldReturnCorrectDirectionAndLocations_ForCreateFileLineCalledWithOneArgument( ) {
        
        Direction direction = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        String locations = "e4 e5 e6";
        LineOfLocations receivedCreatedLine = LineBundle.createFileLine( locations );

        assertThat( receivedCreatedLine.getDirection() ).as( explanationForDirection ).isEqualTo(( direction ) );
        assertThat( receivedCreatedLine.getLocations() ).as( explanationForLocations ).isEqualTo( locations );
    }
    

    @Test
    @DisplayName("DirectedDiagonalLine.createLine(): should return equality if the order and the list elements each are equal")
    public void createLine_shouldReturnCorrectDirectionAndLocations_ForDirectedDiagonalLine( ) {
        
        Direction direction = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        String locations = "e4 f5 g6";
        LineOfLocations receivedCreatedLine = DirectedDiagonalLine.createLine( direction, locations );

        assertThat( receivedCreatedLine.getDirection() ).as( explanationForDirection ).isEqualTo(( direction ) );
        assertThat( receivedCreatedLine.getLocations() ).as( explanationForLocations ).isEqualTo( locations );
    }
    
    @Test
    @DisplayName("createDiagonalLine(): should return equality if the order and the list elements each are equal")
    public void createLine_shouldReturnCorrectDirectionAndLocations_ForCreateDiagonalLineWithTwoArguments( ) {
        
        Direction direction = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        String locations = "e4 f5 g6";
        LineOfLocations receivedCreatedLine = LineBundle.createDiagonalLine( locations, direction );

        assertThat( receivedCreatedLine.getDirection() ).as( explanationForDirection ).isEqualTo(( direction ) );
        assertThat( receivedCreatedLine.getLocations() ).as( explanationForLocations ).isEqualTo( locations );
    }
    
    @Test
    @DisplayName("createDiagonalLine(): should return equality if the order and the list elements each are equal")
    public void createLine_shouldReturnCorrectDirectionAndLocations_ForCreateDiagonalLineWithOneArgument( ) {
        
        Direction direction = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        String locations = "e4 f5 g6";
        LineOfLocations receivedCreatedLine = LineBundle.createDiagonalLine( locations );

        assertThat( receivedCreatedLine.getDirection() ).as( explanationForDirection ).isEqualTo(( direction ) );
        assertThat( receivedCreatedLine.getLocations() ).as( explanationForLocations ).isEqualTo( locations );
    }
    

    @Test
    @DisplayName("KnightsLine.createLine(): should return equality if the order and the list elements each are equal")
    public void createLine_shouldReturnCorrectDirectionAndLocations_ForKnightsLine( ) {
        
        Direction direction = Direction.createBidirectionalDirection();
        String locations = "e4 f3";
        LineOfLocations receivedCreatedLine = KnightsLine.createLine( locations );

        assertThat( receivedCreatedLine.getDirection() ).as( explanationForDirection ).isEqualTo(( direction ) );
        assertThat( receivedCreatedLine.getLocations() ).as( explanationForLocations ).isEqualTo( locations );
    }
    
    @Test
    @DisplayName("KnightsLine.createLine(): should return equality if the order and the list elements each are equal")
    public void createLine_shouldReturnCorrectDirectionAndLocations_ForCreateKnightLine( ) {
        
        Direction direction = Direction.createBidirectionalDirection();
        String locations = "e4 f3";
        LineOfLocations receivedCreatedLine = LineBundle.createKnightLine( locations );

        assertThat( receivedCreatedLine.getDirection() ).as( explanationForDirection ).isEqualTo(( direction ) );
        assertThat( receivedCreatedLine.getLocations() ).as( explanationForLocations ).isEqualTo( locations );
    }
}

