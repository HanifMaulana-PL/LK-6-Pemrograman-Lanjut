package LK6;

import java.io.*;
import java.util.*;

public class FileHandler {
    private String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    // Baca file
    public List<String> baca() {
        List<String> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error membaca file: " + e.getMessage());
        }

        return data;
    }

    // write
    public void tulis(String text) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(text);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error menulis file: " + e.getMessage());
        }
    }

    // hapus
    public void hapusData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("");
        } catch (IOException e) {
            System.out.println("Error menghapus data: " + e.getMessage());
        }
    }
}