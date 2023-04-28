package projeto.labmedicalbackend.services.mappers;

import org.mapstruct.*;
import projeto.labmedicalbackend.controllers.dtos.exame.RequestAtualizarExameDTO;
import projeto.labmedicalbackend.controllers.dtos.exame.RequestCriarExameDTO;
import projeto.labmedicalbackend.controllers.dtos.exame.ResponseBuscarExameDTO;
import projeto.labmedicalbackend.models.Exame;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING , unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ExameMapper {
    Exame map (RequestCriarExameDTO source);
    ResponseBuscarExameDTO map (Exame source);
    void update(@MappingTarget Exame target, RequestAtualizarExameDTO source);
}
