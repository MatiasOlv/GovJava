package service;

import entity.Emissao;
import exception.EmissaoNotFoundException;
import org.springframework.stereotype.Service;
import repository.EmissaoRepository;

import java.util.List;

@Service
public class EmissaoService {

    private final EmissaoRepository repository;

    // Injeção via construtor (boa prática)
    public EmissaoService(EmissaoRepository repository) {
        this.repository = repository;
    }

    public List<Emissao> listarTodas() {
        return repository.findAll();
    }

    public Emissao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmissaoNotFoundException("Emissão com ID " + id + " não encontrada."));
    }

    public Emissao criar(Emissao emissao) {
        return repository.save(emissao);
    }

    public Emissao atualizar(Long id, Emissao emissao) {
        // Verifica se existe uma emissão com o ID informado
        if (!repository.existsById(id)) {
            throw new EmissaoNotFoundException("Emissão com ID " + id + " não encontrada para atualização.");
        }
        emissao.setId(id); // Lombok já gera o setId()
        return repository.save(emissao);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new EmissaoNotFoundException("Emissão com ID " + id + " não encontrada para exclusão.");
        }
        repository.deleteById(id);
    }
}
