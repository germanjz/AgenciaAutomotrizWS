package mx.com.example.converter;

import java.util.ArrayList;
import java.util.List;

import mx.com.example.entity.Automovil;
import mx.com.example.entity.MarcaAutomovil;
import mx.com.example.entity.ModeloAutomovil;
import mx.com.example.ws.request.AutomovilRequest;
import mx.com.example.ws.request.MarcaAutomovilRequest;
import mx.com.example.ws.request.ModeloAutomovilRequest;
import mx.com.example.ws.response.AutomovilResponse;
import mx.com.example.ws.response.MarcaAutomovilResponse;
import mx.com.example.ws.response.ModeloAutomovilResponse;

/**
 * 
 * @author German Juarez
 *
 */
public class AutomovilConverter {

	/**
	 * 
	 */
	private AutomovilConverter() {
		super();
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public static Automovil convert2Automovil(final AutomovilRequest request, final ModeloAutomovil modelo) {
		Automovil automovil = new Automovil();
		
		automovil.setModelo(modelo);
		automovil.setColor(request.getColor());
		automovil.setPrecio(request.getPrecio());
		
		return automovil;
	}
	
	/**
	 * 
	 * @param request
	 * @param automovil
	 */
	public static void setAutomovilUpdate(final AutomovilRequest request, final Automovil automovil, final ModeloAutomovil modelo) {
		automovil.setModelo(modelo);
		automovil.setColor(request.getColor());
		automovil.setPrecio(request.getPrecio());
	}

	/**
	 * 
	 * @param automovil
	 * @return
	 */
	public static AutomovilResponse convert2Response(final Automovil automovil) {
		AutomovilResponse response = new AutomovilResponse();
		
		response.setId(automovil.getId());
		response.setIdMarca(automovil.getModelo().getMarca().getId());
		response.setMarca(automovil.getModelo().getMarca().getMarca());
		response.setIdModelo(automovil.getModelo().getId());
		response.setModelo(automovil.getModelo().getModelo());
		response.setAnio(automovil.getModelo().getAnio());
		response.setColor(automovil.getColor());
		response.setPrecio(automovil.getPrecio());
		response.setMsgError("Respuesta OK!");
		response.setCode(0);
		
		return response;
	}

	public static List<AutomovilResponse> convert2Response(final List<Automovil> listaAutomoviles) {
		List<AutomovilResponse> listaResponse = new ArrayList<>();
		
		for (Automovil automovil : listaAutomoviles) {
			AutomovilResponse response = convert2Response(automovil);
			listaResponse.add(response);
		}
		
		return listaResponse;
	}

	public static MarcaAutomovil convert2Marca(final MarcaAutomovilRequest request) {
		MarcaAutomovil marca = new MarcaAutomovil();
		marca.setMarca(request.getMarca());
		return marca;
	}

	public static MarcaAutomovilResponse convert2MarcaResponse(final MarcaAutomovil marca) {
		MarcaAutomovilResponse response = new MarcaAutomovilResponse();
		
		response.setId(marca.getId());
		response.setMarca(marca.getMarca());
		response.setCode(0);
		response.setMsgError("Respuesta OK!");
		
		return response;
	}

	public static List<MarcaAutomovilResponse> convert2MarcaResponse(final List<MarcaAutomovil> listaMarcas) {
		List<MarcaAutomovilResponse> listResponse = new ArrayList<>();
		
		for (MarcaAutomovil marca : listaMarcas) {
			listResponse.add(new MarcaAutomovilResponse(marca.getId(), marca.getMarca()));
		}
		
		return listResponse;
	}

	public static ModeloAutomovil convert2Modelo(final ModeloAutomovilRequest request, final MarcaAutomovil marca) {
		ModeloAutomovil modelo = new ModeloAutomovil();
		
		modelo.setAnio(request.getAnio());
		modelo.setModelo(request.getModelo());
		modelo.setMarca(marca);
		
		return modelo;
	}

	public static void convert2ModeloUpdate(final ModeloAutomovilRequest request, final ModeloAutomovil modelo, final MarcaAutomovil marca) {
		modelo.setAnio(request.getAnio());
		modelo.setModelo(request.getModelo());
		modelo.setMarca(marca);
	}
	
	public static ModeloAutomovilResponse convert2Modeloesponse(final ModeloAutomovil modelo) {
		MarcaAutomovilResponse marca = new MarcaAutomovilResponse(modelo.getMarca().getId(), modelo.getMarca().getMarca(), 0);
		return new ModeloAutomovilResponse(modelo.getId(), modelo.getModelo(), modelo.getAnio(), marca);	
	}

	public static List<ModeloAutomovilResponse> convert2ModeloResponse(final List<ModeloAutomovil> listaMarcas) {
		List<ModeloAutomovilResponse> listaResponse = new ArrayList<>();
		
		for (ModeloAutomovil marca : listaMarcas) {
			ModeloAutomovilResponse response = convert2Modeloesponse(marca);
			listaResponse.add(response);
		}
		
		return listaResponse;
	}
}
