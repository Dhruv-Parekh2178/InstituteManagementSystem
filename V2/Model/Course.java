package V2.Model;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of POJO Course Class
 *
 * @author dhruvparekh
 * @version 2.0
 *
 */

public class Course {
    private int courseId;
    private String courseName;
    private int tId;

    public Course(int courseId, String courseName, int tId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.tId = tId;
    }

    /**
     * This method return the courseId.
     *
     * @return courseId of the particular course.
     */

    public int getCourseId() {
        return courseId;
    }

    /**
     * This method Return the Teacher Object who is Teach particular course.
     *
     * @return Teacher Id
     */
    public int getTeacherId() {
        return tId;
    }

    /**
     * This methos return the Course Name.
     *
     * @return courseName of type String.
     */
    public String getCourseName() {
        return courseName;
    }

}