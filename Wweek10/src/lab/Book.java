package lab;

public abstract class Book {
	private final String bookName;
	private final String author;
	private int shelfNo;
	private int pageNumber;

	public Book(String bookName, String author,int shelfNo, int pageNumber) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.shelfNo = shelfNo;
		this.pageNumber = pageNumber;
	}
	
	public abstract int calculateWordsNumber();
	
	public int getShelfNo() {
		return shelfNo;
	}
	public void setShelfNo(int shelfNo) {
		this.shelfNo = shelfNo;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getBookName() {
		return bookName;
	}
	public String getAuthor() {
		return author;
	}
}
