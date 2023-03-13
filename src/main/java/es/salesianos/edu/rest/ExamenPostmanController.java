package es.salesianos.edu.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.salesianos.edu.model.Alumnos;

@RestController
@RequestMapping(path = "/api")
public class ExamenPostmanController {

    List<Alumnos> listAlumnos = new ArrayList<>();

    @PostMapping(path = "/ALUMNOS/LIST", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Alumnos>> listAlumnos() {
        return new ResponseEntity<>(listAlumnos, HttpStatus.OK);
    }

    @PostMapping(path = "/ALUMNOS/INSERT", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Alumnos> insertAlumnos(@RequestBody Alumnos alumno) {
        
        if (alumno.getId() == 0) {
            alumno.setId(listAlumnos.size());
        }

        listAlumnos.add(alumno);
        return new ResponseEntity<>(alumno, HttpStatus.CREATED);
    }

    @GetMapping(path = "/ALUMNOS/DELETE/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Alumnos> deleteAlumnos(@PathVariable int id) {
        Alumnos alumnoResult = listAlumnos.stream().filter(alumno -> alumno.getId() == id).findFirst().orElse(null);
        listAlumnos.removeIf(alumno -> alumno.getId() == id);
        return new ResponseEntity<>(alumnoResult, HttpStatus.OK);
    }

}
