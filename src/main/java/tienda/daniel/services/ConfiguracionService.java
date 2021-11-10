package tienda.daniel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienda.daniel.models.Configuracion;
import tienda.daniel.repositories.ConfiguracionRepository;

@Service
public class ConfiguracionService {

	@Autowired
	private ConfiguracionRepository config;

	public Configuracion getClave(String clave) {
		return config.findByClave(clave);
	}

	public void borrarConfiguracion(Configuracion con) {

		config.delete(con);
	}

	public void actualizarConfiguracion(Configuracion con) {
		config.save(con);
	}

}
