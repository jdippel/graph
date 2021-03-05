/*
 *  KnightsLine_HashCode.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2020, 2021 Jörg Dippel
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

/**
 * <p>
 * The class KnightsLine_HashCode implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   February 2021
 *
 */
@DisplayName("the public method int hashCode( ) for class KnightsLine is tested")
public class KnightsLine_HashCode {

    final String LOCATIONS = "  c3 d1 e3 f1    ";
    final KnightsLine LINE = KnightsLine.createLine( LOCATIONS );
    final int HASH_CODE = LINE.hashCode();

    @Test
    @DisplayName("hashCode(): should be equal when identical instances of KnightsLine are compared")
    public void identicalInstances( ) {

        assertThat( LINE.hashCode( ) )
                  .as( "hash code for identical instances should match" )
                  .isEqualTo( HASH_CODE );
    }

    @Test
    @DisplayName("hashCode(): should be equal when instances of KnightsLine are compared")
    public void meaningfullyEquivalentInstances( ) {

        assertThat( KnightsLine.createLine( LOCATIONS ).hashCode( ) )
                  .as( "hash code for meaningfully equivalent instances should match" )
                  .isEqualTo( HASH_CODE );
    }
    
    @Test
    @DisplayName("hashCode(): avoid simple constant assignment")
    public void avoidSimpleConstantAssignement( ) {

        int lineLengthTwo =   KnightsLine.createLine( "h8 g6" ).hashCode();
        int lineLengthThree = KnightsLine.createLine( "d3 e5 f7" ).hashCode();
        int lineLengthFour =  KnightsLine.createLine( "c3 d1 e3 f1" ).hashCode();
        
        assertThat( lineLengthTwo != lineLengthThree || lineLengthThree != lineLengthFour || lineLengthTwo != lineLengthFour )
                  .as( "different lines should have different hash codes" )
                  .isTrue();
        assertThat( lineLengthTwo != 0 || lineLengthThree != 0 || lineLengthFour != 0 )
                  .as( "different lines should have different hash codes" )
                  .isTrue();
    }
}

