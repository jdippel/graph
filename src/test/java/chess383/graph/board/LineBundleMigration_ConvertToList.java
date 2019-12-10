/*
 *  LineBundleMigration_ConvertToList.java
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
 * The class LineBundleMigration_ConvertToList implements an upper tester.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 */
@DisplayName("the public static method String convertToList() for class LineBundleMigration is tested")
public class LineBundleMigration_ConvertToList { 
    
    @Test
    @DisplayName("convertToList(): should return List<String> when locations are defined within a given string")
    public void convertToList_shouldReturnListOfStrings_ForGivenStringContainingLocations( ) {
    	
    	String passedString = "e4 e5 e6 e7 e8";

        assertThat( LineBundleMigration.convertToList( passedString ) )
                  .as( "string should be split by white space separator and ordered as List<String>" )
                  .isEqualTo( Arrays.asList( passedString.split( "\\s+" ) ) );
    }
    
    @Test
    @DisplayName("convertToList(): should return List<String> when locations are defined within a given string")
    public void convertToList_shouldReturnListOfStrings_ForGivenStringContainingLocations_OldStyle( ) {
    	
    	String passedString = "e4 e5 e6 e7 e8";
    	
    	List<String> expectedList = new ArrayList<>();
    	expectedList.add( "e4" );
    	expectedList.add( "e5" );
    	expectedList.add( "e6" );
    	expectedList.add( "e7" );
    	expectedList.add( "e8" );
    	
        assertThat( LineBundleMigration.convertToList( passedString ) )
                  .as( "string should be split by white space separator and ordered as List<String>" )
                  .isEqualTo( expectedList );
    }
}

