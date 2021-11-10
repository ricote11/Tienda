package tienda.daniel.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tienda.daniel.models.Categorias;
import tienda.daniel.models.Detalles_pedido;
import tienda.daniel.models.Productos;
import tienda.daniel.services.CategoriasService;
import tienda.daniel.services.ProductosServices;

@Controller
@RequestMapping("")
public class IndexController {
	
	@Autowired
	private ProductosServices serProductos;
	
	
	
	@Autowired
	private CategoriasService serCategorias;
	

	private ArrayList<Productos> productos = new ArrayList<Productos>();
	protected static String rutaBase = "/";
	protected static boolean carritoBool = true;

	/*
	 * 
	 * @GetMapping("/lista") public String saludoPersona2(Model model) { //Contacto
	 * c = new Contacto("Pepe", "perez", "567y"); model.addAttribute("product",
	 * listaProductos);
	 * 
	 * return "vProducto"; }
	 
	public ArrayList<Productos> listaProductos() {
		ArrayList<Productos> lista = new ArrayList<Productos>();
		Productos c = new Productos("movil", "electronica", 57, 12);
		lista.add(c);
		c = new Productos("ordenador", "electronica", 57, 12);
		lista.add(c);
		c = new Productos("tablet", "electronica", 57, 12);
		lista.add(c);
		c = new Productos("taza", "electronica", 57, 12);
		lista.add(c);
		c = new Productos("mesa", "electronica", 57, 12);
		lista.add(c);
		c = new Productos("agua", "electronica", 57, 12);
		lista.add(c);
		return lista;
	}

	private void iniciaCarrito(HttpSession sesion) {
		ArrayList<Productos> carrito = new ArrayList<Productos>();

		sesion.setAttribute("carrito", carrito);
		carritoBool = false;

	}

	@GetMapping("")
	public String goIndex(Model model, HttpSession sesion) {

		// Usuarios user = (Usuarios)model.asMap().get("user");

		if (carritoBool) {
			iniciaCarrito(sesion);
		}
		model.addAttribute("product", listaProductos);
		redireccion = "/";
		return "index";
	}
*/
	private void iniciaCarrito(HttpSession sesion) {
		//ArrayList<ProductosPedido> carrito = new ArrayList<ProductosPedido>();
		ArrayList<Detalles_pedido> carrito = new ArrayList<Detalles_pedido>();
		//log.info("Iniciando carrito");
		sesion.setAttribute("carrito",carrito);
		carritoBool=false;
	}
	
	
	@GetMapping("")
	public String goIndex(Model model,HttpSession sesion) {
		List<Categorias> categorias = serCategorias.getListaCategorias();
		sesion.setAttribute("categorias", categorias);
		//Usuarios user = (Usuarios)model.asMap().get("user");
		if(carritoBool) {
			iniciaCarrito(sesion);
		}
		rutaBase="/";
		List<Productos> prod = (List<Productos>)serProductos.getListaProductos();
		
		rellenaProductos(prod);
		//model.addAttribute(prod.get(0))
		
		model.addAttribute("productos",productos);
		return "index";
	}
	
	public void rellenaProductos(List<Productos> prod) {
		productos.clear();
		for(int i=0;i<prod.size();i++) {
			Productos product = prod.get(i);
			
			/*double val = calculaMedia(product);
			ProductosVal nuevo = new ProductosVal(product,val);*/
			productos.add(product);
			//productos.add(nuevo);
		}
		//log.info("Productos rellenados");
	}
	
	@GetMapping("/Tienda_Daniel_Ricote_Mompo")
	public String volverIndex(Model model,HttpSession sesion)
	{
		return "redirect:" + IndexController.rutaBase;
		
		
	}
	/*
	public Productos getProductoFromId(String nombre) {

		Productos nuevo = new Productos();
		for (Productos productos : listaProductos) {
			if (productos.getNombre().equals(nombre)) {
				nuevo = productos;
			}
		}
		return nuevo;
	}*/
	
	@GetMapping("operaciones")
	public String verOperaciones(Model model, HttpSession sesion)
	{
		return "operaciones/operaciones";
		
	}
	

}
