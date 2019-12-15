/*
 *  ColorEnum_IsOfSomeColor.java
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

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess383.ColorEnum;

/**
 * <p>
 * The class ColorEnum_IsOfSomeColor implements an upper tester
 * </p>
 *
 * @author    Jörg Dippel
 * @version   December 2019
 *
 */
@DisplayName("the public accessor methods boolean isOf...( ) for enum ColorEnum is tested")
public class ColorEnum_IsOfSomeColor { 
	
    @Test
    @DisplayName("isOfWhiteColor(): result should be true for given enum value WHITE")
    public void isOfWhiteColor_shouldBeTrue_ForEnum_WHITE( ) {

    	assertThat( ColorEnum.WHITE.isOfWhiteColor( ) ).as( "true for given enum value WHITE" ).isTrue();
    }
    
    @Test
    @DisplayName("isOfBlackColor(): result should be true for given enum value BLACK")
    public void isOfBlackColor_shouldBeTrue_ForEnum_BLACK( ) {

    	assertThat( ColorEnum.BLACK.isOfBlackColor( ) ).as( "true for given enum value BLACK" ).isTrue();
    }
    
    @Test
    @DisplayName("isOfRedColor(): result should be true for given enum value RED")
    public void isOfRedColor_shouldBeTrue_ForEnum_RED( ) {

    	assertThat( ColorEnum.RED.isOfRedColor( ) ).as( "true for given enum value RED" ).isTrue();
    }
    
    @Test
    @DisplayName("isOfWhiteColor(): result should be false for given enum value NONE")
    public void isOfWhiteColor_shouldBeFalse_ForEnum_NONE( ) {

    	assertThat( ColorEnum.NONE.isOfWhiteColor( ) ).as( "false for given enum value NONE" ).isFalse();
    }
    
    @Test
    @DisplayName("isOfWhiteColor(): result should be false for given enum value BLACK")
    public void isOfWhiteColor_shouldBeFalse_ForEnum_BLACK( ) {

    	assertThat( ColorEnum.BLACK.isOfWhiteColor( ) ).as( "false for given enum value BLACK" ).isFalse();
    }
    
    @Test
    @DisplayName("isOfWhiteColor(): result should be false for given enum value RED")
    public void isOfWhiteColor_shouldBeFalse_ForEnum_RED( ) {

    	assertThat( ColorEnum.RED.isOfWhiteColor( ) ).as( "false for given enum value RED" ).isFalse();
    }
    
    @Test
    @DisplayName("isOfBlackColor(): result should be false for given enum value NONE")
    public void isOfBlackColor_shouldBeFalse_ForEnum_NONE( ) {

    	assertThat( ColorEnum.NONE.isOfBlackColor( ) ).as( "false for given enum value NONE" ).isFalse();
    }
    
    @Test
    @DisplayName("isOfBlackColor(): result should be false for given enum value WHITE")
    public void isOfBlackColor_shouldBeFalse_ForEnum_WHITE( ) {

    	assertThat( ColorEnum.WHITE.isOfBlackColor( ) ).as( "false for given enum value WHITE" ).isFalse();
    }
    
    @Test
    @DisplayName("isOfBlackColor(): result should be false for given enum value RED")
    public void isOfBlackColor_shouldBeFalse_ForEnum_RED( ) {

    	assertThat( ColorEnum.RED.isOfBlackColor( ) ).as( "false for given enum value RED" ).isFalse();
    }
    
    @Test
    @DisplayName("isOfRedColor(): result should be false for given enum value NONE")
    public void isOfRedColor_shouldBeFalse_ForEnum_NONE( ) {

    	assertThat( ColorEnum.NONE.isOfRedColor( ) ).as( "false for given enum value NONE" ).isFalse();
    }
    
    @Test
    @DisplayName("isOfRedColor(): result should be false for given enum value WHITE")
    public void isOfRedColor_shouldBeFalse_ForEnum_WHITE( ) {

    	assertThat( ColorEnum.WHITE.isOfRedColor( ) ).as( "false for given enum value WHITE" ).isFalse();
    }
    
    @Test
    @DisplayName("isOfRedColor(): result should be false for given enum value BLACK")
    public void isOfRedColor_shouldBeFalse_ForEnum_BLACK( ) {

    	assertThat( ColorEnum.BLACK.isOfRedColor( ) ).as( "false for given enum value BLACK" ).isFalse();
    }
}

