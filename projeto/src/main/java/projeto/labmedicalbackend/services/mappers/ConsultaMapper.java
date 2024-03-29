package projeto.labmedicalbackend.services.mappers;

import org.mapstruct.*;
import projeto.labmedicalbackend.controllers.dtos.consulta.RequestAtualizarConsultaDTO;
import projeto.labmedicalbackend.controllers.dtos.consulta.RequestCriarConsultaDTO;
import projeto.labmedicalbackend.controllers.dtos.consulta.ResponseBuscarConsultaDTO;
import projeto.labmedicalbackend.models.Consulta;
import projeto.labmedicalbackend.models.Paciente;
import projeto.labmedicalbackend.models.Usuario;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {Paciente.class, Usuario.class})
public interface ConsultaMapper {
    Consulta map(RequestCriarConsultaDTO source);

    ResponseBuscarConsultaDTO map(Consulta source);

    void update(@MappingTarget Consulta target, RequestAtualizarConsultaDTO source);
}
