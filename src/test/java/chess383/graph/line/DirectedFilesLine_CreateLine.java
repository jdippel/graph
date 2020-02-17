/*
 *  DirectedFilesLine_CreateLine.java
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

import chess383.ColorEnum;
import chess383.graph.direction.Direction;
import chess383.graph.line.DirectedFilesLine;


/**
 * <p>
 * The class DirectedFilesLine_CreateLine implements an upper tester.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   February 2020
 */
@DisplayName("the public static method DirectedFilesLine_CreateLine createLine() for class DirectedFilesLine is tested")
public class DirectedFilesLine_CreateLine { 
 
    private final Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
    
    @Test
    @DisplayName("createLine(): should return DirectedFilesLine when locations are defined as a file from black to white")
    public void createLine_shouldReturnDirectedFilesLine_WhenLocationsAreDefinedAsAFileFromBlackToWhite( ) {
        
        Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.BLACK, ColorEnum.WHITE );
        String passedString = "b5 b4 b3 b2 b1";
        String expectedString = "b5 b4 b3 b2 b1";

        assertThat( DirectedFilesLine.createLine( DIRECTION, passedString ) )
                  .as( "should return instance of DirectedFilesLine" )
                  .isEqualTo( DirectedFilesLine.createLine( DIRECTION, expectedString ));
    }
    
    @Test
    @DisplayName("createLine(): should return DirectedFilesLine with normalized reversed string when locations are defined")
    public void createLine_shouldReturnDirectedFilesLineWithNormalizedString_WhenLocationsAreDefinedAndDirectionIsUnidirectional( ) {
        
        Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        String passedString = "e3 e3  e4  e5 e6 e7";
        String expectedString = "e3 e3 e4 e5 e6 e7";

        assertThat( DirectedFilesLine.createLine( DIRECTION, passedString ) )
                  .as( "should return instance of DirectedFilesLine" )
                  .isEqualTo( DirectedFilesLine.createLine( DIRECTION, expectedString ));
    }
    
    @Test
    @DisplayName("createLine(): should return DirectedFilesLine ignoring string when less than two names are offered")
    public void createLine_shouldReturnDirectedFilesLineIgnoringString_WhenLessThanTwoNamesAreOffered( ) {

        String passedString = "e4 ";
        String expectedString = "";

        assertThat( DirectedFilesLine.createLine( DIRECTION, passedString ) )
                  .as( "should return instance of DirectedFilesLine" )
                  .isEqualTo( DirectedFilesLine.createLine( DIRECTION, expectedString ));
    } 
}

