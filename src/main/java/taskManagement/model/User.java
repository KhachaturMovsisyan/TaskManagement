package taskManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import taskManagement.enums.UserType;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private UserType userType;

}
