package section3_apis.part2_collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * YOUR CHALLENGE:
 * This class only contains a so-called public API. There is no underlying code that supports the API.
 * It is your task to implement this logic. Using the right collection type(s).
 */
public class StudentAdmin {
    private HashMap<Integer, Student> students = new HashMap<>();
    private HashMap<String, Course> grades = new HashMap<>();


    public void addStudent (Student student) {
        students.put(student.getStudentId(), student);
    }

    public void addGrade(String courseId, int studentId, int studentGrade) {
        if (! grades.containsKey(courseId)) {
            Course course = new Course(courseId);
            grades.put(courseId, course);
        }
        grades.get(courseId).addGrade(studentId, studentGrade);

    }

    /**
     * Returns the students that are present in the database.
     * If the searchString is * (a wildcard), all students will be returned. Else,
     * a simple case insensitive substring match to both first name and family name will be performed.
     * @param searchString the substring string to look for
     * @return students
     */
    public List<Student> getStudents(String searchString) {
        if (searchString.equals("*")) {
            return new ArrayList<>(students.values());
        }

        return students.values().stream()
                .filter(s -> s.getFirstName().toLowerCase().contains(searchString.toLowerCase())
                        || s.getLastName().toLowerCase().contains(searchString.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Returns the grade of a student for the given course
     * @param student the student
     * @param course the course
     * @return grade
     */
    public double getGrade(Student student, Course course) {
        Course courseData = grades.get(course.getCourseId());
        if (courseData != null && courseData.getGrades().containsKey(student.getStudentId())) {
            return courseData.getGrades().get(student.getStudentId());
        }
        return -1;  // Default value if no grade found
    }

    /**
     * returns all grades for a student, as [key=CourseID]:[value=Grade] Map
     * @param student the student to fetch grades for
     * @return grades
     */
    public Map<String, Double> getGradesForStudent(Student student) {
        Map<String, Double> studentGrades = new HashMap<>();
        for (Map.Entry<String, Course> entry : grades.entrySet()) {
            String courseId = entry.getKey();
            Course course = entry.getValue();
            if (course.getGrades().containsKey(student.getStudentId())) {
                studentGrades.put(courseId, (Double) course.getGrades().get(student.getStudentId()));
            }
        }
        return studentGrades;
    }

    /**
     * Returns all grades for a course, as [key=Student]:[value=Grade] Map
     * @param course the course
     * @return grades
     */
    public Map<Student, Double> getGradesForCourse(Course course) {
        Map<Student, Double> courseGrades = new HashMap<>();
        Course courseData = grades.get(course.getCourseId());
        if (courseData != null) {
            courseData.getGrades().forEach((key, value) -> {
                Student student = students.get(key);
                courseGrades.put(student, (Double) value);
            });
        }
        return courseGrades;
    }

}
