/*
 *  LineBundleMigration_Flatten.java
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <p>
 * The class LineBundleMigration_Flatten implements an upper tester.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public static method Set<String> flatten() for class LineBundleMigration is tested")
public class LineBundleMigration_Flatten { 
    
	final String explanation = "result and expectation should match due to LineBundleMigration.compare()";

    @Test
    @DisplayName("flatten(): should return flattened bundles structure for given two lines")
    public void flatten_shouldReturnFlattenedBundleStructure_ForGivenTwoLines( ) {
        
    	Set<List<String>> bundle = new HashSet<List<String>>();
    	bundle.add( new ArrayList<String>( Arrays.asList( new String[] { "e4", "e5", "e6" } ) ) );
    	bundle.add( new ArrayList<String>( Arrays.asList( new String[] { "e4", "c3" } ) ) );

        String expectedString = "e4 c3 , e4 e5 e6";
        
        assertThat( LineBundleMigration.compare( expectedString, LineBundleMigration.flatten( bundle ) ) ).as( explanation ).isTrue();
    }
    
    @Test
    @DisplayName("flatten(): should return flattened bundles structure for given line")
    public void flatten_shouldReturnFlattenedBundleStructure_ForGivenLine( ) {
        
    	Set<List<String>> bundle = new HashSet<List<String>>();
    	bundle.add( new ArrayList<String>( Arrays.asList( new String[] { "e4", "c3" } ) ) );

        String expectedString = "e4 c3";
        
        assertThat( LineBundleMigration.compare( expectedString, LineBundleMigration.flatten( bundle ) ) ).as( explanation ).isTrue();
    }
    
    @Test
    @DisplayName("flatten(): should return flattened bundles structure for empty set of lines")
    public void reduce( ) {
        
    	Set<List<String>> bundle = new HashSet<List<String>>();
        String expectedString = "";
        
        assertThat( LineBundleMigration.compare( expectedString, LineBundleMigration.flatten( bundle ) ) ).as( explanation ).isTrue();
    }
}

