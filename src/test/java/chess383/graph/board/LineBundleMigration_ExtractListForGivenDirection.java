/*
 *  LineBundleMigration_ExtractListForGivenDirection.java
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
 * The class LineBundleMigration_ExtractListForGivenDirection implements an upper tester.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 */
@DisplayName("the public static method List<String> extractListForGivenDirection() for class LineBundleMigration is tested")
public class LineBundleMigration_ExtractListForGivenDirection { 
    
	final String explanation = "result and expectation should match exactly";
	
    @Test
    @DisplayName("extractListForGivenDirection(): should return list of locations beginning with the given location only if location is part of the list and location is head of the list")
    public void extractListForGivenDirection_shouldReturnListOfLocations_WhenLocationIsPartOfListAndLocationIsHeadOfTheList( ) {
        
        String examinedString = "e1 e2 e3 e4 e5 e6";
        String location = "e1";
        List<String> expectedListOfStrings = new ArrayList<String>( Arrays.asList( new String[] { "e1", "e2", "e3", "e4", "e5", "e6" } ) );

        assertThat( LineBundleMigration.compare( expectedListOfStrings , LineBundleMigration.extractListForGivenDirection( examinedString, location ) ) ).as( explanation ).isTrue();
        assertThat( LineBundleMigration.extractListForGivenDirection( examinedString, location ) ).as( explanation ).isEqualTo( expectedListOfStrings );
    }
    
    @Test
    @DisplayName("extractListForGivenDirection(): should return list of locations beginning with the given location if location is part of the list and location is in the middle of the list")
    public void extractListForGivenDirection_shouldReturnListOfLocations_WhenLocationIsPartOfListAndLocationIsSecond( ) {
        
        String examinedString = "e1 e2 e3 e4 e5 e6";
        String location = "e2";
        List<String> expectedListOfStrings = new ArrayList<String>( Arrays.asList( new String[] { "e2", "e3", "e4", "e5", "e6" } ) );

        assertThat( LineBundleMigration.compare( expectedListOfStrings , LineBundleMigration.extractListForGivenDirection( examinedString, location ) ) ).as( explanation ).isTrue();
        assertThat( LineBundleMigration.extractListForGivenDirection( examinedString, location ) ).as( explanation ).isEqualTo( expectedListOfStrings );
    }
    
    @Test
    @DisplayName("extractListForGivenDirection(): should return list of locations beginning with the given location if location is part of the list and location is second to last in the list")
    public void extractListForGivenDirection_shouldReturnListOfLocations_WhenLocationIsPartOfListAndLocationIsSecondToLast( ) {
        
        String examinedString = "e1 e2 e3 e4 e5 e6";
        String location = "e5";
        List<String> expectedListOfStrings = new ArrayList<String>( Arrays.asList( new String[] { "e5", "e6" } ) );

        assertThat( LineBundleMigration.compare( expectedListOfStrings , LineBundleMigration.extractListForGivenDirection( examinedString, location ) ) ).as( explanation ).isTrue();
        assertThat( LineBundleMigration.extractListForGivenDirection( examinedString, location ) ).as( explanation ).isEqualTo( expectedListOfStrings );
    }
    
    @Test
    @DisplayName("extractListForGivenDirection(): should return list of locations beginning with the given location if location is part of the list and location is tail of  the list")
    public void extractListForGivenDirection_shouldReturnListOfLocations_WhenLocationIsPartOfListAndTailOfTheList( ) {
        
        String examinedString = "e1 e2 e3 e4 e5 e6";
        String location = "e6";
        List<String> expectedListOfStrings = new ArrayList<String>( Arrays.asList( new String[] { "e6" } ));

        assertThat( LineBundleMigration.compare( expectedListOfStrings , LineBundleMigration.extractListForGivenDirection( examinedString, location ) ) ).as( explanation ).isTrue();
        assertThat( LineBundleMigration.extractListForGivenDirection( examinedString, location ) ).as( explanation ).isEqualTo( expectedListOfStrings );
    }
    
    @Test
    @DisplayName("extractListForGivenDirection(): should return empty list of locations if location is not part of the list")
    public void extractListForGivenDirection_shouldReturnEmptyList_WhenLocationIsNotPartOfList( ) {
        
        String examinedString = "e1 e2 e3 e4 e5 e6";
        String location = "e7";
        List<String> expectedListOfStrings = new ArrayList<String>( );

        assertThat( LineBundleMigration.compare( expectedListOfStrings , LineBundleMigration.extractListForGivenDirection( examinedString, location ) ) ).as( explanation ).isTrue();
        assertThat( LineBundleMigration.extractListForGivenDirection( examinedString, location ) ).as( explanation ).isEqualTo( expectedListOfStrings );
    }
}

