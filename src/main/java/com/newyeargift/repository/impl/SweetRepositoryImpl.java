package com.newyeargift.repository.impl;

import com.newyeargift.model.sweets.Caramel;
import com.newyeargift.model.sweets.Chocolate;
import com.newyeargift.model.sweets.Jelly;
import com.newyeargift.model.sweets.Praline;
import com.newyeargift.repository.SweetRepository;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SweetRepositoryImpl implements SweetRepository {

    final static Logger log = Logger.getLogger(SweetRepository.class);

    private List<String> getPathAndFile() {
        List<String> files = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(new File("file_path_storage.txt")))) {
            while (scanner.hasNext()) {
                files.add(scanner.next());
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return files;
    }

    @Override
    public List<Caramel> findAllCaramels() {
        List<Caramel> sweets = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(new File(getPathAndFile().get(0))))) {
            while (scanner.hasNext()) {
                sweets.add(new Caramel(scanner.next(), scanner.nextInt()));
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return sweets;
    }

    @Override
    public List<Chocolate> findAllChocolate() {
        List<Chocolate> chocolates = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(new File(getPathAndFile().get(1))))) {
            while (scanner.hasNext()) {
                chocolates.add(new Chocolate(scanner.next(), scanner.nextInt()));
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return chocolates;
    }

    @Override
    public List<Jelly> findAllJelly() {
        List<Jelly> jellies = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(new File(getPathAndFile().get(2))))) {
            while (scanner.hasNext()) {
                jellies.add(new Jelly(scanner.next(), scanner.nextInt()));
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return jellies;
    }

    @Override
    public List<Praline> findAllPraline() {
        List<Praline> pralines = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(new File(getPathAndFile().get(3))))) {
            while (scanner.hasNext()) {
                pralines.add(new Praline(scanner.next(), scanner.nextInt()));
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return pralines;
    }

    @Override
    public void saveResultToFile(String result) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(getPathAndFile().get(4), true))) {
            bufferedWriter.write(result);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
