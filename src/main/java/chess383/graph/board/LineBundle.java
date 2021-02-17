/*
 *  LineBundle.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2015-2021 Jörg Dippel
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import chess383.ColorEnum;
import chess383.ICoordinate;
import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.direction.Direction;
import chess383.graph.line.DirectedDiagonalLine;
import chess383.graph.line.DirectedFilesLine;
import chess383.graph.line.KnightsLine;
import chess383.graph.line.LineOfLocations;
import chess383.graph.line.UndirectedRowsLine;

/**
 * Provides locations on a bundle of lines.
 * A line is an ordered list of locations (names).
 * A bundle of lines through a given location is a set of lines which contain the location each.
 *
 * @author    Jörg Dippel
 * @version   February 2021
 *
 */
public abstract class LineBundle implements ICoordinate {
   
    /** ---------  Attributes  -------------------------------- */
    
    // List<LineOfLocations> bundle; 
  
    /** ---------  Getter and Setter  ------------------------- */

	abstract List<LineOfLocations> getBundle( );
    
    /** ------------------------------------------------------- */
    
    LineOfLocations createRankLine( String locations ) {
        
        return( UndirectedRowsLine.createLine( locations ) );
    }
    
    LineOfLocations createFileLine( String locations, Direction direction ) {
        
        return( DirectedFilesLine.createLine( direction, locations ) );
    }
    
    LineOfLocations createFileLine( String locations ) {
        
        final Direction direction = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        return( createFileLine( locations, direction ) );
    }
    
    LineOfLocations createDiagonalLine( String locations, Direction direction ) {
        
        return( DirectedDiagonalLine.createLine( direction, locations ) );
    }
    
    LineOfLocations createDiagonalLine( String locations ) {
        
        final Direction direction = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        return( createDiagonalLine( locations, direction ) );
    }

    LineOfLocations createKnightLine( String value ) {
    
        return( KnightsLine.createLine( value ) );
    }
    
    private List<String> convertStringToListOfStrings( String list ) {

        return LineBundleMigration.convertToList(list);
    }
    
    /** ------------------------------------------------------- */
    
    public Set<List<String>> getLineBundles( String location ) {
        
        Set<List<String>> result = new HashSet<List<String>>( );
        
        List<LineOfLocations> lineBundles = getBundle( );
        for( LineOfLocations line : lineBundles ) {
            if( line.contains( location ) ) {
                
                result.add( convertStringToListOfStrings( line.getLocations( ) ) );
            }
        }
    
        return( result );
    }
        
    public Set<List<String>> getLineBundles( String location, Direction orientation ) {

        if( orientation == null ) return( getLineBundles( location ) );
        
        LineCollector result = new LineCollector();
        List<LineOfLocations> lineBundles = getBundle( );
        for( LineOfLocations line : lineBundles ) {
            if( line.contains( location ) ) {
            
                 if( !orientation.isDirected() && !line.getDirection().isDirected()  ) {
                     result.add( LineBundleMigration.extractListForGivenDirection( line.getLocations( ), location ) );
                     result.add( LineBundleMigration.extractListForReversedDirection( line.getLocations( ), location ) );
                 }
                 else {
                     if( line.getDirection( ).equals( orientation ) ) {
                         result.add( LineBundleMigration.extractListForGivenDirection( line.getLocations( ), location ) );
                     }
                     else if( line.getDirection( ).equals( Direction.createReversedDirection( orientation ) ) ) {
                         result.add( LineBundleMigration.extractListForReversedDirection( line.getLocations( ), location ) );
                     }
                 }
            }
        }
    
        return( result.getAccumulator() );
    }
    
    public Set<List<String>> getLineBundles( String location, Direction orientation, AdjacencyEnum adjacency ) {

        if( adjacency == null ) return( getLineBundles( location, orientation ) );

        LineCollector result = new LineCollector();        
        List<LineOfLocations> lineBundles = getBundle( );
        for( LineOfLocations line : lineBundles ) {
            if( line.contains( location ) && line.matchesAdjacency( adjacency ) ) {
                
                if( orientation == null || ( !orientation.isDirected() && !line.getDirection().isDirected() )  ) {
                    
                    result.add( LineBundleMigration.extractListForGivenDirection( line.getLocations( ), location ) );
                    result.add( LineBundleMigration.extractListForReversedDirection( line.getLocations( ), location ) );
                }
                else {
                    if( line.getDirection( ).equals( orientation ) ) {
                        result.add( LineBundleMigration.extractListForGivenDirection( line.getLocations( ), location ) );
                    }
                    else if( line.getDirection( ).equals( Direction.createReversedDirection( orientation ) ) ) {
                        result.add( LineBundleMigration.extractListForReversedDirection( line.getLocations( ), location ) );
                    }
                }
            }   
        }
    
        return( result.getAccumulator() );
    }

    public Set<String> getAllLocations() {
        
         Set<String> result = new HashSet<String>( );
            
         List<LineOfLocations> lineBundles = getBundle( );
         for( LineOfLocations line : lineBundles ) {
              String currentLine = line.getLocations( );
              String[] tokens = currentLine.split( "\\s+" );
              for( String location : tokens ) {
                  if( location.length( ) > 0 ) {
                      result.add( location );
                  }
              }
         }
            
         return( result );
    }
}

