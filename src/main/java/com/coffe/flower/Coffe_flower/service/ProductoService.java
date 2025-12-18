package com.coffe.flower.Coffe_flower.service;

import com.coffe.flower.Coffe_flower.model.Producto;
import com.coffe.flower.Coffe_flower.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Listar productos con filtro opcional de categoría
    public List<Producto> listar(String categoria) {
        if (categoria != null && !categoria.isEmpty()) {
            return productoRepository.findByCategoriaNombreIgnoreCase(categoria);
        }
        return productoRepository.findAll();
    }

    // Método para filtrar por categoría, tipo de leche y tamaño
    public List<Producto> listarFiltros(String categoria, String tipoLeche, String tamano) {
        if (categoria != null && tipoLeche != null && tamano != null) {
            return productoRepository.findByCategoriaNombreIgnoreCaseAndTipoLecheNombreIgnoreCaseAndTamanoNombreIgnoreCase(
                    categoria, tipoLeche, tamano
            );
        }
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerPorId(Long id) {
        return productoRepository.findById(id);
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> actualizar(Long id, Producto producto) {
        return productoRepository.findById(id).map(p -> {
            p.setNombre(producto.getNombre());
            p.setDescripcion(producto.getDescripcion());
            p.setPrecioBase(producto.getPrecioBase());
            p.setStock(producto.getStock());
            p.setCategoria(producto.getCategoria());
            p.setTipoLeche(producto.getTipoLeche());
            p.setTipoGrano(producto.getTipoGrano());
            p.setTipoBebida(producto.getTipoBebida());
            p.setTamano(producto.getTamano());
            p.setTemperatura(producto.getTemperatura());
            p.setEndulzante(producto.getEndulzante());
        
            p.setEtiquetas(producto.getEtiquetas());
            
            return productoRepository.save(p);
        });
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
}
