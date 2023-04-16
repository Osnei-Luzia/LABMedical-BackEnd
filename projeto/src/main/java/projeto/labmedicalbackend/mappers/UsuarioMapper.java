package projeto.labmedicalbackend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import projeto.labmedicalbackend.controllers.dtos.RequestCriarUsuarioDTO;
import projeto.labmedicalbackend.models.Usuario;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING , unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper {
    Usuario map(RequestCriarUsuarioDTO source);
}