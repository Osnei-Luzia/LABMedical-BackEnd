package projeto.labmedicalbackend.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import projeto.labmedicalbackend.controllers.dtos.endereco.RequestCriarEnderecoDTO;
import projeto.labmedicalbackend.controllers.dtos.endereco.ResponseBuscarEnderecoDTO;
import projeto.labmedicalbackend.models.Endereco;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING , unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EnderecoMapper {
    Endereco map(RequestCriarEnderecoDTO source);
    ResponseBuscarEnderecoDTO map(Endereco source);
}
