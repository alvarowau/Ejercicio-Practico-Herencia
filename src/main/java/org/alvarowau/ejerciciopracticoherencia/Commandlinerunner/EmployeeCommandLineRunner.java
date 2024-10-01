package org.alvarowau.ejerciciopracticoherencia.Commandlinerunner;

import org.alvarowau.ejerciciopracticoherencia.model.Address;
import org.alvarowau.ejerciciopracticoherencia.model.Employee;
import org.alvarowau.ejerciciopracticoherencia.model.Engineer;
import org.alvarowau.ejerciciopracticoherencia.model.Manager;
import org.alvarowau.ejerciciopracticoherencia.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;


@Component
public class EmployeeCommandLineRunner implements CommandLineRunner {

    private final EmployeeRepository repository;
    private final Logger log = Logger.getLogger(EmployeeCommandLineRunner.class.getName());


    public EmployeeCommandLineRunner(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {


        createEmployee();

        findEmployeeView();

        log.log(Level.INFO, "Buscar Empleado que funciona");
        //buscar empleado que si existe
        findEmployees(2l);
        //buscar empleado que no funciona
        findEmployees(123L);

        //borrar empleado
        log.log(Level.INFO, "Eliminar empleado");
        repository.deleteById(2L);

        //mostrar empleados que quedan en la base de datos
        findEmployeeView();

        //borrado de todos los empleados que quedan en la base de datos
        deleteAllEmployees();

    }


    private void createEmployee() {
        List<Employee> employees = List.of(
                new Engineer("alvaro", "wau", "alvarowau@company.com", new Address("123 Elm St", "CityF", "CountryF", "99887"), "Software Engineering", 5, "Java, Kotlin", "Certified Java Developer"),
                new Engineer("Santiago", "Fernández", "santiago.fernandez@company.com", new Address("789 Cedar St", "CityG", "CountryG", "33221"), "Network Engineering", 7, "Python, Bash", "CCNA"),
                new Engineer("Sofía", "Jiménez", "sofia.jimenez@company.com", new Address("456 Spruce St", "CityH", "CountryH", "99876"), "DevOps", 3, "Docker, Kubernetes", "AWS Certified Solutions Architect"),
                new Engineer("Andrés", "Ruiz", "andres.ruiz@company.com", new Address("321 Cypress St", "CityI", "CountryI", "55443"), "Database Engineering", 10, "SQL, NoSQL", "Oracle Certified Professional"),
                new Engineer("Elena", "Morales", "elena.morales@company.com", new Address("654 Redwood St", "CityJ", "CountryJ", "11234"), "Cloud Engineering", 8, "Azure, AWS", "Google Cloud Certified"),
                new Manager("Carlos", "González", "carlos.gonzalez@company.com", new Address("123 Main St", "CityA", "CountryA", "12345"), 10, "IT", 50000.0, 15),
                new Manager("Lucía", "Martínez", "lucia.martinez@company.com", new Address("456 Oak St", "CityB", "CountryB", "54321"), 8, "HR", 40000.0, 10),
                new Manager("Juan", "Pérez", "juan.perez@company.com", new Address("789 Pine St", "CityC", "CountryC", "67890"), 12, "Finance", 60000.0, 20),
                new Manager("Ana", "López", "ana.lopez@company.com", new Address("321 Maple St", "CityD", "CountryD", "11223"), 15, "Marketing", 70000.0, 25),
                new Manager("Miguel", "Rodríguez", "miguel.rodriguez@company.com", new Address("654 Birch St", "CityE", "CountryE", "44556"), 20, "Operations", 90000.0, 30)
        );

        repository.saveAll(employees);
    }


    private void findEmployees(Long id) {
        log.log(Level.INFO, "Buscando empleado con ID: " + id);
        Optional<Employee> employee = repository.findById(id);

        employee.ifPresentOrElse(
                emp -> log.log(Level.INFO, "Empleado encontrado: " + emp.toString()),
                () -> log.log(Level.SEVERE, "No se encontró el empleado con ID: " + id)
        );
    }

    private void findEmployeeView() {
        log.log(Level.INFO, "Lista de empleados: ");
        for (Employee e : repository.findAll()) {
            log.log(Level.INFO, e.toString());
        }
    }

    private void deleteAllEmployees() {
        log.log(Level.INFO, "Eliminando empleados: ");
        for (Employee e : repository.findAll()) {
            log.log(Level.INFO, "Eliminando empleado : " + e.getName());
            repository.delete(e);
        }
    }
}
