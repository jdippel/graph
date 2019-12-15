/*
 *  AdjacencyEnum_ToString.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2018, 2019 Jörg Dippel
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

package chess383.graph.adjacency;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <p>
 * The class AdjacencyEnum_ToString implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method String toString() for enumeration AdjacencyEnum is tested")
public class AdjacencyEnum_ToString { 

	final String DESCRIPTION = "toString() result should match definition";
	
    @Test
    @DisplayName("ToString(): result should be equal to given definition of enumeration value for USPECIFIED")
    public void ToString_shouldBeEqual_ForGivenDefinition_USPECIFIED( ) {

    	assertThat( AdjacencyEnum.UNSPECIFIED.toString() ).as( DESCRIPTION ).isEqualTo( "unspecified adjacency" );
    }
    
    @Test
    @DisplayName("ToString(): result should be equal to given definition of enumeration value for BY_EDGE")
    public void ToString_shouldBeEqual_ForGivenDefinition_BY_EDGE( ) {

    	assertThat( AdjacencyEnum.BY_EDGE.toString() ).as( DESCRIPTION ).isEqualTo( "adjacency by edge" );
    }
    
    @Test
    @DisplayName("ToString(): result should be equal to given definition of enumeration value for BY_POINT")
    public void ToString_shouldBeEqual_ForGivenDefinition_BY_POINT( ) {

    	assertThat( AdjacencyEnum.BY_POINT.toString() ).as( DESCRIPTION ).isEqualTo( "adjacency by point" );
    }
}

