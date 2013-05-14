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

public class A1T01_AddressTest {

	/*
	 * Run this test e.g. by pressing (Alt+Shift+X) and then (T)! It will tell
	 * you that "personsAreDifferent()" and "stringsMightBeEqual()" are correct.
	 * Explain why this is the case.
	 * 
	 * This means explain why the following assertions are FALSE:
	 * 
	 *   person1 == person2 
	 *   person1.equals(person2) 
	 *   hello1 == hello2
	 * 
	 * ... and why still the following assertions is TRUE:
	 * 
	 *   hello1.equals(hello2)
	 * 
	 * Then turn to "addressesAreLikeStrings()" below.
	 */

	@Test
	public void personsAreDifferent() throws Exception {
		Person person1 = new Person("John Doe");
		Person person2 = new Person("John Doe");
		assertFalse(person1 == person2);
		assertFalse(person1.equals(person2));
	}

	@Test
	public void stringsMightBeEqual() throws Exception {
		String hello1 = new String("Hello!");
		String hello2 = new String("Hello!");
		assertFalse(hello1 == hello2);
		assertTrue(hello1.equals(hello2));
	}

	/*
	 * As you have run this Test, you have seen "addressesAreLikeStrings()"
	 * failing. But we really think, that addresses should be like strings!
	 * Change the class Address (and not this Test!), so that different objects
	 * of class Address are equal, if all elements of the address are equal.
	 */
	@Test
	public void addressesAreLikeStrings() throws Exception {
		Address address1 = new Address("Am Wichelshof 32", "53111", "Bonn");
		Address address2 = new Address("Am Jesuitenhof 1 + 3", "53117", "Bonn");
		Address address3 = new Address("Am Jesuitenhof 1 + 3", "53117", "Bonn");
		assertFalse(address1 == address2);
		assertFalse(address2 == address3);
		assertFalse(address1.equals(address2));
		assertTrue(address2.equals(address3));
	}

}
