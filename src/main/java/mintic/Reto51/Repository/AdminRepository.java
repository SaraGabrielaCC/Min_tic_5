package mintic.Reto51.Repository;

import mintic.Reto51.Entities.Admin;
import mintic.Reto51.Entities.Client;
import mintic.Reto51.Repository.CrudRepository.AdminCrudRepository;
import mintic.Reto51.Repository.CrudRepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {

    @Autowired
    private AdminCrudRepository adminCrudRepository;

    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }
    public Optional<Admin> getAdmin(int id){
        return adminCrudRepository.findById(id);
    }
    public Admin save(Admin admin){
        return adminCrudRepository.save(admin);
    }
    public void delete(Admin admin){
        adminCrudRepository.delete(admin);
    }
}
