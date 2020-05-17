package com.cmd.bookmark.util;

import java.io.*;
import java.util.List;

public class IOUtil {

    public static void read(List<String> data, String fileName) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"))) {
            String line;
            // int count = 0;
            while ((line = br.readLine()) != null) {
                data.add(line);
                //count++;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String read(InputStream in) {
        StringBuilder text = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in,"UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line).append("\n");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    public static void write(String webpage, long id) {

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D://Daiana//BookmarkApp//pages//" +  String.valueOf(id) + ".html"),"UTF-8"))) {
            writer.write(webpage);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
