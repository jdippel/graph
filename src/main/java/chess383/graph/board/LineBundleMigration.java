/*
 *  LineBundleMigration.java
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Provides static migration or conversion methods between types.
 *
 * @author    Jörg Dippel
 * @version   March 2021
 */
public class LineBundleMigration {

    static final String SET_SEPARATOR = " , ";
    public static String getSetSeparator() { return SET_SEPARATOR; }
    
    public static List<String> convertToList( String list ) {

        String[] tokens = list.split( "\\s+", 0 );
        List<String> result = new ArrayList<String>( tokens.length );
        
        for( String token : tokens ) {
            result.add( token );
        }
        return( result );
    }
    
    public static List<String> extractListForGivenDirection( String list, String location ) {
        
        List<String> result = new ArrayList<String>( );
        
        String[] tokens = list.split( "\\s+" );
        int cursor = 0;
        while( cursor < tokens.length ) {
        
            if( location.compareTo( tokens[ cursor ] ) == 0 ) break;
            cursor++;
        }
       
        while( cursor < tokens.length ) {
            result.add( tokens[ cursor ] );
            cursor++;
        }
        
        return( result );
    }
    
    public static List<String> extractListForReversedDirection( String list, String location ) {
      
        String[] tokens = list.split( "\\s+" );
        int cursor = 0;
        while( cursor < tokens.length ) {
        
            if( location.compareTo( tokens[ cursor ] ) == 0 ) break;
            cursor++;
        }
        
        if( cursor == tokens.length ) {
            return( Collections.emptyList() );
        }
        else {
            List<String> result = new ArrayList<String>( );
            while( cursor >= 0 ) {
                result.add( tokens[ cursor ] );
                cursor--;
            }
            
            return( result );
        }
    }
   
    public static Set<String> flatten( Set<List<String>> bundle ) {
        
        Set<String> result = new HashSet<String>( );
        
        for( List<String> line : bundle ) {
            
            String[] strings = line.toArray( new String[0] );
            result.add( String.join( " ", strings ) );         
        }
    
        return( result );
    }
    
    public static boolean compare( String bulldozedString, Set<String> bundle ) {
        
        String[] tokens = bulldozedString.split( getSetSeparator() );
        
        if( bulldozedString.trim().length() == 0 && bundle.isEmpty() ) return true;
        if ( bundle.isEmpty() ) return false;
        if ( bulldozedString.trim().length() == 0 ) return( false );
        
        int cursor = 0;
        while ( cursor < tokens.length ) {
            if ( bundle.contains( tokens[ cursor ] ) ) {
                cursor++;
            }
            else {
                return false;
            }
        }
        return true;
    }
    
    public static boolean compare( String bulldozedString, String bulldozedBundle ) {
        
        if ( bulldozedString.trim().length() == 0 && bulldozedBundle.trim().length() == 0 ) return true;
        if ( bulldozedString.trim().length() == 0 ) return( false );
        if ( bulldozedBundle.trim().length() == 0 ) return( false );
        
        String[] stringTokens = bulldozedString.split( getSetSeparator() );
        String[] bundleTokens = bulldozedBundle.split( getSetSeparator() );
        
        if ( stringTokens.length != bundleTokens.length ) return false;
        
        int stringCursor = 0;
        while ( stringCursor < stringTokens.length ) {
            int bundleCursor = 0;
            while ( bundleCursor < bundleTokens.length ) {
                if ( stringTokens[ stringCursor ].equals( bundleTokens[ bundleCursor ] ) ) {
                    stringCursor++;
                    break;
                }
                else {
                    bundleCursor++;
                }
            }
            if ( bundleCursor == bundleTokens.length ) return( false );
        }
        return true;
    }
    
    public static boolean compare( String simpleString, List<String> listOfStrings ) {
        
        return compare( simpleString, listOfStrings, simpleString.contains( "," ) ? getSetSeparator() : "\\s+" ); 
    }
    
    public static boolean compare( String simpleString, List<String> listOfStrings, String separator ) {
        
        if ( simpleString.trim().length() == 0 && listOfStrings.isEmpty() ) return true;
        if ( simpleString.trim().length() == 0 ) return false;
        if ( listOfStrings.isEmpty() ) return false;
        
        String[] bulldozedTokens = simpleString.split( separator, 0 );
        Iterator<String> iterator = listOfStrings.iterator();
        while ( iterator.hasNext() ) {
            String stringWithinList = iterator.next();
            int cursor = 0;
            while ( cursor < bulldozedTokens.length ) {
                if ( stringWithinList.equals( bulldozedTokens[ cursor ] ) ) {
                    break;
                }
                else {
                    cursor++;
                }
            }
            if ( cursor == bulldozedTokens.length ) return( false );
        }
        return true;
    }
    
    public static boolean compare( List<String> firstListOfStrings, List<String> secondListOfStrings ) {
        
        if ( firstListOfStrings == null && secondListOfStrings == null ) return true;
        if ( firstListOfStrings == null ) return false;
        if ( secondListOfStrings == null ) return false;
        if ( firstListOfStrings.isEmpty() && secondListOfStrings.isEmpty() ) return true;       
        if ( firstListOfStrings.isEmpty() ) return false;
        if ( secondListOfStrings.isEmpty() ) return false;
        if ( firstListOfStrings.size() != secondListOfStrings.size() ) return false;
        
        Iterator<String> firstIterator = firstListOfStrings.iterator();
        Iterator<String> secondIterator = secondListOfStrings.iterator();
        while ( firstIterator.hasNext() && secondIterator.hasNext() ) {
            if ( firstIterator.next().compareTo( secondIterator.next() ) != 0 ) return false;
        }
        return true;
    }
}

