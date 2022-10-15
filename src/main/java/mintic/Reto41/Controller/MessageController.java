package mintic.Reto41.Controller;

import mintic.Reto41.Entities.Message;
import mintic.Reto41.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MessageController {

    @Autowired
    private MessageService messageService;
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/all")
    public List<Message> getMessages(){
        return messageService.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int messageId) {
        return messageService.getMessage(messageId);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public Message save(@RequestBody Message message) {
        return messageService.save(message);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Message update(@RequestBody Message message) {
        return messageService.update(message);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return messageService.deleteMessage(id);
    }
}
