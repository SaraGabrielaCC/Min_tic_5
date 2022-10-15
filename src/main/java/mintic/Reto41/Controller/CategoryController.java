package mintic.Reto41.Controller;

import mintic.Reto41.Entities.Category;
import mintic.Reto41.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/all")
    public List<Category> getCategory(){
        return categoryService.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int Id) {
        return categoryService.getCategory(Id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public Category save(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Category update(@RequestBody Category category){
        return categoryService.update(category);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return categoryService.deleteCategory(id);
    }
}
