package gt.edu.umg.maldonado.saludo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "/api/umg/")
public class Saludo2Controller {

    private static final String template = "Hola, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE}, value = "/hello/{texto}")
    public ResponseEntity<Saludo> hello(@PathVariable String texto) {
        Saludo myRequest = new Saludo(counter.incrementAndGet(), String.format(template,texto));

        return new ResponseEntity<Saludo>(myRequest, HttpStatus.OK);
    }

}
