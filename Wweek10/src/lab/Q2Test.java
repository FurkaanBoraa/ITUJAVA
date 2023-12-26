package lab;

public class Q2Test {

	public static void main(String[] args) {
		Novel novel = new Novel("Lighthouse", "Jules Verne",3, 70, 50);
		Poem poem = new Poem("Letters", "Some Romantic",5, 100, 21, 10);
		System.out.println(novel.calculateWordsNumber());
		System.out.println(poem.calculateWordsNumber());

	}

}
