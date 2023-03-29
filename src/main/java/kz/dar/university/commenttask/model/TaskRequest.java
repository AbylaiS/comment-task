package kz.dar.university.commenttask.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskRequest {

    private String taskId;
    private String initiatorId;
    private String executorId;
    private String description;

}
