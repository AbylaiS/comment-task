package kz.dar.university.commenttask.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.dar.university.commenttask.model.TaskRequest;
import kz.dar.university.commenttask.model.TaskResponse;
import kz.dar.university.commenttask.repository.TaskEntity;
import kz.dar.university.commenttask.repository.TaskRepository;
//import kz.dar.university.commenttask.service.send.SendService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TaskService implements ITaskService{

//    @Autowired
//    private SendService sendService;

    @Autowired
    private TaskRepository taskRepository;

    ObjectMapper objectMapper = new ObjectMapper();


    static  ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public TaskResponse createTask(TaskRequest taskRequest) {
        taskRequest.setTaskId(UUID.randomUUID().toString());

        TaskEntity taskEntity = modelMapper.map(taskRequest , TaskEntity.class);

        taskEntity = taskRepository.save(taskEntity);
        return modelMapper.map(taskEntity , TaskResponse.class);


    }

    @Override
    public TaskResponse updateTask(TaskRequest taskRequest) {

        TaskEntity taskEntity = modelMapper.map(taskRequest , TaskEntity.class);
        TaskEntity dbEntity = taskRepository.getTaskEntityByTaskId(taskRequest.getTaskId());


        dbEntity.setInitiatorId(taskRequest.getInitiatorId());
        dbEntity.setExecutorId(taskRequest.getExecutorId());
        dbEntity.setDescription(taskRequest.getDescription());

        taskEntity = taskRepository.save(dbEntity);

        return modelMapper.map(taskEntity , TaskResponse.class);
    }

    @Override
    public TaskResponse getTaskById(String taskId) {

        TaskEntity taskEntity = taskRepository.getTaskEntityByTaskId(taskId);
        return modelMapper.map(taskEntity , TaskResponse.class);
    }

    @Override
    public void deleteTask(String taskId) {

        taskRepository.deleteTaskEntityByTaskId(taskId);

    }

    @Override
    public Page<TaskResponse> getTasksByInitiatorId(String initiatorId, Pageable pageable) {
        return taskRepository.getTaskEntitiesByInitiatorId(initiatorId , pageable)
                .map(task -> modelMapper.map(task , TaskResponse.class) );
    }

    @Override
    public Page<TaskResponse> getTasksByExecutorId(String executorId, Pageable pageable) {
        return taskRepository.getTaskEntitiesByExecutorId(executorId, pageable)
                .map(task -> modelMapper.map(task , TaskResponse.class));
    }
}
