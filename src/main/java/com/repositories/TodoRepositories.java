
package com.repositories;

import com.data.Todo;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface TodoRepositories extends MongoRepository<Todo, String>  {
    
    public List<Todo> findByUrl(String titre);
    
}
