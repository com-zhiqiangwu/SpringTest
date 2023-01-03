package com.test.designmode.iteratormode;

import java.util.ArrayList;
import java.util.List;

public class BookShelf implements Arrgegate{
    private List<Book> bookList;
    private int last = 0;

    public BookShelf(int maxSize) {
        this.bookList = new ArrayList(maxSize);
    }

    public Book getBookAt(int index){
        if (index<0&&index>bookList.size()){
            System.out.println("书架这个位置没有书");
        }
        return  bookList.get(index);
    }

    public void appendBook(String name){
        bookList.add(new Book(name));
        this.last++;
    }

    public int getLength(){
        return bookList.size();
    }

    @Override
    public Iterator iterator() {
        return  new BookShelfIterator(this);
    }
}
