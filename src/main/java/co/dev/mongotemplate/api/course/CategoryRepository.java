package co.dev.mongotemplate.api.course;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category ,String> {
}
