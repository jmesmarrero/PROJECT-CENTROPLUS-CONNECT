package es.ies.puerto.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import es.ies.puerto.repositories.IActividadRepository;


@ExtendWith(MockitoExtension.class)
public class ActividadServiceTest {

    IActividadService actividadServicio;

    @Mock
    IActividadRepository actividadRepositoryMock;

    @BeforeEach
    void setup() {
        // actividadServicio = new ActividadServiceImpl();
        // actividadRepository = new
    }

}
