/*
 *  AdjacencyEnum_IsAdjacent.java
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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * <p>
 * The class AdjacencyEnum_IsAdjacent implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public method boolean isAdjacent() for enumeration AdjacencyEnum is tested")
public class AdjacencyEnum_IsAdjacent { 

    @Test
    @DisplayName("isAdjacent(): result should be false when adjacency is UNSPECIFIED")
    public void isAdjacent_shouldBeFalse_WhenAdjacencyIs_UNSPECIFIED( ) {

    	assertFalse( AdjacencyEnum.UNSPECIFIED.isAdjacent( ) );
    }
    
    @Test
    @DisplayName("isAdjacent(): result should be true when adjacency is BY_EDGE")
    public void isAdjacent_shouldBeTrue_WhenAdjacencyIs_BY_EDGE( ) {

    	assertTrue( AdjacencyEnum.BY_EDGE.isAdjacent( ) );
    }
    
    @Test
    @DisplayName("isAdjacent(): result should be true when adjacency is BY_POINT")
    public void isAdjacent_shouldBeTrue_WhenAdjacencyIs_BY_POINT( ) {

    	assertTrue( AdjacencyEnum.BY_POINT.isAdjacent( ) );
    }
}

