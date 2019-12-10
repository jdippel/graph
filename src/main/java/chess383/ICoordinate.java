/*
 *  ICoordinate.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2016 - 2018 Jörg Dippel
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

package chess383;

import java.util.List;
import java.util.Set;

import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.direction.Direction;

/**
 * Provides locations on a bundle of lines.
 * 
 * A line is an ordered list of names.
 * 
 * A line is attributed and with attributes you can select a subset of all defined lines.
 * One attribute is the direction as directed in the terms of a vector. Figuratively you can take the direction as a
 * pawn move from one side (may be white) to the last rank (that is on the other, the black side). This means direction,
 * because pawns cannot move backwards.
 * Another attribute is the connection between names. On a standard chess board the locations are squares that are
 * arranged in a grid - for this example squares are neighbors by an edge or by a corner. This is the original meaning
 * of adjacency but now it is only an attribute to cluster the lines in disjunctive sets.
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
public interface ICoordinate {
    
    /**
     * Given a node as a location (name) and also given a set of lines 
     * then a set of lines is returned which contains the location each.
     * The given set of lines is the definition of the board (as a metaphor).
     * 
     * @param location is the name of a location
     * 
     * @return all lines that contain the given location
     */
    public Set<List<String>> getLineBundles( String location );
    
    /**
     * Given a node as a location (name) and also given a set of lines 
     * then a set of lines is returned which contains the location each and each line fulfills a given direction condition.
     * The given set of lines is the definition of the board (as a metaphor).
     * 
     * @param location is the name of a location
     * @param orientation is the order specified
     * 
     * @return all lines that contain the passed name of a location with named conditions
     */
    public Set<List<String>> getLineBundles( String location, Direction orientation );
    
    /**
     * Given a node as a location (name) and also given a set of lines 
     * then a set of lines is returned which contains the location each and each line fulfills a given direction condition
     * and also each line fulfills a given condition for adjacency.
     * The given set of lines is the definition of the board (as a metaphor).
     * 
     * @param location is the name of a location
     * @param orientation is the order specified
     * @param adjancency classifies the lines
     * 
     * @return all lines that contain the passed name of a location with named conditions
     */
    public Set<List<String>> getLineBundles( String location, Direction orientation, AdjacencyEnum adjancency );
    
    /**
     * There is a given set of lines with a finite set of names (locations).
     * 
     * @return the set of all defined names (locations).
     */
    public Set<String> getAllLocations( ) ;
}

