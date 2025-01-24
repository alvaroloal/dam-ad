package com.salesianos.herencia.mappedSuperClassv2;


import com.salesianos.herencia.mappedSuperClassv2.model.Cliente;
import com.salesianos.herencia.mappedSuperClassv2.model.Empleado;
import com.salesianos.herencia.mappedSuperClassv2.repos.ClienteRepository;
import com.salesianos.herencia.mappedSuperClassv2.repos.EmpleadoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeed2 {

    private final EmpleadoRepository empleadoRepository;
    private final ClienteRepository clienteRepository;

    @PostConstruct
    public void run(){

        Empleado empleado = new Empleado();
        empleado.setNombre("Manuel");
        empleado.setEdad(19);
        empleado.setPuesto("Jefe departamento");
        empleado.setSueldo(2000);

        empleadoRepository.save(empleado);

        Cliente cliente = new Cliente();
        cliente.setNombre("Álvaro");
        cliente.setEdad(19);
        cliente.setNumeroCliente("123456");
        cliente.setDineroGastado(800);

        clienteRepository.save(cliente);

        System.out.println(cliente + " Dinero gastado: " + cliente.getDineroGastado());
        System.out.println(empleado + " Sueldo: " + empleado.getSueldo());
        System.out.println();
    }
}
