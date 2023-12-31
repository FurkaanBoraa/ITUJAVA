package lab;

public class Poem extends Book {
	private int wordsPerOddPage;
	private int wordsPerEvenPage;
	
	public Poem(String bookName, String author,int shelfNo, int pageNumber, int wordsPerOddPage, int wordsPerEvenPage) {
		super(bookName,author,shelfNo, pageNumber);
		this.wordsPerOddPage = wordsPerOddPage;
		this.wordsPerEvenPage = wordsPerEvenPage;
	}



	@Override
	public int calculateWordsNumber() {
		int sum = 0;
		for(int i = 1; i<super.getPageNumber();i++) {
			if(i % 2 ==0) {
				sum +=wordsPerEvenPage;
			}else {
				sum+=wordsPerOddPage;
			}
		}
		return sum;
	}

}
