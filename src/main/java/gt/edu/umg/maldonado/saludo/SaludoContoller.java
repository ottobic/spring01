package gt.edu.umg.maldonado.saludo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "/api/umg/")
public class SaludoContoller {

    private static final String template = "Hola, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, value = "/saludo")
    public Saludo saludo(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Saludo(counter.incrementAndGet(),String.format(template,name));
    }

}
