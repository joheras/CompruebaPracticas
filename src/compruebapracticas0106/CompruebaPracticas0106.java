/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compruebapracticas0106;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
public class CompruebaPracticas0106 {

    final static String testFiles[] = {
        "Practica01/Parte01/C++/catch.hpp",
        "Practica01/Parte02/C++/catch.hpp",
        "Practica01/Parte03/C++/catch.hpp",
        "Practica03/Parte02/C++/catch.hpp",
        "Practica04/Parte01/C++/catch.hpp",
        "Practica04/Parte02/C++/catch.hpp",
        "Practica05/Parte01/C++/catch.hpp",
        "Practica05/Parte02/C++/catch.hpp",
        "Practica06/Parte01/C++/catch.hpp",
        "Practica01/Parte01/C++/Tests_prac01_01.cpp",
        "Practica01/Parte02/C++/Tests_prac01_02.cpp",
        "Practica01/Parte03/C++/Tests_prac01_03.cpp",
        "Practica03/Parte02/C++/Tests_prac03_02.cpp",
        "Practica04/Parte01/C++/Tests_prac04_01.cpp",
        "Practica04/Parte02/C++/Tests_prac04_02.cpp",
        "Practica05/Parte01/C++/Tests_prac05_01.cpp",
        "Practica05/Parte02/C++/Tests_prac05_02.cpp",
        "Practica06/Parte01/C++/Tests_prac06_01.cpp",
        "Practica02/Parte01/Java/Tests_prac02_01.java",
        "Practica02/Parte02/Java/Tests_prac02_02.java",
        "Practica02/Parte02/Java/Tests_prac02_02_Estudiante.java",
        "Practica02/Parte02/Java/Tests_prac02_02_Asignatura.java",
        "Practica02/Parte03/Java/Tests_prac02_03.java",
        "Practica03/Parte02/Java/Tests_prac03_02.java",
        "Practica04/Parte01/Java/Tests_prac04_01.java",
        "Practica04/Parte01/Java/Tests_prac04_01_Asignatura.java",
        "Practica04/Parte01/Java/Tests_prac04_01_Estudiante.java",
        "Practica04/Parte01/Java/Tests_prac04_01_Matricula.java",
        "Practica04/Parte02/Java/Tests_prac04_02.java",
        "Practica04/Parte02/Java/Tests_prac04_02_Punto.java",
        "Practica04/Parte02/Java/Tests_prac04_02_Polilinea.java",
        "Practica05/Parte01/Java/Tests_prac05_01.java",
        "Practica05/Parte01/Java/Tests_prac05_01_Circunferencia.java",
        "Practica05/Parte01/Java/Tests_prac05_01_Circunferencia2D.java",
        "Practica05/Parte01/Java/Tests_prac05_01_Punto.java",
        "Practica05/Parte02/Java/Tests_prac05_02.java",
        "Practica05/Parte02/Java/Tests_prac05_02_Actividad.java",
        "Practica05/Parte02/Java/Tests_prac05_02_Asignatura.java",
        "Practica05/Parte02/Java/Tests_prac05_02_Estudiante.java",
        "Practica05/Parte02/Java/Tests_prac05_02_Matricula.java",
        "Practica05/Parte02/Java/Tests_prac05_02_Reconocimiento.java",
        "Practica06/Parte01/Java/Tests_prac06_01.java",
        "Practica06/Parte01/Java/Tests_prac06_01_Directory.java",
        "Practica06/Parte01/Java/Tests_prac06_01_FileManager.java",
        "Practica06/Parte01/Java/Tests_prac06_01_FSObject.java",
        "Practica06/Parte01/Java/Tests_prac06_01_TextFile.java",};

    final static String cTestsfolders[] = {
        "Practica01/Parte01/C++",
        "Practica01/Parte02/C++",
        "Practica01/Parte03/C++",
        "Practica03/Parte02/C++",
        "Practica04/Parte01/C++",
        "Practica04/Parte02/C++",
        "Practica05/Parte01/C++",
        "Practica05/Parte02/C++",
        "Practica06/Parte01/C++"
    };

    final static String javaTestsfolders[] = {
        "Practica02/Parte01/Java",
        "Practica02/Parte02/Java",
        "Practica02/Parte03/Java",
        "Practica03/Parte02/Java",
        "Practica04/Parte01/Java",
        "Practica04/Parte02/Java",
        "Practica05/Parte01/Java",
        "Practica05/Parte02/Java",
        "Practica06/Parte01/Java"
    };

    final static String cfolders[] = {
        "Practica01/Parte01/C++",
        "Practica01/Parte02/C++",
        "Practica01/Parte03/C++",
        "Practica03/Parte01/C++",
        "Practica03/Parte02/C++",
        "Practica04/Parte01/C++",
        "Practica04/Parte02/C++",
        "Practica05/Parte01/C++",
        "Practica05/Parte02/C++",
        "Practica06/Parte01/C++"
    };

    final static String javafolders[] = {
        "Practica02/Parte01/Java",
        "Practica02/Parte02/Java",
        "Practica02/Parte03/Java",
        "Practica03/Parte01/Java",
        "Practica03/Parte02/Java",
        "Practica04/Parte01/Java",
        "Practica04/Parte02/Java",
        "Practica05/Parte01/Java",
        "Practica05/Parte02/Java",
        "Practica06/Parte01/Java"
    };

    final static String ficheros[] = {"/Practica01",
        "/Practica01/Parte01",
        "/Practica01/Parte01/C++",
        "/Practica01/Parte01/C++/Circunferencia.h",
        "/Practica01/Parte01/C++/Circunferencia.cpp",
        "/Practica01/Parte01/C++/Principal_prac01_01.cpp",
        "/Practica01/Parte02",
        "/Practica01/Parte02/C++",
        "/Practica01/Parte02/C++/Asignatura.h",
        "/Practica01/Parte02/C++/Asignatura.cpp",
        "/Practica01/Parte02/C++/Estudiante.h",
        "/Practica01/Parte02/C++/Estudiante.cpp",
        "/Practica01/Parte02/C++/Principal_prac01_02.cpp",
        "/Practica01/Parte03",
        "/Practica01/Parte03/C++",
        "/Practica01/Parte03/C++/Punto.h",
        "/Practica01/Parte03/C++/Punto.cpp",
        "/Practica01/Parte03/C++/Principal_prac01_03.cpp",
        "/Practica02",
        "/Practica02/Parte01",
        "/Practica02/Parte01/Java",
        "/Practica02/Parte01/Java/Circunferencia.java",
        "/Practica02/Parte01/Java/Principal_prac02_01.java",
        "/Practica02/Parte02",
        "/Practica02/Parte02/Java",
        "/Practica02/Parte02/Java/Asignatura.java",
        "/Practica02/Parte02/Java/Estudiante.java",
        "/Practica02/Parte02/Java/Principal_prac02_02.java",
        "/Practica02/Parte03",
        "/Practica02/Parte03/Java",
        "/Practica02/Parte03/Java/Punto.java",
        "/Practica02/Parte03/Java/Principal_prac02_03.java",
        "/Practica03",
        "/Practica03/Parte01",
        "/Practica03/Parte01/C++",
        "/Practica03/Parte01/C++/Principal_prac03_01.cpp",
        "/Practica03/Parte01/Java",
        "/Practica03/Parte01/Java/Principal_prac03_01.java",
        "/Practica03/Parte02",
        "/Practica03/Parte02/C++",
        "/Practica03/Parte02/C++/Punto.h",
        "/Practica03/Parte02/C++/Punto.cpp",
        "/Practica03/Parte02/C++/Principal_prac03_02.cpp",
        "/Practica03/Parte02/Java",
        "/Practica03/Parte02/Java/Punto.java",
        "/Practica03/Parte02/Java/Principal_prac03_02.java",
        "/Practica04",
        "/Practica04/Parte01",
        "/Practica04/Parte01/C++",
        "/Practica04/Parte01/C++/Asignatura.h",
        "/Practica04/Parte01/C++/Asignatura.cpp",
        "/Practica04/Parte01/C++/Estudiante.h",
        "/Practica04/Parte01/C++/Estudiante.cpp",
        "/Practica04/Parte01/C++/Matricula.h",
        "/Practica04/Parte01/C++/Matricula.cpp",
        "/Practica04/Parte01/C++/Curso.h",
        "/Practica04/Parte01/C++/OrdenMatricula.h",
        "/Practica04/Parte01/C++/Principal_prac04_01.cpp",
        "/Practica04/Parte01/Java",
        "/Practica04/Parte01/Java/Asignatura.java",
        "/Practica04/Parte01/Java/Estudiante.java",
        "/Practica04/Parte01/Java/Matricula.java",
        "/Practica04/Parte01/Java/Curso.java",
        "/Practica04/Parte01/Java/OrdenMatricula.java",
        "/Practica04/Parte01/Java/Principal_prac04_01.java",
        "/Practica04/Parte02",
        "/Practica04/Parte02/C++",
        "/Practica04/Parte02/C++/Punto.h",
        "/Practica04/Parte02/C++/Punto.cpp",
        "/Practica04/Parte02/C++/Polilinea.h",
        "/Practica04/Parte02/C++/Polilinea.cpp",
        "/Practica04/Parte02/C++/Principal_prac04_02.cpp",
        "/Practica04/Parte02/Java",
        "/Practica04/Parte02/Java/Punto.java",
        "/Practica04/Parte02/Java/Polilinea.java",
        "/Practica04/Parte02/Java/Principal_prac04_02.java",
        "/Practica05",
        "/Practica05/Parte01",
        "/Practica05/Parte01/C++",
        "/Practica05/Parte01/C++/Circunferencia2D.h",
        "/Practica05/Parte01/C++/Circunferencia2D.cpp",
        "/Practica05/Parte01/C++/Circunferencia.h",
        "/Practica05/Parte01/C++/Circunferencia.cpp",
        "/Practica05/Parte01/C++/Punto.h",
        "/Practica05/Parte01/C++/Punto.cpp",
        "/Practica05/Parte01/C++/Principal_prac05_01.cpp",
        "/Practica05/Parte01/Java",
        "/Practica05/Parte01/Java/Circunferencia2D.java",
        "/Practica05/Parte01/Java/Circunferencia.java",
        "/Practica05/Parte01/Java/Punto.java",
        "/Practica05/Parte01/Java/Principal_prac05_01.java",
        "/Practica05/Parte02",
        "/Practica05/Parte02/C++",
        "/Practica05/Parte02/C++/Actividad.h",
        "/Practica05/Parte02/C++/Actividad.cpp",
        "/Practica05/Parte02/C++/Asignatura.h",
        "/Practica05/Parte02/C++/Asignatura.cpp",
        "/Practica05/Parte02/C++/Curso.h",
        "/Practica05/Parte02/C++/Estudiante.h",
        "/Practica05/Parte02/C++/Estudiante.cpp",
        "/Practica05/Parte02/C++/Matricula.h",
        "/Practica05/Parte02/C++/Matricula.cpp",
        "/Practica05/Parte02/C++/OrdenMatricula.h",
        "/Practica05/Parte02/C++/Reconocimiento.h",
        "/Practica05/Parte02/C++/Reconocimiento.cpp",
        "/Practica05/Parte02/C++/Tipo.h",
        "/Practica05/Parte02/C++/Principal_prac05_02.cpp",
        "/Practica05/Parte02/Java",
        "/Practica05/Parte02/Java/Actividad.java",
        "/Practica05/Parte02/Java/Asignatura.java",
        "/Practica05/Parte02/Java/Curso.java",
        "/Practica05/Parte02/Java/Estudiante.java",
        "/Practica05/Parte02/Java/Matricula.java",
        "/Practica05/Parte02/Java/OrdenMatricula.java",
        "/Practica05/Parte02/Java/Reconocimiento.java",
        "/Practica05/Parte02/Java/Tipo.java",
        "/Practica05/Parte02/Java/Principal_prac05_02.java",
        "/Practica06",
        "/Practica06/Parte01",
        "/Practica06/Parte01/C++",
        "/Practica06/Parte01/C++/FSObject.h",
        "/Practica06/Parte01/C++/FSObject.cpp",
        "/Practica06/Parte01/C++/TextFile.h",
        "/Practica06/Parte01/C++/TextFile.cpp",
        "/Practica06/Parte01/C++/Directory.h",
        "/Practica06/Parte01/C++/Directory.cpp",
        "/Practica06/Parte01/C++/FileManager.h",
        "/Practica06/Parte01/C++/FileManager.cpp",
        "/Practica06/Parte01/C++/Principal_prac06_01.cpp",
        "/Practica06/Parte01/Java",
        "/Practica06/Parte01/Java/FSObject.java",
        "/Practica06/Parte01/Java/TextFile.java",
        "/Practica06/Parte01/Java/Directory.java",
        "/Practica06/Parte01/Java/FileManager.java",
        "/Practica06/Parte01/Java/Principal_prac06_01.java"

    };

    final static String ficherosOpcionales[] = {"/Practica05/Parte02/C++/OrdenMatricula.cpp",
        "/Practica05/Parte02/C++/Tipo.cpp", "/Practica05/Parte02/C++/Curso.cpp",
        "/Practica04/Parte01/C++/OrdenMatricula.cpp", "/Practica04/Parte01/C++/Curso.cpp"
    };

    private static void compruebaEstructura(BufferedWriter bw, String path) throws IOException {
        bw.write("******************************************************\n");
        bw.write("Comprobando si la estructura es correcta\n");
        bw.write("******************************************************\n");
        File f;
        ArrayList<String> lines = new ArrayList<>();
        for (String fichero : ficheros) {
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
        }
    }

    private static ArrayList<String> getFilesFromFolder(String folder) {
        ArrayList<String> files = new ArrayList<>();

        for (String file : ficheros) {
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
            for (String file : ficheros) {
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

        for (String file : ficheros) {
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
        for (String folder : cfolders) {
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
        for (String folder : javafolders) {
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
        for (String folder : cTestsfolders) {
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
        for (String folder : javaTestsfolders) {
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
                
                
                command = "java -cp " + path+folder 
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

//        String path = "/home/joheras/Escritorio/MataMartínezGadea/";
//        String FILENAME = "/home/joheras/Escritorio/MataMartínezGadea/informe.txt";
        String path = "/home/joheras/Escritorio/Practicas/";
        String FILENAME = "/home/joheras/Escritorio/Practicas/informe.txt";
        
        String TEXTFOLDER = "/home/joheras/Escritorio/Tests/";

        FileWriter fw = new FileWriter(FILENAME, true);
        BufferedWriter bw = new BufferedWriter(fw);

        System.out.println("Comprobando la estructura de ficheros");
        compruebaEstructura(bw, path);
        System.out.println("Comprobando si los ficheros compilan");
        compilaFolders(bw, path);
        System.out.println("Comprobando si pasan los tests");
        copyTestFiles(TEXTFOLDER, path);
        compruebaTests(bw, path);
        bw.close();
    }

}
