package privat.houyi.com.ipc.server;

import android.os.IInterface;
import android.os.RemoteException;


import java.util.List;

import privat.houyi.com.ipc.Book;

public interface BookManager extends IInterface {

    List<Book> getBooks() throws RemoteException;

    void addBook(Book book) throws RemoteException;
}
