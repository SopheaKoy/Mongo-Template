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
@Document(collection = "categoryDB")
public class Category {
    @MongoId
    private String id;
    private String categoryName;
}
