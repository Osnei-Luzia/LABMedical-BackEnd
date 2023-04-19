package projeto.labmedicalbackend.services;

import org.springframework.stereotype.Service;
import projeto.labmedicalbackend.controllers.dtos.endereco.ResponseBuscarEnderecoDTO;
import projeto.labmedicalbackend.controllers.dtos.endereco.RequestCriarEnderecoDTO;
import projeto.labmedicalbackend.services.mappers.EnderecoMapper;
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

    public Endereco salvarEndereco(RequestCriarEnderecoDTO request) {
        return repository.save(mapper.map(request));
    }

    public List<ResponseBuscarEnderecoDTO> procurarEnderecos() {
        return repository.findAll().stream().map(
                        endereco -> mapper.map(endereco))
                        .collect(Collectors.toList());
    }
}
