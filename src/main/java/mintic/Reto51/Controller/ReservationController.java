package mintic.Reto51.Controller;

import mintic.Reto51.Controller.DTOs.CompletedAndCancelled;
import mintic.Reto51.Controller.DTOs.TotalAndClient;
import mintic.Reto51.Entities.Reservation;
import mintic.Reto51.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservationService.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int reservationId) {
        return reservationService.getReservation(reservationId);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationService.update(reservation);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return reservationService.deleteReservation(id);
    }

    @GetMapping("/report-dates/{fecha1}/{fecha2}")
    public List<Reservation> getReservationsBetweenDatesReport(@PathVariable("fecha1") String fecha1, @PathVariable("fecha2") String fecha2) {
        return reservationService.getReservationsBetweenDatesReport(fecha1, fecha2);
    }
    @GetMapping("/report-status")
    public CompletedAndCancelled getReservationStatusReport(){
        return reservationService.getReservationStatusReport();
    }

    @GetMapping("/report-clients")
    public List<TotalAndClient> getTopClientsReport(){
        return reservationService.getTopClientsReport();
    }
}
