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
package university;

import static org.junit.Assert.*;
import static university.RegistrationConfigurationUtil.*;

import org.junit.Before;
import org.junit.Test;

public class A1T04_StudentTest {

	Student student1;
	Student student2;
	Student student3;
	Student student4;

	// Will be executed before each test run
	@Before
	public void createStudents() {
		student1 = new Student("John Doe");
		student2 = new Student("Jane Doe");
		student3 = new Student("Jane Doe");
		student4 = new Student("Harry Potter");
	}

	@Test
	public void matriculatingYieldsMatriculationNumbers() throws Exception {

		/*
		 * Complete the Student implementation so that the registrar's office
		 * can handle them and the following assertions are true.
		 * 
		 * The class RegistrarsOffice was bought from another software vendor.
		 * We have only the class file. To see the class file you have to switch
		 * to the resource perspective and look into the cls folder. To use
		 * RegistrarsOffice our Student implementation has to provide the method
		 * in the Matriculatable interface.
		 */

		RegistrarsOffice registrar = new RegistrarsOffice("University Bonn");
		assertFalse(student1.isEnrolled());
		assertFalse(student2.isEnrolled());
		assertFalse(student3.isEnrolled());

		registrar.matriculate(student1);
		assertEquals(10000, student1.getMatriculationNumber());
		assertTrue(student1.isEnrolled());

		registrar.matriculate(student2);
		assertEquals(10001, student2.getMatriculationNumber());

		registrar.matriculate(student3);
		assertEquals(10002, student3.getMatriculationNumber());

		registrar.exmatriculate(student2);
		assertFalse(student2.isEnrolled());
		assertTrue(student1.isEnrolled());
		assertTrue(student3.isEnrolled());

		registrar.matriculate(student2);
		assertTrue(student2.isEnrolled());
		assertEquals(10003, student2.getMatriculationNumber());

	}

	@Test
	public void universityMarketingByMatriculationNumbers() {

		/*
		 * Configure registrar's office to make the following assertions come
		 * true.
		 * 
		 * This should make you aware that you can extend the behavior of the
		 * RegistrarsOffice without modifying the class. This one of - maybe the
		 * most important - advantages of Object Oriented Programming.
		 */

		RegistrarsOffice registrar = new RegistrarsOffice("Brand New Uni");
		configureToGetHighMatriculationNumbers(registrar);

		registrar.matriculate(student1);
		registrar.matriculate(student2);
		registrar.matriculate(student3);
		registrar.matriculate(student4);

		assertEquals(10100, student1.getMatriculationNumber());
		assertEquals(10117, student2.getMatriculationNumber());
		assertEquals(10134, student3.getMatriculationNumber());
		assertEquals(10151, student4.getMatriculationNumber());

	}

	@Test
	public void universitiesCouldRespectSuperstitionIfTheyWant() {

		/*
		 * Configure registrar's office to make the following assertions come
		 * true.
		 */

		RegistrarsOffice registrar = new RegistrarsOffice("Hogwarts?");
		configureToCareForSuperstition(registrar);

		registrar.matriculate(student1);
		registrar.matriculate(student2);
		registrar.matriculate(student3);
		registrar.matriculate(student4);

		assertEquals(1010, student1.getMatriculationNumber());
		assertEquals(1011, student2.getMatriculationNumber());
		assertEquals(1012, student3.getMatriculationNumber());
		assertEquals(1014, student4.getMatriculationNumber());

	}

}
