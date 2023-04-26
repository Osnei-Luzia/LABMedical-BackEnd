package projeto.labmedicalbackend.services.mappers;

import org.mapstruct.*;
import projeto.labmedicalbackend.controllers.dtos.usuario.RequestAtualizarSenhaDTO;
import projeto.labmedicalbackend.controllers.dtos.usuario.RequestAtualizarUsuarioDTO;
import projeto.labmedicalbackend.controllers.dtos.usuario.RequestCriarUsuarioDTO;
import projeto.labmedicalbackend.models.Usuario;
import projeto.labmedicalbackend.models.enums.Especializacao;
import projeto.labmedicalbackend.models.enums.EstadoCivil;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING , unmappedTargetPolicy = ReportingPolicy.IGNORE,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UsuarioMapper {
    //@Mapping(source = "dataNascimento", target = "dataNascimento", dateFormat = "dd/MM/yyyy")
    Usuario map(RequestCriarUsuarioDTO source);
    void update(@MappingTarget Usuario target, RequestAtualizarUsuarioDTO source);
    void update(@MappingTarget Usuario target, RequestAtualizarSenhaDTO source);
}

