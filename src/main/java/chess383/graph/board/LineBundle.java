/*
 *  LineBundle.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2015-2018 Jörg Dippel
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
import chess383.graph.coordinate.LineOfLocations;
import chess383.graph.direction.Direction;

/**
 * Provides locations on a bundle of lines.
 * A line is an ordered list of locations (names).
 * A bundle of lines through a given location is a set of lines which contain the location each.
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
public abstract class LineBundle implements ICoordinate {
   
    /** ---------  Attributes  -------------------------------- */
    
    List<LineOfLocations> bundle; 
  
    /** ---------  Getter and Setter  ------------------------- */

    List<LineOfLocations> getBundle( )   { return( this.bundle ); }
    
    /** ------------------------------------------------------- */
    
    LineOfLocations createRankLine( String locations ) {
        
        final Direction direction = Direction.createBidirectionalDirection( );
        return( LineOfLocations.createLine( AdjacencyEnum.BY_EDGE, direction, locations ) );
    }
    
    LineOfLocations createFileLine( String locations, Direction direction ) {
        
        return( LineOfLocations.createLine( AdjacencyEnum.BY_EDGE, direction, locations ) );
    }
    
    LineOfLocations createFileLine( String locations ) {
        
        final Direction direction = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        return( createFileLine( locations, direction ) );
    }
    
    LineOfLocations createDiagonalLine( String locations, Direction direction ) {
        
        return( LineOfLocations.createLine( AdjacencyEnum.BY_POINT, direction, locations ) );
    }
    
    LineOfLocations createDiagonalLine( String locations ) {
        
        final Direction direction = Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK );
        return( createDiagonalLine( locations, direction ) );
    }

    LineOfLocations createKnightLine( String value ) {
    
        final Direction UNSPECIFIED = Direction.createBidirectionalDirection( );
        return( LineOfLocations.createLine( AdjacencyEnum.UNSPECIFIED, UNSPECIFIED, value ) );
    }
    
    private List<String> convertStringToListOfStrings( String list ) {

        return LineBundleMigration.convertToList(list);
    }
    
    /** ------------------------------------------------------- */
    
    public Set<List<String>> getLineBundles( String location ) {
        
        Set<List<String>> result = new HashSet<>( );
        
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
        
        Set<List<String>> result = new HashSet<>( );
       
        List<LineOfLocations> lineBundles = getBundle( );
        for( LineOfLocations line : lineBundles ) {
            if( line.contains( location ) ) {
            
                 List<String> filteredLine;
                 if( !orientation.isDirected() && !line.getDirection().isDirected()  ) {
                     
                     filteredLine = LineBundleMigration.extractListForGivenDirection( line.getLocations( ), location );
                     if( filteredLine.size( ) > 1 ) {
                         result.add( filteredLine );
                     }
                     
                     filteredLine = LineBundleMigration.extractListForReversedDirection( line.getLocations( ), location );
                     if( filteredLine.size( ) > 1 ) {
                         result.add( filteredLine );
                     }
                 }
                 else {
                     if( line.getDirection( ).equals( orientation ) ) {
                         filteredLine = LineBundleMigration.extractListForGivenDirection( line.getLocations( ), location );
                         if( filteredLine.size( ) > 1 ) {
                             result.add( filteredLine );
                         }
                     }
                     else if( line.getDirection( ).equals( Direction.createReversedDirection( orientation ) ) ) {
                         filteredLine = LineBundleMigration.extractListForReversedDirection( line.getLocations( ), location );
                         if( filteredLine.size( ) > 1 ) {
                             result.add( filteredLine );
                         }
                     }
                 }
            }
        }
    
        return( result );
    }
    
    public Set<List<String>> getLineBundles( String location, Direction orientation, AdjacencyEnum adjacency ) {

        if( adjacency == null ) return( getLineBundles( location, orientation ) );

        Set<List<String>> result = new HashSet<>( );
        
        List<LineOfLocations> lineBundles = getBundle( );
        for( LineOfLocations line : lineBundles ) {
            if( line.contains( location ) && line.getAdjacency().equals( adjacency ) ) {
                
                List<String> filteredLine;
                if( orientation == null || ( !orientation.isDirected() && !line.getDirection().isDirected() )  ) {
                    
                    filteredLine = LineBundleMigration.extractListForGivenDirection( line.getLocations( ), location );
                    if( filteredLine.size( ) > 1 ) {
                        result.add( filteredLine );
                    }
                    
                    filteredLine = LineBundleMigration.extractListForReversedDirection( line.getLocations( ), location );
                    if( filteredLine.size( ) > 1 ) {
                        result.add( filteredLine );
                    }
                }
                else {
                    if( line.getDirection( ).equals( orientation ) ) {
                        filteredLine = LineBundleMigration.extractListForGivenDirection( line.getLocations( ), location );
                        if( filteredLine.size( ) > 1 ) {
                            result.add( filteredLine );
                        }
                    }
                    else if( line.getDirection( ).equals( Direction.createReversedDirection( orientation ) ) ) {
                        filteredLine = LineBundleMigration.extractListForReversedDirection( line.getLocations( ), location );
                        if( filteredLine.size( ) > 1 ) {
                            result.add( filteredLine );
                        }
                    }
                }
            }   
        }
    
        return( result );
    }

    public Set<String> getAllLocations() {
        
         Set<String> result = new HashSet<>( );
            
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

