
package yves;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/datasource")
public class DatasourceServiceCtrl {
    
     private static final String SUCCESS_RESULT="<result>success</result>";
     private static final String FAILURE_RESULT="<result>failure</result>";
  
    
     @Autowired
    private DataSourceRepository  datasourceRepository;
       
       @RequestMapping(method = RequestMethod.GET)
        public DataSource gettoutcourt()
     {
         
     System.out.println("mauvaise URL");
     
     return null;

     }
     
        @RequestMapping(method = RequestMethod.GET, value="/{datasourceId}")
     public DataSource getDetails(@PathVariable("datasourceId") String datasourceId)
     {
         
     return datasourceRepository.findOne(datasourceId);

     }
     
      @RequestMapping(value="/delete/{datasourceId}",method = RequestMethod.DELETE )
     public void Detail(@PathVariable("datasourceId") String datasourceId)
     {
              datasourceRepository.delete(datasourceId);
     }
     
     @RequestMapping(value = "/adddatasource", method = RequestMethod.POST)
    public String create ( @RequestBody DataSource s ) {
     // DataSource datasource = new DataSource( );
      DataSource  result = datasourceRepository.save( s);
        
      if( result == null ){
         return FAILURE_RESULT; 
      }
      return SUCCESS_RESULT;
     
    }
}

