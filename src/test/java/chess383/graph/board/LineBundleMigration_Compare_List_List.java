/*
 *  LineBundleMigration_Compare_List_List.java
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * <p>
 * The class LineBundleMigration_Compare_List_List implements an upper tester.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   August 2020
 *
 */
@DisplayName("the public static method boolean compare() for class LineBundleMigration with two parameters List<String> and List<String> is tested")
public class LineBundleMigration_Compare_List_List { 
    
	final String explanation = "structure should be similar, regarding order and elements";
	
    @Test
    @DisplayName("compare(): should return equality if the order and the list elements each are equal")
    public void compare_shouldReturnTrue_ForIdenticalLists_FilledList( ) {
        
        List<String> list = Arrays.asList( "e4 e5 e6" );

        assertThat( LineBundleMigration.compare( list, list ) ).as( explanation ).isTrue();
    }
    
    @Test
    @DisplayName("compare(): should return equality if the order and the list elements each are equal")
    public void compare_shouldReturnTrue_ForIdenticalLists_SpecialCaseListsAreNull( ) {
        
        List<String> list = null;

        assertThat( LineBundleMigration.compare( list, list ) ).as( explanation ).isTrue();
    }
    
    @Test
    @DisplayName("compare(): should return equality if the order and the list elements each are equal")
    public void compare_shouldReturnTrue_ForIdenticalLists_SpecialCaseListIsEmpty( ) {
        
        List<String> list = new ArrayList<String>();

        assertThat( list.isEmpty() ).as( "special case: it is a list but an empty list" ).isTrue();
        assertThat( LineBundleMigration.compare( list, list ) ).as( explanation ).isTrue();
    }
   
    @Test
    @DisplayName("compare(): should return equality if the order and the list elements each are equal")
    public void compare_shouldReturnTrue_ForLists_FilledList( ) {
        
        List<String> list = Arrays.asList( "e4 e5 e6" );

        assertThat( LineBundleMigration.compare( list, Arrays.asList( "e4 e5 e6" ) ) ).as( explanation ).isTrue();
    }
    
    @Test
    @DisplayName("compare(): should return a difference if first list is empty and the other not")
    public void compare_shouldReturnFalse_ForLists_SpecialCaseFirstListIsEmpty( ) {
        
        List<String> list = Arrays.asList( "e4 e5 e6" );;

        assertThat( LineBundleMigration.compare( new ArrayList<String>(), list ) ).as( explanation ).isFalse();
    }
    
    @Test
    @DisplayName("compare(): should return a difference if second list is empty and the other not")
    public void compare_shouldReturnFalse_ForLists_SpecialCaseSecondListIsEmpty( ) {
        
        List<String> list = Arrays.asList( "e4 e5 e6" );;

        assertThat( LineBundleMigration.compare( list, new ArrayList<String>() ) ).as( explanation ).isFalse();
    }
    
    @Test
    @DisplayName("compare(): should return a difference if first list is null and the other list not")
    public void compare_shouldReturnFalse_ForLists_SpecialCaseFirstListIsNULL( ) {
        
        List<String> list = Arrays.asList( "e4 e5 e6" );

        assertThat( LineBundleMigration.compare( (List<String>)null, list ) ).as( explanation ).isFalse();
    }
    
    @Test
    @DisplayName("compare(): should return a difference if first list is null and the other list not")
    public void compare_shouldReturnFalse_ForLists_SpecialCaseSecondListIsNULL( ) {
        
        List<String> list = Arrays.asList( "e4 e5 e6" );

        assertThat( LineBundleMigration.compare( list, (List<String>)null ) ).as( explanation ).isFalse();
    }
    
    @Test
    @DisplayName("compare(): should return a difference if lists differ")
    public void compare_shouldReturnFalse_ForListsIfBothAreDifferent( ) {
        
        List<String> firstList = Arrays.asList( "e4 e5 e6" );
        List<String> secondList = Arrays.asList( "e4 e6" );

        assertThat( LineBundleMigration.compare( firstList, secondList ) ).as( explanation ).isFalse();
    }
    
    @Test
    @DisplayName("compare(): should return a difference if a list is shorter")
    public void compare_shouldReturnFalse_ForListsIfOneListIsShorter( ) {
        
        List<String> firstList = Arrays.asList( "e4 e5 e6" );
        List<String> secondList = Arrays.asList( "e4 e5" );

        assertThat( LineBundleMigration.compare( firstList, secondList ) ).as( explanation ).isFalse();
    }
}

