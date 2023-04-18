package projeto.labmedicalbackend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import projeto.labmedicalbackend.controllers.dtos.endereco.EnderecoBuscarDTO;
import projeto.labmedicalbackend.controllers.dtos.endereco.EnderecoCriarDTO;
import projeto.labmedicalbackend.models.Endereco;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING , unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EnderecoMapper {
    Endereco map(EnderecoCriarDTO source);
    EnderecoBuscarDTO map(Endereco source);
}
