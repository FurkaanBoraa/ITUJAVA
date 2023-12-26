package lab;

public class Novel extends Book {
	private int wordsPerPage;
	
	public Novel(String bookName, String author,int shelfNo, int pageNumber,int wordsPerPage) {
		super(bookName,author,shelfNo, pageNumber);
		this.wordsPerPage = wordsPerPage;
	}

	@Override
	public int calculateWordsNumber() {
		return (super.getPageNumber())*wordsPerPage;
	}

}
