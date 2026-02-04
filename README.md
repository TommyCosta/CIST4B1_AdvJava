# CIST4B1_AdvJava
Advanced Python - Data Structures

About Me:
My name is Tommy Costa and I live in the bay are near San Francisco. I have been coding for three years, mostly learned through professional experience. I worked over two years on the technical support team for a SaaS company, where I learned how to search databases using SQL. In that position, I also worked with Python programs and simple Java scripts, but did not actually write them. I took a genuine interest to the world of software engineering and decided to go back to school to expand my skillset. I have now cpmpleted two Python and one Java course (this is my second). In the past few months I have been working as part of a QE team for a networking company, though my role as lab associate is not very hands on.

Goals:
By completeing this course, I hope to deepen my understanding of databases and how to build them efficently. It's been two semesters since I have taken a Java course, so reinforcing that language wil also be nice. Personal growth is the personal goal, but this course also leads to a potential degree someday.

In-Class Warm Up Java File:

public class Animal {
	public void sound() {
		System.out.println("Animal noise");
	}
	public static void main(String[] args) {
		Panda p1 = new Panda();
		Shark s1 = new Shark();
		Rooster r1 = new Rooster();
		Animal[] zoo = {p1, s1, r1};
		for (Animal a : zoo) {
			a.sound();
		}
	}
}

class Panda extends Animal {
	String favoriteFood = "Bamboo";
    int weight = 150;
    @Override
	public void sound() {
		System.out.println("munch munch");
	}
}

class Shark extends Animal {
	int teethCount = 300;
    boolean isDangerous = true;
	@Override
	public void sound() {
		System.out.println("chomp");
	}
}

class Rooster extends Animal {
	String featherColor = "Red";
    int crowVolume = 5;
	@Override
	public void sound() {
		System.out.println("peck peck");
	}
}


