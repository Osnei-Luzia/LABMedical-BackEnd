package projeto.labmedicalbackend.services.mappers;

import org.mapstruct.*;
import projeto.labmedicalbackend.controllers.dtos.paciente.RequestAtualizarPacienteDTO;
import projeto.labmedicalbackend.controllers.dtos.paciente.RequestCriarPacienteDTO;
import projeto.labmedicalbackend.controllers.dtos.paciente.ResponseBuscarPacienteDTO;
import projeto.labmedicalbackend.models.Paciente;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING , unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PacienteMapper {
    Paciente map(RequestCriarPacienteDTO source);

    ResponseBuscarPacienteDTO map(Paciente source);

    void update(@MappingTarget Paciente target, RequestAtualizarPacienteDTO source);
}
