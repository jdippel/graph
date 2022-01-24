/*
 *  ThreeDimensionalBoard_GetStaticBundle.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2021, 2022 Jörg Dippel
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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <p>
 * The class ThreeDimensionalBoard_GetStaticBundle implements an upper tester.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   January 2022
 *
 */
@DisplayName("the public method List<LineOfLocations> getStaticBundle() for class ThreeDimensionalBoard is tested")
public class ThreeDimensionalBoard_GetStaticBundle { 
    
    @Test
    @DisplayName("board contains lines")
    public void getStaticBundle_SizeIsGreaterThanZero( ) {

    	assertThat( ThreeDimensionalBoard.getStaticBundle().size() ).as( "board contains lines" ).isEqualTo( 216 );
    }
}

