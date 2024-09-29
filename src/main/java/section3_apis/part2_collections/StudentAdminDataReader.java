package section3_apis.part2_collections;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * This class has all basic file reader functionality.
 * There are two methods you need to implement:
 * The processLine() method of both LineHandlers.
 */
public class StudentAdminDataReader {

    private StudentAdmin studentAdmin;

    public StudentAdmin importAll(String studentsFile, String courseResultsFile) {
        this.studentAdmin = new StudentAdmin();
        readStudents(studentsFile);
        readCourseResults(courseResultsFile);

        return studentAdmin;
    }

    private void readStudents(String studentsFile) {
        Path filePath = initFile(studentsFile);
        readFile(filePath, new StudentLineHandler());

    }

    private void readCourseResults(String courseResultsFile) {
        Path filePath = initFile(courseResultsFile);
        readFile(filePath, new CoursesLineHandler());
    }

    private void readFile(Path filePath, LineHandler lineHandler) {
        int lineCount = 0;
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                if (lineCount == 1) continue;
                lineHandler.processLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Path initFile(String fileName) {
        Path path = Paths.get(fileName);
        File file = path.toFile();
        if (! (file.exists() && file.canRead())) {
            throw new IllegalArgumentException("file " + file + " does not exist or is not readable.");
        }
        return path;
    }

    private interface LineHandler {
        void processLine(String line);
    }

    /**
     * processes each line of the file students.txt
     */
    private class StudentLineHandler implements LineHandler {
        @Override
        public void processLine(String line) {
            String[] elements = line.split("\t");
            System.out.println(Arrays.toString(elements));
            //-------------------  YOUR CODE HERE   -------------------//
            //assign each element to
            int studentId = Integer.parseInt(elements[0]);
            String firstName = elements[1];
            String lastName = elements[2];

            //Create new student instance.
            Student student = new Student(studentId, firstName, lastName);
            //add to student admin
            studentAdmin.getStudents(student);
        }
    }

    /**
     * processes each line of the file courses.csv
     */
    private class CoursesLineHandler implements LineHandler {
        @Override
        public void processLine(String line) {
            String[] elements = line.split(";");
            System.out.println(Arrays.toString(elements));
            //-------------------  YOUR CODE HERE   -------------------//
            String courseId = elements[0];
            int studentId = Integer.parseInt(elements[1]);
            int studentGrade = Integer.parseInt(elements[2]);

            Course course = new Course(courseId, studentId, studentGrade);
            studentAdmin.addGrade(course);
        }
    }


    public static void main(String[] args) {
        StudentAdminDataReader dataReader = new StudentAdminDataReader();
        dataReader.importAll("data/students.txt", "data/courses.csv");
    }
}
