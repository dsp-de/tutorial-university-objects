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
package people;

import static org.junit.Assert.*;

import org.junit.Test;

public class A1X01_AddressExtraTest {

	// For experts only. For details see:
	// http://docs.oracle.com/javase/1.4.2/docs/api/java/lang/Object.html#hashCode%28%29
	@Test
	public void expertsKnowThatEqualObjectsHaveTheSameHashcode()
			throws Exception {

		Address address1 = new Address("Am Wichelshof 32", "53111", "Bonn");
		Address address2 = new Address("Am Jesuitenhof 1 + 3", "53117", "Bonn");
		Address address3 = new Address("Am Jesuitenhof 1 + 3", "53117", "Bonn");

		// Could be true by chance :-( :
		assertFalse(address1.hashCode() == address2.hashCode());

		assertTrue(address2.hashCode() == address3.hashCode());
	}
	/*
	 * Can you write some extra code to show that the changes you made to make
	 * the test succeed are necessary to use the Address class in a HashSet or a
	 * HashMap?
	 */

}
