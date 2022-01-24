/*
 *  DirectedFilesLine_HashCode.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2020 - 2022 Jörg Dippel
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
 * The class DirectedFilesLine_HashCode implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   January 2022
 *
 */
@DisplayName("the public method int hashCode( ) for class DirectedFilesLine is tested")
public class DirectedFilesLine_HashCode {
    
    private final Direction DIRECTION = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
    private final String LOCATIONS = "  b2  b3 b4    ";
    private final DirectedFilesLine LINE = DirectedFilesLine.createLine( LOCATIONS, DIRECTION );
    private final int HASH_CODE = LINE.hashCode();

    @Test
    @DisplayName("hashCode(): should be equal when identical instances of DirectedFilesLine are compared")
    public void identicalInstances( ) {

        assertThat( LINE.hashCode( ) )
                  .as( "hash code for identical instances should match" )
                  .isEqualTo( HASH_CODE );
    }

    @Test
    @DisplayName("hashCode(): should be equal when instances of DirectedFilesLine are compared")
    public void meaningfullyEquivalentInstances( ) {

        assertThat( DirectedFilesLine.createLine( LOCATIONS, DIRECTION ).hashCode( ) )
                  .as( "hash code for meaningfully equivalent instances should match" )
                  .isEqualTo( HASH_CODE );
    }
    
    @Test
    @DisplayName("hashCode(): should differ for unidirectional instances of DirectedFilesLine when locations are reversed")
    public void unidirectionalInstanceReversedShouldDiffer( ) {

        assertThat( DirectedFilesLine.createLine( LOCATIONS, Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK ) ).hashCode( ) )
                  .as( "hash code for meaningfully equivalent instances should match" )
                  .isNotEqualTo( DirectedFilesLine.createLine( LOCATIONS, Direction.createUnidirectionalDirection( ColorEnum.BLACK, ColorEnum.WHITE ) ).hashCode( ) );
    }
    
    @Test
    @DisplayName("hashCode(): avoid simple constant assignment")
    public void avoidSimpleConstantAssignement( ) {

        int lineLengthTwo =   DirectedFilesLine.createLine( "c2 c3", Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK ) ).hashCode();
        int lineLengthThree = DirectedFilesLine.createLine( "d4 d3 d2", Direction.createUnidirectionalDirection( ColorEnum.BLACK, ColorEnum.WHITE ) ).hashCode();
        int lineLengthFour =  DirectedFilesLine.createLine( "e7 f7 g7 h7", Direction.createBidirectionalDirection() ).hashCode();
        
        assertThat( lineLengthTwo != lineLengthThree && lineLengthThree != lineLengthFour && lineLengthTwo != lineLengthFour )
                  .as( "different lines should have different hash codes" )
                  .isTrue();
        assertThat( lineLengthTwo != 0 && lineLengthThree != 0 && lineLengthFour != 0 )
                  .as( "different lines should have different hash codes" )
                  .isTrue();
    }
}

