package taskManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import taskManagement.enums.TaskStatus;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private int id;
    private String title;
    private String description;
    private TaskStatus status;
    private User user;
    private Date deadline;
}
