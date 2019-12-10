/*
 *  ColorEnum_ToString.java
 *
 *  chess383 is a collection of chess related utilities.
 *  Copyright (C) 2015-2019 Jörg Dippel
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

package chess383.colorenum;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ColorEnum;

/**
 * <p>
 * The class ColorEnum_ToString implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   October 2019
 *
 */
@DisplayName("the public methods String toString( ) for enum ColorEnum is tested")
public class ColorEnum_ToString { 
    
    @Test
    @DisplayName("toString(): result should be equal to defined description for enum WHITE")
    public void toString_shouldBeEqual_ForEnum_WHITE_ToTheDefinedDescription( ) {

    	assertEquals( "white", ColorEnum.WHITE.toString() );
    }
    
    @Test
    @DisplayName("toString(): result should be equal to defined description for enum BLACK")
    public void toString_shouldBeEqual_ForEnum_BLACK_ToTheDefinedDescription( ) {

    	assertEquals( "black", ColorEnum.BLACK.toString() );
    }

    @Test
    @DisplayName("toString(): result should be equal to defined description for enum RED")
    public void verifyTheCorrectReturnForTheToStringMethod( ) {

    	assertEquals( "red", ColorEnum.RED.toString() );
    }
    
    @Test
    @DisplayName("toString(): result should be equal to defined description for enum NONE")
    public void toString_shouldBeEqual_ForEnum_NONE_ToTheDefinedDescription( ) {

    	assertEquals( "no color", ColorEnum.NONE.toString() );
    }
    
    @Test
    @DisplayName("toString(): when comparing two different colors with the toString method then both results should be different for WHITE and BLACK")
    public void toString_shouldBeDifferent_ForEnum_WHITE_ToDefinedDescriptionForEnum_BLACK( ) {

    	assertNotEquals( ColorEnum.WHITE.toString(), ColorEnum.BLACK.toString() );
    }
    
    @Test
    @DisplayName("toString(): when comparing two different colors with the toString method then both results should be different for WHITE and RED")
    public void toString_shouldBeDifferent_ForEnum_WHITE_ToDefinedDescriptionForEnum_RED( ) {

    	assertNotEquals( ColorEnum.WHITE.toString(), ColorEnum.RED.toString() );
    }
    
    @Test
    @DisplayName("toString(): when comparing two different colors with the toString method then both results should be different for WHITE and NONE")
    public void toString_shouldBeDifferent_ForEnum_WHITE_ToDefinedDescriptionForEnum_NONE( ) {

    	assertNotEquals( ColorEnum.WHITE.toString(), ColorEnum.NONE.toString() );
    }
    
    @Test
    @DisplayName("toString(): when comparing two different colors with the toString method then both results should be different for BLACK and WHITE")
    public void toString_shouldBeDifferent_ForEnum_BLACK_ToDefinedDescriptionForEnum_WHITE( ) {

    	assertNotEquals( ColorEnum.BLACK.toString(), ColorEnum.WHITE.toString() );
    }
    
    @Test
    @DisplayName("toString(): when comparing two different colors with the toString method then both results should be different for BLACK and RED")
    public void toString_shouldBeDifferent_ForEnum_BLACK_ToDefinedDescriptionForEnum_RED( ) {

    	assertNotEquals( ColorEnum.BLACK.toString(), ColorEnum.RED.toString() );
    }
    
    @Test
    @DisplayName("toString(): when comparing two different colors with the toString method then both results should be different for BLACK and NONE")
    public void toString_shouldBeDifferent_ForEnum_BLACK_ToDefinedDescriptionForEnum_NONE( ) {

    	assertNotEquals( ColorEnum.BLACK.toString(), ColorEnum.NONE.toString() );
    }
    
    @Test
    @DisplayName("toString(): when comparing two different colors with the toString method then both results should be different for RED and WHITE")
    public void toString_shouldBeDifferent_ForEnum_RED_ToDefinedDescriptionForEnum_WHITE( ) {

    	assertNotEquals( ColorEnum.RED.toString(), ColorEnum.WHITE.toString() );
    }
    
    @Test
    @DisplayName("toString(): when comparing two different colors with the toString method then both results should be different for RED and BLACK")
    public void toString_shouldBeDifferent_ForEnum_RED_ToDefinedDescriptionForEnum_BLACK( ) {

    	assertNotEquals( ColorEnum.RED.toString(), ColorEnum.BLACK.toString() );
    }
    
    @Test
    @DisplayName("toString(): when comparing two different colors with the toString method then both results should be different for RED and NONE")
    public void toString_shouldBeDifferent_ForEnum_RED_ToDefinedDescriptionForEnum_NONE( ) {

    	assertNotEquals( ColorEnum.RED.toString(), ColorEnum.NONE.toString() );
    }
    
    @Test
    @DisplayName("toString(): when comparing two different colors with the toString method then both results should be different for NONE and WHITE")
    public void toString_shouldBeDifferent_ForEnum_NONE_ToDefinedDescriptionForEnum_WHITE( ) {

    	assertNotEquals( ColorEnum.NONE.toString(), ColorEnum.WHITE.toString() );
    }
    
    @Test
    @DisplayName("toString(): when comparing two different colors with the toString method then both results should be different for NONE and BLACK")
    public void toString_shouldBeDifferent_ForEnum_NONE_ToDefinedDescriptionForEnum_BLACK( ) {

    	assertNotEquals( ColorEnum.NONE.toString(), ColorEnum.BLACK.toString() );
    }
    
    @Test
    @DisplayName("toString(): when comparing two different colors with the toString method then both results should be different for NONE and RED")
    public void toString_shouldBeDifferent_ForEnum_NONE_ToDefinedDescriptionForEnum_RED( ) {

    	assertNotEquals( ColorEnum.NONE.toString(), ColorEnum.RED.toString() );
    }
}

