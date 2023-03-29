package kz.dar.university.commenttask.service;

import kz.dar.university.commenttask.model.TaskRequest;
import kz.dar.university.commenttask.model.TaskResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITaskService {

    TaskResponse createTask(TaskRequest taskRequest);

    TaskResponse updateTask(TaskRequest taskRequest);

    TaskResponse getTaskById(String taskId);

    void deleteTask(String taskId);

    Page<TaskResponse> getTasksByInitiatorId(String initiatorId , Pageable pageable);

    Page<TaskResponse> getTasksByExecutorId(String executorId, Pageable pageable);

}
