/*
 *  LineBundleMigration_Compare_String_String.java
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

package chess383.graph.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * <p>
 * The class LineBundleMigration_Compare_String_String implements an upper tester.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public static method boolean compare() for class LineBundleMigration with two parameters String and String is tested")
public class LineBundleMigration_Compare_String_String { 
    
	final String explanation = "structure should be similar, regarding order and elements";
	
    @Test
    @DisplayName("compare(): should return equality if the list elements each have an representation")
    public void compare_shouldReturnTrue_ForSimilarSubsets( ) {
        
        String firstString = "e2 e3 e4 , e6 e7";
        String secondString = "e6 e7 , e2 e3 e4";

        assertThat( LineBundleMigration.compare( firstString, secondString) ).as( explanation ).isTrue();
    }
    
    @Test
    @DisplayName("compare(): should return equality if the list are empty")
    public void compare_shouldReturnTrue_ForEmptyParameters( ) {
        
        String firstString = "";
        String secondString = "";

        assertThat( LineBundleMigration.compare( firstString, secondString) ).as( explanation ).isTrue();
    }
    
    @Test
    @DisplayName("compare(): should return a difference if the first parameter is defined but the second parameter is empty")
    public void compare_shouldReturnFalse_ForDefinedFirstParameterAndEmptySecondParameter( ) {
        
        String firstString = "e2 e3 e4 , e6 e7";
        String secondString = "";

        assertThat( LineBundleMigration.compare( firstString, secondString) ).as( explanation ).isFalse();
    }
    
    @Test
    @DisplayName("compare(): should return a difference if the first parameter empty but the second parameter is defined")
    public void compare_shouldReturnFals_ForDefinedFirstParameterAndEmptySecondParameter( ) {
        
        String firstString = "";
        String secondString = "e6 e7 , e2 e3 e4";

        assertThat( LineBundleMigration.compare( firstString, secondString) ).as( explanation ).isFalse();
    }
    
    @Test
    @DisplayName("compare(): should return difference if the number of separators are different")
    public void compare_shouldReturnFalse_ForDifferentNumberOfSeparators( ) {
        
        String firstString = "e3 e4 , e6 e7";
        String secondString = "e1 e2 , e6 e7 , e3 e4";

        assertThat( LineBundleMigration.compare( firstString, secondString) ).as( explanation ).isFalse();
    }
    
    @Test
    @DisplayName("compare(): should return difference if strings are different")
    public void compare_shouldReturnFalse_ForDifferentStrings( ) {
        
        String firstString = "e3 e4 , e6 e7";
        String secondString = "a8 a7 , b5 c4";

        assertThat( LineBundleMigration.compare( firstString, secondString) ).as( explanation ).isFalse();
    }
}

