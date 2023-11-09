package co.dev.mongotemplate.api.course;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@Setter
@Getter
@Builder
@Document(collection = "courseDB")
public class Course {
    @MongoId
    private String id ;
    private String name;
    private String description;
    private List<Category> categoryList;
}
