package com.kaeser.platform.u20211f955.inventory.domain.exceptions;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(Long courseId) {
        super("Course with Id " + courseId + "not found");
    }
}
