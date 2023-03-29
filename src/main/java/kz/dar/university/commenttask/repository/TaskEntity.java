package kz.dar.university.commenttask.repository;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "comment-task")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskEntity {
    @Id
    @Field(type = FieldType.Keyword)
    private String taskId;
    @Field(type = FieldType.Keyword)
    private String initiatorId;
    @Field(type = FieldType.Keyword)
    private String executorId;
    @Field(type = FieldType.Text)
    private String description;
}
