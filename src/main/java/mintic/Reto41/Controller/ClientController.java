package mintic.Reto41.Controller;

import mintic.Reto41.Entities.Client;
import mintic.Reto41.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class ClientController {

    @Autowired
    private ClientService clientService;
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/all")
    public List<Client> getClients(){
        return clientService.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int clientId) {
        return clientService.getClient(clientId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Client update(@RequestBody Client client) {
        return clientService.update(client);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return clientService.deleteClient(id);
    }
}
