package projeto.labmedicalbackend.services;

import org.springframework.stereotype.Service;
import projeto.labmedicalbackend.controllers.dtos.endereco.EnderecoBuscarDTO;
import projeto.labmedicalbackend.controllers.dtos.endereco.EnderecoCriarDTO;
import projeto.labmedicalbackend.mappers.EnderecoMapper;
import projeto.labmedicalbackend.models.Endereco;
import projeto.labmedicalbackend.repositories.EnderecoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {
    private final EnderecoRepository repository;
    private final EnderecoMapper mapper;

    public EnderecoService(EnderecoRepository repository, EnderecoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Endereco salvarEndereco(EnderecoCriarDTO request) {
        return repository.save(mapper.map(request));
    }

    public List<EnderecoBuscarDTO> procurarEnderecos() {
        return repository.findAll().stream().map(
                        endereco -> mapper.map(endereco))
                        .collect(Collectors.toList());
    }
}
