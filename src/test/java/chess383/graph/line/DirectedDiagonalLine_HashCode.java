/*
 *  DirectedDiagonalLine_HashCode.java
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
 * The class DirectedDiagonalLine_HashCode implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   February 2020
 *
 */
@DisplayName("the public method int hashCode( ) for class DirectedDiagonalLine is tested")
public class DirectedDiagonalLine_HashCode {

    final String LOCATIONS = "  e5 d4    c3 b2   ";
    final Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.BLACK, ColorEnum.WHITE );
    final DirectedDiagonalLine LINE = DirectedDiagonalLine.createLine( DIRECTION, LOCATIONS );
    final int HASH_CODE = LINE.hashCode();

    @Test
    @DisplayName("hashCode(): should be equal when identical instances of DirectedDiagonalLine are compared")
    public void identicalInstances( ) {

        assertThat( LINE.hashCode( ) )
                  .as( "hash code for identical instances should match" )
                  .isEqualTo( HASH_CODE );
    }

    @Test
    @DisplayName("hashCode(): should be equal when instances of DirectedDiagonalLine are compared")
    public void meaningfullyEquivalentInstances( ) {

        assertThat( DirectedDiagonalLine.createLine( DIRECTION, LOCATIONS ).hashCode( ) )
                  .as( "hash code for meaningfully equivalent instances should match" )
                  .isEqualTo( HASH_CODE );
    }
    
    @Test
    @DisplayName("hashCode(): should differ for unidirectional instances of DirectedDiagonalLine when locations are reversed")
    public void unidirectionalInstanceReversedShouldDiffer( ) {

        assertThat( DirectedFilesLine.createLine( Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK ), LOCATIONS ).hashCode( ) )
                  .as( "hash code for meaningfully equivalent instances should match" )
                  .isNotEqualTo( DirectedFilesLine.createLine( DIRECTION, LOCATIONS ).hashCode( ) );
    }
}

