package DAO;

import java.util.List;
import java.util.Optional;


public interface Dao<Personne> {
    
    Optional<Personne> get(long id);
    
    List<Personne> getAll();
    
    void save(Personne t);
    
    void update(Personne t, String[] params);
    
    void delete(Personne t);
}
