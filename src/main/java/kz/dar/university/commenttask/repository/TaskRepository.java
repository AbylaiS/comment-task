package kz.dar.university.commenttask.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends ElasticsearchRepository<TaskEntity ,String> {

    TaskEntity getTaskEntityByTaskId(String taskId);

    Page<TaskEntity> getTaskEntitiesByInitiatorId(String initiatorId , Pageable pageable);

    Page<TaskEntity> getTaskEntitiesByExecutorId(String executorId , Pageable pageable);

    void deleteTaskEntityByTaskId(String taskId);



}
