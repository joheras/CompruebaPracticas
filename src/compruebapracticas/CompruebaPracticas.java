/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compruebapracticas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import static java.nio.file.Files.lines;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

/**
 *
 * @author joheras
 */
public class CompruebaPracticas {

    // Lista con los ficheros de test
    static ArrayList<String> testFiles;
    // Lista con la estructura de ficheros a satisfacer
    static ArrayList<String> structure;
    // Lista con los ficheros opcionales
    static ArrayList<String> optionalFiles;

    // Carpetas de los ficheros de C++ y Java y de los ficheros de tests
    static ArrayList<String> cFolders;
    static ArrayList<String> javaFolders;
    static ArrayList<String> cTestsFolders;
    static ArrayList<String> javaTestsFolders;

    /**
     * *************************************************************************
     *
     * Métodos auxiliares
     *
     **************************************************************************
     */
    /*
    * Método para leer una lista de ficheros almacenada en un fichero de texto
     */
    private static ArrayList<String> readListofFilesFromFile(String path) throws FileNotFoundException, IOException {
        ArrayList<String> result = new ArrayList<>();
        FileReader in = new FileReader(path);
        BufferedReader br = new BufferedReader(in);
        String line;
        while ((line = br.readLine()) != null) {
            result.add(line);
        }
        return result;
    }

    /*
    * Método para extraer lista de carpetas a partir de una lista de ficheros y
    * el tipo (Java o C++) de esos ficheros
     */
    private static ArrayList<String> extractFoldersFromListofFiles(ArrayList<String> files,
            String type) {
        ArrayList<String> result = new ArrayList<>();
        for (String file : files) {
            if (!file.contains(".") && file.contains(type) && !result.contains(file)) {
                result.add(file);
            }
        }
        return result;

    }

    private static ArrayList<String> extractFoldersFromListofTestFiles(ArrayList<String> files,
            String type) {
        ArrayList<String> result = new ArrayList<>();
        for (String file : files) {
            String folder = file.substring(0, file.lastIndexOf("/"));
            if (folder.contains(type) && !result.contains(folder)) {
                result.add(folder);
            }
        }
        return result;

    }

    private static void compruebaEstructura(BufferedWriter bw, String path) throws IOException {
        bw.write("******************************************************\n");
        bw.write("Comprobando si la estructura es correcta\n");
        bw.write("******************************************************\n");
        File f;
        ArrayList<String> lines = new ArrayList<>();
        for (String fichero : structure) {
            f = new File(path + fichero);
            if (!f.exists()) {
                if ((path + fichero).contains(".")) {
                    lines.add("Falta el fichero " + fichero + "\n");
                } else {
                    lines.add("Falta la carpeta " + fichero + "\n");
                }
            }
        }
        if (!lines.isEmpty()) {
            for (int i = 0; i < lines.size(); i++) {
                bw.write(lines.get(i));
            }
        } else {
            bw.write("La estructura de ficheros es correcta\n");
            for (String fichero : optionalFiles) {
                f = new File(path + fichero);
                if (f.exists()) {
                    bw.write("Además ha añadido el fichero "+ fichero + "\n");
                }
            }
        }
    }

    private static ArrayList<String> getFilesFromFolder(String folder) {
        ArrayList<String> files = new ArrayList<>();

        for (String file : structure) {
            if (file.contains(folder) && !file.endsWith("C++") && !file.endsWith("Java")) {
                files.add(file);
            }
        }
        return files;
    }

    private static ArrayList<String> getFilesFromFolderTestsExecute(String folder) {
        ArrayList<String> files = new ArrayList<>();
        if (folder.contains("Java")) {
            for (String file : testFiles) {
                if (file.contains(folder) && !file.endsWith("Java")
                        && (file.endsWith("01.java") || file.endsWith("02.java") || file.endsWith("03.java"))) {
                    files.add("/" + file);
                }
            }

        } else {
            for (String file : structure) {
                if (file.contains(folder) && !file.endsWith("C++") && !file.endsWith("Java") && !file.contains("Principal")) {
                    files.add(file);
                }
            }
            for (String file : testFiles) {
                if (file.contains(folder) && !file.endsWith("C++") && !file.endsWith("Java")) {
                    files.add("/" + file);
                }
            }
        }
        return files;
    }

    private static ArrayList<String> getFilesFromFolderTestsCompile(String folder) {
        ArrayList<String> files = new ArrayList<>();

        for (String file : structure) {
            if (file.contains(folder) && !file.endsWith("C++") && !file.endsWith("Java") && !file.contains("Principal")) {
                files.add(file);
            }
        }
        for (String file : testFiles) {
            if (file.contains(folder) && !file.endsWith("C++") && !file.endsWith("Java")) {
                files.add("/" + file);
            }
        }

        return files;
    }

    private static void compilaFoldersC(BufferedWriter bw, String path) throws IOException, InterruptedException {

        Runtime rt = Runtime.getRuntime();
        bw.write("******************************************************\n");
        bw.write("Parte C++\n");
        bw.write("******************************************************\n");
        for (String folder : cFolders) {
            ArrayList<String> files = getFilesFromFolder(folder);
            String command = "g++ ";
            for (String file : files) {
                command = command + path.substring(0, path.lastIndexOf("/")) + file + " ";
            }
            bw.write("--------------------------------------\n");
            bw.write(folder + "\n");
            bw.write("--------------------------------------\n");

            Process pr = rt.exec(command);
            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getErrorStream()));
            String line = input.readLine();
            if (line == null) {
                bw.write("Compila correctamente" + "\n");
            } else {
                bw.write(line + "\n");
                while ((line = input.readLine()) != null) {
                    bw.write(line + "\n");
                }
            }

            bw.write("\n\n");

        }

    }

    private static void compilaFoldersJava(BufferedWriter bw, String path) throws IOException, InterruptedException {
        Runtime rt = Runtime.getRuntime();
        bw.write("******************************************************\n");
        bw.write("Parte Java\n");
        bw.write("******************************************************\n");
        for (String folder : javaFolders) {
            ArrayList<String> files = getFilesFromFolder(folder);
            String command = "javac -encoding ISO-8859-1 ";
            for (String file : files) {
                command = command + path.substring(0, path.lastIndexOf("/")) + file + " ";
            }
            bw.write("--------------------------------------\n");
            bw.write(folder + "\n");
            bw.write("--------------------------------------\n");

            Process pr = rt.exec(command);
            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getErrorStream()));
            String line = input.readLine();
            if (line == null) {
                bw.write("Compila correctamente" + "\n");
            } else {
                bw.write(line + "\n");
                while ((line = input.readLine()) != null) {
                    bw.write(line + "\n");
                }
            }

            bw.write("\n\n");

        }

    }

    private static void compilaFolders(BufferedWriter bw, String path) throws IOException, InterruptedException {
        bw.write("\n\n\n******************************************************\n");
        bw.write("Comprobando si los ficheros compilan\n");
        bw.write("******************************************************\n");
        compilaFoldersC(bw, path);
        compilaFoldersJava(bw, path);
    }

    private static void copyTestFiles(String testsFolder, String targetFolder) throws IOException {

        for (String file : testFiles) {
            Files.copy(Paths.get(testsFolder + file), Paths.get(targetFolder + file), REPLACE_EXISTING);
        }

    }

    private static void compruebaTestsC(BufferedWriter bw, String path) throws IOException, InterruptedException {

        Runtime rt = Runtime.getRuntime();
        bw.write("******************************************************\n");
        bw.write("Parte C++\n");
        bw.write("******************************************************\n");

        for (String folder : cTestsFolders) {
            ArrayList<String> files = getFilesFromFolderTestsExecute(folder);
            String command = "g++ ";
            for (String file : files) {
                command = command + path.substring(0, path.lastIndexOf("/")) + file + " ";
            }
            command = command + " -o " + path + folder + "/a.out";
            //System.out.println(command);
            bw.write("--------------------------------------\n");
            bw.write("Tests en " + folder + "\n");
            bw.write("--------------------------------------\n");

            Process pr = rt.exec(command);
            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line = null;
            while ((line = input.readLine()) != null) {

            }

            if ((new File(path + folder + "/a.out")).exists()) {

                try {
                    pr = rt.exec(path + folder + "/a.out");

                    input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                    String line2 = null;
                    while ((line2 = input.readLine()) != null) {
                        bw.write(line2 + "\n");
                    }
                } catch (IOException e) {

                }
            } else {
                bw.write("Se produjeron errores de compilación con los tests\n");
            }

            bw.write("\n\n");

        }

    }

    private static void compruebaTestsJava(BufferedWriter bw, String path) throws IOException, InterruptedException {

        Runtime rt = Runtime.getRuntime();
        bw.write("******************************************************\n");
        bw.write("Parte Java\n");
        bw.write("******************************************************\n");
        for (String folder : javaTestsFolders) {
            ArrayList<String> files = getFilesFromFolderTestsExecute(folder);
            ArrayList<String> filesCompile = getFilesFromFolderTestsCompile(folder);
            if (files.size() != 1) {
                bw.write("Se produjeron errores de compilación con los tests\n");
            } else {
                String command = "javac -encoding ISO-8859-1 -cp :/usr/share/java/junit4.jar ";
                for (String file : filesCompile) {
                    command = command + path.substring(0, path.lastIndexOf("/")) + file + " ";
                }
                //System.out.println(command);
                Process pr = rt.exec(command);
                BufferedReader input = new BufferedReader(new InputStreamReader(pr.getErrorStream()));
                String line = null;
                while ((line = input.readLine()) != null) {
                    bw.write(line + "\n");
                }

                command = "java -cp " + path + folder
                        + "/:/usr/share/java/junit4.jar org.junit.runner.JUnitCore "
                        + files.get(0).substring(files.get(0).lastIndexOf("/") + 1, files.get(0).indexOf("."));

                //System.out.println(command);
                bw.write("--------------------------------------\n");
                bw.write("Tests en " + folder + "\n");
                bw.write("--------------------------------------\n");

                pr = rt.exec(command);
                input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                line = null;
                while ((line = input.readLine()) != null) {
                    bw.write(line + "\n");
                }

                bw.write("\n\n");
            }
        }

    }

    private static void compruebaTests(BufferedWriter bw, String path) throws IOException, InterruptedException {
        bw.write("\n\n\n******************************************************\n");
        bw.write("Comprobando los tests\n");
        bw.write("******************************************************\n");
        compruebaTestsC(bw, path);
        compruebaTestsJava(bw, path);
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        // El path del proyecto debe contener dos carpetas. Una de configuración
        // llamada Config y otra que contendrá los tests llamada Tests.
        String projectPath = "/home/jonathan/NetBeansProjects/CompruebaPracticas/";

        // La actividad indica el nombre de la actividad a evaluar.
        String actividad = "Practicas0106";

        // La carpeta Config del proyecto contendrá tantas subcarpetas como
        // actividades queramos evaluar. Cada una de esas subcarpetas deberá
        // contener un fichero de estructura (llamado structure.txt),
        // un fichero con la lista de ficheros de tests (llamado testfiles.txt),
        // y un fichero con la lista de ficheros adicionales (llamado optionalfiles.txt).
        String configPath = projectPath + "Config/" + actividad + "/";
        String structurePath = configPath + "structure.txt";
        String optionalFilesPath = configPath + "optionalfiles.txt";
        String testFilesPath = configPath + "testfiles.txt";

        // Leemos la estructura de ficheros, la lista de ficheros opcionales y
        // la lista de ficheros de tests y lo almacenamos en las respectivas
        // variables
        structure = readListofFilesFromFile(structurePath);
        optionalFiles = readListofFilesFromFile(optionalFilesPath);
        testFiles = readListofFilesFromFile(testFilesPath);

        // Obtenemos las carpetas de Java y C++ que contienen los ficheros y los
        // tests
        cFolders = extractFoldersFromListofFiles(structure, "C++");
        javaFolders = extractFoldersFromListofFiles(structure, "Java");
        cTestsFolders = extractFoldersFromListofTestFiles(testFiles, "C++");
        javaTestsFolders = extractFoldersFromListofTestFiles(testFiles, "Java");

        // La carpeta Tests del proyecto contendrá tantas subcarpetas como
        // actividades queramos evaluar. Cada una de esas subcarpetas deberá
        // contener los tests siguiendo la misma estructura de ficheros que se
        // pide entregar para así poder copiar los tests al sitio correcto
        String testFolderPath = projectPath + "Tests/" + actividad + "/";

        // La carpeta que queremos evaluar, y donde se guardará el informe.
        // Cuando tengamos un conjunto de ficheros habrá que modificar esto para
        // que se evaluen todos los envíos.
        String path = "/home/jonathan/Escritorio/MataMartínezGadea/";
        String reportPath = path + "informe.txt";

        FileWriter fw = new FileWriter(reportPath, true);
        BufferedWriter bw = new BufferedWriter(fw);

        System.out.println("Comprobando la estructura de ficheros");
        compruebaEstructura(bw, path);
        System.out.println("Comprobando si los ficheros compilan");
        compilaFolders(bw, path);
        System.out.println("Comprobando si pasan los tests");
        // Primero copiamos los ficheros de tests
        copyTestFiles(testFolderPath, path);
        compruebaTests(bw, path);
        bw.close();
    }

}
