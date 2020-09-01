/*
 *  LineBundleMigration_Compare_String_Set.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2019, 2020 Jörg Dippel
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

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * <p>
 * The class LineBundleMigration_Compare_String_Set implements an upper tester.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   August 2020
 *
 */
@DisplayName("the public static method boolean compare() for class LineBundleMigration with two parameters String and Set<String> is tested")
public class LineBundleMigration_Compare_String_Set { 
    
	final String explanation = "structure should be similar, regarding order and elements";
	
    @Test
    @DisplayName("compare(): should return equality if the list elements each are equal")
    public void compare_shouldReturnTrue_ForIdenticalLists_FilledList( ) {
        
        Set<String> set = new HashSet<String>();
        set.add( "e4 e5" );
        set.add( "e7 e8" );
        String separator = LineBundleMigration.getSetSeparator();
        String flattenedString = "e4 e5" + separator + "e7 e8";

        assertThat( LineBundleMigration.compare( flattenedString, set) ).as( explanation ).isTrue();
    }
    
    @Test
    @DisplayName("compare(): should return equality for empty parameters")
    public void compare_shouldReturnTrue_ForEmptyParameters( ) {
        
    	Set<String> set = new HashSet<String>();
        String flattenedString = "";

        assertThat( LineBundleMigration.compare( flattenedString, set ) ).as( explanation ).isTrue();
    }
    
    @Test
    @DisplayName("compare(): should return false for empty string but filled set")
    public void compare_shouldReturnFalse_ForEmptyStringButFilledSet( ) {
        
    	Set<String> set = new HashSet<String>();
        set.add( "e4 e5" );
        set.add( "e7 e8" );
        String flattenedString = "";

        assertThat( LineBundleMigration.compare( flattenedString, set ) ).as( explanation ).isFalse();
    }
    
    @Test
    @DisplayName("compare(): should return false for filled string but empty set")
    public void compare_shouldReturnTrue_ForFilledStringButEmptyList( ) {
        
    	Set<String> set = new HashSet<String>();
        String flattenedString = "e4 e5";

        assertThat( LineBundleMigration.compare( flattenedString, set ) ).as( explanation ).isFalse();
    }
    
    @Test
    @DisplayName("compare(): should return a difference if an element is missing within set")
    public void compare_shouldReturnFalse_IfAnyStringsAreMissingWithinSet( ) {
        
        Set<String> set = new HashSet<String>();
        set.add( "e1 e2" );
        set.add( "e7 e8" );
        String separator = LineBundleMigration.getSetSeparator();
        String flattenedString = "e1 e2 " + separator + "e4 e5" + separator + "e7 e8";

        assertThat( LineBundleMigration.compare( flattenedString, set) ).as( explanation ).isFalse();
    }
}

