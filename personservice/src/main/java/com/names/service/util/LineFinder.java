package com.names.service.util;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

public class LineFinder {

    private static String resource = "/name-list.txt";


    public static Optional<String> findLineByName(String name) {

        String line = null;

        try (InputStream is = new ClassPathResource(resource).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {

            while ((line = bufferedReader.readLine()) != null) {
                final String n = line.split("_")[0];
                if (name.equals(n)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            line = null;
        }
        return Optional.ofNullable(line);
    }

    public static Optional<String> findMaxAge() {

        String line = null;
        String selectedLine = null;
        int max = -1;

        try (InputStream is = new ClassPathResource(resource).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {


            while ((line = bufferedReader.readLine()) != null) {
                final String[] data = line.split("_");
                final int age = Integer.parseInt(data[1]);

                if (max < age) {
                    selectedLine = line;
                    max = age;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(selectedLine);

    }
}
