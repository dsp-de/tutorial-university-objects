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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import people.Person;
import people.CollectiveIdentity;

/*
 * For details of the mentioned students, you may consult e.g.
 * http://en.wikipedia.org/wiki/Hogwarts
 */
public class A1T03_PersonsStudentsProfessors {

	@Test
	public void personsIntroduceThemselves() throws Exception {

		/*
		 * Change the classes Person, Student, and Professor so that the
		 * following tests succeed.
		 * 
		 * You shouldn't add any other fields to the classes. It is enough to
		 * introduce methods.
		 */

		Person person = new Person("somebody");
		Student student1 = new Student("Harry Potter");
		Student student2 = new Student("Hermione");
		Professor professor = new Professor("Prof. Albus Dumbledore");

		assertEquals("somebody", person.getName());
		assertEquals("Harry Potter", student1.getName());
		assertEquals("Hermione", student2.getName());
		assertEquals("Prof. Albus Dumbledore", professor.getName());

		assertEquals("Hi! I'm Harry Potter.", student1.getGreeting());
		assertEquals("Hi! I'm Hermione.", student2.getGreeting());
		assertEquals("Welcome ladies and gentlemen! May I introduce myself? "
				+ "My name is Prof. Albus Dumbledore.", //
				professor.getGreeting());

		assertEquals("Almost every day I go to the world to be.", //
				person.getWorkDescription());
		assertEquals("Almost every day I go to Hogwarts to study.", //
				student1.getWorkDescription());
		assertEquals("Almost every day I go to Hogwarts to study.", //
				student2.getWorkDescription());
		assertEquals("Almost every day I go to Hogwarts to teach.", //
				professor.getWorkDescription());

		/*
		 * After you improved the code so that this test succeeds, review the
		 * classes Person, Student, and Professor to see whether you can improve
		 * them.
		 */

	}

	@Test
	public void peopleMightIdentifyThemselvesWithACollectiveIdentity()
			throws Exception {

		/*
		 * Improve the class CollectiveIdentity so that the following assertions
		 * hold true. You can even change the code that we suggested. The test
		 * itself is of course taboo.
		 */

		CollectiveIdentity harrysFriends = new CollectiveIdentity(
				"Harry's friends");
		harrysFriends.add(new Person("Harry Potter"));
		harrysFriends.add(new Person("Hermione Granger"));
		harrysFriends.add(new Person("Ron Weasley"));
		harrysFriends.add(new Person("Neville Longbottom"));
		assertEquals("Here is who we are: " + "Harry's friends ("
				+ "Harry Potter, Hermione Granger, Ron Weasley, "
				+ "Neville Longbottom)", //
				harrysFriends.getSelfIntroduction());

		CollectiveIdentity house1 = new CollectiveIdentity("Gryffindor");
		house1.add(harrysFriends);
		house1.add(new Person("Katie Bell"));
		house1.add(new Person("Lavender Brown"));
		house1.add(new Person("Seamus Finnigan"));
		assertEquals("Here is who we are: Gryffindor (Harry's friends ("
				+ "Harry Potter, Hermione Granger, Ron Weasley, "
				+ "Neville Longbottom), Katie Bell, Lavender Brown, "
				+ "Seamus Finnigan)", //
				house1.getSelfIntroduction());

		CollectiveIdentity house2 = new CollectiveIdentity("Hufflepuff");
		house2.add(new Person("Hannah Abbott"));
		house2.add(new Person("Cedric Diggory"));
		house2.add(new Person("Ernie Macmillan"));
		assertEquals("Here is who we are: Hufflepuff ("
				+ "Hannah Abbott, Cedric Diggory, Ernie Macmillan)",
				house2.getSelfIntroduction());

		CollectiveIdentity house3 = new CollectiveIdentity("Ravenclaw");
		house3.add(new Person("Cho Chang"));
		house3.add(new Person("Michael Corner"));
		house3.add(new Person("Padma Patil"));
		assertEquals("Here is who we are: Ravenclaw ("
				+ "Cho Chang, Michael Corner, Padma Patil)",
				house3.getSelfIntroduction());

		CollectiveIdentity dracosGang = new CollectiveIdentity("Draco's gang");
		dracosGang.add(new Person("Draco Lucius Malfoy"));
		dracosGang.add(new Person("Vincent Crabbe"));
		dracosGang.add(new Person("Gregory Goyle"));
		assertEquals("Here is who we are: Draco's gang ("
				+ "Draco Lucius Malfoy, Vincent Crabbe, Gregory Goyle)",
				dracosGang.getSelfIntroduction());

		CollectiveIdentity house4 = new CollectiveIdentity("Slytherin");
		house4.add(dracosGang);
		house4.add(new Person("Pansy Parkinson"));
		assertEquals("Here is who we are: Slytherin (Draco's gang ("
				+ "Draco Lucius Malfoy, Vincent Crabbe, Gregory Goyle), "
				+ "Pansy Parkinson)", //
				house4.getSelfIntroduction());

		CollectiveIdentity hogwarts = new CollectiveIdentity("Hogwarts");
		hogwarts.add(house1);
		hogwarts.add(house2);
		hogwarts.add(house3);
		hogwarts.add(house4);
		assertEquals("Here is who we are: Hogwarts (Gryffindor ("
				+ "Harry's friends (Harry Potter, Hermione Granger, "
				+ "Ron Weasley, Neville Longbottom), Katie Bell, "
				+ "Lavender Brown, Seamus Finnigan), Hufflepuff ("
				+ "Hannah Abbott, Cedric Diggory, Ernie Macmillan), "
				+ "Ravenclaw (Cho Chang, Michael Corner, Padma Patil), "
				+ "Slytherin (Draco's gang (Draco Lucius Malfoy, "
				+ "Vincent Crabbe, Gregory Goyle), Pansy Parkinson))",
				hogwarts.getSelfIntroduction());

		/*
		 * Review your code again, after you successfully created the missing
		 * methods in CollectiveIdentity. Anything to improve? Can it be done
		 * with less code? What's the structure? Give another example where such
		 * an structure could be useful.
		 */
	}
}
