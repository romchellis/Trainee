package training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JavaCourse {

    @Test
    @DisplayName("Am i java senior engineer")
    void senior_engineer_test() {
        Assertions.fail("Seems like not yet", new NotEnoughLearningException("Learn headbridge course first"));
    }

    static class NotEnoughLearningException extends RuntimeException {

        public NotEnoughLearningException(String message) {
            super(message);
        }
    }
}
