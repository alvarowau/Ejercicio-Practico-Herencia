package org.alvarowau.ejerciciopracticoherencia.Commandlinerunner;

import org.alvarowau.ejerciciopracticoherencia.model.Address;
import org.alvarowau.ejerciciopracticoherencia.model.Employee;
import org.alvarowau.ejerciciopracticoherencia.model.Engineer;
import org.alvarowau.ejerciciopracticoherencia.model.Manager;
import org.alvarowau.ejerciciopracticoherencia.repository.EmployeeRepository;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class EmployeeCommandLineRunner implements CommandLineRunner {

    private final EmployeeRepository repository;
    private final Logger log = Logger.getLogger(EmployeeCommandLineRunner.class.getName());



    public EmployeeCommandLineRunner(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        Engineer engineer1 = new Engineer(1L, "alvaro", "wau", "alvarowau@company.com", new Address("123 Elm St", "CityF", "CountryF", "99887"), "Software Engineering", 5, "Java, Kotlin", "Certified Java Developer");
        repository.save(engineer1);
        Engineer engineer2 = new Engineer(2L, "Santiago", "Fernández", "santiago.fernandez@company.com", new Address("789 Cedar St", "CityG", "CountryG", "33221"), "Network Engineering", 7, "Python, Bash", "CCNA");
        repository.save(engineer2);
        Engineer engineer3 = new Engineer(3L, "Sofía", "Jiménez", "sofia.jimenez@company.com", new Address("456 Spruce St", "CityH", "CountryH", "99876"), "DevOps", 3, "Docker, Kubernetes", "AWS Certified Solutions Architect");
        repository.save(engineer3);
        Engineer engineer4 = new Engineer(4L, "Andrés", "Ruiz", "andres.ruiz@company.com", new Address("321 Cypress St", "CityI", "CountryI", "55443"), "Database Engineering", 10, "SQL, NoSQL", "Oracle Certified Professional");
        repository.save(engineer4);
        Engineer engineer5 = new Engineer(5L, "Elena", "Morales", "elena.morales@company.com", new Address("654 Redwood St", "CityJ", "CountryJ", "11234"), "Cloud Engineering", 8, "Azure, AWS", "Google Cloud Certified");
        repository.save(engineer5);

        Manager manager1 = new Manager(1L, "Carlos", "González", "carlos.gonzalez@company.com", new Address("123 Main St", "CityA", "CountryA", "12345"), 10, "IT", 50000.0, 15);
        repository.save(manager1);
        Manager manager2 = new Manager(2L, "Lucía", "Martínez", "lucia.martinez@company.com", new Address("456 Oak St", "CityB", "CountryB", "54321"), 8, "HR", 40000.0, 10);
        repository.save(manager2);
        Manager manager3 = new Manager(3L, "Juan", "Pérez", "juan.perez@company.com", new Address("789 Pine St", "CityC", "CountryC", "67890"), 12, "Finance", 60000.0, 20);
        repository.save(manager3);
        Manager manager4 = new Manager(4L, "Ana", "López", "ana.lopez@company.com", new Address("321 Maple St", "CityD", "CountryD", "11223"), 15, "Marketing", 70000.0, 25);
        repository.save(manager4);
        Manager manager5 = new Manager(5L, "Miguel", "Rodríguez", "miguel.rodriguez@company.com", new Address("654 Birch St", "CityE", "CountryE", "44556"), 20, "Operations", 90000.0, 30);
        repository.save(manager5);


        findEmployeeView();

        log.log(Level.INFO, "Buscar Empleado que funciona");
        //buscar empleado que si existe
        findEmployees(2l);
        //buscar empleado que no funciona
        findEmployees(123L);

        //borrar empleado
        log.log(Level.INFO, "Eliminar empleado");
        repository.deleteById(manager4.getId());

        //mostrar empleados que quedan en la base de datos
        findEmployeeView();

        //borrado de todos los empleados que quedan en la base de datos
        deleteAllEmployees();

    }

    private void findEmployees(Long id) {
        log.log(Level.INFO, "Buscando empleado con ID: " + id);
        Optional<Employee> employee = repository.findById(id);

        employee.ifPresentOrElse(
                emp -> log.log(Level.INFO, "Empleado encontrado: " + emp.toString()),
                () -> log.log(Level.SEVERE, "No se encontró el empleado con ID: " + id)
        );
    }

    private void findEmployeeView(){
        log.log(Level.INFO, "Lista de empleados: ");
        for(Employee e : repository.findAll()) {
            log.log(Level.INFO, e.toString());
        }
    }

    private void deleteAllEmployees() {
        log.log(Level.INFO, "Eliminando empleados: ");
        for(Employee e : repository.findAll()) {
            log.log(Level.INFO, "Eliminando empleado : " + e.getName());
            repository.delete(e);
        }
    }
}
