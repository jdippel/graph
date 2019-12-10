/*
 *  LineBundleMigration_ExtractListForReversedDirection.java
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
 * The class LineBundleMigration_ExtractListForReversedDirection implements an upper tester.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 */
@DisplayName("the public static method List<String> extractListForReversedDirection() for class LineBundleMigration is tested")
public class LineBundleMigration_ExtractListForReversedDirection { 
    
	final String explanation = "result and expectation should match exactly";

    @Test
    @DisplayName("extractListForReversedDirection(): should return list of locations when location is part of the list and location is tail of the list")
    public void extractListForReversedDirection_shouldReturnListOfLocationsUpToAGivenLocation_WhenLocationIsPartOfListAndLocationIsTail( ) {
        
        String examinedString = "e1 e2 e3 e4 e5 e6";
        String location = "e6";
        List<String> expectedListOfStrings = new ArrayList<String>( Arrays.asList( new String[] { "e6", "e5", "e4", "e3", "e2", "e1" } ) );

        assertThat( LineBundleMigration.compare( expectedListOfStrings , LineBundleMigration.extractListForReversedDirection( examinedString, location ) ) ).as( explanation ).isTrue();
        assertThat( LineBundleMigration.extractListForReversedDirection( examinedString, location ) ).as( explanation ).isEqualTo( expectedListOfStrings );
    }
    
    @Test
    @DisplayName("extractListForReversedDirection(): should return list of locations when location is part of the list and location is second to last")
    public void extractListForReversedDirection_shouldReturnListOfLocationsUpToAGivenLocation_WhenLocationIsPartOfListAndLocationsIsSecondToLast( ) {
        
        String examinedString = "e1 e2 e3 e4 e5 e6";
        String location = "e5";
        List<String> expectedListOfStrings = new ArrayList<String>( Arrays.asList( new String[] { "e5", "e4", "e3", "e2", "e1" } ) );

        assertThat( LineBundleMigration.compare( expectedListOfStrings , LineBundleMigration.extractListForReversedDirection( examinedString, location ) ) ).as( explanation ).isTrue();
        assertThat( LineBundleMigration.extractListForReversedDirection( examinedString, location ) ).as( explanation ).isEqualTo( expectedListOfStrings );
    }
    
    @Test
    @DisplayName("extractListForReversedDirection(): should return list of locations when location is part of the list and location is on second place of the list")
    public void extractListForReversedDirection_shouldReturnListOfLocationsUpToAGivenLocation_WhenLocationIsPartOfListAndLocationIsOnSecondPlace( ) {
        
        String examinedString = "e1 e2 e3 e4 e5 e6";
        String location = "e2";
        List<String> expectedListOfStrings = new ArrayList<String>( Arrays.asList( new String[] { "e2", "e1" } ) );

        assertThat( LineBundleMigration.compare( expectedListOfStrings , LineBundleMigration.extractListForReversedDirection( examinedString, location ) ) ).as( explanation ).isTrue();
        assertThat( LineBundleMigration.extractListForReversedDirection( examinedString, location ) ).as( explanation ).isEqualTo( expectedListOfStrings );
    }
    
    @Test
    @DisplayName("extractListForReversedDirection(): should return list of locations when location is part of the list and location is head of the list")
    public void extractListForReversedDirection_shouldReturnListOfLocationsUpToAGivenLocation_WhenLocationIsPartOfListAndLocationIsHeadOfTheList( ) {
        
        String examinedString = "e1 e2 e3 e4 e5 e6";
        String location = "e1";
        List<String> expectedListOfStrings = new ArrayList<String>( Arrays.asList( new String[] { "e1" } ) );

        assertThat( LineBundleMigration.compare( expectedListOfStrings , LineBundleMigration.extractListForReversedDirection( examinedString, location ) ) ).as( explanation ).isTrue();
        assertThat( LineBundleMigration.extractListForReversedDirection( examinedString, location ) ).as( explanation ).isEqualTo( expectedListOfStrings );
    }
    
    @Test
    @DisplayName("extractListForReversedDirection(): should return empty list of locations when location is not part of the list")
    public void extractListForReversedDirection_shouldReturnEmptyList_WhenLocationIsNotPartOfList( ) {
        
        String examinedString = "e1 e2 e3 e4 e5 e6";
        String location = "d1";
        List<String> expectedListOfStrings = new ArrayList<String>( );

        assertThat( LineBundleMigration.compare( expectedListOfStrings , LineBundleMigration.extractListForReversedDirection( examinedString, location ) ) ).as( explanation ).isTrue();
        assertThat( LineBundleMigration.extractListForReversedDirection( examinedString, location ) ).as( explanation ).isEqualTo( expectedListOfStrings );
    }
}

