package com.designmode.test.iteratormode;

public class BookShelf implements Arrgegate{
    private Book[] books;
    private int last = 0;

    public BookShelf(int maxSize) {
        this.books = new Book[maxSize];
    }

    public Book getBookAt(int index){
        if (index<0&&index>books.length){
            System.out.println("书架这个位置没有书");
        }
        return  books[index];
    }

    public void appendBook(String name){
        books[last] = new Book(name);
        this.last++;
    }

    public int getLength(){
        return books.length;
    }

    @Override
    public Iterator iterator() {
        return  new BookShelfIterator(this);
    }
}
