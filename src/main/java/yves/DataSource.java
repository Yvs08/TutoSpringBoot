package yves;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="datasource")
public class DataSource {

    @Id
    private String id;

    private String description;
    private String code;	
    private String url;
    private String utilisateur;	
    private String motDePasse;
    private String driverJdbc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getDriverJdbc() {
        return driverJdbc;
    }

    public void setDriverJdbc(String driverJdbc) {
        this.driverJdbc = driverJdbc;
    }

    @Override
    public String toString() {
        return "DataSource{" + "id=" + id + ", description=" + description + ", code=" + code + ", url=" + url + ", utilisateur=" + utilisateur + ", motDePasse=" + motDePasse + ", driverJdbc=" + driverJdbc + '}';
    }

    

    

    

   

    

    

   

    
}