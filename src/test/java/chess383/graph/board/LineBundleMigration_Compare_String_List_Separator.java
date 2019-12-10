/*
 *  LineBundleMigration_Compare_String_List_Separator.java
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * <p>
 * The class LineBundleMigration_Compare_String_List_Separator implements an upper tester.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public static method boolean compare() for class LineBundleMigration with three parameters String, List<String> and String is tested")
public class LineBundleMigration_Compare_String_List_Separator { 
    
	final String explanation = "structure should be similar, regarding order and elements";
	
    @Test
    @DisplayName("compare(): should return equality if the order and the list elements each are equal")
    public void compare_shouldReturnTrue_ForIdenticalLists_FilledList( ) {
        
        List<String> list = Arrays.asList( "e4 e5", "e7 e8" );
        String separator = " t ";
        String flattenedString = "e4 e5" + separator + "e7 e8";

        assertThat( LineBundleMigration.compare( flattenedString, list, separator ) ).as( explanation ).isTrue();
    }
    
    @Test
    @DisplayName("compare(): should return equality for empty parameters")
    public void compare_shouldReturnTrue_ForEmptyParameters( ) {
        
        List<String> list = new ArrayList<>();
        String separator = " t ";
        String flattenedString = "";

        assertThat( LineBundleMigration.compare( flattenedString, list, separator ) ).as( explanation ).isTrue();
    }
    
    @Test
    @DisplayName("compare(): should return false for empty string but filled list")
    public void compare_shouldReturnFalse_ForEmptyStringButFilledList( ) {
        
        List<String> list = Arrays.asList( "e4 e5", "e7 e8" );
        String separator = " t ";
        String flattenedString = "";

        assertThat( LineBundleMigration.compare( flattenedString, list, separator ) ).as( explanation ).isFalse();
    }
    
    @Test
    @DisplayName("compare(): should return false for filled string but empty list")
    public void compare_shouldReturnTrue_ForFilledStringButEmptyList( ) {
        
        List<String> list = new ArrayList<>();
        String separator = " t ";
        String flattenedString = "e4 e5";

        assertThat( LineBundleMigration.compare( flattenedString, list, separator ) ).as( explanation ).isFalse();
    }
}

