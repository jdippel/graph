/*
 *  KnightsLine_Equals.java
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
 * The class KnightsLine_Equals implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   February 2020
 *
 */
@DisplayName("the public method boolean equals( ) for class KnightsLine is tested")
public class KnightsLine_Equals {

    final KnightsLine EXPECTED_LINE = KnightsLine.createLine( "c3 d1 e3 f1" );
    
    @Test
    @DisplayName("equals(): return value should be true when strings for KnightsLine.createLine() are identical") 
    public void equals_shouldBeEqual_WhenStringsAreIdentical( ) {

        String inputLine = "c3 d1 e3 f1";
        KnightsLine discreteLine = KnightsLine.createLine( inputLine );
        
        assertThat( discreteLine.equals( EXPECTED_LINE ) )
                  .as( "strings should be equal" )
                  .isTrue();
    }
    
    @Test
    @DisplayName("equals(): return value should be false when within the string for KnightsLine.createLine() location names are missing") 
    public void equals_shouldNotBeEqual_WhenLocationNamesAreMissingWithinLine( ) {

        String inputLine = "c3 d1    f1";
        KnightsLine discreteLine = KnightsLine.createLine( inputLine );
        
        assertThat( discreteLine.equals( EXPECTED_LINE ) )
                  .as( "strings must not be equal" )
                  .isFalse();
    }
    
    @Test
    @DisplayName("equals(): return value should be true when strings for KnightsLine.createLine() are similar but only differing for white spaces") 
    public void equals_shouldBeEqual_WhenStringsAreSimilarButOnlyDifferingForWhiteSpaces( ) {

    	String inputLine = " c3  d1 e3 f1 ";
    	KnightsLine discreteLine = KnightsLine.createLine( inputLine );
        
        assertThat( discreteLine.equals( EXPECTED_LINE ) )
                  .as( "strings should be equal" )
                  .isTrue();
    }
}

