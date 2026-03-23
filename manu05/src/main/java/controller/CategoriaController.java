package controller;
import models.CategoriaModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import services.CategoriaService;
import java.net.URI;
import java.util.Optional;
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaModel>> findAll(){
        List<CategoriaModel> categoria = categoriaService.findAll();
        return ResponseEntity.ok().body(categoria);
    }
    @PostMapping
    public ResponseEntity<CategoriaModel> criar (@RequestBody CategoriaModel categoriaModel){
        CategoriaModel categoria = categoriaService.criarCategoria(categoriaModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoriaModel.getId()).toUri();
        return ResponseEntity.created(uri).body(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id){
        categoriaService.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional<CategoriaModel> findById(@PathVariable Long id){
        return categoriaService.findById(id);
    }

}
