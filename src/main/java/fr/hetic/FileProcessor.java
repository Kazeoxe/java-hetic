package fr.hetic;

import java.io.*;

public class FileProcessor implements Reader {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java FileProcessor <dossier>");
            return;
        }

        File folder = new File(args[0]);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Erreur: Le dossier spécifié n'existe pas.");
            return;
        }

        for (File file : folder.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".op")) {
                processFile(file);
            }
        }
    }

    public static String calculFichier(String num1, String num2, String operator) {

        double num1Double = Double.parseDouble(num1);
        double num2Double = Double.parseDouble(num2);
        double result;

        switch (operator) {
            case "+":
                result = num1Double + num2Double;
                break;
            case "-":
                result = num1Double - num2Double;
                break;
            case "*":
                result = num1Double * num2Double;
                break;
            default:
                return "ERREUR";
        }

        return String.valueOf(result);
    }

    @Override
    public void read(String folderName) throws Exception {
        File dossier = new File(folderName);
        String outputFileName = folderName.getAbsolutePath().replace(".op", ".res");
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    try {
                        double num1 = Double.parseDouble(parts[0]);
                        double num2 = Double.parseDouble(parts[1]);
                        String operator = parts[2];
                        String result = calculFichier(String.valueOf(num1), String.valueOf(num2), operator);
                        writer.write(String.valueOf(result) + "\n");
                    } catch (NumberFormatException e) {
                        writer.write("ERROR\n");
                    }
                } else {
                    writer.write("ERROR\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}