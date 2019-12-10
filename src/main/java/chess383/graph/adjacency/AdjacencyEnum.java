/*
 *  AdjacencyEnum.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2018 Jörg Dippel
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

/**
 * Provides an attribute for adjacency.
 *
 * @author    Jörg Dippel
 * @version   December 2018
 *
 */
public enum AdjacencyEnum {

    UNSPECIFIED,
    
    BY_EDGE                { @Override public String toString( ) { return( "adjacency by edge" ); }
                             @Override public boolean isAdjacent( ) { return( true ); } 
                             @Override public boolean isAdjacentByEdge( ) { return( true ); } },
    
    BY_POINT               { @Override public String toString( ) { return( "adjacency by point" ); } 
                             @Override public boolean isAdjacent( ) { return( true ); } 
                             @Override public boolean isAdjacentByPoint( ) { return( true ); } };
    
    
    public String  toString( )            { return( "unspecified adjacency" ); }
    public boolean isAdjacent( )          { return( false ); }
    public boolean isAdjacentByEdge( )    { return( false ); }
    public boolean isAdjacentByPoint( )   { return( false ); }
}
