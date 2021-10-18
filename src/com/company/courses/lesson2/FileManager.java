package com.company.courses.lesson2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class FileManager {
    private Path directory;
    public String fileName;

    public FileManager(Path directory) {
        this.directory = directory;
        printList();
    }

    public void changeDirectory(String targetDirectory) {
        assignCurrentDirectoryFromString(targetDirectory);
        printList();
    }

    public void changeDirectoryLevelUp() {
        assignCurrentDirectoryToLevelUp();
        printList();
    }

    private void printList() {
        try {
            Map<Boolean, List<Path>> directoriesAndFiles = Files.list(directory)
                    .collect(Collectors.partitioningBy(path -> Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)));
            directoriesAndFiles.get(Boolean.TRUE).stream().sorted().forEach(System.out::println);
            directoriesAndFiles.get(Boolean.FALSE).stream().sorted().forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    private void assignCurrentDirectoryFromString(String targetDirectory) {
        Path path = definePath(targetDirectory);
        if (Files.isDirectory(path)) {
            directory = path;
        } else {
            System.out.println("Not a directory");
        }
    }

    private Path definePath(String targetDirectory) {
        Path path;
        if (Paths.get(targetDirectory).isAbsolute()) {
            path = Paths.get(targetDirectory);
        } else {
            path = Paths.get(directory.toString(), targetDirectory);
        }
        return path;
    }

    private void assignCurrentDirectoryToLevelUp() {
        if (Objects.equals(directory.getRoot(), directory)) {
            System.out.println("Warning current directory is already root");
        } else {
            directory = directory.getParent();
        }
    }


    public void printTextFileFromCurrentDirectory(String filename) {
        Optional<Path> maybeTargetFile = getFilePath(filename);
        if (maybeTargetFile.isPresent() && Files.isReadable(maybeTargetFile.get())) {
            try (BufferedReader in = new BufferedReader(new FileReader(maybeTargetFile.get().toFile()))) {
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("error: " + e.getMessage());
            }
        }
    }

    private Optional<Path> getFilePath(String targetFile) {
        Optional<Path> maybePath;
        try {
            Map<Boolean, List<Path>> directoriesAndFiles = Files.list(directory)
                    .collect(Collectors.partitioningBy(path -> Files.isRegularFile(path, LinkOption.NOFOLLOW_LINKS)));
            maybePath = directoriesAndFiles.get(Boolean.TRUE)
                    .stream()
                    .filter(path -> path.getFileName().toString().equals(targetFile))
                    .findFirst();
            if (!maybePath.isPresent()) {
                System.out.println("No such file in current directory");
            }
            return maybePath;
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
        return Optional.empty();
    }
}
