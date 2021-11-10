package tienda.daniel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tienda.daniel.models.Configuracion;



public interface ConfiguracionRepository extends JpaRepository<Configuracion,Integer>{

	Configuracion findByClave(String clave);
}
