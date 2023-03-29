package kz.dar.university.commenttask.controller;

import kz.dar.university.commenttask.model.TaskRequest;
import kz.dar.university.commenttask.model.TaskResponse;
import kz.dar.university.commenttask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/check")
    public String check(){
        return "comment-task is working";
    }

    @PostMapping
    public TaskResponse createTask(@RequestBody TaskRequest taskRequest){
        return taskService.createTask(taskRequest);
    }

    @PutMapping
    public TaskResponse updateTask(@RequestParam String taskId, @RequestBody TaskRequest taskRequest){
        taskRequest.setTaskId(taskId);
        return taskService.updateTask(taskRequest);
    }

    @GetMapping("/initiator")
    public Page<TaskResponse> getTasksByInitiator(@RequestParam String initiatorId, Pageable pageable){
        return taskService.getTasksByInitiatorId(initiatorId , pageable);
    }

    @GetMapping("/executor")
    public Page<TaskResponse> getTaskByExecutor(@RequestParam String executorId, Pageable pageable){
        return taskService.getTasksByExecutorId(executorId, pageable);
    }

    @DeleteMapping
    public void deleteTask(@RequestParam String taskId){
        taskService.deleteTask(taskId);
    }

}
