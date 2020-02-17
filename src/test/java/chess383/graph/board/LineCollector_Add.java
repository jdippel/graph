/*
 *  LineCollector_Add.java
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

package chess383.graph.board;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <p>
 * The class LineCollector_Add implements an upper tester.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   February 2020
 *
 */
@DisplayName("the public method boolean add() for class LineCollector is tested")
public class LineCollector_Add { 
    
    @Test
    @DisplayName("empty LineCollector class")
    public void createdClassShouldNotHoldAnyElements( ) {
        
        LineCollector akkumulator = new LineCollector();
        
        assertThat( akkumulator.getAccumulator() ).as( "Collection should be empty" ).isEmpty();
    }
    
    @Test
    @DisplayName("add: inserted element should also be in the collection")
    public void add_insertedElementShouldBeInTheCollection() {
        
        final List<String> ELEMENT = Arrays.asList( "apple", "banana" );
        
        LineCollector akkumulator = new LineCollector();
        akkumulator.add( ELEMENT );
        
        assertThat( akkumulator.getAccumulator().contains( ELEMENT ) ).as( "collection should hold only the named element" ).isTrue();
    }
    
    @Test
    @DisplayName("add: inserted element could also be retieved")
    public void add_insertedElementCouldAlsoBeRetrieved() {
        
        final List<String> ELEMENT = Arrays.asList( "apple", "banana" );
        
        LineCollector akkumulator = new LineCollector();
        akkumulator.add( ELEMENT );
        
        assertThat( akkumulator.getAccumulator().remove( ELEMENT ) ).as( "an added element could also be removed" ).isTrue();
        assertThat( akkumulator.getAccumulator() ).as( "removing all elements then the collection is empty" ).isEmpty();
    }
    
    
    @Test
    @DisplayName("add: collection is a set")
    public void add_collectionnIsASet() {
        
        final List<String> ELEMENT = Arrays.asList( "apple", "banana" );
        
        LineCollector akkumulator = new LineCollector();
        akkumulator.add( ELEMENT );
        
        assertThat( akkumulator.getAccumulator().add( ELEMENT ) ).as( "an already added element could not be added again" ).isFalse();
        assertThat( akkumulator.getAccumulator().remove( ELEMENT ) ).as( "an added element could also be removed" ).isTrue();
        assertThat( akkumulator.getAccumulator() ).as( "removing all elements then the collection is empty" ).isEmpty();
    }
}

