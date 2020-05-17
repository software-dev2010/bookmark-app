package com.cmd.bookmark;

import com.cmd.bookmark.bgjobs.WebpageDownloaderTask;
import com.cmd.bookmark.entities.User;
import com.cmd.bookmark.entities.Bookmark;
import com.cmd.bookmark.manager.BookmarkManager;
import com.cmd.bookmark.manager.UserManager;

import java.util.List;

public class Launch {


    private static List<User> users;
    private static List<List<Bookmark>> bookmarks;

    private static void loadData() {
        System.out.println("1. Loading data.....");
        DataStore.loadData();

        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstance().getBookmarks();

        //System.out.println("Printing data......");
        // printUserData();
        //printBookmarkData();
    }

    public static void main(String[] args) {
        loadData();
        start();

        //Background job
        //runDownloaderJob();
    }

    private static void runDownloaderJob() {
        WebpageDownloaderTask task = new WebpageDownloaderTask(true);
        (new Thread(task)).start();
    }

    private static void printUserData(){
        for (User user : users) {
            System.out.println(user);
        }
    }

    private static void printBookmarkData() {
        for (List<Bookmark> bookmarkList : bookmarks) {
            for (Bookmark bookmark : bookmarkList) {
                System.out.println(bookmark);
            }
        }
    }

    private static void start() {
        //System.out.println("\n2.Bookmarking......");
        for (User user : users) {
            View.browse(user, bookmarks);
        }
    }
}
