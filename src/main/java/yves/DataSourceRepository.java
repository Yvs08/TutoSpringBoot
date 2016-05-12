/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yves;


import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
    

public interface DataSourceRepository extends MongoRepository<DataSource, String> 
{

    public DataSource findByDescription(String Description);
    public List<DataSource> findByUrl(String Url);
    

}
    

