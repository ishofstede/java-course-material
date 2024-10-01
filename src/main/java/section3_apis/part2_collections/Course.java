package section3_apis.part2_collections;

import java.util.HashMap;
import java.util.Objects;

/**
 * YOUR CHALLENGE:
 * Class Course models a teaching course. How are you going to store the students grades in here?
 */
public class Course {
    private String courseId;
    private HashMap<Integer, Double> grades = new HashMap<>();

    public Course(final String courseId) {
        this.courseId = courseId;
    }

    public void addGrade(double grade, int studentId){
        grades.put(studentId, grade);
    }


    public String getCourseId() {
        return this.courseId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final Course course = (Course) o;
        return this.courseId.equals(course.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.courseId);
    }
}
