/**
 * "University Objects" demonstrates OOP concepts for educational purposes.
 * Copyright (C) 2008-2013 Daniel Speicher and University of Bonn
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package numbers;

import static org.junit.Assert.*;
import static numbers.CollectorUtil.*;

import numbers.FastGrowingNumberGenerator;
import numbers.INumberGenerator;
import numbers.NumberGenerator;
import numbers.SuperstitionRespectingNumberGenerator;

import org.junit.Test;

public class A1T02_NumberGeneratorTest {
	
	@Test
	public void generatingNumbersIsEasy() throws Exception {
		INumberGenerator generator = new NumberGenerator();
		assertEquals(0, generator.nextNumber());
		assertEquals(1, generator.nextNumber());
		assertEquals(2, generator.nextNumber());
		generator.setNextNumber(144);
		assertEquals(144, generator.nextNumber());
		assertEquals(145, generator.nextNumber());
		assertEquals(146, generator.nextNumber());
	}
	
	@Test
	public void youCanGetBigNumbers() throws Exception {
		INumberGenerator generator = new FastGrowingNumberGenerator(27068, 17);
		assertEquals(27068, generator.nextNumber());
		assertEquals(27068 + 1*17, generator.nextNumber());
		assertEquals(27068 + 2*17, generator.nextNumber());
		assertEquals(27068 + 3*17, generator.nextNumber());
	}

	@Test
	public void superstitionCanBeRespected() throws Exception {
		INumberGenerator generator = new SuperstitionRespectingNumberGenerator();
		generator.setNextNumber(11);
		assertEquals(11, generator.nextNumber());
		assertEquals(12, generator.nextNumber());
		// 13 is avoided
		assertEquals(14, generator.nextNumber());
		assertEquals(15, generator.nextNumber());
	}

	@Test
	public void nowItsEasyToCollectDifferentNumbers() throws Exception{
		int[] numbers;
		
		numbers = collectSomeNumbers(5, new NumberGenerator());
		assertArrayEquals(new int[] {0, 1, 2, 3, 4}, numbers);
		
		numbers = collectSomeNumbers(3, new FastGrowingNumberGenerator(55, 11));
		assertArrayEquals(new int[] {55, 66, 77}, numbers);
		
		numbers = collectSomeNumbers(20, new SuperstitionRespectingNumberGenerator());
		assertEquals(20, numbers.length);
		assertEquals(10, numbers[10]);
		assertEquals(20, numbers[19]);
	}

}
