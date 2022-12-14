package Iterator.book;

import Iterator.Iterator;

/**
 * @author ankh
 * @created at 2022-09-07 14:29
 */
public class BookShelfIterator implements Iterator {
    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < bookShelf.getLength() ? true : false;
    }

    @Override
    public Object next() {
        return bookShelf.getBookAt(index++);
    }
}
