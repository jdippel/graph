/*
 *  LineCollector.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2020, 2021 Jörg Dippel
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

/**
 * Collects lines for a bundle of lines.
 *
 * @author    Jörg Dippel
 * @version   February 2021
 *
 */
public class LineCollector {
   
    /** ---------  Attributes  -------------------------------- */
    
    private Set<List<String>> accumulator;
  
     /** ---------  Constructors  ------------------------------ */

    public LineCollector( ) {
        
        setAccumulator( );
    }
    
    /** ---------  Getter and Setter  ------------------------- */

    private void setAccumulator( )            { this.accumulator = new HashSet<List<String>>( 0 ); }
    public Set<List<String>> getAccumulator() { return this.accumulator; }
    
    /** ------------------------------------------------------- */
 
    // size must be at least of size 2, because one element is the origin and the other elements are possible targets
    public boolean add( List<String> filteredLine ) {
    	
        return ( filteredLine.size( ) > 1 ) && ( this.accumulator.add( filteredLine ) );
    }
}

