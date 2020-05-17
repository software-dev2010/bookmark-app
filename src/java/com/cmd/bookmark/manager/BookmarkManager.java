package com.cmd.bookmark.manager;

import com.cmd.bookmark.constants.BookGenre;
import com.cmd.bookmark.constants.KidFriendlyStatus;
import com.cmd.bookmark.constants.MovieGenre;
import com.cmd.bookmark.dao.BookmarkDao;
import com.cmd.bookmark.entities.*;
import com.cmd.bookmark.util.HttpConnect;
import com.cmd.bookmark.util.IOUtil;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;

public class BookmarkManager {

    private static BookmarkManager instance = new BookmarkManager();
    private static BookmarkDao dao = new BookmarkDao();
    private BookmarkManager() {

    }

    public static BookmarkManager getInstance() {
        return instance;
    }

    public Movie createMovie(long id, String title, String profile, int releaseYear,
                             String[] cast, String[] directors, MovieGenre genre, double imdbRating) {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle(title);
        movie.setProfile(profile);
        movie.setReleaseYear(releaseYear);
        movie.setCast(cast);
        movie.setDirectors(directors);
        movie.setGenre(genre);
        movie.setImdbRating(imdbRating);

        return movie;
    }

    public Book createBook(long id, String title, String imageUrl, int publicationYear, String publisher, String[] authors,
                           BookGenre genre, double amazonRating) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setImageUrl(imageUrl);
        book.setPublicationYear(publicationYear);
        book.setPublisher(publisher);
        book.setAuthors(authors);
        book.setGenre(genre);
        book.setAmazonRating(amazonRating);

        return book;
    }

    public WebLink createWebLink(long id, String title, String url, String host) {
        WebLink weblink = new WebLink();
        weblink.setId(id);
        weblink.setTitle(title);
        weblink.setUrl(url);
        weblink.setHost(host);

        return weblink;
    }

    public List<List<Bookmark>> getBookmarks() {
        return dao.getBookmarks();
    }

    public void saveUserBookmark(User user, Bookmark bookmark) {
        UserBookmark userBookmark = new UserBookmark();
        userBookmark.setUser(user);
        userBookmark.setBookmark(bookmark);

      /*  if (bookmark instanceof WebLink) {
            try {
                String url = ((WebLink)bookmark).getUrl();
                if (!url.endsWith(".pdf")) {
                    String webpage = HttpConnect.download(((WebLink)bookmark).getUrl());
                    if (webpage != null) {
                        IOUtil.write(webpage, bookmark.getId());
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }*/

        dao.saveUserBookmark(userBookmark);
    }

    public void setKidFriendlyStatus(User user, KidFriendlyStatus kidFriendlyStatus, Bookmark bookmark) {
        bookmark.setKidFriendlyStatus(kidFriendlyStatus);
        bookmark.setKidFriendlyMarkedBy(user);

        dao.updateKidFriendlyStatus(bookmark);

        System.out.println("Kid-friendly status: " + kidFriendlyStatus + ", Marked by:" + user.getEmail() + "," + bookmark);
    }

    public void share(User user, Bookmark bookmark) {
        bookmark.setShareBy(user);

        System.out.println("Data to be shared: ");
        if (bookmark instanceof Book) {
            System.out.println( ((Book)bookmark).getItemData());
        } else if (bookmark instanceof WebLink) {
            System.out.println( ((WebLink)bookmark).getItemData());
        }

        dao.sharedByInfo(bookmark);
    }

    public Collection<Bookmark> getBooks(boolean isBookmarked, long id) {

        return dao.getBooks(isBookmarked, id);
    }

    public Bookmark getBook(long bid) {

        return dao.getBook(bid);
    }
}
