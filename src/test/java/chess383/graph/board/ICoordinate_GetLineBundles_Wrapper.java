/*
 *  ICoordinate_GetLineBundles_Wrapper.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2017 - 2019 Jörg Dippel
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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import chess383.ICoordinate;
import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.direction.Direction;

/**
 * <p>
 * The class ICoordinate_GetLineBundles_Wrapper provides a verifying method.
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
public class ICoordinate_GetLineBundles_Wrapper { 
    
    private static final ArrayList<String> ARRAY_LIST = new ArrayList<String>();
    protected final static List<String>  EMPTY_STRING_LIST = ARRAY_LIST;
    
    protected String describeOnError( String origin ) {
        return String.format( "bundled lines do not match for %s", origin );
    }
    
    protected boolean testOfArguments( ICoordinate board, String origin, Direction direction, AdjacencyEnum adjacency, List<String> expectedResultList) {
      
        return compareLists( board.getLineBundles( origin, direction, adjacency ), expectedResultList );
    }
    
    protected boolean compareLists( Set<List<String>> receivedSet, List<String> expectedList) {
        
        if( receivedSet.isEmpty() && ( expectedList.isEmpty() ) ) {
            return( true );
        }
        if( receivedSet.size() != expectedList.size() ) {
            return( false );
        }
        
        boolean result = true;
        for( String expectedString : expectedList ) {
            result = false;
            for ( String receivedString : LineBundleMigration.flatten( receivedSet ) ) {
                if ( receivedString.startsWith( expectedString ) ) {
                    result = true;
                    break;
                }
            }
            if ( result == false ) break;
        }
        return result;
    }
}

