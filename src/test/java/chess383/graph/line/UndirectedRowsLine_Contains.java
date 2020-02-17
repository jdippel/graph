/*
 *  UndirectedRowsLine_Contains.java
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
 * The class UndirectedRowsLine_Contains implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   February 2020
 *
 */
@DisplayName("the public method boolean contains( ) for class UndirectedRowsLine is tested")
public class UndirectedRowsLine_Contains {

    final String GIVEN_LINE = "b2 c2 d2 e2";

    @Test
    @DisplayName("contains(): return value should be true when location is contained in the middle of the given line")
    public void contains_shouldBeTrue_WhenLocationIsContainedInTheMiddleOfTheLine( ) {

        final String location = "c2";
        UndirectedRowsLine discreteLine = UndirectedRowsLine.createLine( GIVEN_LINE );

        assertThat( discreteLine.contains( location ))
                  .as( String.format( "defined line %s with location %s should contain location if asked", GIVEN_LINE, location ) )
                  .isTrue();
    }
    
    @Test
    @DisplayName("contains(): return value should be true when location is contained at the beginning of the given line")
    public void contains_shouldBeTrue_WhenLocationIsContainedInTheBeginningOfTheLine( ) {

        final String location = "b2";
        UndirectedRowsLine discreteLine = UndirectedRowsLine.createLine( GIVEN_LINE );

        assertThat( discreteLine.contains( location ))
                  .as( String.format( "defined line %s with location %s should contain location if asked", GIVEN_LINE, location ) )
                  .isTrue();
    }
    
    @Test
    @DisplayName("contains(): return value should be true when location is contained at the end of the given line")
    public void contains_shouldBeTrue_WhenLocationIsContainedAtTheEndOfTheLine( ) {

        final String location = "e2";
        UndirectedRowsLine discreteLine = UndirectedRowsLine.createLine( GIVEN_LINE );

        assertThat( discreteLine.contains( location ))
                  .as( String.format( "defined line %s with location %s should contain location if asked", GIVEN_LINE, location ) )
                  .isTrue();
    }
    
    @Test
    @DisplayName("contains(): return value should be false when location is a string but not a specified name")
    public void contains_shouldBeFalse_WhenLocationIsNotDefinedByAName( ) {

        final String location = "c2 d2";   // a name does not contain white spaces
        UndirectedRowsLine discreteLine = UndirectedRowsLine.createLine( GIVEN_LINE );

        assertThat( discreteLine.contains( location ))
                  .as( String.format( "defined line %s with passed locations %s should return false for several locations", GIVEN_LINE, location ) )
                  .isFalse();
    }
    
    @Test
    @DisplayName("contains(): return value should be false when location is misspelled")
    public void contains_shouldBeFalse_WhenLocationIsMisspelled( ) {

        final String location = "2c";   // a name should have a format - first literal then number
        UndirectedRowsLine discreteLine = UndirectedRowsLine.createLine( GIVEN_LINE );

        assertThat( discreteLine.contains( location ))
                  .as( String.format( "defined line %s with passed location %s should return true only if it matches exactly", GIVEN_LINE, location ) )
                  .isFalse();
    }
    
    @Test
    @DisplayName("contains(): return value should be false when created line is null or empty")
    public void contains_shouldBeFalse_WhenCreatedLineIsEmptyOrNull( ) {

        final String location = "c2";
        UndirectedRowsLine discreteLine = UndirectedRowsLine.createLine( null );

        assertThat( discreteLine.contains( location ))
                  .as( String.format( "an empty line %s with passed location %s should return always false", GIVEN_LINE, location ) )
                  .isFalse();
    }
    
    @Test
    @DisplayName("contains(): return value should be false when location is empty")
    public void contains_shouldBeFalse_WhenCreatedLocationIsEmpty( ) {

        final String location = "";   // an empty name
        UndirectedRowsLine discreteLine = UndirectedRowsLine.createLine( GIVEN_LINE );

        assertThat( discreteLine.contains( location ))
                  .as( String.format( "an empty line %s with passed location %s should return always false", GIVEN_LINE, location ) )
                  .isFalse();
    }
    
    @Test
    @DisplayName("contains(): return value should be false when location is null")
    public void contains_shouldBeFalse_WhenCreatedLocationIsNull( ) {

        final String location = null;   // a nullable name
        UndirectedRowsLine discreteLine = UndirectedRowsLine.createLine( GIVEN_LINE );

        assertThat( discreteLine.contains( location ))
                  .as( String.format( "an empty line %s with passed location %s should return always false", GIVEN_LINE, location ) )
                  .isFalse();
    }
}

