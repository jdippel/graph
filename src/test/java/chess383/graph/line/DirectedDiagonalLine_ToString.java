/*
 *  DirectedDiagonalLine_ToString.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2020 Jörg Dippel
 *
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

package chess383.graph.line;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ColorEnum;
import chess383.graph.direction.Direction;


/**
 * <p>
 * The class DirectedDiagonalLine_ToString implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   February 2020
 *
 */
@DisplayName("the public method String toString( ) for class DirectedDiagonalLine is tested")
public class DirectedDiagonalLine_ToString {

    final Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.BLACK, ColorEnum.WHITE );
    final String LOCATIONS = "  e5 d4    c3 b2   ";
    final String EXPECTED_STRING_DESCRIPTION = "DirectedDiagonalLine : " + DIRECTION.toString() + " : " + "e5 d4 c3 b2";
    
    @Test
    @DisplayName("toString(): should be equal for given definition of DirectedDiagonalLine example")
    public void sameStringDescription( ) {

        DirectedDiagonalLine discreteLine = DirectedDiagonalLine.createLine( DIRECTION, LOCATIONS );
        
        assertThat( discreteLine.toString( ) )
                  .as( "strings of toString() method must be formatted by trimming" )
                  .contains( EXPECTED_STRING_DESCRIPTION );
    }
}

