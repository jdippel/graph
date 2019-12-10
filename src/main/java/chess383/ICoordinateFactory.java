/*
 *  ICoordinateFactory.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2019 Jörg Dippel
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

import chess383.graph.board.StandardBoard;
import chess383.graph.board.ThreeDimensionalBoard;
import chess383.graph.board.TripleBoardByRectangles;

/**
 * Provides locations on a bundle of lines.
 * 
 * A line is a ordered list of names.
 *
 * @author    Jörg Dippel
 * @version   January 2019
 *
 */
public enum ICoordinateFactory {
    
	STANDARD          { public ICoordinate createInstance( ) { return new StandardBoard( ); } },
	THREE_DIMENSIONAL { public ICoordinate createInstance( ) { return new ThreeDimensionalBoard( ); } },
	TRIPLE            { public ICoordinate createInstance( ) { return new TripleBoardByRectangles( ); } };
	
	
	private ICoordinate board = ( ICoordinate ) null;
	
	public abstract ICoordinate createInstance( );
	
	public ICoordinate get( ) {
		
		if( board == ( ICoordinate ) null ) {
			board = createInstance( );
		}
		return board;
	}
}

