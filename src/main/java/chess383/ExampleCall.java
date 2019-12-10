/*
 *  ExampleCall.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2010-2016 Jörg Dippel
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

import chess383.graph.adjacency.AdjacencyEnum;
import chess383.graph.direction.Direction;

/*
 * Example for Usage:
 * 
 * ICoordinate is an enumeration defining a chess board.
 * Via the interface ICoordinate you can get the locations (squares) of the board. 
 */
public class ExampleCall {

	public static void main(String[] args) {
	
		ICoordinate board = ICoordinateFactory.STANDARD.get( );
		final String ORIGIN_LOCATION = "b2";
		
		System.out.println( "Alle: " + board.getLineBundles( ORIGIN_LOCATION ) );
		System.out.println( "Bishops: " + board.getLineBundles( ORIGIN_LOCATION, Direction.createUnidirectionalDirection( ColorEnum.WHITE, ColorEnum.BLACK ), AdjacencyEnum.BY_POINT ) );
	}

}
