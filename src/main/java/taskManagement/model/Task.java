package taskManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import taskManagement.enums.TaskStatus;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private int id;
    private String name;
    private String description;
    private TaskStatus status;
    private User user;
}
