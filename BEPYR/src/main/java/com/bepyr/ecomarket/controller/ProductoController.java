package com.bepyr.ecomarket.controller;

import com.bepyr.ecomarket.model.Producto;
import com.bepyr.ecomarket.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return service.guardarProducto(producto);
    }

    @GetMapping
    public List<Producto> listar() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Producto obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        return service.actualizar(id, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}